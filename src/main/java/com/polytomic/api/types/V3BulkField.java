
package com.polytomic.api.types;

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
@JsonDeserialize(builder = V3BulkField.Builder.class)
public final class V3BulkField {
    private final Optional<Boolean> enabled;

    private final Optional<String> id;

    private final Optional<Boolean> obfuscated;

    private final Map<String, Object> additionalProperties;

    private V3BulkField(
            Optional<Boolean> enabled,
            Optional<String> id,
            Optional<Boolean> obfuscated,
            Map<String, Object> additionalProperties) {
        this.enabled = enabled;
        this.id = id;
        this.obfuscated = obfuscated;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("enabled")
    public Optional<Boolean> getEnabled() {
        return enabled;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("obfuscated")
    public Optional<Boolean> getObfuscated() {
        return obfuscated;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V3BulkField && equalTo((V3BulkField) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V3BulkField other) {
        return enabled.equals(other.enabled) && id.equals(other.id) && obfuscated.equals(other.obfuscated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.enabled, this.id, this.obfuscated);
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
        private Optional<Boolean> enabled = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<Boolean> obfuscated = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V3BulkField other) {
            enabled(other.getEnabled());
            id(other.getId());
            obfuscated(other.getObfuscated());
            return this;
        }

        @JsonSetter(value = "enabled", nulls = Nulls.SKIP)
        public Builder enabled(Optional<Boolean> enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder enabled(Boolean enabled) {
            this.enabled = Optional.of(enabled);
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        @JsonSetter(value = "obfuscated", nulls = Nulls.SKIP)
        public Builder obfuscated(Optional<Boolean> obfuscated) {
            this.obfuscated = obfuscated;
            return this;
        }

        public Builder obfuscated(Boolean obfuscated) {
            this.obfuscated = Optional.of(obfuscated);
            return this;
        }

        public V3BulkField build() {
            return new V3BulkField(enabled, id, obfuscated, additionalProperties);
        }
    }
}
