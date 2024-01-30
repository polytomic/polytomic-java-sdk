package com.polytomic.api.resources.modelsync.types;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Override;
import java.lang.String;

public enum V2CreateSyncRequestMode {
  UPDATE("update"),

  UPDATE_OR_CREATE("updateOrCreate"),

  CREATE("create"),

  REPLACE("replace"),

  APPEND("append"),

  SNAPSHOT("snapshot");

  private final String value;

  V2CreateSyncRequestMode(String value) {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }
}