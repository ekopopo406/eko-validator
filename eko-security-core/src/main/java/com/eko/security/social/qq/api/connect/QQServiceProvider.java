package com.eko.security.social.qq.api.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Template;

import com.eko.security.social.qq.api.QQ;
import com.eko.security.social.qq.api.QQImpl;

public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {
	private String appId;
	private static final String URL_AUTH="https://graph.qq.com/oauth2.0/authorize";
	private static final String URL_ACCESSTOKEN="https://graph.qq.com/oauth2.0/token";
	//等于是box的clientID和clientSecret，由box方提供的，注册应用是提供的。
	public QQServiceProvider(String appId,String appSecret) {
		super(new QQOAuth2Template(appId, appSecret, URL_AUTH, URL_ACCESSTOKEN));
		this.appId=appId;
	}

	//arg0=accesstoken
	@Override
	public QQ getApi(String arg0) {
		// TODO Auto-generated method stub
		return new QQImpl(arg0,appId);
	}

}
