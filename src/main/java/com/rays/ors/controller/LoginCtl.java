package com.rays.ors.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.rays.ors.bean.BaseBean;
import com.rays.ors.bean.RoleBean;
import com.rays.ors.bean.UserBean;
import com.rays.ors.exception.ApplicationException;
import com.rays.ors.model.RoleModel;
import com.rays.ors.model.UserModel;
import com.rays.ors.util.DataUtility;
import com.rays.ors.util.DataValidator;
import com.rays.ors.util.PropertyReader;
import com.rays.ors.util.ServletUtility;

//TODO: Auto-generated Javadoc
/**
 * Login functionality Controller. Performs operation for Login
 * 
 * @author Prateek
 */

@WebServlet(name = "LoginCtl", urlPatterns = { "/LoginCtl" })
public class LoginCtl extends BaseCtl {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant OP_REGISTER. */
	public static final String OP_REGISTER = "Register";

	/** The Constant OP_SIGN_IN. */
	public static final String OP_SIGN_IN = "SignIn";

	/** The Constant OP_SIGN_UP. */
	public static final String OP_SIGN_UP = "SignUp";

	/** The Constant OP_LOG_OUT. */
	public static final String OP_LOG_OUT = "logout";

	/** The log. */
	private static Logger log = Logger.getLogger(LoginCtl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.co.rays.ors.controller.BaseCtl#validate(javax.servlet.http.
	 * HttpServletRequest)
	 */
	@Override
	protected boolean validate(HttpServletRequest request) {
		log.debug("LoginCtl Method validate Started");
		boolean pass = true;

		String op = request.getParameter("operation");
		if (OP_SIGN_UP.equals(op) || OP_LOG_OUT.equals(op)) {
			return pass;
		}

		String login = request.getParameter("login");

//		if (OP_SIGN_IN.equals(op)) {
		if (DataValidator.isNull(login)) {
			request.setAttribute("login", PropertyReader.getValue("error.require", "Login Id"));
			pass = false;
		} else if (!DataValidator.isEmail(login)) {
			request.setAttribute("login", PropertyReader.getValue("error.email", "Invalid "));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("password"))) {
			request.setAttribute("password", PropertyReader.getValue("error.require", "Password"));
			pass = false;
		}
		/*
		 * else if (!DataValidator.isPassword(request.getParameter("password"))) {
		 * request.setAttribute("password",
		 * "Password should contain 8 letter with alpha-numeric and special Character");
		 * pass = false; }
		 */

		log.debug("LoginCtl Method validate Ended");

		return pass;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.co.rays.ors.controller.BaseCtl#populateBean(javax.servlet.http.
	 * HttpServletRequest)
	 */
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		log.debug("LoginCtl Method populatebean Started");
		UserBean bean = new UserBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setLogin(DataUtility.getString(request.getParameter("login")));
		System.out.println("login>>>>>>>>>>>>>>" + request.getParameter("login"));
		bean.setPassword(DataUtility.getString(request.getParameter("password")));
		System.out.println("password>>>>>>>>>>>>>>" + request.getParameter("password"));
		log.debug("LoginCtl Method populatebean Ended");

		populateDTO(bean, request);
		System.out.println("end of populate bean");
		return bean;
	}

	/**
	 * Display Login form.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.debug(" Method doGet Started");

		HttpSession session = request.getSession(false);
		String op = DataUtility.getString(request.getParameter("operation"));

		long id = DataUtility.getLong(request.getParameter("id"));
		if (OP_LOG_OUT.equals(op) && !OP_SIGN_IN.equals(op)) {

			session.invalidate();
			ServletUtility.setSuccessMessage("User Logout Succesfully", request);
			ServletUtility.forward(getView(), request, response);
			return;
		} /*
			 * else{ ServletUtility.redirect(ORSView.WELCOME_CTL, request, response);
			 * return; }
			 */
		ServletUtility.forward(getView(), request, response);

	}

	/**
	 * Contains Submit logics.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug(" Login Ctl Method doPost Started");
		System.out.println("doPost starting");
		HttpSession session = request.getSession();
		String op = DataUtility.getString(request.getParameter("operation"));

		// get model
		UserModel model = new UserModel();
		RoleModel role = new RoleModel();

		if (OP_SIGN_IN.equalsIgnoreCase(op)) {
			UserBean bean = (UserBean) populateBean(request);

			try {
				bean = model.authenticate(bean.getLogin(), bean.getPassword());
				ServletUtility.setBean(bean, request);

				if (bean != null) {
					session.setAttribute("user", bean);
					long rollId = bean.getRoleId();
					RoleBean rolebean = role.findByPk(rollId);

					if (rolebean != null) {
						session.setAttribute("role", rolebean.getName());
					}

					// Code of The URI
					String str = (String) session.getAttribute("URI");
					if (str == null || "null".equalsIgnoreCase(str)) {
						ServletUtility.redirect(ORSView.WELCOME_CTL, request, response);
						return;
					} else {
						ServletUtility.redirect(str, request, response);
						return;
					}
				} else {
					bean = (UserBean) populateBean(request);
					ServletUtility.setBean(bean, request);
					ServletUtility.setErrorMessage("Invalid LoginId And Password", request);

				}
			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
		} else if (OP_SIGN_UP.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.USER_REGISTRATION_CTL, request, response);
			return;
		}

		// ServletUtility.setBean(bean, request);
		log.debug("loginCtl Method doPost Ended");
		ServletUtility.forward(getView(), request, response);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.co.rays.ors.controller.BaseCtl#getView()
	 */
	@Override
	protected String getView() {
		return ORSView.LOGIN_VIEW;
	}
}
