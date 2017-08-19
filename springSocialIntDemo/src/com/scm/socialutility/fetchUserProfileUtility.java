package com.scm.socialutility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.json.JSONObject;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;

public class fetchUserProfileUtility {
	private String accessToken;
	private String graph;

	public fetchUserProfileUtility(String accessToken) {
		this.accessToken = accessToken;
		getGraphData();
	}

	public JSONObject getLogedInUserProfileData() throws Exception {
		JSONObject json = new JSONObject(graph);
		return json;
	}

	public List<com.restfb.types.User> getLogedInUserFriendList() {
		FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
		Connection<com.restfb.types.User> friends = null;
		try {
			friends = facebookClient.fetchConnection("me/friends", User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<com.restfb.types.User> friendsList = friends.getData();
		return friendsList;
	}

	private void getGraphData() {
		try {
			String g = "https://graph.facebook.com/me?fields=name,email,gender&access_token="
					+ accessToken;
			System.out.println("Graph url:" + g);
			URL u = new URL(g);
			URLConnection c = u.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					c.getInputStream()));
			String inputLine;
			StringBuffer b = new StringBuffer();
			while ((inputLine = in.readLine()) != null)
				b.append(inputLine + "\n");
			in.close();
			graph = b.toString();
			System.out.println(graph);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR in getting FB graph data. " + e);
		}
	}

}
