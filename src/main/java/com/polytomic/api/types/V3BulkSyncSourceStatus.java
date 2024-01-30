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
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = V3BulkSyncSourceStatus.Builder.class
)
public final class V3BulkSyncSourceStatus {
  private final Optional<String> cacheStatus;

  private final Optional<OffsetDateTime> lastRefreshFinished;

  private final Optional<OffsetDateTime> lastRefreshStarted;

  private final Map<String, Object> additionalProperties;

  private V3BulkSyncSourceStatus(Optional<String> cacheStatus,
      Optional<OffsetDateTime> lastRefreshFinished, Optional<OffsetDateTime> lastRefreshStarted,
      Map<String, Object> additionalProperties) {
    this.cacheStatus = cacheStatus;
    this.lastRefreshFinished = lastRefreshFinished;
    this.lastRefreshStarted = lastRefreshStarted;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("cache_status")
  public Optional<String> getCacheStatus() {
    return cacheStatus;
  }

  @JsonProperty("last_refresh_finished")
  public Optional<OffsetDateTime> getLastRefreshFinished() {
    return lastRefreshFinished;
  }

  @JsonProperty("last_refresh_started")
  public Optional<OffsetDateTime> getLastRefreshStarted() {
    return lastRefreshStarted;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V3BulkSyncSourceStatus && equalTo((V3BulkSyncSourceStatus) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V3BulkSyncSourceStatus other) {
    return cacheStatus.equals(other.cacheStatus) && lastRefreshFinished.equals(other.lastRefreshFinished) && lastRefreshStarted.equals(other.lastRefreshStarted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.cacheStatus, this.lastRefreshFinished, this.lastRefreshStarted);
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
    private Optional<String> cacheStatus = Optional.empty();

    private Optional<OffsetDateTime> lastRefreshFinished = Optional.empty();

    private Optional<OffsetDateTime> lastRefreshStarted = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(V3BulkSyncSourceStatus other) {
      cacheStatus(other.getCacheStatus());
      lastRefreshFinished(other.getLastRefreshFinished());
      lastRefreshStarted(other.getLastRefreshStarted());
      return this;
    }

    @JsonSetter(
        value = "cache_status",
        nulls = Nulls.SKIP
    )
    public Builder cacheStatus(Optional<String> cacheStatus) {
      this.cacheStatus = cacheStatus;
      return this;
    }

    public Builder cacheStatus(String cacheStatus) {
      this.cacheStatus = Optional.of(cacheStatus);
      return this;
    }

    @JsonSetter(
        value = "last_refresh_finished",
        nulls = Nulls.SKIP
    )
    public Builder lastRefreshFinished(Optional<OffsetDateTime> lastRefreshFinished) {
      this.lastRefreshFinished = lastRefreshFinished;
      return this;
    }

    public Builder lastRefreshFinished(OffsetDateTime lastRefreshFinished) {
      this.lastRefreshFinished = Optional.of(lastRefreshFinished);
      return this;
    }

    @JsonSetter(
        value = "last_refresh_started",
        nulls = Nulls.SKIP
    )
    public Builder lastRefreshStarted(Optional<OffsetDateTime> lastRefreshStarted) {
      this.lastRefreshStarted = lastRefreshStarted;
      return this;
    }

    public Builder lastRefreshStarted(OffsetDateTime lastRefreshStarted) {
      this.lastRefreshStarted = Optional.of(lastRefreshStarted);
      return this;
    }

    public V3BulkSyncSourceStatus build() {
      return new V3BulkSyncSourceStatus(cacheStatus, lastRefreshFinished, lastRefreshStarted, additionalProperties);
    }
  }
}