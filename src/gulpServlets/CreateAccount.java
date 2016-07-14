package gulpServlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.UserUtil;
import model.Gulpuser;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String zipcde=request.getParameter("zipcode");
		Number zip = Integer.parseInt(zipcde);
		BigDecimal zipcode= new BigDecimal(zip.toString());
		Gulpuser newuser= new Gulpuser();
		newuser.setFirstname(firstname);
		newuser.setUseremail(email);
		newuser.setLastname(lastname);
		newuser.setZipcode(zipcode);
		newuser.setUserpassword(password);
		UserUtil.insert(newuser);
		
	    String nextURL="/login.jsp"; 
		response.sendRedirect(request.getContextPath() + nextURL);
	}

}
