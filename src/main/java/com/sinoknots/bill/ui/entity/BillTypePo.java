package com.sinoknots.bill.ui.entity;

import com.sinoknots.bill.common.BaseEntity;

/** 
* 
* @author sinoknots 
* @version V1.0.0
* @since V1.0.0(2019-06-11 21:13:21)
*/
public class BillTypePo extends BaseEntity {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 类型编号
     */
    private String typeId;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 类型描述
     */
    private String typeDesc;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc == null ? null : typeDesc.trim();
    }
}