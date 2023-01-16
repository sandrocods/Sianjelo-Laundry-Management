package helper;

import javax.swing.table.DefaultTableModel;
import java.sql.*;


public class databaseHelper {

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
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

    /*
     *  Dashboard Page
     */
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

    public String getTotalUser() {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM tb_user");
            String total = null;
            while (rs.next()) {
                total = rs.getString("total");
            }
            return total;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return null;
    }

    public String getTotalMember(){
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM tb_member");
            String total = null;
            while (rs.next()) {
                total = rs.getString("total");
            }
            return total;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return null;
    }

    /*
     * Manage User Method
     */
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


    /*
     * Manage Member Method
     */
    public void getDataMember(DefaultTableModel model) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_member");
            while (rs.next()) {
                Object[] row = {rs.getString("id") ,rs.getString("nama_member"), rs.getString("alamat_member"), rs.getString("no_telp"), rs.getString("point")};
                model.addRow(row);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
    }
    public void cariDataMember(DefaultTableModel model, String cari) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_member WHERE nama_member LIKE '%"+ cari +"%' OR alamat_member LIKE '%"+ cari +"%'");

            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();

            while (rs.next()) {
                Object[] row = {rs.getString("id") ,rs.getString("nama_member"), rs.getString("alamat_member"), rs.getString("no_telp"), rs.getString("point")};
                model.addRow(row);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
    }

    public Boolean addDataMember(String nama_member, String alamat_member, String no_telp, String point) {

        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO `tb_member` (`id`, `nama_member`, `alamat_member`, `no_telp`, `point` , `created_at`) VALUES (NULL, '"+ nama_member +"', '"+ alamat_member +"', '"+ no_telp +"', '"+ point +"', current_timestamp())");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return false;
    }

    public Boolean editDataMember(String id, String nama_member, String alamat_member, String no_telp, String point) {

        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE `tb_member` SET `nama_member` = '"+ nama_member +"', `alamat_member` = '"+ alamat_member +"', `no_telp` = '"+ no_telp +"', `point` = '"+ point +"' WHERE `tb_member`.`id` = "+ id +";");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return false;
    }

    public Boolean deleteDataMember(String id) {

        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM `tb_member` WHERE `tb_member`.`id` = "+ id +";");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return false;
    }
}
