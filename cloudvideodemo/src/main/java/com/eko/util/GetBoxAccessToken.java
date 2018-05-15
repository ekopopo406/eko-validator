package com.eko.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.box.sdk.BoxAPIException;

import net.sf.json.JSONObject;

public class GetBoxAccessToken {
	
	private static final String exchangeAuthCodeURL = "https://www.ustream.tv/oauth2/token";
	private static final String cloudChannel = "https://api.ustream.tv/users/self/channels.json";
	private static final String videoUrl = "https://api.ustream.tv/channels/23520496/videos.json";
	private static final String embededUrl = "https://api.ustream.tv/channels/23520496/locks/embed.json";
	private static final String initInfoFtp = "https://api.ustream.tv/channels/23520496/uploads.json?type=videoupload-ftp";
	private static final String getAuthViewerSettings = "https://api.ustream.tv/channels/23520496/locks/hash.json";
	private static final String setAuthViewer = "https://api.ustream.tv/channels/23520496/locks/hash/advanced.json";
	private static final String removeAuthView = "https://api.ustream.tv/channels/23520496/locks/hash.json";
	private static final String ttt = "https://www.ustream.tv/embed/hashlock/pass?hash=RESPONSE_IN_JSON_FORMAT";
	private static final String uploadEndSingal = "https://api.ustream.tv/channels/23520496/uploads/113810965.json";
	
