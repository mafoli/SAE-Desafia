<%-- 
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/bootstrap-switch.css">
    <script src="js/jquery-2.2.1.min.js"></script>
    <script src="js/pesquisa.js.js" type="text/javascript"></script>
    <script src="js/bootstrap.js"></script>
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
    <script src="js/bootstrap-switch.js"></script>
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="js/jquery-ui-1.11.4.custom/jquery-ui.min.css">
    <script src="js/jquery-ui-1.11.4.custom/jquery-ui.min.js"></script>
    <script src="js/jquery.mask.js"></script>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> SAE Ingressos </title>
    </head>
    <body>
         <body>
             <div class="container">
                 <div class="row">
                     <div class="col-md-4 col-md-offset-4">
                    <div class=" login-panel panel panel-default">
                         <div class="panel-heading">
                         <h3 class="panel-title">  SAE Ingressos </h3>
                         </div>
                         <div class="panel-body">
        <form role="form" action="ProcessaLogin" method="POST">
            <fieldset>
                <div class="form-group">
            
            <input  class="form-control" placeholder="Acesso" type="text" name="login"/>
                </div>
                <div class="form-group">
            <input class="form-control" placeholder="Senha" type="password" name="senha"/>
                </div>
                <button class="btn btn-primary btn-block botao" type="submit"> Acessar</button>
            </fieldset>
        </form>
                         </div>
                     </div>
                 </div>
             </div>
             </div>           

    </body>
    
</html>
