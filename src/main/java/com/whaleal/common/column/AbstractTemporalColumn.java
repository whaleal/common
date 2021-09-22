package com.whaleal.common.column;


import java.time.*;

/**
 * @author wh
 * @date 2021/9/18 10:20 上午
 */
public abstract class AbstractTemporalColumn<T>   extends AbstractColumn<T>{

    public static final ZoneId DEFAULT_ZONE = ZoneId.systemDefault();

    protected AbstractTemporalColumn(ColumnEditor editor) {
        super(editor);
    }


    /**
     * Convert DATE to TIMESTAMP as per ANSI standard.
     *
     * @param date Date.
     * @return Timestamp with the same date at midnight.
     */
    protected static LocalDateTime dateToTimestamp(LocalDate date) {
        return date.atStartOfDay();
    }

    /**
     * Convert TIME to TIMESTAMP as per ANSI standard.
     *
     * @param time Time.
     * @return Timestamp with the same time and current date.
     */
    protected static LocalDateTime timeToTimestamp(LocalTime time) {
        return LocalDateTime.of(LocalDate.now(), time);
    }

    /**
     * Convert TIMESTAMP to TIMESTAMP WITH TIMEZONE as per ANSI standard.
     *
     * @param timestamp Original timestamp.
     * @return Timestamp with timezone.
     */
    protected static OffsetDateTime timestampToTimestampWithTimezone(LocalDateTime timestamp) {
        return ZonedDateTime.of(timestamp, DEFAULT_ZONE).toOffsetDateTime();
    }

    /**
     * Convert TIMESTAMP WITH TIMEZONE to TIMESTAMP as per ANSI standard.
     *
     * @param timestampWithTimezone Original timestamp with timezone.
     * @return Timestamp.
     */
    protected static LocalDateTime timestampWithTimezoneToTimestamp(OffsetDateTime timestampWithTimezone) {
        return timestampWithTimezone.toLocalDateTime();
    }
}
