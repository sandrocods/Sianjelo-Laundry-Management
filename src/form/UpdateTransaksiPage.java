package form;

import helper.databaseHelper;
import helper.whatsappHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateTransaksiPage extends JFrame {
    private JLabel lbl_id_trx;
    private JLabel lbl_status_trx;
    private JLabel lbl_nama_member;
    private JLabel lbl_tgl_transaksi;
    private JLabel lbl_status_proses;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox2;
    private JButton btn_update_trx;
    private JButton btn_batal;
    private JTable tb_list_trx;
    private JTable tb_detail_trx;

    private DefaultTableModel model1;

    private DefaultTableModel model2;

    public void kondisiawal() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");

        textField1.setEnabled(false);
        textField2.setEnabled(false);
        textField3.setEnabled(false);


    }

    public UpdateTransaksiPage() {
        this.setVisible(true);
        this.setSize(1280, 800);
        this.setTitle("Sianjelau - Update Transaksi Page");
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        kondisiawal();

        /*
         * Background Image
         */
        ImageIcon image = new ImageIcon("src\\assets\\update_transaksi_page.png");
        JLabel label = new JLabel(image);
        label.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));
        JPanel panel = (JPanel) this.getContentPane();
        panel.setOpaque(false);

        /*
         * Label ID Transaksi
         */
        lbl_id_trx.setBounds(100, 120, 100, 10);
        lbl_id_trx.setForeground(new java.awt.Color(41, 65, 114));
        this.getLayeredPane().add(lbl_id_trx, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Text Field ID Transaksi
         */

        textField1.setBounds(230, 117, 200, 20);
        this.getLayeredPane().add(textField1, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Label Status Transaksi
         */

        lbl_status_trx.setBounds(100, 145, 200, 20);
        this.getLayeredPane().add(lbl_status_trx, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Combo Box Status Transaksi
         */
        comboBox1.setBounds(230, 145, 200, 20);
        comboBox1.addItem("Belum Bayar");
        comboBox1.addItem("Dibayar");
        this.getLayeredPane().add(comboBox1, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Label Nama Member
         */
        lbl_nama_member.setBounds(100, 170, 200, 20);
        this.getLayeredPane().add(lbl_nama_member, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Text Field Nama Member
         */
        textField2.setBounds(230, 170, 200, 20);
        this.getLayeredPane().add(textField2, 2);

        /*
         * Label Tanggal Transaksi
         */
        lbl_tgl_transaksi.setBounds(100, 195, 200, 20);
        this.getLayeredPane().add(lbl_tgl_transaksi, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Text Field Tanggal Transaksi
         */
        textField3.setBounds(230, 195, 200, 20);
        this.getLayeredPane().add(textField3, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Label Status Proses
         */
        lbl_status_proses.setBounds(100, 220, 200, 20);

        this.getLayeredPane().add(lbl_status_proses, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Combo Box Status Proses
         */
        comboBox2.setBounds(230, 220, 200, 20);
        comboBox2.addItem("Selesai");
        comboBox2.addItem("Pengerjaan");
        comboBox2.addItem("Antar");
        comboBox2.addItem("Jemput");
        this.getLayeredPane().add(comboBox2, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Button Update Transaksi
         */
        btn_update_trx.setBounds(400, 330, 150, 20);
        btn_update_trx.setForeground(new java.awt.Color(255, 255, 255));
        btn_update_trx.setBorder(null);
        this.getLayeredPane().add(btn_update_trx, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Button Batal
         */
        btn_batal.setBounds(600, 330, 150, 20);
        btn_batal.setForeground(new java.awt.Color(255, 255, 255));
        btn_batal.setBorder(null);
        this.getLayeredPane().add(btn_batal, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Table List Transaksi
         */
        tb_list_trx.setBounds(100, 400, 750, 200);
        this.getLayeredPane().add(tb_list_trx, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Jpanel list transaksi
         */
        JScrollPane scrollPane = new JScrollPane(tb_list_trx);
        scrollPane.setBounds(100, 400, 750, 200);
        this.getLayeredPane().add(scrollPane, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Table Detail Transaksi
         */
        tb_detail_trx.setBounds(930, 400, 250, 200);
        this.getLayeredPane().add(tb_detail_trx, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Jpanel Detail Transaksi
         */
        JScrollPane scrollPane2 = new JScrollPane(tb_detail_trx);
        scrollPane2.setBounds(930, 400, 250, 200);
        this.getLayeredPane().add(scrollPane2, Integer.valueOf(Integer.MAX_VALUE));


        tb_list_trx.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = tb_list_trx.getSelectedRow();
                String id_trx = tb_list_trx.getModel().getValueAt(row, 0).toString();
                String status_trx = tb_list_trx.getModel().getValueAt(row, 1).toString();
                String nama_member = tb_list_trx.getModel().getValueAt(row, 2).toString();
                String tgl_transaksi = tb_list_trx.getModel().getValueAt(row, 3).toString();
                String status_proses = tb_list_trx.getModel().getValueAt(row, 4).toString();

                textField1.setText(id_trx);
                comboBox1.setSelectedItem(status_trx);
                textField2.setText(nama_member);
                textField3.setText(tgl_transaksi);
                comboBox2.setSelectedItem(status_proses);


                databaseHelper db = new databaseHelper();
                db.getDetailTrx(tb_list_trx.getModel().getValueAt(row, 5).toString(), model2);

            }
        });
        btn_update_trx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (textField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");

                } else {

                    databaseHelper db = new databaseHelper();
                    db.updateTrx(
                            textField1.getText(),
                            comboBox1.getSelectedItem().toString(),
                            comboBox2.getSelectedItem().toString()
                    );
                    model1.setValueAt(comboBox1.getSelectedItem().toString(), tb_list_trx.getSelectedRow(), 1);
                    model1.setValueAt(comboBox2.getSelectedItem().toString(), tb_list_trx.getSelectedRow(), 4);

                    JOptionPane.showMessageDialog(null, "Data berhasil diupdate");

                    if (db.getActiveWhatsappSetting()) {

                        String no_telepon = tb_list_trx.getModel().getValueAt(tb_list_trx.getSelectedRow(), 6).toString();

                        String detail_pesanan = "";
                        for (int i = 0; i < tb_detail_trx.getRowCount(); i++) {
                            String nama_paket = tb_detail_trx.getModel().getValueAt(i, 0).toString();
                            String harga_paket = tb_detail_trx.getModel().getValueAt(i, 1).toString();
                            String jenis_paket = tb_detail_trx.getModel().getValueAt(i, 2).toString();

                            detail_pesanan +=
                                    "Nama Paket : " + nama_paket + "\n"
                                            + "Harga Paket : " + harga_paket + "\n"
                                            + "Jenis Paket : " + jenis_paket + "\n\n";

                        }

                        whatsappHelper helper = new whatsappHelper();
                        helper.sendMessage(
                                no_telepon.replaceFirst("0", "62"),
                                comboBox2.getSelectedItem().toString(),
                                textField2.getText(),
                                no_telepon.replaceFirst("0", "62"),
                                detail_pesanan
                        );
                    }

                    kondisiawal();
                }
            }
        });
        btn_batal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kondisiawal();
            }
        });
    }

    private void createUIComponents() {

        databaseHelper db = new databaseHelper();


        model1 = new DefaultTableModel();
        tb_list_trx = new JTable(model1);
        model1.addColumn("ID Transaksi");
        model1.addColumn("Status Transaksi");
        model1.addColumn("Nama Member");
        model1.addColumn("Tanggal Transaksi");
        model1.addColumn("Status Proses");
        model1.addColumn("id_detail_transaksi");
        model1.addColumn("no_telp");

        tb_list_trx.getColumnModel().getColumn(5).setMinWidth(0);


        db.getTransaksi(model1);


        model2 = new DefaultTableModel();
        tb_detail_trx = new JTable(model2);
        model2.addColumn("Nama Paket");
        model2.addColumn("Harga Paket");
        model2.addColumn("Jenis Paket");


    }
}
