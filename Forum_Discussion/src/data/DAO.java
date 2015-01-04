package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Comment;
import model.RegistrationBean;
import model.Topic;
import model.User;

public class DAO{

	public static void saveRegistration(RegistrationBean registration)
			throws DataException {

		Connection con = null;
		try {
			con = DBManager.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DataException();
		}

		try {
			String insStr = "insert into users values(?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(insStr);
			stmt.setString(1, registration.getUserid());
			stmt.setString(2, registration.getPassword());
			stmt.setString(3, registration.getName());
			stmt.setString(4, Character.toString(registration.getGender()));
			stmt.setInt(5, registration.getAge());
			stmt.setString(6, registration.getCity());

			int result = stmt.executeUpdate();
			if (result != 1) {
				throw new DataException("Failed to insert data");
			}

		} catch (SQLException se) {
			throw new DataException(se.getMessage());
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

	public static List<Topic> getTopics() throws DataException {
		Connection con = null;
		ArrayList<Topic> topics = new ArrayList<Topic>();
		try {
			con = DBManager.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DataException();
		}

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from topics order by time desc");
			while (rs.next()) {
				// Topic t = new
				// Topic(rs.getInt("id"),rs.getString("name"),rs.getString("comment"),rs.getString("userid"));
				Topic topic = new Topic();
				topic.setId(rs.getInt("id"));
				topic.setName(rs.getString("name"));
				topic.setComment(rs.getString("comment"));
				topic.setUserid(rs.getString("userid"));
				topic.setTime(rs.getTimestamp("time"));

				topics.add(topic);

			}

		} catch (SQLException se) {
			throw new DataException(se.getMessage());
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return topics;
	}

	public static Topic getTopic(int id) throws DataException {
		Connection con = null;
		Topic topic = null;
		try {
			con = DBManager.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DataException();
		}

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Topics where id="
					+ id);
			if (rs.next()) {
				topic = new Topic();
				topic.setId(rs.getInt("id"));
				topic.setName(rs.getString("name"));
				topic.setComment(rs.getString("comment"));
				topic.setUserid(rs.getString("userid"));
				topic.setTime(rs.getTimestamp("time"));

			} else
				throw new InvalidTopicIdException();

		} catch (SQLException se) {
			throw new DataException(se.getMessage());
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return topic;
	}

	public static List<Topic> getTopics(String userid) throws DataException {
		Connection con = null;
		ArrayList<Topic> topics = new ArrayList<Topic>();
		try {
			con = DBManager.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DataException();
		}

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from topics where userid = '"
							+ userid + "' order by time desc");
			while (rs.next()) {
				// Topic t = new
				// Topic(rs.getInt("id"),rs.getString("name"),rs.getString("comment"),rs.getString("userid"));
				Topic topic = new Topic();
				topic.setId(rs.getInt("id"));
				topic.setName(rs.getString("name"));
				topic.setComment(rs.getString("comment"));
				topic.setUserid(rs.getString("userid"));
				topic.setTime(rs.getTimestamp("time"));
				topics.add(topic);

			}

		} catch (SQLException se) {
			throw new DataException("hi");
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return topics;
	}

	public static List<Topic> searchTopics(String searchtext)
			throws DataException {
		Connection con = null;
		ArrayList<Topic> topics = new ArrayList<Topic>();
		try {
			con = DBManager.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DataException();
		}

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from topics where name like '%"
							+ searchtext + "%'");
			while (rs.next()) {
				// Topic t = new
				// Topic(rs.getInt("id"),rs.getString("name"),rs.getString("comment"),rs.getString("userid"));
				Topic topic = new Topic();
				topic.setId(rs.getInt("id"));
				topic.setName(rs.getString("name"));
				topic.setComment(rs.getString("comment"));
				topic.setUserid(rs.getString("userid"));
				topic.setTime(rs.getTimestamp("time"));
				topics.add(topic);

			}

		} catch (SQLException se) {
			throw new DataException(se.getMessage());
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return topics;
	}

	public static void updateTopic(Topic topic) throws DataException {
		Connection con = null;
		String str=null;
		try {
			con = DBManager.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DataException();
		}

		try {
			Statement stmt = con.createStatement();
			int result = stmt.executeUpdate("update Topics set comment = '"
					+ topic.getComment() + "' where id =" + topic.getId());
			
			if (result != 1)
				throw new DataException("Error occured while updating topic");

		} catch (SQLException se) {
			throw new DataException(se.getMessage());
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

	public static User getUser(String userid) throws DataException {
		Connection con = null;
		User user = null;
		try {
			
			con = DBManager.getConnection();
		} catch (Exception e) {
			throw new DataException();
		}

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from users where userid = '"
							+ userid + "'");
			if (rs.next()) {
				user = new User();
				user.setUserid(userid);
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setAge(rs.getInt("age"));
				user.setCity(rs.getString("city"));
				user.setGender(rs.getString("gender").charAt(0));

			} else
				throw new InvalidUserIdException();

		} catch (SQLException se) {
			throw new DataException(se.getMessage());
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return user;
	}

	public static void saveUser(User user) throws DataException {

		Connection con = null;
		try {
			con = DBManager.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DataException();
		}

		try {
			String insStr = "insert into users values(?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(insStr);
		
			stmt.setString(1, user.getUserid());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setString(4, Character.toString(user.getGender()));
			stmt.setInt(5, user.getAge());
			stmt.setString(6, user.getCity());
			
			int result = stmt.executeUpdate();
			if (result != 1) {
				//throw new DataException("Failed to insert data");
			}

		} catch (SQLException se) {
			System.out.println("hi");
			//throw new DataException(se.getMessage());
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

	public static void saveTopic(Topic topic) throws DataException {

		Connection con = null;
		try {
			con = DBManager.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DataException();
		}

		try {
			String insStr = "insert into topics(name,comment,userid, time) values(?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(insStr);
				
			stmt.setString(1, topic.getName());
			stmt.setString(2, topic.getComment());
			stmt.setString(3, topic.getUserid());
			stmt.setTimestamp(4, new java.sql.Timestamp(topic.getTime().getTime()));
				
			int result = stmt.executeUpdate();
			if (result != 1) {
				throw new DataException("Failed to insert data");
			}

		} catch (SQLException se) {
			throw new DataException(se.getMessage());
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

	public static List<Comment> getComments(int topicid) throws DataException {
		Connection con = null;
		ArrayList<Comment> comments = new ArrayList<Comment>();
		try {
			con = DBManager.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DataException();
		}

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from comment where topicid = "
							+ topicid + " order by time desc");
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setId(rs.getInt("id"));
				comment.setTopicid(topicid);
				comment.setComment(rs.getString("comment"));
				comment.setUserid(rs.getString("userid"));
				comment.setTime(rs.getTimestamp("time"));

				comments.add(comment);

			}

		} catch (SQLException se) {
			throw new DataException(se.getMessage());
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return comments;
	}

public static void saveComment(Comment comment) throws DataException{		
		Connection con = null;
		try {
			 con = DBManager.getConnection();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DataException();
		}		
		try
		{
		String insStr = "insert into comment(topicid,userid,comment,time) values(?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(insStr);	
		 stmt.setInt(1, comment.getTopicid());
		 stmt.setString(2, comment.getUserid());
		 stmt.setString(3, comment.getComment());
		 stmt.setTimestamp(4, new java.sql.Timestamp(comment.getTime().getTime()));
		int result = stmt.executeUpdate();
		 if(result != 1){
			 throw new DataException("Failed to insert data");
		 }		 
		}catch(SQLException se){
			throw new DataException(se.getMessage());
		}finally{
			if(con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	
	}
}
