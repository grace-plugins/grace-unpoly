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

import javax.servlet.http.HttpServletResponse

import groovy.transform.CompileStatic

import static org.graceframework.plugins.unpoly.UnpolyRequest.*

/**
 * Unpoly Response {link https://unpoly.com/up.protocol}
 *
 * @author Michael Yan
 * @since 0.0.1
 */
@CompileStatic
class UnpolyResponse {

    private final HttpServletResponse response

    UnpolyResponse(HttpServletResponse response) {
        this.response = response
    }

    /**
     * The server may set this response header to accept the targeted overlay in response to a fragment update.
     *
     * @param acceptLayer
     */
    void setAcceptLayer(String acceptLayer) {
        setHeaderValue(UP_ACCEPT_LAYER, acceptLayer)
    }

    /**
     * The server may set this response header to dismiss the targeted overlay in response to a fragment update.
     *
     * @param dismissLayer
     */
    void setDismissLayer(String dismissLayer) {
        setHeaderValue(UP_DISMISS_LAYER, dismissLayer)
    }

    /**
     * The server may set this response header to emit events with the requested fragment update.
     *
     * @param events
     */
    void setEvents(String events) {
        setHeaderValue(UP_EVENTS, events)
    }

    /**
     * The server may send this optional response header to control which previously cached responses should be evicted after this response.
     * The value of this header is a URL pattern matching responses that should be evicted.
     *
     * @param evictCache
     */
    void setEvictCache(String evictCache) {
        setHeaderValue(UP_EVICT_CACHE, evictCache)
    }

    /**
     * The server may send this optional response header to control which previously cached responses should be expired after this response.
     * The value of this header is a URL pattern matching responses that should be expired.
     *
     * @param expireCache
     */
    void setExpireCache(String expireCache) {
        setHeaderValue(UP_EXPIRE_CACHE, expireCache)
    }

    /**
     * The server may set this response header to set a custom browser location after a fragment update.
     * Without an X-Up-Location header Unpoly will set the browser location to the requested URL.
     */
    void setLocation(String location) {
        setHeaderValue(UP_LOCATION, location)
    }

    /**
     * This request header contains the target selector for a successful fragment update.
     */
    void setTarget(String target) {
        setHeaderValue(UP_TARGET, target)
    }

    /**
     * Set header value for response
     * @param The name of header
     * @return value
     */
    void setHeaderValue(String name, Object value) {
        this.response.setHeader(name, (value == null) ? "" : value.toString())
    }

}
