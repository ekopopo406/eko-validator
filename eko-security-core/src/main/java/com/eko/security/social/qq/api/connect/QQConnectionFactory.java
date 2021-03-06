package com.eko.security.social.qq.api.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

import com.eko.security.social.qq.api.QQ;

public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {
//OAuth2ServiceProvider<QQ> serviceProvider, ApiAdapter<QQ> apiAdapter
	public QQConnectionFactory(String providerId,String appId,String appSecret ) {
		super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
		// TODO Auto-generated constructor stub
	}

}
