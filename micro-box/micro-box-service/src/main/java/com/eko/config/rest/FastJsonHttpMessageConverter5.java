package com.eko.config.rest;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.springframework.http.MediaType;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.google.common.collect.Lists;

public class FastJsonHttpMessageConverter5 extends FastJsonHttpMessageConverter4 {
	
	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
	
	public FastJsonHttpMessageConverter5(){
		setDefaultCharset(DEFAULT_CHARSET);
		setSupportedMediaTypes(Lists.newArrayList(MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON_UTF8,new MediaType("application","*+json")));
	}


}
