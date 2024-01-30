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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = V2ModelFieldRequest.Builder.class
)
public final class V2ModelFieldRequest {
  private final Optional<String> example;

  private final String label;

  private final String name;

  private final String type;

  private final Map<String, Object> additionalProperties;

  private V2ModelFieldRequest(Optional<String> example, String label, String name, String type,
      Map<String, Object> additionalProperties) {
    this.example = example;
    this.label = label;
    this.name = name;
    this.type = type;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("example")
  public Optional<String> getExample() {
    return example;
  }

  @JsonProperty("label")
  public String getLabel() {
    return label;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V2ModelFieldRequest && equalTo((V2ModelFieldRequest) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V2ModelFieldRequest other) {
    return example.equals(other.example) && label.equals(other.label) && name.equals(other.name) && type.equals(other.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.example, this.label, this.name, this.type);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static LabelStage builder() {
    return new Builder();
  }

  public interface LabelStage {
    NameStage label(String label);

    Builder from(V2ModelFieldRequest other);
  }

  public interface NameStage {
    TypeStage name(String name);
  }

  public interface TypeStage {
    _FinalStage type(String type);
  }

  public interface _FinalStage {
    V2ModelFieldRequest build();

    _FinalStage example(Optional<String> example);

    _FinalStage example(String example);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements LabelStage, NameStage, TypeStage, _FinalStage {
    private String label;

    private String name;

    private String type;

    private Optional<String> example = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(V2ModelFieldRequest other) {
      example(other.getExample());
      label(other.getLabel());
      name(other.getName());
      type(other.getType());
      return this;
    }

    @Override
    @JsonSetter("label")
    public NameStage label(String label) {
      this.label = label;
      return this;
    }

    @Override
    @JsonSetter("name")
    public TypeStage name(String name) {
      this.name = name;
      return this;
    }

    @Override
    @JsonSetter("type")
    public _FinalStage type(String type) {
      this.type = type;
      return this;
    }

    @Override
    public _FinalStage example(String example) {
      this.example = Optional.of(example);
      return this;
    }

    @Override
    @JsonSetter(
        value = "example",
        nulls = Nulls.SKIP
    )
    public _FinalStage example(Optional<String> example) {
      this.example = example;
      return this;
    }

    @Override
    public V2ModelFieldRequest build() {
      return new V2ModelFieldRequest(example, label, name, type, additionalProperties);
    }
  }
}