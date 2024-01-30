package com.polytomic.api.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.polytomic.api.core.ObjectMappers;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = V2ActivateSyncInput.Builder.class
)
public final class V2ActivateSyncInput {
  private final boolean active;

  private final Map<String, Object> additionalProperties;

  private V2ActivateSyncInput(boolean active, Map<String, Object> additionalProperties) {
    this.active = active;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("active")
  public boolean getActive() {
    return active;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V2ActivateSyncInput && equalTo((V2ActivateSyncInput) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V2ActivateSyncInput other) {
    return active == other.active;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.active);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static ActiveStage builder() {
    return new Builder();
  }

  public interface ActiveStage {
    _FinalStage active(boolean active);

    Builder from(V2ActivateSyncInput other);
  }

  public interface _FinalStage {
    V2ActivateSyncInput build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ActiveStage, _FinalStage {
    private boolean active;

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(V2ActivateSyncInput other) {
      active(other.getActive());
      return this;
    }

    @Override
    @JsonSetter("active")
    public _FinalStage active(boolean active) {
      this.active = active;
      return this;
    }

    @Override
    public V2ActivateSyncInput build() {
      return new V2ActivateSyncInput(active, additionalProperties);
    }
  }
}