package com.eko.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;

import com.box.sdk.BoxDeveloperEditionAPIConnection;
import com.box.sdk.EncryptionAlgorithm;
import com.box.sdk.IAccessTokenCache;
import com.box.sdk.InMemoryLRUAccessTokenCache;
import com.box.sdk.JWTEncryptionPreferences;

public class OurAppBoxAPIConnection {
	static ResourceBundle bundle = ResourceBundle.getBundle("common",
			Locale.ENGLISH);
	private static final int MAX_CACHE_ENTRIES = 100;
	private static OurAppBoxAPIConnection OurAppBoxAPIConnection = null;
	private static String privateKey = null;
	private static JWTEncryptionPreferences encryptionPref = null;
	private static IAccessTokenCache accessTokenCache = null;
	private static BoxDeveloperEditionAPIConnection api = null;

	private OurAppBoxAPIConnection() {
	}

	static {
		try {

			OurAppBoxAPIConnection = new OurAppBoxAPIConnection();
			privateKey = new String(Files.readAllBytes(Paths.get(bundle.getString("privatekey.file.path"))));
			encryptionPref = new JWTEncryptionPreferences();
			encryptionPref.setPublicKeyID(bundle.getString("publickey.id"));
			encryptionPref.setPrivateKey(privateKey);
			encryptionPref.setPrivateKeyPassword(bundle.getString("privatekey.password"));
			encryptionPref.setEncryptionAlgorithm(EncryptionAlgorithm.RSA_SHA_256);
		
			accessTokenCache = new InMemoryLRUAccessTokenCache(MAX_CACHE_ENTRIES);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static synchronized BoxDeveloperEditionAPIConnection getAppUserConnection(
			String appUserId) {
		
		if (api == null) {
			api = BoxDeveloperEditionAPIConnection.getAppUserConnection(
					appUserId, bundle.getString("box.client.id"),
					bundle.getString("box.client.secret"), encryptionPref,
					accessTokenCache);
		}
		if (api.needsRefresh()) {
		      api.refresh();
		}
		return api;
	}
  
 

}
