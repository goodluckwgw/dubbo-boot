package com.github.bootapi.exception;

/**
 * ice异常
 * 
 * @author <a href="mailto:gengcai.xie@skyroam.com">Xie Gengcai</a>
 * @version 1.0
 */
public class IceException extends RuntimeException {

	private static final long serialVersionUID = 4380345178425283103L;

	public IceException() {
	}

	public IceException(String message) {
		super(message);
	}

	public IceException(String message, Throwable cause) {
		super(message, cause);
	}

	public IceException(Throwable cause) {
		super(cause);
	}
}
