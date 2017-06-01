<html>
<body>

<form method="get" action="/ValidationsPractise/Person">
<%
	Object obj=request.getAttribute("errors");
	String errorMsg="";
	if(obj !=null){
		errorMsg = (String) obj;
	}
	
%>
<%=errorMsg %><br>

	<br>First Name:<br>
	<input type="text" name="firstname"><br>
	Last Name:<br>
	<input type="text" name="lastname"><br>
	Middle Name:<br>
	<input type="text" name="middlename"><br><br>
	
	Gender <input type="radio" name="gender" value="male" checked> Male
	<input type="radio" name="gender" value="female"> Female<br><br>
	<input type="submit" value="Submit">

</form>

</html>
</body>