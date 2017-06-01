<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Details</title>
</head>
<body>
You have registered successfully<br><br>

PersonalInfo:<br><br>
<jsp:useBean id="pinfo1" class="com.java.bn.PersonalInfoBean" scope="session"></jsp:useBean>
		<font color=red size=5>FirstName:</font>
		<jsp:getProperty property="firstName" name="pinfo1"/><br>
		<font color=red size=5>MiddleName:</font>
		<jsp:getProperty property="middleName" name="pinfo1"/><br>
		<font color=red size=5>LastName:</font>
		<jsp:getProperty property="lastName" name="pinfo1"/><br><br>

ContactInfo:<br><br>
<jsp:useBean id="cinfo1" class="com.java.bn.ContactInfoBean" scope="session"></jsp:useBean>
		<font color=red size=5>Address:</font>
		<jsp:getProperty property="address" name="cinfo1"/><br>
		<font color=red size=5>City:</font>
		<jsp:getProperty property="city" name="cinfo1"/><br>
		<font color=red size=5>Country:</font>
		<jsp:getProperty property="country" name="cinfo1"/><br>
		<font color=red size=5>State:</font>
		<jsp:getProperty property="state" name="cinfo1"/><br>
		<font color=red size=5>Phone:</font>
		<jsp:getProperty property="phnNum" name="cinfo1"/><br><br>

BankInfo:<br><br>
<jsp:useBean id="binfo1" class="com.java.bn.BankInfoBean" scope="session"></jsp:useBean>
		<font color=red size=5>BankName:</font>
		<jsp:getProperty property="bankName" name="binfo1"/><br>
		<font color=red size=5>Account:</font>
		<jsp:getProperty property="accountNum" name="binfo1"/><br>
		<font color=red size=5>SSn:</font>
		<jsp:getProperty property="ssn" name="binfo1"/>

</body>
</html>