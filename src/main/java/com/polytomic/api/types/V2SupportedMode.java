
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
@JsonDeserialize(builder = V2SupportedMode.Builder.class)
public final class V2SupportedMode {
    private final Optional<String> description;

    private final Optional<String> id;

    private final Optional<String> label;

    private final Optional<Boolean> requiresIdentity;

    private final Optional<Boolean> supportsFieldSyncMode;

    private final Optional<Boolean> supportsTargetFilters;

    private final Map<String, Object> additionalProperties;

    private V2SupportedMode(
            Optional<String> description,
            Optional<String> id,
            Optional<String> label,
            Optional<Boolean> requiresIdentity,
            Optional<Boolean> supportsFieldSyncMode,
            Optional<Boolean> supportsTargetFilters,
            Map<String, Object> additionalProperties) {
        this.description = description;
        this.id = id;
        this.label = label;
        this.requiresIdentity = requiresIdentity;
        this.supportsFieldSyncMode = supportsFieldSyncMode;
        this.supportsTargetFilters = supportsTargetFilters;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    /**
     * @return
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("label")
    public Optional<String> getLabel() {
        return label;
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
        return other instanceof V2SupportedMode && equalTo((V2SupportedMode) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2SupportedMode other) {
        return description.equals(other.description)
                && id.equals(other.id)
                && label.equals(other.label)
                && requiresIdentity.equals(other.requiresIdentity)
                && supportsFieldSyncMode.equals(other.supportsFieldSyncMode)
                && supportsTargetFilters.equals(other.supportsTargetFilters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.description,
                this.id,
                this.label,
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

        private Optional<String> id = Optional.empty();

        private Optional<String> label = Optional.empty();

        private Optional<Boolean> requiresIdentity = Optional.empty();

        private Optional<Boolean> supportsFieldSyncMode = Optional.empty();

        private Optional<Boolean> supportsTargetFilters = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2SupportedMode other) {
            description(other.getDescription());
            id(other.getId());
            label(other.getLabel());
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

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
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

        public V2SupportedMode build() {
            return new V2SupportedMode(
                    description,
                    id,
                    label,
                    requiresIdentity,
                    supportsFieldSyncMode,
                    supportsTargetFilters,
                    additionalProperties);
        }
    }
}
