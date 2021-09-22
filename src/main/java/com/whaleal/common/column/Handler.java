package com.whaleal.common.column;

/**
 * @author wh
 * @date 2021/9/17 10:17 上午
 *
 * 一个接口
 * 主要用于 各个库自己的转换实现
 */
public interface Handler {

    abstract Object asRepresentValue(Column column ,JdbcType type);


}
