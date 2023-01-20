package form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import helper.databaseHelper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransaksiPage extends JFrame {
    private JLabel lbl_id_trx;
    private JLabel lbl_member;
    private JLabel lbl_user;
    private JLabel lbl_jumlah_pembayaran;
    private JLabel lbl_total_pembayaran;
    private JLabel lbl_status_trx;
    private JLabel lbl_tanggal_trx;
    private JTextField txt_id_trx;
    private JComboBox cb_pilih_member;
    private JTextField txt_user;
    private JTextField txt_tgl_trx;
    private JComboBox cb_status_trx;
    private JLabel lbl_val_total_bayar;
    private JLabel lbl_val_jumlah_bayar;
    private JLabel lbl_paket;
    private JComboBox cb_pilih_paket;
    private JLabel lbl_jenis_paket;
    private JTextField txt_jenis_paket;
    private JLabel lbl_harga_paket;
    private JTextField txt_harga_paket;
    private JButton btn_tambah_paket;
    private JButton btn_hapus_paket;
    private JTable table1;
    private JLabel lbl_poin_member;
    private JTextField txt_point_member;
    private JButton btn_use_point;
    private JLabel lbl_jumlah_paket;
    private JTextField txt_jumlah_paket;
    private JLabel lbl_diskon_member;
    private JLabel lbl_val_potongan_point;
    private JTextField txt_jumlah_bayar;
    private JButton btn_simpan;
    private JLabel lbl_kembalian;
    private JLabel lbl_val_kembalian;

    private DefaultTableModel model;

    public void kondisi_awal() {
        txt_id_trx.setText("");
        txt_tgl_trx.setText("");
        txt_jenis_paket.setText("");
        txt_harga_paket.setText("");
        txt_jumlah_paket.setText("");
        txt_point_member.setText("");
        txt_jumlah_bayar.setText("");
        lbl_val_total_bayar.setText("0");
        lbl_val_jumlah_bayar.setText("0");
        lbl_val_potongan_point.setText("0");
        lbl_val_kembalian.setText("0");

        txt_id_trx.setEnabled(false);
        txt_user.setEnabled(false);
        txt_tgl_trx.setEnabled(false);
        txt_jenis_paket.setEnabled(false);
        txt_harga_paket.setEnabled(false);
        txt_jumlah_paket.setEnabled(true);
        txt_point_member.setEnabled(false);
        txt_jumlah_bayar.setEnabled(true);
        cb_pilih_member.setEnabled(true);
        cb_pilih_paket.setEnabled(true);
        cb_status_trx.setEnabled(true);
        btn_tambah_paket.setEnabled(true);
        btn_hapus_paket.setEnabled(true);
        btn_use_point.setEnabled(true);
        btn_simpan.setEnabled(true);


        cb_pilih_member.setSelectedIndex(0);
        cb_pilih_paket.setSelectedIndex(0);


    }

    public TransaksiPage(String username) {
        this.setVisible(true);
        this.setSize(1280, 800);
        this.setTitle("Sianjelau - Transaksi Page");
        this.setLocationRelativeTo(null);
        this.setResizable(false);





        /*
         * Background Image
         */
        ImageIcon image = new ImageIcon("src\\assets\\transaksi_page.png");
        JLabel label = new JLabel(image);
        label.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));
        JPanel panel = (JPanel) this.getContentPane();
        panel.setOpaque(false);


        lbl_id_trx = new JLabel("ID Transaksi");
        lbl_id_trx.setBounds(100, 120, 100, 20);
        this.getLayeredPane().add(lbl_id_trx, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * txt_id_trx
         */
        txt_id_trx.setBounds(180, 122, 100, 20);
        txt_id_trx.setBorder(null);
        this.getLayeredPane().add(txt_id_trx, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * lbl_user
         */
        lbl_user = new JLabel("User");
        lbl_user.setBounds(100, 155, 100, 20);
        this.getLayeredPane().add(lbl_user, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * txt_user
         */
        txt_user = new JTextField(username);
        txt_user.setBounds(180, 155, 100, 20);
        txt_user.setBorder(null);
        txt_user.setEnabled(false);
        this.getLayeredPane().add(txt_user, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * lbl_member
         */
        lbl_member = new JLabel("Pilih Member");
        lbl_member.setBounds(100, 190, 100, 20);
        this.getLayeredPane().add(lbl_member, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * cb_pilih_member
         */

        cb_pilih_member.setBounds(180, 190, 200, 20);
        cb_pilih_member.setBorder(null);

        databaseHelper db = new databaseHelper();
        db.add_member_combobox(cb_pilih_member);

        this.getLayeredPane().add(cb_pilih_member, 1);

        /*
         * lbl_tanggal_trx
         */
        lbl_tanggal_trx = new JLabel("Tanggal Transaksi");
        lbl_tanggal_trx.setBounds(450, 120, 200, 20);
        this.getLayeredPane().add(lbl_tanggal_trx, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * txt_tgl_trx
         */
        txt_tgl_trx.setBorder(null);
        txt_tgl_trx.setEnabled(false);
        txt_tgl_trx.setBounds(580, 122, 150, 20);

        lbl_poin_member = new JLabel("Point Member");
        lbl_poin_member.setBounds(450, 155, 200, 20);
        this.getLayeredPane().add(lbl_poin_member, Integer.valueOf(Integer.MAX_VALUE));


        txt_point_member.setBorder(null);
        txt_point_member.setEnabled(false);
        txt_point_member.setBounds(580, 155, 100, 20);
        this.getLayeredPane().add(txt_point_member, Integer.valueOf(Integer.MAX_VALUE));


        btn_use_point.setBounds(560, 190, 150, 20);
        btn_use_point.setBorder(null);
        btn_use_point.setForeground(new java.awt.Color(255, 255, 255));
        this.getLayeredPane().add(btn_use_point, Integer.valueOf(Integer.MAX_VALUE));


        Thread thread = new Thread(() -> {
            while (true) {
                java.util.Date date = new java.util.Date();
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
                String formattedDate = sdf.format(date);
                txt_tgl_trx.setText(formattedDate);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        this.getLayeredPane().add(txt_tgl_trx, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * lbl_status_trx
         */
        lbl_status_trx = new JLabel("Status Transaksi");
        lbl_status_trx.setBounds(840, 122, 200, 20);
        this.getLayeredPane().add(lbl_status_trx, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * cb_status_trx
         */
        cb_status_trx.setBounds(950, 122, 200, 20);
        cb_status_trx.setBorder(null);
        cb_status_trx.addItem("Belum Bayar");
        cb_status_trx.addItem("Dibayar");
        this.getLayeredPane().add(cb_status_trx, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * lbl_pilih_paket
         */
        lbl_paket = new JLabel("Pilih Paket");
        lbl_paket.setBounds(110, 290, 200, 20);
        this.getLayeredPane().add(lbl_paket, Integer.valueOf(Integer.MAX_VALUE));


        /*
         * cb_pilih_paket
         */
        cb_pilih_paket.setBounds(180, 290, 200, 20);
        cb_pilih_paket.setBorder(null);
        db.add_data_paket_combobox(cb_pilih_paket);
        this.getLayeredPane().add(cb_pilih_paket, 2);

        /*
         * lbl_harga_paket
         */
        lbl_harga_paket = new JLabel("Harga Paket");
        lbl_harga_paket.setBounds(450, 270, 200, 20);
        this.getLayeredPane().add(lbl_harga_paket, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * txt_harga_paket
         */
        txt_harga_paket.setBorder(null);
        txt_harga_paket.setEnabled(false);
        txt_harga_paket.setBounds(580, 270, 200, 20);
        this.getLayeredPane().add(txt_harga_paket, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * lbl_jenis_paket
         */
        lbl_jenis_paket = new JLabel("Jenis Paket");
        lbl_jenis_paket.setBounds(450, 300, 200, 20);
        this.getLayeredPane().add(lbl_jenis_paket, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * txt_jenis_paket
         */
        txt_jenis_paket.setBorder(null);
        txt_jenis_paket.setEnabled(false);
        txt_jenis_paket.setBounds(580, 300, 200, 20);
        this.getLayeredPane().add(txt_jenis_paket, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * lbl_jumlah_paket
         */
        lbl_jumlah_paket = new JLabel("Jumlah Paket");
        lbl_jumlah_paket.setBounds(800, 270, 200, 20);
        this.getLayeredPane().add(lbl_jumlah_paket, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * txt_jumlah_paket
         */
        txt_jumlah_paket.setBorder(null);
        txt_jumlah_paket.setBounds(900, 270, 50, 20);
        this.getLayeredPane().add(txt_jumlah_paket, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * btn_tambah_paket
         */
        btn_tambah_paket.setBounds(810, 300, 150, 20);
        btn_tambah_paket.setBorder(null);
        btn_tambah_paket.setForeground(new java.awt.Color(255, 255, 255));
        this.getLayeredPane().add(btn_tambah_paket, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * btn_hapus_paket
         */
        btn_hapus_paket.setBounds(1000, 300, 150, 20);
        btn_hapus_paket.setBorder(null);
        btn_hapus_paket.setForeground(new java.awt.Color(255, 255, 255));
        this.getLayeredPane().add(btn_hapus_paket, Integer.valueOf(Integer.MAX_VALUE));





        /*
         * table
         */
        table1.setBounds(130, 400, 1000, 300);
        table1.setBorder(null);
        table1.setDefaultEditor(Object.class, null);
        this.getLayeredPane().add(table1, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * jscrollpane
         */

        JScrollPane scrollPane = new JScrollPane(table1);
        scrollPane.setBounds(110, 350, 1040, 200);
        this.getLayeredPane().add(scrollPane, 2);

        /*
         * lbl_total_pembayaran
         */
        lbl_total_pembayaran = new JLabel("Total Pembayaran");
        lbl_total_pembayaran.setBounds(830, 600, 200, 20);
        this.getLayeredPane().add(lbl_total_pembayaran, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * lbl_val_total_pembayaran
         */
        lbl_val_total_bayar = new JLabel("0");
        lbl_val_total_bayar.setBounds(950, 600, 200, 20);
        this.getLayeredPane().add(lbl_val_total_bayar, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * lbl_potongan_point
         */
        lbl_diskon_member = new JLabel("Potongan Point");
        lbl_diskon_member.setBounds(830, 630, 200, 20);
        this.getLayeredPane().add(lbl_diskon_member, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * lbl_val_potongan_point
         */
        lbl_val_potongan_point = new JLabel("0");
        lbl_val_potongan_point.setBounds(950, 630, 200, 20);
        this.getLayeredPane().add(lbl_val_potongan_point, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * lbl_jumlah_bayar
         */
        lbl_jumlah_pembayaran = new JLabel("Jumlah Pembayaran");
        lbl_jumlah_pembayaran.setBounds(830, 660, 200, 20);
        this.getLayeredPane().add(lbl_jumlah_pembayaran, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * txt_jumlah_bayar
         */
        txt_jumlah_bayar.setBorder(null);
        txt_jumlah_bayar.setBounds(950, 660, 200, 20);
        this.getLayeredPane().add(txt_jumlah_bayar, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * lbl_kembalian
         */
        lbl_kembalian = new JLabel("Kembalian");
        lbl_kembalian.setBounds(830, 690, 200, 20);
        this.getLayeredPane().add(lbl_kembalian, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * lbl_val_kembalian
         */
        lbl_val_kembalian = new JLabel("0");
        lbl_val_kembalian.setBounds(950, 690, 200, 20);
        this.getLayeredPane().add(lbl_val_kembalian, Integer.valueOf(Integer.MAX_VALUE));








        /*
         * btn_simpan
         */
        btn_simpan.setBounds(450, 620, 150, 30);
        btn_simpan.setBorder(null);
        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        this.getLayeredPane().add(btn_simpan, Integer.valueOf(Integer.MAX_VALUE));


        cb_pilih_member.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String member = cb_pilih_member.getSelectedItem().toString();
                if (member.equals("-- Pilih Member --")) {
                    txt_point_member.setText("0");
                } else {
                    databaseHelper db = new databaseHelper();
                    txt_point_member.setText(db.getPointMember(member));
                }
            }
        });
        cb_pilih_paket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String paket = cb_pilih_paket.getSelectedItem().toString();
                if (paket.equals("-- Pilih Paket --")) {
                    txt_harga_paket.setText("0");
                    txt_jenis_paket.setText("0");
                    txt_jumlah_paket.setText("0");
                } else {
                    databaseHelper db = new databaseHelper();
                    String[] data = db.getHargaPaket(paket).toArray(new String[0]);
                    txt_jenis_paket.setText(data[2]);
                    txt_harga_paket.setText(data[3]);


                }
            }
        });
        btn_tambah_paket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String paket = cb_pilih_paket.getSelectedItem().toString();
                if (paket.equals("-- Pilih Paket --")) {
                    JOptionPane.showMessageDialog(null, "Pilih Paket Terlebih Dahulu");
                } else {

                    int no = table1.getRowCount() + 1;
                    model.addRow(new Object[]{no, paket, txt_jenis_paket.getText(), txt_harga_paket.getText(), txt_jumlah_paket.getText(), Integer.parseInt(txt_harga_paket.getText()) * Integer.parseInt(txt_jumlah_paket.getText())});

                    int total = 0;
                    for (int i = 0; i < table1.getRowCount(); i++) {
                        total += Integer.parseInt(table1.getValueAt(i, 5).toString());
                    }
                    if (lbl_val_potongan_point.getText().equals("0")) {
                        lbl_val_total_bayar.setText(String.valueOf(total));
                    } else {
                        lbl_val_total_bayar.setText(String.valueOf(total - Integer.parseInt(lbl_val_potongan_point.getText())));
                    }

                    cb_pilih_paket.setSelectedIndex(0);
                    txt_jenis_paket.setText("");
                    txt_harga_paket.setText("");
                    txt_jumlah_paket.setText("");

                }
            }
        });
        btn_hapus_paket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table1.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Pilih Paket Terlebih Dahulu");
                } else {
                    model.removeRow(row);
                    int total = 0;
                    for (int i = 0; i < table1.getRowCount(); i++) {
                        total += Integer.parseInt(table1.getValueAt(i, 5).toString());
                    }
                    lbl_val_total_bayar.setText(String.valueOf(total));
                }
            }
        });
        btn_use_point.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String member = cb_pilih_member.getSelectedItem().toString();

                if (txt_point_member.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Point Member Tidak Mencukupi");
                }

                if (member.equals("-- Pilih Member --")) {
                    JOptionPane.showMessageDialog(null, "Pilih Member Terlebih Dahulu");
                } else {
                    lbl_val_potongan_point.setText(txt_point_member.getText());
                    int point = Integer.parseInt(txt_point_member.getText());
                    int total = Integer.parseInt(lbl_val_total_bayar.getText());
                    if (point > total) {
                        JOptionPane.showMessageDialog(null, "Point Tidak Mencukupi");
                    } else {
                        int point_baru = 0;
                        databaseHelper db = new databaseHelper();

                        if (lbl_val_potongan_point.getText().equals("0")) {
                            lbl_val_total_bayar.setText(String.valueOf(total));
                        } else {
                            lbl_val_total_bayar.setText(String.valueOf(total - Integer.parseInt(lbl_val_potongan_point.getText())));
                        }

                        db.updatePointMember(member, point_baru);
                        txt_point_member.setText(String.valueOf(point_baru));
                        JOptionPane.showMessageDialog(null, "Point Berhasil Digunakan");
                    }
                }
            }
        });
        btn_simpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                databaseHelper db = new databaseHelper();
                String id_trx = txt_id_trx.getText();
                String id_member = db.getIdMember(cb_pilih_member.getSelectedItem().toString());
                String id_eksekusi = db.getIdPegawai(txt_user.getText());
                String status_trx = cb_status_trx.getSelectedItem().toString();
                String total_bayar = lbl_val_total_bayar.getText();
                String jumlah_pembayaran = txt_jumlah_bayar.getText();
                String id_detail_trx = db.getLastIdDetailTrx();
                String lbl_kembalian = lbl_val_kembalian.getText();

                if (id_detail_trx == null) {
                    id_detail_trx = "1";
                } else {
                    id_detail_trx = String.valueOf(Integer.parseInt(id_detail_trx) + 1);
                }

                System.out.println(
                        "id_trx : " + id_trx + "\n" +
                                "id_member : " + id_member + "\n" +
                                "id_eksekusi : " + id_eksekusi + "\n" +
                                "status_trx : " + status_trx + "\n" +
                                "total_bayar : " + total_bayar + "\n" +
                                "jumlah_pembayaran : " + jumlah_pembayaran + "\n" +
                                "id_detail_trx : " + id_detail_trx + "\n"
                );

                if (lbl_val_kembalian.getText().equals("-")) {
                    JOptionPane.showMessageDialog(null, "Jumlah Pembayaran Kurang");
                }

                if (cb_pilih_member.getSelectedItem().toString().equals("-- Pilih Member --")) {
                    JOptionPane.showMessageDialog(null, "Pilih Member Terlebih Dahulu");
                } else if (cb_status_trx.getSelectedItem().toString().equals("-- Pilih Status --")) {
                    JOptionPane.showMessageDialog(null, "Pilih Status Terlebih Dahulu");
                } else if (txt_jumlah_bayar.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Masukkan Jumlah Pembayaran");
                    txt_jumlah_bayar.requestFocus();

                } else if (Integer.parseInt(txt_jumlah_bayar.getText()) < Integer.parseInt(lbl_val_total_bayar.getText())) {
                    JOptionPane.showMessageDialog(null, "Jumlah Pembayaran Kurang");
                    txt_jumlah_bayar.setText("");
                    txt_jumlah_bayar.requestFocus();

                } else {
                    db.insertTransaksi(id_trx, id_member, id_eksekusi, status_trx, total_bayar, jumlah_pembayaran, lbl_kembalian, id_detail_trx);
                    for (int i = 0; i < table1.getRowCount(); i++) {
                        String id_paket = db.getIdPaketByName(table1.getValueAt(i, 1).toString());
                        db.insertDetailTransaksi(id_detail_trx, id_paket);
                    }

                    JOptionPane.showMessageDialog(null, "Transaksi Berhasil Disimpan");
                    String member = cb_pilih_member.getSelectedItem().toString();
                    int point = Integer.parseInt(txt_point_member.getText());
                    db.updatePointMember(member, point + 1000);

                    for (int i = table1.getRowCount() - 1; i >= 0; i--) {
                        model.removeRow(i);
                    }

                    kondisi_awal();

                }


            }
        });
        txt_jumlah_bayar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int jumlah_bayar = Integer.parseInt(txt_jumlah_bayar.getText());
                int total_bayar = Integer.parseInt(lbl_val_total_bayar.getText());
                int kembalian = jumlah_bayar - total_bayar;
                lbl_val_kembalian.setText(String.valueOf(kembalian));
            }
        });
    }

    private void createUIComponents() {

        model = new DefaultTableModel();
        table1 = new JTable(model);
        model.addColumn("No");
        model.addColumn("Nama Paket");
        model.addColumn("Jenis Paket");
        model.addColumn("Harga Paket");
        model.addColumn("Jumlah Paket");
        model.addColumn("Total Harga");


        table1.setRowHeight(30);


    }
}
