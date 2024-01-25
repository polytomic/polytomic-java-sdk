
package com.polytomic.api.resources.connections.requests;

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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = V2CreateConnectionRequestSchema.Builder.class)
public final class V2CreateConnectionRequestSchema {
    private final Optional<Map<String, Object>> configuration;

    private final String name;

    private final Optional<String> organizationId;

    private final Optional<List<String>> policies;

    private final Optional<String> redirectUrl;

    private final String type;

    private final Optional<Boolean> validate;

    private final Map<String, Object> additionalProperties;

    private V2CreateConnectionRequestSchema(
            Optional<Map<String, Object>> configuration,
            String name,
            Optional<String> organizationId,
            Optional<List<String>> policies,
            Optional<String> redirectUrl,
            String type,
            Optional<Boolean> validate,
            Map<String, Object> additionalProperties) {
        this.configuration = configuration;
        this.name = name;
        this.organizationId = organizationId;
        this.policies = policies;
        this.redirectUrl = redirectUrl;
        this.type = type;
        this.validate = validate;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("configuration")
    public Optional<Map<String, Object>> getConfiguration() {
        return configuration;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("organization_id")
    public Optional<String> getOrganizationId() {
        return organizationId;
    }

    @JsonProperty("policies")
    public Optional<List<String>> getPolicies() {
        return policies;
    }

    /**
     * @return URL to redirect to after completing OAuth flow.
     */
    @JsonProperty("redirect_url")
    public Optional<String> getRedirectUrl() {
        return redirectUrl;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * @return Validate connection configuration.
     */
    @JsonProperty("validate")
    public Optional<Boolean> getValidate() {
        return validate;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2CreateConnectionRequestSchema && equalTo((V2CreateConnectionRequestSchema) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2CreateConnectionRequestSchema other) {
        return configuration.equals(other.configuration)
                && name.equals(other.name)
                && organizationId.equals(other.organizationId)
                && policies.equals(other.policies)
                && redirectUrl.equals(other.redirectUrl)
                && type.equals(other.type)
                && validate.equals(other.validate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.configuration,
                this.name,
                this.organizationId,
                this.policies,
                this.redirectUrl,
                this.type,
                this.validate);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        TypeStage name(String name);

        Builder from(V2CreateConnectionRequestSchema other);
    }

    public interface TypeStage {
        _FinalStage type(String type);
    }

    public interface _FinalStage {
        V2CreateConnectionRequestSchema build();

        _FinalStage configuration(Optional<Map<String, Object>> configuration);

        _FinalStage configuration(Map<String, Object> configuration);

        _FinalStage organizationId(Optional<String> organizationId);

        _FinalStage organizationId(String organizationId);

        _FinalStage policies(Optional<List<String>> policies);

        _FinalStage policies(List<String> policies);

        _FinalStage redirectUrl(Optional<String> redirectUrl);

        _FinalStage redirectUrl(String redirectUrl);

        _FinalStage validate(Optional<Boolean> validate);

        _FinalStage validate(Boolean validate);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, TypeStage, _FinalStage {
        private String name;

        private String type;

        private Optional<Boolean> validate = Optional.empty();

        private Optional<String> redirectUrl = Optional.empty();

        private Optional<List<String>> policies = Optional.empty();

        private Optional<String> organizationId = Optional.empty();

        private Optional<Map<String, Object>> configuration = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(V2CreateConnectionRequestSchema other) {
            configuration(other.getConfiguration());
            name(other.getName());
            organizationId(other.getOrganizationId());
            policies(other.getPolicies());
            redirectUrl(other.getRedirectUrl());
            type(other.getType());
            validate(other.getValidate());
            return this;
        }

        @Override
        @JsonSetter("name")
        public TypeStage name(String name) {
            this.name = name;
            return this;
        }

        @Override
        @JsonSetter("type")
        public _FinalStage type(String type) {
            this.type = type;
            return this;
        }

        /**
         * <p>Validate connection configuration.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage validate(Boolean validate) {
            this.validate = Optional.of(validate);
            return this;
        }

        @Override
        @JsonSetter(value = "validate", nulls = Nulls.SKIP)
        public _FinalStage validate(Optional<Boolean> validate) {
            this.validate = validate;
            return this;
        }

        /**
         * <p>URL to redirect to after completing OAuth flow.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage redirectUrl(String redirectUrl) {
            this.redirectUrl = Optional.of(redirectUrl);
            return this;
        }

        @Override
        @JsonSetter(value = "redirect_url", nulls = Nulls.SKIP)
        public _FinalStage redirectUrl(Optional<String> redirectUrl) {
            this.redirectUrl = redirectUrl;
            return this;
        }

        @Override
        public _FinalStage policies(List<String> policies) {
            this.policies = Optional.of(policies);
            return this;
        }

        @Override
        @JsonSetter(value = "policies", nulls = Nulls.SKIP)
        public _FinalStage policies(Optional<List<String>> policies) {
            this.policies = policies;
            return this;
        }

        @Override
        public _FinalStage organizationId(String organizationId) {
            this.organizationId = Optional.of(organizationId);
            return this;
        }

        @Override
        @JsonSetter(value = "organization_id", nulls = Nulls.SKIP)
        public _FinalStage organizationId(Optional<String> organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        @Override
        public _FinalStage configuration(Map<String, Object> configuration) {
            this.configuration = Optional.of(configuration);
            return this;
        }

        @Override
        @JsonSetter(value = "configuration", nulls = Nulls.SKIP)
        public _FinalStage configuration(Optional<Map<String, Object>> configuration) {
            this.configuration = configuration;
            return this;
        }

        @Override
        public V2CreateConnectionRequestSchema build() {
            return new V2CreateConnectionRequestSchema(
                    configuration, name, organizationId, policies, redirectUrl, type, validate, additionalProperties);
        }
    }
}
