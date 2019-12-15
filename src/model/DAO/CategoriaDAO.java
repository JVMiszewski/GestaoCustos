
package model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.BEAN.Categoria;

public class CategoriaDAO {
    
    public List<Categoria> read(){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Categoria> categorias = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT nome, idCategoria FROM categoria;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Categoria categoria = new Categoria();
                
                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNome(rs.getString("nome"));
                
                categorias.add(categoria);
                
            }
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao consultar Categorias: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return categorias;
    
    }
    
    public List<Categoria> readWhere(String nome){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Categoria> categorias = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT nome, idCategoria FROM categoria WHERE nome like '%"+ nome + "%';");
            System.out.println(stmt);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Categoria categoria = new Categoria();
                
                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNome(rs.getString("nome"));
                
                categorias.add(categoria);
                
            }
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao consultar categorias: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return categorias;
    
    }
    
    public List<Categoria> readWhere(int id){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Categoria> categorias = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT nome, idCategoria FROM categoria WHERE idCategoria like '%"+ id + "%';");
            rs = stmt.executeQuery();
            
            System.out.println(stmt);
            
            while(rs.next()){
                
                Categoria categoria = new Categoria();
                
                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNome(rs.getString("nome"));
                
                categorias.add(categoria);
                
            }
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao consultar categorias: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return categorias;
    
    }
    
    public void create(Categoria c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("insert into categoria (nome) values (?);");
            
            stmt.setString(1, c.getNome());
                       
            System.out.println(stmt);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }
    
    public void delete(Categoria c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("DELETE FROM categoria WHERE idCategoria = ?");
            
            stmt.setInt(1, c.getId());
            
            System.out.println(stmt);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Não é possível excluir uma ferramenta que está sendo usada em algum processo");
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }
    
    public void update(Categoria c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("UPDATE categoria SET nome=? WHERE idCategoria = ?;");
 
            stmt.setString(1, c.getNome());
           
            stmt.setInt(2, c.getId());
            
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
