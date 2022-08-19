<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>YoilTellerMVC</title>
</head>
<body>
<h1>year=<%=request.getParameter("year") %></h1>
<h1>${myDate.year}년 ${myDate.month}월 ${myDate.day}일은 ${yoil}요일입니다.</h1> <!-- EL(Expression Language) 태크 -->
</body>
</html>