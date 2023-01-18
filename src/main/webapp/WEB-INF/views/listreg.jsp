<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<h2>All Registrations</h2>
<table>

<thead>
<tr>
<th>name</th>
<th>city</th>
<th>email</th>
<th>mobile</th>
<th>delete</th>
<th>update</th>
</tr>
</thead>
<%
ResultSet result=(ResultSet)request.getAttribute("result");
while(result.next()){%>
<tbody>
<tr>
<td><%=result.getString(1) %></td>
<td><%=result.getString(2) %></td>
<td><%=result.getString(3) %></td>
<td><%=result.getString(4) %></td>
<td><a href="delete?emailID=<%=result.getString(3) %>">delete</a></td>
<td><a href="update?emailID=<%=result.getString(3) %>&mobile=<%=result.getString(4) %>">update</a></td>
</tr>
</tbody>

<%}%>

</table>


















</body>
</html>