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
package org.apache.camel.dsl.jbang.core.commands;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import groovy.grape.Grape;
import groovy.lang.GroovyClassLoader;
import org.apache.camel.main.KameletMain;
import org.apache.camel.main.MavenGav;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "dependency-tree", description = "Displays the dependency tree")
@Deprecated
class DependencyTree implements Callable<Integer> {

    //CHECKSTYLE:OFF
    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Display the help and sub-commands")
    private boolean helpRequested = false;
    //CHECKSTYLE:ON

    @Override
    public Integer call() throws Exception {
        File file = new File(Run.DEPENDENCY_FILE);
        if (!file.exists()) {
            System.out.println("Run Camel first to generate dependency file");
            return 0;
        }

        ClassLoader parentCL = KameletMain.class.getClassLoader();
        final GroovyClassLoader gcl = new GroovyClassLoader(parentCL);
        final List<String> lines = Files.readAllLines(file.toPath());
        for (String l : lines) {
            MavenGav gav = MavenGav.parseGav(null, l);

            Map<String, Object> map = new HashMap<>();
            map.put("classLoader", gcl);
            map.put("group", gav.getGroupId());
            map.put("module", gav.getArtifactId());
            map.put("version", gav.getVersion());
            map.put("classifier", "");

            URI[] u = Grape.resolve(map, map);
            System.out.println(Arrays.asList(u));
        }

        return 0;
    }

}
