package com.whaleal.common.column;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.SignStyle;

import static com.sun.xml.internal.bind.v2.schemagen.Util.equalsIgnoreCase;
import static java.time.temporal.ChronoField.*;

/**
 * @author wh
 * @date 2021/9/17 3:18 下午
 */
public class StringColumn extends AbstractColumn<String>{


    private static final int MIN_YEAR_SYMBOLS = 4;
    private static final int MAX_YEAR_SYMBOLS = 10;

    // region date-time formatters
    static final DateTimeFormatter STANDARD_DATE_FORMAT = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendValue(YEAR, MIN_YEAR_SYMBOLS, MAX_YEAR_SYMBOLS, SignStyle.EXCEEDS_PAD)
            .appendLiteral('-')
            .appendValue(MONTH_OF_YEAR, 1, 2, SignStyle.NEVER)
            .appendLiteral('-')
            .appendValue(DAY_OF_MONTH, 1, 2, SignStyle.NEVER)
            .toFormatter();

    @SuppressWarnings({"checkstyle:MagicNumber", "checkstyle:DeclarationOrder"})
    static final DateTimeFormatter STANDARD_TIME_FORMAT = new DateTimeFormatterBuilder()
            .appendValue(HOUR_OF_DAY, 1, 2, SignStyle.NEVER)
            .appendLiteral(':')
            .appendValue(MINUTE_OF_HOUR, 1, 2, SignStyle.NEVER)
            .optionalStart()
            .appendLiteral(':')
            .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NEVER)
            .optionalStart()
            .appendFraction(NANO_OF_SECOND, 0, 9, true)
            .toFormatter();

    static final DateTimeFormatter STANDARD_DATE_TIME_FORMAT = new DateTimeFormatterBuilder()
            .append(STANDARD_DATE_FORMAT)
            .appendPattern("['T'][' ']")
            .append(STANDARD_TIME_FORMAT)
            .toFormatter();

    static final DateTimeFormatter STANDARD_OFFSET_DATE_TIME_FORMAT = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .append(STANDARD_DATE_TIME_FORMAT)
            .appendOffsetId()
            .toFormatter();

    public StringColumn(ColumnEditorImpl columnEditor) {
        super(columnEditor);
    }

    //endregion


  
    @Override
    public final Boolean asBoolean() {
        String val0 = super.getRawValue();
       

        if (equalsIgnoreCase(val0, BooleanColumn.TRUE)) {
            return true;
        } else if (equalsIgnoreCase(val0, BooleanColumn.FALSE)) {
            return false;
        }

        throw cannotParseError(JdbcType.BOOLEAN);
    }

    @Override
    public final Byte asByte() {
        try {
            return Byte.parseByte(super.getRawValue());
        } catch (NumberFormatException e) {
            throw cannotParseError(JdbcType.TINYINT);
        }
    }

    @Override
    public final Short asShort() {
        try {
            return Short.parseShort(super.getRawValue());
        } catch (NumberFormatException e) {
            throw cannotParseError(JdbcType.SMALLINT);
        }
    }

    @Override
    public final Integer asInteger() {
        try {
            return Integer.parseInt(super.getRawValue());
        } catch (NumberFormatException e) {
            throw cannotParseError(JdbcType.INTEGER);
        }
    }

    @Override
    public final Long asLong() {
        try {
            return Long.parseLong(super.getRawValue());
        } catch (NumberFormatException e) {
            throw cannotParseError(JdbcType.BIGINT);
        }
    }

    @Override
    public final BigDecimal asDecimal() {
        try {
            return new BigDecimal(super.getRawValue(), MathContext.DECIMAL128);
        } catch (NumberFormatException e) {
            throw cannotParseError(JdbcType.DECIMAL);
        }
    }

    @Override
    public final Float asFloat() {
        try {
            return Float.parseFloat(super.getRawValue());
        } catch (NumberFormatException e) {
            throw cannotParseError(JdbcType.REAL);
        }
    }

    @Override
    public final Double asDouble() {
        try {
            return Double.parseDouble(super.getRawValue());
        } catch (NumberFormatException e) {
            throw cannotParseError(JdbcType.DOUBLE);
        }
    }

    @Override
    public final String asString() {
        return cast();
    }

    @Override
    public final LocalDate asDate() {
        try {
            return LocalDate.parse(super.getRawValue(), STANDARD_DATE_FORMAT);
        } catch (DateTimeParseException e) {
            throw cannotParseError(JdbcType.DATE);
        }
    }

    @Override
    public final LocalTime asTime() {
        try {
            return LocalTime.parse(super.getRawValue(), STANDARD_TIME_FORMAT);
        } catch (DateTimeParseException e) {
            throw cannotParseError(JdbcType.TIME);
        }
    }

    @Override
    public final LocalDateTime asTimestamp() {
        try {
            return LocalDateTime.parse(super.getRawValue(), STANDARD_DATE_TIME_FORMAT);
        } catch (DateTimeParseException e) {
            throw cannotParseError(JdbcType.TIMESTAMP);
        }
    }

    @Override
    public final OffsetDateTime asTimestampWithTimezone() {
        try {
            return OffsetDateTime.parse(super.getRawValue(), STANDARD_OFFSET_DATE_TIME_FORMAT);
        } catch (DateTimeParseException e) {
            throw cannotParseError(JdbcType.TIMESTAMP_WITH_TIMEZONE);
        }
    }

    @Override
    public final Object asObject() {
        return asString();
    }







    @Override
    byte[] asByteArray() {
        return new byte[0];
    }

    @Override
    Class<String> getEncoderClass() {
        return String.class;
    }

    protected String cast() {
        return (String) super.getRawValue();
    }





    private static ColumnCastingException cannotParseError(JdbcType target) {
        String message = "Cannot parse " + JdbcType.VARCHAR + " value to " + target;

        return ColumnCastingException.error(ErrorCode.DATA_EXCEPTION, message);
    }
}
