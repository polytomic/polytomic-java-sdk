
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
@JsonDeserialize(builder = BulkSchedule.Builder.class)
public final class BulkSchedule {
    private final Optional<String> dayOfMonth;

    private final Optional<String> dayOfWeek;

    private final String frequency;

    private final Optional<String> hour;

    private final Optional<String> minute;

    private final Optional<String> month;

    private final Map<String, Object> additionalProperties;

    private BulkSchedule(
            Optional<String> dayOfMonth,
            Optional<String> dayOfWeek,
            String frequency,
            Optional<String> hour,
            Optional<String> minute,
            Optional<String> month,
            Map<String, Object> additionalProperties) {
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
        this.frequency = frequency;
        this.hour = hour;
        this.minute = minute;
        this.month = month;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("day_of_month")
    public Optional<String> getDayOfMonth() {
        return dayOfMonth;
    }

    @JsonProperty("day_of_week")
    public Optional<String> getDayOfWeek() {
        return dayOfWeek;
    }

    @JsonProperty("frequency")
    public String getFrequency() {
        return frequency;
    }

    @JsonProperty("hour")
    public Optional<String> getHour() {
        return hour;
    }

    @JsonProperty("minute")
    public Optional<String> getMinute() {
        return minute;
    }

    @JsonProperty("month")
    public Optional<String> getMonth() {
        return month;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BulkSchedule && equalTo((BulkSchedule) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(BulkSchedule other) {
        return dayOfMonth.equals(other.dayOfMonth)
                && dayOfWeek.equals(other.dayOfWeek)
                && frequency.equals(other.frequency)
                && hour.equals(other.hour)
                && minute.equals(other.minute)
                && month.equals(other.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.dayOfMonth, this.dayOfWeek, this.frequency, this.hour, this.minute, this.month);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static FrequencyStage builder() {
        return new Builder();
    }

    public interface FrequencyStage {
        _FinalStage frequency(String frequency);

        Builder from(BulkSchedule other);
    }

    public interface _FinalStage {
        BulkSchedule build();

        _FinalStage dayOfMonth(Optional<String> dayOfMonth);

        _FinalStage dayOfMonth(String dayOfMonth);

        _FinalStage dayOfWeek(Optional<String> dayOfWeek);

        _FinalStage dayOfWeek(String dayOfWeek);

        _FinalStage hour(Optional<String> hour);

        _FinalStage hour(String hour);

        _FinalStage minute(Optional<String> minute);

        _FinalStage minute(String minute);

        _FinalStage month(Optional<String> month);

        _FinalStage month(String month);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements FrequencyStage, _FinalStage {
        private String frequency;

        private Optional<String> month = Optional.empty();

        private Optional<String> minute = Optional.empty();

        private Optional<String> hour = Optional.empty();

        private Optional<String> dayOfWeek = Optional.empty();

        private Optional<String> dayOfMonth = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(BulkSchedule other) {
            dayOfMonth(other.getDayOfMonth());
            dayOfWeek(other.getDayOfWeek());
            frequency(other.getFrequency());
            hour(other.getHour());
            minute(other.getMinute());
            month(other.getMonth());
            return this;
        }

        @Override
        @JsonSetter("frequency")
        public _FinalStage frequency(String frequency) {
            this.frequency = frequency;
            return this;
        }

        @Override
        public _FinalStage month(String month) {
            this.month = Optional.of(month);
            return this;
        }

        @Override
        @JsonSetter(value = "month", nulls = Nulls.SKIP)
        public _FinalStage month(Optional<String> month) {
            this.month = month;
            return this;
        }

        @Override
        public _FinalStage minute(String minute) {
            this.minute = Optional.of(minute);
            return this;
        }

        @Override
        @JsonSetter(value = "minute", nulls = Nulls.SKIP)
        public _FinalStage minute(Optional<String> minute) {
            this.minute = minute;
            return this;
        }

        @Override
        public _FinalStage hour(String hour) {
            this.hour = Optional.of(hour);
            return this;
        }

        @Override
        @JsonSetter(value = "hour", nulls = Nulls.SKIP)
        public _FinalStage hour(Optional<String> hour) {
            this.hour = hour;
            return this;
        }

        @Override
        public _FinalStage dayOfWeek(String dayOfWeek) {
            this.dayOfWeek = Optional.of(dayOfWeek);
            return this;
        }

        @Override
        @JsonSetter(value = "day_of_week", nulls = Nulls.SKIP)
        public _FinalStage dayOfWeek(Optional<String> dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
            return this;
        }

        @Override
        public _FinalStage dayOfMonth(String dayOfMonth) {
            this.dayOfMonth = Optional.of(dayOfMonth);
            return this;
        }

        @Override
        @JsonSetter(value = "day_of_month", nulls = Nulls.SKIP)
        public _FinalStage dayOfMonth(Optional<String> dayOfMonth) {
            this.dayOfMonth = dayOfMonth;
            return this;
        }

        @Override
        public BulkSchedule build() {
            return new BulkSchedule(dayOfMonth, dayOfWeek, frequency, hour, minute, month, additionalProperties);
        }
    }
}
