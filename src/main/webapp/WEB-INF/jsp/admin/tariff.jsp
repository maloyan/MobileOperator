<%@ page language="java" import="org.badcoding.hibernate.stored.*,java.text.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <title><spring:message code="title.tariff" /></title>

    <!-- Bootstrap core CSS -->
    <link href="/js/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/dashboard.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<%@include file="../include/navbar.jsp" %>

<!-- Форма добавления пользователя -->
<div id="user_edit_modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="infoModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div id="info-modal-div" class="modal-content" align="center">
            <div class="modal-header" align="left">
                <button id="modal_close_btn" class="close" aria-hidden="true" data-dismiss="modal" type="button">
                    ×
                </button>
                <h4 id="user_edit_header" class="modal-title">
                </h4>
            </div>
            <div id="user_edit_body" class="modal-body">
                <form role="form" id="user_form">
                    <p><input id="id" name="id" type="text" class="form-control" placeholder="ID" /></p>
                    <p><input id="first_name" name="first_name" type="text" class="form-control" placeholder="Имя" /></p>
                    <p><input id="last_name"  name="last_name" type="text" class="form-control" placeholder="Фамилия" /></p>
                    <p><input id="company"  name="company" type="text" class="form-control" placeholder="Компания(если есть)" /></p>
                    <p><input id="email" name="email" type="text" class="form-control" placeholder="email" /></p>
                    <p><input id="address" name="address" type="text" class="form-control" placeholder="адрес" /></p>
                    <p><input id="personal_or_commercial" name="personal_or_commercial" type="text" class="form-control" placeholder="физическое лицо или юридическое" /></p>
                    <p><input id="passport" name="passport" type="text" class="form-control" placeholder="паспорт" /></p>
                </form>
            </div>
            <div class="modal-footer">
                <button id="modal_add_btn" type="button" class="btn btn-primary"> Добавить </button>
                <button id="modal_edit_btn" type="button" class="btn btn-primary"> Сохранить </button>
                <button id="modal_remove_btn" type="button" class="btn btn-danger"> Удалить </button>
            </div>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="<c:url value="/admin/users" />"><spring:message code="title.users" /></a></li>
                <li class="active"><a href="<c:url value="/admin/tariff" />"><spring:message code="title.tariff" /></a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="<c:url value="/admin/logout" />"><spring:message code="label.user.12" /></a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">
                <spring:message code="title.tariff" />
                <button id="user_add_btn" type="button" class="btn btn-default btn-lg">
                    <span class="glyphicon glyphicon-plus"></span>
                </button>
            </h1>
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
            <c:if test="${ !empty errors }">
                <p>
                <c:forEach items="${errors}" var="error">
                    <div class="alert alert-danger fade in">
                        <button class="close" aria-hidden="true" data-dismiss="alert" type="button">
                            ×
                        </button>
                        <strong><spring:message code="error.00" /></strong>
                        <spring:message code="error.${error}" />
                    </div>
                </c:forEach>
                </p>
            </c:if>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2 main">
                        <form:form method="get" id="tariff_form" commandName="tariffForm" action="/admin/tariff_search"  role="form">

                            <spring:message code="label.admin.01" var="msg1" />
                            <spring:message code="label.admin.18" var="msg2" />
                            <spring:message code="label.admin.19" var="msg3" />
                            <spring:message code="label.admin.20" var="msg4" />
                            <spring:message code="label.admin.21" var="msg5" />
                            <spring:message code="label.admin.22" var="msg6" />
                            <spring:message code="label.admin.23" var="msg7" />
                            <spring:message code="label.admin.24" var="msg8" />
                            <div class="row">
                                <div class="col-md-4">
                                    <p><form:input id="tariffId" path="tariffId" type="text" class="form-control" placeholder="${ msg1 }" /></p>
                                </div>
                                <div class="col-md-4">
                                    <p><form:input id="name" path="name" type="text" class="form-control" placeholder="${ msg2 }" /></p>
                                </div>
                                <div class="col-md-4">
                                    <p><form:input id="intMb" path="intMb" type="text" class="form-control" placeholder="${ msg3 }" /></p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <p><form:input id="intDay" path="intDay" type="text" class="form-control" placeholder="${ msg4 }" /></p>
                                </div>
                                <div class="col-md-4">
                                    <p><form:input id="callDayPerMinute" path="callDayPerMinute" type="text" class="form-control" placeholder="${ msg5 }" /></p>
                                </div>
                                <div class="col-md-4">
                                    <p><form:input id="callNightPerMinute" path="callNightPerMinute" type="text" class="form-control" placeholder="${ msg6 }" /></p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <p><form:input id="callPerDay" path="callPerDay" type="text" class="form-control" placeholder="${ msg7 }" /></p>
                                </div>
                                <div class="col-md-4">
                                    <p><form:input id="sms" path="sms" type="text" class="form-control" placeholder="${ msg8 }" /></p>
                                </div>
                                <div class="col-md-4" align="right">
                                    <p><button class="btn btn-primary" type="submit"><spring:message code="label.admin.06" /></button></p>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <c:forEach items="${ results }" varStatus="status" var="result">
                        <div class="row highlight">
                            <div class="col-md-5">
                                <p>
                                    <b><spring:message code="label.admin.25" />:</b> ${ result.firstName }
                                </p>
                                <p>
                                    <b><spring:message code="label.admin.26" />:</b> ${ result.lastName }
                                </p>
                            </div>
                            <div class="col-md-6">
                                <p>
                                    <b><spring:message code="label.admin.28" />:</b> ${ result.email }
                                </p>
                            </div>
                            <div class="col-md-1 no-rights" align="right">
                                <p>
                                    <button id="rm-${ result.customerId }-btn" type="button" class="btn btn-default btn-xs<c:if test="${ status.isLast() }"> rm-last</c:if>">
                                        <span class="glyphicon glyphicon-remove"></span>
                                    </button>
                                </p>
                                <p>
                                    <button id="edit-${ result.customerId }-btn" type="button" class="btn btn-default btn-xs<c:if test="${ status.isLast() }"> edit-last</c:if>">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                </p>
                                <p>
                                    <b><spring:message code="label.admin.01" />:</b> ${ result.customerId }
                                </p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/js/js/bootstrap.min.js"></script>
