
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
@JsonDeserialize(builder = SchemaAssociation.Builder.class)
public final class SchemaAssociation {
    private final Optional<String> id;

    private final Optional<String> name;

    private final Optional<List<String>> referenceTo;

    private final Optional<String> referencedField;

    private final Map<String, Object> additionalProperties;

    private SchemaAssociation(
            Optional<String> id,
            Optional<String> name,
            Optional<List<String>> referenceTo,
            Optional<String> referencedField,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.name = name;
        this.referenceTo = referenceTo;
        this.referencedField = referencedField;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    @JsonProperty("reference_to")
    public Optional<List<String>> getReferenceTo() {
        return referenceTo;
    }

    @JsonProperty("referenced_field")
    public Optional<String> getReferencedField() {
        return referencedField;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SchemaAssociation && equalTo((SchemaAssociation) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SchemaAssociation other) {
        return id.equals(other.id)
                && name.equals(other.name)
                && referenceTo.equals(other.referenceTo)
                && referencedField.equals(other.referencedField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.referenceTo, this.referencedField);
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
        private Optional<String> id = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<List<String>> referenceTo = Optional.empty();

        private Optional<String> referencedField = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(SchemaAssociation other) {
            id(other.getId());
            name(other.getName());
            referenceTo(other.getReferenceTo());
            referencedField(other.getReferencedField());
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

        @JsonSetter(value = "reference_to", nulls = Nulls.SKIP)
        public Builder referenceTo(Optional<List<String>> referenceTo) {
            this.referenceTo = referenceTo;
            return this;
        }

        public Builder referenceTo(List<String> referenceTo) {
            this.referenceTo = Optional.of(referenceTo);
            return this;
        }

        @JsonSetter(value = "referenced_field", nulls = Nulls.SKIP)
        public Builder referencedField(Optional<String> referencedField) {
            this.referencedField = referencedField;
            return this;
        }

        public Builder referencedField(String referencedField) {
            this.referencedField = Optional.of(referencedField);
            return this;
        }

        public SchemaAssociation build() {
            return new SchemaAssociation(id, name, referenceTo, referencedField, additionalProperties);
        }
    }
}
