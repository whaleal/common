/*
 * Copyright Debezium Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package com.whaleal.common.column;

import java.util.List;
import java.util.Optional;


final class ColumnEditorImpl implements ColumnEditor {

    private String name;
    private JdbcType representType = JdbcType.UNDEFINED;
    private JdbcType nativeType = JdbcType.UNDEFINED ;
    private String typeName;
    private String typeExpression;
    private String charsetName;
    private String tableCharsetName;
    private int length = Column.UNSET_INT_VALUE;
    private Integer scale;
    private int position = 1;
    private boolean optional = true;
    private boolean autoIncremented = false;
    private boolean generated = false;
    private Object defaultValue = null;
    private boolean hasDefaultValue = false;
    private boolean isPK = false ;
    private List<String> enumValues;


    protected ColumnEditorImpl() {
    }

    @Override
    public String name() {
        return name;
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
    public JdbcType representType() {
        return representType;
    }

    @Override
    public JdbcType nativeType() {
        return nativeType;
    }

    @Override
    public String charsetName() {
        return charsetName;
    }

    @Override
    public String charsetNameOfTable() {
        return tableCharsetName;
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
    public int position() {
        return position;
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
    public ColumnEditorImpl name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public List<String> enumValues() {
        return enumValues;
    }

    @Override
    public ColumnEditorImpl type(String typeName) {
        this.typeName = typeName;
        this.typeExpression = typeName;
        return this;
    }

    @Override
    public ColumnEditor type(String typeName, String typeExpression) {
        this.typeName = typeName;
        this.typeExpression = typeExpression != null ? typeExpression : typeName;
        return this;
    }

    @Override
    public ColumnEditorImpl representType(JdbcType representType) {
        this.representType = representType;
        return this;
    }

    @Override
    public ColumnEditorImpl nativeType(JdbcType nativeType) {
        this.nativeType = nativeType;
        return this;
    }

    @Override
    public ColumnEditor charsetName(String charsetName) {
        this.charsetName = charsetName;
        return this;
    }

    @Override
    public ColumnEditor charsetNameOfTable(String charsetName) {
        this.tableCharsetName = charsetName;
        return this;
    }

    @Override
    public ColumnEditorImpl length(int length) {
        assert length >= -1;
        this.length = length;
        return this;
    }

    @Override
    public ColumnEditorImpl scale(Integer scale) {
        this.scale = scale;
        return this;
    }

    @Override
    public ColumnEditorImpl optional(boolean optional) {
        this.optional = optional;
        if (optional && !hasDefaultValue()) {
            // Optional columns have implicit NULL default value
            defaultValue(null);
        }
        return this;
    }

    @Override
    public ColumnEditorImpl autoIncremented(boolean autoIncremented) {
        this.autoIncremented = autoIncremented;
        return this;
    }

    @Override
    public ColumnEditorImpl generated(boolean generated) {
        this.generated = generated;
        return this;
    }

    @Override
    public ColumnEditorImpl position(int position) {
        this.position = position;
        return this;
    }

    @Override
    public ColumnEditor defaultValue(final Object defaultValue) {
        this.hasDefaultValue = true;
        this.defaultValue = defaultValue;
        return this;
    }

    @Override
    public ColumnEditor unsetDefaultValue() {
        this.hasDefaultValue = false;
        this.defaultValue = null;
        return this;
    }

    @Override
    public ColumnEditor enumValues(List<String> enumValues) {
        this.enumValues = enumValues;
        return this;
    }
    @Override
    public ColumnEditor pk(Boolean  isPK){
        this.isPK = isPK ;
        return this;
    }

    @Override
    public Boolean isPK() {
        return isPK;
    }

    @Override
    public Column create() {

        /**
         * 此部分与 JDBCTYPE  de 枚举类相关联
         */

        Column column = null ;

        switch (this.nativeType){
            case CHAR:
            case VARCHAR:
            case LONGNVARCHAR:
                 column = new StringColumn(this);
                 return column ;

            case TINYINT:
            case SMALLINT:
                column = new ShortColumn(this);
                return column;

            case INTEGER:
                column = new IntegerColumn(this);
                return column ;
            case REAL:
            case FLOAT:
                column = new FloatColumn(this);
                return column ;
            case DOUBLE:
                column  = new DoubleColumn(this);
                return column;
            case BIT:
            case BOOLEAN:
                column = new BooleanColumn(this);
                return column ;
            case BIGINT:
                column = new LongColumn(this);
                return column ;
            case DECIMAL:
            case NUMERIC:
                column = new BigDecimalColumn(this);
                return column;
            case NULL:
                column = new NullColumn(this);
                return column ;
            case DATE:
                column = new LocalDateColumn(this);
                return column ;
            case TIME:
                column = new LocalTimeColumn(this);
                return column ;
            case TIMESTAMP:
                column = new LocalDateTImeColumn(this);
                return column ;
            case TIMESTAMP_WITH_TIMEZONE:
                column = new OffsetDateTimeColumn(this);
                return column ;
            default:
                column =new ObjectColumn(this);
                return column;

        }

    }



    @Override
    public String toString() {
        return create().toString();
    }
}
