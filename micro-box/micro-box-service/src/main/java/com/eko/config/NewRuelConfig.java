package com.eko.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RandomRule;

public class NewRuelConfig {
	@Autowired
	private IClientConfig ribbonIClientConfig;
	@Bean
	public IPing ribbonIPing(IClientConfig config){
		return new PingUrl(false,"/health");
	}
	@Bean
	public IRule ribbonRule(IClientConfig config){
		//return new RandomRule();
		return new AvailabilityFilteringRule();
	}
}
