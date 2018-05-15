package com.eko.upload;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.StringBody;

import com.eko.util.HttpUtil;

public class ApacheHCUploader implements Uploader {

	private static HttpClient client = createClient();
	private static final Log log = LogFactory.getLog(ApacheHCUploader.class);

	public void upload(Part part) {

		String partName = part.getName();
		Map<String, ContentBody> params = new HashMap<String, ContentBody>();
		params.put(Config.keyFile, new ByteArrayBody(part.getContent(), partName));
		post(params);
		log.debug(partName + " uploaded.");
	}

	public void done(String fileName, long partCount) {

		Map<String, ContentBody> params = new HashMap<String, ContentBody>();
			params.put(Config.keyFileName, new StringBody(fileName,ContentType.TEXT_PLAIN));
			params.put(Config.keyPartCount, new StringBody(String.valueOf(partCount),ContentType.TEXT_PLAIN));
		post(params);
		log.debug(fileName + " notification is done.");
	}

	private void post(Map<String, ContentBody> params) {

		HttpPost post = new HttpPost(Config.url);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE); 
		for (Entry<String, ContentBody> e : params.entrySet()) {
			builder.addPart(e.getKey(), e.getValue());
		}
		post.setEntity(builder.build());

		try {
			HttpResponse response = client.execute(post);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				throw new RuntimeException("Upload failed.");
			}
		} catch (Exception e) {
			post.abort();
			throw new RuntimeException(e);
		} finally {
			post.releaseConnection();
		}
	}

	private static HttpClient createClient() {
		 return HttpUtil.getHttpClient();
	}
}
