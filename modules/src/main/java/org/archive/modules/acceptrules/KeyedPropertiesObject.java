/*
 *  This file is part of the Heritrix web crawler (crawler.archive.org).
 *
 *  Licensed to the Internet Archive (IA) by one or more individual 
 *  contributors. 
 *
 *  The IA licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.archive.modules.acceptrules;

import org.archive.spring.HasKeyedProperties;
import org.archive.spring.KeyedProperties;

/**
 * Base implementation for an {@link Object} that would want to implements
 * {@link HasKeyedProperties}.
 * 
 * @author Bertrand Dechoux
 */
public abstract class KeyedPropertiesObject implements HasKeyedProperties {
    private static final long serialVersionUID = 1L;

    protected KeyedProperties kp = new KeyedProperties();

    public final KeyedProperties getKeyedProperties() {
        return kp;
    }

}
