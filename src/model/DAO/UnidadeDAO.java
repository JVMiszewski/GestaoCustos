
package model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.BEAN.Unidade;

public class UnidadeDAO {
    
    public List<Unidade> read(){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Unidade> unidades = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT nome, idUnidade, descricao FROM unidade;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Unidade unidade = new Unidade();
                
                unidade.setId(rs.getInt("idUnidade"));
                unidade.setNome(rs.getString("nome"));
                unidade.setDescricao(rs.getString("descricao"));
                
                unidades.add(unidade);
                
            }
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao consultar Unidade: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return unidades;
    
    }
    
    public List<Unidade> readWhere(String nome){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Unidade> unidades = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT nome, idUnidade, descricao FROM unidade WHERE nome like '%"+ nome + "%';");
            System.out.println(stmt);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Unidade unidade = new Unidade();
                
                unidade.setId(rs.getInt("idUnidade"));
                unidade.setNome(rs.getString("nome"));
                unidade.setDescricao(rs.getString("descricao"));
                
                unidades.add(unidade);
                
            }
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao consultar unidades: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return unidades;
    
    }
    
    public List<Unidade> readWhere(int id){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Unidade> unidades = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT nome, idUnidade, descricao FROM unidade WHERE idUnidade like '%"+ id + "%';");
            System.out.println(stmt);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Unidade unidade = new Unidade();
                
                unidade.setId(rs.getInt("idUnidade"));
                unidade.setNome(rs.getString("nome"));
                unidade.setDescricao(rs.getString("descricao"));
                
                unidades.add(unidade);
                
            }
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao consultar unidades: " + ex);
                    
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return unidades;
    
    }
    
    public void create(Unidade u){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("insert into unidade (nome, descricao) values (?, ?);");
            
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getDescricao());
                       
            System.out.println(stmt);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }
    
    public void delete(Unidade u){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("DELETE FROM unidade WHERE idUnidade = ?");
            
            stmt.setInt(1, u.getId());
            
            System.out.println(stmt);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Não é possível excluir algo que faz parte de outra classe.");
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }
    
    public void update(Unidade u){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("UPDATE unidade SET nome=?, descricao=? WHERE idUnidade = ?;");
 
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getDescricao());
           
            stmt.setInt(3, u.getId());
            
            System.out.println(stmt);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }
    
}
