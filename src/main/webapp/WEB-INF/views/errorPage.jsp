<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Error!</title>
    <link href="<c:url value="/static/css/error.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <div class="boo-wrapper">
        <div class="boo">
            <div class="face"></div>
        </div>
        <div class="shadow"></div>
        <center>
            <div class="fof">
                <h1>Whoops! Error ${errorCode}</h1>
            </div>
        </center>
        <p style="font-weight: bold;">Sorry! ${errorMsg} -_-</p>
        <p>Please return <a href="/home">HomePage</a></p>
    </div>
</div>
</body>
</html>
