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
import model.BEAN.Processo;

public class ProcessoDAO {

    public void create(Processo p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("INSERT INTO processo(idCategoriaP, nomeP, descricaoP, precoP) VALUES (?, ?, ?, ?);");

            stmt.setInt(1, p.getCategoria().getId());
            stmt.setString(2, p.getNomeP());
            stmt.setString(3, p.getDescricaoP());
            stmt.setDouble(4, p.getPrecoP());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public List<Processo> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Processo> processos = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT processo.idProcesso, processo.idCategoriaP, processo.nomeP, processo.descricaoP, \n"
                    + "processo.precoP, categoria.idCategoria, categoria.nome AS nomeC\n"
                    + "FROM processo\n"
                    + "INNER JOIN categoria ON categoria.idCategoria = processo.idCategoriaP;");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Processo processo = new Processo();

                processo.setIdProcesso(rs.getInt("idProcesso"));;
                processo.setNomeP(rs.getString("nomeP"));
                processo.setDescricaoP(rs.getString("descricaoP"));
                processo.setPrecoP(rs.getDouble("precoP"));

                Categoria categoria = new Categoria();

                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNome(rs.getString("nomeC"));

                processo.setCategoria(categoria);

                processos.add(processo);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar processos: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return processos;

    }
    
    public List<Processo> readWhere(String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Processo> processos = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT processo.idProcesso, processo.idCategoriaP, processo.nomeP, processo.descricaoP, \n"
                    + "processo.precoP, categoria.idCategoria, categoria.nome AS nomeC\n"
                    + "FROM processo\n"
                    + "INNER JOIN categoria ON categoria.idCategoria = processo.idCategoriaP"
                    + " where processo.nomeP like '%" + nome + "%';");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Processo processo = new Processo();

                processo.setIdProcesso(rs.getInt("idProcesso"));;
                processo.setNomeP(rs.getString("nomeP"));
                processo.setDescricaoP(rs.getString("descricaoP"));
                processo.setPrecoP(rs.getDouble("precoP"));

                Categoria categoria = new Categoria();

                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNome(rs.getString("nomeC"));

                processo.setCategoria(categoria);

                processos.add(processo);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar processos: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return processos;

    }
    
    public List<Processo> readWhere(int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Processo> processos = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT processo.idProcesso, processo.idCategoriaP, processo.nomeP, processo.descricaoP, \n"
                    + "processo.precoP, categoria.idCategoria, categoria.nome AS nomeC\n"
                    + "FROM processo\n"
                    + "INNER JOIN categoria ON categoria.idCategoria = processo.idCategoriaP"
                    + " where processo.idProcesso like '%" + id + "%';");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Processo processo = new Processo();

                processo.setIdProcesso(rs.getInt("idProcesso"));;
                processo.setNomeP(rs.getString("nomeP"));
                processo.setDescricaoP(rs.getString("descricaoP"));
                processo.setPrecoP(rs.getDouble("precoP"));

                Categoria categoria = new Categoria();

                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNome(rs.getString("nomeC"));

                processo.setCategoria(categoria);

                processos.add(processo);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar processos: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return processos;

    }

    public List<Processo> readMAX() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Processo> processos = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT MAX(processo.idProcesso), processo.idCategoriaP, processo.nomeP, processo.descricaoP, \n"
                    + "processo.precoP FROM processo;");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Processo processo = new Processo();

                processo.setIdProcesso(rs.getInt("MAX(processo.idProcesso)"));
                processo.setNomeP(rs.getString("nomeP"));
                processo.setDescricaoP(rs.getString("descricaoP"));
                processo.setPrecoP(rs.getDouble("precoP"));

                Categoria categoria = new Categoria();

                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNome(rs.getString("nomeC"));

                processo.setCategoria(categoria);

                processos.add(processo);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao consultar processos: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return processos;

    }

    public void update(Processo p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("UPDATE processo SET idCategoriaP = ?, nomeP = ?, descricaoP = ?, precoP = ? WHERE idProcesso = ?;");

            stmt.setInt(1, p.getCategoria().getId());
            stmt.setString(2, p.getNomeP());
            stmt.setString(3, p.getDescricaoP());
            stmt.setDouble(4, p.getPrecoP());

            stmt.setInt(5, p.getIdProcesso());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public void delete(Processo p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("DELETE FROM processo WHERE idProcesso = ?");

            stmt.setInt(1, p.getIdProcesso());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }
    }

}
