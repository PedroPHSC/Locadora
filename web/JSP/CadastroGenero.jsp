<%-- 
    Document   : CadastroGenero
    Created on : 12/05/2017, 08:11:50
    Author     : sala308b
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Gêneros</title>
    </head>
    <body>
        <h1>Cadastrar Gêneros</h1>
        <hr>
        <a href="javascript:history.back()">Voltar</a><br><br>
        <form action="../CadastroGenero">
            <label>Nome:</label><br>
            <input type="text" minlength="4" name="txtNome"><br>
            <label>Descrição:</label><br>
            <input type="text" name="txtDescricao"><br><br>
            <input type="submit" value="Cadastrar"><br>
        </form>
    </body>
</html>
