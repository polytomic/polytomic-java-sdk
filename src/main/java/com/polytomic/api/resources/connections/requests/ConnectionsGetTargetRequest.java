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
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = ConnectionsGetTargetRequest.Builder.class
)
public final class ConnectionsGetTargetRequest {
  private final Optional<String> type;

  private final Optional<String> search;

  private final Map<String, Object> additionalProperties;

  private ConnectionsGetTargetRequest(Optional<String> type, Optional<String> search,
      Map<String, Object> additionalProperties) {
    this.type = type;
    this.search = search;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("type")
  public Optional<String> getType() {
    return type;
  }

  @JsonProperty("search")
  public Optional<String> getSearch() {
    return search;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ConnectionsGetTargetRequest && equalTo((ConnectionsGetTargetRequest) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(ConnectionsGetTargetRequest other) {
    return type.equals(other.type) && search.equals(other.search);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.type, this.search);
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
    private Optional<String> type = Optional.empty();

    private Optional<String> search = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(ConnectionsGetTargetRequest other) {
      type(other.getType());
      search(other.getSearch());
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

    @JsonSetter(
        value = "search",
        nulls = Nulls.SKIP
    )
    public Builder search(Optional<String> search) {
      this.search = search;
      return this;
    }

    public Builder search(String search) {
      this.search = Optional.of(search);
      return this;
    }

    public ConnectionsGetTargetRequest build() {
      return new ConnectionsGetTargetRequest(type, search, additionalProperties);
    }
  }
}