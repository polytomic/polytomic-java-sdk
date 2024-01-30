package com.polytomic.api.resources.permissions.policies.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.types.V2PolicyAction;
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
    builder = V2UpdatePolicyRequest.Builder.class
)
public final class V2UpdatePolicyRequest {
  private final String name;

  private final Optional<String> organizationId;

  private final Optional<List<V2PolicyAction>> policyActions;

  private final Map<String, Object> additionalProperties;

  private V2UpdatePolicyRequest(String name, Optional<String> organizationId,
      Optional<List<V2PolicyAction>> policyActions, Map<String, Object> additionalProperties) {
    this.name = name;
    this.organizationId = organizationId;
    this.policyActions = policyActions;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("organization_id")
  public Optional<String> getOrganizationId() {
    return organizationId;
  }

  @JsonProperty("policy_actions")
  public Optional<List<V2PolicyAction>> getPolicyActions() {
    return policyActions;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V2UpdatePolicyRequest && equalTo((V2UpdatePolicyRequest) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V2UpdatePolicyRequest other) {
    return name.equals(other.name) && organizationId.equals(other.organizationId) && policyActions.equals(other.policyActions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.organizationId, this.policyActions);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static NameStage builder() {
    return new Builder();
  }

  public interface NameStage {
    _FinalStage name(String name);

    Builder from(V2UpdatePolicyRequest other);
  }

  public interface _FinalStage {
    V2UpdatePolicyRequest build();

    _FinalStage organizationId(Optional<String> organizationId);

    _FinalStage organizationId(String organizationId);

    _FinalStage policyActions(Optional<List<V2PolicyAction>> policyActions);

    _FinalStage policyActions(List<V2PolicyAction> policyActions);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements NameStage, _FinalStage {
    private String name;

    private Optional<List<V2PolicyAction>> policyActions = Optional.empty();

    private Optional<String> organizationId = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(V2UpdatePolicyRequest other) {
      name(other.getName());
      organizationId(other.getOrganizationId());
      policyActions(other.getPolicyActions());
      return this;
    }

    @Override
    @JsonSetter("name")
    public _FinalStage name(String name) {
      this.name = name;
      return this;
    }

    @Override
    public _FinalStage policyActions(List<V2PolicyAction> policyActions) {
      this.policyActions = Optional.of(policyActions);
      return this;
    }

    @Override
    @JsonSetter(
        value = "policy_actions",
        nulls = Nulls.SKIP
    )
    public _FinalStage policyActions(Optional<List<V2PolicyAction>> policyActions) {
      this.policyActions = policyActions;
      return this;
    }

    @Override
    public _FinalStage organizationId(String organizationId) {
      this.organizationId = Optional.of(organizationId);
      return this;
    }

    @Override
    @JsonSetter(
        value = "organization_id",
        nulls = Nulls.SKIP
    )
    public _FinalStage organizationId(Optional<String> organizationId) {
      this.organizationId = organizationId;
      return this;
    }

    @Override
    public V2UpdatePolicyRequest build() {
      return new V2UpdatePolicyRequest(name, organizationId, policyActions, additionalProperties);
    }
  }
}