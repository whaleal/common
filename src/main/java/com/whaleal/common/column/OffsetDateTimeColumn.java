package com.whaleal.common.column;


import java.time.OffsetDateTime;

/**
 * @author wh
 * @date 2021/9/16 8:40 下午
 */
public class OffsetDateTimeColumn extends  AbstractTimestampWithTimezoneColumn<OffsetDateTime>{




    public OffsetDateTimeColumn(ColumnEditorImpl columnEditor) {
        super(columnEditor);
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
    public OffsetDateTime asTimestampWithTimezone() {
        return (OffsetDateTime) super.getRawValue();
    }

    @Override
    byte[] asByteArray() {
        return new byte[0];
    }

    @Override
    Class<OffsetDateTime> getEncoderClass() {
        return OffsetDateTime.class;
    }

}
