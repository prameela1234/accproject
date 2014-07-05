package acc.capstone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class BlogManager {

	private DataSource ds;

	public BlogManager(DataSource ds) {
		this.ds = ds;

	}

	public List<Blog> findallPosts() {
		List<Blog> allposts = new ArrayList<Blog>();
		try {
			Connection connection = ds.getConnection();
			Statement statement = connection.createStatement();
			ResultSet results = statement
					.executeQuery("select * from blog order by dates desc");

			while (results.next()) {
				allposts.add(new Blog(
						Integer.parseInt(results.getString("id")), results
								.getString("title"), results
								.getString("content"), results
								.getString("dates"), results.getString("link"),
						results.getString("image_url")));

			}

			results.close();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allposts;
	}

	public Blog findPostById(int postID) {

		Blog post = null;
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select id, title,content,dates,link, image_url from blog where id=?");
			statement.setInt(1, postID);

			ResultSet results = statement.executeQuery();

			if (results.next()) {
				post = new Blog(results.getInt("id"),
						results.getString("title"),
						results.getString("content"),
						results.getString("dates"), results.getString("link"),
						results.getString("image_url"));

			}

			results.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return post;
	}

	public boolean newPost(Blog post) {
		boolean ok = false;

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("insert into blog(title,content,dates,link, image_url) values(?,?,sysdate(),?,?)");

			statement.setString(1, post.getTitle());
			statement.setString(2, post.getText());
			// statement.setString(3, new java.util.Date().toString());
			// statement.setString(3, post.getDate());
			statement.setString(3, post.getLink());
			statement.setString(4, post.getImg());

			System.out.print(statement.toString());

			statement.execute();
			ok = true;

			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ok;
	}

	public boolean updateBlog(Blog post) {
		boolean success = false;

		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("update blog set title=?,content=?,link=?, image_url=? where id=?");

			statement.setString(1, post.getTitle());
			statement.setString(2, post.getText());
			// statement.setString(3, post.getDate());
			statement.setString(3, post.getLink());
			statement.setString(4, post.getImg());
			statement.setInt(5, post.getId());
			statement.execute();
			success = true;

			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return success;
	}
}
