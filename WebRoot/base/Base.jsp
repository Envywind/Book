<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String port = (request.getServerPort() == 80 || request.getServerPort() == 443) ? "" : ":" + String.valueOf(request.getServerPort());
    String basePath = request.getScheme() + "://" + request.getServerName() + port + path + "/";
    request.setAttribute("_basePath", basePath);
%>

	
	