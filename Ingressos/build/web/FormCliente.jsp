<%-- 
   
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SAE Ingressos</title>
    </head>
    <body>
       <jsp:include page="header.jsp"/>
        <jsp:useBean id="cliente" scope="request" class="Model.Cliente" />
        <form method="post" action="ProcessaCliente?tipoServlet=insert">
            <div class="form-group">
                <div style="display:none;">
                    <input type="text" value="${cliente.id}" name="id">
                </div>
                <div class="container">
                
                    
                    <h3> Cadastro Cliente </h3>
                    <div class="col-md-3">
                    <label>CPF:</label><br>
                    <input class=" form-control cpf cpfmask" type="text" value="${cliente.cpf}" name="cpf"><br><br>
                    <label>Nome:</label><br>
                    <input class=" form-control nome" required="true" type="text" value="${cliente.nome}" name="nome"><br><br>
                    <label>Sobrenome:</label><br><input class=" form-control sobreNome" required="true"type="text" value="${cliente.sobreNome}" name="sobreNome"><br><br>
                   </div>
                    <div class="col-md-3">
                    <label>Endereço:</label><br><input class=" form-control endereco"required="true" type="text" value="${cliente.endereco}" name="endereco"><br><br>
                    
                    <label> Numero:</label><br><input class=" form-control numero" required="true" type="text" value="${cliente.numero}" name="numero"><br><br>
                    
                    <label>Complemento:</label><br><input class=" form-control complemento" type="text" value="${cliente.complemento}" name="complemento"><br><br>
                    </div>
                    <div class="col-md-3">
                    <label>Cep:</label><br><input class=" form-control cep" type="text" value="${cliente.cep}" name="cep"><br><br>
                   
                    <label>Uf:</label><br><input class=" form-control uf" type="text" value="${cliente.uf}" name="uf"><br><br>
                    
                    <label>Cidade:</label><br><input class=" form-control sobreNome  " type="text" value="${cliente.cidade}" name="cidade"><br><br>
                    
                   
                    </div>
                    <div class="col-md-3">
                   <label>Bairro:</label><br><input class=" form-control bairro" type="text" value="${cliente.bairro}" name="bairro"><br><br>
                   <label>Telefone:</label><br><input class="form-control telefone" required="true"  type="text" value="${cliente.telefone}" name="telefone"><br><br>
                   
                    <label>Celular:</label><br><input class=" form-control celular" type="text" value="${cliente.celular}" name="celular"><br><br>
                     <button class=" btn btn-primary" type="submit" value="Salvar" ><i class="fa fa-fw fa-save"></i>Salvar</button>
                    <a class="btn btn-default" href="ProcessaCliente"><i class="fa fa-fw fa-reply"></i>Voltar</a>
               
                    </div>
                    
               </div>
             </div>
            </div>
        </form>
                   
    </body>
</html>
