package com.whaleal.common.column;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author wh
 * @date 2021/9/16 8:29 下午
 */
public abstract class AbstractTimestampWithTimezoneColumn<T>  extends AbstractTemporalColumn<T> {


    protected AbstractTimestampWithTimezoneColumn(ColumnEditor editor) {
        super(editor);
    }

    @Override
    public final String asString() {
        return asTimestampWithTimezone().toString();
    }

    @Override
    public final LocalDate asDate() {
        return asTimestamp().toLocalDate();
    }

    @Override
    public final LocalTime asTime() {
        return asTimestamp().toLocalTime();
    }

    @Override
    public final LocalDateTime asTimestamp() {
        return timestampWithTimezoneToTimestamp(asTimestampWithTimezone());
    }

    @Override
    public final Object asObject() {
        return asTimestampWithTimezone();
    }


    
}
