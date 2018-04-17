<%--
  Created by IntelliJ IDEA.
  User: narek
  Date: 06.04.18
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Mobile operator</title>
    <link href="/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
      <%@include file="navbar.jsp" %>
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
  </body>
</html>
