package com.whaleal.common.column;

/**
 * @author wh
 * @date 2021/9/15 5:17 下午
 */
public class CastingException extends RuntimeException{
    public CastingException(JdbcType type){
        super(type.name());
    }

    public CastingException() {
    }

    public CastingException(final String message) {
        super(message);
    }

    public CastingException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CastingException(final Throwable cause) {
        super(cause);
    }
}
