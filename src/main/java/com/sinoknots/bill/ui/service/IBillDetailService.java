package com.sinoknots.bill.ui.service;

import com.sinoknots.bill.common.ResponseResult;
import com.sinoknots.bill.ui.service.vo.BillDetailReqVo;

/**
 * 账单明细服务接口
 * 
 * @author sinoknots
 * @version V1.0.0
 * @since V1.0.0(2019-06-12 20:05)
 */
public interface IBillDetailService {

	/**
	 * 账单明细列表查询
	 * 
	 * @param vo
	 * @return
	 */
	ResponseResult pagelist(BillDetailReqVo vo);
}
