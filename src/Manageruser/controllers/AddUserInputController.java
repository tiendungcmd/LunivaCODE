package Manageruser.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manageruser.logics.MstGroupLogics;
import Manageruser.logics.MstJapanLogics;
import Manageruser.logics.impl.MstGroupLogicsImpl;
import Manageruser.logics.impl.MstJapanLogicsImpl;
import utils.Common;
import utils.Constant;

/**
 * Servlet implementation class AddUserInpuController
 */
@WebServlet("/AddUserInputController")
public class AddUserInputController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserInputController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if (Common.checkLogin(request.getSession())){
			setDataLogic(request);
			
		}else {
			//neu chua dang nhap quay ve man hinh ADM001
			response.sendRedirect(Constant.URL_LOGIN);
		}
	}
	
	private void  setDataLogic(HttpServletRequest request){
		MstGroupLogics mstGroup = new MstGroupLogicsImpl();
		MstJapanLogics mstJapan = new MstJapanLogicsImpl();
		mstGroup.getAllMstGroup();
		mstJapan.getAllMstJapan();
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
