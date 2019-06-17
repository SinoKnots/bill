package com.sinoknots.bill.ui.dao;

import com.sinoknots.bill.ui.entity.BillDetailPo;
import java.util.List;

/**
* 
* @author sinoknots 
* @version V1.0.0
* @since V1.0.0(2019-06-11 21:13:21)
*/
public interface BillDetailDao {
    int deleteByPrimaryKey(String billId);

    int insert(BillDetailPo record);

    BillDetailPo selectByPrimaryKey(String billId);

    List<BillDetailPo> selectAll();

    int updateByPrimaryKey(BillDetailPo record);
}