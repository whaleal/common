package com.whaleal.common.column;

import java.time.OffsetDateTime;
import java.util.Calendar;

/**
 * @author wh
 * @date 2021/9/16 8:37 下午
 */
public class CalendarColumn  extends AbstractTimestampWithTimezoneColumn<Calendar> {


    protected CalendarColumn(ColumnEditor editor) {
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
        Calendar c = (Calendar) super.getRawValue();
        return OffsetDateTime.ofInstant(c.toInstant(), c.getTimeZone().toZoneId());
    }

    @Override
    byte[] asByteArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    Class<Calendar> getEncoderClass() {
        return Calendar.class;
    }
}
