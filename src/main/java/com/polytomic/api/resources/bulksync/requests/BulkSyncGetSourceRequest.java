package com.polytomic.api.resources.bulksync.requests;

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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = BulkSyncGetSourceRequest.Builder.class
)
public final class BulkSyncGetSourceRequest {
  private final Optional<Boolean> refreshSchemas;

  private final Optional<Boolean> includeFields;

  private final Map<String, Object> additionalProperties;

  private BulkSyncGetSourceRequest(Optional<Boolean> refreshSchemas,
      Optional<Boolean> includeFields, Map<String, Object> additionalProperties) {
    this.refreshSchemas = refreshSchemas;
    this.includeFields = includeFields;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("refresh_schemas")
  public Optional<Boolean> getRefreshSchemas() {
    return refreshSchemas;
  }

  @JsonProperty("include_fields")
  public Optional<Boolean> getIncludeFields() {
    return includeFields;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof BulkSyncGetSourceRequest && equalTo((BulkSyncGetSourceRequest) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(BulkSyncGetSourceRequest other) {
    return refreshSchemas.equals(other.refreshSchemas) && includeFields.equals(other.includeFields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.refreshSchemas, this.includeFields);
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
    private Optional<Boolean> refreshSchemas = Optional.empty();

    private Optional<Boolean> includeFields = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(BulkSyncGetSourceRequest other) {
      refreshSchemas(other.getRefreshSchemas());
      includeFields(other.getIncludeFields());
      return this;
    }

    @JsonSetter(
        value = "refresh_schemas",
        nulls = Nulls.SKIP
    )
    public Builder refreshSchemas(Optional<Boolean> refreshSchemas) {
      this.refreshSchemas = refreshSchemas;
      return this;
    }

    public Builder refreshSchemas(Boolean refreshSchemas) {
      this.refreshSchemas = Optional.of(refreshSchemas);
      return this;
    }

    @JsonSetter(
        value = "include_fields",
        nulls = Nulls.SKIP
    )
    public Builder includeFields(Optional<Boolean> includeFields) {
      this.includeFields = includeFields;
      return this;
    }

    public Builder includeFields(Boolean includeFields) {
      this.includeFields = Optional.of(includeFields);
      return this;
    }

    public BulkSyncGetSourceRequest build() {
      return new BulkSyncGetSourceRequest(refreshSchemas, includeFields, additionalProperties);
    }
  }
}
