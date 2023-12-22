/**
 * This file was auto-generated by Fern from our API Definition.
 */

package types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import core.ObjectMappers;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = V2RelationTo.Builder.class
)
public final class V2RelationTo {
  private final Optional<String> field;

  private final Optional<String> modelId;

  private final Map<String, Object> additionalProperties;

  private V2RelationTo(Optional<String> field, Optional<String> modelId,
      Map<String, Object> additionalProperties) {
    this.field = field;
    this.modelId = modelId;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("field")
  public Optional<String> getField() {
    return field;
  }

  @JsonProperty("model_id")
  public Optional<String> getModelId() {
    return modelId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V2RelationTo && equalTo((V2RelationTo) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V2RelationTo other) {
    return field.equals(other.field) && modelId.equals(other.modelId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.field, this.modelId);
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
    private Optional<String> field = Optional.empty();

    private Optional<String> modelId = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(V2RelationTo other) {
      field(other.getField());
      modelId(other.getModelId());
      return this;
    }

    @JsonSetter(
        value = "field",
        nulls = Nulls.SKIP
    )
    public Builder field(Optional<String> field) {
      this.field = field;
      return this;
    }

    public Builder field(String field) {
      this.field = Optional.of(field);
      return this;
    }

    @JsonSetter(
        value = "model_id",
        nulls = Nulls.SKIP
    )
    public Builder modelId(Optional<String> modelId) {
      this.modelId = modelId;
      return this;
    }

    public Builder modelId(String modelId) {
      this.modelId = Optional.of(modelId);
      return this;
    }

    public V2RelationTo build() {
      return new V2RelationTo(field, modelId, additionalProperties);
    }
  }
}
