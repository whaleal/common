package com.whaleal.common.column;


import java.math.BigDecimal;
import java.math.MathContext;
import java.time.*;


/**
 * @author wh
 * @date 2021/9/17 3:56 下午
 */
public class ByteColumn extends AbstractColumn<Byte> {


    protected ByteColumn(ColumnEditor editor) {
        super(editor);
    }

    @Override
    public Byte asByte() {
        return cast();
    }

    @Override
    public Short asShort() {
        return (short) cast();
    }

    @Override
    public Integer asInteger() {
        return (int)cast();
    }

    @Override
    public Long asLong() {
        return (long)cast();
    }

    @Override
    public BigDecimal asDecimal() {
        return new BigDecimal(cast(), MathContext.DECIMAL128);
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
        return new byte[0];
    }

    @Override
    Class<Byte> getEncoderClass() {
        return Byte.class;
    }

    @Override
    public Float asFloat() {
        return (float)cast();
    }

    @Override
    public Double asDouble() {
        return (double)cast();
    }

    @Override
    public String asString() {
        return Byte.toString(cast());
    }

    @Override
    Boolean asBoolean() {
        return null;
    }


    private byte cast() {
        return  super.getRawValue();
    }
}
