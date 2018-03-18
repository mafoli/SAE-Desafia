

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
        <jsp:useBean id="espetaculo" scope="request" class="Model.Espetaculo" />
        <form method="post" action="ProcessaEspetaculo?tipoServlet=insert">
            <div class="form-group">
               
               
                <div style="display:none;">
                    <input type="text" value="${espetaculo.id}" name="id">
                </div>
               
                <div class="container">
                    
                    
                     <div class="col-md-3">
                  
                    
                
                  </div>
                     
                    <form>
                        <div class="form-group">
                           
                            
                      <div class="col-md-6">
                     <h3 class="center"> Cadastro de Espetaculos</h3> 
                    <label>Nome:</label><br>
                    <input class="form-control"  required="true" type="text" value="${espetaculo.nome}" name="nome"><br><br>
                    <label>Data:</label><br>
                    <fmt:formatDate var='fmtDate' value='${espetaculo.data}' pattern='dd/MM/yyyy' />
                    <input class="data dtmask form-control"  required="true" path="data" type="text" required="true" value="${fmtDate}" name="data"><br><br>
                    <label>Direção:</label><br>
                    <input class="form-control"  required="true" type="text" value="${espetaculo.direcao}" name="direcao"><br><br>
                    <label>Local:</label><br>
                    <input class="form-control"  required="true" type="text" value="${espetaculo.local}" name="local"><br><br>
                     <label>Poltronas:</label><br>
                    <input class=" form-control numero " required="true" type="text" value="${espetaculo.poltrona}" name="poltrona"><br><br>
                   <button class=" btn btn-primary" type="submit" value="Salvar" ><i class="fa fa-fw fa-save"></i>Salvar</button>
                    
                    <a  class="btn btn-default" href="ProcessaEspetaculo"><i class="fa fa-fw fa-reply"></i>Voltar</a>
                    </div>
                    <div class="col-md-6">
                  
                    
                    
                        </div>
                    </div>
                     </form>
                        </div>
                     
            </div>
            
        </form>
       
    </body>
</html>
