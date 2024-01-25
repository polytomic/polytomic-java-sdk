
package com.polytomic.api.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.polytomic.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = V2Source.Builder.class)
public final class V2Source {
    private final String field;

    private final String modelId;

    private final Map<String, Object> additionalProperties;

    private V2Source(String field, String modelId, Map<String, Object> additionalProperties) {
        this.field = field;
        this.modelId = modelId;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("field")
    public String getField() {
        return field;
    }

    @JsonProperty("model_id")
    public String getModelId() {
        return modelId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2Source && equalTo((V2Source) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2Source other) {
        return field.equals(other.field) && modelId.equals(other.modelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.field, this.modelId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static FieldStage builder() {
        return new Builder();
    }

    public interface FieldStage {
        ModelIdStage field(String field);

        Builder from(V2Source other);
    }

    public interface ModelIdStage {
        _FinalStage modelId(String modelId);
    }

    public interface _FinalStage {
        V2Source build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements FieldStage, ModelIdStage, _FinalStage {
        private String field;

        private String modelId;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(V2Source other) {
            field(other.getField());
            modelId(other.getModelId());
            return this;
        }

        @Override
        @JsonSetter("field")
        public ModelIdStage field(String field) {
            this.field = field;
            return this;
        }

        @Override
        @JsonSetter("model_id")
        public _FinalStage modelId(String modelId) {
            this.modelId = modelId;
            return this;
        }

        @Override
        public V2Source build() {
            return new V2Source(field, modelId, additionalProperties);
        }
    }
}
