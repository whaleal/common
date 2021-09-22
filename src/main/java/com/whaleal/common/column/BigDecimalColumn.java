package com.whaleal.common.column;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;

/**
 * @author wh
 * @date 2021/9/17 3:54 下午
 */
public class BigDecimalColumn  extends AbstractDecimalColumn<BigDecimal>{
    public BigDecimalColumn(ColumnEditorImpl columnEditor) {
        super(columnEditor);
    }



    @Override
    public Byte asByte() {
        BigDecimal casted = cast();
        try {
            return casted.setScale(0, BigDecimal.ROUND_DOWN).byteValueExact();
        } catch (ArithmeticException e) {
            throw new CastingException(JdbcType.TINYINT);
        }
    }

    @Override
    public Short asShort() {
        BigDecimal casted = cast();
        try {
            return casted.setScale(0, BigDecimal.ROUND_DOWN).shortValueExact();
        } catch (ArithmeticException e) {
            throw new CastingException(JdbcType.SMALLINT);
        }
    }

    @Override
    public Integer asInteger() {
        BigDecimal casted = cast();
        try {
            return casted.setScale(0, BigDecimal.ROUND_DOWN).intValueExact();
        } catch (ArithmeticException e) {
            throw new CastingException(JdbcType.INTEGER);
        }
    }

    @Override
    public Long asLong() {
        BigDecimal casted = cast();
        try {
            return casted.setScale(0, BigDecimal.ROUND_DOWN).longValueExact();
        } catch (ArithmeticException e) {
            throw new CastingException(JdbcType.BIGINT);
        }
    }

    @Override
    public BigDecimal asDecimal() {
        return cast();
    }

    @Override
    LocalDate asDate() {
        return null;
    }

    @Override
    LocalTime asTime() {
        return null;
    }

    @Override
    LocalDateTime asTimestamp() {
        return null;
    }

    @Override
    OffsetDateTime asTimestampWithTimezone() {
        return null;
    }

    @Override
    byte[] asByteArray() {
        return new byte[0];
    }

    @Override
    Class<BigDecimal> getEncoderClass() {
        return BigDecimal.class;
    }

    @Override
    public Float asFloat() {
        return cast().floatValue();
    }

    @Override
    public Double asDouble() {
        return cast().doubleValue();
    }

    @Override
    public String asString() {
        return cast().toString();
    }

    @Override
    Boolean asBoolean() {
        return null;
    }

    private BigDecimal cast() {
        return (BigDecimal) super.getRawValue();
    }
   
}
