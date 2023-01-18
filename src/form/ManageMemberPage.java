package form;

import helper.databaseHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageMemberPage extends JFrame {

    private JLabel lbl_id;
    private JTextField txt_id;
    private JLabel lbl_cari_data;
    private JTextField txt_cari_data;
    private JLabel lbl_nama_member;
    private JTextField txt_nama_member;
    private JTextArea txta_alamat_member;
    private JLabel lbl_telp_member;
    private JTextField txt_no_telp;
    private JTextField txt_poin_member;
    private JButton btn_tambah_member;
    private JButton btn_edit_member;
    private JButton btn_delete_member;
    private JButton btn_batal;
    private JButton cariDataButton;
    private JTable table1;
    private JLabel lbl_point_member;
    private JLabel lbl_alamat_member;

    private DefaultTableModel model;


    public void kondisiAwal() {


        txt_id.setEnabled(false);
        txt_nama_member.setEnabled(false);
        txta_alamat_member.setEnabled(false);
        txt_no_telp.setEnabled(false);
        txt_poin_member.setEnabled(false);


        btn_tambah_member.setEnabled(true);
        btn_delete_member.setEnabled(true);
        btn_edit_member.setEnabled(true);
        btn_batal.setEnabled(true);


        txt_id.setText("");
        txt_nama_member.setText("");
        txta_alamat_member.setText("");
        txt_no_telp.setText("");
        txt_poin_member.setText("");
        txt_cari_data.setText("");

        btn_tambah_member.setText("Tambah Data");
        btn_edit_member.setText("Edit Data");
        btn_delete_member.setText("Hapus Data");
        btn_batal.setText("Batal");


    }

    public void aktif() {

        txt_id.setEnabled(true);
        txt_nama_member.setEnabled(true);
        txta_alamat_member.setEnabled(true);
        txt_no_telp.setEnabled(true);
        txt_poin_member.setEnabled(true);

    }

    public ManageMemberPage() {
        this.setVisible(true);
        this.setSize(1280, 800);
        this.setTitle("Sianjelau - Manage Member Page");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        kondisiAwal();

        /*
         * Background Image
         */
        ImageIcon image = new ImageIcon("src\\assets\\manage_member_page.png");
        JLabel label = new JLabel(image);
        label.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));
        JPanel panel = (JPanel) this.getContentPane();
        panel.setOpaque(false);

        /*
         * Label ID
         */
        lbl_id = new JLabel("ID");
        lbl_id.setBounds(105, 120, 100, 20);
        this.getLayeredPane().add(lbl_id, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Text Field ID
         */

        txt_id.setBounds(300, 120, 300, 25);
        txt_id.setBorder(null);
        this.getLayeredPane().add(txt_id, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Label nama
         */
        lbl_nama_member = new JLabel("Nama");
        lbl_nama_member.setBounds(105, 150, 100, 20);
        this.getLayeredPane().add(lbl_nama_member, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Text Field nama
         */

        txt_nama_member.setBounds(300, 150, 300, 25);
        txt_nama_member.setBorder(null);
        this.getLayeredPane().add(txt_nama_member, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Label alamat member
         */
        lbl_telp_member = new JLabel("Alamat");
        lbl_telp_member.setBounds(105, 180, 100, 20);
        this.getLayeredPane().add(lbl_telp_member, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Text Field alamat
         */

        txta_alamat_member.setBounds(300, 180, 300, 45);
        txta_alamat_member.setBorder(null);
        txta_alamat_member.setLineWrap(true);
        this.getLayeredPane().add(txta_alamat_member, Integer.valueOf(Integer.MAX_VALUE));


        /*
         * Label no telp
         */
        lbl_telp_member = new JLabel("No. Telp");
        lbl_telp_member.setBounds(105, 230, 100, 20);
        this.getLayeredPane().add(lbl_telp_member, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Text Field no telp
         */

        txt_no_telp.setBounds(300, 230, 300, 25);
        txt_no_telp.setBorder(null);
        this.getLayeredPane().add(txt_no_telp, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Label point member
         */
        lbl_point_member = new JLabel("Point Member");
        lbl_point_member.setBounds(105, 260, 100, 20);
        this.getLayeredPane().add(lbl_point_member, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Text Field point member
         */
        txt_poin_member.setBounds(300, 260, 300, 25);
        txt_poin_member.setBorder(null);
        this.getLayeredPane().add(txt_poin_member, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Button Tambah
         */

        btn_tambah_member.setBounds(250, 330, 130, 25);
        btn_tambah_member.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah_member.setBorder(null);
        this.getLayeredPane().add(btn_tambah_member, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Button Edit
         */
        btn_edit_member.setBounds(450, 330, 130, 25);
        btn_edit_member.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit_member.setBorder(null);
        this.getLayeredPane().add(btn_edit_member, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Button Delete
         */
        btn_delete_member.setBounds(650, 330, 130, 25);
        btn_delete_member.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete_member.setBorder(null);
        this.getLayeredPane().add(btn_delete_member, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Button Batal
         */
        btn_batal.setBounds(850, 330, 130, 25);
        btn_batal.setForeground(new java.awt.Color(255, 255, 255));
        btn_batal.setBorder(null);
        this.getLayeredPane().add(btn_batal, Integer.valueOf(Integer.MAX_VALUE));



        /*
         * Label cari data
         */
        lbl_cari_data = new JLabel("Cari Data");
        lbl_cari_data.setBounds(820, 150, 100, 20);
        this.getLayeredPane().add(lbl_cari_data, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Text Field Search
         */
        txt_cari_data.setBounds(820, 180, 300, 25);
        txt_cari_data.setBorder(null);
        this.getLayeredPane().add(txt_cari_data, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Button cari data
         */
        cariDataButton.setBounds(900, 220, 130, 25);
        cariDataButton.setForeground(new java.awt.Color(255, 255, 255));
        cariDataButton.setBorder(null);
        this.getLayeredPane().add(cariDataButton, Integer.valueOf(Integer.MAX_VALUE));



        /*
         * Table
         */

        table1.setBounds(130, 400, 1000, 300);
        table1.setBorder(null);
        table1.setDefaultEditor(Object.class, null);
        this.getLayeredPane().add(table1, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * scroll pane
         */
        JScrollPane scrollPane = new JScrollPane(table1);
        scrollPane.setBounds(130, 400, 1000, 300);
        this.getLayeredPane().add(scrollPane, Integer.valueOf(Integer.MAX_VALUE));

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int i = table1.getSelectedRow();

                txt_id.setText(model.getValueAt(i, 0).toString());
                txt_nama_member.setText(model.getValueAt(i, 1).toString());
                txta_alamat_member.setText(model.getValueAt(i, 2).toString());
                txt_no_telp.setText(model.getValueAt(i, 3).toString());
                txt_poin_member.setText(model.getValueAt(i, 4).toString());

            }
        });
        btn_tambah_member.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn_tambah_member.getText().equals("Tambah Data")) {
                    int newId = 0;
                    kondisiAwal();

                    btn_tambah_member.setText("Simpan");
                    btn_delete_member.setEnabled(false);
                    btn_edit_member.setEnabled(false);
                    aktif();

                    txt_id.setEnabled(false);
                    txt_nama_member.requestFocus();

                    try{
                        String oldId = table1.getValueAt(table1.getRowCount() - 1, 0).toString();
                        newId = Integer.parseInt(oldId) + 1;
                        txt_id.setText(String.valueOf(newId));
                    } catch (Exception ex){
                        newId = 1;
                        txt_id.setText(String.valueOf(newId));
                    }

                } else {
                    String id = txt_id.getText();
                    String nama = txt_nama_member.getText();
                    String alamat = txta_alamat_member.getText();
                    String no_telp = txt_no_telp.getText();
                    String poin = txt_poin_member.getText();

                    if (nama.isEmpty() || alamat.isEmpty() || no_telp.isEmpty() || poin.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
                    } else {
                        databaseHelper db = new databaseHelper();
                        if (db.addDataMember(nama, alamat, no_telp, poin)) {
                            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
                            model.addRow(new Object[]{id, nama, alamat, no_telp, poin});
                            kondisiAwal();
                        } else {
                            JOptionPane.showMessageDialog(null, "Data gagal ditambahkan");
                        }

                    }

                }
            }
        });
        btn_edit_member.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn_edit_member.getText().equals("Edit Data")) {
                    btn_edit_member.setText("Simpan");
                    btn_delete_member.setEnabled(false);
                    btn_tambah_member.setEnabled(false);
                    aktif();

                    txt_id.setEnabled(false);
                    txt_nama_member.requestFocus();
                } else {
                    String id = txt_id.getText();
                    String nama = txt_nama_member.getText();
                    String alamat = txta_alamat_member.getText();
                    String no_telp = txt_no_telp.getText();
                    String poin = txt_poin_member.getText();

                    if (id.isEmpty() || nama.isEmpty() || alamat.isEmpty() || no_telp.isEmpty() || poin.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
                    } else {
                        databaseHelper db = new databaseHelper();
                        if (db.editDataMember(id, nama, alamat, no_telp, poin)) {
                            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
                            model.setValueAt(id, table1.getSelectedRow(), 0);
                            model.setValueAt(nama, table1.getSelectedRow(), 1);
                            model.setValueAt(alamat, table1.getSelectedRow(), 2);
                            model.setValueAt(no_telp, table1.getSelectedRow(), 3);
                            model.setValueAt(poin, table1.getSelectedRow(), 4);
                            kondisiAwal();
                        } else {
                            JOptionPane.showMessageDialog(null, "Data gagal diubah");
                            kondisiAwal();
                        }

                    }

                }
            }
        });
        btn_delete_member.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn_delete_member.getText().equals("Hapus Data")) {
                    btn_delete_member.setText("Hapus");
                    btn_edit_member.setEnabled(false);
                    btn_tambah_member.setEnabled(false);
                    txt_id.setEnabled(false);
                    txt_nama_member.setEnabled(false);
                    txta_alamat_member.setEnabled(false);
                    txt_no_telp.setEnabled(false);
                    txt_poin_member.setEnabled(false);
                } else {
                    String id = txt_id.getText();
                    databaseHelper db = new databaseHelper();
                    if (db.deleteDataMember(id)) {
                        JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                        model.removeRow(table1.getSelectedRow());
                        kondisiAwal();
                    } else {
                        JOptionPane.showMessageDialog(null, "Data gagal dihapus");
                        kondisiAwal();
                    }
                }
            }
        });
        btn_batal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.getDataVector().removeAllElements();
                model.fireTableDataChanged();

                databaseHelper db = new databaseHelper();
                db.cariDataMember(model, " ");

                if (btn_batal.getText().equals("Batal")) {
                    kondisiAwal();
                } else {
                    kondisiAwal();
                }
            }
        });
        cariDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cari = txt_cari_data.getText();
                databaseHelper db = new databaseHelper();
                db.cariDataMember(model, cari);
            }
        });
    }

    private void createUIComponents() {

        model = new DefaultTableModel();
        table1 = new JTable(model);

        // add table header
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("No. Telp");
        model.addColumn("Point");

        databaseHelper db = new databaseHelper();
        db.getDataMember(model);
    }
}
