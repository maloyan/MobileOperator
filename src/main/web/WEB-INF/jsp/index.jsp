<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%--
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><spring:message code="title.main" /></title>

    <!-- Bootstrap core CSS -->
    <link href="js/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    --%>
</head>

<body>
asdsad
<%--
<%@include file="include/navbar.jsp" %>
<c:if test="${!empty errors}">
    <p>
    <div class="col-xs-10 col-xs-offset-1">
        <c:forEach items="${errors}" var="error">
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


<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12 col-sm-offset-0 col-md-8 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-body">
                    <form:form method="get" commandName="indexForm" action="index_search" role="form">
                        <div class="row">
                            <div class="col-xs-6">
                                <div class="form-group">
                                    <label for="city_out"><spring:message code="label.index.0" /></label>
                                    <form:input type="text" class="form-control" id="city_out" path="city_out" />
                                </div>
                                <div class="form-group">
                                    <label for="city_in"><spring:message code="label.index.1" /></label>
                                    <form:input type="text" class="form-control" id="city_in" path="city_in" />
                                </div>
                                <div class="form-group">
                                    <label for="company"><spring:message code="label.index.2" /></label>
                                    <form:input type="text" class="form-control" id="company" path="company" />
                                </div>
                            </div>
                            <div class="col-xs-6">
                                <div class="form-group">
                                    <label for="date0"><spring:message code="label.index.3" /></label>
                                    <form:input type="datetime" class="form-control" placeholder="dd.MM.yyyy [HH:mm]" id="date0" path="date0"/>
                                </div>
                                <div class="form-group">
                                    <label for="date1"><spring:message code="label.index.4" /></label>
                                    <form:input type="text" class="form-control" placeholder="dd.MM.yyyy [HH:mm]" id="date1" path="date1"/>
                                </div>
                                <div class="form-group" align="right">
                                    <br />
                                    <button type="submit" id="search_btn" data-loading-text="<spring:message code="label.index.25" />" class="btn btn-primary"><spring:message code="label.index.24" /></button>
                                </div>
                            </div>
                        </div>
                    </form:form>

                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/js/bootstrap.min.js"></script>
<script>
    var btn = document.getElementById('search_btn');
    btn.disabled = false;
    // btn.button('reset')
    btn.onclick = function () {
        var btn = $(this)
        btn.button('loading')
        btn.button
    };
</script>
--%>
</body>
</html>