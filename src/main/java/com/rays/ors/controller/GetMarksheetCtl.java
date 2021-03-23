package com.rays.ors.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.rays.ors.bean.BaseBean;
import com.rays.ors.bean.MarksheetBean;
import com.rays.ors.exception.ApplicationException;
import com.rays.ors.model.MarksheetModel;
import com.rays.ors.util.DataUtility;
import com.rays.ors.util.DataValidator;
import com.rays.ors.util.PropertyReader;
import com.rays.ors.util.ServletUtility;

/**
 * Get Marksheet functionality Controller. Performs operation for Get Marksheet
 *
 * @author Prateek
 */
@WebServlet(name = "GetMarksheetCtl", urlPatterns = { "/ctl/GetMarksheetCtl" })
public class GetMarksheetCtl extends BaseCtl {
	// private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(GetMarksheetCtl.class);

	protected boolean validate(HttpServletRequest request) {
		// log.debug("GetMarksheetCtl validate method started");
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("rollNo"))) {
			request.setAttribute("rollNo", PropertyReader.getValue("error.require", "Roll Number"));
			pass = false;
		}
		log.debug("GetMarksheetCtl validate mtd ended");
		return pass;
	}

	protected BaseBean populateBean(HttpServletRequest request) {

//		log.debug("GetMarksheetCtl populateBean mtd ended");
		MarksheetBean bean = new MarksheetBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));

		bean.setRollNo(DataUtility.getString(request.getParameter("rollNo")));

		bean.setName(DataUtility.getString(request.getParameter("name")));

		bean.setPhysics(DataUtility.getInt(request.getParameter("physics")));

		bean.setChemistry(DataUtility.getInt(request.getParameter("chemistry")));

		bean.setMaths(DataUtility.getInt(request.getParameter("maths")));

		// log.debug("GetMarksheetCtl validate mtd ended");

		return bean;
	}

	/**
	 * Concept of Display method
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletUtility.forward(getView(), request, response);
	}

	/**
	 * Concept of Submit Method
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// log.debug("GetMarksheetCtl doPost method Started");
		String op = DataUtility.getString(request.getParameter("operation"));
		System.out.println(request.getParameter("rollNo"));
		System.out.println(">>>>>>>>>>>>>>>>" + op);
		// get model
		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = (MarksheetBean) populateBean(request);

		long rNo = DataUtility.getLong(request.getParameter("rollNo"));
		System.out.println("Roll No>>>>>>>>>>>>>>>>>>>>>>>>>" + rNo);
		if (OP_GO.equalsIgnoreCase(op)) {
			try {
				bean = model.findByRollNo(bean.getRollNo());
				if (bean != null) {
					ServletUtility.setBean(bean, request);					
				} else {
					ServletUtility.setErrorMessage("RollNo does not exist", request);
				}
			} catch (ApplicationException e) {
				// log.error(e);
				e.printStackTrace();
				ServletUtility.handleException(e, request, response);
				return;
			}
			System.out.println("before getView of (GMV) doPost method");
			ServletUtility.forward(getView(), request, response);
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.GET_MARKSHEET_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);
		// log.debug("MarksheetCtl Method doGet Ended");

	}

	@Override
	protected String getView() {
		return ORSView.GET_MARKSHEET_VIEW;
	}

}
