package com.whaleal.common.column;

import java.time.*;

/**
 * @author wh
 * @date 2021/9/16 4:09 下午
 */
public class BooleanColumn extends AbstractColumn<Boolean>{
    static final String TRUE = "true";
    static final String FALSE = "false";



    public BooleanColumn(ColumnEditorImpl columnEditor) {
        super(columnEditor);
    }

    @Override
    String asString() {
        return super.getRawValue().toString();
    }

    @Override
    Boolean asBoolean() {
        return super.getRawValue();
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
        return  Boolean.compare(super.getRawValue(), Boolean.TRUE) + 1;
    }

    @Override
    Long asLong() {
        return Boolean.compare(super.getRawValue(), Boolean.TRUE) + 1L;
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
    LocalTime asTime() {
        throw new UnsupportedOperationException();
    }

    @Override
    LocalDateTime asTimestamp() {
        throw new UnsupportedOperationException();
    }

    @Override
    OffsetDateTime asTimestampWithTimezone() {
        throw new UnsupportedOperationException();
    }


    @Override
    byte[] asByteArray() {
        throw new UnsupportedOperationException();
    }


    @Override
    Class<Boolean> getEncoderClass() {
        return Boolean.class;
    }
}