<script>
    $('#modal_add_btn').hide()
    $('#modal_edit_btn').hide()
    $('#modal_remove_btn').hide()
    $('#user_edit_modal').on('hidden.bs.modal', function (e) {
        $('#id').show()
        $('#modal_add_btn').hide()
        $('#modal_edit_btn').hide()
        $('#modal_remove_btn').hide()
        $('#user_form :input').each(function() {
            $(this).prop('disabled', false)
            $(this).show()
            $(this).val("")
        });
        $('#user_form').show()
        $('#errors_p').remove()
    })
</script>

<!-- Всплывающее окно для add -->
<script>
    var btn = $("#user_add_btn")[0]
    btn.onclick = function() {
        $('#id').show()
        $('#modal_add_btn').show()
        $('#registered').hide()
        $('#last_login').hide()
        $('#user_edit_header').text("<spring:message code="label.admin.14" /> <spring:message code="label.admin.31" />")
        $('#user_edit_modal').modal()
    }
</script>
<script>
    var btn = $("#modal_add_btn")[0]
    btn.disabled = false;
    btn.onclick = function() {
        $('#errors_p').remove()
        var btn = $(this)
        btn.button('loading')
        $.post( '<c:url value='/admin/add_user' />'
            , $('#user_form').serialize()
            , function(data) {
                $('<p/>', {
                    id: 'errors_p'
                }).appendTo('#user_edit_body');
                if (data.length == 0) {
                    $('<div/>', {
                        class: 'alert alert-success fade in',
                        id: 'alert_success'
                    }).appendTo('#errors_p');
                    $('#alert_success').append('<button class="close" aria-hidden="true" data-dismiss="alert" type="button">×</button>')
                    window['msg1000'].appendTo('#alert_success')
                    $('#user_form :input').each(function() {
                        $(this).val("");
                    });
                } else {
                    var i;
                    for (i = 0; i < data.length; ++i) {
                        var error = data[i]
                        $('<div/>', {
                            class: 'alert alert-danger fade in',
                            id: 'alert_error' + i.toString()
                        }).appendTo('#errors_p');
                        $('#alert_error' + i.toString()).append('<button class="close" aria-hidden="true" data-dismiss="alert" type="button">×</button>')
                        window['msg' + error.toString()].appendTo('#alert_error' + i.toString())
                    };
                }
                btn.button('reset')
            });
    }
</script>
<script>
    $.each($(":button[id^='rm-']"), function(i, btn) {
        btn.onclick = function () {
            $('#password').hide()
            $('#user_form :input').each(function() {
                $(this).prop('disabled', true)
            })
            $('#password').hide()
            $('#user_edit_header').text("<spring:message code="label.admin.15" /> <spring:message code="label.admin.31" />")
            var i = $(this).attr("id").match(/[\d]+/)[0]
            fill_form(i, '#modal_remove_btn')
        }
    })
