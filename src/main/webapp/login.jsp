
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <%@include file="WEB-INF/vista/estilos.jspf" %>
    </head>
    <body>
        <%@include file="WEB-INF/vista/cabecera.jspf" %>
        <%@include file="WEB-INF/vista/menu.jspf" %>
        
        <div class="container">
            <div class="row">
                <div class="col">
                    <p>Introduce los datos de Acceso</p>
                    <div class="col">${ requestScope.msgErrorLogin }</div>
                </div>
            </div>
            <form action="login" method="post">
                <div class="form-group">
                    <label for="email">Email address</label>
                    <input type="email" class="form-control" name="email"
                           id="email" placeholder="Introduce  email">
                </div>
                <div class="col">${ requestScope.msgErrorEmail }</div>
                <div class="form-group">
                    <label for="pass">Password</label>
                    <input type="password" class="form-control" name="pass"
                           id="pass" placeholder="Password">
                </div>
                <div class="btn-group" role="group">
                    <div class="col">${ requestScope.msgErrorPass }</div>
                    </br>
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
        </div>
    </body>
</html>