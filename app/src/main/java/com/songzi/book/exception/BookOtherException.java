package com.songzi.book.exception;

/**
 * 类说明： 	其他异常
 * 
 * @author 	Cundong
 * @date 	2014-6-16
 * @version 1.0
 */
public class BookOtherException extends BookException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookOtherException(String msg) {
		super(msg);
	}

	public BookOtherException(String msg, Exception cause) {
		super(msg, cause);
	}

}