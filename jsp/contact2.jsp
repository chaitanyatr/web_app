<!-- the NewContact Screen -->
<html>
<head>
<title>New Address Form</title>
<style>
label{
width: 4em;
float: left;
text-align: right;
margin-right: 0.5em;
display: block
}
</style>
</head>
<body>
<form action="/ValidationsPractise/Contact">

<%
	Object obj=request.getAttribute("msg");
	String errorMsg="";
	if(obj !=null){
		errorMsg = (String) obj;
	}
%>
<%=errorMsg %><br><br>

<label for="AddrID">Address:</label>    <input type="text" name="AddrID" /><br/>
<label for="CityID">City:</label>   <input type="text" name="CityID" /><br/>
<label for="StateID">State:</label>     <input type="text" name="StateID" /><br/>
<label for="ContryID">Country: </label>        <input type="text" name="CountryID" /><br/>
<label for="PhoneID">Phone: </label>        <input type="text" name="PhoneID" /><br/>
<br class="clear" />
<br/>
<input type="submit" value="Submit" class="floatright"/>
<br class="clear"/>
</form>
</body>
</html>