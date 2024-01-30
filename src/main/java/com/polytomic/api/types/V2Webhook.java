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
    builder = V2Webhook.Builder.class
)
public final class V2Webhook {
  private final Optional<OffsetDateTime> createdAt;

  private final Optional<String> endpoint;

  private final Optional<String> id;

  private final Optional<String> organizationId;

  private final Optional<String> secret;

  private final Map<String, Object> additionalProperties;

  private V2Webhook(Optional<OffsetDateTime> createdAt, Optional<String> endpoint,
      Optional<String> id, Optional<String> organizationId, Optional<String> secret,
      Map<String, Object> additionalProperties) {
    this.createdAt = createdAt;
    this.endpoint = endpoint;
    this.id = id;
    this.organizationId = organizationId;
    this.secret = secret;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("created_at")
  public Optional<OffsetDateTime> getCreatedAt() {
    return createdAt;
  }

  @JsonProperty("endpoint")
  public Optional<String> getEndpoint() {
    return endpoint;
  }

  @JsonProperty("id")
  public Optional<String> getId() {
    return id;
  }

  @JsonProperty("organization_id")
  public Optional<String> getOrganizationId() {
    return organizationId;
  }

  @JsonProperty("secret")
  public Optional<String> getSecret() {
    return secret;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V2Webhook && equalTo((V2Webhook) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V2Webhook other) {
    return createdAt.equals(other.createdAt) && endpoint.equals(other.endpoint) && id.equals(other.id) && organizationId.equals(other.organizationId) && secret.equals(other.secret);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.createdAt, this.endpoint, this.id, this.organizationId, this.secret);
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
    private Optional<OffsetDateTime> createdAt = Optional.empty();

    private Optional<String> endpoint = Optional.empty();

    private Optional<String> id = Optional.empty();

    private Optional<String> organizationId = Optional.empty();

    private Optional<String> secret = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(V2Webhook other) {
      createdAt(other.getCreatedAt());
      endpoint(other.getEndpoint());
      id(other.getId());
      organizationId(other.getOrganizationId());
      secret(other.getSecret());
      return this;
    }

    @JsonSetter(
        value = "created_at",
        nulls = Nulls.SKIP
    )
    public Builder createdAt(Optional<OffsetDateTime> createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public Builder createdAt(OffsetDateTime createdAt) {
      this.createdAt = Optional.of(createdAt);
      return this;
    }

    @JsonSetter(
        value = "endpoint",
        nulls = Nulls.SKIP
    )
    public Builder endpoint(Optional<String> endpoint) {
      this.endpoint = endpoint;
      return this;
    }

    public Builder endpoint(String endpoint) {
      this.endpoint = Optional.of(endpoint);
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
        value = "organization_id",
        nulls = Nulls.SKIP
    )
    public Builder organizationId(Optional<String> organizationId) {
      this.organizationId = organizationId;
      return this;
    }

    public Builder organizationId(String organizationId) {
      this.organizationId = Optional.of(organizationId);
      return this;
    }

    @JsonSetter(
        value = "secret",
        nulls = Nulls.SKIP
    )
    public Builder secret(Optional<String> secret) {
      this.secret = secret;
      return this;
    }

    public Builder secret(String secret) {
      this.secret = Optional.of(secret);
      return this;
    }

    public V2Webhook build() {
      return new V2Webhook(createdAt, endpoint, id, organizationId, secret, additionalProperties);
    }
  }
}