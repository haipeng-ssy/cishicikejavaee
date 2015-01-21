<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	操作成功！！
	
	
	<!-- jsp语法 -->
	<%
	   String str= ""+request.getAttribute("message");
	   
	%>
	<%=str%>
	<!-- jstl标签 -->
	<c:out value="${message}"></c:out>
	
	<!-- jstl中的EL表达式 -->
	${message}
</body>
</html>