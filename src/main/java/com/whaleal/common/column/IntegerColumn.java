package com.whaleal.common.column;


import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;


/**
 * @author wh
 * @date 2021/9/17 3:21 下午
 */
public class IntegerColumn extends AbstractColumn<Integer>{




    public IntegerColumn(ColumnEditorImpl columnEditor) {
        super(columnEditor);
    }

    @Override
    public Byte asByte() {
        int casted = cast();
        byte converted = (byte) casted;

        if (converted != casted) {
            throw new CastingException(JdbcType.TINYINT);
        }

        return converted;
    }

    @Override
    public Short asShort() {
        int casted = cast();
        short converted = (short) casted;

        if (converted != casted) {
            throw new CastingException(JdbcType.SMALLINT);
        }

        return converted;
    }

    @Override
    public Integer asInteger() {
        return cast();
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
    public Float asFloat() {
        return (float)cast();
    }

    @Override
    public Double asDouble() {
        return (double)cast();
    }

    @Override
    public String asString() {
        return Integer.toString(cast());
    }

    @Override
    Boolean asBoolean() {
        throw new UnsupportedOperationException();
    }


    private int cast() {

        return super.getRawValue();
    }

    @Override
    Class<Integer> getEncoderClass() {
        return Integer.class;
    }


}
