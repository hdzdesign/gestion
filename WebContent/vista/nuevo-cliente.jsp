<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="css/bootstrap.min.css">   		
        <script src="js/bootstrap.min.js"></script>     
    </head>
    <body>
        <div class="container">
            <form action="clienteController?action=register" method="post"  role="form" data-toggle="validator" >
                <c:if test ="${empty action}">                        	
                    <c:set var="action" value="guardar"/>
                </c:if>
                <input type="hidden" id="action" name="action" value="${action}">
                <input type="hidden" id="idCliente" name="idCliente" value="${cliente.id}">
                <h2>Cliente</h2>
                <div class="form-group">
                    <label for="nombre" class="control-label col-xs-4">Nombre:</label>
                    <input type="text" name="nombre" id="nombre" class="form-control" value="${cliente.nombre}" required="true" />                                   

                    <label for="apellidos" class="control-label col-xs-4">Apellidos:</label>                   
                    <input type="text" name="apellidos" id="apellido" class="form-control" value="${cliente.apellidos}" required="true"/> 

                    <label for="fnacimiento" class="control-label col-xs-4">Fecha de Nacimiento</label>                 
                    <input type="text"  pattern="^\d{2}-\d{2}-\d{4}$" name="fnacimiento" id="fnacimiento" class="form-control" value="${cliente.fechaNacimiento}" maxlength="10" placeholder="dd-MM-yyy" required="true"/>

                    <label for="numerosocio" class="control-label col-xs-4">Numero de Socio:</label>                    
                    <input type="text" name="numerosocio" id="nsocio" class="form-control" value="${cliente.numeroSocio}" required="true"/> 

                    <label for="email" class="control-label col-xs-4">E-mail:</label>
                    <input type="email" name="email" id="email" class="form-control" value="${cliente.email}"  placeholder="Escriba su email" required="true"/>

                    <label for="telefono" class="control-label col-xs-4">telefono:</label>                   
                    <input type="text" name="telefono" id="telefono" class="form-control" value="${cliente.telefono}" required="true"/>

                    <br></br>
                    <button type="submit"  class="btn btn-primary">Guardar</button> 
                    <table>
                    <br></br>
                    <tr><td><a href="articuloController?action=index" class="btn btn-primary">VOLVER AL MENU</a></td></tr>
                    </table>
                </div>                                                      
            </form>
        </div>
    </body>
</html>