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

import io.jenkins.functions.runtime.FunctionContext;
import io.jenkins.functions.runtime.StepFunction;
import io.jenkins.functions.runtime.StepFunctions;
import org.junit.Before;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 */
public class StepTestSupport {
    protected Map<String, StepFunction> functionMap;
    protected FunctionContext functionContext = new FunctionContext();

    @Before
    public void init() throws Exception {
        functionMap = StepFunctions.loadStepFunctions(MavenPipelineStep.class.getClassLoader());
        assertThat(functionMap).isNotNull();
    }

    public StepFunction assertFunctionExists(String functionName) {
        StepFunction function = functionMap.get(functionName);
        assertThat(function).describedAs("No function found for nane " + functionName).isNotNull();
        return function;
    }
}
