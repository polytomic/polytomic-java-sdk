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
    builder = V2IdentityFunction.Builder.class
)
public final class V2IdentityFunction {
  private final Optional<String> id;

  private final Optional<String> label;

  private final Map<String, Object> additionalProperties;

  private V2IdentityFunction(Optional<String> id, Optional<String> label,
      Map<String, Object> additionalProperties) {
    this.id = id;
    this.label = label;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("id")
  public Optional<String> getId() {
    return id;
  }

  @JsonProperty("label")
  public Optional<String> getLabel() {
    return label;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V2IdentityFunction && equalTo((V2IdentityFunction) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V2IdentityFunction other) {
    return id.equals(other.id) && label.equals(other.label);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.label);
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
    private Optional<String> id = Optional.empty();

    private Optional<String> label = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(V2IdentityFunction other) {
      id(other.getId());
      label(other.getLabel());
      return this;
    }

    @JsonSetter(
        value = "id",
        nulls = Nulls.SKIP
    )
    public Builder id(Optional<String> id) {
      this.id = id;
      return this;
    }

    public Builder id(String id) {
      this.id = Optional.of(id);
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

    public V2IdentityFunction build() {
      return new V2IdentityFunction(id, label, additionalProperties);
    }
  }
}