package com.sinoknots.bill.common;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

/**
 * 请求参数转换成实体类的工具类
 * @author sinoknots
 *
 */
public class RequestUtils {

	/**
	 * 请求参数转换成实体类
	 * @param request
	 * @param clazz
	 * @return
	 */
	public static <T> Object requestParams2Entity(HttpServletRequest request, Class<T> clazz){
		JSONObject json = new JSONObject();
		Enumeration<String> nameEnum = request.getParameterNames();
		while(nameEnum.hasMoreElements()) {
			String name = nameEnum.nextElement();
			json.put(name, request.getParameter(name));
		}
		return JSONObject.toJavaObject(json, clazz);
	}
	
	/**
	 * 将HttpServletRequest的请求参数转换成JSON格式的字符串
	 * 
	 * @param request
	 * @return
	 */
	public static String requestParams2JsonString(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		Enumeration<String> nameEnum = request.getParameterNames();
		while(nameEnum.hasMoreElements()) {
			String name = nameEnum.nextElement();
			json.put(name, request.getParameter(name));
		}
		return json.toJSONString();
	}
}
