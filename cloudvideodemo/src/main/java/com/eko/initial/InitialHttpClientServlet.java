package com.eko.initial;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.log4j.Logger;

public class InitialHttpClientServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3177922303823672830L;
	private static Logger logger = Logger.getLogger(InitialHttpClientServlet.class);
	private CloseableHttpClient client;  
	     
	private int connectTimeout = 2000;
	private int connectRequestTimeout = 2000;
	private int socketTimeout = 2000;
	private int connMaxTotal = 20;
	private int maxPerRoute = 20;
	private int timeToLive = 60;
	private int keepAliveTime = 30;
	private int retryTime=5;
	@Override
	public void init() throws ServletException {
		System.out.println("init http client start");
		initHttpClient();
		System.out.println("init http client end");
	}
	

	@Override
	public void destroy() {
	      if(null != this.client){  
	            try {
					this.client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	           }  
	}


	private RequestConfig config() {
		return RequestConfig.custom()
				.setConnectionRequestTimeout(this.connectRequestTimeout)
				.setConnectTimeout(this.connectTimeout)
				.setSocketTimeout(this.socketTimeout).build();
	}

	private PoolingHttpClientConnectionManager poolingClientConnectionManager() {
		PoolingHttpClientConnectionManager poolHttpcConnManager = new PoolingHttpClientConnectionManager(
				60, TimeUnit.SECONDS);
		poolHttpcConnManager.setMaxTotal(this.connMaxTotal);
		poolHttpcConnManager.setDefaultMaxPerRoute(this.maxPerRoute);
		return poolHttpcConnManager;
	}

	private ConnectionKeepAliveStrategy connectionKeepAliveStrategy() {
		return new ConnectionKeepAliveStrategy() {

			public long getKeepAliveDuration(HttpResponse response,
					HttpContext context) {
				// Honor 'keep-alive' header
				HeaderElementIterator it = new BasicHeaderElementIterator(
						response.headerIterator(HTTP.CONN_KEEP_ALIVE));
				while (it.hasNext()) {
					HeaderElement he = it.nextElement();
					String param = he.getName();
					String value = he.getValue();
					if (value != null && param.equalsIgnoreCase("timeout")) {
						try {
							return Long.parseLong(value) * 1000;
						} catch (NumberFormatException ignore) {
						}
					}
				}
				return 30 * 1000;
			}
		};
	}
	public HttpRequestRetryHandler httpRequestRetryHandler() {  
    
        final int retryTime = this.retryTime;  
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
	public void initHttpClient() {
		this.client = HttpClients.custom().setConnectionManager(poolingClientConnectionManager())  
	                .setRetryHandler(httpRequestRetryHandler())  
	                .setKeepAliveStrategy(connectionKeepAliveStrategy())  
	                .setDefaultRequestConfig(config())  
	                .build();  
	}
}
