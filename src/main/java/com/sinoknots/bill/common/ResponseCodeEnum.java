package com.sinoknots.bill.common;

/**
 * 请求响应Code枚举类
 * 
 * @author sinoknots
 * @version V1.0.0
 * @since V1.0.0(2019-06-12 00:41)
 */
public enum ResponseCodeEnum {
	/**
	 * 成功
	 */
	SUCCESS("0000"),
	/**
	 * 请求参数验证失败
	 */
	REQUEST_PARAMS_INVALID("0001"),
	/**
	 * 服务异常
	 */
	SERVER_EXCEPTION("0002"),
	/**
	 * 请求失效
	 */
	REQUEST_INVALID("0003");
	
	private String code;
	private ResponseCodeEnum(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
