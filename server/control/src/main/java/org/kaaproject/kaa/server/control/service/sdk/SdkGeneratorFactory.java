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

package org.kaaproject.kaa.server.control.service.sdk;

import org.kaaproject.kaa.server.common.thrift.gen.control.SdkPlatform;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating SdkGenerator objects.
 */
public class SdkGeneratorFactory {

    /**
     * Creates a new SdkGenerator object.
     *
     * @param sdkPlatform the sdk platform
     * @return the sdk generator
     */
    public static SdkGenerator createSdkGenerator(SdkPlatform sdkPlatform) {
        switch (sdkPlatform) {
        case JAVA:
            return new JavaSdkGenerator();
        default:
            return null;
        }
    }

}
