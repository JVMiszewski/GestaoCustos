
package model.CONF;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ConfiguracoesDAO {
    
    public List<Configuracoes> read(){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Configuracoes> configuracoes = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT idConf, pesquisa, casas FROM configuracoes;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Configuracoes configuracao = new Configuracoes();
                
                configuracao.setId(rs.getInt("idConf"));
                configuracao.setPesquisa(rs.getString("pesquisa"));
                configuracao.setCasas(rs.getInt("casas"));
                
                configuracoes.add(configuracao);
            }
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro nas configurações: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return configuracoes;
    
    }
        
    public void update(Configuracoes c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("UPDATE configuracoes SET pesquisa=?, casas=? WHERE idConf = ?;");
            
            stmt.setString(1, c.getPesquisa());
            stmt.setInt(2, c.getCasas());
           
            stmt.setInt(3, c.getId());
            
            System.out.println(stmt);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Configurações atualizadas com sucesso");
        
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Erro ao atualizar as configurações: " + ex);
        
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }   
        
}
