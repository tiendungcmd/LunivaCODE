package Manageruser.controllers;
/**
 * @author Bùi Tiến Dũng
 */
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Manageruser.entities.UserInfor;
import utils.Constant;

/**
 * Servlet implementation class AddUserConfirmController
 */
@WebServlet("/AddUserConfirmController")
public class AddUserConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		UserInfor usInfor = new UserInfor();
		
		HttpSession session =request.getSession();
		usInfor = (UserInfor) session.getAttribute(Constant.USER_INFOR_KEY);
		//session.setAttribute(arg0, arg1);
		//gán userinfor lên request
		request.setAttribute("usInfor", usInfor);
		System.out.println("test2");
		System.out.println(usInfor);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(Constant.LINK_ADM004_JSP);
		requestDispatcher.forward(request, response);
	}

}
