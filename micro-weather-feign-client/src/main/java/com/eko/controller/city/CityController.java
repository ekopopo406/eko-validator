package com.eko.controller.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eko.client.city.CityClient;

@RestController
public class CityController {

	@Autowired
	private CityClient cityClient;
	@GetMapping("cities")
	public String listCity(){
		String body = cityClient.listCity();
		return body;
	}
}
