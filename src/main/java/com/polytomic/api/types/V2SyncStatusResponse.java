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
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = V2SyncStatusResponse.Builder.class)
public final class V2SyncStatusResponse {
    private final Optional<V2GetExecutionResponseSchema> currentExecution;

    private final Optional<V2GetExecutionResponseSchema> lastExecution;

    private final Optional<OffsetDateTime> nextExecutionTime;

    private final Map<String, Object> additionalProperties;

    private V2SyncStatusResponse(
            Optional<V2GetExecutionResponseSchema> currentExecution,
            Optional<V2GetExecutionResponseSchema> lastExecution,
            Optional<OffsetDateTime> nextExecutionTime,
            Map<String, Object> additionalProperties) {
        this.currentExecution = currentExecution;
        this.lastExecution = lastExecution;
        this.nextExecutionTime = nextExecutionTime;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("current_execution")
    public Optional<V2GetExecutionResponseSchema> getCurrentExecution() {
        return currentExecution;
    }

    @JsonProperty("last_execution")
    public Optional<V2GetExecutionResponseSchema> getLastExecution() {
        return lastExecution;
    }

    @JsonProperty("next_execution_time")
    public Optional<OffsetDateTime> getNextExecutionTime() {
        return nextExecutionTime;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2SyncStatusResponse && equalTo((V2SyncStatusResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2SyncStatusResponse other) {
        return currentExecution.equals(other.currentExecution)
                && lastExecution.equals(other.lastExecution)
                && nextExecutionTime.equals(other.nextExecutionTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.currentExecution, this.lastExecution, this.nextExecutionTime);
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
        private Optional<V2GetExecutionResponseSchema> currentExecution = Optional.empty();

        private Optional<V2GetExecutionResponseSchema> lastExecution = Optional.empty();

        private Optional<OffsetDateTime> nextExecutionTime = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V2SyncStatusResponse other) {
            currentExecution(other.getCurrentExecution());
            lastExecution(other.getLastExecution());
            nextExecutionTime(other.getNextExecutionTime());
            return this;
        }

        @JsonSetter(value = "current_execution", nulls = Nulls.SKIP)
        public Builder currentExecution(Optional<V2GetExecutionResponseSchema> currentExecution) {
            this.currentExecution = currentExecution;
            return this;
        }

        public Builder currentExecution(V2GetExecutionResponseSchema currentExecution) {
            this.currentExecution = Optional.of(currentExecution);
            return this;
        }

        @JsonSetter(value = "last_execution", nulls = Nulls.SKIP)
        public Builder lastExecution(Optional<V2GetExecutionResponseSchema> lastExecution) {
            this.lastExecution = lastExecution;
            return this;
        }

        public Builder lastExecution(V2GetExecutionResponseSchema lastExecution) {
            this.lastExecution = Optional.of(lastExecution);
            return this;
        }

        @JsonSetter(value = "next_execution_time", nulls = Nulls.SKIP)
        public Builder nextExecutionTime(Optional<OffsetDateTime> nextExecutionTime) {
            this.nextExecutionTime = nextExecutionTime;
            return this;
        }

        public Builder nextExecutionTime(OffsetDateTime nextExecutionTime) {
            this.nextExecutionTime = Optional.of(nextExecutionTime);
            return this;
        }

        public V2SyncStatusResponse build() {
            return new V2SyncStatusResponse(currentExecution, lastExecution, nextExecutionTime, additionalProperties);
        }
    }
}
