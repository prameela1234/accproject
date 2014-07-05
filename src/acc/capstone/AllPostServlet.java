package acc.capstone;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/list")
public class AllPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/MyBlog")
	DataSource ds;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		BlogManager manager = new BlogManager(ds);

		List<Blog> posts = manager.findallPosts();

		request.setAttribute("posts", posts);
		request.setAttribute("now", new Date());
		
		for (Blog p : posts) {
			System.out.println("The date is: "+ p.getDate());
		}

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/blog.jsp");
		dispatcher.forward(request, response);

	}

}
