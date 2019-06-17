package com.sinoknots.bill.ui.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sinoknots.bill.common.ResponseCodeEnum;
import com.sinoknots.bill.common.ResponseResult;
import com.sinoknots.bill.ui.dao.BillDetailDao;
import com.sinoknots.bill.ui.entity.BillDetailPo;
import com.sinoknots.bill.ui.service.IBillDetailService;
import com.sinoknots.bill.ui.service.vo.BillDetailReqVo;

@Service
public class BillDetailService implements IBillDetailService {
	
	@Autowired
	private BillDetailDao billDetailDao;

	@Override
	public ResponseResult pagelist(BillDetailReqVo vo) {
		ResponseResult rr = new ResponseResult();
		
		// TODO 为了程序的严谨性，判断非空：
		// 分页开始
		//1、设置分页信息，包括当前页数和每页显示的总计数
        PageHelper.startPage(vo.getPage(), vo.getPageSize());
        // 2. 获取数据
        List<BillDetailPo> list = billDetailDao.selectAll();
		//3、获取分页查询后的数据
        PageInfo<BillDetailPo> pageInfo = new PageInfo<>(list);
        
        Map<String, Object> pageResult = new HashMap<String, Object>();
        pageResult.put("total", pageInfo.getTotal());
        pageResult.put("rows", list);
		
		rr.setCode(ResponseCodeEnum.SUCCESS.getCode());
		rr.setMessage("查询成功");
		rr.setStatus(HttpStatus.OK.toString());
		rr.setResult(pageResult);
		return rr;
	}

}
