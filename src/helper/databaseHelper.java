package helper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


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
            return rs.next();
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
                Object[] row = {rs.getString("id"), rs.getString("username"), rs.getString("password"), rs.getString("full_name"), rs.getString("role")};
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

    public String getTotalMember() {
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

    public String getTotalProsesSelesai() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = sdf.format(new java.util.Date());

        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(`status_proses`) as total_proses_selesai FROM tb_transaksi WHERE `status_proses` = \"Selesai\" and tgl_transaksi LIKE \"%" + dateNow + "%\";");
            String total = null;
            while (rs.next()) {
                total = rs.getString("total_proses_selesai");
            }
            return total;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return null;
    }


    public String getPendapatanHarian() {


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = sdf.format(new java.util.Date());

        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SUM(jumlah_pembayaran) AS total_hari_ini FROM tb_transaksi WHERE tgl_transaksi LIKE \"%" + dateNow + "%\";");
            String total = null;
            while (rs.next()) {
                total = rs.getString("total_hari_ini");
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
            stmt.executeUpdate("INSERT INTO `tb_user` (`id`, `username`, `password`, `full_name`, `role`, `created_at`) VALUES (NULL, '" + username + "', '" + password + "', '" + full_name + "', '" + role + "', current_timestamp())");

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
            stmt.executeUpdate("UPDATE `tb_user` SET `username` = '" + username + "', `password` = '" + password + "', `full_name` = '" + full_name + "', `role` = '" + role + "' WHERE `tb_user`.`id` = " + id + ";");

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
            stmt.executeUpdate("DELETE FROM `tb_user` WHERE `tb_user`.`id` = " + id + ";");

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
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_user WHERE username LIKE '%" + cari + "%' OR full_name LIKE '%" + cari + "%'");

            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();

            while (rs.next()) {
                Object[] row = {rs.getString("id"), rs.getString("username"), rs.getString("password"), rs.getString("full_name"), rs.getString("role")};
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
                Object[] row = {rs.getString("id"), rs.getString("nama_member"), rs.getString("alamat_member"), rs.getString("no_telp"), rs.getString("point")};
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_member WHERE nama_member LIKE '%" + cari + "%' OR alamat_member LIKE '%" + cari + "%'");

            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();

            while (rs.next()) {
                Object[] row = {rs.getString("id"), rs.getString("nama_member"), rs.getString("alamat_member"), rs.getString("no_telp"), rs.getString("point")};
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
            stmt.executeUpdate("INSERT INTO `tb_member` (`id`, `nama_member`, `alamat_member`, `no_telp`, `point` , `created_at`) VALUES (NULL, '" + nama_member + "', '" + alamat_member + "', '" + no_telp + "', '" + point + "', current_timestamp())");
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
            stmt.executeUpdate("UPDATE `tb_member` SET `nama_member` = '" + nama_member + "', `alamat_member` = '" + alamat_member + "', `no_telp` = '" + no_telp + "', `point` = '" + point + "' WHERE `tb_member`.`id` = " + id + ";");
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
            stmt.executeUpdate("DELETE FROM `tb_member` WHERE `tb_member`.`id` = " + id + ";");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return false;
    }

    public void getDataPaket(DefaultTableModel model) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_paket");
            while (rs.next()) {
                Object[] row = {rs.getString("id_paket"), rs.getString("nama_paket"), rs.getString("jenis_paket"), rs.getString("harga_paket")};
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
            stmt.executeUpdate("DELETE FROM `tb_paket` WHERE `tb_paket`.`id_paket` = " + id + ";");

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return false;
    }

    public boolean updateDataPaket(String id, String nama, String jenis, int harga) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE tb_paket SET nama_paket = '" + nama + "', jenis_paket = '" + jenis + "', harga_paket = '" + harga + "' WHERE id_paket = '" + id + "';");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        } finally {
            databaseHelper.close(conn);
        }
        return false;
    }

    public void cariDataPaket(DefaultTableModel model, String cari) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_paket WHERE nama_paket LIKE '%" + cari + "%'");

            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();

            while (rs.next()) {
                Object[] row = {rs.getString("id_paket"), rs.getString("nama_paket"), rs.getString("jenis_paket"), rs.getString("harga_paket")};
                model.addRow(row);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }

    }


    public void add_member_combobox(JComboBox combobox) {
        Connection conn = null;
        try {
            combobox.removeAllItems();
            combobox.addItem("-- Pilih Member --");
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_member");
            while (rs.next()) {
                combobox.addItem(rs.getString("nama_member"));
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
    }

    public String getIdMember(String nama) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_member WHERE nama_member = '" + nama + "'");
            while (rs.next()) {
                return rs.getString("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return null;
    }

    public String getIdPegawai(String nama) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_user WHERE username = '" + nama + "'");
            while (rs.next()) {
                return rs.getString("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return null;
    }

    public String getPointMember(String nama_member) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_member WHERE nama_member = '" + nama_member + "'");
            while (rs.next()) {
                return rs.getString("point");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return null;
    }

    public void add_data_paket_combobox(JComboBox combobox) {
        Connection conn = null;
        try {
            combobox.removeAllItems();
            combobox.addItem("-- Pilih Paket --");
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_paket");
            while (rs.next()) {
                combobox.addItem(rs.getString("nama_paket"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }

    }

    // make function return array assosiative using arraylist
    public ArrayList<String> getHargaPaket(String nama_paket) {
        Connection conn = null;
        ArrayList<String> data = new ArrayList<String>();
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_paket WHERE nama_paket = '" + nama_paket + "'");
            while (rs.next()) {
                data.add(rs.getString("id_paket"));
                data.add(rs.getString("nama_paket"));
                data.add(rs.getString("jenis_paket"));
                data.add(rs.getString("harga_paket"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return data;
    }

    public String getLastIdDetailTrx() {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_detail FROM tb_detail_transaksi ORDER BY id_detail DESC LIMIT 1");
            while (rs.next()) {
                return rs.getString("id_detail");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return null;
    }


    public void insertTransaksi(String id_trx, String id_member, String id_eksekusi, String status_trx, String total_bayar, String jumlah_pembayaran, String kembalian, String id_detail) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO `tb_transaksi` " +
                    "(`id`, `id_member`, `id_user`, `tgl_transaksi`, `status_proses`, `status_transaksi`, `total_pembayaran`, `jumlah_pembayaran`, `kembalian`, `id_detail`) VALUES " +
                    "(NULL, '" + id_member + "', '" + id_eksekusi + "', current_timestamp(), 'Jemput', '" + status_trx + "', '" + total_bayar + "', '" + jumlah_pembayaran + "','" + kembalian + "', '" + id_detail + "');");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        } finally {
            close(conn);
        }
    }

    public String getIdPaketByName(String nama_paket) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_paket WHERE nama_paket = '" + nama_paket + "'");
            while (rs.next()) {
                return rs.getString("id_paket");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return null;
    }

    public void insertDetailTransaksi(String id_detail_trx, String id_paket) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO `tb_detail_transaksi` (`id_detail`, `id_paket`) VALUES ('" + id_detail_trx + "', '" + id_paket + "');");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        } finally {
            close(conn);
        }
    }


    public void updatePointMember(String member, int point_baru) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE `tb_member` SET `point` = '" + point_baru + "' WHERE `tb_member`.`nama_member` = '" + member + "';");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        } finally {
            close(conn);
        }
    }

    public String getTotalProsesPengerjaan() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = sdf.format(new java.util.Date());

        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(`status_proses`) as total_proses_pengerjaan FROM tb_transaksi WHERE `status_proses` = \"Pengerjaan\" and tgl_transaksi LIKE \"%" + dateNow + "%\";");
            String total = null;
            while (rs.next()) {
                total = rs.getString("total_proses_pengerjaan");
            }
            return total;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return null;
    }

    public void getTransaksi(DefaultTableModel model1) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT DISTINCT tb_transaksi.id, tb_transaksi.status_transaksi, tb_member.nama_member, tb_transaksi.tgl_transaksi, tb_transaksi.status_proses, tb_transaksi.id_detail, tb_member.no_telp\n" +
                            "FROM tb_paket\n" +
                            "INNER JOIN tb_detail_transaksi ON tb_paket.id_paket = tb_detail_transaksi.id_paket\n" +
                            "INNER JOIN tb_transaksi ON tb_detail_transaksi.id_detail = tb_transaksi.id_detail\n" +
                            "INNER JOIN tb_member ON tb_transaksi.id_member = tb_member.id;");
            while (rs.next()) {
                model1.addRow(new Object[]{
                        rs.getString("id"),
                        rs.getString("status_transaksi"),
                        rs.getString("nama_member"),
                        rs.getString("tgl_transaksi"),
                        rs.getString("status_proses"),
                        rs.getString("id_detail"),
                        rs.getString("no_telp")

                });
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
    }

    public void getTransaksibyDate(DefaultTableModel model1, String data_awal, String data_akhir) {
        Connection conn = null;

        model1.fireTableDataChanged();
        model1.setRowCount(0);

        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT DISTINCT tb_transaksi.id, tb_transaksi.status_transaksi, tb_member.nama_member, tb_transaksi.tgl_transaksi, tb_transaksi.status_proses, tb_transaksi.id_detail, tb_member.no_telp\n" +
                            "FROM tb_paket\n" +
                            "INNER JOIN tb_detail_transaksi ON tb_paket.id_paket = tb_detail_transaksi.id_paket\n" +
                            "INNER JOIN tb_transaksi ON tb_detail_transaksi.id_detail = tb_transaksi.id_detail\n" +
                            "INNER JOIN tb_member ON tb_transaksi.id_member = tb_member.id\n" +
                            "WHERE tb_transaksi.tgl_transaksi BETWEEN '" + data_awal + "' AND '" + data_akhir + "';");
            while (rs.next()) {
                model1.addRow(new Object[]{
                        rs.getString("id"),
                        rs.getString("status_transaksi"),
                        rs.getString("nama_member"),
                        rs.getString("tgl_transaksi"),
                        rs.getString("status_proses"),
                        rs.getString("id_detail"),
                        rs.getString("no_telp")

                });
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
    }

    public void getDetailTrx(String data, DefaultTableModel model2) {
        Connection conn = null;

        model2.getDataVector().removeAllElements();
        model2.fireTableDataChanged();


        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT tb_paket.id_paket, tb_paket.nama_paket, tb_paket.harga_paket, tb_paket.jenis_paket " +
                    "FROM tb_paket " +
                    "INNER JOIN tb_detail_transaksi ON tb_paket.id_paket = tb_detail_transaksi.id_paket " +
                    "INNER JOIN tb_transaksi ON tb_detail_transaksi.id_detail = tb_transaksi.id_detail " +
                    "INNER JOIN tb_member ON tb_transaksi.id_member = tb_member.id " +
                    "WHERE tb_transaksi.id_detail = " + data + ";");
            while (rs.next()) {
                model2.addRow(new Object[]{
                        rs.getString("id_paket"),
                        rs.getString("nama_paket"),
                        rs.getString("jenis_paket"),
                        rs.getString("harga_paket")
                });
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
    }

    public void updateTrx(String id_trx, String status_transaksi, String status_proses) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE `tb_transaksi` SET `status_transaksi` = '" + status_transaksi + "', `status_proses` = '" + status_proses + "' WHERE `tb_transaksi`.`id` = '" + id_trx + "';");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        } finally {
            close(conn);
        }
    }

    public String getSettingApp(JCheckBox checkbox, JTextField textField) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_setting;");
            while (rs.next()) {

                checkbox.setSelected(rs.getString("active_send_whatsapp").equals("1"));
                textField.setText(rs.getString("api_endpoint"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return null;
    }

    public void updateSettingApp(JCheckBox cb_aktif_whatsapp, JTextField txt_api_endpoint) {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE `tb_setting` SET `active_send_whatsapp` = '" + (cb_aktif_whatsapp.isSelected() ? 1 : 0) + "', `api_endpoint` = '" + txt_api_endpoint.getText() + "';");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(conn);
        }
    }

    public Boolean getActiveWhatsappSetting() {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_setting;");
            while (rs.next()) {
                return rs.getString("active_send_whatsapp").equals("1");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return false;
    }


    public String getApiEndpointSetting() {
        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_setting;");
            while (rs.next()) {
                return rs.getString("api_endpoint");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return null;
    }
}