</script>
<script>
    var btn = $("#modal_remove_btn")[0]
    btn.disabled = false;
    btn.onclick = function() {
        var btn = $(this)
        btn.button('loading')
        var i = $('#id').val().match(/[\d]+/)[0]
        $.post( '<c:url value='/admin/remove_user' />'
            , { user_id: i }
            , function(data) {
                $('<p/>', {
                    id: 'errors_p'
                }).appendTo('#user_edit_body');
                if (data.length == 0) {
                    $('<div/>', {
                        class: 'alert alert-success fade in',
                        id: 'alert_success'
                    }).appendTo('#errors_p');
                    $('#alert_success').append('<button class="close" aria-hidden="true" data-dismiss="alert" type="button">×</button>')
                    window['msg1000'].appendTo('#alert_success')
                    $('#user_form').hide()
                } else {
                    var i;
                    for (i = 0; i < data.length; ++i) {
                        var error = data[i]
                        $('<div/>', {
                            class: 'alert alert-danger fade in',
                            id: 'alert_error' + i.toString()
                        }).appendTo('#errors_p');
                        $('#alert_error' + i.toString()).append('<button class="close" aria-hidden="true" data-dismiss="alert" type="button">×</button>')
                        window['msg' + error.toString()].appendTo('#alert_error' + i.toString())
                    };
                }
                btn.button('reset')
                btn.hide()
            });
    }
</script>
<script>
    $.each($(":button[id^='edit-']"), function(i, btn) {
        btn.onclick = function () {
            $('#user_edit_header').text("<spring:message code="label.admin.16" /> <spring:message code="label.admin.31" />")
            $('#id').prop('disabled', true)
            $('#registered').hide()
            $('#last_login').hide()
            $('#password').hide()
            var i = $(this).attr("id").match(/[\d]+/)[0]
            fill_form(i, '#modal_edit_btn')
        }
    })
</script>
<script>
    var btn = $("#modal_edit_btn")[0]
    btn.disabled = false;
    btn.onclick = function() {
        $('#errors_p').remove()
        $('#id').prop('disabled', false)
        var btn = $(this)
        btn.button('loading')
        $.post( '<c:url value='/admin/edit_user' />'
            , $('#user_form').serialize()
            , function(data) {
                $('#id').prop('disabled', true)
                $('<p/>', {
                    id: 'errors_p'
                }).appendTo('#user_edit_body');
                if (data.length == 0) {
                    $('<div/>', {
                        class: 'alert alert-success fade in',
                        id: 'alert_success'
                    }).appendTo('#errors_p');
                    $('#alert_success').append('<button class="close" aria-hidden="true" data-dismiss="alert" type="button">×</button>')
                    window['msg1000'].appendTo('#alert_success')
                } else {
                    var i;
                    for (i = 0; i < data.length; ++i) {
                        var error = data[i]
                        $('<div/>', {
                            class: 'alert alert-danger fade in',
                            id: 'alert_error' + i.toString()
                        }).appendTo('#errors_p');
                        $('#alert_error' + i.toString()).append('<button class="close" aria-hidden="true" data-dismiss="alert" type="button">×</button>')
                        window['msg' + error.toString()].appendTo('#alert_error' + i.toString())
                    };
                }
                btn.button('reset')
            });
    }
</script>
<script>
    function fill_form(i, button) {
        $('#user_edit_modal').modal()
        var request = $.getJSON("get_user", { user_id: i }, function(data) {
            if (data.length == 1) { // error
                $('#user_form').hide()
                $('<p/>', {
                    id: 'errors_p'
                }).appendTo('#user_edit_body');
                var i;
                for (i = 0; i < data[0].length; ++i) {
                    var error = data[0][i]
                    $('<div/>', {
                        class: 'alert alert-danger fade in',
                        id: 'alert_error' + i.toString()
                    }).appendTo('#errors_p');
                    window['msg' + error.toString()].appendTo('#alert_error' + i.toString())
                };
            } else {
                var result = data[0]
                $('#id').val(result[0])
                $('#first_name').val(result[1])
                $('#last_name').val(result[2])
                $('#company').val(result[3])
                $('#email').val(result[4])
                $('#address').val(result[5])
                $('#personal_or_commercial').val(result[6])
                $('#passport').val(result[7])
                $(button).show()
            }
        });
        request.fail(function() {
            $('#user_form').hide()
            $('<p/>', {
                id: 'errors_p'
            }).appendTo('#user_edit_body');
            $('<div/>', {
                class: 'alert alert-danger fade in',
                id: 'alert_error'
            }).appendTo('#errors_p');
            window['msg00'].appendTo('#alert_error')
        });
    }
</script>
<%@include file="../include/errors.jsp" %>
</body>
</html>


