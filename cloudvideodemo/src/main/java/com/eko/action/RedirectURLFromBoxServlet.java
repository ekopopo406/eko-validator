package com.eko.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.box.sdk.BoxAPIConnection;
import com.box.sdk.BoxAPIException;
import com.box.sdk.BoxUser;
import com.eko.util.HttpUtilss;

import net.sf.json.JSONObject;

public class RedirectURLFromBoxServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 275129331687962629L;
	private static final String exchangeAuthCodeURL = "https://www.ustream.tv/oauth2/token";

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 System.out.println(request.getAttribute("name"));
//		String boxstate = request.getParameter("state");
//		String authCode = request.getParameter("code");// alive time 30 seconds
//		System.out.println(authCode);
//		String responseString = null;
//		try {
//			CloseableHttpClient client = HttpUtilss.initHttpClient();
//			HttpPost httpPost = new HttpPost(exchangeAuthCodeURL);
//			List<NameValuePair> GWparameters = new ArrayList<NameValuePair>();
//			GWparameters.add(new BasicNameValuePair("grant_type",
//					"authorization_code"));
//			GWparameters.add(new BasicNameValuePair("code", authCode));
////			GWparameters.add(new BasicNameValuePair("client_id",
////					"h11dmt34wn5x7vf71ghmozxszjftj21l"));
////			GWparameters.add(new BasicNameValuePair("client_secret",
////					"kXwCbLvdSx4tlkLFeIf99Luwe7ns83hB"));
//			
//			GWparameters.add(new BasicNameValuePair("client_id",
//					"vj600hzaswm9ckqe0aq9s2zmxur168qb"));
//			GWparameters.add(new BasicNameValuePair("client_secret",
//					"t2PaEhQB6XgGJb41JRicIaFT0xrcmWpc"));
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
//			String accessTkoen = json.getString("access_token");
//			String refreshTkoen = json.getString("refresh_token");
//		  
//			PrintWriter pw = response.getWriter();
//			pw.write(json.toString());
//
//			pw.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return;
	}

	public static void main(String[] args) {
		String responseString = null;
		try {
			CloseableHttpClient client = HttpUtilss.initHttpClient();
			HttpPost httpPost = new HttpPost(exchangeAuthCodeURL);
			List<NameValuePair> GWparameters = new ArrayList<NameValuePair>();
			GWparameters.add(new BasicNameValuePair("grant_type",
					"authorization_code"));
			GWparameters.add(new BasicNameValuePair("code", "fy64aF1FnfEnhij6Llr5hnJteiA34Tqq"));
			GWparameters.add(new BasicNameValuePair("client_id",
					"h11dmt34wn5x7vf71ghmozxszjftj21l"));
			GWparameters.add(new BasicNameValuePair("client_secret",
					"kXwCbLvdSx4tlkLFeIf99Luwe7ns83hB"));
			
//			GWparameters.add(new BasicNameValuePair("client_id",
//					"3expyvyk8piden5ui5ecm4kb1qps34go"));
//			GWparameters.add(new BasicNameValuePair("client_secret",
//					"j5LTWsn4npJ0pqcQ5jOuB3teDozwLJji"));
//			GWparameters.add(new BasicNameValuePair("client_id",
//					"zz0msfvizm524a9de326upq6sxtq9vef"));
//			GWparameters.add(new BasicNameValuePair("client_secret",
//					"Nqru8ZgF1pABJkcMtc0yZzpfI3QkOJFl"));
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(
					GWparameters, "UTF-8");
			httpPost.setEntity(entity);
			CloseableHttpResponse theResponse = client.execute(httpPost);
			if (theResponse != null) {
				HttpEntity resEntity = theResponse.getEntity();
				if (resEntity != null) {
					responseString = EntityUtils.toString(resEntity, "UTF-8");
				}
			}
			System.out.println(responseString);
			JSONObject json = JSONObject.fromObject(responseString);
			String accessTkoen = json.getString("access_token");
			String refreshTkoen = json.getString("refresh_token");
		  
//			PrintWriter pw = response.getWriter();
//			pw.write(json.toString());
//
//			pw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		String responseString = null;
 	try {
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
