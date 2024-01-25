
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
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = V2Event.Builder.class)
public final class V2Event {
    private final Optional<OffsetDateTime> createdAt;

    private final Optional<Object> event;

    private final Optional<String> id;

    private final Optional<String> organizationId;

    private final Optional<String> type;

    private final Map<String, Object> additionalProperties;

    private V2Event(
            Optional<OffsetDateTime> createdAt,
            Optional<Object> event,
            Optional<String> id,
            Optional<String> organizationId,
            Optional<String> type,
            Map<String, Object> additionalProperties) {
        this.createdAt = createdAt;
        this.event = event;
        this.id = id;
        this.organizationId = organizationId;
        this.type = type;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("created_at")
    public Optional<OffsetDateTime> getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("event")
    public Optional<Object> getEvent() {
        return event;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("organization_id")
    public Optional<String> getOrganizationId() {
        return organizationId;
    }

    @JsonProperty("type")
    public Optional<String> getType() {
        return type;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2Event && equalTo((V2Event) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2Event other) {
        return createdAt.equals(other.createdAt)
                && event.equals(other.event)
                && id.equals(other.id)
                && organizationId.equals(other.organizationId)
                && type.equals(other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.createdAt, this.event, this.id, this.organizationId, this.type);
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
        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<Object> event = Optional.empty();

        private Optional<String> id = Optional.empty();

        private Optional<String> organizationId = Optional.empty();

        private Optional<String> type = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2Event other) {
            createdAt(other.getCreatedAt());
            event(other.getEvent());
            id(other.getId());
            organizationId(other.getOrganizationId());
            type(other.getType());
            return this;
        }

        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public Builder createdAt(Optional<OffsetDateTime> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = Optional.of(createdAt);
            return this;
        }

        @JsonSetter(value = "event", nulls = Nulls.SKIP)
        public Builder event(Optional<Object> event) {
            this.event = event;
            return this;
        }

        public Builder event(Object event) {
            this.event = Optional.of(event);
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

        @JsonSetter(value = "organization_id", nulls = Nulls.SKIP)
        public Builder organizationId(Optional<String> organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        public Builder organizationId(String organizationId) {
            this.organizationId = Optional.of(organizationId);
            return this;
        }

        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<String> type) {
            this.type = type;
            return this;
        }

        public Builder type(String type) {
            this.type = Optional.of(type);
            return this;
        }

        public V2Event build() {
            return new V2Event(createdAt, event, id, organizationId, type, additionalProperties);
        }
    }
}
