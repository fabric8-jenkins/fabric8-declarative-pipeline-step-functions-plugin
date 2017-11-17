/*
 * Copyright 2016 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package io.fabric8.pipeline.steps;

import io.jenkins.functions.runtime.ArgumentMetadata;
import io.jenkins.functions.runtime.FunctionContext;
import io.jenkins.functions.runtime.StepFunction;
import io.jenkins.functions.runtime.StepFunctions;
import io.jenkins.functions.runtime.StepMetadata;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 */
public class MavenPipelineStepTest extends StepTestSupport {

    @Test
    public void testStepClass() throws Exception {
        MavenPipelineStep step = new MavenPipelineStep();
        String containerName = step.getContainerName();
        System.out.println("containerName: " + containerName);
        assertThat(containerName).describedAs("containerName").isNotEmpty();
    }

    @Test
    public void testStep() throws Exception {
        StepFunction function = assertFunctionExists("mavenPipeline");

        Map<String, Object> defaultArguments = function.getArguments(new HashMap<>(), functionContext);
        System.out.println("Default arguments: " + defaultArguments);
        
        assertThat(defaultArguments).describedAs("Default arguments").isNotEmpty();
        assertThat(defaultArguments.get("containerName")).describedAs("defaultArguments.containerName").isEqualTo("maven");
    }

}
