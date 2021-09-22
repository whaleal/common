package com.whaleal.common.column;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;

/**
 * @author wh
 * @date 2021/9/18 11:03 上午
 */
public class LocalDateTImeColumn   extends AbstractTemporalColumn<LocalDateTime>{

    public LocalDateTImeColumn(ColumnEditorImpl columnEditor) {
        super(columnEditor);
    }


    @Override
    public String asString() {
        return cast().toString();
    }

    @Override
    Boolean asBoolean() {
        throw  new UnsupportedOperationException();
    }

    @Override
    Byte asByte() {
        throw  new UnsupportedOperationException();
    }

    @Override
    Short asShort() {
        throw  new UnsupportedOperationException();
    }

    @Override
    Integer asInteger() {
        throw  new UnsupportedOperationException();
    }

    @Override
    Long asLong() {
        throw  new UnsupportedOperationException();
    }

    @Override
    Float asFloat() {
        throw  new UnsupportedOperationException();
    }

    @Override
    Double asDouble() {
        throw  new UnsupportedOperationException();
    }

    @Override
    Object asDecimal() {
        throw  new UnsupportedOperationException();
    }

    @Override
    public LocalDate asDate() {
        return cast().toLocalDate();
    }

    @Override
    public LocalTime asTime() {
        return cast().toLocalTime();
    }

    @Override
    public LocalDateTime asTimestamp() {
        return cast();
    }

    @Override
    public OffsetDateTime asTimestampWithTimezone() {
        return timestampToTimestampWithTimezone(cast());
    }

    @Override
    byte[] asByteArray() {
        return new byte[0];
    }

    @Override
    Class<LocalDateTime> getEncoderClass() {
        return LocalDateTime.class;
    }



    private LocalDateTime cast() {
        return ((LocalDateTime) super.getRawValue());
    }
}
