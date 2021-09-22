package com.whaleal.common.column;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;

/**
 * @author wh
 * @date 2021/9/18 11:01 上午
 */
public class LocalDateColumn  extends   AbstractTemporalColumn<LocalDate> {

    public LocalDateColumn(ColumnEditorImpl columnEditor) {
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
    public LocalDate asDate() {
        return cast();
    }

    @Override
    LocalTime asTime() {
        throw new UnsupportedOperationException();
    }

    @Override
    public LocalDateTime asTimestamp() {
        LocalDate date = cast();

        return dateToTimestamp(date);
    }

    @Override
    public OffsetDateTime asTimestampWithTimezone() {
        LocalDate date = cast();

        LocalDateTime timestamp = dateToTimestamp(date);

        return timestampToTimestampWithTimezone(timestamp);
    }

    @Override
    byte[] asByteArray() {
        return new byte[0];
    }

    @Override
    Class<LocalDate> getEncoderClass() {
        return null;
    }


    private LocalDate cast() {
        return ((LocalDate) super.getRawValue());
    }
}
