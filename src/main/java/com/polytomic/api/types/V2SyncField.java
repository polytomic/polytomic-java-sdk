
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
@JsonDeserialize(builder = V2SyncField.Builder.class)
public final class V2SyncField {
    private final Optional<Boolean> new_;

    private final Optional<String> overrideValue;

    private final V2Source source;

    private final Optional<String> syncMode;

    private final String target;

    private final Map<String, Object> additionalProperties;

    private V2SyncField(
            Optional<Boolean> new_,
            Optional<String> overrideValue,
            V2Source source,
            Optional<String> syncMode,
            String target,
            Map<String, Object> additionalProperties) {
        this.new_ = new_;
        this.overrideValue = overrideValue;
        this.source = source;
        this.syncMode = syncMode;
        this.target = target;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("new")
    public Optional<Boolean> getNew() {
        return new_;
    }

    @JsonProperty("override_value")
    public Optional<String> getOverrideValue() {
        return overrideValue;
    }

    @JsonProperty("source")
    public V2Source getSource() {
        return source;
    }

    @JsonProperty("sync_mode")
    public Optional<String> getSyncMode() {
        return syncMode;
    }

    @JsonProperty("target")
    public String getTarget() {
        return target;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2SyncField && equalTo((V2SyncField) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2SyncField other) {
        return new_.equals(other.new_)
                && overrideValue.equals(other.overrideValue)
                && source.equals(other.source)
                && syncMode.equals(other.syncMode)
                && target.equals(other.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.new_, this.overrideValue, this.source, this.syncMode, this.target);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static SourceStage builder() {
        return new Builder();
    }

    public interface SourceStage {
        TargetStage source(V2Source source);

        Builder from(V2SyncField other);
    }

    public interface TargetStage {
        _FinalStage target(String target);
    }

    public interface _FinalStage {
        V2SyncField build();

        _FinalStage new_(Optional<Boolean> new_);

        _FinalStage new_(Boolean new_);

        _FinalStage overrideValue(Optional<String> overrideValue);

        _FinalStage overrideValue(String overrideValue);

        _FinalStage syncMode(Optional<String> syncMode);

        _FinalStage syncMode(String syncMode);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SourceStage, TargetStage, _FinalStage {
        private V2Source source;

        private String target;

        private Optional<String> syncMode = Optional.empty();

        private Optional<String> overrideValue = Optional.empty();

        private Optional<Boolean> new_ = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(V2SyncField other) {
            new_(other.getNew());
            overrideValue(other.getOverrideValue());
            source(other.getSource());
            syncMode(other.getSyncMode());
            target(other.getTarget());
            return this;
        }

        @Override
        @JsonSetter("source")
        public TargetStage source(V2Source source) {
            this.source = source;
            return this;
        }

        @Override
        @JsonSetter("target")
        public _FinalStage target(String target) {
            this.target = target;
            return this;
        }

        @Override
        public _FinalStage syncMode(String syncMode) {
            this.syncMode = Optional.of(syncMode);
            return this;
        }

        @Override
        @JsonSetter(value = "sync_mode", nulls = Nulls.SKIP)
        public _FinalStage syncMode(Optional<String> syncMode) {
            this.syncMode = syncMode;
            return this;
        }

        @Override
        public _FinalStage overrideValue(String overrideValue) {
            this.overrideValue = Optional.of(overrideValue);
            return this;
        }

        @Override
        @JsonSetter(value = "override_value", nulls = Nulls.SKIP)
        public _FinalStage overrideValue(Optional<String> overrideValue) {
            this.overrideValue = overrideValue;
            return this;
        }

        @Override
        public _FinalStage new_(Boolean new_) {
            this.new_ = Optional.of(new_);
            return this;
        }

        @Override
        @JsonSetter(value = "new", nulls = Nulls.SKIP)
        public _FinalStage new_(Optional<Boolean> new_) {
            this.new_ = new_;
            return this;
        }

        @Override
        public V2SyncField build() {
            return new V2SyncField(new_, overrideValue, source, syncMode, target, additionalProperties);
        }
    }
}
