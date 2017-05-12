<%-- 
    Document   : CadastroFilmes
    Created on : 12/05/2017, 08:14:48
    Author     : sala308b
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Filmes</title>
    </head>
    <body>
        <h1>Cadastrar Produto</h1>
        <hr>
        <a href="javascript:history.back()">Voltar</a><br><br>
        <form action="ProdutoIncluir">
            <label>Título:</label><br>
            <input type="text" name="txtTitulo"><br>
            <label>Gênero</label><br>
            <input type="text" name="txtQtd"><br>
            <label>Sinopse:</label><br>
            <input type="text" name="txtSinopse"><br>
            <label>Diretor:</label><br>
            <input type="text" name="txtDiretor"><br>
            <label>Ano de Lançamento:</label><br>
            <input type="number" min="1895" max="3000" name="txtAnoLancamento"><br>
            <label>Status:</label><br>
            <input type="radio" name="Status" value="Ativo" checked="checked" />Ativo
            <input type="radio" name="Status" value="Inativo" />Inativo<br><br>
            <input type="submit" value="Cadastrar"><br>
        </form>
    </body>
</html>
