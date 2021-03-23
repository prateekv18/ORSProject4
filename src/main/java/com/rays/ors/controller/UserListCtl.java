package com.rays.ors.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.rays.ors.bean.BaseBean;
import com.rays.ors.bean.UserBean;
import com.rays.ors.exception.ApplicationException;
import com.rays.ors.model.RoleModel;
import com.rays.ors.model.UserModel;
import com.rays.ors.util.DataUtility;
import com.rays.ors.util.PropertyReader;
import com.rays.ors.util.ServletUtility;
import com.sun.mail.util.PropUtil;

/**
 * Servlet implementation class UserListCtl
 */
//TODO: Auto-generated Javadoc
/**
 * User List functionality Controller. Performs operation for list, search and
 * delete operations of User
 * 
 * @author Prateek
 */
@WebServlet(name = "UserListCtl", urlPatterns = { "/ctl/UserListCtl" })
public class UserListCtl extends BaseCtl {

	/* The log */
	private static Logger log = Logger.getLogger(UserListCtl.class);

	/**
	 * private static final long serialVersionUID = 1L;@see
	 * HttpServlet#HttpServlet() public UserListCtl() { super(); // TODO
	 * Auto-generated constructor stub}
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.co.rays.ors.controller.BaseCtl#preload(javax.servlet.http.
	 * HttpServletRequest)
	 */ @Override
	protected void preload(HttpServletRequest request) {
		RoleModel rm = new RoleModel();
		UserModel um = new UserModel();

		try {
			List rl = rm.list();
			List ul = um.list();

			request.setAttribute("RoleList", rl);
			request.setAttribute("LoginId", ul);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.co.rays.ors.controller.BaseCtl#populateBean(javax.servlet.http.
	 * HttpServletRequest)
	 */ @Override
	protected BaseBean populateBean(HttpServletRequest request) {
		UserBean ub = new UserBean();

		ub.setFirstName(DataUtility.getString(request.getParameter("firstName")));
	//	ub.setRoleId(DataUtility.getLong(request.getParameter("Role_ID")));
		ub.setLogin(DataUtility.getString(request.getParameter("login")));

		return ub;
	}

	/**
	 * Contains Display logics.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inside doget");
		// log.debug("UserList doGet started");
		List l = null;
		List nextList = null;

		int pageNo = 1;
		int pageSize = DataUtility.getInt(PropertyReader.getValue("page.size"));

		UserBean ub = (UserBean) populateBean(request);
		 String op = DataUtility.getString(request.getParameter("operation"));

		// get the selected checkbox ids array for delete list

        String[] ids = request.getParameterValues("ids");
		UserModel um = new UserModel();
		try {
			l = um.search(ub, pageNo, pageSize);
			nextList = um.search(ub, pageNo + 1, pageSize);

			request.setAttribute("nextlist", nextList.size());

			ServletUtility.setList(l, request);
			if (l == null || l.size() == 0) {
				ServletUtility.setErrorMessage("No record found", request);
			}
			ServletUtility.setList(l, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);
		} catch (Exception e) {
			log.error(e);
		e.printStackTrace();
			//	ServletUtility.handleException(e, request, response);
			return;
		}
		log.debug("UserListCtl doGet End");
	}

	/**
	 * Contains Submit logics.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("UserListCtl doPost Start");
		List l;
		List nextList = null;

		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));
		pageNo = (pageNo == 0) ? 1 : pageNo;
		pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader.getValue("page.size")) : pageSize;

		String op = DataUtility.getString(request.getParameter("operation"));
		UserBean ub = (UserBean) populateBean(request);

		// get the selected checkbox ids array for delete list
		String[] ids = request.getParameterValues("ids");
		UserModel um = new UserModel();
		if (OP_SEARCH.equalsIgnoreCase(op)) {
			pageNo = 1;
		} else if (OP_NEXT.equalsIgnoreCase(op)) {
			pageNo++;
		} else if (OP_PREVIOUS.equalsIgnoreCase(op) && pageNo > 1) {
			pageNo--;
		} else if (OP_NEW.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.USER_CTL, request, response);
			return;
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.USER_LIST_CTL, request, response);
			return;
		} else if (OP_DELETE.equalsIgnoreCase(op)) {
			pageNo = 1;
			if (ids != null && ids.length > 0) {
				UserBean deletebean = new UserBean();
				for (String id : ids) {
					deletebean.setId(DataUtility.getInt(id));
					try {
						um.delete(deletebean);
					} catch (ApplicationException e) {
						log.error(e);
						e.printStackTrace();
						ServletUtility.handleException(e, request, response);
						return;
					}

					ServletUtility.setSuccessMessage("User is Deleted Successfully", request);
				}
			} else {
				ServletUtility.setErrorMessage("Select at least one record", request);
			}
		}
		try {
			l = um.search(ub, pageNo, pageSize);
			nextList = um.search(ub, pageNo + 1, pageSize);
			request.setAttribute("nextlist", nextList.size());
		} catch (ApplicationException e) {
			//log.error(e);
			e.printStackTrace();
			//ServletUtility.handleException(e, request, response);
			return;
		}
		if (l == null || l.size() == 0 && !OP_DELETE.equalsIgnoreCase(op)) {
			ServletUtility.setErrorMessage("No record found", request);
		}
		ServletUtility.setList(l, request);
		ServletUtility.setBean(ub, request);
		ServletUtility.setPageNo(pageNo, request);
		ServletUtility.setPageSize(pageSize, request);
		ServletUtility.forward(getView(), request, response);
		log.debug("UserListCtl doPost End");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.co.rays.ors.controller.BaseCtl#getView()
	 */
	@Override
	protected String getView() {
		return ORSView.USER_LIST_VIEW;
	}

}
