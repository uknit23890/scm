package com.oauth.service;

import java.util.Base64;
import java.util.StringTokenizer;

/**
 * @author www.sourcecodematrix.com
 * @Description This class has logic to decode the encrypted header value which
 *              contain the user credentials.
 */
public class AuthenticationService {
	private static final String CHAR_ENCODING = "UTF-8";

	public boolean authenticateUser(String authCredentials) throws Exception {
		authCredentials = authCredentials.replaceFirst("Basic ", "");
		if (null == authCredentials)
			return false;
		String userCredentials = null;

		byte[] decodedBytes = null;
		decodedBytes = Base64.getDecoder().decode(authCredentials);

		userCredentials = new String(decodedBytes, CHAR_ENCODING);
		final StringTokenizer tokenizer = new StringTokenizer(userCredentials, ":");
		final String email = tokenizer.nextToken();
		final String password = tokenizer.nextToken();
		if ("sourcecodematrix@gmail.com".equals(email) && password.equals("admin")) {
			return true;
		}
		return false;
	}

}
