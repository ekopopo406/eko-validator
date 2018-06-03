package com.eko.security.social.qq.api;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class QQImpl extends AbstractOAuth2ApiBinding implements QQ{
	private String appId;
	private String openId;
	private ObjectMapper objectMap = new ObjectMapper();
	private static final String URL_GET_USEINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";
	private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";
	@Override
	public QQUserInfo getQQUserInfo() {
		try {
			String url =  String.format(URL_GET_USEINFO,appId,openId);
			String result = getRestTemplate().getForObject(url, String.class);
			System.out.println(result);
			QQUserInfo qqUserInfo = objectMap.readValue(result, QQUserInfo.class);
			qqUserInfo.setOpenId(openId);
			return qqUserInfo;
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("get QQ user info failure" +e.getMessage(),e);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("get QQ user info failure" +e.getMessage(),e);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("get QQ user info failure" +e.getMessage(),e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("get QQ user info failure" +e.getMessage(),e);
		}
	}
	public QQImpl(String accessToken,String appId){
		super(accessToken,TokenStrategy.ACCESS_TOKEN_PARAMETER);
		this.appId=appId;
		String url = String.format(URL_GET_OPENID, accessToken);
		String result = getRestTemplate().getForObject(url, String.class);
		System.out.println(result);
		this.openId=StringUtils.substringBetween(result, "\"openId\":","}");
	}
}
