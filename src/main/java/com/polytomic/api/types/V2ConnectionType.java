
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
@JsonDeserialize(builder = V2ConnectionType.Builder.class)
public final class V2ConnectionType {
    private final Optional<Map<String, Object>> envConfig;

    private final Optional<String> id;

    private final Optional<String> name;

    private final Optional<Boolean> useOauth;

    private final Map<String, Object> additionalProperties;

    private V2ConnectionType(
            Optional<Map<String, Object>> envConfig,
            Optional<String> id,
            Optional<String> name,
            Optional<Boolean> useOauth,
            Map<String, Object> additionalProperties) {
        this.envConfig = envConfig;
        this.id = id;
        this.name = name;
        this.useOauth = useOauth;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("envConfig")
    public Optional<Map<String, Object>> getEnvConfig() {
        return envConfig;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    @JsonProperty("use_oauth")
    public Optional<Boolean> getUseOauth() {
        return useOauth;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2ConnectionType && equalTo((V2ConnectionType) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2ConnectionType other) {
        return envConfig.equals(other.envConfig)
                && id.equals(other.id)
                && name.equals(other.name)
                && useOauth.equals(other.useOauth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.envConfig, this.id, this.name, this.useOauth);
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
        private Optional<Map<String, Object>> envConfig = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<Boolean> useOauth = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2ConnectionType other) {
            envConfig(other.getEnvConfig());
            id(other.getId());
            name(other.getName());
            useOauth(other.getUseOauth());
            return this;
        }

        @JsonSetter(value = "envConfig", nulls = Nulls.SKIP)
        public Builder envConfig(Optional<Map<String, Object>> envConfig) {
            this.envConfig = envConfig;
            return this;
        }

        public Builder envConfig(Map<String, Object> envConfig) {
            this.envConfig = Optional.of(envConfig);
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

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @JsonSetter(value = "use_oauth", nulls = Nulls.SKIP)
        public Builder useOauth(Optional<Boolean> useOauth) {
            this.useOauth = useOauth;
            return this;
        }

        public Builder useOauth(Boolean useOauth) {
            this.useOauth = Optional.of(useOauth);
            return this;
        }

        public V2ConnectionType build() {
            return new V2ConnectionType(envConfig, id, name, useOauth, additionalProperties);
        }
    }
}
