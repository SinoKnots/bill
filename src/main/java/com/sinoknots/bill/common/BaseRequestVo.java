package com.sinoknots.bill.common;

import java.io.Serializable;

/**
 * 请求参数基类
 * 
 * @author sinoknots
 * @version V1.0.0
 * @since V1.0.0(2019-06-12 20:11)
 */
public class BaseRequestVo implements Serializable {
	private static final long serialVersionUID = 3524890674058022105L;

	/**
	 * 操作人ID
	 */
	protected String operaterId;
	/**
	 * 操作时间
	 */
	protected Long operateTime;
	/**
	 * 当前页条数
	 */
	protected Integer pageSize;
	/**
	 * 当前页页数
	 */
	protected Integer page;

	public String getOperaterId() {
		return operaterId;
	}

	public void setOperaterId(String operaterId) {
		this.operaterId = operaterId;
	}

	public Long getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Long operateTime) {
		this.operateTime = operateTime;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

}
