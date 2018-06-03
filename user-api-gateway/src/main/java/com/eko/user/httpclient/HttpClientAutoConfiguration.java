package com.eko.user.httpclient;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.httpclient.LogbookHttpRequestInterceptor;
import org.zalando.logbook.httpclient.LogbookHttpResponseInterceptor;

@Configuration
@ConditionalOnClass({HttpClient.class})
@EnableConfigurationProperties(HttpClientProperties.class)
public class HttpClientAutoConfiguration {

	private final HttpClientProperties properties;
	
	public HttpClientAutoConfiguration(HttpClientProperties properties){
		this.properties = properties;
	}
	@Autowired
	private LogbookHttpRequestInterceptor logbookHttpRequestInterceptor;
	@Autowired
	private LogbookHttpResponseInterceptor logbookHttpResponseInterceptor;
	/**
	 * httpclient bean 的定义
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(HttpClient.class)
	public HttpClient httpClient(){
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(properties.getConnectTimeOut())
				.setSocketTimeout(properties.getSocketTimeOut()).build();//构建requestConfig
		HttpClient client = HttpClientBuilder.create()
				.setDefaultRequestConfig(requestConfig)
				.setUserAgent(properties.getAgent())
				.setMaxConnPerRoute(properties.getMaxConnPerRoute())
				.addInterceptorFirst(logbookHttpRequestInterceptor)
				.addInterceptorFirst(logbookHttpResponseInterceptor)
				.setConnectionReuseStrategy(new NoConnectionReuseStrategy()).build();
		return client;
	}
	
	private static Registry<ConnectionSocketFactory> getRegistry()
			throws KeyManagementException, NoSuchAlgorithmException {
		SSLContext sslContext = SSLContexts.custom().build();
		SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext,
				new String[] { "TLSv1.2" }, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
		return RegistryBuilder.<ConnectionSocketFactory> create()
				.register("http", PlainConnectionSocketFactory.getSocketFactory())
				.register("https", sslConnectionSocketFactory).build();
	}
	public HttpClient getHttpClient() {
		CloseableHttpClient httpClient = null;
		try {
			PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(getRegistry());
			connMgr.setMaxTotal(properties.getMaxConnTotaol());
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(properties.getSocketTimeOut()).setConnectTimeout(10 * 1000).build();
			httpClient = HttpClients.custom()
					.setDefaultRequestConfig(requestConfig)
					.setConnectionManager(connMgr)
					.addInterceptorFirst(logbookHttpRequestInterceptor)
					.addInterceptorFirst(logbookHttpResponseInterceptor)
					.build();
		} catch  (Exception e) {
			e.printStackTrace();
			return null;
		}
		return httpClient;
	}
}
