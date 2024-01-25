
package com.polytomic.api.resources.bulksync.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.polytomic.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = BulkSyncRemoveRequest.Builder.class)
public final class BulkSyncRemoveRequest {
    private final Optional<Boolean> refreshSchemas;

    private final Map<String, Object> additionalProperties;

    private BulkSyncRemoveRequest(Optional<Boolean> refreshSchemas, Map<String, Object> additionalProperties) {
        this.refreshSchemas = refreshSchemas;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("refresh_schemas")
    public Optional<Boolean> getRefreshSchemas() {
        return refreshSchemas;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BulkSyncRemoveRequest && equalTo((BulkSyncRemoveRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(BulkSyncRemoveRequest other) {
        return refreshSchemas.equals(other.refreshSchemas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.refreshSchemas);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Boolean> refreshSchemas = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(BulkSyncRemoveRequest other) {
            refreshSchemas(other.getRefreshSchemas());
            return this;
        }

        @JsonSetter(value = "refresh_schemas", nulls = Nulls.SKIP)
        public Builder refreshSchemas(Optional<Boolean> refreshSchemas) {
            this.refreshSchemas = refreshSchemas;
            return this;
        }

        public Builder refreshSchemas(Boolean refreshSchemas) {
            this.refreshSchemas = Optional.of(refreshSchemas);
            return this;
        }

        public BulkSyncRemoveRequest build() {
            return new BulkSyncRemoveRequest(refreshSchemas, additionalProperties);
        }
    }
}
