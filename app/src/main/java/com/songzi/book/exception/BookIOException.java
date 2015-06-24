package com.songzi.book.exception;

/**
 * 类说明： IO类异常
 * 
 * @author 	Cundong
 * @date 	2014-6-16
 * @version 1.0
 */
public class BookIOException extends BookException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookIOException(String msg) {
		super(msg);

		this.errorCode = CONNECTED_ERORR;
	}

	public BookIOException(String msg, Exception cause) {
		super(msg, cause);

		this.errorCode = CONNECTED_ERORR;
	}

}