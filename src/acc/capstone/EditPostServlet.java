package acc.capstone;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/edit")
public class EditPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/MyBlog")
	private DataSource ds;
   
    public EditPostServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	       ServletException, IOException {
		BlogManager blog = new BlogManager(ds);
		System.out.println("Rowid=" + request.getParameter("rowid"));
		int postID = Integer.parseInt(request.getParameter("rowid"));

		Blog post = blog.findPostById(postID);
		if (post != null) {
		request.setAttribute("blogpost", post);
		
		request.getRequestDispatcher("/WEB-INF/edit.jsp").forward(request, response);
		} else {
		response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}

	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
    int id = Integer.parseInt(request.getParameter("id"));
	String title = request.getParameter("title");
	String content = request.getParameter("text");
	String dates = request.getParameter("dates");
	String link = request.getParameter("link");
	String img = request.getParameter("img");
	System.out.print("Edit Servlet output" + id + title + content + dates + link + img);
	
	Blog post = new Blog(id,title,content,dates,link, img);
	BlogManager manager = new BlogManager(ds);
	
	System.out.print("Edit Servlet output2: " + post.getId() + post.getTitle() + 
			          post.getText() + post.getLink() + post.getImg());
		if (manager.updateBlog(post)) {

			response.sendRedirect("/");
		} else {
			request.getRequestDispatcher("/WEB-INF/edit.jsp").forward(request, response);
			
		}

	}	

}
