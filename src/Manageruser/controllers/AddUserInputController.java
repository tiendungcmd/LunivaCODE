package Manageruser.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manageruser.entities.MstGroupEntities;
import Manageruser.entities.MstJapanEntities;
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
			getDefaultValue(request);
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.LINK_ADM003_JSP);
			dispatcher.forward(request, response);	
		}else {
			//neu chua dang nhap quay ve man hinh ADM001
			response.sendRedirect(Constant.URL_LOGIN);
		}
	}
	/**
	 * set cas gia tri cho cac hang muc o select box
	 * @param request
	 */
	private void  setDataLogic(HttpServletRequest request){
		//khoi tai mang chua thon tin
		List<MstGroupEntities> lstGroup =new ArrayList();
		List<MstJapanEntities> lstJapan = new ArrayList();
		List<Integer> lstYear = new ArrayList();
		List<Integer> lstMonth = new ArrayList();
		List<Integer> lstDay = new ArrayList();
		MstGroupLogics mstGroup = new MstGroupLogicsImpl();
		MstJapanLogics mstJapan = new MstJapanLogicsImpl();
		//lay thong tin Group
		lstGroup.addAll(mstGroup.getAllMstGroup());
		//lay thong tin Japan
		lstJapan.addAll(mstJapan.getAllMstJapan());
		//khai bao
		int yearFrom=Constant.YEAR_BEGIN;
		int yearTo=Common.getYearNow();
		lstYear.addAll(Common.getListYear(yearFrom,yearTo));
		System.out.println(lstYear);
		lstMonth.addAll(Common.getListMonth());
		lstDay.addAll(Common.getListDay());		
		//gan thong tin len request
		request.setAttribute("lstGroup", lstGroup);
		request.setAttribute("lstJapan", lstJapan);
		request.setAttribute("lstYear", lstYear);
		request.setAttribute("lstMonth", lstMonth);
		request.setAttribute("lstDay", lstDay);
	}
	/**
	 * get gia tri default cho man hinh ADM003
	 * @param request
	 */
	private void getDefaultValue(HttpServletRequest request) {
		
		//khai bao
		int yearNow = Common.getYearNow();
		int monthNow = Common.getMonthNow();
		int dayNow = Common.getDayNow();
		//gan len request
		request.setAttribute("yearNow", yearNow);
		request.setAttribute("monthNow", monthNow);
		request.setAttribute("dayNow", dayNow);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
