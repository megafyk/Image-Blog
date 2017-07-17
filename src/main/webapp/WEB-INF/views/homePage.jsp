<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Megafyk</title>
    <link href="<c:url value='/static/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/static/css/post.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/static/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
</head>

<body>
<div class="menu">
    <div class="title">MENU</div>
    <ul class="nav">
        <li><a href="#">Home</a></li>
        <li><a href="/login">Login</a></li>
        <li><a href="/about">About</a></li>
        <li><a href="#">Contact</a></li>
    </ul>
</div>
<div class='thetop'></div>
<section class="title container">
    <div class="row">
        <div class="col-md-12">
            <center>
                <h1>Megafyk's Blog</h1>
                <div class="seperator"></div>
                <p>This is where I store and release my stock for free!</p>
            </center>
        </div>
    </div>
</section>
<div class="gallery">
    <div ng-app='loadingApp' ng-controller='DemoController'>
        <div infinite-scroll='megafyk.nextPage()' infinite-scroll-disabled='megafyk.busy'
             infinite-scroll-distance='0'>

            <div class="container-fluid">
                <div class="row justify-content-xs-center">
                    <div ng-repeat="post in megafyk.posts">
                        <center>
                            <article class="image">
                                <img ng-src="/images/fulls/{{post.image_uri}}" alt=""/>
                            </article>
                        </center>
                    </div>
                </div>
            </div>
            <div class="container-fluid">
                <div class="container-fluid">
                    <div class='row justify-content-xs-center'>
                        <div class='scroll icon'><i class="fa fa-4x fa-angle-up"></i></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<footer>
    <div class="container-fluid">
        <div class="row">
            <a href="#"><i class="fa fa-google-plus-square fa-2x bounce" aria-hidden="true"
                           style="color:#4C4848"></i></a>
            <a href="#"><i class="fa fa-facebook-official fa-2x bounce" aria-hidden="true"
                           style="color:#4C4848"></i></a>
            <a href="#"><i class="fa fa-instagram fa-2x bounce" aria-hidden="true" style="color:#4C4848"></i></a>
            <a href="#"><i class="fa fa-github fa-2x bounce" aria-hidden="true" style="color:#4C4848"></i></a>
        </div>
        <br/>
        <div class="row">
            <p>Made by TUNGDD with <i class="fa fa-heart" aria-hidden="true" style="color:red"></i></p>
        </div>
    </div>
</footer>

<script src="<c:url value="/static/js/lib/jquery.min.js"/>"></script>
<script src="<c:url value="/static/js/lib/bootstrap.min.js"/>"></script>
<script src="<c:url value="/static/js/lib/angular.min.js"/>"></script>
<script src="<c:url value="/static/js/lib/ng-infinite-scroll.min.js"/>"></script>
<script src="<c:url value="/static/js/module/loading_module.js"/>"></script>
<script src="<c:url value="/static/js/module/scroll.js"/>"></script>
</body>
</html>