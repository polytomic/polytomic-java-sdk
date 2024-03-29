/**
 * This file was auto-generated by Fern from our API Definition.
 */
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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = V2Identity.Builder.class)
public final class V2Identity {
    private final String function;

    private final Optional<Boolean> newField;

    private final Optional<String> remoteFieldTypeId;

    private final V2Source source;

    private final String target;

    private final Map<String, Object> additionalProperties;

    private V2Identity(
            String function,
            Optional<Boolean> newField,
            Optional<String> remoteFieldTypeId,
            V2Source source,
            String target,
            Map<String, Object> additionalProperties) {
        this.function = function;
        this.newField = newField;
        this.remoteFieldTypeId = remoteFieldTypeId;
        this.source = source;
        this.target = target;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("function")
    public String getFunction() {
        return function;
    }

    @JsonProperty("new_field")
    public Optional<Boolean> getNewField() {
        return newField;
    }

    @JsonProperty("remote_field_type_id")
    public Optional<String> getRemoteFieldTypeId() {
        return remoteFieldTypeId;
    }

    @JsonProperty("source")
    public V2Source getSource() {
        return source;
    }

    @JsonProperty("target")
    public String getTarget() {
        return target;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2Identity && equalTo((V2Identity) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2Identity other) {
        return function.equals(other.function)
                && newField.equals(other.newField)
                && remoteFieldTypeId.equals(other.remoteFieldTypeId)
                && source.equals(other.source)
                && target.equals(other.target);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.function, this.newField, this.remoteFieldTypeId, this.source, this.target);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static FunctionStage builder() {
        return new Builder();
    }

    public interface FunctionStage {
        SourceStage function(String function);

        Builder from(V2Identity other);
    }

    public interface SourceStage {
        TargetStage source(V2Source source);
    }

    public interface TargetStage {
        _FinalStage target(String target);
    }

    public interface _FinalStage {
        V2Identity build();

        _FinalStage newField(Optional<Boolean> newField);

        _FinalStage newField(Boolean newField);

        _FinalStage remoteFieldTypeId(Optional<String> remoteFieldTypeId);

        _FinalStage remoteFieldTypeId(String remoteFieldTypeId);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements FunctionStage, SourceStage, TargetStage, _FinalStage {
        private String function;

        private V2Source source;

        private String target;

        private Optional<String> remoteFieldTypeId = Optional.empty();

        private Optional<Boolean> newField = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(V2Identity other) {
            function(other.getFunction());
            newField(other.getNewField());
            remoteFieldTypeId(other.getRemoteFieldTypeId());
            source(other.getSource());
            target(other.getTarget());
            return this;
        }

        @java.lang.Override
        @JsonSetter("function")
        public SourceStage function(String function) {
            this.function = function;
            return this;
        }

        @java.lang.Override
        @JsonSetter("source")
        public TargetStage source(V2Source source) {
            this.source = source;
            return this;
        }

        @java.lang.Override
        @JsonSetter("target")
        public _FinalStage target(String target) {
            this.target = target;
            return this;
        }

        @java.lang.Override
        public _FinalStage remoteFieldTypeId(String remoteFieldTypeId) {
            this.remoteFieldTypeId = Optional.of(remoteFieldTypeId);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "remote_field_type_id", nulls = Nulls.SKIP)
        public _FinalStage remoteFieldTypeId(Optional<String> remoteFieldTypeId) {
            this.remoteFieldTypeId = remoteFieldTypeId;
            return this;
        }

        @java.lang.Override
        public _FinalStage newField(Boolean newField) {
            this.newField = Optional.of(newField);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "new_field", nulls = Nulls.SKIP)
        public _FinalStage newField(Optional<Boolean> newField) {
            this.newField = newField;
            return this;
        }

        @java.lang.Override
        public V2Identity build() {
            return new V2Identity(function, newField, remoteFieldTypeId, source, target, additionalProperties);
        }
    }
}
