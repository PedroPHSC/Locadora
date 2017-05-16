<%-- 
    Document   : TelaInicial
    Created on : 16/05/2017, 09:21:15
    Author     : sala308b
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login de Usuários</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>       
        <h2>Locadora xFilmes</h2>
        <hr>
        <div>${msgErro}</div><br>
        <form action="Autenticar">
        <label>Login: </label>
        <input type="text" name="txtLogin"><br><br>
        <label>Senha: </label>
        <input type="password" name="txtSenha"><br><br>
        <input type="submit" value="Entrar" name="btEntrar"/>
        <input type="reset" value="Limpar" name="btLimpar" />
        </form>
        <hr>        
    </body>
</html>
