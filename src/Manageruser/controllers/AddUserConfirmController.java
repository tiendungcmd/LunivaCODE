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
import Manageruser.entities.UserInforEntities;
import utils.Constant;

/**
 * Servlet implementation class AddUserConfirmController
 */
@WebServlet("/AddUserConfirmController.do")
public class AddUserConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		UserInforEntities usInfor = new UserInforEntities();
		//tao session
		HttpSession session =request.getSession();
		//gán thông tin từ session về 
		usInfor = (UserInforEntities) session.getAttribute(Constant.USER_INFOR_KEY);
		
		//gán userinfor lên request
		request.setAttribute("usInfor", usInfor);
		System.out.println("test2");
		System.out.println(usInfor);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(Constant.LINK_ADM004_JSP);
		requestDispatcher.forward(request, response);
	}
}
