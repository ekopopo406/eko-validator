package com.eko.config.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GenericRestConfig {
	@Autowired
	private RestTemplate lbRestTemplate;
	@Autowired
	private RestTemplate directRestTemplate;
	
	private static final String directFlag = "direct://";
	
	public <T> ResponseEntity<T> post(String url, Object reqBody,ParameterizedTypeReference<T> responseType){
		RestTemplate template = getRestTemplate(url);
		url = url.replace(directFlag, "");
		return template.exchange(url, HttpMethod.POST,new HttpEntity(reqBody),responseType); 
	}
	public <T> ResponseEntity<T> get(String url,ParameterizedTypeReference<T> responseType){
		RestTemplate template = getRestTemplate(url);
		url = url.replace(directFlag, "");
		return template.exchange(url, HttpMethod.GET,HttpEntity.EMPTY,responseType); 
	}
	public <T> ResponseEntity<T> put(String url,ParameterizedTypeReference<T> responseType){
		RestTemplate template = getRestTemplate(url);
		url = url.replace(directFlag, "");
		return template.exchange(url, HttpMethod.PUT,HttpEntity.EMPTY,responseType); 
	}
	private RestTemplate getRestTemplate(String url){
		if(url.contains(directFlag)){
			return directRestTemplate;
		}else{
			return lbRestTemplate;
		}
	}
}
