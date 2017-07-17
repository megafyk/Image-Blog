<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Create Post</title>
    <link href="<c:url value='/static/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value='/static/css/form.css'/>" rel="stylesheet" type="text/css"/>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
            <h2>CREATE POST</h2>
        </div>
    </div>

    <div ng-app="myUploadApp" class="ng-cloak">
        <div class="generic-container">
            <div class="row">
                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 col-xs-offset-3">
                    <form:form action="upload?${_csrf.parameterName}=${_csrf.token}" method="POST"
                               modelAttribute="fileBucket"
                               enctype="multipart/form-data">
                        <div flow-init>
                            <div class="thumbnail" ng-hide="$flow.files.length" flow-prevent-drop>
                                <img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&text=no+image"/>
                            </div>
                            <div class="thumbnail ng-hide" ng-show="$flow.files.length">
                                <img flow-img="$flow.files[0]">
                            </div>
                            <div>

                                <form:input type="file" path="file" id="file"
                                            cssStyle="visibility: visible; position: absolute" required="required"/>
                                <div class="has-error">
                                    <form:errors path="file" class="help-inline"/>
                                </div>
                                    <%--<span class="btn btn-primary" ng-show="!$flow.files.length" flow-btn="">Select image--%>

                                    <%--</span>--%>
                                <span class="btn btn-danger ng-hide" ng-show="$flow.files.length"
                                      ng-click="$flow.cancel()">Remove</span>
                            </div>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <div class="text-center">
                            <input type="submit" value="Publish" class="btn btn-start-order"/>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script src="<c:url value="/static/js/lib/ng-flow-standalone.min.js"/>"></script>
<script src="<c:url value="/static/js/module/upload_module.js"/>"></script>
</body>
</html>