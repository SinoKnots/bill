package com.sinoknots.bill.ui.service.vo;

import com.alibaba.fastjson.JSONObject;
import com.sinoknots.bill.common.BaseRequestVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 账单明细请求参数封装类
 * 
 * @author sinoknots
 * @version V1.0.0
 * @since V1.0.0(2019-06-12 21:03)
 */
@ApiModel(value="账单明细请求参数封装类", description="用于封装账单明细服务请求参数")
public class BillDetailReqVo extends BaseRequestVo {
	private static final long serialVersionUID = -7366204844212098700L;

	@ApiModelProperty(value="流水号")
    private String billId;

	@ApiModelProperty(value="类型编号")
    private String typeId;

	@ApiModelProperty(value="金额，单位分")
    private Long amount;

	@ApiModelProperty(value="账单类型编号")
    private String useTypeId;

	@ApiModelProperty(value="账单描述")
    private String billDesc;
	
	public String toString() {
		JSONObject json = new JSONObject();
		json.put("billId", billId);
		json.put("typeId", typeId);
		json.put("amount", amount);
		json.put("useTypeId", useTypeId);
		json.put("billDesc", billDesc);
		json.put("operaterId", super.operaterId);
		json.put("operateTime", super.operateTime);
		json.put("pageSize", super.pageSize);
		json.put("page", super.page);
		return json.toJSONString();
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getUseTypeId() {
		return useTypeId;
	}

	public void setUseTypeId(String useTypeId) {
		this.useTypeId = useTypeId;
	}

	public String getBillDesc() {
		return billDesc;
	}

	public void setBillDesc(String billDesc) {
		this.billDesc = billDesc;
	}
    
}
