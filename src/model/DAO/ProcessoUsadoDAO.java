package model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.BEAN.Processo;
import model.BEAN.ProcessoUsado;

public class ProcessoUsadoDAO {

    public List<ProcessoUsado> readP(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ProcessoUsado> processosUsados = new ArrayList<>();

        try {

            stmt = con.prepareStatement("select processoUsado.idProcessoUsado, processo.nomeP, processoUsado.preco, "
                    + "processo.precoP, processoUsado.quantia from processoUsado\n"
                    + "inner join processo on processoUsado.idProcesso = processo.idProcesso\n"
                    + "where processoUsado.idFichaTecnica = ?;");

            stmt.setInt(1, id);

            System.out.println(stmt);

            rs = stmt.executeQuery();

            while (rs.next()) {

                ProcessoUsado processoUsado = new ProcessoUsado();

                processoUsado.setIdProcessoUsado(rs.getInt("idProcessoUsado"));
                processoUsado.setPreco(rs.getDouble("preco"));
                processoUsado.setQuantidade(rs.getInt("quantia"));

                Processo processo = new Processo();

                processo.setNomeP(rs.getString("nomeP"));
                processo.setPrecoP(rs.getDouble("precoP"));

                processoUsado.setProcesso(processo);

                processosUsados.add(processoUsado);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar processos usados: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return processosUsados;

    }
    
    public List<ProcessoUsado> readP(int id, String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ProcessoUsado> processosUsados = new ArrayList<>();

        try {

            stmt = con.prepareStatement("select processoUsado.idProcessoUsado, processo.nomeP, processoUsado.preco, "
                    + "processo.precoP, processoUsado.quantia from processoUsado\n"
                    + "inner join processo on processoUsado.idProcesso = processo.idProcesso\n"
                    + "where processoUsado.idFichaTecnica = ? and nomeP like '%" + nome + "%';");

            stmt.setInt(1, id);

            System.out.println(stmt);

            rs = stmt.executeQuery();

            while (rs.next()) {

                ProcessoUsado processoUsado = new ProcessoUsado();

                processoUsado.setIdProcessoUsado(rs.getInt("idProcessoUsado"));
                processoUsado.setPreco(rs.getDouble("preco"));
                processoUsado.setQuantidade(rs.getInt("quantia"));

                Processo processo = new Processo();

                processo.setNomeP(rs.getString("nomeP"));
                processo.setPrecoP(rs.getDouble("precoP"));

                processoUsado.setProcesso(processo);

                processosUsados.add(processoUsado);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar processos usados: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return processosUsados;

    }
    
    public List<ProcessoUsado> readP(int id, int cod) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ProcessoUsado> processosUsados = new ArrayList<>();

        try {

            stmt = con.prepareStatement("select processoUsado.idProcessoUsado, processo.nomeP, processoUsado.preco, "
                    + "processo.precoP, processoUsado.quantia from processoUsado\n"
                    + "inner join processo on processoUsado.idProcesso = processo.idProcesso\n"
                    + "where processoUsado.idFichaTecnica = ? and processoUsado.idProcessoUsado like '%" + cod + "%';");

            stmt.setInt(1, id);

            System.out.println(stmt);

            rs = stmt.executeQuery();

            while (rs.next()) {

                ProcessoUsado processoUsado = new ProcessoUsado();

                processoUsado.setIdProcessoUsado(rs.getInt("idProcessoUsado"));
                processoUsado.setPreco(rs.getDouble("preco"));
                processoUsado.setQuantidade(rs.getInt("quantia"));

                Processo processo = new Processo();

                processo.setNomeP(rs.getString("nomeP"));
                processo.setPrecoP(rs.getDouble("precoP"));

                processoUsado.setProcesso(processo);

                processosUsados.add(processoUsado);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar processos usados: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return processosUsados;

    }

    public void create(ProcessoUsado pu) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("insert into processoUsado (idProcesso, idFichaTecnica, preco, quantia) values (?, ?, ?, ?) ;");

            stmt.setInt(1, pu.getProcesso().getIdProcesso());
            stmt.setInt(2, pu.getFichaTecnica().getIdFichaTecnica());
            stmt.setDouble(3, pu.getPreco());
            stmt.setInt(4, pu.getQuantidade());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public void delete(ProcessoUsado pu) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("DELETE FROM processoUsado WHERE idProcessoUsado = ?");

            stmt.setInt(1, pu.getIdProcessoUsado());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }
    }
}
