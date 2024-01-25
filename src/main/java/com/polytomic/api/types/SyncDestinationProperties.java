
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
@JsonDeserialize(builder = SyncDestinationProperties.Builder.class)
public final class SyncDestinationProperties {
    private final Optional<Boolean> doesNotReportOperationCounts;

    private final Optional<String> newTargetLabel;

    private final Optional<Boolean> optionalTargetMappings;

    private final Optional<String> primaryMetadataObject;

    private final Optional<Boolean> requiresConfiguration;

    private final Optional<Boolean> supportsFieldCreation;

    private final Optional<Boolean> supportsFieldTypeSelection;

    private final Optional<Boolean> supportsTargetFilters;

    private final Optional<Boolean> targetCreator;

    private final Optional<Boolean> useFieldNamesAsLabels;

    private final Map<String, Object> additionalProperties;

    private SyncDestinationProperties(
            Optional<Boolean> doesNotReportOperationCounts,
            Optional<String> newTargetLabel,
            Optional<Boolean> optionalTargetMappings,
            Optional<String> primaryMetadataObject,
            Optional<Boolean> requiresConfiguration,
            Optional<Boolean> supportsFieldCreation,
            Optional<Boolean> supportsFieldTypeSelection,
            Optional<Boolean> supportsTargetFilters,
            Optional<Boolean> targetCreator,
            Optional<Boolean> useFieldNamesAsLabels,
            Map<String, Object> additionalProperties) {
        this.doesNotReportOperationCounts = doesNotReportOperationCounts;
        this.newTargetLabel = newTargetLabel;
        this.optionalTargetMappings = optionalTargetMappings;
        this.primaryMetadataObject = primaryMetadataObject;
        this.requiresConfiguration = requiresConfiguration;
        this.supportsFieldCreation = supportsFieldCreation;
        this.supportsFieldTypeSelection = supportsFieldTypeSelection;
        this.supportsTargetFilters = supportsTargetFilters;
        this.targetCreator = targetCreator;
        this.useFieldNamesAsLabels = useFieldNamesAsLabels;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("does_not_report_operation_counts")
    public Optional<Boolean> getDoesNotReportOperationCounts() {
        return doesNotReportOperationCounts;
    }

    @JsonProperty("new_target_label")
    public Optional<String> getNewTargetLabel() {
        return newTargetLabel;
    }

    @JsonProperty("optional_target_mappings")
    public Optional<Boolean> getOptionalTargetMappings() {
        return optionalTargetMappings;
    }

    @JsonProperty("primary_metadata_object")
    public Optional<String> getPrimaryMetadataObject() {
        return primaryMetadataObject;
    }

    @JsonProperty("requires_configuration")
    public Optional<Boolean> getRequiresConfiguration() {
        return requiresConfiguration;
    }

    @JsonProperty("supports_field_creation")
    public Optional<Boolean> getSupportsFieldCreation() {
        return supportsFieldCreation;
    }

    @JsonProperty("supports_field_type_selection")
    public Optional<Boolean> getSupportsFieldTypeSelection() {
        return supportsFieldTypeSelection;
    }

    @JsonProperty("supports_target_filters")
    public Optional<Boolean> getSupportsTargetFilters() {
        return supportsTargetFilters;
    }

    @JsonProperty("target_creator")
    public Optional<Boolean> getTargetCreator() {
        return targetCreator;
    }

    @JsonProperty("use_field_names_as_labels")
    public Optional<Boolean> getUseFieldNamesAsLabels() {
        return useFieldNamesAsLabels;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SyncDestinationProperties && equalTo((SyncDestinationProperties) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SyncDestinationProperties other) {
        return doesNotReportOperationCounts.equals(other.doesNotReportOperationCounts)
                && newTargetLabel.equals(other.newTargetLabel)
                && optionalTargetMappings.equals(other.optionalTargetMappings)
                && primaryMetadataObject.equals(other.primaryMetadataObject)
                && requiresConfiguration.equals(other.requiresConfiguration)
                && supportsFieldCreation.equals(other.supportsFieldCreation)
                && supportsFieldTypeSelection.equals(other.supportsFieldTypeSelection)
                && supportsTargetFilters.equals(other.supportsTargetFilters)
                && targetCreator.equals(other.targetCreator)
                && useFieldNamesAsLabels.equals(other.useFieldNamesAsLabels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.doesNotReportOperationCounts,
                this.newTargetLabel,
                this.optionalTargetMappings,
                this.primaryMetadataObject,
                this.requiresConfiguration,
                this.supportsFieldCreation,
                this.supportsFieldTypeSelection,
                this.supportsTargetFilters,
                this.targetCreator,
                this.useFieldNamesAsLabels);
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
        private Optional<Boolean> doesNotReportOperationCounts = Optional.empty();

        private Optional<String> newTargetLabel = Optional.empty();

        private Optional<Boolean> optionalTargetMappings = Optional.empty();

        private Optional<String> primaryMetadataObject = Optional.empty();

        private Optional<Boolean> requiresConfiguration = Optional.empty();

        private Optional<Boolean> supportsFieldCreation = Optional.empty();

        private Optional<Boolean> supportsFieldTypeSelection = Optional.empty();

        private Optional<Boolean> supportsTargetFilters = Optional.empty();

        private Optional<Boolean> targetCreator = Optional.empty();

        private Optional<Boolean> useFieldNamesAsLabels = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(SyncDestinationProperties other) {
            doesNotReportOperationCounts(other.getDoesNotReportOperationCounts());
            newTargetLabel(other.getNewTargetLabel());
            optionalTargetMappings(other.getOptionalTargetMappings());
            primaryMetadataObject(other.getPrimaryMetadataObject());
            requiresConfiguration(other.getRequiresConfiguration());
            supportsFieldCreation(other.getSupportsFieldCreation());
            supportsFieldTypeSelection(other.getSupportsFieldTypeSelection());
            supportsTargetFilters(other.getSupportsTargetFilters());
            targetCreator(other.getTargetCreator());
            useFieldNamesAsLabels(other.getUseFieldNamesAsLabels());
            return this;
        }

        @JsonSetter(value = "does_not_report_operation_counts", nulls = Nulls.SKIP)
        public Builder doesNotReportOperationCounts(Optional<Boolean> doesNotReportOperationCounts) {
            this.doesNotReportOperationCounts = doesNotReportOperationCounts;
            return this;
        }

        public Builder doesNotReportOperationCounts(Boolean doesNotReportOperationCounts) {
            this.doesNotReportOperationCounts = Optional.of(doesNotReportOperationCounts);
            return this;
        }

        @JsonSetter(value = "new_target_label", nulls = Nulls.SKIP)
        public Builder newTargetLabel(Optional<String> newTargetLabel) {
            this.newTargetLabel = newTargetLabel;
            return this;
        }

        public Builder newTargetLabel(String newTargetLabel) {
            this.newTargetLabel = Optional.of(newTargetLabel);
            return this;
        }

        @JsonSetter(value = "optional_target_mappings", nulls = Nulls.SKIP)
        public Builder optionalTargetMappings(Optional<Boolean> optionalTargetMappings) {
            this.optionalTargetMappings = optionalTargetMappings;
            return this;
        }

        public Builder optionalTargetMappings(Boolean optionalTargetMappings) {
            this.optionalTargetMappings = Optional.of(optionalTargetMappings);
            return this;
        }

        @JsonSetter(value = "primary_metadata_object", nulls = Nulls.SKIP)
        public Builder primaryMetadataObject(Optional<String> primaryMetadataObject) {
            this.primaryMetadataObject = primaryMetadataObject;
            return this;
        }

        public Builder primaryMetadataObject(String primaryMetadataObject) {
            this.primaryMetadataObject = Optional.of(primaryMetadataObject);
            return this;
        }

        @JsonSetter(value = "requires_configuration", nulls = Nulls.SKIP)
        public Builder requiresConfiguration(Optional<Boolean> requiresConfiguration) {
            this.requiresConfiguration = requiresConfiguration;
            return this;
        }

        public Builder requiresConfiguration(Boolean requiresConfiguration) {
            this.requiresConfiguration = Optional.of(requiresConfiguration);
            return this;
        }

        @JsonSetter(value = "supports_field_creation", nulls = Nulls.SKIP)
        public Builder supportsFieldCreation(Optional<Boolean> supportsFieldCreation) {
            this.supportsFieldCreation = supportsFieldCreation;
            return this;
        }

        public Builder supportsFieldCreation(Boolean supportsFieldCreation) {
            this.supportsFieldCreation = Optional.of(supportsFieldCreation);
            return this;
        }

        @JsonSetter(value = "supports_field_type_selection", nulls = Nulls.SKIP)
        public Builder supportsFieldTypeSelection(Optional<Boolean> supportsFieldTypeSelection) {
            this.supportsFieldTypeSelection = supportsFieldTypeSelection;
            return this;
        }

        public Builder supportsFieldTypeSelection(Boolean supportsFieldTypeSelection) {
            this.supportsFieldTypeSelection = Optional.of(supportsFieldTypeSelection);
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

        @JsonSetter(value = "target_creator", nulls = Nulls.SKIP)
        public Builder targetCreator(Optional<Boolean> targetCreator) {
            this.targetCreator = targetCreator;
            return this;
        }

        public Builder targetCreator(Boolean targetCreator) {
            this.targetCreator = Optional.of(targetCreator);
            return this;
        }

        @JsonSetter(value = "use_field_names_as_labels", nulls = Nulls.SKIP)
        public Builder useFieldNamesAsLabels(Optional<Boolean> useFieldNamesAsLabels) {
            this.useFieldNamesAsLabels = useFieldNamesAsLabels;
            return this;
        }

        public Builder useFieldNamesAsLabels(Boolean useFieldNamesAsLabels) {
            this.useFieldNamesAsLabels = Optional.of(useFieldNamesAsLabels);
            return this;
        }

        public SyncDestinationProperties build() {
            return new SyncDestinationProperties(
                    doesNotReportOperationCounts,
                    newTargetLabel,
                    optionalTargetMappings,
                    primaryMetadataObject,
                    requiresConfiguration,
                    supportsFieldCreation,
                    supportsFieldTypeSelection,
                    supportsTargetFilters,
                    targetCreator,
                    useFieldNamesAsLabels,
                    additionalProperties);
        }
    }
}
