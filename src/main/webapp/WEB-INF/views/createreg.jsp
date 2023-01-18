<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CreateRegistration</title>
</head>
<body>
<h2>NewRegistration</h2>

<form action="savereg" method="post">
<table>
<tr>
<td>name</td>
<td><input type="text" name="name"></td>
</tr>

<tr>
<td>city</td>
<td><input type="text" name="city"></td>
</tr>


<tr>
<td>email</td>
<td><input type="text" name="email"></td>
</tr>



<tr>
<td>mobile</td>
<td><input type="text" name="mobile"></td>
</tr>




</table>
<input type="submit" value="save">

</form>
<%
if(request.getAttribute("msg")!=null){
	out.println(request.getAttribute("msg"));

}


%>
</body>
</html>