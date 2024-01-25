
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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = V2ModelResponse.Builder.class)
public final class V2ModelResponse {
    private final Optional<Map<String, Object>> configuration;

    private final Optional<String> connectionId;

    private final Optional<List<V2ModelField>> fields;

    private final Optional<String> id;

    private final Optional<String> identifier;

    private final Optional<List<Map<String, Object>>> labels;

    private final Optional<String> name;

    private final Optional<String> organizationId;

    private final Optional<List<String>> policies;

    private final Optional<List<V2Relation>> relations;

    private final Optional<List<String>> trackingColumns;

    private final Optional<String> type;

    private final Optional<Integer> version;

    private final Map<String, Object> additionalProperties;

    private V2ModelResponse(
            Optional<Map<String, Object>> configuration,
            Optional<String> connectionId,
            Optional<List<V2ModelField>> fields,
            Optional<String> id,
            Optional<String> identifier,
            Optional<List<Map<String, Object>>> labels,
            Optional<String> name,
            Optional<String> organizationId,
            Optional<List<String>> policies,
            Optional<List<V2Relation>> relations,
            Optional<List<String>> trackingColumns,
            Optional<String> type,
            Optional<Integer> version,
            Map<String, Object> additionalProperties) {
        this.configuration = configuration;
        this.connectionId = connectionId;
        this.fields = fields;
        this.id = id;
        this.identifier = identifier;
        this.labels = labels;
        this.name = name;
        this.organizationId = organizationId;
        this.policies = policies;
        this.relations = relations;
        this.trackingColumns = trackingColumns;
        this.type = type;
        this.version = version;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("configuration")
    public Optional<Map<String, Object>> getConfiguration() {
        return configuration;
    }

    @JsonProperty("connection_id")
    public Optional<String> getConnectionId() {
        return connectionId;
    }

    @JsonProperty("fields")
    public Optional<List<V2ModelField>> getFields() {
        return fields;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("identifier")
    public Optional<String> getIdentifier() {
        return identifier;
    }

    @JsonProperty("labels")
    public Optional<List<Map<String, Object>>> getLabels() {
        return labels;
    }

    @JsonProperty("name")
    public Optional<String> getName() {
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

    @JsonProperty("relations")
    public Optional<List<V2Relation>> getRelations() {
        return relations;
    }

    @JsonProperty("tracking_columns")
    public Optional<List<String>> getTrackingColumns() {
        return trackingColumns;
    }

    @JsonProperty("type")
    public Optional<String> getType() {
        return type;
    }

    @JsonProperty("version")
    public Optional<Integer> getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2ModelResponse && equalTo((V2ModelResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2ModelResponse other) {
        return configuration.equals(other.configuration)
                && connectionId.equals(other.connectionId)
                && fields.equals(other.fields)
                && id.equals(other.id)
                && identifier.equals(other.identifier)
                && labels.equals(other.labels)
                && name.equals(other.name)
                && organizationId.equals(other.organizationId)
                && policies.equals(other.policies)
                && relations.equals(other.relations)
                && trackingColumns.equals(other.trackingColumns)
                && type.equals(other.type)
                && version.equals(other.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.configuration,
                this.connectionId,
                this.fields,
                this.id,
                this.identifier,
                this.labels,
                this.name,
                this.organizationId,
                this.policies,
                this.relations,
                this.trackingColumns,
                this.type,
                this.version);
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
        private Optional<Map<String, Object>> configuration = Optional.empty();

        private Optional<String> connectionId = Optional.empty();

        private Optional<List<V2ModelField>> fields = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<String> identifier = Optional.empty();

        private Optional<List<Map<String, Object>>> labels = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> organizationId = Optional.empty();

        private Optional<List<String>> policies = Optional.empty();

        private Optional<List<V2Relation>> relations = Optional.empty();

        private Optional<List<String>> trackingColumns = Optional.empty();

        private Optional<String> type = Optional.empty();

        private Optional<Integer> version = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2ModelResponse other) {
            configuration(other.getConfiguration());
            connectionId(other.getConnectionId());
            fields(other.getFields());
            id(other.getId());
            identifier(other.getIdentifier());
            labels(other.getLabels());
            name(other.getName());
            organizationId(other.getOrganizationId());
            policies(other.getPolicies());
            relations(other.getRelations());
            trackingColumns(other.getTrackingColumns());
            type(other.getType());
            version(other.getVersion());
            return this;
        }

        @JsonSetter(value = "configuration", nulls = Nulls.SKIP)
        public Builder configuration(Optional<Map<String, Object>> configuration) {
            this.configuration = configuration;
            return this;
        }

        public Builder configuration(Map<String, Object> configuration) {
            this.configuration = Optional.of(configuration);
            return this;
        }

        @JsonSetter(value = "connection_id", nulls = Nulls.SKIP)
        public Builder connectionId(Optional<String> connectionId) {
            this.connectionId = connectionId;
            return this;
        }

        public Builder connectionId(String connectionId) {
            this.connectionId = Optional.of(connectionId);
            return this;
        }

        @JsonSetter(value = "fields", nulls = Nulls.SKIP)
        public Builder fields(Optional<List<V2ModelField>> fields) {
            this.fields = fields;
            return this;
        }

        public Builder fields(List<V2ModelField> fields) {
            this.fields = Optional.of(fields);
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

        @JsonSetter(value = "identifier", nulls = Nulls.SKIP)
        public Builder identifier(Optional<String> identifier) {
            this.identifier = identifier;
            return this;
        }

        public Builder identifier(String identifier) {
            this.identifier = Optional.of(identifier);
            return this;
        }

        @JsonSetter(value = "labels", nulls = Nulls.SKIP)
        public Builder labels(Optional<List<Map<String, Object>>> labels) {
            this.labels = labels;
            return this;
        }

        public Builder labels(List<Map<String, Object>> labels) {
            this.labels = Optional.of(labels);
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

        @JsonSetter(value = "organization_id", nulls = Nulls.SKIP)
        public Builder organizationId(Optional<String> organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        public Builder organizationId(String organizationId) {
            this.organizationId = Optional.of(organizationId);
            return this;
        }

        @JsonSetter(value = "policies", nulls = Nulls.SKIP)
        public Builder policies(Optional<List<String>> policies) {
            this.policies = policies;
            return this;
        }

        public Builder policies(List<String> policies) {
            this.policies = Optional.of(policies);
            return this;
        }

        @JsonSetter(value = "relations", nulls = Nulls.SKIP)
        public Builder relations(Optional<List<V2Relation>> relations) {
            this.relations = relations;
            return this;
        }

        public Builder relations(List<V2Relation> relations) {
            this.relations = Optional.of(relations);
            return this;
        }

        @JsonSetter(value = "tracking_columns", nulls = Nulls.SKIP)
        public Builder trackingColumns(Optional<List<String>> trackingColumns) {
            this.trackingColumns = trackingColumns;
            return this;
        }

        public Builder trackingColumns(List<String> trackingColumns) {
            this.trackingColumns = Optional.of(trackingColumns);
            return this;
        }

        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<String> type) {
            this.type = type;
            return this;
        }

        public Builder type(String type) {
            this.type = Optional.of(type);
            return this;
        }

        @JsonSetter(value = "version", nulls = Nulls.SKIP)
        public Builder version(Optional<Integer> version) {
            this.version = version;
            return this;
        }

        public Builder version(Integer version) {
            this.version = Optional.of(version);
            return this;
        }

        public V2ModelResponse build() {
            return new V2ModelResponse(
                    configuration,
                    connectionId,
                    fields,
                    id,
                    identifier,
                    labels,
                    name,
                    organizationId,
                    policies,
                    relations,
                    trackingColumns,
                    type,
                    version,
                    additionalProperties);
        }
    }
}
