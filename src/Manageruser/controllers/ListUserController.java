/**
 /**
 * Copyright(C) 2020 Luvina
 *ListUserController.java 16/11/2020 BichPhuong
 */
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
import javax.servlet.http.HttpSession;

import Manageruser.entities.MstGroupEntities;
import Manageruser.entities.UserInfor;
import Manageruser.logics.MstGroupLogics;
import Manageruser.logics.TblUserLogics;
import Manageruser.logics.impl.MstGroupLogicsImpl;
import Manageruser.logics.impl.TblUserLogicsImpl;
import Manageruser.properties.MessageErrorProperties;
import utils.Common;
import utils.Constant;

/**
 * Xử lí thao tác để hiển thị ra list user
 * 
 * @author Bùi Tiến Dũng
 *
 */
@WebServlet("/ListUserController")
public class ListUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListUserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// kiem tra login
		if (Common.checkLogin(request.getSession())) {

			// khoi tao 1 list de them group vao list
			List<MstGroupEntities> lstGr = new ArrayList<>();
			MstGroupLogics mstGr = new MstGroupLogicsImpl();
			// khoi tao list User
			List<UserInfor> lstUser = new ArrayList<>();
			TblUserLogics tbUser = new TblUserLogicsImpl();

			List<Integer> lstPaging = new ArrayList<Integer>();
			
			HttpSession session = request.getSession();
			// gan gia tri
			int grId = Constant.GROUP_ID_DEFAULT;
			String fullName = Constant.FULL_NAME_DEFAULT;
			String sortByFullName = Constant.SORT_FULL_NAME_DEFAULT;
			String sortByCodeLevel = Constant.SORT_NAME_LEVEL_DEFAULT;
			String sortByEndDate = Constant.SORT_END_DATE_DEFAULT;
			int ofset = Constant.OFFSET_DEFAULT;
			String sortType = Constant.SORT_TYPE_DEFAULT;
			String sortValue = "";
			int currentPage = Constant.PAGE_DEFAULT;
			int limit = Common.getLimit();
			int limitPage = Constant.LIMIT_PAGE;

			// lấy hành động từ request
			String action = request.getParameter("action");
			// kiểm tra xem có rỗng không, nếu rỗng gán giá trị action = default
			if (action == null) {
				action = "default";
			}

			switch (action) {
			case "default":

				break;
			case "search":
				fullName = request.getParameter("name");
				// String fName = tbUser.replaceWildcard(fullName);
				grId = Integer.parseInt(request.getParameter("group_id"));
				break;
			case "sort":
				sortType = request.getParameter("sortType");
				fullName = request.getParameter("fullName");
				grId = Integer.parseInt(request.getParameter("group_id"));
				sortValue = String.valueOf(request.getParameter("sortValue"));
				if ("full_name".equals(sortType)) {
					sortByFullName = sortValue;
				} else if ("code_level".equals(sortType)) {
					sortByCodeLevel = sortValue;
				} else if ("end_date".equals(sortType)) {
					sortByEndDate = sortValue;
				}
				break;
			case "paging":
				sortType = request.getParameter("sortType");
				fullName = request.getParameter("fullName");
				grId = Integer.parseInt(request.getParameter("group_id"));
				sortValue = String.valueOf(request.getParameter("sortValue"));
				if ("full_name".equals(sortType)) {
					sortByFullName = sortValue;
				} else if ("code_level".equals(sortType)) {
					sortByCodeLevel = sortValue;
				} else if ("end_date".equals(sortType)) {
					sortByEndDate = sortValue;
				}
				String pageNumber = request.getParameter("currentPage");
				if (pageNumber != null) {
					currentPage = Integer.parseInt(pageNumber);
				} else
					currentPage = Constant.PAGE_DEFAULT;
				ofset = Common.getOffset(currentPage, limit);
				
				break;
			case "back":
				fullName = session.getAttribute("fullName").toString();
				grId = Integer.parseInt(session.getAttribute("group_id").toString());
				sortType =session.getAttribute("sortType").toString();
				sortValue=session.getAttribute("sortValue").toString();
				sortByFullName = session.getAttribute("sortByFullName").toString();
				sortByCodeLevel = session.getAttribute("sortByCodeLevel").toString();
				sortByEndDate = session.getAttribute("sortByEndDate").toString();
				currentPage = Integer.parseInt(session.getAttribute("currentPage").toString());
				break;
			default:
				break;
			}
			lstGr.addAll(mstGr.getAllMstGroup());
			lstUser.addAll(tbUser.getListUsers(ofset, limit, grId, fullName, sortType, sortByFullName, sortByCodeLevel,
					sortByEndDate));
			// System.out.println(lstGr.get(0));
			// gán thông báo lên màn hình
			MessageErrorProperties ms = new MessageErrorProperties();
			request.setAttribute("ERR", ms.getValueByKey("MSG005"));
			//tong so user
			int totalUser = tbUser.getTotalRecords(grId, fullName);
			lstPaging.addAll(Common.getListPaging(totalUser, limit, currentPage));
		//	System.out.println(lstPaging.get(2));
			//tong page
			int totalPage = Common.getTotalPage(totalUser, limit);
			// dua danh sách user vào request lay danh sach user
			request.setAttribute("lstUser", lstUser);
			// them nhom vao list
			// gan gia tri len request
			request.setAttribute("lstGroup", lstGr);
			request.setAttribute("fullName", fullName);
			request.setAttribute("group_id", grId);
			request.setAttribute("sortType", sortType);
			request.setAttribute("sortByFullName", sortByFullName);
			request.setAttribute("sortByCodeLevel", sortByCodeLevel);
			request.setAttribute("sortByEndDate", sortByEndDate);
			request.setAttribute("limit", limit);
			request.setAttribute("limitPage", limitPage);
			request.setAttribute("lstPaging", lstPaging);
			request.setAttribute("totalPage", totalPage);
			//set cac gia tri len session
			session.setAttribute("currentPage", currentPage);
			session.setAttribute("fullName", fullName);
			session.setAttribute("group_id", grId);
			session.setAttribute("sortType", sortType);
			session.setAttribute("sortValue", sortValue);
			session.setAttribute("sortByFullName", sortByFullName);
			session.setAttribute("sortByCodeLevel", sortByCodeLevel);
			session.setAttribute("sortByEndDat	e", sortByEndDate);
			session.setAttribute("limit", limit);
			session.setAttribute("totalPage", totalPage);
			session.setAttribute("limitPage", limitPage);
			// hien thi man hinh adm002
			RequestDispatcher dispatcher = request.getRequestDispatcher(Constant.LINK_ADM002_JSP);
			dispatcher.forward(request, response);
		} else {
			//neu chua dang nhap quay ve man hinh ADM001
			response.sendRedirect(Constant.URL_LOGIN);
		}
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
