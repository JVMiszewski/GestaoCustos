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

public class MaquinaProcessoDAO {

    public List<MaquinaProcesso> readP(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<MaquinaProcesso> maquinasProcesso = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT maquinaProcesso.idMaquinaProcesso, maquinaProcesso.idMaquina AS idM, maquinaProcesso.idProcesso,\n"
                    + "maquina.nome, maquina.descricao, processo.idProcesso, processo.nomeP\n"
                    + "from maquinaProcesso\n"
                    + "Inner Join maquina ON maquinaProcesso.idMaquina = maquina.idMaquina \n"
                    + "Inner Join processo ON maquinaProcesso.idProcesso = processo.idProcesso\n"
                    + "WHERE maquinaProcesso.idProcesso = ?;");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {

                MaquinaProcesso mp = new MaquinaProcesso();

                mp.setIdMaquinaProcesso(rs.getInt("idMaquinaProcesso"));

                Maquina m = new Maquina();

                m.setIdMaquina(rs.getInt("idM"));
                m.setDescricao(rs.getString("descricao"));
                m.setNome(rs.getString("nome"));

                mp.setMaquina(m);

                Processo p = new Processo();

                p.setIdProcesso(rs.getInt("idProcesso"));
                p.setNomeP(rs.getString("nomeP"));

                mp.setProcesso(p);

                maquinasProcesso.add(mp);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar maquinas dos processos: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return maquinasProcesso;

    }

    public List<MaquinaProcesso> readWhere(int id, String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<MaquinaProcesso> maquinasProcesso = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT maquinaProcesso.idMaquinaProcesso, maquinaProcesso.idMaquina AS idM, maquinaProcesso.idProcesso,\n"
                    + "maquina.nome, maquina.descricao, processo.idProcesso, processo.nomeP\n"
                    + "from maquinaProcesso\n"
                    + "Inner Join maquina ON maquinaProcesso.idMaquina = maquina.idMaquina \n"
                    + "Inner Join processo ON maquinaProcesso.idProcesso = processo.idProcesso\n"
                    + "WHERE maquinaProcesso.idProcesso = ? and maquina.nome like '%" + nome + "%';");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {

                MaquinaProcesso mp = new MaquinaProcesso();

                mp.setIdMaquinaProcesso(rs.getInt("idMaquinaProcesso"));

                Maquina m = new Maquina();

                m.setIdMaquina(rs.getInt("idM"));
                m.setDescricao(rs.getString("descricao"));
                m.setNome(rs.getString("nome"));

                mp.setMaquina(m);

                Processo p = new Processo();

                p.setIdProcesso(rs.getInt("idProcesso"));
                p.setNomeP(rs.getString("nomeP"));

                mp.setProcesso(p);

                maquinasProcesso.add(mp);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar maquinas dos processos: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return maquinasProcesso;

    }
    
    public List<MaquinaProcesso> readWhere(int id, int cod) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<MaquinaProcesso> maquinasProcesso = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT maquinaProcesso.idMaquinaProcesso, maquinaProcesso.idMaquina AS idM, maquinaProcesso.idProcesso,\n"
                    + "maquina.nome, maquina.descricao, processo.idProcesso, processo.nomeP\n"
                    + "from maquinaProcesso\n"
                    + "Inner Join maquina ON maquinaProcesso.idMaquina = maquina.idMaquina \n"
                    + "Inner Join processo ON maquinaProcesso.idProcesso = processo.idProcesso\n"
                    + "WHERE maquinaProcesso.idProcesso = ? and maquinaProcesso.idMaquinaProcesso like '%" + cod + "%';");

            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                MaquinaProcesso mp = new MaquinaProcesso();

                mp.setIdMaquinaProcesso(rs.getInt("idMaquinaProcesso"));

                Maquina m = new Maquina();

                m.setIdMaquina(rs.getInt("idM"));
                m.setDescricao(rs.getString("descricao"));
                m.setNome(rs.getString("nome"));

                mp.setMaquina(m);

                Processo p = new Processo();

                p.setIdProcesso(rs.getInt("idProcesso"));
                p.setNomeP(rs.getString("nomeP"));

                mp.setProcesso(p);

                maquinasProcesso.add(mp);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar maquinas dos processos: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return maquinasProcesso;

    }

    public void create(MaquinaProcesso mp) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("insert into maquinaProcesso (idMaquina, idProcesso) values (?, ?) ;");

            stmt.setInt(1, mp.getMaquina().getIdMaquina());
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

    public void delete(MaquinaProcesso m) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("DELETE FROM maquinaProcesso WHERE idMaquinaProcesso = ?");

            stmt.setInt(1, m.getIdMaquinaProcesso());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }
    }

}
