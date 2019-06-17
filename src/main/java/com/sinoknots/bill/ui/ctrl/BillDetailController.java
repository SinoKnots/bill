package com.sinoknots.bill.ui.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sinoknots.bill.common.ResponseResult;
import com.sinoknots.bill.ui.service.IBillDetailService;
import com.sinoknots.bill.ui.service.vo.BillDetailReqVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="Bill detail controller")
@RestController
@RequestMapping("/billDetail")
public class BillDetailController {
	private Logger logger = LoggerFactory.getLogger(BillDetailController.class);
	
	@Autowired
	private IBillDetailService billDetailService;

	@ApiOperation(value="账单明细列表查询", notes="账单明细列表查询", response = ResponseResult.class, tags = {"账单明细" })
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "typeId", value = "类型编号", dataType = "String",paramType = "query", required=false), 
		@ApiImplicitParam(name = "page", value = "当前页数1开始", dataType = "int",paramType = "query", required=true), 
		@ApiImplicitParam(name = "pageSize", value = "每页的大小", dataType = "int",paramType = "query", required=true), 
		@ApiImplicitParam(name = "operateTime", value = "操作时间", dataType = "Long",paramType = "query", required=true), 
		@ApiImplicitParam(name = "operaterId", value = "当前登录的用户id", dataType = "String",paramType = "query", required=true) 
	})
	@ApiResponses({
		@ApiResponse(code=200,message="请求成功"),
        @ApiResponse(code=400,message="请求参数没填好"),
        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
	@RequestMapping(value="/pagelist", produces={"application/json"}, method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	@ResponseBody
	public ResponseResult pagelist(@RequestBody BillDetailReqVo vo){
		return billDetailService.pagelist(vo);
	}
}
