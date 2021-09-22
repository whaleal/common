package com.whaleal.common.column;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;

/**
 * @author wh
 * @date 2021/9/18 11:10 上午
 */
public class ObjectColumn  extends AbstractColumn<Object> {


    protected ObjectColumn(ColumnEditor editor) {
        super(editor);
    }

    @Override
    public Boolean asBoolean() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Byte asByte() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Short asShort() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer asInteger() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Long asLong() {
        throw new UnsupportedOperationException();
    }

    @Override
    public BigDecimal asDecimal() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Float asFloat() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Double asDouble() {
        throw new UnsupportedOperationException();
    }

    @Override
    public LocalDate asDate() {
        throw new UnsupportedOperationException();
    }

    @Override
    public LocalTime asTime() {
        throw new UnsupportedOperationException();
    }

    @Override
    public LocalDateTime asTimestamp() {
        throw new UnsupportedOperationException();
    }

    @Override
    public OffsetDateTime asTimestampWithTimezone() {
        throw new UnsupportedOperationException();
    }

    @Override
    byte[] asByteArray() {
        return new byte[0];
    }

    @Override
    public String asString() {
        return super.getRawValue().toString();
    }

    @Override
    public Object asObject() {
        return super.getRawValue();
    }

    @Override
    Class<Object> getEncoderClass() {
        return Object.class;
    }



}
