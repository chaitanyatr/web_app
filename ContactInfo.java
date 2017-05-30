package com.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.bn.ContactInfoBean;

public class ContactInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Step-1
		ContactInfoBean cInfoBean=new ContactInfoBean();
		String addr=request.getParameter("AddrID");
		String city_Name=request.getParameter("CityID");
		String state_Name=request.getParameter("StateID");
		String country_Name=request.getParameter("CountryID");
		String phn_Num=request.getParameter("PhoneID");
		cInfoBean.setAddress(addr);
		cInfoBean.setCity(city_Name);
		cInfoBean.setState(state_Name);
		cInfoBean.setCountry(country_Name);
		cInfoBean.setPhnNum(phn_Num);
		
		
		//Step-2
		//2a-validations
		String errors="";
		if(checkFieldBlank(addr)){
			errors +="address is blank";
		}
		if(checkFieldBlank(city_Name)){
			errors +="city name is blank";
		}
		if(checkFieldBlank(state_Name)){
			errors +="state is blank";
		}
		if(checkFieldBlank(country_Name)){
			errors +="country is blank";
		}
		if(checkFieldBlank(phn_Num)){
			errors +="phone is blank";
		}

		String msg="";
		if(checkLength(addr)){
			msg +="Address is less than 2 charecters";
		}
		if(checkLength(city_Name)){
			msg +="City is less than 2 charecters";
		}
		if(checkLength(state_Name)){
			msg +="State is less than 2 charecters";
		}
		if(checkLength(country_Name)){
			msg +="Country is less than 2 charecters";
		}
		if(checkLength(phn_Num)){
			msg +="Phone is less than 2 charecters";
		}
		
		
		//Step-3 respond back
		if(checkFieldBlank(errors)&& checkLength(msg)){
		HttpSession ses=request.getSession();
		ses.setAttribute("cinfo1", cInfoBean);
		
		response.sendRedirect("html/bankinfo.html");
		
		}else if(checkFieldBlank(errors)){
			request.setAttribute("msg", msg);
			RequestDispatcher rd=request.getRequestDispatcher("jsp/contact2.jsp");
			rd.forward(request, response);
		}
		else{
			request.setAttribute("errors", errors);
			RequestDispatcher rd=request.getRequestDispatcher("jsp/contact.jsp");
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
