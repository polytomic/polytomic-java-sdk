package com.polytomic.api.resources.users.requests;

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
    builder = V2UpdateUserRequestSchema.Builder.class
)
public final class V2UpdateUserRequestSchema {
  private final String email;

  private final Optional<String> role;

  private final Map<String, Object> additionalProperties;

  private V2UpdateUserRequestSchema(String email, Optional<String> role,
      Map<String, Object> additionalProperties) {
    this.email = email;
    this.role = role;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  @JsonProperty("role")
  public Optional<String> getRole() {
    return role;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V2UpdateUserRequestSchema && equalTo((V2UpdateUserRequestSchema) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V2UpdateUserRequestSchema other) {
    return email.equals(other.email) && role.equals(other.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.email, this.role);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static EmailStage builder() {
    return new Builder();
  }

  public interface EmailStage {
    _FinalStage email(String email);

    Builder from(V2UpdateUserRequestSchema other);
  }

  public interface _FinalStage {
    V2UpdateUserRequestSchema build();

    _FinalStage role(Optional<String> role);

    _FinalStage role(String role);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements EmailStage, _FinalStage {
    private String email;

    private Optional<String> role = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(V2UpdateUserRequestSchema other) {
      email(other.getEmail());
      role(other.getRole());
      return this;
    }

    @Override
    @JsonSetter("email")
    public _FinalStage email(String email) {
      this.email = email;
      return this;
    }

    @Override
    public _FinalStage role(String role) {
      this.role = Optional.of(role);
      return this;
    }

    @Override
    @JsonSetter(
        value = "role",
        nulls = Nulls.SKIP
    )
    public _FinalStage role(Optional<String> role) {
      this.role = role;
      return this;
    }

    @Override
    public V2UpdateUserRequestSchema build() {
      return new V2UpdateUserRequestSchema(email, role, additionalProperties);
    }
  }
}
