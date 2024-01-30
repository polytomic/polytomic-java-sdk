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
    builder = V2CreateConnectionResponseEnvelope.Builder.class
)
public final class V2CreateConnectionResponseEnvelope {
  private final Optional<V2CreateConnectionResponseSchema> data;

  private final Map<String, Object> additionalProperties;

  private V2CreateConnectionResponseEnvelope(Optional<V2CreateConnectionResponseSchema> data,
      Map<String, Object> additionalProperties) {
    this.data = data;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("data")
  public Optional<V2CreateConnectionResponseSchema> getData() {
    return data;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V2CreateConnectionResponseEnvelope && equalTo((V2CreateConnectionResponseEnvelope) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V2CreateConnectionResponseEnvelope other) {
    return data.equals(other.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.data);
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
    private Optional<V2CreateConnectionResponseSchema> data = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(V2CreateConnectionResponseEnvelope other) {
      data(other.getData());
      return this;
    }

    @JsonSetter(
        value = "data",
        nulls = Nulls.SKIP
    )
    public Builder data(Optional<V2CreateConnectionResponseSchema> data) {
      this.data = data;
      return this;
    }

    public Builder data(V2CreateConnectionResponseSchema data) {
      this.data = Optional.of(data);
      return this;
    }

    public V2CreateConnectionResponseEnvelope build() {
      return new V2CreateConnectionResponseEnvelope(data, additionalProperties);
    }
  }
}
