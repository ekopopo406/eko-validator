package com.eko.security.social.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

import com.eko.security.properties.QQProperties;
import com.eko.security.properties.SecurityProperties;
import com.eko.security.social.qq.api.connect.QQConnectionFactory;
@Configuration
@ConditionalOnProperty(prefix="com.eko.security.social.config.qq",name="app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter{
	@Autowired
	private SecurityProperties  securityProperties;
	
	@Override
	protected ConnectionFactory<?> createConnectionFactory() {
		QQProperties qqProperties = securityProperties.getSocial().getQq();
		
		return new QQConnectionFactory(qqProperties.getProviderId(), qqProperties.getAppId(), qqProperties.getAppSecret());
	}

}
