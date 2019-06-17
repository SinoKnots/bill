package com.sinoknots.bill.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * WebMVC 自定义配置类
 * 
 * @author sinoknots
 * @version V1.0.0
 * @since V1.0.0(2019-06-12 20:39)
 */
@SuppressWarnings("deprecation")
@Configuration
public class WebMVCConfig extends WebMvcConfigurerAdapter {

	/**
	 * 将/swagger-ui.html这个路径映射到对应的目录META-INF/resources/下面
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}