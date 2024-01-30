package com.polytomic.api.resources.bulksync.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.types.BulkSchedule;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = V2CreateBulkSyncRequest.Builder.class
)
public final class V2CreateBulkSyncRequest {
  private final Optional<Boolean> active;

  private final Optional<Map<String, Object>> destinationConfiguration;

  private final String destinationConnectionId;

  private final Optional<Boolean> discover;

  private final String mode;

  private final String name;

  private final Optional<String> organizationId;

  private final Optional<List<String>> policies;

  private final BulkSchedule schedule;

  private final Optional<List<String>> schemas;

  private final Optional<Map<String, Object>> sourceConfiguration;

  private final String sourceConnectionId;

  private final Map<String, Object> additionalProperties;

  private V2CreateBulkSyncRequest(Optional<Boolean> active,
      Optional<Map<String, Object>> destinationConfiguration, String destinationConnectionId,
      Optional<Boolean> discover, String mode, String name, Optional<String> organizationId,
      Optional<List<String>> policies, BulkSchedule schedule, Optional<List<String>> schemas,
      Optional<Map<String, Object>> sourceConfiguration, String sourceConnectionId,
      Map<String, Object> additionalProperties) {
    this.active = active;
    this.destinationConfiguration = destinationConfiguration;
    this.destinationConnectionId = destinationConnectionId;
    this.discover = discover;
    this.mode = mode;
    this.name = name;
    this.organizationId = organizationId;
    this.policies = policies;
    this.schedule = schedule;
    this.schemas = schemas;
    this.sourceConfiguration = sourceConfiguration;
    this.sourceConnectionId = sourceConnectionId;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("active")
  public Optional<Boolean> getActive() {
    return active;
  }

  @JsonProperty("destination_configuration")
  public Optional<Map<String, Object>> getDestinationConfiguration() {
    return destinationConfiguration;
  }

  @JsonProperty("destination_connection_id")
  public String getDestinationConnectionId() {
    return destinationConnectionId;
  }

  @JsonProperty("discover")
  public Optional<Boolean> getDiscover() {
    return discover;
  }

  @JsonProperty("mode")
  public String getMode() {
    return mode;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("organization_id")
  public Optional<String> getOrganizationId() {
    return organizationId;
  }

  @JsonProperty("policies")
  public Optional<List<String>> getPolicies() {
    return policies;
  }

  @JsonProperty("schedule")
  public BulkSchedule getSchedule() {
    return schedule;
  }

  @JsonProperty("schemas")
  public Optional<List<String>> getSchemas() {
    return schemas;
  }

  @JsonProperty("source_configuration")
  public Optional<Map<String, Object>> getSourceConfiguration() {
    return sourceConfiguration;
  }

  @JsonProperty("source_connection_id")
  public String getSourceConnectionId() {
    return sourceConnectionId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof V2CreateBulkSyncRequest && equalTo((V2CreateBulkSyncRequest) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(V2CreateBulkSyncRequest other) {
    return active.equals(other.active) && destinationConfiguration.equals(other.destinationConfiguration) && destinationConnectionId.equals(other.destinationConnectionId) && discover.equals(other.discover) && mode.equals(other.mode) && name.equals(other.name) && organizationId.equals(other.organizationId) && policies.equals(other.policies) && schedule.equals(other.schedule) && schemas.equals(other.schemas) && sourceConfiguration.equals(other.sourceConfiguration) && sourceConnectionId.equals(other.sourceConnectionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.active, this.destinationConfiguration, this.destinationConnectionId, this.discover, this.mode, this.name, this.organizationId, this.policies, this.schedule, this.schemas, this.sourceConfiguration, this.sourceConnectionId);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static DestinationConnectionIdStage builder() {
    return new Builder();
  }

  public interface DestinationConnectionIdStage {
    ModeStage destinationConnectionId(String destinationConnectionId);

    Builder from(V2CreateBulkSyncRequest other);
  }

  public interface ModeStage {
    NameStage mode(String mode);
  }

  public interface NameStage {
    ScheduleStage name(String name);
  }

  public interface ScheduleStage {
    SourceConnectionIdStage schedule(BulkSchedule schedule);
  }

  public interface SourceConnectionIdStage {
    _FinalStage sourceConnectionId(String sourceConnectionId);
  }

  public interface _FinalStage {
    V2CreateBulkSyncRequest build();

    _FinalStage active(Optional<Boolean> active);

    _FinalStage active(Boolean active);

    _FinalStage destinationConfiguration(Optional<Map<String, Object>> destinationConfiguration);

    _FinalStage destinationConfiguration(Map<String, Object> destinationConfiguration);

    _FinalStage discover(Optional<Boolean> discover);

    _FinalStage discover(Boolean discover);

    _FinalStage organizationId(Optional<String> organizationId);

    _FinalStage organizationId(String organizationId);

    _FinalStage policies(Optional<List<String>> policies);

    _FinalStage policies(List<String> policies);

    _FinalStage schemas(Optional<List<String>> schemas);

    _FinalStage schemas(List<String> schemas);

    _FinalStage sourceConfiguration(Optional<Map<String, Object>> sourceConfiguration);

    _FinalStage sourceConfiguration(Map<String, Object> sourceConfiguration);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements DestinationConnectionIdStage, ModeStage, NameStage, ScheduleStage, SourceConnectionIdStage, _FinalStage {
    private String destinationConnectionId;

    private String mode;

    private String name;

    private BulkSchedule schedule;

    private String sourceConnectionId;

    private Optional<Map<String, Object>> sourceConfiguration = Optional.empty();

    private Optional<List<String>> schemas = Optional.empty();

    private Optional<List<String>> policies = Optional.empty();

    private Optional<String> organizationId = Optional.empty();

    private Optional<Boolean> discover = Optional.empty();

    private Optional<Map<String, Object>> destinationConfiguration = Optional.empty();

    private Optional<Boolean> active = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(V2CreateBulkSyncRequest other) {
      active(other.getActive());
      destinationConfiguration(other.getDestinationConfiguration());
      destinationConnectionId(other.getDestinationConnectionId());
      discover(other.getDiscover());
      mode(other.getMode());
      name(other.getName());
      organizationId(other.getOrganizationId());
      policies(other.getPolicies());
      schedule(other.getSchedule());
      schemas(other.getSchemas());
      sourceConfiguration(other.getSourceConfiguration());
      sourceConnectionId(other.getSourceConnectionId());
      return this;
    }

    @Override
    @JsonSetter("destination_connection_id")
    public ModeStage destinationConnectionId(String destinationConnectionId) {
      this.destinationConnectionId = destinationConnectionId;
      return this;
    }

    @Override
    @JsonSetter("mode")
    public NameStage mode(String mode) {
      this.mode = mode;
      return this;
    }

    @Override
    @JsonSetter("name")
    public ScheduleStage name(String name) {
      this.name = name;
      return this;
    }

    @Override
    @JsonSetter("schedule")
    public SourceConnectionIdStage schedule(BulkSchedule schedule) {
      this.schedule = schedule;
      return this;
    }

    @Override
    @JsonSetter("source_connection_id")
    public _FinalStage sourceConnectionId(String sourceConnectionId) {
      this.sourceConnectionId = sourceConnectionId;
      return this;
    }

    @Override
    public _FinalStage sourceConfiguration(Map<String, Object> sourceConfiguration) {
      this.sourceConfiguration = Optional.of(sourceConfiguration);
      return this;
    }

    @Override
    @JsonSetter(
        value = "source_configuration",
        nulls = Nulls.SKIP
    )
    public _FinalStage sourceConfiguration(Optional<Map<String, Object>> sourceConfiguration) {
      this.sourceConfiguration = sourceConfiguration;
      return this;
    }

    @Override
    public _FinalStage schemas(List<String> schemas) {
      this.schemas = Optional.of(schemas);
      return this;
    }

    @Override
    @JsonSetter(
        value = "schemas",
        nulls = Nulls.SKIP
    )
    public _FinalStage schemas(Optional<List<String>> schemas) {
      this.schemas = schemas;
      return this;
    }

    @Override
    public _FinalStage policies(List<String> policies) {
      this.policies = Optional.of(policies);
      return this;
    }

    @Override
    @JsonSetter(
        value = "policies",
        nulls = Nulls.SKIP
    )
    public _FinalStage policies(Optional<List<String>> policies) {
      this.policies = policies;
      return this;
    }

    @Override
    public _FinalStage organizationId(String organizationId) {
      this.organizationId = Optional.of(organizationId);
      return this;
    }

    @Override
    @JsonSetter(
        value = "organization_id",
        nulls = Nulls.SKIP
    )
    public _FinalStage organizationId(Optional<String> organizationId) {
      this.organizationId = organizationId;
      return this;
    }

    @Override
    public _FinalStage discover(Boolean discover) {
      this.discover = Optional.of(discover);
      return this;
    }

    @Override
    @JsonSetter(
        value = "discover",
        nulls = Nulls.SKIP
    )
    public _FinalStage discover(Optional<Boolean> discover) {
      this.discover = discover;
      return this;
    }

    @Override
    public _FinalStage destinationConfiguration(Map<String, Object> destinationConfiguration) {
      this.destinationConfiguration = Optional.of(destinationConfiguration);
      return this;
    }

    @Override
    @JsonSetter(
        value = "destination_configuration",
        nulls = Nulls.SKIP
    )
    public _FinalStage destinationConfiguration(
        Optional<Map<String, Object>> destinationConfiguration) {
      this.destinationConfiguration = destinationConfiguration;
      return this;
    }

    @Override
    public _FinalStage active(Boolean active) {
      this.active = Optional.of(active);
      return this;
    }

    @Override
    @JsonSetter(
        value = "active",
        nulls = Nulls.SKIP
    )
    public _FinalStage active(Optional<Boolean> active) {
      this.active = active;
      return this;
    }

    @Override
    public V2CreateBulkSyncRequest build() {
      return new V2CreateBulkSyncRequest(active, destinationConfiguration, destinationConnectionId, discover, mode, name, organizationId, policies, schedule, schemas, sourceConfiguration, sourceConnectionId, additionalProperties);
    }
  }
}
