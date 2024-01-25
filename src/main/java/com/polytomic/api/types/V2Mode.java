
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
@JsonDeserialize(builder = V2Mode.Builder.class)
public final class V2Mode {
    private final Optional<String> description;

    private final Optional<String> label;

    private final Optional<String> mode;

    private final Optional<Boolean> requiresIdentity;

    private final Optional<Boolean> supportsFieldSyncMode;

    private final Optional<Boolean> supportsTargetFilters;

    private final Map<String, Object> additionalProperties;

    private V2Mode(
            Optional<String> description,
            Optional<String> label,
            Optional<String> mode,
            Optional<Boolean> requiresIdentity,
            Optional<Boolean> supportsFieldSyncMode,
            Optional<Boolean> supportsTargetFilters,
            Map<String, Object> additionalProperties) {
        this.description = description;
        this.label = label;
        this.mode = mode;
        this.requiresIdentity = requiresIdentity;
        this.supportsFieldSyncMode = supportsFieldSyncMode;
        this.supportsTargetFilters = supportsTargetFilters;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    @JsonProperty("label")
    public Optional<String> getLabel() {
        return label;
    }

    @JsonProperty("mode")
    public Optional<String> getMode() {
        return mode;
    }

    @JsonProperty("requires_identity")
    public Optional<Boolean> getRequiresIdentity() {
        return requiresIdentity;
    }

    @JsonProperty("supports_field_sync_mode")
    public Optional<Boolean> getSupportsFieldSyncMode() {
        return supportsFieldSyncMode;
    }

    @JsonProperty("supports_target_filters")
    public Optional<Boolean> getSupportsTargetFilters() {
        return supportsTargetFilters;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2Mode && equalTo((V2Mode) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2Mode other) {
        return description.equals(other.description)
                && label.equals(other.label)
                && mode.equals(other.mode)
                && requiresIdentity.equals(other.requiresIdentity)
                && supportsFieldSyncMode.equals(other.supportsFieldSyncMode)
                && supportsTargetFilters.equals(other.supportsTargetFilters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.description,
                this.label,
                this.mode,
                this.requiresIdentity,
                this.supportsFieldSyncMode,
                this.supportsTargetFilters);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> description = Optional.empty();

        private Optional<String> label = Optional.empty();

        private Optional<String> mode = Optional.empty();

        private Optional<Boolean> requiresIdentity = Optional.empty();

        private Optional<Boolean> supportsFieldSyncMode = Optional.empty();

        private Optional<Boolean> supportsTargetFilters = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2Mode other) {
            description(other.getDescription());
            label(other.getLabel());
            mode(other.getMode());
            requiresIdentity(other.getRequiresIdentity());
            supportsFieldSyncMode(other.getSupportsFieldSyncMode());
            supportsTargetFilters(other.getSupportsTargetFilters());
            return this;
        }

        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public Builder description(Optional<String> description) {
            this.description = description;
            return this;
        }

        public Builder description(String description) {
            this.description = Optional.of(description);
            return this;
        }

        @JsonSetter(value = "label", nulls = Nulls.SKIP)
        public Builder label(Optional<String> label) {
            this.label = label;
            return this;
        }

        public Builder label(String label) {
            this.label = Optional.of(label);
            return this;
        }

        @JsonSetter(value = "mode", nulls = Nulls.SKIP)
        public Builder mode(Optional<String> mode) {
            this.mode = mode;
            return this;
        }

        public Builder mode(String mode) {
            this.mode = Optional.of(mode);
            return this;
        }

        @JsonSetter(value = "requires_identity", nulls = Nulls.SKIP)
        public Builder requiresIdentity(Optional<Boolean> requiresIdentity) {
            this.requiresIdentity = requiresIdentity;
            return this;
        }

        public Builder requiresIdentity(Boolean requiresIdentity) {
            this.requiresIdentity = Optional.of(requiresIdentity);
            return this;
        }

        @JsonSetter(value = "supports_field_sync_mode", nulls = Nulls.SKIP)
        public Builder supportsFieldSyncMode(Optional<Boolean> supportsFieldSyncMode) {
            this.supportsFieldSyncMode = supportsFieldSyncMode;
            return this;
        }

        public Builder supportsFieldSyncMode(Boolean supportsFieldSyncMode) {
            this.supportsFieldSyncMode = Optional.of(supportsFieldSyncMode);
            return this;
        }

        @JsonSetter(value = "supports_target_filters", nulls = Nulls.SKIP)
        public Builder supportsTargetFilters(Optional<Boolean> supportsTargetFilters) {
            this.supportsTargetFilters = supportsTargetFilters;
            return this;
        }

        public Builder supportsTargetFilters(Boolean supportsTargetFilters) {
            this.supportsTargetFilters = Optional.of(supportsTargetFilters);
            return this;
        }

        public V2Mode build() {
            return new V2Mode(
                    description,
                    label,
                    mode,
                    requiresIdentity,
                    supportsFieldSyncMode,
                    supportsTargetFilters,
                    additionalProperties);
        }
    }
}
