<%-- 
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SAE Ingressos </title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class=" alert alert-primary">
            
            <strong>${mensagem}</strong>
        </div>
        <a  class="btn btn-default" href="${voltar}"><i class="fa fa-fw fa-reply"></i>Voltar</a>
    </body>
</html>
