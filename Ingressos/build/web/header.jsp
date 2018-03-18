<%-- 
  
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="Usuario" scope="session" class="Model.Usuario" />
    <c:choose>
        <c:when test="${Usuario.id > 0}">
<head>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="js/jquery-ui-1.11.4.custom/jquery-ui.min.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/bootstrap-switch.css">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/jquery.dataTables.css" rel="stylesheet" type="text/css"/>
    <link href="css/dataTables.bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/dataTables.responsive.css" rel="stylesheet" type="text/css"/> 
    <link href="css/select2-bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/select2.min.css" rel="stylesheet" type="text/css"/>
    
    
   
    
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/jquery-ui-1.11.4.custom/jquery-ui.js" type="text/javascript"></script>
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/jquery-ui-1.11.4.custom/jquery-ui.min.js" type="text/javascript"></script>
    <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/jquery.dataTables.js"></script>
    <script src="js/dataTables.bootstrap.js"></script>
    <script src="js/dataTables.bootstrap.min.js" type="text/javascript"></script>
    <script src="js/select2.full.js"></script>
    <script src="js/pesquisa.js.js" type="text/javascript"></script>
    <script src="js/bootstrap-switch.js"></script>
    <script src="js/jquery.mask.js"></script>

    <script src="jqueynumber/jquery.number.js" type="text/javascript"></script>
    <script src="js/dataTables.responsive.js"></script>  
    <script src="jqueynumber/jquery.number.min.js" type="text/javascript"></script>
</head>
</c:when>

<c:otherwise>
    <link href="ProcessaLogout"/>
</c:otherwise>
    
     </c:choose> 

<dv>
    <nav class="navbar navbar-default nav navbar-principal navbar-fixed-top" style="position:relative !important;">
        <div class="container-fluid">
            <div class="navbar-header logo">
                <div class="navbar-header">
                   
                    <a class=" nav navbar-brand active" href="ProcessaCliente">Sae Ingressos </a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="cadcliente"><a  href="Home.jsp"><i class="fa fa-fw fa-bars "></i>Home</a></li> 
                    <li class="cadcliente"><a  href="ProcessaCliente"><i class="fa fa-fw fa-group"></i>Cliente</a></li> 
                    
                    <li class="cadusuario"><a href="ProcessaEspetaculo"><i class="fa fa-fw fa-asterisk"></i>Espetaculo</a></li>
                 
                </ul>
            </div>
            <div class="collapse navbar-collapse " id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right  ">
                    <li class="cadusuario  "><a><i class="fa fa-fw fa-user orange"></i>${Usuario.login}</a></li>
                    <li class="cadusuario "><a href="ProcessaLogout" ><i class="fa fa-fw fa-sign-out orange "></i></a></li>
                </ul>
            </div>
        </div>
    </nav>
        
     
</dv>

<script type="text/javascript">
        $(document).ready(function () {
            carregaMaster();
            
            $(".js-example-basic-single").select2();
            
            $("table").dataTable({
               
                responsive: true,
                "bJQueryUI": true,
                "bProcessing": true,
                "bScrollInfinite": false,
                "bScrollCollapse": true,
                "pageLength": 10,
                "iTabIndex": -1,
                                "aaSorting": [],
                "language": {
                  "sEmptyTable": "Nenhum registro encontrado",
    "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
    "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
    "sInfoFiltered": "(Filtrados de _MAX_ registros)",
    "sInfoPostFix": "",
    "sInfoThousands": ".",
    "sLengthMenu": "_MENU_ resultados por página",
    "sLoadingRecords": "Carregando...",
    "sProcessing": "Processando...",
    "sZeroRecords": "Nenhum registro encontrado",
    "sSearch": "Pesquisar",
    "oPaginate": {
        "sNext": "Próximo",
        "sPrevious":"Anterior",
        "sFirst":"Primeiro",
        "sLast":"Último"
    },
    "oAria": {
        "sSortAscending": ": Ordenar colunas de forma ascendente",
        "sSortDescending": ": Ordenar colunas de forma descendente"
    }
                },
                "aoColumnDefs" : [{ "sClass": "rightTableCell", "aTargets": [] }],
                "bLengthChange": false,
            });
            
        });

        function carregaMaster() {
         $(".telefone").mask("(99)9999-9999");
          $(".celular").mask("(99)99999-9999");
           $(".cep").mask("99999-999");
           $(".cpfmask").mask("999.999.999-99");
           $(".cnpjmask").mask("99.999.999/9999-99");
            $(".intmask").mask("9999999999");
             $(".decimal").mask("99999999,99");
             $('.number').number( true, 2,);
        
            
            

            $(".dtmask").datepicker({
                dateFormat: 'dd/mm/yy',
                dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
                dayNamesMin: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D'],
                dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb', 'Dom'],
                monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
                monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
                nextText: 'Próximo',
                prevText: 'Anterior'
            });
        }   
        
       

</script>