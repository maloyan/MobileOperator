<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<script>
		<c:set var="errors">00,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,30,31,32,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,1000</c:set>

		<c:forTokens items="${ errors }" delims="," var="err">
			var msg${ err } = $('<p/>', {
				text: '<spring:message code="error.${ err }" />'
			})
		</c:forTokens>
	</script>
