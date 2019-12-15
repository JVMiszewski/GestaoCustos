
package model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.BEAN.Ferramenta;

public class FerramentaDAO {
    
    public List<Ferramenta> read(){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Ferramenta> ferramentas = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT idFerramenta, nome, descricao FROM ferramenta;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Ferramenta ferramenta = new Ferramenta();
                
                ferramenta.setIdFerramenta(rs.getInt("idFerramenta"));
                ferramenta.setDescricao(rs.getString("descricao"));
                ferramenta.setNome(rs.getString("nome"));
                
                ferramentas.add(ferramenta);
            }
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao consultar Ferramentas: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return ferramentas;
    
    }
    
    public List<Ferramenta> readWhere(String nome){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Ferramenta> ferramentas = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT idFerramenta, nome, descricao FROM ferramenta where nome like '%" + nome + "%';" );
            System.out.print(stmt);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Ferramenta ferramenta = new Ferramenta();
                
                ferramenta.setIdFerramenta(rs.getInt("idFerramenta"));
                ferramenta.setDescricao(rs.getString("descricao"));
                ferramenta.setNome(rs.getString("nome"));
                
                ferramentas.add(ferramenta);
            }
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao consultar Ferramentas Where: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return ferramentas;
    
    }
    
    public List<Ferramenta> readWhere(int id){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Ferramenta> ferramentas = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT idFerramenta, nome, descricao FROM ferramenta where idFerramenta like '%" + id + "%';" );
            System.out.print(stmt);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Ferramenta ferramenta = new Ferramenta();
                
                ferramenta.setIdFerramenta(rs.getInt("idFerramenta"));
                ferramenta.setDescricao(rs.getString("descricao"));
                ferramenta.setNome(rs.getString("nome"));
                
                ferramentas.add(ferramenta);
            }
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao consultar Ferramentas Where: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return ferramentas;
    
    }
    
    public void create(Ferramenta f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("insert into ferramenta (nome, descricao) values (?, ?);");
            
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getDescricao());
                       
            System.out.println(stmt);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }
    
    public void delete(Ferramenta f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("DELETE FROM ferramenta WHERE idFerramenta = ?");
            
            stmt.setInt(1, f.getIdFerramenta());
            
            System.out.println(stmt);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Não é possível excluir uma ferramenta que está sendo usada em algum processo");
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }
    
    public void update(Ferramenta f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("UPDATE ferramenta SET nome=?, descricao=? WHERE idFerramenta = ?;");
            
            
            
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getDescricao());
           
            stmt.setInt(3, f.getIdFerramenta());
            
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
