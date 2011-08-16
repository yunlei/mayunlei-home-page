<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="lang.jsp" %>
<title><%=welcome[langindex]%></title>
<script src="<%=request.getContextPath()%>/js/jquery-1.4.4.min.js"></script>
<script src="<%=request.getContextPath()%>/js/index.js"></script>
<%
 	if(session.getAttribute("init")==null)
 	{	
 		String ip=request.getRemoteUser();
 		session.setAttribute("init","init");
 		session.setAttribute("IP",ip);
%>
<script type="text/javascript">
$(document).ready(function(){
	 $.ajax({
		 type:"POST",
		 url:"init.action?ip="		 
	 });
});
</script>
<%	}
%>
</head>
<body>

<h1 style="text-align:center;"><%=welcome[langindex]%></h1>
<div id="langArea" style="float:right;">
<%
	for(int i=0;i<lang.length;i++)
	{
%>
		<a href='javascript:changeLang(<%=i%>)'  ><%=lang[i]%></a>
<%
	}
%>

</div>
</body>
</html>