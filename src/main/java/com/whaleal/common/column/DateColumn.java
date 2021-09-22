package com.whaleal.common.column;

import java.time.OffsetDateTime;
import java.util.Date;

/**
 * @author wh
 * @date 2021/9/16 8:31 下午
 */
public class DateColumn  extends AbstractTimestampWithTimezoneColumn<Date> {


    protected DateColumn(ColumnEditor editor) {
        super(editor);
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
        return OffsetDateTime.ofInstant(((Date) super.getRawValue()).toInstant(), DEFAULT_ZONE);
    }

    @Override
    byte[] asByteArray() {
        return new byte[0];
    }

    @Override
    Class<Date> getEncoderClass() {
        return Date.class;
    }
}
