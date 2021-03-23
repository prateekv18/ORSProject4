package com.rays.ors.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.log4j.Logger;

import com.rays.ors.bean.BaseBean;
import com.rays.ors.bean.UserBean;
import com.rays.ors.exception.ApplicationException;
import com.rays.ors.exception.DuplicateRecordException;
import com.rays.ors.exception.RecordNotFoundException;
import com.rays.ors.model.UserModel;
import com.rays.ors.util.DataUtility;
import com.rays.ors.util.DataValidator;
import com.rays.ors.util.PropertyReader;
import com.rays.ors.util.ServletUtility;

/**
 * My Profile functionality Controller. Performs operation for update your
 * Profile
 *
 * @author Prateek
 */
@WebServlet(name = "MyProfileCtl", urlPatterns = { "/ctl/MyProfileCtl" })
public class MyProfileCtl extends BaseCtl {

	public static final String OP_CHANGE_MY_PASSWORD = "ChangePassword";
	// public static Logger log = Logger.getLogger(MyProfileCtl.class);

	protected boolean validate(HttpServletRequest request) {
		// log.debug("MyProfileCtl Method validate Started");

		boolean pass = true;

		String op = DataUtility.getString(request.getParameter("operation"));

		if (OP_CHANGE_MY_PASSWORD.equalsIgnoreCase(op) || op == null) {
			return pass;
		}
		if (DataValidator.isNull(request.getParameter("firstName"))) {
			System.out.println("First Name: " + request.getParameter("firstName"));

			request.setAttribute("firstName", PropertyReader.getValue("error.require", "First Name"));
			pass = false;

		}
		if (DataValidator.isNull(request.getParameter("lastName"))) {
			System.out.println("Last Name: " + request.getParameter("lastName"));

			request.setAttribute("lastName", PropertyReader.getValue("error.require", "Last Name"));
			pass = false;

		}

		if (DataValidator.isNull(request.getParameter("gender"))) {
			System.out.println("Gender: " + request.getParameter("gender"));

			request.setAttribute("Gender", PropertyReader.getValue("error.require", "gender"));
			pass = false;

		}
		if (DataValidator.isNull(request.getParameter("mobileNo"))) {
			System.out.println("mobileNo: " + request.getParameter("mobileNo"));

			request.setAttribute("mobileNo", PropertyReader.getValue("error.require", "Mobile No"));
			pass = false;

		}
		if (DataValidator.isNull(request.getParameter("dob"))) {
			System.out.println("DOB: " + request.getParameter("dob"));

			request.setAttribute("dob", PropertyReader.getValue("error.require", "DOB"));
			pass = false;

		}

		// log.debug("MyProfileCtl Method validate Ended");

		return pass;
	}

	protected BaseBean populateBean(HttpServletRequest request) {
		// log.debug("MyProfileCtl populateBean Started");

		UserBean ub = new UserBean();

		ub.setId(DataUtility.getLong(request.getParameter("Id")));

		ub.setLogin(DataUtility.getString(request.getParameter("login")));

		ub.setFirstName(DataUtility.getString(request.getParameter("firstName")));

		ub.setLastName(DataUtility.getString(request.getParameter("lastName")));

		ub.setMobileNo(DataUtility.getString(request.getParameter("mobileNo")));

		ub.setGender(DataUtility.getString(request.getParameter("gender")));

		ub.setDob(DataUtility.getDate(request.getParameter("dob")));

		populateDTO(ub, request);

		return ub;
	}

	/**
	 * Display Concept for viewing profile page view
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession(true);
		// log.debug("MyprofileCtl Method doGet Started");

		UserBean uB = (UserBean) hs.getAttribute("user");
		long id = uB.getId();
		String op = DataUtility.getString(request.getParameter("operation"));

		// get model
		UserModel um = new UserModel();
		if (id > 0 || op != null) {
			System.out.println("in d>0 condition");
			UserBean bn;
			try {
				bn = um.findByPK(id);
				ServletUtility.setBean(bn, request);
			} catch (ApplicationException e) {
				// log.error(e);
				e.printStackTrace();
				ServletUtility.handleException(e, request, response);
				return;
			}
		}
		ServletUtility.forward(getView(), request, response);

//	log.debug("MyProfileCtl Method doGet Ended");
	}

	/**
	 * Submit Concept
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		// log.debug("MyProfileCtl Method doPost Started");

		UserBean ub = (UserBean) session.getAttribute("user");
		long id = ub.getId();
		String op = DataUtility.getString(request.getParameter("operation"));

		// get Model
		UserModel um = new UserModel();

		if (OP_SAVE.equalsIgnoreCase(op)) {
			UserBean bn = (UserBean) populateBean(request);
			try {
				if (id > 0) {
					ub.setFirstName(bn.getFirstName());
					ub.setLastName(bn.getLastName());
					ub.setGender(bn.getGender());
					ub.setMobileNo(bn.getMobileNo());
					ub.setDob(bn.getDob());
					um.update(ub);
				}
				ServletUtility.setBean(bn, request);
				ServletUtility.setSuccessMessage("Updated successfully", request);
			} catch (ApplicationException e) {
				// log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setBean(bn, request);
				ServletUtility.setErrorMessage("Login id already exists", request);
			} catch (RecordNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (OP_CHANGE_MY_PASSWORD.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.CHANGE_PASSWORD_CTL, request, response);
			return;
		}

		ServletUtility.forward(getView(), request, response);
		// log.debug("MyProfileCtl doPost method ended");
	}

	@Override
	protected String getView() {
		return ORSView.MY_PROFILE_VIEW;
	}

}
