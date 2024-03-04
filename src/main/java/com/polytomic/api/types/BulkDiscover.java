/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.polytomic.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BulkDiscover {
    ALL("all"),

    ONLY_INCREMENTAL("onlyIncremental"),

    ONLY_NON_INCREMENTAL("onlyNonIncremental"),

    NONE("none");

    private final String value;

    BulkDiscover(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}
