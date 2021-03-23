package com.rays.ors.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.rays.ors.bean.BaseBean;
import com.rays.ors.bean.CollegeBean;
import com.rays.ors.exception.ApplicationException;
import com.rays.ors.model.CollegeModel;
import com.rays.ors.util.DataUtility;
import com.rays.ors.util.PropertyReader;
import com.rays.ors.util.ServletUtility;

/**
 * College List functionality Controller. Performs operation for list, search
 * and delete operations of College
 *
 * @author Prateek
 */
@WebServlet(name = "CollegeListCtl", urlPatterns = { "/ctl/CollegeListCtl" })
public class CollegeListCtl extends BaseCtl {

	private static Logger log = Logger.getLogger(CollegeListCtl.class);

	protected BaseBean populateBean(HttpServletRequest request) {
		CollegeBean bean = new CollegeBean();

		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setCity(DataUtility.getString(request.getParameter("city")));

		return bean;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNo = 1;
		int pageSize = DataUtility.getInt(PropertyReader.getValue("page.size"));

		CollegeBean bean = (CollegeBean) populateBean(request);
		CollegeModel model = new CollegeModel();

		List list = null;

		try {
			list = model.search(bean, pageNo, pageSize);
		} catch (ApplicationException e) {
			// log.error(e);
			e.printStackTrace();
			ServletUtility.handleException(e, request, response);
			return;
		}
		if (list == null || list.size() == 0) {
			ServletUtility.setErrorMessage("No record found", request);
		}

		ServletUtility.setList(list, request);
		ServletUtility.setPageNo(pageNo, request);
		ServletUtility.setPageSize(pageSize, request);
		ServletUtility.forward(getView(), request, response);
	}

	/**
	 * Contain Submit logic
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// log.debug("CollegeListCtl doPost Start");
		List list=null;
		
		int pageNo=DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize=DataUtility.getInt(request.getParameter("pageSize"));
	
		pageNo=(pageNo==0)?1:pageNo;
		
		pageSize=(pageSize==0)?DataUtility.getInt(PropertyReader.getValue("page.size")):pageSize;
		
		CollegeBean bean=(CollegeBean)populateBean(request);
		
		String op=DataUtility.getString(request.getParameter("operation"));
		
		CollegeModel model = new CollegeModel();
		
		try {
			if(OP_SEARCH.equalsIgnoreCase(op)||"Next".equalsIgnoreCase(op)||"Previous".equalsIgnoreCase(op)) {
				if(OP_SEARCH.equalsIgnoreCase(op)) {
					pageNo=1;
				}else if (OP_NEXT.equalsIgnoreCase(op)) {
					pageNo++;
				}else if (OP_PREVIOUS.equalsIgnoreCase(op)) {
					pageNo--;
				}
			}
			list=model.search(bean, pageNo, pageSize);
			ServletUtility.setList(list, request);
			if(list==null||list.size()==0) {
				ServletUtility.setErrorMessage("No record", request);				
			}
			ServletUtility.setList(list, request);
			
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);
			
		}catch (ApplicationException e) {
			// log.error(e);
			e.printStackTrace();
			ServletUtility.handleException(e, request, response);
			return;
		}
		//log.debug("CollegeListCtl doPost Ended");
	}

	@Override
	protected String getView() {
		return ORSView.COLLEGE_LIST_VIEW;
	}

}
/*
 * @see HttpServlet#HttpServlet() public CollegeListCtl() { super(); // TODO
 * Auto-generated constructor stub } private static final long serialVersionUID
 * = 1L;
 */

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
 *      response)
 */