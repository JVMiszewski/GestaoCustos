package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    //private static final String URL = "jdbc:mysql://tcc-ifrs.mysql.uhserver.com:3306/tcc_ifrs?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private static final String URL = "jdbc:mysql://localhost:3306/tcc?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {

        try {

            Class.forName(DRIVER);

            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException ex) {

            throw new RuntimeException("Erro da Conexão com o BD: ", ex);
        }
    }

    public static void closeConnection(Connection con) {

        try {

            if (con != null) {

                con.close();

            }
        } catch (SQLException ex) {

            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if (stmt != null) {

                stmt.close();

            }
        } catch (SQLException ex) {

            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) {

                rs.close();

            }
        } catch (SQLException ex) {

            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("");

            System.out.println(stmt);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }
    }

}
