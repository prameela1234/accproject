package acc.capstone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class UserManager {
private DataSource ds;

public UserManager(DataSource ds) {
this.ds = ds;
}


public Bloguser userByNameAndPassword(String username, String password) {
Bloguser user = null;

try {
Connection connection = ds.getConnection();
PreparedStatement statement = connection.prepareStatement(
"select * from bloguser where username=? and password=?");
statement.setString(1, username);
statement.setString(2, password);

ResultSet results = statement.executeQuery();

if (results.next()) {
user = new Bloguser(results.getString("username"), results.getString("password"));
}

results.close();
statement.close();
connection.close();
} catch (SQLException e) {
e.printStackTrace();
}

return user;
}


}
