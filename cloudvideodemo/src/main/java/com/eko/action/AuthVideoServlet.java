package com.eko.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.eko.util.TimeUtil;
import com.google.gson.Gson;

public class AuthVideoServlet extends BaseServlet {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ustreamContentType = request.getParameter("ustreamContentType");
		String ustreamContentId = request.getParameter("ustreamContentId");
		System.out.println(ustreamContentType+"-"+ustreamContentId);
		Gson json = new Gson();
		 
		Map<String,String> jsonMap1 = new HashMap<String,String>();
		Map<String,String> jsonMap2 = new HashMap<String,String>();
		Map<String,String> jsonMap3 = new HashMap<String,String>();
		jsonMap1.put("user", "");
		jsonMap2.put("hash", "e10adc3949ba59abbe56e057f20f883e");
		jsonMap3.put("hashExpire", String.valueOf(TimeUtil.convDateToZeroLong("2018-05-01 12:00:00")/1000L));
		
		List<Map<String,String>> theArr = new ArrayList<Map<String,String>>();
		theArr.add(jsonMap1);
		theArr.add(jsonMap2);
		theArr.add(jsonMap3);
		String theHashLockStr = json.toJson(theArr);
		System.out.println(theHashLockStr);
	String unlockVideo = "https://www.ustream.tv/embed/hashlock/pass?hash=";
	List<NameValuePair> someParams = new ArrayList<NameValuePair>();	
	someParams.add(new BasicNameValuePair("hash",
			theHashLockStr));
//	RequestDispatcher dispatcher = request
//			.getRequestDispatcher(unlockVideo+theHashLockStr);
//	dispatcher.forward(request, response);
	response.sendRedirect(unlockVideo+theHashLockStr);
	}

}
