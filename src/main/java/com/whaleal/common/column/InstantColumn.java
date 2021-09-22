package com.whaleal.common.column;

import java.time.Instant;
import java.time.OffsetDateTime;

/**
 * @author wh
 * @date 2021/9/16 8:38 下午
 */
public class InstantColumn  extends AbstractTimestampWithTimezoneColumn<Instant>{


    protected InstantColumn(ColumnEditor editor) {
        super(editor);
    }

    @Override
    public OffsetDateTime asTimestampWithTimezone() {
        return OffsetDateTime.ofInstant(((Instant) super.getRawValue()), DEFAULT_ZONE);
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
    byte[] asByteArray() {
        return new byte[0];
    }

    @Override
    Class<Instant> getEncoderClass() {
        return Instant.class;
    }
}
