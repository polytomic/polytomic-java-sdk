package com.polytomic.api.resources.bulksync.executions.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.polytomic.api.core.ObjectMappers;
import java.lang.Boolean;
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
    builder = V3StartBulkSyncRequest.Builder.class
)
public final class V3StartBulkSyncRequest {
  private final Optional<Boolean> resync;

  private final Optional<List<String>> schemas;

  private final Optional<Boolean> test;

  private final Map<String, Object> additionalProperties;

  private V3StartBulkSyncRequest(Optional<Boolean> resync, Optional<List<String>> schemas,
      Optional<Boolean> test, Map<String, Object> additionalProperties) {
    this.resync = resync;
    this.schemas = schemas;
    this.test = test;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("resync")
  public Optional<Boolean> getResync() {
    return resync;
  }

  @JsonProperty("schemas")
  public Optional<List<String>> getSchemas() {
    return schemas;
  }

  @JsonProperty("test")
  public Optional<Boolean> getTest() {
    return test;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V3StartBulkSyncRequest && equalTo((V3StartBulkSyncRequest) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V3StartBulkSyncRequest other) {
    return resync.equals(other.resync) && schemas.equals(other.schemas) && test.equals(other.test);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.resync, this.schemas, this.test);
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
    private Optional<Boolean> resync = Optional.empty();

    private Optional<List<String>> schemas = Optional.empty();

    private Optional<Boolean> test = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(V3StartBulkSyncRequest other) {
      resync(other.getResync());
      schemas(other.getSchemas());
      test(other.getTest());
      return this;
    }

    @JsonSetter(
        value = "resync",
        nulls = Nulls.SKIP
    )
    public Builder resync(Optional<Boolean> resync) {
      this.resync = resync;
      return this;
    }

    public Builder resync(Boolean resync) {
      this.resync = Optional.of(resync);
      return this;
    }

    @JsonSetter(
        value = "schemas",
        nulls = Nulls.SKIP
    )
    public Builder schemas(Optional<List<String>> schemas) {
      this.schemas = schemas;
      return this;
    }

    public Builder schemas(List<String> schemas) {
      this.schemas = Optional.of(schemas);
      return this;
    }

    @JsonSetter(
        value = "test",
        nulls = Nulls.SKIP
    )
    public Builder test(Optional<Boolean> test) {
      this.test = test;
      return this;
    }

    public Builder test(Boolean test) {
      this.test = Optional.of(test);
      return this;
    }

    public V3StartBulkSyncRequest build() {
      return new V3StartBulkSyncRequest(resync, schemas, test, additionalProperties);
    }
  }
}
