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
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/newpost.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String text = request.getParameter("text");
		String link = request.getParameter("link");
		String img = request.getParameter("img");
		String date = request.getParameter("dates");
		//BlogManager manager = new BlogManager(ds);
		Blog post = new Blog(title, text, date, link, img);

		System.out.print("doPost!!!  " + post.getTitle() + " " + post.getText()
				+ " " + post.getDate() + " " + post.getLink() + " "
				+ post.getImg());

		String dates = null;
		if (!validText(title)) {
			request.setAttribute("error", "You must enter a title");
			handleError(request, response);

		} else if (!validText(text)) {
			request.setAttribute("error", "You must enter a text");
			handleError(request, response);

		} else if (!validText(link)) {
			request.setAttribute("error", "You must enter a link");
			handleError(request, response);

		} else if (!validText(dates)) {
			request.setAttribute("error", "You must enter a date");
			handleError(request, response);

		} else {
			Blog post1 = new Blog(title, text, link, img, dates);
			BlogManager manager1 = new BlogManager(ds);

			if (manager1.newPost(post1)) {
				response.sendRedirect("/");

			} else {
				request.getRequestDispatcher("/WEB-INF/newpost.jsp").forward(
						request, response);
			}
		}
	}

	void handleError(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/newpost.jsp").forward(request,
				response);
	}

	boolean validText(String text) {
		return text != null && text.length() > 0;
	}
}
