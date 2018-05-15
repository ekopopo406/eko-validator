/*******************************************************************************
 *
 *  IBM Confidential
 *  
 *  OCO Source Materials
 *
 *  5747-SM3
 *
 *  (C) Copyright IBM Corp. 2015, 2017 All Rights Reserved.
 *
 *  The source code for this program is not published or otherwise divested 
 *  of its trade secrets, irrespective of what has been deposited with 
 *  the U.S. Copyright office .
 *
 *******************************************************************************/
package com.eko.util;

import java.net.URI;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import com.eko.upload.Config;

public class HttpUtil {

	private static Registry<ConnectionSocketFactory> getRegistry()
			throws KeyManagementException, NoSuchAlgorithmException {
		SSLContext sslContext = SSLContexts.custom().build();
		SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext,
				new String[] { "TLSv1.2" }, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
		return RegistryBuilder.<ConnectionSocketFactory> create()
				.register("http", PlainConnectionSocketFactory.getSocketFactory())
				.register("https", sslConnectionSocketFactory).build();
	}

	public static String send(String url, List<NameValuePair> nvps, String refer) {
		String body = "";
		try {
			PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(getRegistry());
			CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connMgr).build();
			URI formUri = new URI(url + "?" + URLEncodedUtils.format(nvps, "utf-8"));
			HttpGet get = new HttpGet(formUri);

			get.setHeader("Authorization", "Bearer " + "b8a467c29b6681e548d64c0515bde7a0754aa349");
			CloseableHttpResponse response = httpClient.execute(get);
			HttpEntity entity = response.getEntity();
			if (entity != null) {

				body = EntityUtils.toString(entity, Consts.UTF_8);
			}
			EntityUtils.consume(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return body;
	}

	public static String sendPost(String url, List<NameValuePair> nvps, String refer) {
		String body = "";
		try {
			PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(getRegistry());
			CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connMgr).build();
			URI formUri = new URI(url);
			HttpPost post = new HttpPost(formUri);
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvps, "UTF-8");
			post.setEntity(entity);
			post.setHeader( "Authorization","Basic "+"586b76a99a9cae0adb2eaa43e6b27711701ab9f7");
			CloseableHttpResponse response = httpClient.execute(post);
			HttpEntity responseEntity = response.getEntity();
			if (responseEntity != null) {

				body = EntityUtils.toString(responseEntity, Consts.UTF_8);
			}
			EntityUtils.consume(responseEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return body;
	}
	public static String sendPostWithAccessToken(String url, List<NameValuePair> nvps, String refer) {
		String body = "";
		try {
			PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(getRegistry());
			CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connMgr).build();
			URI formUri = new URI(url);
			HttpPost post = new HttpPost(formUri);
 
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvps, "UTF-8");
			post.setEntity(entity);
			post.setHeader( "Authorization","Bearer "+"b8a467c29b6681e548d64c0515bde7a0754aa349");
			CloseableHttpResponse response = httpClient.execute(post);
			HttpEntity responseEntity = response.getEntity();
			if (responseEntity != null) {

				body = EntityUtils.toString(responseEntity, Consts.UTF_8);
			}
			EntityUtils.consume(responseEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return body;
	}
	public static String sendPutWithAccessToken(String url, List<NameValuePair> nvps, String refer) {
		String body = "";
		try {
			PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(getRegistry());
			CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connMgr).build();
			URI formUri = new URI(url);
		 
			HttpPut put = new HttpPut(formUri);
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvps, "UTF-8");
			put.setEntity(entity);
			put.setHeader( "Authorization","Bearer "+"b8a467c29b6681e548d64c0515bde7a0754aa349");
			CloseableHttpResponse response = httpClient.execute(put);
			HttpEntity responseEntity = response.getEntity();
			if (responseEntity != null) {

				body = EntityUtils.toString(responseEntity, Consts.UTF_8);
			}
			EntityUtils.consume(responseEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return body;
	}
	public static String sendDeleteWithAccessToken(String url, List<NameValuePair> nvps, String refer) {
		String body = "";
		try {
			PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(getRegistry());
			CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connMgr).build();
			URI formUri = new URI(url);
		 
			HttpDelete delete = new HttpDelete(formUri);
	
			delete.setHeader( "Authorization","Bearer "+"b8a467c29b6681e548d64c0515bde7a0754aa349");
			CloseableHttpResponse response = httpClient.execute(delete);
			HttpEntity responseEntity = response.getEntity();
			if (responseEntity != null) {

				body = EntityUtils.toString(responseEntity, Consts.UTF_8);
			}
			EntityUtils.consume(responseEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return body;
	}
	private static String encode(byte[] binaryData) {
		String str = "";
		try {
			Base64 base64 = new Base64();
			str = new String(base64.encode(binaryData));
			return str;
		} catch (Exception e) {
			return str;
		}
	}

	public static HttpClient getHttpClient() {
		CloseableHttpClient httpClient = null;
		try {
			PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(getRegistry());
			connMgr.setMaxTotal(Config.maxUpload);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(Config.timeOut).setConnectTimeout(10 * 1000).build();
			httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).setConnectionManager(connMgr).build();
		} catch  (Exception e) {
			e.printStackTrace();
			return null;
		}
		return httpClient;
	}
}
