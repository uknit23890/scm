package com.scm.socialutility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;




public class connectionUtility {

	public static final String APP_ID = "108262403174039";
	public static final String APP_SECRET = "7afb8c2f6c0a72bea268fab1f6b7f08e";
	public static final String REDIRECT_URI = "http://localhost:4040/fb/FBServlet";
	public static final String USER_PERMISIONS="publish_stream,share_item,offline_access,manage_pages,user_friends";

	
	// this use to login the user
		public static String getFBAuthUrl() {
			String fbLoginUrl = "";
			try {
				fbLoginUrl = "http://www.facebook.com/dialog/oauth?" + "client_id=" + connectionUtility.APP_ID
						+ "&redirect_uri=" + URLEncoder.encode(connectionUtility.REDIRECT_URI, "UTF-8")
						+ "&scope="+USER_PERMISIONS;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return fbLoginUrl;
		}
		
		
	public static String getAccessToken(String code) throws JSONException   {
		String accessToken = "";
		URL fbGraphURL;
		try {
			fbGraphURL = new URL(getFBGraphUrl(code));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException("Invalid code received " + e);
		}
		URLConnection fbConnection;
		StringBuffer b = null;
		try {
			fbConnection = fbGraphURL.openConnection();
			BufferedReader in;
			in = new BufferedReader(new InputStreamReader(fbConnection.getInputStream()));
			String inputLine;
			b = new StringBuffer();
			while ((inputLine = in.readLine()) != null)
				b.append(inputLine + "\n");
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect with Facebook " + e);
		}
		
		JSONObject json = new JSONObject(b.toString());
		accessToken = json.getString("access_token");
		if (accessToken.startsWith("{")) {
			throw new RuntimeException("ERROR: Access Token Invalid: " + accessToken);
		}

		return accessToken;
	}

	public static String getFBGraphUrl(String code) {
		String fbGraphUrl = "";
		try {
			fbGraphUrl = "https://graph.facebook.com/oauth/access_token?" + "client_id=" + connectionUtility.APP_ID
					+ "&redirect_uri=" + URLEncoder.encode(connectionUtility.REDIRECT_URI, "UTF-8")
					+ "&client_secret=" + APP_SECRET + "&code=" + code;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return fbGraphUrl;
	}

}
