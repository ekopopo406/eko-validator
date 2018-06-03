package com.eko.security.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.eko.security.filter.TimeFilter;
import com.eko.security.interceptor.TimeInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	@Bean
	public FilterRegistrationBean timeFilter(){
		FilterRegistrationBean regBean = new FilterRegistrationBean();
		
		TimeFilter tf = new TimeFilter();
		regBean.setFilter(tf);
		List<String> url = new ArrayList<String>();
		url.add("/*");
		regBean.setUrlPatterns(url);
		
		return regBean;
	}
	
	@Autowired
	private TimeInterceptor timeInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(timeInterceptor);
	}
	
	
}
