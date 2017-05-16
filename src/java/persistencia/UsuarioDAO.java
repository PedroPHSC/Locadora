package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Usuario;

public class UsuarioDAO {

    private Connection conexao;

    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        conexao = ConnectionFactory.getConnection();
    }

    public boolean inserirUsuario(Usuario u) {

        boolean resultado = false;

        String sql = "INSERT INTO usuarios (login, nome, senha, perfil, status)"
                + " VALUES (?, ?, ?, ?, ?)";

        try {
            conexao.setAutoCommit(false);
            
            PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getNome());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getPerfil());
            stmt.setString(5, u.getStatus());
            
            stmt.executeUpdate();

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
    public static Usuario buscar(String login, String senha) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement  preparedStatement = null;
        ResultSet rs = null;
        String SQL = "";
        Usuario u = null;
        
        // Obtem conexao com BD
        conn = ConnectionFactory.getConnection();
        
        // Comando SQL 
        SQL = "SELECT * FROM usuarios " +
                " WHERE login = ? AND senha = ?";

        preparedStatement = conn.prepareStatement(SQL);

        preparedStatement.setString(1, login);
        preparedStatement.setString(2, senha);
                
        // Para buscar informações
        rs = preparedStatement.executeQuery();   

        // Verifica se possui dados
        if (rs.next()) {
            
            u = new Usuario();
            
            u.setNome(rs.getString("nome"));
            u.setLogin(rs.getString("login"));
            u.setPerfil(rs.getString("perfil"));
            u.setStatus(rs.getString("status"));
            
         } 
        
        // Fechar conexao
        conn.close();
        
        return u;
    }
}
