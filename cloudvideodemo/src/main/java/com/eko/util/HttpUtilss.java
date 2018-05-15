package com.eko.util;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLException;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;

public class HttpUtilss {
 
	private static RequestConfig config() {
		return RequestConfig.custom()
				.setConnectionRequestTimeout(2000)
				.setConnectTimeout(2000)
				.setSocketTimeout(2000).build();
	}

	private static PoolingHttpClientConnectionManager poolingClientConnectionManager() {
		PoolingHttpClientConnectionManager poolHttpcConnManager = new PoolingHttpClientConnectionManager(
				60, TimeUnit.SECONDS);
		poolHttpcConnManager.setMaxTotal(20);
		poolHttpcConnManager.setDefaultMaxPerRoute(20);
		return poolHttpcConnManager;
	}

	public static HttpRequestRetryHandler httpRequestRetryHandler() {  
    
        final int retryTime =  5;  
        return new HttpRequestRetryHandler() {  
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {  
                // Do not retry if over max retry count
                if (executionCount >= retryTime) {  
                    return false;  
                }  
                // server abort 
                if (exception instanceof NoHttpResponseException) {  
                    return true;  
                }  
                // time out 
                if (exception instanceof InterruptedIOException) {  
                    return true;  
                }  
                // Unknown host  
                if (exception instanceof UnknownHostException) {  
                    return false;  
                }  
                // Connection refused  
                if (exception instanceof ConnectTimeoutException) {  
                    return false;  
                }  
                // SSL handshake exception  
                if (exception instanceof SSLException) {  
                    return false;  
                }  
                HttpClientContext clientContext = HttpClientContext.adapt(context);  
                HttpRequest request = clientContext.getRequest();  
                if (!(request instanceof HttpEntityEnclosingRequest)) {  
                    return true;  
                }  
                return false;  
            }  
        };  
    }  
	public static CloseableHttpClient initHttpClient() {
		CloseableHttpClient client = HttpClients.custom().setConnectionManager(poolingClientConnectionManager())  
	                .setRetryHandler(httpRequestRetryHandler())  
	                .setDefaultRequestConfig(config())  
	                .build();  
		return client;
	}
}
