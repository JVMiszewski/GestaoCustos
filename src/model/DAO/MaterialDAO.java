package model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.BEAN.*;

public class MaterialDAO {

    public void create(Material m) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("INSERT INTO material (idCategoriaM, nomeM, descricaoM, idUnidade, precoM) VALUES (?, ?, ?, ?, ?)");

            stmt.setInt(1, m.getCategoria().getId());
            stmt.setString(2, m.getNomeM());
            stmt.setString(3, m.getDescricaoM());
            stmt.setInt(4, m.getUn().getId());
            stmt.setDouble(5, m.getPrecoM());

            System.out.println(stmt);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public List<Material> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Material> materiais = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT material.idMaterial, material.nomeM, material.descricaoM, material.idUnidade, material.precoM, categoria.idCategoria, \n"
                    + "categoria.nome AS nomeC, unidade.nome AS nomeU, unidade.idUnidade as idU FROM material \n"
                    + "INNER JOIN categoria ON categoria.idCategoria = material.idCategoriaM"
                    + " INNER JOIN unidade ON unidade.idUnidade = material.idUnidade;");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Material material = new Material();

                material.setIdMaterial(rs.getInt("idMaterial"));;
                material.setNomeM(rs.getString("nomeM"));
                material.setDescricaoM(rs.getString("descricaoM"));
                material.setPrecoM(rs.getDouble("precoM"));

                Categoria categoria = new Categoria();

                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNome(rs.getString("nomeC"));
                
                Unidade unidade = new Unidade();
                
                unidade.setId(rs.getInt("idU"));
                unidade.setNome(rs.getString("nomeU"));

                material.setCategoria(categoria);
                material.setUn(unidade);

                materiais.add(material);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar materiais: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return materiais;

    }

    public List<Material> readWhere(String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Material> materiais = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT material.idMaterial, material.nomeM, material.descricaoM, material.idUnidade, material.precoM, categoria.idCategoria, \n"
                    + "categoria.nome AS nomeC, unidade.nome AS nomeU, unidade.idUnidade as idU FROM material \n"
                    + "INNER JOIN categoria ON categoria.idCategoria = material.idCategoriaM "
                    + "INNER JOIN unidade ON unidade.idUnidade = material.idUnidade "
                    + "where nomeM like '%" + nome + "%';");
            
            System.out.print(stmt);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Material material = new Material();

                material.setIdMaterial(rs.getInt("idMaterial"));;
                material.setNomeM(rs.getString("nomeM"));
                material.setDescricaoM(rs.getString("descricaoM"));
                material.setPrecoM(rs.getDouble("precoM"));

                Categoria categoria = new Categoria();

                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNome(rs.getString("nomeC"));
                
                Unidade unidade = new Unidade();
                
                unidade.setId(rs.getInt("idU"));
                unidade.setNome(rs.getString("nomeU"));

                material.setUn(unidade);
                material.setCategoria(categoria);

                materiais.add(material);
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar Material Where: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return materiais;

    }
    
    public List<Material> readWhere(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Material> materiais = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT material.idMaterial, material.nomeM, material.descricaoM, material.idUnidade, material.precoM, categoria.idCategoria, \n"
                    + "categoria.nome AS nomeC, unidade.nome AS nomeU, unidade.idUnidade as idU FROM material \n"
                    + "INNER JOIN categoria ON categoria.idCategoria = material.idCategoriaM "
                    + "INNER JOIN unidade ON unidade.idUnidade = material.idUnidade "
                    + "where idMaterial like '%" + id + "%';");
            
            System.out.print(stmt);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Material material = new Material();

                material.setIdMaterial(rs.getInt("idMaterial"));
                material.setNomeM(rs.getString("nomeM"));
                material.setDescricaoM(rs.getString("descricaoM"));
                material.setPrecoM(rs.getDouble("precoM"));

                Categoria categoria = new Categoria();

                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNome(rs.getString("nomeC"));
                
                Unidade unidade = new Unidade();
                
                unidade.setId(rs.getInt("idU"));
                unidade.setNome(rs.getString("nomeU"));

                material.setUn(unidade);
                material.setCategoria(categoria);

                materiais.add(material);
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar Material Where: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return materiais;

    }

    public void update(Material m) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("UPDATE material SET idCategoriaM=?, nomeM=?, descricaoM=?, idUnidade=?, precoM=? WHERE idMaterial = ?;");

            stmt.setInt(1, m.getCategoria().getId());
            stmt.setString(2, m.getNomeM());
            stmt.setString(3, m.getDescricaoM());
            stmt.setInt(4, m.getUn().getId());
            stmt.setDouble(5, m.getPrecoM());

            stmt.setInt(6, m.getIdMaterial());

            System.out.println(stmt);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public void delete(Material m) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("DELETE FROM material WHERE idMaterial = ?");

            stmt.setInt(1, m.getIdMaterial());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }
    }

}
