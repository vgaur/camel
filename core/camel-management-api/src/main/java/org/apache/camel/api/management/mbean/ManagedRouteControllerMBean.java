/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.api.management.mbean;

import java.util.Collection;

import org.apache.camel.api.management.ManagedAttribute;

public interface ManagedRouteControllerMBean extends ManagedServiceMBean {

    @ManagedAttribute(description = "Indicates whether the route controller is doing initial starting of the routes.")
    boolean isStartingRoutes();

    @ManagedAttribute(description = "Indicates if the route controller has routes that are currently unhealthy")
    boolean isHasUnhealthyRoutes();

    @ManagedAttribute(description = "Controlled Routes")
    Collection<String> getControlledRoutes();

    @ManagedAttribute(description = "Logging level used for logging route startup activity")
    String getRouteStartupLoggingLevel();
}
