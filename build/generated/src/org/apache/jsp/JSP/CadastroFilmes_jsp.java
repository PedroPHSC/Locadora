package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CadastroFilmes_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cadastro de Filmes</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Cadastrar Produto</h1>\n");
      out.write("        <hr>\n");
      out.write("        <a href=\"javascript:history.back()\">Voltar</a><br><br>\n");
      out.write("        <form action=\"ProdutoIncluir\">\n");
      out.write("            <label>Título:</label><br>\n");
      out.write("            <input type=\"text\" name=\"txtTitulo\"><br>\n");
      out.write("            <label>Gênero</label><br>\n");
      out.write("            <input type=\"text\" name=\"txtQtd\"><br>\n");
      out.write("            <label>Sinopse:</label><br>\n");
      out.write("            <input type=\"text\" name=\"txtSinopse\"><br>\n");
      out.write("            <label>Diretor:</label><br>\n");
      out.write("            <input type=\"text\" name=\"txtDiretor\"><br>\n");
      out.write("            <label>Ano de Lançamento:</label><br>\n");
      out.write("            <input type=\"number\" name=\"txtAnoLancamento\"><br>\n");
      out.write("            <label>Status:</label><br>\n");
      out.write("            <input type=\"radio\" name=\"Status\" value=\"Ativo\" checked=\"checked\" />Ativo\n");
      out.write("            <input type=\"radio\" name=\"Status\" value=\"Inativo\" />Inativo<br><br>\n");
      out.write("            <label>Usuário que cadastrou:</label><br>\n");
      out.write("            <input type=\"text\" name=\"txtUsuarioCadastro\"><br>\n");
      out.write("            <label>Data e hora do cadastro:</label><br>\n");
      out.write("            <input type=\"datetime\" name=\"txtDataHora\"><br>\n");
      out.write("            <label>Gênero</label><br>\n");
      out.write("            <input type=\"text\" name=\"txtQtd\"><br>\n");
      out.write("            <label>Sinopse:</label><br><br>\n");
      out.write("            <input type=\"submit\" value=\"Cadastrar\"><br>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}