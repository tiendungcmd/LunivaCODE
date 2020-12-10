/**
 * Coppyright (C)  2020 Luvina
 * Constant.java, Nov 17, 2020, BuiTienDung
 */
package Manageruser.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Manageruser.entities.MstGroupEntities;
import Manageruser.entities.MstJapanEntities;
import Manageruser.entities.UserInforEntities;
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

	@WebServlet(urlPatterns = {"/AddUserInput.do", "/AdduserValidate.do"})
public class AddUserInputController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 *  hiển thị giá trị sang ADM004 sau khi submit
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			// kiểm tra login
			if (Common.checkLogin(request.getSession())) {
				// khởi tạo đối tượng userinfor
				UserInforEntities usInfor = new UserInforEntities();
				// lấy giá trị từ MH ADM003 gán thông tin cho đối User
				usInfor = getDefaultValue(request);
				HttpSession session = request.getSession();
				session.setAttribute(Constant.USER_INFOR_KEY, usInfor);
				
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.sendRedirect(Constant.URL_ADDUSERCONFIRM);
			} else {
				// neu chua dang nhap quay ve man hinh ADM001
				response.sendRedirect(Constant.URL_LOGIN);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Hiển thị thông tin màn hình ADM003
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// TODO Auto-generated method stub
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			UserInforEntities usInfor = new UserInforEntities();
			
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

		} catch (Exception e) {

		}
	}

	/**
	 * set các gia tri cho cac hang muc o select box
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
	 * lấy gia tri  cho man hinh ADM003
	 * 
	 * @param request  
	 * @return Thông tin đối tượng userInfor
	 */
	private UserInforEntities getDefaultValue(HttpServletRequest request) {
		// khoi tao doi tuong userinfor
		UserInforEntities usInfor = new UserInforEntities();
		MessageErrorProperties mes = new MessageErrorProperties();
		String action = request.getParameter("action");
		if (action == null) {
			action = "default";
		}
		switch (action) {
		case "default":
			// khai bao
			String loginName = Constant.LOGIN_NAME;

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
			System.out.println("vao ca default");
			break;
		case "submit":
			System.out.println("vao submit roif");
			List<Integer> lstBirth = new ArrayList<>();
			List<Integer> lstStartDate = new ArrayList<>();
			List<Integer> lstEndDate = new ArrayList<>();
			// lay giá trị của màn hình ADM003 gán vào đối tượng UserInfor
			usInfor.setLogin_name(request.getParameter("login_name"));
			usInfor.setGroup_name(request.getParameter("group_id"));
			usInfor.setFull_name(request.getParameter("name"));
			usInfor.setFull_name_kana(request.getParameter("name_kana"));
			// lay gias tri ngay thang nam birth day
			int year1 = Integer.parseInt(request.getParameter("yearBirth"));
			int month1 = Integer.parseInt(request.getParameter("monthBirth"));
			int day1 = Integer.parseInt(request.getParameter("dayBirth"));
			lstBirth.add(year1);
			lstBirth.add(month1);
			lstBirth.add(day1);
			// gán giá trị listBirth 
			usInfor.setListBirth(lstBirth);
			
			usInfor.setEmail(request.getParameter("email"));
			usInfor.setTel(request.getParameter("tel"));
			usInfor.setPass(request.getParameter("pass"));
			usInfor.setName_level(request.getParameter("kyu_id"));

			// lay gia tri ngay thang nam ngay bat dau
			int yearStart = Integer.parseInt(request.getParameter("yearStart"));
			int monthStart = Integer.parseInt(request.getParameter("monthStart"));
			int dayStart = Integer.parseInt(request.getParameter("dayStart"));
			lstStartDate.add(yearStart);
			lstStartDate.add(monthStart);
			lstStartDate.add(dayStart);
			// gán giá trị listStartdate
			usInfor.setListStartdate(lstStartDate);
			// lay gia tri ngay thang nam cua ngay ket thuc
			int yearEnd = Integer.parseInt(request.getParameter("yearEnd"));
			int monthEnd = Integer.parseInt(request.getParameter("monthEnd"));
			int dayEnd = Integer.parseInt(request.getParameter("dayEnd"));
			lstEndDate.add(yearEnd);
			lstEndDate.add(monthEnd);
			lstEndDate.add(dayEnd);
			usInfor.setListEndDate(lstEndDate);
			usInfor.setTotal(Integer.parseInt(request.getParameter("total")));
			break;
		case "back":
			break;
		}
		return usInfor;
	}

	
	
}
