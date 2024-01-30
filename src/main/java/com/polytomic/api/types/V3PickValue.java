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
    builder = V3PickValue.Builder.class
)
public final class V3PickValue {
  private final Optional<String> label;

  private final Optional<String> value;

  private final Map<String, Object> additionalProperties;

  private V3PickValue(Optional<String> label, Optional<String> value,
      Map<String, Object> additionalProperties) {
    this.label = label;
    this.value = value;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("label")
  public Optional<String> getLabel() {
    return label;
  }

  @JsonProperty("value")
  public Optional<String> getValue() {
    return value;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V3PickValue && equalTo((V3PickValue) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V3PickValue other) {
    return label.equals(other.label) && value.equals(other.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.label, this.value);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> label = Optional.empty();

    private Optional<String> value = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(V3PickValue other) {
      label(other.getLabel());
      value(other.getValue());
      return this;
    }

    @JsonSetter(
        value = "label",
        nulls = Nulls.SKIP
    )
    public Builder label(Optional<String> label) {
      this.label = label;
      return this;
    }

    public Builder label(String label) {
      this.label = Optional.of(label);
      return this;
    }

    @JsonSetter(
        value = "value",
        nulls = Nulls.SKIP
    )
    public Builder value(Optional<String> value) {
      this.value = value;
      return this;
    }

    public Builder value(String value) {
      this.value = Optional.of(value);
      return this;
    }

    public V3PickValue build() {
      return new V3PickValue(label, value, additionalProperties);
    }
  }
}