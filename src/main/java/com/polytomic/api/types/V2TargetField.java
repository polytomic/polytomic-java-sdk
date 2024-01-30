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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = V2TargetField.Builder.class
)
public final class V2TargetField {
  private final Optional<Boolean> association;

  private final Optional<Boolean> createable;

  private final Optional<String> description;

  private final Optional<Boolean> filterable;

  private final Optional<String> id;

  private final Optional<List<V2IdentityFunction>> identityFunctions;

  private final Optional<String> name;

  private final Optional<Boolean> required;

  private final Optional<String> sourceType;

  private final Optional<Boolean> supportsIdentity;

  private final Optional<String> type;

  private final Optional<Boolean> updateable;

  private final Map<String, Object> additionalProperties;

  private V2TargetField(Optional<Boolean> association, Optional<Boolean> createable,
      Optional<String> description, Optional<Boolean> filterable, Optional<String> id,
      Optional<List<V2IdentityFunction>> identityFunctions, Optional<String> name,
      Optional<Boolean> required, Optional<String> sourceType, Optional<Boolean> supportsIdentity,
      Optional<String> type, Optional<Boolean> updateable,
      Map<String, Object> additionalProperties) {
    this.association = association;
    this.createable = createable;
    this.description = description;
    this.filterable = filterable;
    this.id = id;
    this.identityFunctions = identityFunctions;
    this.name = name;
    this.required = required;
    this.sourceType = sourceType;
    this.supportsIdentity = supportsIdentity;
    this.type = type;
    this.updateable = updateable;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("association")
  public Optional<Boolean> getAssociation() {
    return association;
  }

  @JsonProperty("createable")
  public Optional<Boolean> getCreateable() {
    return createable;
  }

  @JsonProperty("description")
  public Optional<String> getDescription() {
    return description;
  }

  @JsonProperty("filterable")
  public Optional<Boolean> getFilterable() {
    return filterable;
  }

  @JsonProperty("id")
  public Optional<String> getId() {
    return id;
  }

  @JsonProperty("identity_functions")
  public Optional<List<V2IdentityFunction>> getIdentityFunctions() {
    return identityFunctions;
  }

  @JsonProperty("name")
  public Optional<String> getName() {
    return name;
  }

  @JsonProperty("required")
  public Optional<Boolean> getRequired() {
    return required;
  }

  @JsonProperty("source_type")
  public Optional<String> getSourceType() {
    return sourceType;
  }

  @JsonProperty("supports_identity")
  public Optional<Boolean> getSupportsIdentity() {
    return supportsIdentity;
  }

  @JsonProperty("type")
  public Optional<String> getType() {
    return type;
  }

  @JsonProperty("updateable")
  public Optional<Boolean> getUpdateable() {
    return updateable;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V2TargetField && equalTo((V2TargetField) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V2TargetField other) {
    return association.equals(other.association) && createable.equals(other.createable) && description.equals(other.description) && filterable.equals(other.filterable) && id.equals(other.id) && identityFunctions.equals(other.identityFunctions) && name.equals(other.name) && required.equals(other.required) && sourceType.equals(other.sourceType) && supportsIdentity.equals(other.supportsIdentity) && type.equals(other.type) && updateable.equals(other.updateable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.association, this.createable, this.description, this.filterable, this.id, this.identityFunctions, this.name, this.required, this.sourceType, this.supportsIdentity, this.type, this.updateable);
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
    private Optional<Boolean> association = Optional.empty();

    private Optional<Boolean> createable = Optional.empty();

    private Optional<String> description = Optional.empty();

    private Optional<Boolean> filterable = Optional.empty();

    private Optional<String> id = Optional.empty();

    private Optional<List<V2IdentityFunction>> identityFunctions = Optional.empty();

    private Optional<String> name = Optional.empty();

    private Optional<Boolean> required = Optional.empty();

    private Optional<String> sourceType = Optional.empty();

    private Optional<Boolean> supportsIdentity = Optional.empty();

    private Optional<String> type = Optional.empty();

    private Optional<Boolean> updateable = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(V2TargetField other) {
      association(other.getAssociation());
      createable(other.getCreateable());
      description(other.getDescription());
      filterable(other.getFilterable());
      id(other.getId());
      identityFunctions(other.getIdentityFunctions());
      name(other.getName());
      required(other.getRequired());
      sourceType(other.getSourceType());
      supportsIdentity(other.getSupportsIdentity());
      type(other.getType());
      updateable(other.getUpdateable());
      return this;
    }

    @JsonSetter(
        value = "association",
        nulls = Nulls.SKIP
    )
    public Builder association(Optional<Boolean> association) {
      this.association = association;
      return this;
    }

    public Builder association(Boolean association) {
      this.association = Optional.of(association);
      return this;
    }

    @JsonSetter(
        value = "createable",
        nulls = Nulls.SKIP
    )
    public Builder createable(Optional<Boolean> createable) {
      this.createable = createable;
      return this;
    }

    public Builder createable(Boolean createable) {
      this.createable = Optional.of(createable);
      return this;
    }

    @JsonSetter(
        value = "description",
        nulls = Nulls.SKIP
    )
    public Builder description(Optional<String> description) {
      this.description = description;
      return this;
    }

    public Builder description(String description) {
      this.description = Optional.of(description);
      return this;
    }

    @JsonSetter(
        value = "filterable",
        nulls = Nulls.SKIP
    )
    public Builder filterable(Optional<Boolean> filterable) {
      this.filterable = filterable;
      return this;
    }

    public Builder filterable(Boolean filterable) {
      this.filterable = Optional.of(filterable);
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
        value = "identity_functions",
        nulls = Nulls.SKIP
    )
    public Builder identityFunctions(Optional<List<V2IdentityFunction>> identityFunctions) {
      this.identityFunctions = identityFunctions;
      return this;
    }

    public Builder identityFunctions(List<V2IdentityFunction> identityFunctions) {
      this.identityFunctions = Optional.of(identityFunctions);
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
        value = "required",
        nulls = Nulls.SKIP
    )
    public Builder required(Optional<Boolean> required) {
      this.required = required;
      return this;
    }

    public Builder required(Boolean required) {
      this.required = Optional.of(required);
      return this;
    }

    @JsonSetter(
        value = "source_type",
        nulls = Nulls.SKIP
    )
    public Builder sourceType(Optional<String> sourceType) {
      this.sourceType = sourceType;
      return this;
    }

    public Builder sourceType(String sourceType) {
      this.sourceType = Optional.of(sourceType);
      return this;
    }

    @JsonSetter(
        value = "supports_identity",
        nulls = Nulls.SKIP
    )
    public Builder supportsIdentity(Optional<Boolean> supportsIdentity) {
      this.supportsIdentity = supportsIdentity;
      return this;
    }

    public Builder supportsIdentity(Boolean supportsIdentity) {
      this.supportsIdentity = Optional.of(supportsIdentity);
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
        value = "updateable",
        nulls = Nulls.SKIP
    )
    public Builder updateable(Optional<Boolean> updateable) {
      this.updateable = updateable;
      return this;
    }

    public Builder updateable(Boolean updateable) {
      this.updateable = Optional.of(updateable);
      return this;
    }

    public V2TargetField build() {
      return new V2TargetField(association, createable, description, filterable, id, identityFunctions, name, required, sourceType, supportsIdentity, type, updateable, additionalProperties);
    }
  }
}
