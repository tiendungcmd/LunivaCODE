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
import Manageruser.entities.UserInfor;
import Manageruser.logics.MstGroupLogics;
import Manageruser.logics.MstJapanLogics;
import Manageruser.logics.impl.MstGroupLogicsImpl;
import Manageruser.logics.impl.MstJapanLogicsImpl;
import Manageruser.properties.MessageErrorProperties;
import utils.Common;
import utils.Constant;

/**
 * @author Bui Tien Dung
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		UserInfor usInfor = new UserInfor();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if (Common.checkLogin(request.getSession())) {
			// set gia tri cho select box
			setDataLogic(request);
			// lay gia tri cho
			usInfor = getDefaultValue(request);
			request.setAttribute("usInfor", usInfor);
			RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.LINK_ADM003_JSP);
			dispatcher.forward(request, response);
		} else {
			// neu chua dang nhap quay ve man hinh ADM001
			response.sendRedirect(Constant.URL_LOGIN);
		}
	}

	/**
	 * set cas gia tri cho cac hang muc o select box
	 * 
	 * @param request
	 */
	private void setDataLogic(HttpServletRequest request) {
		// khoi tai mang chua thon tin
		List<MstGroupEntities> lstGroup = new ArrayList<>();
		List<MstJapanEntities> lstJapan = new ArrayList<>();
		List<Integer> lstYear = new ArrayList<>();
		List<Integer> lstMonth = new ArrayList<>();
		List<Integer> lstDay = new ArrayList<>();
		MstGroupLogics mstGroup = new MstGroupLogicsImpl();
		MstJapanLogics mstJapan = new MstJapanLogicsImpl();
		// lay thong tin Group
		lstGroup.addAll(mstGroup.getAllMstGroup());
		// lay thong tin Japan
		lstJapan.addAll(mstJapan.getAllMstJapan());
		// khai bao
		int yearFrom = Constant.YEAR_BEGIN;
		int yearTo = Common.getYearNow();
		lstYear.addAll(Common.getListYear(yearFrom, yearTo));
		lstMonth.addAll(Common.getListMonth());
		lstDay.addAll(Common.getListDay());
		// gan thong tin len request
		request.setAttribute("lstGroup", lstGroup);
		request.setAttribute("lstJapan", lstJapan);
		request.setAttribute("lstYear", lstYear);
		request.setAttribute("lstMonth", lstMonth);
		request.setAttribute("lstDay", lstDay);
	}

	/**
	 * get gia tri default cho man hinh ADM003
	 * 
	 * @param request
	 */
	private UserInfor getDefaultValue(HttpServletRequest request) {
		// khoi tao doi tuong userinfor
		UserInfor usInfor = new UserInfor();
		MessageErrorProperties mes = new MessageErrorProperties();
		// khai bao
		String loginName = "";
		// int yearNow = Common.getYearNow();
		// int monthNow = Common.getMonthNow();
		// int dayNow = Common.getDayNow();
		// lay gia tri default
		usInfor.setLogin_name(loginName);
		usInfor.setGroup_name(mes.getValueByKey("GROUP_NAME"));
		usInfor.setFull_name(Constant.FULL_NAME);
		usInfor.setFull_name_kana(Constant.FULL_NAME_KANA);
		usInfor.setEmail(Constant.EMAIL);
		usInfor.setTel(Constant.TEL);
		usInfor.setPass(Constant.PASS);
		usInfor.setName_level(mes.getValueByKey("NAME_LEVEL"));
		usInfor.setTotal(Constant.TOLTAL);
		usInfor.setListDMY(Common.getListDMY());
		// Date birthday = new Date( yearNow ,monthNow,dayNow);
		// usInfor.setBirthday(birthday);
		// lay gia tri id
		// usInfor.setUser_id(Integer.parseInt(request.getParameter("id")));
		// //lay gia tri group_name
		// usInfor.setGroup_name(request.getParameter("group_name"));
		// usInfor.setLogin_name(request.getParameter("login_name"));
		// usInfor.setFull_name(request.getParameter("full_name"));
		// usInfor.setFull_name_kana(request.getParameter("full_name_kana"));
		// SimpleDateFormat.parse(request.getParameter("birthday"));
		// usInfor.setBirthday( );

		// request.getParameter("id");

		// gan len request
		// request.setAttribute("yearNow", yearNow);
		// request.setAttribute("monthNow", monthNow);
		// request.setAttribute("dayNow", dayNow);
		return usInfor;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
