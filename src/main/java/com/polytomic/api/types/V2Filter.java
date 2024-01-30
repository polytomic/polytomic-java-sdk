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
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = V2Filter.Builder.class
)
public final class V2Filter {
  private final String fieldId;

  private final String fieldType;

  private final String function;

  private final Optional<String> label;

  private final Optional<Object> value;

  private final Map<String, Object> additionalProperties;

  private V2Filter(String fieldId, String fieldType, String function, Optional<String> label,
      Optional<Object> value, Map<String, Object> additionalProperties) {
    this.fieldId = fieldId;
    this.fieldType = fieldType;
    this.function = function;
    this.label = label;
    this.value = value;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("field_id")
  public String getFieldId() {
    return fieldId;
  }

  @JsonProperty("field_type")
  public String getFieldType() {
    return fieldType;
  }

  @JsonProperty("function")
  public String getFunction() {
    return function;
  }

  @JsonProperty("label")
  public Optional<String> getLabel() {
    return label;
  }

  @JsonProperty("value")
  public Optional<Object> getValue() {
    return value;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V2Filter && equalTo((V2Filter) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V2Filter other) {
    return fieldId.equals(other.fieldId) && fieldType.equals(other.fieldType) && function.equals(other.function) && label.equals(other.label) && value.equals(other.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.fieldId, this.fieldType, this.function, this.label, this.value);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static FieldIdStage builder() {
    return new Builder();
  }

  public interface FieldIdStage {
    FieldTypeStage fieldId(String fieldId);

    Builder from(V2Filter other);
  }

  public interface FieldTypeStage {
    FunctionStage fieldType(String fieldType);
  }

  public interface FunctionStage {
    _FinalStage function(String function);
  }

  public interface _FinalStage {
    V2Filter build();

    _FinalStage label(Optional<String> label);

    _FinalStage label(String label);

    _FinalStage value(Optional<Object> value);

    _FinalStage value(Object value);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements FieldIdStage, FieldTypeStage, FunctionStage, _FinalStage {
    private String fieldId;

    private String fieldType;

    private String function;

    private Optional<Object> value = Optional.empty();

    private Optional<String> label = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(V2Filter other) {
      fieldId(other.getFieldId());
      fieldType(other.getFieldType());
      function(other.getFunction());
      label(other.getLabel());
      value(other.getValue());
      return this;
    }

    @Override
    @JsonSetter("field_id")
    public FieldTypeStage fieldId(String fieldId) {
      this.fieldId = fieldId;
      return this;
    }

    @Override
    @JsonSetter("field_type")
    public FunctionStage fieldType(String fieldType) {
      this.fieldType = fieldType;
      return this;
    }

    @Override
    @JsonSetter("function")
    public _FinalStage function(String function) {
      this.function = function;
      return this;
    }

    @Override
    public _FinalStage value(Object value) {
      this.value = Optional.of(value);
      return this;
    }

    @Override
    @JsonSetter(
        value = "value",
        nulls = Nulls.SKIP
    )
    public _FinalStage value(Optional<Object> value) {
      this.value = value;
      return this;
    }

    @Override
    public _FinalStage label(String label) {
      this.label = Optional.of(label);
      return this;
    }

    @Override
    @JsonSetter(
        value = "label",
        nulls = Nulls.SKIP
    )
    public _FinalStage label(Optional<String> label) {
      this.label = label;
      return this;
    }

    @Override
    public V2Filter build() {
      return new V2Filter(fieldId, fieldType, function, label, value, additionalProperties);
    }
  }
}