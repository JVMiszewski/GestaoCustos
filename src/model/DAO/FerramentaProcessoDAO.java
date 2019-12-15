package model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.BEAN.FerramentaProcesso;
import model.BEAN.Ferramenta;
import model.BEAN.Processo;

public class FerramentaProcessoDAO {

    public List<FerramentaProcesso> readP(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<FerramentaProcesso> ferramentasProcesso = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT ferramentaProcesso.idFerramentaProcesso, ferramentaProcesso.idFerramenta AS idF, \n"
                    + "ferramentaProcesso.idProcesso, ferramenta.nome, ferramenta.descricao, processo.idProcesso, processo.nomeP\n"
                    + "from ferramentaProcesso\n"
                    + "Inner Join ferramenta on ferramentaProcesso.idFerramenta = ferramenta.idFerramenta\n"
                    + "Inner Join processo on ferramentaProcesso.idProcesso = processo.idProcesso\n"
                    + "where ferramentaProcesso.idProcesso = ?;");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {

                FerramentaProcesso fp = new FerramentaProcesso();

                fp.setIdFerramentaProcesso(rs.getInt("idFerramentaProcesso"));

                Ferramenta f = new Ferramenta();

                f.setIdFerramenta(rs.getInt("idF"));
                f.setDescricao(rs.getString("descricao"));
                f.setNome(rs.getString("nome"));

                fp.setFerramenta(f);

                Processo p = new Processo();

                p.setIdProcesso(rs.getInt("idProcesso"));
                p.setNomeP(rs.getString("nomeP"));

                fp.setProcesso(p);

                ferramentasProcesso.add(fp);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar ferramentas dos processos: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return ferramentasProcesso;

    }

    public List<FerramentaProcesso> readWhere(int id, String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<FerramentaProcesso> ferramentasProcesso = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT ferramentaProcesso.idFerramentaProcesso, ferramentaProcesso.idFerramenta AS idF, \n"
                    + "ferramentaProcesso.idProcesso, ferramenta.nome, ferramenta.descricao, processo.idProcesso, processo.nomeP\n"
                    + "from ferramentaProcesso\n"
                    + "Inner Join ferramenta on ferramentaProcesso.idFerramenta = ferramenta.idFerramenta\n"
                    + "Inner Join processo on ferramentaProcesso.idProcesso = processo.idProcesso\n"
                    + "where ferramentaProcesso.idProcesso = ? and ferramenta.nome like '%" + nome + "%';");

            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                FerramentaProcesso fp = new FerramentaProcesso();

                fp.setIdFerramentaProcesso(rs.getInt("idFerramentaProcesso"));

                Ferramenta f = new Ferramenta();

                f.setIdFerramenta(rs.getInt("idF"));
                f.setDescricao(rs.getString("descricao"));
                f.setNome(rs.getString("nome"));

                fp.setFerramenta(f);

                Processo p = new Processo();

                p.setIdProcesso(rs.getInt("idProcesso"));
                p.setNomeP(rs.getString("nomeP"));

                fp.setProcesso(p);

                ferramentasProcesso.add(fp);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar ferramentas dos processos: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return ferramentasProcesso;

    }

    public List<FerramentaProcesso> readWhere(int id, int cod) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<FerramentaProcesso> ferramentasProcesso = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT ferramentaProcesso.idFerramentaProcesso, ferramentaProcesso.idFerramenta AS idF, \n"
                    + "ferramentaProcesso.idProcesso, ferramenta.nome, ferramenta.descricao, processo.idProcesso, processo.nomeP\n"
                    + "from ferramentaProcesso\n"
                    + "Inner Join ferramenta on ferramentaProcesso.idFerramenta = ferramenta.idFerramenta\n"
                    + "Inner Join processo on ferramentaProcesso.idProcesso = processo.idProcesso\n"
                    + "where ferramentaProcesso.idProcesso = ? and ferramentaProcesso.idFerramentaProcesso like '%" + cod + "%';");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {

                FerramentaProcesso fp = new FerramentaProcesso();

                fp.setIdFerramentaProcesso(rs.getInt("idFerramentaProcesso"));

                Ferramenta f = new Ferramenta();

                f.setIdFerramenta(rs.getInt("idF"));
                f.setDescricao(rs.getString("descricao"));
                f.setNome(rs.getString("nome"));

                fp.setFerramenta(f);

                Processo p = new Processo();

                p.setIdProcesso(rs.getInt("idProcesso"));
                p.setNomeP(rs.getString("nomeP"));

                fp.setProcesso(p);

                ferramentasProcesso.add(fp);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar ferramentas dos processos: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return ferramentasProcesso;

    }

    public void create(FerramentaProcesso fp) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("insert into ferramentaProcesso (idFerramenta, idProcesso) values (?, ?) ;");

            stmt.setInt(1, fp.getFerramenta().getIdFerramenta());
            stmt.setInt(2, fp.getProcesso().getIdProcesso());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public void delete(FerramentaProcesso p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("DELETE FROM ferramentaProcesso WHERE idFerramentaProcesso = ?");

            stmt.setInt(1, p.getIdFerramentaProcesso());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }
    }
}