	private static final String checkUploadEndProcess = "https://api.ustream.tv/channels/23520496/uploads/113810965.json";
	public static void main(String[] args) {
		String responseString = null;
		try {
//			CloseableHttpClient client = HttpUtilss.initHttpClient();
//			HttpPost httpPost = new HttpPost(exchangeAuthCodeURL);
//			List<NameValuePair> GWparameters = new ArrayList<NameValuePair>();
//			GWparameters.add(new BasicNameValuePair("grant_type",
//					"authorization_code"));
//			GWparameters.add(new BasicNameValuePair("code", "dfa78d488b4818bd1531ac1539727001465ecd97"));
//			GWparameters.add(new BasicNameValuePair("client_id",
//					"9704eadd82441b37f7e1846b7a4fc9475d7f89ed"));
//			GWparameters.add(new BasicNameValuePair("client_secret",
//					"586b76a99a9cae0adb2eaa43e6b27711701ab9f7"));
//			GWparameters.add(new BasicNameValuePair("redirect_uri",
//					"http://127.0.0.1:8080"));
//
//			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(
//					GWparameters, "UTF-8");
//			httpPost.setEntity(entity);
//			CloseableHttpResponse theResponse = client.execute(httpPost);
//			if (theResponse != null) {
//				HttpEntity resEntity = theResponse.getEntity();
//				if (resEntity != null) {
//					responseString = EntityUtils.toString(resEntity, "UTF-8");
//				}
//			}
//			System.out.println(responseString);
//			JSONObject json = JSONObject.fromObject(responseString);
//			String accessTkoen = json.getString("access_token");
//			String refreshTkoen = json.getString("refresh_token");
//		  
//			PrintWriter pw = response.getWriter();
//			pw.write(json.toString());
//
//			pw.close();
			
//	cloud video start
			
//			CloseableHttpClient client = HttpUtilss.initHttpClient();
//			HttpPost httpPost = new HttpPost(exchangeAuthCodeURL);
//			List<NameValuePair> GWparameters = new ArrayList<NameValuePair>();
//			GWparameters.add(new BasicNameValuePair("grant_type",
//					"password"));
//			GWparameters.add(new BasicNameValuePair("client_id",
//					"9704eadd82441b37f7e1846b7a4fc9475d7f89ed"));
//			GWparameters.add(new BasicNameValuePair("client_secret",
// 					"586b76a99a9cae0adb2eaa43e6b27711701ab9f7"));
//			GWparameters.add(new BasicNameValuePair("username",
//					"vndgaoys@cn.ibm.com"));
//			GWparameters.add(new BasicNameValuePair("password",
//					"myEnigma406"));
//			responseString = HttpUtil.sendPost(exchangeAuthCodeURL, GWparameters, "UTF-8");
//			System.out.println(responseString);
			
			
//			GWparameters.add(new BasicNameValuePair("client_id",
//			"9ee37de9cbfca82872e3ae4c0045feb5fa4f7bb4"));
//	GWparameters.add(new BasicNameValuePair("client_secret",
//				"25db3a23a7570155e81d92b994f97501da92492a"));
//			GWparameters.add(new BasicNameValuePair("username",
//					"U0UJVC1QZWV"));
//			GWparameters.add(new BasicNameValuePair("password",
//					"Spring4funs"));
//		
//			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(
//			GWparameters, "UTF-8");
//			httpPost.setEntity(entity);
//		 	httpPost.setHeader( "Authorization","Basic "+"25db3a23a7570155e81d92b994f97501da92492a");
//			CloseableHttpResponse theResponse = client.execute(httpPost);
//			if (theResponse != null) {
//				HttpEntity resEntity = theResponse.getEntity();
//				if (resEntity != null) {
//					responseString = EntityUtils.toString(resEntity, "UTF-8");
//				}
//			}

//			
			
			List<NameValuePair> someParams = new ArrayList<NameValuePair>();	
			
//			String channelResult = HttpUtil.send(cloudChannel, someParams, "UTF-8");
//			System.out.println( channelResult);
//////			
////// 			
//			String videoResult = HttpUtil.send(videoUrl, someParams, "UTF-8");
//			System.out.println(videoResult);
//			
//			
//			List<NameValuePair> someParams = new ArrayList<NameValuePair>();	
// 			someParams.add(new BasicNameValuePair("title",
// 					"20180324-01"));
//			String videoResult = HttpUtil.sendPostWithAccessToken(initInfoFtp, someParams, "UTF-8");
//			System.out.println("the ftp info: "+videoResult);
			
			someParams.add(new BasicNameValuePair("status",
 				 "ready"));
			String videoUploadEndResult = HttpUtil.sendPutWithAccessToken(uploadEndSingal, someParams, "UTF-8");
			System.out.println("the ftp info: "+videoUploadEndResult);
			
//			String checkUploadStatus = HttpUtil.send(checkUploadEndProcess, someParams,  "UTF-8");
//			System.out.println(checkUploadStatus);
//		
//			String getAuthViewerSettingsResult = HttpUtil.send(getAuthViewerSettings, someParams, "UTF-8");
//			System.out.println(getAuthViewerSettingsResult);
//			
//			String removeAuthViewerStr = HttpUtil.sendDeleteWithAccessToken(removeAuthView,null,"UTF-8");
//			System.out.println(removeAuthViewerStr);
			//http:\\www.ustream.tv\recorded\113779120
//	 String lockHashChannelUrl = "http://127.0.0.1:8080/cloudvideodemo/page/login.jsp";
//	 String lockHashSecretKey = "123456";
//	 someParams.add(new BasicNameValuePair("url",
//			 lockHashChannelUrl));
//	 someParams.add(new BasicNameValuePair("secret",
//			 lockHashSecretKey));
//		String setViewerAuthResult = HttpUtil.sendPutWithAccessToken(setAuthViewer, someParams, "UTF-8");
//		System.out.println(setViewerAuthResult);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		String responseString = null;
 //	try {
//			CloseableHttpClient client = HttpUtil.initHttpClient();
//			HttpPost httpPost = new HttpPost(exchangeAuthCodeURL);
//			List<NameValuePair> GWparameters = new ArrayList<NameValuePair>();
//			GWparameters.add(new BasicNameValuePair("grant_type",
//					"authorization_code"));
//			GWparameters.add(new BasicNameValuePair("code", "gSUhg7mXyiOzUtHpXbx1BoSZEZTlZKLq"));
//			GWparameters.add(new BasicNameValuePair("client_id",
//					"3expyvyk8piden5ui5ecm4kb1qps34go"));
//			GWparameters.add(new BasicNameValuePair("client_secret",
//					"Nqru8ZgF1pABJkcMtc0yZzpfI3QkOJFl"));
////			GWparameters.add(new BasicNameValuePair("client_id",
////					"zz0msfvizm524a9de326upq6sxtq9vef"));
////			GWparameters.add(new BasicNameValuePair("client_secret",
////					"Nqru8ZgF1pABJkcMtc0yZzpfI3QkOJFl"));
//			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(
//					GWparameters, "UTF-8");
//			httpPost.setEntity(entity);
//			CloseableHttpResponse theResponse = client.execute(httpPost);
//			if (theResponse != null) {
//				HttpEntity resEntity = theResponse.getEntity();
//				if (resEntity != null) {
//					responseString = EntityUtils.toString(resEntity, "UTF-8");
//				}
//			}
//			System.out.println(responseString);
//			JSONObject json = JSONObject.fromObject(responseString);
//			String accessToken = json.getString("access_token");
//			String refreshToken = json.getString("refresh_token");
//		System.out.println(accessToken+"-"+refreshToken);
//			
			
//			BoxAPIConnection api = new BoxAPIConnection(
//					"5TigYICjdOo4E7no8TREorgc2H5Xht7G");
//			BoxUser.Info userInfo = BoxUser.getCurrentUser(api).getInfo();
//			System.out.println(userInfo.getID());
//			BoxFile boxFile = new BoxFile(api, "171407379511");
//			BoxFile.Info info = boxFile.getInfo();
//			FileOutputStream stream = new FileOutputStream("C://"+info.getName());
//			boxFile.download(stream);
//			stream.close();
//			BoxAPIConnection api = new BoxAPIConnection(
// 					"b86ANRT836yPunQYfaQxpkuo2Hj7JGAV");
//			if(api.needsRefresh()){
//				api.setRefreshToken("c3E273GerItprQtTAQ2TJyutLorDOhBUghfPH8SWBBGTxbkbtRXgvobUMrFNBxDf");
//				api.refresh();
//				System.out.println(api.getAccessToken());
//				System.out.println(api.getRefreshToken());
//				
//			}
//			BoxAPIConnection api = new BoxAPIConnection("3expyvyk8piden5ui5ecm4kb1qps34go","j5LTWsn4npJ0pqcQ5jOuB3teDozwLJji","jgXXlytpDKqxosFliluDaBjTXcWpuHEe","67xx21XTIFrIOfpSvjFGZo6yg8OzZhRupPtnCHP5kBNy63OYDaTqhiazVpsLYmwC");
//			 
//			if(api.needsRefresh()){
//				System.out.println("need");
//				System.out.println(api.getRefreshToken());
////				api.setRefreshToken("67xx21XTIFrIOfpSvjFGZo6yg8OzZhRupPtnCHP5kBNy63OYDaTqhiazVpsLYmwC");
////				api.refresh();
//				//String s = api.save();
//				//System.out.println(s);
//				System.out.println(api.getAccessToken());
//				System.out.println(api.getRefreshToken());
//			}
////			System.out.println(api.getAccessToken());
////			System.out.println(api.getRefreshToken());
		}  catch (BoxAPIException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getResponse());
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
