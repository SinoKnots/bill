package com.sinoknots.bill.config;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.JSONObject;

@Configuration
public class MyFilterConfig {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean filterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new MyRequestPrintFilter());
		List<String> urlList = new ArrayList<String>();
		urlList.add("/*");
		registration.setUrlPatterns(urlList);
		registration.setName("UrlFilter");
		registration.setOrder(1);
		return registration;
	}
}

class MyRequestPrintFilter implements Filter {
	private Logger logger = LoggerFactory.getLogger(MyRequestPrintFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		ServletRequest requestWrapper = null;
		if (request instanceof HttpServletRequest) {
			requestWrapper = new BodyReaderHttpServletRequestWrapper((HttpServletRequest) request);
		}
		if (null == requestWrapper) {
			chain.doFilter(request, response);
		} else {
			if(getParams((HttpServletRequest) requestWrapper) != null && !"".equals(getParams((HttpServletRequest) requestWrapper))) {
				String paramsStr = getParams((HttpServletRequest) requestWrapper);
				JSONObject json = (JSONObject) JSONObject.parse(paramsStr);
				long operateTime = json.getLongValue("operateTime");
				long now = System.currentTimeMillis();
				logger.info(String.format("向%s发起请求，请求参数为：%s", ((HttpServletRequest) request).getRequestURI(), json.toJSONString()));
			}
			chain.doFilter(requestWrapper, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	private String getParams(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				sb.append(line.trim());
			}
		} catch (Exception e) {
			logger.info("获取请求参数失败", e);
		}
		return sb.toString().trim();
	}
	
	class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {
		private final byte[] body;
		
		public BodyReaderHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
			super(request);
			body = toByteArray(request.getInputStream());
		}
		
		private byte[] toByteArray(InputStream in) throws IOException {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024 * 4];
			int n = 0;
			while ((n = in.read(buffer)) != -1) {
				out.write(buffer, 0, n);
			}
			return out.toByteArray();
		}
		
		@Override
		public BufferedReader getReader() throws IOException {
			return new BufferedReader(new InputStreamReader(getInputStream()));
		}
		
		@Override
		public ServletInputStream getInputStream() throws IOException {
			final ByteArrayInputStream bais = new ByteArrayInputStream(body);
			return new ServletInputStream() {
				@Override
				public int read() throws IOException {
					return bais.read();
				}
				
				@Override
				public boolean isFinished() {
					return false;
				}
				
				@Override
				public boolean isReady() {
					return false;
				}
				
				@Override
				public void setReadListener(ReadListener listener) {
					
				}
			};
		}
	}
}