<%-- 
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> SAE Ingressos </title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
      
        <div class="container"> 
            
            <form method="post" action="ProcessaEspetaculo?tipoServlet=busca">
            <div class="col-xs-4">
            <div class="input-group">
          
                </div>
                 </div>
                </div>
            <div class="container"> 
            </form>
                    </p>

            
                 <h3 class="text-center"> Espetaculos</h3>
        <a  class="btn btn-primary" href="ProcessaEspetaculo?id=0&tipoServlet=getform"><i class="fa fa-fw fa-unlink"></i>Novo Espetaculo</a>
        </p>
        <table id="table" class=" table table-condensed">
            <thead>
                <tr>
                    
                    <th >Nome</th>
                    <th> Data</th> 
                    <th >Local</th>
                    <th >Direção</th>
                    <th >Poltronnas</th>
                    <th >Valor</th>
                    <th style="text-align:center;">Ações</th>
                </tr>
            </thead>
            <c:forEach items="${dados}" var="x">
                 
                <tr>
                   <p>${dado}</p>
                    
                    <td >${x.nome}</td>
                    <td > ${x.data}</td>
                    <td > ${x.local}</td>
                    <td >${x.direcao}</td>
                    <td >${x.poltrona}</td>
                    <td >R$ 23.76</td>
                    <td style="text-align:center;">
                        <a class="btn btn-primary btn-xs" href="ProcessaReserva?id=${x.id}&tipoServlet=getform"><i class="fa fa-fw fa-edit"></i>Reservas</a>
                        <a class="btn btn-default btn-xs" href="ProcessaEspetaculo?id=${x.id}&tipoServlet=getform"><i class="fa fa-fw fa-edit"></i>Editar</a>
                        <a class="btn btn-danger btn-xs" href="ProcessaEspetaculo?id=${x.id}&tipoServlet=delete"><i class="fa fa-fw fa-eraser"></i> Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
