package com.whaleal.common.column;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;

/**
 * @author wh
 * @date 2021/9/18 11:09 上午
 */
public class NullColumn extends AbstractColumn<Object>{

    public NullColumn(ColumnEditorImpl columnEditor) {
        super(columnEditor);
    }

    @Override
    public Boolean asBoolean() {
        throw new UnsupportedOperationException("must never be called");
    }

    @Override
    public Byte asByte() {
        throw new UnsupportedOperationException("must never be called");
    }

    @Override
    public Short asShort() {
        throw new UnsupportedOperationException("must never be called");
    }

    @Override
    public Integer asInteger() {
        throw new UnsupportedOperationException("must never be called");
    }

    @Override
    public Long asLong() {
        throw new UnsupportedOperationException("must never be called");
    }

    @Override
    public BigDecimal asDecimal() {
        throw new UnsupportedOperationException("must never be called");
    }

    @Override
    public Float asFloat() {
        throw new UnsupportedOperationException("must never be called");
    }

    @Override
    public Double asDouble() {
        throw new UnsupportedOperationException("must never be called");
    }

    @Override
    public String asString() {
        throw new UnsupportedOperationException("must never be called");
    }

    @Override
    public LocalDate asDate() {
        throw new UnsupportedOperationException("must never be called");
    }

    @Override
    public LocalTime asTime() {
        throw new UnsupportedOperationException("must never be called");
    }

    @Override
    public LocalDateTime asTimestamp() {
        throw new UnsupportedOperationException("must never be called");
    }

    @Override
    public OffsetDateTime asTimestampWithTimezone() {
        throw new UnsupportedOperationException("must never be called");
    }

    @Override
    byte[] asByteArray() {
        return new byte[0];
    }

    @Override
    public Object asObject() {
        throw new UnsupportedOperationException("must never be called");
    }

    @Override
    Class<Object> getEncoderClass() {
        return null;
    }


}
