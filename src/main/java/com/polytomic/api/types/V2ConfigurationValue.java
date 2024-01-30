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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = V2ConfigurationValue.Builder.class
)
public final class V2ConfigurationValue {
  private final Optional<List<Object>> items;

  private final Optional<String> type;

  private final Map<String, Object> additionalProperties;

  private V2ConfigurationValue(Optional<List<Object>> items, Optional<String> type,
      Map<String, Object> additionalProperties) {
    this.items = items;
    this.type = type;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("items")
  public Optional<List<Object>> getItems() {
    return items;
  }

  @JsonProperty("type")
  public Optional<String> getType() {
    return type;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V2ConfigurationValue && equalTo((V2ConfigurationValue) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V2ConfigurationValue other) {
    return items.equals(other.items) && type.equals(other.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.items, this.type);
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
    private Optional<List<Object>> items = Optional.empty();

    private Optional<String> type = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(V2ConfigurationValue other) {
      items(other.getItems());
      type(other.getType());
      return this;
    }

    @JsonSetter(
        value = "items",
        nulls = Nulls.SKIP
    )
    public Builder items(Optional<List<Object>> items) {
      this.items = items;
      return this;
    }

    public Builder items(List<Object> items) {
      this.items = Optional.of(items);
      return this;
    }

    @JsonSetter(
        value = "type",
        nulls = Nulls.SKIP
    )
    public Builder type(Optional<String> type) {
      this.type = type;
      return this;
    }

    public Builder type(String type) {
      this.type = Optional.of(type);
      return this;
    }

    public V2ConfigurationValue build() {
      return new V2ConfigurationValue(items, type, additionalProperties);
    }
  }
}
