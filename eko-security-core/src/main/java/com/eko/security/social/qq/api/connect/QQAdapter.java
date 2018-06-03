package com.eko.security.social.qq.api.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

import com.eko.security.social.qq.api.QQ;
//QQ类型表示Abs OAuth2 api binding的类型，自定义实现类
public class QQAdapter implements ApiAdapter<QQ> {

	@Override
	public UserProfile fetchUserProfile(QQ arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConnectionValues(QQ api, ConnectionValues values) {
		// ConnectionValues的值从QQ类型自定义实现里取得
	  
			values.setDisplayName(api.getQQUserInfo().getNickname());
			values.setImageUrl(api.getQQUserInfo().getFigureurl_qq_1());
			values.setProfileUrl("this custom personal private web page link");
			values.setProviderUserId(api.getQQUserInfo().getOpenId());
	 
		
	}

	@Override
	public boolean test(QQ arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void updateStatus(QQ api, String message) {
		// notthing good to do for QQ
		
	}

}
