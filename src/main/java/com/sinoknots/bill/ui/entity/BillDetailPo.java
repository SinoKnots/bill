package com.sinoknots.bill.ui.entity;

import com.sinoknots.bill.common.BaseEntity;

/** 
* 
* @author sinoknots 
* @version V1.0.0
* @since V1.0.0(2019-06-11 21:13:21)
*/
public class BillDetailPo extends BaseEntity {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    private String billId;

    /**
     * 类型编号
     */
    private String typeId;

    /**
     * 金额，单位分
     */
    private Long amount;

    /**
     * 账单类型编号
     */
    private String useTypeId;

    /**
     * 描述
     */
    private String billDesc;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
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
        this.useTypeId = useTypeId == null ? null : useTypeId.trim();
    }

    public String getBillDesc() {
        return billDesc;
    }

    public void setBillDesc(String billDesc) {
        this.billDesc = billDesc == null ? null : billDesc.trim();
    }
}