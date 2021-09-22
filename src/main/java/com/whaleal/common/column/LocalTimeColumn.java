package com.whaleal.common.column;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;

/**
 * @author wh
 * @date 2021/9/18 11:04 上午
 */
public class LocalTimeColumn  extends AbstractTemporalColumn<LocalTime>{

    public LocalTimeColumn(ColumnEditorImpl columnEditor) {
        super(columnEditor);
    }


    @Override
    public String asString() {
        return cast().toString();
    }

    @Override
    Boolean asBoolean() {
        throw new UnsupportedOperationException();
    }

    @Override
    Byte asByte() {
        throw new UnsupportedOperationException();
    }

    @Override
    Short asShort() {
        throw new UnsupportedOperationException();
    }

    @Override
    Integer asInteger() {
        throw new UnsupportedOperationException();
    }

    @Override
    Long asLong() {
        throw new UnsupportedOperationException();
    }

    @Override
    Float asFloat() {
        throw new UnsupportedOperationException();
    }

    @Override
    Double asDouble() {
        throw new UnsupportedOperationException();
    }

    @Override
    Object asDecimal() {
        throw new UnsupportedOperationException();
    }

    @Override
    LocalDate asDate() {
        throw new UnsupportedOperationException();
    }

    @Override
    public LocalTime asTime() {
        return cast();
    }

    @Override
    public LocalDateTime asTimestamp() {
        LocalTime time = cast();

        return timeToTimestamp(time);
    }

    @Override
    public OffsetDateTime asTimestampWithTimezone() {
        LocalTime time = cast();

        LocalDateTime timestamp = timeToTimestamp(time);

        return timestampToTimestampWithTimezone(timestamp);
    }

    @Override
    byte[] asByteArray() {
        return new byte[0];
    }

    @Override
    Class<LocalTime> getEncoderClass() {
        return null;
    }

    private LocalTime cast() {
        return ((LocalTime) super.getRawValue());
    }

}
