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

package org.kaaproject.kaa.server.operations.service.delta.merge;

import org.junit.Assert;
import org.junit.Test;
import org.kaaproject.kaa.server.operations.service.delta.merge.ArrayMergeStrategy;

public class ArrayMergeStrategyTest {

    @Test
    public void testGetByNameSuccessForCorrectName() {
        ArrayMergeStrategy arrayMergeStrategy = ArrayMergeStrategy.getByName(ArrayMergeStrategy.APPEND.getName());
        Assert.assertTrue(ArrayMergeStrategy.APPEND == arrayMergeStrategy);
    }

    @Test
    public void testGetByNameFailsForIncorrectName() {
        ArrayMergeStrategy arrayMergeStrategy = ArrayMergeStrategy.getByName("incorrect_name");
        Assert.assertNull(arrayMergeStrategy);
    }
}
