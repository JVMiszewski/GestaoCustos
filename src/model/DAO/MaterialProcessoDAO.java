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

public class MaterialProcessoDAO {

    public List<MaterialProcesso> readP(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<MaterialProcesso> materiaisProcesso = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT materialProcesso.idMaterialProcesso, material.nomeM, material.descricaoM, processo.nomeP\n"
                    + "from materialProcesso\n"
                    + "Inner Join material ON materialProcesso.idMaterial = material.idMaterial\n"
                    + "Inner Join processo ON materialProcesso.idProcesso = processo.idProcesso\n"
                    + "WHERE materialProcesso.idProcesso = ?;");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {

                MaterialProcesso mp = new MaterialProcesso();

                mp.setIdMaterialProcesso(rs.getInt("idMaterialProcesso"));

                Material m = new Material();

                m.setNomeM(rs.getString("nomeM"));
                m.setDescricaoM(rs.getString("descricaoM"));

                mp.setMaterial(m);

                Processo p = new Processo();

                p.setNomeP(rs.getString("nomeP"));

                mp.setProcesso(p);

                materiaisProcesso.add(mp);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar materiais dos processos: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return materiaisProcesso;

    }

    public List<MaterialProcesso> readWhere(int id, String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<MaterialProcesso> materiaisProcesso = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT materialProcesso.idMaterialProcesso, material.nomeM, material.descricaoM, processo.nomeP\n"
                    + "from materialProcesso\n"
                    + "Inner Join material ON materialProcesso.idMaterial = material.idMaterial\n"
                    + "Inner Join processo ON materialProcesso.idProcesso = processo.idProcesso\n"
                    + "WHERE materialProcesso.idProcesso = ? and material.nomeM like '%" + nome + "%';");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {

                MaterialProcesso mp = new MaterialProcesso();

                mp.setIdMaterialProcesso(rs.getInt("idMaterialProcesso"));

                Material m = new Material();

                m.setNomeM(rs.getString("nomeM"));
                m.setDescricaoM(rs.getString("descricaoM"));

                mp.setMaterial(m);

                Processo p = new Processo();

                p.setNomeP(rs.getString("nomeP"));

                mp.setProcesso(p);

                materiaisProcesso.add(mp);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar materiais dos processos: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return materiaisProcesso;

    }
    
    public List<MaterialProcesso> readWhere(int id, int cod) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<MaterialProcesso> materiaisProcesso = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT materialProcesso.idMaterialProcesso, material.nomeM, material.descricaoM, processo.nomeP\n"
                    + "from materialProcesso\n"
                    + "Inner Join material ON materialProcesso.idMaterial = material.idMaterial\n"
                    + "Inner Join processo ON materialProcesso.idProcesso = processo.idProcesso\n"
                    + "WHERE materialProcesso.idProcesso = ? and materialProcesso.idMaterialProcesso like '%" + cod + "%';");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {

                MaterialProcesso mp = new MaterialProcesso();

                mp.setIdMaterialProcesso(rs.getInt("idMaterialProcesso"));

                Material m = new Material();

                m.setNomeM(rs.getString("nomeM"));
                m.setDescricaoM(rs.getString("descricaoM"));

                mp.setMaterial(m);

                Processo p = new Processo();

                p.setNomeP(rs.getString("nomeP"));

                mp.setProcesso(p);

                materiaisProcesso.add(mp);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar materiais dos processos: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return materiaisProcesso;

    }

    public void create(MaterialProcesso mp) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("insert into materialProcesso(idMaterial, idProcesso) values (?, ?);");

            stmt.setInt(1, mp.getMaterial().getIdMaterial());
            stmt.setInt(2, mp.getProcesso().getIdProcesso());

            System.out.println(stmt);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public void delete(MaterialProcesso m) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("DELETE FROM materialProcesso WHERE idMaterialProcesso = ?");

            stmt.setInt(1, m.getIdMaterialProcesso());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }
    }

}
