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

package org.kaaproject.kaa.client.schema;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.apache.avro.Schema;

/**
 * Receives the data from stream and creates a schema object.
 *
 * @author Yaroslav Zeygerman
 *
 */
public interface SchemaProcessor {

    /**
     * Loads new schema from the buffer.
     *
     * @param buffer schema buffer.
     *
     */
    void loadSchema(ByteBuffer buffer) throws IOException;

    /**
     * Retrieves current schema object.
     *
     * @return current schema.
     *
     */
    Schema getSchema();
}
