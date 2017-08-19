package com.scm.socialutility;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import com.restfb.types.User;

public class socialAuthServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		String code = req.getParameter("code");
		String accessToken = "";
		if (code == null || code.equals("")) {
			throw new RuntimeException(
					"ERROR: Didn't get code parameter in callback.");
		}

		try {
			accessToken = connectionUtility.getAccessToken(code);
			fetchUserProfileUtility fup = new fetchUserProfileUtility(
					accessToken);
			JSONObject fbProfileDataJSon = fup.getLogedInUserProfileData();
			out.println("<h1>Facebook loged in with user:->"
					+ fbProfileDataJSon.getString("name") + "</h1>");
			out.println("<div>All details:" + fbProfileDataJSon);
			out.print("</br>");
			out.print(fbProfileDataJSon.getString("name")
					+ " below are your friends using this App ID");
			out.print("</br>");
			List<com.restfb.types.User> friendsList = fup
					.getLogedInUserFriendList();
			int i = 1;
			for (User user : friendsList) {
				out.println(i++ + ". Name:" + user.getName() + " FB_ID:"
						+ user.getId());
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
