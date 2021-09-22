package com.whaleal.common.column;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * JDBC中字段类型枚举
 *
 * @autor wh
 * @see java.sql.Types
 */
public enum JdbcType {
	ARRAY(java.sql.Types.ARRAY), //
	/**
	 * The JDBC type BIT represents a single bit value that can be zero or one.
	 * The recommended Java mapping for the JDBC BIT type is as a Java boolean
	 * BIT type, represented by {@link Boolean}
	 */
	BIT(java.sql.Types.BIT), //
	/** TINYINT type, represented by {@link Short} */
	TINYINT(java.sql.Types.TINYINT), //
	/** SMALLINT type, represented by {@link Short} */
	SMALLINT(java.sql.Types.SMALLINT), //
	/** INTEGER type, represented by {@link Integer} */
	INTEGER(java.sql.Types.INTEGER), //
	/** BIGINT type, represented by {@link Long} */
	BIGINT(java.sql.Types.BIGINT), //
	/** FLOAT type, represented by {@link Float} */
	FLOAT(java.sql.Types.FLOAT), //
	/** REAL type, represented by {@link Float} */
	REAL(java.sql.Types.REAL), //
	/** DOUBLE type, represented by {@link Double} */
	DOUBLE(java.sql.Types.DOUBLE), //
	/** DECIMAL type, represented by {@link BigDecimal} */
	NUMERIC(java.sql.Types.NUMERIC), //
	/** DECIMAL type, represented by {@link BigDecimal} */
	DECIMAL(java.sql.Types.DECIMAL), //
	/**
	 * The JDBC types CHAR, VARCHAR, and LONGVARCHAR are closely related. CHAR represents a small, fixed-length character string, VARCHAR represents a small, variable- length character string, and LONGVARCHAR represents a large, variable-length character string.
	 * The SQL CHAR type corresponding to JDBC CHAR is defined in SQL-92 and is supported by all the major databases. It takes a parameter that specifies the string length. Thus CHAR(12) defines a 12-character string. All the major databases support CHAR lengths up to at least 254 characters.
	 * CHAR type, represented by {@link String}
	 */
	CHAR(java.sql.Types.CHAR), //
	/** VARCHAR type, represented by {@link String} */
	VARCHAR(java.sql.Types.VARCHAR), //
	/** LONGVARCHAR type, represented by {@link String} */
	LONGVARCHAR(java.sql.Types.LONGVARCHAR), //
	/** DATE type, represented by {@link LocalDate} */
	DATE(java.sql.Types.DATE), //
	/** TIME type, represented by {@link LocalTime} */
	TIME(java.sql.Types.TIME), //
	/** TIMESTAMP type, represented by {@link LocalDateTime} */
	TIMESTAMP(java.sql.Types.TIMESTAMP), //

	BINARY(java.sql.Types.BINARY), //
	VARBINARY(java.sql.Types.VARBINARY), //
	LONGVARBINARY(java.sql.Types.LONGVARBINARY), //
	/**
	 * The type of the generic SQL {@code NULL} literal.
	 * <p>
	 * The only valid value of {@code NULL} type is {@code null}.
	 */
	NULL(java.sql.Types.NULL), //
	OTHER(java.sql.Types.OTHER), //
	BLOB(java.sql.Types.BLOB), //
	CLOB(java.sql.Types.CLOB), //
	/** BOOLEAN type, represented by {@link Boolean} */
	BOOLEAN(java.sql.Types.BOOLEAN), //
	CURSOR(-10), // Oracle
	UNDEFINED(Integer.MIN_VALUE + 1000), //
	NVARCHAR(java.sql.Types.NVARCHAR), // JDK6
	NCHAR(java.sql.Types.NCHAR), // JDK6
	NCLOB(java.sql.Types.NCLOB), // JDK6
	STRUCT(java.sql.Types.STRUCT), //
	/**
	 *
	 */
	JAVA_OBJECT(java.sql.Types.JAVA_OBJECT), //
	DISTINCT(java.sql.Types.DISTINCT), //
	REF(java.sql.Types.REF), //
	DATALINK(java.sql.Types.DATALINK), //
	ROWID(java.sql.Types.ROWID), // JDK6
	LONGNVARCHAR(java.sql.Types.LONGNVARCHAR), // JDK6
	SQLXML(java.sql.Types.SQLXML), // JDK6
	DATETIMEOFFSET(-155), // SQL Server 2008
	TIME_WITH_TIMEZONE(2013), // JDBC 4.2 JDK8
	/** TIMESTAMP_WITH_TIME_ZONE type, represented by {@link OffsetDateTime} */
	TIMESTAMP_WITH_TIMEZONE(2014); // JDBC 4.2 JDK8

	public final int typeCode;

	/**
	 * 构造
	 *
	 * @param code {@link java.sql.Types} 中对应的值
	 */
	JdbcType(int code) {
		this.typeCode = code;
	}

	private static final Map<Integer, JdbcType> CODE_MAP = new ConcurrentHashMap<>(100, 1);
	static {
		for (JdbcType type : JdbcType.values()) {
			CODE_MAP.put(type.typeCode, type);
		}
	}

	/**
	 * 通过{@link java.sql.Types}中对应int值找到enum值
	 *
	 * @param code Jdbc type值
	 * @return {@link JdbcType}
	 */
	public static JdbcType valueOf(int code) {
		return CODE_MAP.get(code);
	}

}
