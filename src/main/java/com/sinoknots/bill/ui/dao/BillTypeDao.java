package com.sinoknots.bill.ui.dao;

import com.sinoknots.bill.ui.entity.BillTypePo;
import java.util.List;

/**
* 
* @author sinoknots 
* @version V1.0.0
* @since V1.0.0(2019-06-11 21:13:21)
*/
public interface BillTypeDao {
    int deleteByPrimaryKey(String typeId);

    int insert(BillTypePo record);

    BillTypePo selectByPrimaryKey(String typeId);

    List<BillTypePo> selectAll();

    int updateByPrimaryKey(BillTypePo record);
}