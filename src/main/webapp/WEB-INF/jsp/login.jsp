<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,org.badcoding.hibernate.stored.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><spring:message code="title.login" /></title>

    <!-- Bootstrap core CSS -->
    <link href="js/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<%@include file="include/navbar.jsp" %>

<c:if test="${ !empty info }">
    <p>
    <div class="col-xs-10 col-xs-offset-1">
        <c:forEach items="${ info }" var="error">
            <div class="alert alert-info fade in">
                <button class="close" aria-hidden="true" data-dismiss="alert" type="button">
                    ×
                </button>
                <spring:message code="error.${ error }" />
            </div>
        </c:forEach>
    </div>
    </p>
</c:if>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-0 col-md-13 col-md-offset-0 main">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3><spring:message code="label.login.9" /></h3>
                </div>
                <div class="panel-body">
                    <form:form id="login" commandName="loginForm" action="process_login${ login_modifier }"  role="form">
                        <p><form:input path="id" name="id" type="text" class="form-control" placeholder="${ msg1 }" /></p>
                        <p><form:input path="password" name="password" type="password" class="form-control" placeholder="${ msg2 }" /></p>
                        <p><button class="btn btn-primary" type="submit"><spring:message code="label.login.10" /></button></p>
                    </form:form>
                </div>
            </div>
            <c:if test="${!empty login_errors}">
                <p>
                <div class="col-xs-10 col-xs-offset-1">
                    <c:forEach items="${ login_errors }" var="error">
                        <div class="alert alert-danger fade in">
                            <button class="close" aria-hidden="true" data-dismiss="alert" type="button">
                                ×
                            </button>
                            <strong><spring:message code="error.00" /></strong>
                            <spring:message code="error.${error}" />
                        </div>
                    </c:forEach>
                </div>
                </p>
            </c:if>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/js/bootstrap.min.js"></script>

</body>
</html>
