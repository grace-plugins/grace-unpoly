/*
 * Copyright 2024 the original author or authors.
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

import groovy.transform.CompileStatic

/**
 * Unpoly Request {link https://unpoly.com/up.protocol}
 *
 * @author Michael Yan
 * @since 0.0.1
 */
@CompileStatic
class UnpolyRequest {

    public static final String UP_ACCEPT_LAYER = 'X-Up-Accept-Layer'
    public static final String UP_DISMISS_LAYER = 'X-Up-Dismiss-Layer'
    public static final String UP_EVENTS = 'X-Up-Events'
    public static final String UP_EVICT_CACHE = 'X-Up-Evict-Cache'
    public static final String UP_EXPIRE_CACHE = 'X-Up-Expire-Cache'
    public static final String UP_FAIL_MODE = 'X-Up-Fail-Mode'
    public static final String UP_FAIL_TARGET = 'X-Up-Fail-Target'
    public static final String UP_LOCATION = 'X-Up-Location'
    public static final String UP_METHOD = 'X-Up-Method'
    public static final String UP_MODE = 'X-Up-Mode'
    public static final String UP_TARGET = 'X-Up-Target'
    public static final String UP_TITLE = 'X-Up-Title'
    public static final String UP_VALIDATE = 'X-Up-Validate'
    public static final String UP_VERSION = 'X-Up-Version'

    private final HttpServletRequest request

    UnpolyRequest(HttpServletRequest request) {
        this.request = request
    }

    /**
     * This request header contains the mode of the layer targeted for a failed fragment update.
     * A fragment update is considered failed if the server responds with a status code other than 2xx, but still renders HTML.
     */
    String getFailMode() {
        getHeaderValue(UP_FAIL_MODE)
    }

    /**
     * This request header contains the target selector for a failed fragment update.
     * A fragment update is considered failed if the server responds with a status code other than 2xx, but still renders HTML.
     */
    String getFailTarget() {
        getHeaderValue(UP_FAIL_TARGET)
    }

    /**
     * The server may set this response header to set a custom browser location after a fragment update.
     * Without an X-Up-Location header Unpoly will set the browser location to the requested URL.
     */
    String getLocation() {
        getHeaderValue(UP_LOCATION)
    }

    /**
     * The server may set this optional response header to change the HTTP method after a fragment update.
     * Without this header Unpoly will use the requested method.
     */
    String getMethod() {
        getHeaderValue(UP_METHOD)
    }

    /**
     * This request header contains the targeted layer's mode.
     * Server-side code is free to render different HTML for different modes.
     */
    String getMode() {
        getHeaderValue(UP_MODE)
    }

    /**
     * This request header contains the target selector for a successful fragment update.
     */
    String getTarget() {
        getHeaderValue(UP_TARGET)
    }

    /**
     * The server may set this optional response header to change the document title after a fragment update.
     * The title must be encoded as a JSON string.
     */
    String getTitle() {
        getHeaderValue(UP_TITLE)
    }

    /**
     * This request header contains the names of the form fields being validated.
     */
    String getValidate() {
        getHeaderValue(UP_VALIDATE)
    }

    /**
     * This request header contains the current Unpoly version to mark this request as a fragment update.
     */
    String getVersion() {
        getHeaderValue(UP_VERSION)
    }

    /**
     * Get header value from request
     * @param The name of header
     * @return value
     */
    String getHeaderValue(String name) {
        this.request.getHeader(name)
    }

    boolean asBoolean() {
        getTarget() || getVersion()
    }

}
