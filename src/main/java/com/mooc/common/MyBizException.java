package com.mooc.common;

public class MyBizException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MyBizException(final String message) {
        super(message);
    }
}
