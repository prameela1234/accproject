package acc.capstone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("")

public class BlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
@Resource(name="jdbc/MyBlog")
	DataSource ds;
    
    public BlogServlet() {
        super();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	BlogManager manager = new BlogManager(ds);
	List<Blog> posts = manager.findallPosts();
	
	List<Blog> randomPost = new ArrayList<Blog>();

	Random random = new Random();
	
	randomPost.add(posts.get(random.nextInt(posts.size())));
	
    request.setAttribute("posts", randomPost);
	
	request.setAttribute("now", new Date());
	
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/random.jsp");
	dispatcher.forward(request, response);
		
	}

	
}
