/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.polytomic.api;

import com.polytomic.api.core.ClientOptions;
import com.polytomic.api.core.Environment;

public final class PolytomicBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private String token = null;

    private String polytomicVersion = null;

    private Environment environment = Environment.DEFAULT;

    /**
     * Sets token
     */
    public PolytomicBuilder token(String token) {
        this.token = token;
        return this;
    }

    /**
     * Sets polytomicVersion
     */
    public PolytomicBuilder polytomicVersion(String polytomicVersion) {
        this.polytomicVersion = polytomicVersion;
        return this;
    }

    public PolytomicBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public PolytomicBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    public Polytomic build() {
        this.clientOptionsBuilder.addHeader("Authorization", "Bearer " + this.token);
        this.clientOptionsBuilder.addHeader("X-Polytomic-Version", this.polytomicVersion);
        clientOptionsBuilder.environment(this.environment);
        return new Polytomic(clientOptionsBuilder.build());
    }
}
