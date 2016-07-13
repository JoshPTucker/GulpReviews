package gulpServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.RestaurantUtil;
import customTools.ReviewUtil;
import model.Gulprestaurant;
import model.Gulpreview;


/**
 * Servlet implementation class RestaurantProfile
 */
@WebServlet("/RestaurantProfile")
public class RestaurantProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();

        Gulprestaurant currrestaurant = null;
        String rid=request.getParameter("restaurantview");
        System.out.println(rid);
		int restaurantid=Integer.parseInt(rid);
		currrestaurant = RestaurantUtil.getRestaurant(restaurantid);
		ArrayList<Gulpreview> reviews= new ArrayList<Gulpreview>();
		List<Gulpreview> rs =ReviewUtil.restaurantReviews(restaurantid);
		reviews.addAll(rs);
		session.setAttribute("currrestaurant",currrestaurant);
		session.setAttribute("reviews", reviews);
		String nextURL="/restaurantprofile.jsp";
		response.sendRedirect(request.getContextPath() + nextURL);
	}

}
