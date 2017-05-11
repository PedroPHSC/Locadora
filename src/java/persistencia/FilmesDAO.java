package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import modelo.Filmes;
import modelo.Usuario;

public class FilmesDAO {

    private Connection conexao;

    public FilmesDAO() {
        conexao = ConnectionFactory.getConnection();
    }

    public boolean inserirFilmes(Filmes f) {

        boolean resultado = false;

        String sql = "INSERT INTO filmes (titulo, codGenero, sinopse, diretor, anoLancamento, status, usuarioCadastro, datahoraCadastro)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conexao.setAutoCommit(false);
            
            PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, f.getTitulo());
            stmt.setInt(2, f.getCodGenero());
            stmt.setString(3, f.getSinopse());
            stmt.setString(4, f.getDiretor());
            stmt.setInt(5, f.getAnoLancamento());
            stmt.setString(6, f.getStatus());
            stmt.setString(7, f.getUsuarioCadastro());
            Timestamp dataAux = new Timestamp(f.getDatahoraCadastro().getTime());
            stmt.setTimestamp(8, dataAux);
            
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();

            // Busca a chave gerada (id)
            if (rs.next()) {
                f.setCodigo(rs.getInt(1));
            } 

            conexao.commit();
            resultado = true;
            
            
        } catch (SQLException ex) {
            try {
                conexao.rollback();
            } catch (SQLException ex1) {
               JOptionPane.showMessageDialog(null,"Erro ao reverter a operação - " + ex1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null,"Erro ao inserir o cliente - " + ex.getMessage());
        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Erro ao fechar conexão - " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return resultado;
    }
}
