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

package org.kaaproject.kaa.server.operations.service.akka.messages.core.endpoint;

import org.kaaproject.kaa.common.endpoint.gen.SyncResponse;
import org.kaaproject.kaa.common.hash.EndpointObjectHash;
import org.kaaproject.kaa.server.operations.pojo.exceptions.GetDeltaException;


/**
 * The Class SyncResponseMessage.
 */
public class SyncResponseMessage extends EndpointAwareMessage {

    /** The response. */
    private final SyncResponse response;

    /** The exception. */
    private final GetDeltaException exception;
    
    /** The sync time. */
    private final long syncTime;

    /**
     * Instantiates a new sync response message.
     * 
     * @param appToken
     *            the app token
     * @param key
     *            the key
     * @param response
     *            the response
     * @param exception
     *            the exception
     */
    public SyncResponseMessage(String appToken, EndpointObjectHash key, SyncResponse response, GetDeltaException exception) {
        this(appToken, key, response, exception, 0L);
    }    
    
    /**
     * Instantiates a new sync response message.
     * 
     * @param appToken
     *            the app token
     * @param key
     *            the key
     * @param response
     *            the response
     * @param exception
     *            the exception
     */
    public SyncResponseMessage(String appToken, EndpointObjectHash key, SyncResponse response, GetDeltaException exception, long syncTime) {
        super(appToken, key, null);
        this.response = response;
        this.exception = exception;
        this.syncTime = syncTime;
    }

    /**
     * Gets the response.
     * 
     * @return the response
     */
    public SyncResponse getResponse() {
        return response;
    }

    /**
     * Gets the exception.
     * 
     * @return the exception
     */
    public GetDeltaException getException() {
        return exception;
    }

    /**
     * Gets the sync time.
     * 
     * @return the syncTime
     */
    public long getSyncTime() {
        return syncTime;
    }
    
    
}
