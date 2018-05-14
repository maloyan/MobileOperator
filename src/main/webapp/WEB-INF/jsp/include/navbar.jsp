<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button class="navbar-toggle" data-target="#header_navbar" data-toggle="collapse" type="button">
					<span class="sr-only"><spring:message code="label.tog_nav" /></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value="/" />"><spring:message code="title.site" /></a>
			</div>
			<div class="collapse navbar-collapse" id="header_navbar">
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a data-toggle="modal" data-target=".bs-example-modal-sm" href="#"><spring:message code="label.language" /></a>
					</li>
			 		<li>
						<% if (session.getAttribute("user_id") != null) { %>
							<a href="<c:url value="/user/" />"><spring:message code="label.member_area" /></a>
						<% } else if (session.getAttribute("is_admin") != null) { %>
							<a href="<c:url value="/admin/" />"><spring:message code="label.cp" /></a>
						<% } else { %>
							<a href="<c:url value="/login" />"><spring:message code="label.login" /></a>
						<% } %>
					</li>
				</ul>
			</div>
		</div>
	</div>


	<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-sm">
	    <div class="modal-content" align="center">
			<div class="modal-header"align="left">
				<button class="close" aria-hidden="true" data-dismiss="modal" type="button">
					×
				</button>
				<h4 id="mySmallModalLabel" class="modal-title">
					<spring:message code="label.select_language" />
				</h4>
			</div>
			<p>
				<div class="btn-group">
				  <a href="<c:url value="/set_locale?locale=ru" />" type="button" class="btn btn-default">RU</a>
				</div>
			</p>
	    </div>
	  </div>
	</div>
