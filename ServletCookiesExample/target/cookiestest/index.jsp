<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<html>
<html>
<head>
    <title>Hello Form</title>
</head>
<body>
<div>
    <%
        Cookie[] cookies = request.getCookies();
        String login = "";
        String password = "";
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("login")) {
                    login = cookie.getValue();
                } else if (cookie.getName().equals("password")) {
                    password = cookie.getValue();
                }
            }
        }
    %>
    <h1>Login</h1>
    <form method="post" action="Registration">
        <ul>
            <li>Login: <input name="login" type="text" value="<%=login%>"></li>
        </ul>
        <ul>
            <li>Password: <input name="password" type="password" value=<%=password%>></li>
        </ul>
        <ul>
            <li>Submit:<input type="submit" value="submit"></li>
        </ul>
    </form>
    <c:if test="${inSystem}">
        <h1>Logged in user: <%=login%></h1>
    </c:if>
</div>

<div>
    <h1>Register</h1>
    <form method="get" action="Registration">
        <ul>
            <li>Login: <input name="login" type="text"></li>
        </ul>
        <ul>
            <li>Password: <input name="password" type="password"></li>
        </ul>
        <ul>
            <li>Submit:<input type="submit" value="register"></li>
        </ul>
    </form>
</div>

</body>
</html>