<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update registration</title>
</head>
<body>
<form action="update" method="post">
<table>
<tr>
<td>email</td>
<td><input type="text" name="email" value=<%=request.getAttribute("email") %>></td>
</tr>

<tr>
<td>mobile</td>
<td><input type="text" name="mobile"value=<%=request.getAttribute("mobile") %>></td>
</tr>
</table>
<input type="submit" value="update">`
</form>
</body>
</html>