package com.eko.security.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/localRedirect")
public class OAuthRedirectController {
	public static final URL_LOCAL_AUTH = "http://127.0.0.1:8080/auth/token";
	@GetMapping("/authcode")
	@ResponseBody
	public String getAuthCode(@RequestParam String code){
		System.out.println(code);
		return code;
	}
}
