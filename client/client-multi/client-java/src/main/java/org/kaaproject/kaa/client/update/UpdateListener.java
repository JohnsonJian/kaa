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

package org.kaaproject.kaa.client.update;

import java.io.IOException;

import org.kaaproject.kaa.common.endpoint.gen.SyncResponse;

/**
 * Listener of configuration delta updates from the endpoint server.
 *
 * @author Yaroslav Zeygerman
 *
 */
public interface UpdateListener {

    /**
     * Will be called on each received configuration delta.
     *
     * @param response sync response from the server.
     *
     */
    void onDeltaUpdate(SyncResponse response) throws IOException;

}
