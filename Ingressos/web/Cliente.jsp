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
        <form  method="post" action="ProcessaCliente?tipoServlet=busca">
            </span>
                </div>
                 </div>
        </div>
                 
          <div class="container">
             
        </form>
        </p>
       
            <h3 class="text-center"> Clientes</h3> 
        <a class="btn btn-primary " href="ProcessaCliente?id=0&tipoServlet=getform"><i class="fa fa-fw fa-user"></i>Novo Cliente</a>
        </p>
        
        <table  class="table table-condensed" >
            <thead>
                <tr>
                    <th >CPF</th>
                    <th >Nome</th>
                    <th >Sobrenome</th>
                    <th style="text-align:center;">Ações</th>
                </tr>
            </thead>
            <c:forEach items="${dados}" var="x">
                <tr>
                    <td >${x.cpf}</td>
                    <td >${x.nome}</td>
                    <td >${x.sobreNome}</td>
                    <td style="text-align:center;">
                                              
                        <a class="btn btn-default btn-xs" href="ProcessaCliente?id=${x.id}&tipoServlet=getform"><i class="fa fa-fw fa-edit"></i>Editar</a>
                        <a class="btn btn-danger btn-xs" href="ProcessaCliente?id=${x.id}&tipoServlet=delete"><i class="fa fa-fw fa-eraser"></i> Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
         </div>
        </div>
    </body>
    
</html>
