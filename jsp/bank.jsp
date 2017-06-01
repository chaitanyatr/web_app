<html>
<head>
<title>Bank Info</title>
<style>
label{
width: 4.5em;
float: left;
text-align: right;
margin-right: 0.9em;
display: block
}
</style>
</head>
<body>
<form method="get" action="/ValidationsPractise/Bank">
<%
	Object obj=request.getAttribute("errors");
	String errorMsg="";
	if(obj !=null){
		errorMsg = (String) obj;
	}
%>
<%= errorMsg  %><br><br>
<label for="bankID">Bankname:</label>    <input type="text" name="bankID" /><br/>
<label for="accID">Accountnum:</label>   <input type="text" name="accID" /><br/>
<label for="ssnID">Ssn:</label>     <input type="text" name="ssnID" /><br/><br>
<input type="submit" value="Submit" class="floatright"/>
<br class="clear"/>
</form>
</body>
</html>