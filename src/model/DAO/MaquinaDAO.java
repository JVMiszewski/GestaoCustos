
package model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.BEAN.Maquina;

public class MaquinaDAO {
    
    public List<Maquina> read(){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Maquina> maquinas = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT idMaquina, nome, descricao FROM maquina;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Maquina maquina = new Maquina();
                
                maquina.setIdMaquina(rs.getInt("idMaquina"));
                maquina.setDescricao(rs.getString("descricao"));
                maquina.setNome(rs.getString("nome"));
                
                maquinas.add(maquina);
            }
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao consultar Maquinas: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return maquinas;
    
    }
    
    public List<Maquina> readWhere(String nome){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Maquina> maquinas = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT idMaquina, nome, descricao FROM maquina where nome like '%" + nome + "%';" );
            System.out.print(stmt);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Maquina maquina = new Maquina();
                
                maquina.setIdMaquina(rs.getInt("idMaquina"));
                maquina.setDescricao(rs.getString("descricao"));
                maquina.setNome(rs.getString("nome"));
                
                maquinas.add(maquina);
            }
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao consultar Maquinas Where: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return maquinas;
    
    }
    
    public List<Maquina> readWhere(int id){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Maquina> maquinas = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT idMaquina, nome, descricao FROM maquina where idMaquina like '%" + id + "%';" );
            System.out.print(stmt);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Maquina maquina = new Maquina();
                
                maquina.setIdMaquina(rs.getInt("idMaquina"));
                maquina.setDescricao(rs.getString("descricao"));
                maquina.setNome(rs.getString("nome"));
                
                maquinas.add(maquina);
            }
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao consultar Maquinas Where: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return maquinas;
    
    }
    
    public void create(Maquina m){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("insert into maquina (nome, descricao) values (?, ?);");
            
            stmt.setString(1, m.getNome());
            stmt.setString(2, m.getDescricao());
                       
            System.out.println(stmt);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }
    
    public void delete(Maquina m){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("DELETE FROM maquina WHERE idMaquina = ?");
            
            stmt.setInt(1, m.getIdMaquina());
            
            System.out.println(stmt);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Não é possível excluir uma máquina que está sendo usada em algum processo");
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }
    
    public void update(Maquina m){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("UPDATE maquina SET nome=?, descricao=? WHERE idMaquina = ?;");
            
            
            
            stmt.setString(1, m.getNome());
            stmt.setString(2, m.getDescricao());
           
            stmt.setInt(3, m.getIdMaquina());
            
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
