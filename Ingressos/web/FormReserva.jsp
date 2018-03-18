<%-- 
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SAE Ingressos </title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        
        <jsp:useBean id="espetaculo" scope="request" class="Model.Espetaculo" />
        <form method="post" action="ProcessaReserva?tipoServlet=insertreserva">
            <div class="form-group">
                <div style="display:none;">
                    <input type="text" value="${espetaculo.id}" name="id">
                   
                </div>
                <div class="row">
                
                    
                    <div class="container">
                     
                    
                    <div class="col-md-3">
                    <h3> Reserva</h3>
                    
                    <label>Cliente:</label><br>
                    <select required id="ddlTipoOcupacao"  onkeypress="cbboxSearch(this, event); return false;" name="idCliente" class="js-example-basic-single  form-control">
                   
                    <c:forEach items="${dadoscliente}" var="y">
                            <option   value="${y.id}">${y.nome}</option>
                    </c:forEach>
                    </select><br><br>
                    
                    <label>Quantidade:</label><br><input  required="true" class=" form-control quantidade intmask" type="text" value="" name="qtdade"><br><br>
                    <label>Valor:</label><br><input  required="true" class=" form-control number "  readonly="true" value="23.76" name="precovenda"><br><br>
                   
                    </p>
                    <button class="btn btn-primary" type="submit" value="Adicionar"><i class="fa fa-fw fa-plus-circle"></i>Adicionar</button>
                    

                   
        </form>
                    </div>
                    
                     <div class="col-md-9">
                     <div class="jumbotron">
                    <h3> Itens</h3>
                         <table class="table table-condensed">
            <thead>
                <tr>
                    <th >Descrição</th>
                    <th >Quantidade</th>
                    <th >Valor </th>
                    <th> Total </th>
                    <th>Ações</th>
                </tr>
            </thead>
            <c:forEach items="${dados}" var="x">
                <tr>
                    <td >${x.cliente.nome}</td>
                    <td >${x.qtdade}</td>
                    <td >R$${x.precovenda}</td>
                    <td >R$${x.precovenda * x.qtdade}</td>
                    
                    <td style="text-align:center;">
                        <a class=" btn btn-danger btn-xs" href="ProcessaReserva?idEspetaculo=${x.id_espetaculo}&idCliente=${x.cliente.id}&tipoServlet=deleteitem"> <i class="fa fa-fw fa-eraser"></i>Excluir</a>
                    </td>
                </tr>
                 
              </c:forEach>
        </table> 
                   </p>
                   
                   <h3 class='number'> Total:R$${total} </h3>
                   <h3 class='number'> Total de Poltronas:${espetaculo.poltrona} </h3>
                   <h3 class='number'> Total Reserva:${totalreserva} </h3>
                   <h3 class='number'> Poltronas Disponíveis :${espetaculo.poltrona - totalreserva} </h3>
                   
                    <a class="btn btn-default" href="ProcessaEspetaculo?id=${cliente.id}"><i class="fa fa-fw fa-reply"></i>Voltar</a>
                     </div>
                  
                    
                  
                    </div>
                    </div>
       
    </body>
</html>
