
package model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.BEAN.Usuario;

public class UsuarioDAO {
    
    public List<Usuario> readWhere(String nome){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("select senha, nome, idUser from usuario where nome = ?;" );
            
            stmt.setString(1, nome);

            rs = stmt.executeQuery();
               
            while(rs.next()){
                
                Usuario usuario = new Usuario();
                
                usuario.setIdUsuario(rs.getInt("idUser"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
  
                usuarios.add(usuario);
                
            }
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Usuário não encontrado: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return usuarios;
    
    }
    
    public void create(Usuario u){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("insert into usuario(nome, senha) values (?, ?);");
            
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getSenha());
                       
            System.out.println(stmt);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuário Cadastrado!");
        
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }
    
}
