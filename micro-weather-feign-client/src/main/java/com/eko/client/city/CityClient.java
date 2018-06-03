package com.eko.client.city;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("user")
public interface CityClient {
	@GetMapping("getusername")
	String listCity();
}
