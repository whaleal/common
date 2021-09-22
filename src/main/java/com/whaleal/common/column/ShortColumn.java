package com.whaleal.common.column;


import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;


/**
 * @author wh
 * @date 2021/9/18 11:12 上午
 */
public class ShortColumn  extends AbstractColumn<Short>{

    public ShortColumn(ColumnEditorImpl columnEditor) {
        super(columnEditor);
    }


    @Override
    public Byte asByte() {
        short casted = cast();
        byte converted = (byte) casted;

        if (converted != casted) {
            throw new CastingException(JdbcType.TINYINT);
        }

        return converted;
    }

    @Override
    public Short asShort() {
        return cast();
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
    Class<Short> getEncoderClass() {
        return Short.class;
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
        return Short.toString(cast());
    }

    @Override
    Boolean asBoolean() {
        throw new UnsupportedOperationException();
    }


    private short cast() {
        return (short) super.getRawValue();
    }
}
