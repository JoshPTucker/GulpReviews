package gulpServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.RestaurantUtil;
import model.Gulprestaurant;

/**
 * Servlet implementation class ReviewFeed
 */
@WebServlet("/ReviewFeed")
public class ReviewFeed extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewFeed() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		ArrayList<Gulprestaurant> restaurants = new ArrayList<Gulprestaurant>();
		restaurants.addAll(RestaurantUtil.gulprestaurants());
		session.setAttribute("restaurants", restaurants);
		//String nextURL = "/reviewfeed.jsp";
		String nextURL = "/home.jsp";
		response.sendRedirect(request.getContextPath() + nextURL);
	}

}
