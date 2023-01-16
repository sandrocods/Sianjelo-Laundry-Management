package helper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;


public class databaseHelper {

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sianjelo", "root", "");
        } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
        }
        return conn;
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static boolean login(String username, String password) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_user WHERE username = '" + username + "' AND password = '" + password + "'");
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return false;
    }

    public static String getRole(String username, String password) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT role FROM tb_user WHERE username = '" + username + "' AND password = '" + password + "'");
            if (rs.next()) {
                return rs.getString("role");
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return null;
    }


    public void getDataUser(DefaultTableModel model) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_user");
            while (rs.next()) {
                Object[] row = {rs.getString("id") ,rs.getString("username"), rs.getString("password"), rs.getString("full_name"), rs.getString("role")};
                model.addRow(row);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
    }

    public boolean addDataUser(String username, String password, String full_name, String role) {
        Connection conn = null;
        System.out.println("INSERT INTO tb_user VALUES ('NULL," + username + "', '" + password + "', '" + full_name + "', '" + role + "',current_timestamp())");
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO `tb_user` (`id`, `username`, `password`, `full_name`, `role`, `created_at`) VALUES (NULL, '"+ username +"', '"+ password + "', '"+ full_name +"', '"+ role +"', current_timestamp())");

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return false;
    }

    public boolean updateDataUser(String id, String username, String password, String full_name, String role) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE `tb_user` SET `username` = '"+ username +"', `password` = '"+ password +"', `full_name` = '"+ full_name +"', `role` = '"+ role +"' WHERE `tb_user`.`id` = "+ id +";");

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return false;
    }

    public boolean deleteDataUser(String id) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM `tb_user` WHERE `tb_user`.`id` = "+ id +";");

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return false;
    }

    public void cariDataUser(DefaultTableModel model, String cari) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_user WHERE username LIKE '%"+ cari +"%' OR full_name LIKE '%"+ cari +"%'");

            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();

            while (rs.next()) {
                Object[] row = {rs.getString("id") ,rs.getString("username"), rs.getString("password"), rs.getString("full_name"), rs.getString("role")};
                model.addRow(row);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
    }

    public void getDataPaket(DefaultTableModel model) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_paket");
            while (rs.next()) {
                Object[] row = {rs.getString("id_paket") ,rs.getString("nama_paket"), rs.getString("jenis_paket"), rs.getString("harga_paket")};
                model.addRow(row);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
    }
    public boolean addDataPaket(int id, String nama, String jenis, int harga) {
        Connection conn = null;
        System.out.println("INSERT INTO tb_user VALUES ('NULL," + nama + "', '" + jenis + "', '" + harga + "')");
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO `tb_paket` (`id_paket`, `nama_paket`, `jenis_paket`, `harga_paket`) VALUES (NULL, '" + nama + "', '" + jenis + "', '" + harga + "')");

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return false;
    }
    public boolean deleteDataPaket(String id) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM `tb_paket` WHERE `tb_paket`.`id_paket` = "+ id +";");

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return false;
    }
    public boolean updateDataPaket( String id,String nama, String jenis, int harga){
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE tb_paket SET nama = '"+ nama+ "', jenis_paket = '"+jenis+"', harga = '"+harga+"' WHERE id_paket = '"+id+"';");
            return true;
        }catch (SQLException ex) {
            ex.printStackTrace( ) ;
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }finally {
            databaseHelper.close(conn);
        }
        return false;
    }
}
