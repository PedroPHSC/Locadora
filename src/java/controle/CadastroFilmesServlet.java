/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Filmes;
import modelo.Genero;
import modelo.Usuario;
import persistencia.FilmesDAO;
import utilidades.PersonalizarMsgErro;

/**
 *
 * @author sala308b
 */
@WebServlet(name = "CadastroFilmesServlet", urlPatterns = {"/CadastroFilmes"})
public class CadastroFilmesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String msgErro = "";
        
        String titulo = request.getParameter("txtTitulo");
        String codGenero = request.getParameter("Genero");
        String sinopse = request.getParameter("txtSinopse");
        String diretor = request.getParameter("txtDiretor");
        String anoLancamentoAux = request.getParameter("txtAnoLancamento");
        String status = request.getParameter("Status");
        
        String diretorAux = diretor.replace(" ", "");
        
        if(titulo.isEmpty()){
            msgErro = "Por favor digite o nome do filme";
        }else if(titulo.trim().length() < 3){
            msgErro = "Título não pode ser menor que 3 caracteres";
        }else if(codGenero.equals("Select")){
            msgErro = "Um filme não pode ser cadastrado sem um Gênero";
        }else if(sinopse.equals("")){
            msgErro = "Por favor digite a sinopse do filme";
        }else if(diretor.equals("")){
            msgErro = "Por favor indique o nome do diretor";
        }else if(diretorAux.length() < 5){
            msgErro = "Não é permitido nome menor que 5 caracteres";
        }else{
        Genero g = new Genero(Integer.parseInt(codGenero));
        Usuario u = (Usuario) request.getSession().getAttribute("usuarioAutenticado");
        
        int anoLancamento = Integer.parseInt(anoLancamentoAux);
        
        Filmes f = new Filmes();
        f.setTitulo(titulo);
        f.setGenero(g);
        f.setSinopse(sinopse);
        f.setDiretor(diretor);
        f.setAnoLancamento(anoLancamento);
        f.setStatus(status);
        f.setUsuarioCadastro(u);
        f.setDatahoraCadastro(new Date());
        
        try{
            FilmesDAO filmesDao = new FilmesDAO();
            filmesDao.inserirFilmes(f);
            response.sendRedirect("PainelUsuario.jsp");
        }catch (Exception e){
            msgErro = PersonalizarMsgErro.getMensagem(e.getMessage());
        }
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Algo inesperado aconteceu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Ocorreu um erro: " + msgErro + "</h2>");
            out.println("<a href=\"javascript:history.back()\">Voltar</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
