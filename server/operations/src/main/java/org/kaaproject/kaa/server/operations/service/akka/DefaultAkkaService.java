/*
 * Copyright 2014 CyberVision, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kaaproject.kaa.server.operations.service.akka;

import javax.annotation.PostConstruct;

import org.kaaproject.kaa.common.dto.ApplicationDto;
import org.kaaproject.kaa.server.common.dao.ApplicationService;
import org.kaaproject.kaa.server.common.thrift.gen.operations.Notification;
import org.kaaproject.kaa.server.common.thrift.gen.operations.RedirectionRule;
import org.kaaproject.kaa.server.operations.service.OperationsService;
import org.kaaproject.kaa.server.operations.service.akka.actors.core.OperationsServerActor;
import org.kaaproject.kaa.server.operations.service.akka.actors.io.EncDecActor;
import org.kaaproject.kaa.server.operations.service.akka.messages.core.notification.ThriftNotificationMessage;
import org.kaaproject.kaa.server.operations.service.akka.messages.io.NettyCommandAwareMessage;
import org.kaaproject.kaa.server.operations.service.notification.NotificationDeltaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.Broadcast;
import akka.routing.RoundRobinPool;


/**
 * The Class DefaultAkkaService.
 */
@Service
public class DefaultAkkaService implements AkkaService {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory
            .getLogger(DefaultAkkaService.class);

    /** The Constant EPS. */
    public static final String EPS = "EPS";
    // TODO: make configurable;
    /** The Constant IO_WORKERS_COUNT. */
    private static final int IO_WORKERS_COUNT = 4;
    
    /** The akka. */
    private ActorSystem akka;
    
    /** The eps actor. */
    private ActorRef opsActor;
    
    /** The io router. */
    private ActorRef ioRouter;

    /** The operations service. */
    @Autowired
    private OperationsService operationsService;
    
    /** The notification delta service. */
    @Autowired
    private NotificationDeltaService notificationDeltaService;
    
    /** The application service. */
    @Autowired
    private ApplicationService applicationService;

    /**
     * Inits the actor system.
     */
    @PostConstruct
    public void initActorSystem() {
        LOG.info("Initializing Akka system..");
        akka = ActorSystem.create(EPS);
        LOG.info("Initializing Akka EPS actor..");
        opsActor = akka.actorOf(Props
                .create(new OperationsServerActor.ActorCreator(operationsService,
                        notificationDeltaService)), EPS);
        LOG.info("Initializing Akka io router..");
        ioRouter = akka.actorOf(new RoundRobinPool(IO_WORKERS_COUNT)
                .props(Props.create(new EncDecActor.ActorCreator(opsActor))),
                "ioRouter");
        LOG.info("Initializing Akka system done");
    }

    /* (non-Javadoc)
     * @see org.kaaproject.kaa.server.operations.service.akka.AkkaService#getActorSystem()
     */
    @Override
    public ActorSystem getActorSystem() {
        return akka;
    }

    /*
     * (non-Javadoc)
     * @see org.kaaproject.kaa.server.operations.service.akka.AkkaService#onRedirectionRule(org.kaaproject.kaa.server.common.thrift.gen.endpoint.RedirectionRule)
     */
    @Override
    public void onRedirectionRule(RedirectionRule redirectionRule) {
        ioRouter.tell(new Broadcast(redirectionRule), ActorRef.noSender());
    }

    /* (non-Javadoc)
     * @see org.kaaproject.kaa.server.operations.service.akka.AkkaService#onNotification(org.kaaproject.kaa.server.common.thrift.gen.endpoint.Notification)
     */
    @Override
    public void onNotification(Notification notification) {
        ApplicationDto applicationDto = applicationService
                .findAppById(notification.getAppId());
        if (applicationDto != null) {
            LOG.debug("Sending message {} to EPS actor", notification);
            opsActor.tell(
                    new ThriftNotificationMessage(applicationDto
                            .getApplicationToken(), notification), ActorRef
                            .noSender());
        } else {
            LOG.warn("Can't find corresponding application for: {}",
                    notification);
        }
    }

    @Override
    public void process(NettyCommandAwareMessage message) {
        ioRouter.tell(message, ActorRef.noSender());
    }
}
