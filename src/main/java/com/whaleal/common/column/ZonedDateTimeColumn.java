package com.whaleal.common.column;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

/**
 * @author wh
 * @date 2021/9/18 11:15 上午
 */
public class ZonedDateTimeColumn extends AbstractTimestampWithTimezoneColumn<ZonedDateTime> {


    protected ZonedDateTimeColumn(ColumnEditor editor) {
        super(editor);
    }

    @Override
    public OffsetDateTime asTimestampWithTimezone() {
        return (cast()).toOffsetDateTime();
    }

    @Override
    Boolean asBoolean() {
        return null;
    }

    @Override
    Byte asByte() {
        return null;
    }

    @Override
    Short asShort() {
        return null;
    }

    @Override
    Integer asInteger() {
        return null;
    }

    @Override
    Long asLong() {
        return null;
    }

    @Override
    Float asFloat() {
        return null;
    }

    @Override
    Double asDouble() {
        return null;
    }

    @Override
    Object asDecimal() {
        return null;
    }



    @Override
    byte[] asByteArray() {
        return new byte[0];
    }

    @Override
    Class<ZonedDateTime> getEncoderClass() {
        return ZonedDateTime.class;
    }

    private ZonedDateTime cast(){
        return super.getRawValue();
    }
}
