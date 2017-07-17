<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login page</title>
    <link href="<c:url value="/static/css/login.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/static/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
</head>

<body>
<hgroup>
    <h1>Login</h1>
    <h3>YOU GONNA LOVE MY SITE!</h3>
</hgroup>
<c:url var="loginUrl" value="/login"/>
<form action="${loginUrl}" method="POST">
    <c:if test="${param.error != null}">
        <div class="alert alert-danger">
            <p>Invalid username and password.</p>
        </div>
    </c:if>
    <c:if test="${param.logout != null}">
        <div class="alert alert-success">
            <p>You have been logged out successfully.</p>
        </div>
        <br/>
    </c:if>
    <div class="group">
        <input type="text" id="username" name="ssoId" required><span class="highlight"></span><span class="bar"></span>
        <label>Username</label>
    </div>
    <div class="group">
        <input type="password" id="password" name="password" required><span class="highlight"></span><span
            class="bar"></span>
        <label>Password</label>
    </div>
    <div id="expanddit_console">
        <input id="rememberme" name="remember-me" type="checkbox">
        <b style="color: #999;font-size: 18px;font-weight: normal;">Remember me</b>
    </div>
    <br/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit" class="button buttonBlue">LOGIN
        <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
    </button>
</form>
<footer>
    <div class="row">
        <p>Powerred by TUNGDD with <i class="fa fa-heart" aria-hidden="true" style="color:red"></i></p>
    </div>
</footer>
<script src="<c:url value="/static/js/lib/jquery.min.js"/>"></script>
<script src="<c:url value="/static/js/login.js"/>"></script>
</body>
</html>
