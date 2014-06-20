package acc.capstone;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/new")
public class NewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/MyBlog")
	private DataSource ds;

	public NewPostServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/newpost.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String  text= request.getParameter("text");
		//String  date= new java.util.Date();
		
		String  link= request.getParameter("link");
		String  img= request.getParameter("img");
		String  date = request.getParameter("dates");
		BlogManager manager = new BlogManager(ds);
		Blog post = new Blog(title,text,date,link, img);
		
		System.out.print("doPost!!!  " + post.getTitle() + " " + post.getText() + " " + post.getDate()
				+ " " + post.getLink() + " " + post.getImg());
		
		if (manager.newPost(post)) {
			response.sendRedirect("/");
			
		} else {
			request.getRequestDispatcher("/WEB-INF/newpost.jsp").forward(request, response);
		}
	}
}
