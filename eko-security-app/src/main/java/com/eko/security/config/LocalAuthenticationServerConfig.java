package com.eko.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class LocalAuthenticationServerConfig {
//http://127.0.0.1:8080/oauth/authorize?response_type=code&client_id=ff147c10-e91e-4428-bb92-4e3a681a2366&http://123.com&scope=all
}
