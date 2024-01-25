
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
@JsonDeserialize(builder = V2PolicyAction.Builder.class)
public final class V2PolicyAction {
    private final String action;

    private final Optional<List<String>> roleIds;

    private final Map<String, Object> additionalProperties;

    private V2PolicyAction(String action, Optional<List<String>> roleIds, Map<String, Object> additionalProperties) {
        this.action = action;
        this.roleIds = roleIds;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    @JsonProperty("role_ids")
    public Optional<List<String>> getRoleIds() {
        return roleIds;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2PolicyAction && equalTo((V2PolicyAction) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V2PolicyAction other) {
        return action.equals(other.action) && roleIds.equals(other.roleIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.action, this.roleIds);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ActionStage builder() {
        return new Builder();
    }

    public interface ActionStage {
        _FinalStage action(String action);

        Builder from(V2PolicyAction other);
    }

    public interface _FinalStage {
        V2PolicyAction build();

        _FinalStage roleIds(Optional<List<String>> roleIds);

        _FinalStage roleIds(List<String> roleIds);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ActionStage, _FinalStage {
        private String action;

        private Optional<List<String>> roleIds = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(V2PolicyAction other) {
            action(other.getAction());
            roleIds(other.getRoleIds());
            return this;
        }

        @Override
        @JsonSetter("action")
        public _FinalStage action(String action) {
            this.action = action;
            return this;
        }

        @Override
        public _FinalStage roleIds(List<String> roleIds) {
            this.roleIds = Optional.of(roleIds);
            return this;
        }

        @Override
        @JsonSetter(value = "role_ids", nulls = Nulls.SKIP)
        public _FinalStage roleIds(Optional<List<String>> roleIds) {
            this.roleIds = roleIds;
            return this;
        }

        @Override
        public V2PolicyAction build() {
            return new V2PolicyAction(action, roleIds, additionalProperties);
        }
    }
}
