package com.whaleal.common.column;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.*;

/**
 * @author wh
 * @date 2021/9/17 3:20 下午
 */
public class FloatColumn  extends AbstractColumn<Float>{

 

    public FloatColumn(ColumnEditorImpl columnEditor) {
        super(columnEditor);
    }

    @Override
    public Byte asByte() {
        float val0 = cast();

        if (Float.isInfinite(val0)) {
            throw new CastingException(JdbcType.TINYINT);
        }

        if (Float.isNaN(val0)) {
            throw new CastingException(JdbcType.TINYINT);
        }

        // here the overflow may happen: (byte) casted = (byte) (int) casted
        byte converted = (byte) val0;

        // casts from float to int are saturating
        if (converted != (int) val0) {
            throw new CastingException(JdbcType.TINYINT);
        }

        return converted;
    }

    @Override
    public Short asShort() {
        float val0 = cast();

        if (Float.isInfinite(val0)) {
            throw new CastingException(JdbcType.SMALLINT);
        }

        if (Float.isNaN(val0)) {
            throw new CastingException(JdbcType.SMALLINT);
        }

        // here the overflow may happen: (short) casted = (short) (int) casted
        short converted = (short) val0;

        // casts from float to int are saturating
        if (converted != (int) val0) {
            throw new CastingException(JdbcType.SMALLINT);
        }

        return converted;
    }

    @Override
    public Integer asInteger() {
        float val0 = cast();

        if (Float.isInfinite(val0)) {
            throw new CastingException(JdbcType.INTEGER);
        }

        if (Float.isNaN(val0)) {
            throw new CastingException(JdbcType.INTEGER);
        }

        // casts from float to int are saturating
        int converted = (int) val0;

        // casts from float to long are saturating
        if (converted != (long) val0) {
            throw new CastingException(JdbcType.INTEGER);
        }

        return converted;
    }

    @Override
    public Long asLong() {
        float val0 = cast();

        if (Float.isInfinite(val0)) {
            throw new CastingException(JdbcType.BIGINT);
        }

        if (Float.isNaN(val0)) {
            throw new CastingException(JdbcType.BIGINT);
        }

        float truncated = (float) (val0 > 0.0 ? Math.floor(val0) : Math.ceil(val0));
        // casts from float to long are saturating
        long converted = (long) truncated;

        if ((float) converted != truncated) {
            throw new CastingException(JdbcType.BIGINT);
        }

        return converted;
    }

    @Override
    public BigDecimal asDecimal() {
        float val0 = cast();

        if (Float.isInfinite(val0)) {
            throw new CastingException(JdbcType.DECIMAL);
        }

        if (Float.isNaN(val0)) {
            throw new CastingException(JdbcType.DECIMAL);
        }

        return new BigDecimal(val0, MathContext.DECIMAL128);
    }

    @Override
    LocalDate asDate() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Float asFloat() {
        return cast();
    }

    @Override
    public Double asDouble() {
        return (double)cast();
    }

    @Override
    public String asString() {
        return Float.toString(cast());
    }



    private float cast() {
        return  super.getRawValue();
    }

    @Override
    Boolean asBoolean() {
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
    Class<Float> getEncoderClass() {
        return Float.class;
    }
}
