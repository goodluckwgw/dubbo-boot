package com.github.bootapi.exception;

/**
 * 错误类型，暂时先这么干了
 * @date 2014-06-01
 */
public abstract class ErrorType {

    public final static String noError = "0";
	/**方法或版本找不到*/
    public final static String methodError = "1";
	
	/**时间戳错误*/
    public final static String timestampError = "2";
	
	/**方法已经被废弃*/
    public final static String obsoletedError = "3";
	
	/**post get 不支持*/
    public final static String actionError = "4";
	
	/**appKey不存在*/
    public final static String appKeyError = "5";
	
	/**会话超时*/
    public final static String sessionError = "6";
	
	/**签名错误*/
    public final static String signError = "7";
	
	/**参数不合法*/
    public final static String parametersError = "8";
	
	/**超出资源最大服务*/
    public final static String maxSourcesError = "9";
	
	/**执行超时*/
    public final static String timeoutError = "10";
	
	/**执行错误*/
    public final static String executeError = "11";
    
    /**异步执行错误*/
    public final static String AsyncError="12";
	
}
