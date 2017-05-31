package com.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.bn.BankInfoBean;


public class BankInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Step-1
		BankInfoBean bInfoBean=new BankInfoBean();
		String bank_Name=request.getParameter("bankID");
		String acc_Num=request.getParameter("accID");
		String ssn_Num=request.getParameter("ssnID");
		bInfoBean.setBankName(bank_Name);
		bInfoBean.setAccountNum(acc_Num);
		bInfoBean.setSsn(ssn_Num);
		
		//Step-2 added chaitanya
		//2a-validations
		String errors="";
		if(checkFieldBlank(bank_Name)){
			errors += "Bank name is blank";
		}
		if(checkFieldBlank(acc_Num)){
			errors += "Account is blank";
		}
		if(checkFieldBlank(ssn_Num)){
			errors += "Ssn is blank";
		}
		
		String msg="";
		if(checkLength(bank_Name)){
			msg +="Bank name is less than 2 charecters";
		}
		if(checkLength(acc_Num)){
			msg +="Account no is less than 2 charecters";
		}
		if(checkLength(ssn_Num)){
			msg +="Ssn no is less than 2 charecters";
		}
		
	
		//Step-3 Respond back
	
		if(checkFieldBlank(errors) && checkLength(msg)){
		HttpSession ses=request.getSession();
		ses.setAttribute("binfo1", bInfoBean);
		
		response.sendRedirect("jsp/beanoutput.jsp");
		
	}	else if(checkFieldBlank(errors)){
		request.setAttribute("msg", msg);
		RequestDispatcher rd=request.getRequestDispatcher("jsp/bank2.jsp");
		rd.forward(request, response);
	}	else{
		request.setAttribute("errors", errors);
		RequestDispatcher rd=request.getRequestDispatcher("jsp/bank.jsp");
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
