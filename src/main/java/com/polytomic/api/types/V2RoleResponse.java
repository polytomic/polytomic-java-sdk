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
    builder = V2RoleResponse.Builder.class
)
public final class V2RoleResponse {
  private final Optional<String> id;

  private final Optional<String> name;

  private final Optional<String> organizationId;

  private final Optional<Boolean> system;

  private final Map<String, Object> additionalProperties;

  private V2RoleResponse(Optional<String> id, Optional<String> name,
      Optional<String> organizationId, Optional<Boolean> system,
      Map<String, Object> additionalProperties) {
    this.id = id;
    this.name = name;
    this.organizationId = organizationId;
    this.system = system;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("id")
  public Optional<String> getId() {
    return id;
  }

  @JsonProperty("name")
  public Optional<String> getName() {
    return name;
  }

  @JsonProperty("organization_id")
  public Optional<String> getOrganizationId() {
    return organizationId;
  }

  @JsonProperty("system")
  public Optional<Boolean> getSystem() {
    return system;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V2RoleResponse && equalTo((V2RoleResponse) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V2RoleResponse other) {
    return id.equals(other.id) && name.equals(other.name) && organizationId.equals(other.organizationId) && system.equals(other.system);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.organizationId, this.system);
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

    private Optional<String> name = Optional.empty();

    private Optional<String> organizationId = Optional.empty();

    private Optional<Boolean> system = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(V2RoleResponse other) {
      id(other.getId());
      name(other.getName());
      organizationId(other.getOrganizationId());
      system(other.getSystem());
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
        value = "name",
        nulls = Nulls.SKIP
    )
    public Builder name(Optional<String> name) {
      this.name = name;
      return this;
    }

    public Builder name(String name) {
      this.name = Optional.of(name);
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
        value = "system",
        nulls = Nulls.SKIP
    )
    public Builder system(Optional<Boolean> system) {
      this.system = system;
      return this;
    }

    public Builder system(Boolean system) {
      this.system = Optional.of(system);
      return this;
    }

    public V2RoleResponse build() {
      return new V2RoleResponse(id, name, organizationId, system, additionalProperties);
    }
  }
}