
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
@JsonDeserialize(builder = V3Schema.Builder.class)
public final class V3Schema {
    private final Optional<List<V3SchemaField>> fields;

    private final Optional<String> id;

    private final Optional<String> name;

    private final Map<String, Object> additionalProperties;

    private V3Schema(
            Optional<List<V3SchemaField>> fields,
            Optional<String> id,
            Optional<String> name,
            Map<String, Object> additionalProperties) {
        this.fields = fields;
        this.id = id;
        this.name = name;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("fields")
    public Optional<List<V3SchemaField>> getFields() {
        return fields;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V3Schema && equalTo((V3Schema) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V3Schema other) {
        return fields.equals(other.fields) && id.equals(other.id) && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fields, this.id, this.name);
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
        private Optional<List<V3SchemaField>> fields = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<String> name = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V3Schema other) {
            fields(other.getFields());
            id(other.getId());
            name(other.getName());
            return this;
        }

        @JsonSetter(value = "fields", nulls = Nulls.SKIP)
        public Builder fields(Optional<List<V3SchemaField>> fields) {
            this.fields = fields;
            return this;
        }

        public Builder fields(List<V3SchemaField> fields) {
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

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        public V3Schema build() {
            return new V3Schema(fields, id, name, additionalProperties);
        }
    }
}
