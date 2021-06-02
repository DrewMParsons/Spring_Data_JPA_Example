<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sales Rep Manager</title>
</head>
<body>
<div align="center">
    <h2>Sales Rep  Manager</h2>
    
    <h3><a href="salesrep/new">New Sales Rep</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Office Code</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${listSalesRep}" var="salesRep">
        <tr>
            <td>${salesRep.id}</td>
            <td>${salesRep.name}</td>
            <td>${salesRep.officeCode}</td>
            <td>
                <a href="salesrep/edit?id=${salesRep.id}">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <a href="salesrep/delete?id=${salesRep.id}">Delete</a>
            </td>
        </tr>
        </c:forEach>
    </table>
    <h3><a href="${pageContext.request.contextPath}/">Home</a></h3>
</div>   
</body>
</html>