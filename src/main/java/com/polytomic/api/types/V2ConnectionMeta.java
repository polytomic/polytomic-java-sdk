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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = V2ConnectionMeta.Builder.class)
public final class V2ConnectionMeta {
    private final Optional<Boolean> hasItems;

    private final Optional<List<Object>> items;

    private final Optional<List<String>> requiresOneOf;

    private final Map<String, Object> additionalProperties;

    private V2ConnectionMeta(
            Optional<Boolean> hasItems,
            Optional<List<Object>> items,
            Optional<List<String>> requiresOneOf,
            Map<String, Object> additionalProperties) {
        this.hasItems = hasItems;
        this.items = items;
        this.requiresOneOf = requiresOneOf;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("has_items")
    public Optional<Boolean> getHasItems() {
        return hasItems;
    }

    @JsonProperty("items")
    public Optional<List<Object>> getItems() {
        return items;
    }

    @JsonProperty("requires_one_of")
    public Optional<List<String>> getRequiresOneOf() {
        return requiresOneOf;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2ConnectionMeta && equalTo((V2ConnectionMeta) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2ConnectionMeta other) {
        return hasItems.equals(other.hasItems)
                && items.equals(other.items)
                && requiresOneOf.equals(other.requiresOneOf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.hasItems, this.items, this.requiresOneOf);
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
        private Optional<Boolean> hasItems = Optional.empty();

        private Optional<List<Object>> items = Optional.empty();

        private Optional<List<String>> requiresOneOf = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2ConnectionMeta other) {
            hasItems(other.getHasItems());
            items(other.getItems());
            requiresOneOf(other.getRequiresOneOf());
            return this;
        }

        @JsonSetter(value = "has_items", nulls = Nulls.SKIP)
        public Builder hasItems(Optional<Boolean> hasItems) {
            this.hasItems = hasItems;
            return this;
        }

        public Builder hasItems(Boolean hasItems) {
            this.hasItems = Optional.of(hasItems);
            return this;
        }

        @JsonSetter(value = "items", nulls = Nulls.SKIP)
        public Builder items(Optional<List<Object>> items) {
            this.items = items;
            return this;
        }

        public Builder items(List<Object> items) {
            this.items = Optional.of(items);
            return this;
        }

        @JsonSetter(value = "requires_one_of", nulls = Nulls.SKIP)
        public Builder requiresOneOf(Optional<List<String>> requiresOneOf) {
            this.requiresOneOf = requiresOneOf;
            return this;
        }

        public Builder requiresOneOf(List<String> requiresOneOf) {
            this.requiresOneOf = Optional.of(requiresOneOf);
            return this;
        }

        public V2ConnectionMeta build() {
            return new V2ConnectionMeta(hasItems, items, requiresOneOf, additionalProperties);
        }
    }
}
