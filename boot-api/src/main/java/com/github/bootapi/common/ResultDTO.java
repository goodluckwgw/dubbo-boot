/**
 * 
 */
package com.github.bootapi.common;

import java.io.Serializable;

/** <p>Title: ResultDO</p>
 * <p>Description:返回对象(远程接口统一返回该对象) 必须可序列化</p>
 */
public class ResultDTO<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8577576196604864472L;
	
	/*
     * 返回模型
     */
    private T data;

    /*
     * 错误码
     */
    private String errorCode;

    /*
     * 是否业务成功
     */
    private boolean success;

   
    
    public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
	
	

}
