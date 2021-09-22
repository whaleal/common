package com.whaleal.common.column;


import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;


/**
 * @author wh
 * @date 2021/9/17 3:58 下午
 */
public class LongColumn  extends AbstractColumn<Long>{

    public LongColumn(ColumnEditorImpl columnEditor) {
        super(columnEditor);
    }

    
    @Override
    public Byte asByte() {
        long casted = cast();
        byte converted = (byte) casted;

        if (converted != casted) {
            throw new CastingException(JdbcType.TINYINT);
        }

        return converted;
    }

    @Override
    public Short asShort() {
        long casted = cast();
        short converted = (short) casted;

        if (converted != casted) {
            throw new CastingException(JdbcType.SMALLINT);
        }

        return converted;
    }

    @Override
    public Integer asInteger() {
        long casted = cast();
        int converted = (int) casted;

        if (converted != casted) {
            throw new CastingException(JdbcType.INTEGER);
        }

        return converted;
    }

    @Override
    public Long asLong() {
        return cast();
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
    Class<Long> getEncoderClass() {
        throw new UnsupportedOperationException();
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
        return Long.toString(cast());
    }

    @Override
    Boolean asBoolean() {
        throw new UnsupportedOperationException();
    }


    private long cast() {
        return (long) super.getRawValue();
    }
}
