
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
import model.BEAN.FichaTecnica;

public class FichaTecnicaDAO {
    
    public void create(FichaTecnica ft){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("insert into fichaTecnica (nome, idCategoria) values (?, ?);");
            
            stmt.setString(1, ft.getNome());
            stmt.setInt(2, ft.getCategoria().getId());
                       
            System.out.println(stmt);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }
    
    public List<FichaTecnica> readMAX() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<FichaTecnica> fichasTecnicas = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT MAX(fichaTecnica.idFichaTecnica) FROM fichaTecnica;");

            rs = stmt.executeQuery();

            while (rs.next()) {

                FichaTecnica fichaTecnica = new FichaTecnica();
                fichaTecnica.setIdFichaTecnica(rs.getInt("MAX(fichaTecnica.idFichaTecnica)"));

                fichasTecnicas.add(fichaTecnica);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar Fichas Técnicas: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return fichasTecnicas;

    }
    
    public List<FichaTecnica> read(){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<FichaTecnica> fichasTecnicas = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("select fichaTecnica.idFichaTecnica, fichaTecnica.nome, fichaTecnica.preco, fichaTecnica.custo, \n" +
"fichaTecnica.idCategoria, categoria.nome AS nomeC from fichaTecnica\n" +
"Inner join categoria on fichaTecnica.idCategoria = categoria.idCategoria;");
            
            rs = stmt.executeQuery();
            
            
            while(rs.next()){
                
                FichaTecnica fichaTecnica = new FichaTecnica();
                
                fichaTecnica.setIdFichaTecnica(rs.getInt("idFichaTecnica"));
                fichaTecnica.setNome(rs.getString("nome"));
                fichaTecnica.setPreco(rs.getDouble("preco"));
                fichaTecnica.setCusto(rs.getDouble("custo"));
                
                Categoria categoria = new Categoria();
                
                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNome(rs.getString("nomeC"));
                
                fichaTecnica.setCategoria(categoria);
                        
                fichasTecnicas.add(fichaTecnica);
                
            }
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao consultar Fichas Técnicas 1: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return fichasTecnicas;
    
    }
    
    public List<FichaTecnica> readID(int id){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<FichaTecnica> fichasTecnicas = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("select idFichaTecnica, custo, nome from fichaTecnica where idFichaTecnica = " + id + ";");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                FichaTecnica fichaTecnica = new FichaTecnica();
                
                fichaTecnica.setIdFichaTecnica(rs.getInt("idFichaTecnica"));
                fichaTecnica.setCusto(rs.getDouble("custo"));
                fichaTecnica.setNome(rs.getString("nome"));
                
                fichasTecnicas.add(fichaTecnica);
                
            }
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao consultar custo da ficha técnica: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return fichasTecnicas;
    
    }
    
    public List<FichaTecnica> readWhere(String nome){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<FichaTecnica> fichasTecnicas = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("select fichaTecnica.idFichaTecnica, fichaTecnica.nome, fichaTecnica.preco, fichaTecnica.custo, \n" +
"fichaTecnica.idCategoria, categoria.nome AS nomeC from fichaTecnica\n" +
"Inner join categoria on fichaTecnica.idCategoria = categoria.idCategoria where fichaTecnica.nome like '%" + nome + "%';");
            
            rs = stmt.executeQuery();
            
            
            while(rs.next()){
                
                FichaTecnica fichaTecnica = new FichaTecnica();
                
                fichaTecnica.setIdFichaTecnica(rs.getInt("idFichaTecnica"));
                fichaTecnica.setNome(rs.getString("nome"));
                fichaTecnica.setPreco(rs.getDouble("preco"));
                fichaTecnica.setCusto(rs.getDouble("custo"));
                        
                Categoria categoria = new Categoria();
                
                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNome(rs.getString("nomeC"));
                
                fichaTecnica.setCategoria(categoria);
                        
                fichasTecnicas.add(fichaTecnica);
                
            }
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao consultar Fichas Técnicas: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return fichasTecnicas;
    
    }
    
    public void update(FichaTecnica ft){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("UPDATE fichaTecnica SET nome=?, idCategoria=? WHERE idFichaTecnica = ?;");

            stmt.setString(1, ft.getNome());
            stmt.setInt(2, ft.getCategoria().getId());
           
            stmt.setInt(3, ft.getIdFichaTecnica());
            
            System.out.println(stmt);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }
    
    public void updateCusto(FichaTecnica ft){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("UPDATE fichaTecnica SET custo=? WHERE idFichaTecnica = ?;");

            stmt.setDouble(1, ft.getCusto());
           
            stmt.setInt(2, ft.getIdFichaTecnica());
            
            System.out.println(stmt);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }
    
    public void delete(FichaTecnica ft){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("DELETE FROM fichaTecnica WHERE idFichaTecnica = ?");
            
            stmt.setInt(1,ft.getIdFichaTecnica());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }
       
}
