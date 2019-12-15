package model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.BEAN.Material;
import model.BEAN.MaterialUsado;

public class MaterialUsadoDAO {

    public List<MaterialUsado> readP(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<MaterialUsado> materiaisUsados = new ArrayList<>();

        try {

            stmt = con.prepareStatement("select materialUsado.idMaterialUsado, material.nomeM, material.precoM, "
                    + " materialUsado.preco, materialUsado.quantia from materialUsado\n"
                    + "inner join material on materialUsado.idMaterial = material.idMaterial\n"
                    + "where materialUsado.idFichaTecnica = ?;");

            stmt.setInt(1, id);

            System.out.println(stmt);

            rs = stmt.executeQuery();

            while (rs.next()) {

                MaterialUsado materialUsado = new MaterialUsado();

                materialUsado.setIdMaterialUsado(rs.getInt("idMaterialUsado"));
                materialUsado.setPreco(rs.getDouble("preco"));
                materialUsado.setQuantidade(rs.getInt("quantia"));

                Material material = new Material();

                material.setNomeM(rs.getString("nomeM"));
                material.setPrecoM(rs.getDouble("precoM"));

                materialUsado.setMaterial(material);

                materiaisUsados.add(materialUsado);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar materiais usados: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return materiaisUsados;

    }
    
    public List<MaterialUsado> readP(int id, String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<MaterialUsado> materiaisUsados = new ArrayList<>();

        try {

            stmt = con.prepareStatement("select materialUsado.idMaterialUsado, material.nomeM, material.precoM, "
                    + " materialUsado.preco, materialUsado.quantia from materialUsado\n"
                    + "inner join material on materialUsado.idMaterial = material.idMaterial\n"
                    + "where materialUsado.idFichaTecnica = ? and nomeM like '%" + nome + "%';");

            stmt.setInt(1, id);

            System.out.println(stmt);

            rs = stmt.executeQuery();

            while (rs.next()) {

                MaterialUsado materialUsado = new MaterialUsado();

                materialUsado.setIdMaterialUsado(rs.getInt("idMaterialUsado"));
                materialUsado.setPreco(rs.getDouble("preco"));
                materialUsado.setQuantidade(rs.getInt("quantia"));

                Material material = new Material();

                material.setNomeM(rs.getString("nomeM"));
                material.setPrecoM(rs.getDouble("precoM"));

                materialUsado.setMaterial(material);

                materiaisUsados.add(materialUsado);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar materiais usados: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return materiaisUsados;

    }
    
    public List<MaterialUsado> readP(int id, int cod) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<MaterialUsado> materiaisUsados = new ArrayList<>();

        try {

            stmt = con.prepareStatement("select materialUsado.idMaterialUsado, material.nomeM, material.precoM, "
                    + " materialUsado.preco, materialUsado.quantia from materialUsado\n"
                    + "inner join material on materialUsado.idMaterial = material.idMaterial\n"
                    + "where materialUsado.idFichaTecnica = ? and materialUsado.idmaterialUsado like '%" + cod + "%';");

            stmt.setInt(1, id);

            System.out.println(stmt);

            rs = stmt.executeQuery();

            while (rs.next()) {

                MaterialUsado materialUsado = new MaterialUsado();

                materialUsado.setIdMaterialUsado(rs.getInt("idMaterialUsado"));
                materialUsado.setPreco(rs.getDouble("preco"));
                materialUsado.setQuantidade(rs.getInt("quantia"));

                Material material = new Material();

                material.setNomeM(rs.getString("nomeM"));
                material.setPrecoM(rs.getDouble("precoM"));

                materialUsado.setMaterial(material);

                materiaisUsados.add(materialUsado);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar materiais usados: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return materiaisUsados;

    }

    public void create(MaterialUsado mu) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("insert into materialUsado (idMaterial, idFichaTecnica, preco, quantia) values (?, ?, ?, ?) ;");

            stmt.setInt(1, mu.getMaterial().getIdMaterial());
            stmt.setInt(2, mu.getFichaTecnica().getIdFichaTecnica());
            stmt.setDouble(3, mu.getPreco());
            stmt.setInt(4, mu.getQuantidade());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public void delete(MaterialUsado mu) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("DELETE FROM materialUsado WHERE idMaterialUsado = ?");

            stmt.setInt(1, mu.getIdMaterialUsado());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }
    }
}
