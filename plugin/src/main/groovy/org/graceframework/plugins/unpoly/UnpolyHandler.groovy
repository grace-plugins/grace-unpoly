/*
 * Copyright 2024-2026 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.graceframework.plugins.unpoly

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import groovy.transform.CompileStatic

/**
 * Delegator to {@link UnpolyRequest} and {@link UnpolyResponse}.
 *
 * @author Michael Yan
 * @since 0.5
 */
@CompileStatic
class UnpolyHandler {

    @Delegate
    UnpolyRequest request

    @Delegate
    UnpolyResponse response

    UnpolyHandler(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        this.request = new UnpolyRequest(servletRequest)
        this.response = new UnpolyResponse(servletResponse)
    }

    boolean asBoolean() {
        this.request.asBoolean()
    }

}
