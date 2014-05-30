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

package org.kaaproject.kaa.server.common.dao;


import java.util.List;

import org.kaaproject.kaa.common.dto.EndpointConfigurationDto;
import org.kaaproject.kaa.common.dto.EndpointGroupDto;
import org.kaaproject.kaa.common.dto.EndpointProfileDto;
import org.kaaproject.kaa.common.dto.UpdateNotificationDto;

/**
 * The interface Endpoint service.
 */
public interface EndpointService {

    /**
     * Find endpoint groups by application id.
     *
     * @param applicationId the application id
     * @return the list
     */
    List<EndpointGroupDto> findEndpointGroupsByAppId(String applicationId);

    /**
     * Find endpoint group by id.
     *
     * @param id the id
     * @return the endpoint group dto
     */
    EndpointGroupDto findEndpointGroupById(String id);

    /**
     * Remove endpoint group by application id.
     *
     * @param applicationId the application id
     */
    void removeEndpointGroupByAppId(String applicationId);

    /**
     * Remove endpoint group by id.
     *
     * @param applicationId the application id
     */
    void removeEndpointGroupById(String applicationId);

    /**
     * Save endpoint group. Can't save endpoint group with same weight or
     * update weight for default group. Application id and group weight is unique
     *
     * @param endpointGroupDto the endpoint group dto
     * @return the endpoint group dto
     */
    EndpointGroupDto saveEndpointGroup(EndpointGroupDto endpointGroupDto);


    /**
     * Removes the topic id from endpoint group.
     *
     * @param id the id
     * @param topicId the topic id
     * @return the update notification dto
     */
    UpdateNotificationDto<EndpointGroupDto> removeTopicFromEndpointGroup(String id, String topicId);

    /**
     * Add topic id to endpoint group.
     *
     * @param id the id
     * @param topicId the topic id
     * @return the update notification dto
     */
    UpdateNotificationDto<EndpointGroupDto> addTopicToEndpointGroup(String id, String topicId);

    /**
     * Find endpoint configuration by hash.
     *
     * @param hash the hash
     * @return the endpoint configuration dto
     */
    EndpointConfigurationDto findEndpointConfigurationByHash(byte[] hash);

    /**
     * Save endpoint configuration.
     *
     * @param endpointConfigurationDto the endpoint configuration dto
     * @return the endpoint configuration dto
     */
    EndpointConfigurationDto saveEndpointConfiguration(EndpointConfigurationDto endpointConfigurationDto);

    /**
     * Find endpoint profile by key hash.
     *
     * @param endpointProfileKeyHash the endpoint profile key hash
     * @return the endpoint profile dto
     */
    EndpointProfileDto findEndpointProfileByKeyHash(byte[] endpointProfileKeyHash);

    /**
     * Remove endpoint profile by key hash.
     *
     * @param endpointProfileKeyHash the endpoint profile key hash
     */
    void removeEndpointProfileByKeyHash(byte[] endpointProfileKeyHash);

    /**
     * Remove endpoint profile by application id.
     * @param appId application id
     */
    void removeEndpointProfileByAppId(String appId);

    /**
     * Save endpoint profile.
     *
     * @param endpointProfileDto the endpoint profile dto
     * @return the endpoint profile dto
     */
    EndpointProfileDto saveEndpointProfile(EndpointProfileDto endpointProfileDto);
}
