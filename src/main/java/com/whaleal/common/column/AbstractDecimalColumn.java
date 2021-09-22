package com.whaleal.common.column;


/**
 * @author wh
 * @date 2021/9/21 9:28 下午
 */
public abstract class AbstractDecimalColumn<T>  extends AbstractColumn<T>{


    public AbstractDecimalColumn(ColumnEditor editor) {
        super(editor);
    }

    @Override
    public final Object asObject() {
        return asDecimal();
    }

}
