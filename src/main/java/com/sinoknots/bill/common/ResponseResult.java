package com.sinoknots.bill.common;

import java.io.Serializable;

/**
 * 返回结果
 * 
 * @author sinoknots
 * @version V1.0.0
 * @since V1.0.0(2019-06-12 00:38)
 */
public class ResponseResult implements Serializable {
	private static final long serialVersionUID = 21346791533724943L;

	private String status;
	private String code;
	private String message;
	private Object result;
	private Long timestamp = System.currentTimeMillis();

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
