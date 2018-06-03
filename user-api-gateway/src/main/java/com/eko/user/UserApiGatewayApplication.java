package com.eko.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eko.user.config.NewRuelConfig;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableCircuitBreaker
@Controller
@RibbonClient(name="user",configuration=NewRuelConfig.class)
@EnableZuulProxy
public class UserApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApiGatewayApplication.class, args);
	}
	@Autowired
	private DiscoveryClient  discoveryClient;
	
	@RequestMapping("index1")
	@ResponseBody
	public List<ServiceInstance> getRegisterInstance(){
		return discoveryClient.getInstances("USER");
	}
}
