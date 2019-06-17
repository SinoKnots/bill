package com.sinoknots.bill.common;

import java.io.Serializable;

/**
 * 实体基类
 * 
 * @author sinoknots
 * @version V1.0.0
 * @since V1.0.0(201906102244)
 */
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 4464040105389239419L;

	private Long createTime;
	private String createrId;
	private String creater;
	private Long lastOperateTime;
	private String lastOperater;

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public Long getLastOperateTime() {
		return lastOperateTime;
	}

	public void setLastOperateTime(Long lastOperateTime) {
		this.lastOperateTime = lastOperateTime;
	}

	public String getLastOperater() {
		return lastOperater;
	}

	public void setLastOperater(String lastOperater) {
		this.lastOperater = lastOperater;
	}

}
