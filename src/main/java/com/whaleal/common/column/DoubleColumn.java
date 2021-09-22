package com.whaleal.common.column;


import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;

import static com.whaleal.common.column.JdbcType.DECIMAL;

/**
 * @author wh
 * @date 2021/9/17 3:54 下午
 */
public class DoubleColumn  extends AbstractColumn<Double>{

    public DoubleColumn(ColumnEditorImpl columnEditor) {
        super(columnEditor);
    }

    @Override
    public Byte asByte() {
        double val0 = cast();

        if (Double.isInfinite(val0)) {
            throw new CastingException(JdbcType.TINYINT);
        }

        if (Double.isNaN(val0)) {
            throw new CastingException(JdbcType.TINYINT);
        }

        // here the overflow may happen: (byte) casted = (byte) (int) casted
        byte converted = (byte) val0;

        // casts from double to int are saturating
        if (converted != (int) val0) {
            throw new CastingException(JdbcType.TINYINT);
        }

        return converted;
    }

    @Override
    public Short asShort() {
        double val0 = cast();

        if (Double.isInfinite(val0)) {
            throw new CastingException(JdbcType.SMALLINT);
        }

        if (Double.isNaN(val0)) {
            throw new CastingException(JdbcType.SMALLINT);
        }

        // here the overflow may happen: (short) casted = (short) (int) casted
        short converted = (short) val0;

        // casts from double to int are saturating
        if (converted != (int) val0) {
            throw new CastingException(JdbcType.SMALLINT);
        }

        return converted;
    }

    @Override
    public Integer asInteger() {
        double val0 = cast();

        if (Double.isInfinite(val0)) {
            throw new CastingException(JdbcType.INTEGER);
        }

        if (Double.isNaN(val0)) {
            throw new CastingException(JdbcType.INTEGER);
        }

        int converted = (int) val0;

        // casts from double to long are saturating
        if (converted != (long) val0) {
            throw new CastingException(JdbcType.INTEGER);
        }

        return converted;
    }

    @Override
    public Long asLong() {
        double val0 = cast();

        if (Double.isInfinite(val0)) {
            throw new CastingException(JdbcType.BIGINT);
        }

        if (Double.isNaN(val0)) {
            throw new CastingException(JdbcType.BIGINT);
        }

        double truncated = val0 > 0.0 ? Math.floor(val0) : Math.ceil(val0);
        // casts from double to long are saturating
        long converted = (long) truncated;

        if ((double) converted != truncated) {
            throw new CastingException(JdbcType.BIGINT);
        }

        return converted;
    }

    @Override
    public BigDecimal asDecimal() {
        double val0 = cast();

        if (Double.isInfinite(val0)) {
            throw new CastingException(DECIMAL);
        }

        if (Double.isNaN(val0)) {
            throw new CastingException(DECIMAL);
        }

        return new BigDecimal(val0, MathContext.DECIMAL128);
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
    Class<Double> getEncoderClass() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Float asFloat() {
        double doubleVal = cast();
        float floatVal = (float) cast();

        if (Float.isInfinite(floatVal) && !Double.isInfinite(doubleVal)) {
            throw new CastingException(JdbcType.REAL);
        }

        return floatVal;
    }

    @Override
    public Double asDouble() {
        return cast();
    }

    @Override
    public String asString() {
        return Double.toString(cast());
    }

    @Override
    Boolean asBoolean() {
        throw new UnsupportedOperationException();
    }


    private double cast() {
        return (double) super.getRawValue();
    }

}
