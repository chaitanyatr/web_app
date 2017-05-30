package com.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.bn.PersonalInfoBean;


public class PersonalInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Step-1
		PersonalInfoBean pInfoBean=new PersonalInfoBean();
		String fName=request.getParameter("firstname");
		String mName=request.getParameter("middlename");
		String lName=request.getParameter("lastname");
		String gen=request.getParameter("gender");
		pInfoBean.setFirstName(fName);
		pInfoBean.setMiddleName(mName);
		pInfoBean.setLastName(lName);
		
		//Step-2
		//2a-validations
		String errors="";
		if(checkFieldBlank(fName)){
			errors += "First name is blank";
		}
		if(checkFieldBlank(mName)){
			errors += "middle name is blank";
		}
		if(checkFieldBlank(lName)){
			errors += "Last name is blank";
		}
		
		String msg="";
		if(checkLength(fName)){
			msg +="First name is less than 2 charecters";
		}
		if(checkLength(mName)){
			msg +="Middle name is less than 2 charecters";
		}
		if(checkLength(lName)){
			msg +="Last name is less than 2 charecters";
		}
		
		
		//2b-db interaction
		
		if(checkFieldBlank(errors) && checkLength(msg)){
		HttpSession ses=request.getSession();
		ses.setAttribute("pinfo1",pInfoBean);
		
		response.sendRedirect("html/contactinfo.html");
		}
	
		else if(checkFieldBlank(errors)) {
		request.setAttribute("msg", msg);
		RequestDispatcher rd=request.getRequestDispatcher("jsp/personal2.jsp");
		rd.forward(request, response);
	}
		else{
			request.setAttribute("errors", errors);
			RequestDispatcher rd=request.getRequestDispatcher("jsp/personal.jsp");
			rd.forward(request, response);
		}
		
	}
	
	private boolean checkLength(String val) {
		return val.length()<2;
	}

	private boolean checkFieldBlank(String fieldValue) {
		return fieldValue==null ||fieldValue.length()==0;
	}

}

