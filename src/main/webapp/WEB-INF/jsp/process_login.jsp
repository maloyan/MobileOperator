<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String login = request.getParameter("login");
   String password = request.getParameter("password");
   session.setAttribute("login", login);
   session.setAttribute("password", password);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Processing...</title>
</head>
<body>
	<!--script type="text/javascript">
		var loc = window.location.pathname.split("/");
		loc.pop();
		loc.push("index.jsp");
		location.replace(loc.join("/"));
	</script-->
	<!--jsp:forward page="index.jsp" /-->
	<meta http-equiv="refresh" content="0; URL=index.jsp">
</body>
</html>
</body>
</html>
</html>
</body>
</html>
