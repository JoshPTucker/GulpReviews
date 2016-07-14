package gulpServlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.ReviewUtil;
import model.Gulprestaurant;
import model.Gulpreview;
import model.Gulpuser;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
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
		HttpSession session = request.getSession();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		//get current date time with Date()
		Date date = new Date();
		String reviewtext = request.getParameter("userreview");
		Number rating;
		rating= Integer.parseInt(request.getParameter("rating"));
		BigDecimal r=new BigDecimal( rating.toString());
		Gulpuser user = (Gulpuser) session.getAttribute("user");
		Gulprestaurant restaurant= (Gulprestaurant) session.getAttribute("currrestaurant");
		Gulpreview rev=new Gulpreview();
		rev.setGulprestaurant(restaurant);
		rev.setGulpuser(user);
		rev.setReviewdate(date);
		rev.setReviewtext(reviewtext);
		rev.setReviewrating(r);
		ReviewUtil.insert(rev);
		String nextURL="/restaurantprofile.jsp";
		response.sendRedirect(request.getContextPath() + nextURL);
		
		
	}

}
