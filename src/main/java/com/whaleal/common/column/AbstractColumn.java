/*
 * Copyright Debezium Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package com.whaleal.common.column;



import java.time.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class AbstractColumn<T> implements Column<T>, Comparable<Column> {
    /**
     *字段名称
     */
    private String name;

    /**
     * 字段所在的位置 比如第三列
     */
    private int position;
    // JdbcType
    private JdbcType representType;
    // JdbcType
    private JdbcType nativeType;

    /**
     * 字段类型及描述
     * comment
     */
    private String typeName;
    private String typeExpression;
    // 字符集
    private String charsetName;
    /**
     * 大小或数据长度
     * 大小
     * 小数位数 等
     */
    private int length;
    private Integer scale;
    /**
     * 是否为可空
     */
    private boolean optional;
    /**
     * 是否可以自增
     */
    private boolean autoIncremented;
    private boolean generated;

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setRepresentType(JdbcType representType) {
        this.representType = representType;
    }

    public void setNativeType(JdbcType nativeType) {
        this.nativeType = nativeType;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setTypeExpression(String typeExpression) {
        this.typeExpression = typeExpression;
    }

    public void setCharsetName(String charsetName) {
        this.charsetName = charsetName;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    public void setAutoIncremented(boolean autoIncremented) {
        this.autoIncremented = autoIncremented;
    }

    public void setGenerated(boolean generated) {
        this.generated = generated;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void setHasDefaultValue(boolean hasDefaultValue) {
        this.hasDefaultValue = hasDefaultValue;
    }

    public void setEnumValues(List<String> enumValues) {
        this.enumValues = enumValues;
    }

    public void setPK(boolean isPK) {
        this.isPK = isPK;
    }

    /**
     * 字段默认值
     */
    private Object defaultValue;
    private boolean hasDefaultValue;
    private List<String> enumValues;
    /**
     * 该列是否为主键
     */
    private boolean isPK ;


    protected AbstractColumn(ColumnEditor editor){
        this.name = editor.name();
        this.position = editor.position();

        this.nativeType = editor.nativeType();
        this.defaultValue = editor.representType();
        this.typeName = editor.typeName();
        this.typeExpression = editor.typeExpression();
        // We want to always capture the charset name for the column (if the column needs one) ...
        if (typeUsesCharset() && (charsetName == null || "DEFAULT".equalsIgnoreCase(charsetName))) {
            // Use the default charset name ...
            charsetName = editor.charsetName();
        }
        this.charsetName =  editor.charsetName();
        this.length = editor.length();
        this.scale = editor.scale().get();
        this.optional = editor.isOptional();
        this.autoIncremented = editor.isAutoIncremented();
        this.generated = editor.isGenerated();

        this.hasDefaultValue = editor.hasDefaultValue();
        this.enumValues = editor.enumValues()== null ? new ArrayList<>() : editor.enumValues();
        assert this.length >= -1;
        this.isPK = editor.isPK();

    }


    @Override
    public String name() {
        return name;
    }

    @Override
    public int position() {
        return position;
    }

    @Override
    public JdbcType representType() {
        return representType;
    }

    @Override
    public JdbcType nativeType() {
        return nativeType;
    }

    @Override
    public String typeName() {
        return typeName;
    }

    @Override
    public String typeExpression() {
        return typeExpression;
    }

    @Override
    public String charsetName() {
        return charsetName;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public Optional<Integer> scale() {
        return Optional.ofNullable(scale);
    }

    @Override
    public boolean isOptional() {
        return optional;
    }

    @Override
    public boolean isAutoIncremented() {
        return autoIncremented;
    }

    @Override
    public boolean isGenerated() {
        return generated;
    }

    @Override
    public Object defaultValue() {
        return defaultValue;
    }

    @Override
    public boolean hasDefaultValue() {
        return hasDefaultValue;
    }

    @Override
    public List<String> enumValues() {
        return enumValues;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean isPK() {
        return isPK;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Column) {
            Column that = (Column) obj;
            return this.name().equalsIgnoreCase(that.name()) &&
                    this.typeExpression().equalsIgnoreCase(that.typeExpression()) &&
                    this.typeName().equalsIgnoreCase(that.typeName()) &&
                    this.representType() == that.representType() &&
                    this.charsetName().equals(that.charsetName()) &&
                    this.position() == that.position() &&
                    this.length() == that.length() &&
                    this.scale().equals(that.scale()) &&
                    this.isOptional() == that.isOptional() &&
                    this.isAutoIncremented() == that.isAutoIncremented() &&
                    this.isGenerated() == that.isGenerated() &&
                    Objects.equals(this.defaultValue(), that.defaultValue()) &&
                    this.hasDefaultValue() == that.hasDefaultValue() &&
                    this.enumValues().equals(that.enumValues());
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        sb.append(" ").append(typeName);
        if (length >= 0) {
            sb.append('(').append(length);
            if (scale != null) {
                sb.append(", ").append(scale);
            }
            sb.append(')');
        }
        if (charsetName != null && !charsetName.isEmpty()) {
            sb.append(" CHARSET ").append(charsetName);
        }
        if (!optional) {
            sb.append(" NOT NULL");
        }
        if (autoIncremented) {
            sb.append(" AUTO_INCREMENTED");
        }
        if (generated) {
            sb.append(" GENERATED");
        }
        if (hasDefaultValue() && defaultValue() == null) {
            sb.append(" DEFAULT VALUE NULL");
        }
        else if (defaultValue != null) {
            sb.append(" DEFAULT VALUE ").append(defaultValue);
        }
        return sb.toString();
    }

    @Override
    public ColumnEditor edit() {
        ColumnEditor editor = Column.editor()
                .name(name())
                .type(typeName(), typeExpression())
                .representType(representType())
                .nativeType(representType)
                .charsetName(charsetName)
                .length(length())
                .scale(scale().orElse(null))
                .position(position())
                .optional(isOptional())
                .autoIncremented(isAutoIncremented())
                .generated(isGenerated())
                .enumValues(enumValues)
                .pk(isPK);
        if (hasDefaultValue()) {
            editor.defaultValue(defaultValue());
        }
        return editor;
    }

    T getRawValue(){
        return isNull()?null:(T)defaultValue();
    }




    boolean isNull(){
       return this.defaultValue == null ;
    }

    abstract String asString();

    abstract Boolean asBoolean();

    abstract Byte asByte();

    abstract Short asShort();

    abstract Integer asInteger();

    abstract Long asLong();

    abstract Float asFloat();

    abstract Double asDouble();

    abstract Object asDecimal();

    abstract LocalDate asDate() ;


    abstract LocalTime asTime();


    abstract LocalDateTime asTimestamp();


    abstract OffsetDateTime asTimestampWithTimezone() ;

    abstract byte[] asByteArray();

    public Object asObject(){
        return this.defaultValue;
    }

    Object asRepresentValue(JdbcType type,Handler handler){
        if(this.representType!=null){
            return handler.asRepresentValue(this,representType);
        }else {
            throw new NullPointerException();
        }
    }

    abstract Class<T> getEncoderClass();




}
