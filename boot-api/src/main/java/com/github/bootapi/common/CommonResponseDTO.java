/**
 * 
 */
package com.github.bootapi.common;

import java.io.Serializable;

/*** <p>Title: CommonResponseDto</p>
 * <p>Description:通用返回对象，必须可序列化</p>
 */
public class CommonResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -954527522130217717L;
	

	private int result;

	private String errorMessage;

	public CommonResponseDTO() {
	}

	public CommonResponseDTO(int result) {
		this.result = result;
	}

	public CommonResponseDTO(int result, String errorMessage) {
		this.result = result;
		this.errorMessage = errorMessage;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
	

}
