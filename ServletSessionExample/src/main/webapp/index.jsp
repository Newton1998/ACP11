<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %><html>
<html>
<head>
    <title>Hello Form</title>
</head>
<body>
<div>
    <h1>Login</h1>
    <c:if test="${!inSystem}">
    <form method="post" action="Registration">
        <ul>
            <li>Login: <input name="login" type="text"></li>
        </ul>
        <ul>
            <li>Password: <input name="password" type="password"></li>
        </ul>
        <ul>
            <li>Submit:<input type="submit" value="submit"></li>
        </ul>
    </form>
    </c:if>

    <c:if test="${inSystem}">
        <h1>Logged in user: ${login}</h1>
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