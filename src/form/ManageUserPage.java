package form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import helper.databaseHelper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageUserPage extends JFrame {


    private JTable table1;
    private JTextField txt_username;
    private JTextField txt_password;
    private JTextField txt_full_name;
    private JComboBox cb_role;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private JLabel lbl_nama_lengkap;
    private JLabel lbl_role;
    private JButton btn_tambah;
    private JButton btn_edit;
    private JButton btn_delete;
    private JButton btn_batal;
    private JLabel lbl_id;
    private JTextField txt_id;
    private JButton btn_cari_data;
    private JTextField txt_cari_data;
    private JLabel lbl_cari_data;

    private DefaultTableModel model;

    public void kondisiAwal() {

        txt_id.setEnabled(false);
        txt_username.setEnabled(false);
        txt_password.setEnabled(false);
        txt_full_name.setEnabled(false);
        cb_role.setEnabled(false);

        txt_cari_data.setText("");


        txt_id.setText("");
        txt_username.setText("");
        txt_password.setText("");
        txt_full_name.setText("");
        cb_role.setSelectedIndex(0);

        btn_tambah.setEnabled(true);
        btn_edit.setEnabled(true);
        btn_delete.setEnabled(true);

        btn_tambah.setText("Tambah Data");
        btn_edit.setText("Edit Data");
        btn_delete.setText("Hapus Data");
        btn_batal.setText("Batal");





    }

    public void aktif() {
        txt_id.setEnabled(true);
        txt_username.setEnabled(true);
        txt_password.setEnabled(true);
        txt_full_name.setEnabled(true);
        cb_role.setEnabled(true);
    }


    public ManageUserPage() {
        this.setVisible(true);
        this.setSize(1280, 800);
        this.setTitle("Sianjelau - Manage User Page");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        kondisiAwal();

        /*
         * Background Image
         */
        ImageIcon image = new ImageIcon("src\\assets\\global_background.png");
        JLabel label = new JLabel(image);
        label.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));
        JPanel panel = (JPanel) this.getContentPane();
        panel.setOpaque(false);

        /*
         * Label Username
         */
        lbl_username = new JLabel("Username");
        lbl_username.setBounds(105, 150, 100, 20);
        this.getLayeredPane().add(lbl_username, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Text Field Username
         */

        txt_username.setBounds(300, 150, 300, 25);
        txt_username.setBorder(null);
        this.getLayeredPane().add(txt_username, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Label Password
         */
        lbl_password = new JLabel("Password");
        lbl_password.setBounds(105, 180, 100, 20);
        this.getLayeredPane().add(lbl_password, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Text Field Password
         */

        txt_password.setBounds(300, 180, 300, 25);
        txt_password.setBorder(null);
        this.getLayeredPane().add(txt_password, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Label Nama Lengkap
         */
        lbl_nama_lengkap = new JLabel("Nama Lengkap");
        lbl_nama_lengkap.setBounds(105, 210, 100, 20);
        this.getLayeredPane().add(lbl_nama_lengkap, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Text Field Nama Lengkap
         */

        txt_full_name.setBounds(300, 210, 300, 25);
        txt_full_name.setBorder(null);
        this.getLayeredPane().add(txt_full_name, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Label Role
         */
        lbl_role = new JLabel("Role");
        lbl_role.setBounds(105, 240, 100, 20);
        this.getLayeredPane().add(lbl_role, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Combo Box Role
         */

        cb_role.setBounds(300, 240, 300, 25);

        this.getLayeredPane().add(cb_role, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Button Tambah
         */

        btn_tambah.setBounds(350, 330, 130, 25);
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setBorder(null);
        this.getLayeredPane().add(btn_tambah, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Button Edit
         */
        btn_edit.setBounds(550, 330, 130, 25);
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setBorder(null);
        this.getLayeredPane().add(btn_edit, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Button Delete
         */
        btn_delete.setBounds(750, 330, 130, 25);
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setBorder(null);
        this.getLayeredPane().add(btn_delete, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Button Batal
         */
        btn_batal.setBounds(950, 330, 130, 25);
        btn_batal.setForeground(new java.awt.Color(255, 255, 255));
        btn_batal.setBorder(null);
        this.getLayeredPane().add(btn_batal, Integer.valueOf(Integer.MAX_VALUE));

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
         * Label cari data
         */
        lbl_cari_data = new JLabel("Cari Data");
        lbl_cari_data.setBounds(820, 170, 100, 20);
        this.getLayeredPane().add(lbl_cari_data, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Text Field Search
         */
        txt_cari_data.setBounds(820, 200, 300, 25);
        txt_cari_data.setBorder(null);
        this.getLayeredPane().add(txt_cari_data, Integer.valueOf(Integer.MAX_VALUE));




        /*
         * Button cari data
         */
        btn_cari_data.setBounds(900, 240, 130, 25);
        btn_cari_data.setForeground(new java.awt.Color(255, 255, 255));
        btn_cari_data.setBorder(null);
        this.getLayeredPane().add(btn_cari_data, Integer.valueOf(Integer.MAX_VALUE));








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


        btn_tambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn_tambah.getText().equals("Tambah Data")) {
                    kondisiAwal();
                    btn_tambah.setText("Simpan Data");
                    btn_edit.setEnabled(false);
                    btn_delete.setEnabled(false);
                    btn_batal.setText("Batal");
                    aktif();
                    txt_id.setEnabled(false);
                    txt_username.requestFocus();

                    String oldId = table1.getValueAt(table1.getRowCount() - 1, 0).toString();
                    int newId = Integer.parseInt(oldId) + 1;
                    txt_id.setText(String.valueOf(newId));




                } else {
                    String id = txt_id.getText();
                    String username = txt_username.getText();
                    String password = txt_password.getText();
                    String full_name = txt_full_name.getText();
                    String role = cb_role.getSelectedItem().toString();

                    if (username.equals("") || password.equals("") || full_name.equals("") || role.equals("")) {
                        JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
                    } else {
                        databaseHelper db = new databaseHelper();
                        if (db.addDataUser(username, password, full_name, role)) {
                            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
                            model.addRow(new Object[]{id, username, password, full_name, role});
                            kondisiAwal();
                        } else {
                            JOptionPane.showMessageDialog(null, "Data gagal disimpan");
                        }
                    }
                }
            }
        });
        btn_batal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn_batal.getText().equals("Batal")) {
                    model.getDataVector().removeAllElements();
                    model.fireTableDataChanged();

                    databaseHelper db = new databaseHelper();
                    db.cariDataUser(model, "");
                    kondisiAwal();




                }
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table1.getSelectedRow();

                String ID = table1.getValueAt(row, 0).toString();
                String username = table1.getValueAt(row, 1).toString();
                String password = table1.getValueAt(row, 2).toString();
                String full_name = table1.getValueAt(row, 3).toString();
                String role = table1.getValueAt(row, 4).toString();

                txt_id.setText(ID);
                txt_username.setText(username);
                txt_password.setText(password);
                txt_full_name.setText(full_name);

                if (role.equals("admin")) {
                    cb_role.setSelectedIndex(0);
                } else if (role.equals("karyawan")) {
                    cb_role.setSelectedIndex(1);
                } else {
                    cb_role.setSelectedIndex(2);
                }
                cb_role.setSelectedItem(role);

            }
        });

        btn_edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn_edit.getText().equals("Edit Data")) {
                    kondisiAwal();
                    btn_edit.setText("Simpan Data");
                    btn_tambah.setEnabled(false);
                    btn_delete.setEnabled(false);
                    btn_batal.setText("Batal");
                    aktif();
                    txt_id.setEnabled(false);
                    txt_username.requestFocus();

                    txt_id.setText(table1.getValueAt(table1.getSelectedRow(), 0).toString());
                    txt_username.setText(table1.getValueAt(table1.getSelectedRow(), 1).toString());
                    txt_password.setText(table1.getValueAt(table1.getSelectedRow(), 2).toString());
                    txt_full_name.setText(table1.getValueAt(table1.getSelectedRow(), 3).toString());
                    String role = table1.getValueAt(table1.getSelectedRow(), 4).toString();
                    if (role.equals("admin")) {
                        cb_role.setSelectedIndex(0);
                    } else if (role.equals("karyawan")) {
                        cb_role.setSelectedIndex(1);
                    } else {
                        cb_role.setSelectedIndex(2);
                    }
                    cb_role.setSelectedItem(role);


                } else {
                    String id = txt_id.getText();
                    String username = txt_username.getText();
                    String password = txt_password.getText();
                    String full_name = txt_full_name.getText();
                    String role = cb_role.getSelectedItem().toString();

                    if (username.equals("") || password.equals("") || full_name.equals("") || role.equals("")) {
                        JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
                    } else {
                        databaseHelper db = new databaseHelper();
                        if (db.updateDataUser(id, username, password, full_name, role)) {
                            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
                            model.setValueAt(id, table1.getSelectedRow(), 0);
                            model.setValueAt(username, table1.getSelectedRow(), 1);
                            model.setValueAt(password, table1.getSelectedRow(), 2);
                            model.setValueAt(full_name, table1.getSelectedRow(), 3);
                            model.setValueAt(role, table1.getSelectedRow(), 4);
                            kondisiAwal();
                        } else {
                            JOptionPane.showMessageDialog(null, "Data gagal diubah");
                        }
                    }
                }
            }
        });
        btn_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn_delete.getText().equals("Hapus Data")) {


                    btn_tambah.setEnabled(false);
                    btn_edit.setEnabled(false);
                    btn_batal.setText("Batal");

                    txt_id.setEnabled(false);
                    txt_username.requestFocus();

                    String id = txt_id.getText();
                    if (id.equals("")){
                        JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
                    } else {
                        txt_id.setText(table1.getValueAt(table1.getSelectedRow(), 0).toString());
                        txt_username.setText(table1.getValueAt(table1.getSelectedRow(), 1).toString());
                        txt_password.setText(table1.getValueAt(table1.getSelectedRow(), 2).toString());
                        txt_full_name.setText(table1.getValueAt(table1.getSelectedRow(), 3).toString());
                        String role = table1.getValueAt(table1.getSelectedRow(), 4).toString();
                        if (role.equals("admin")) {
                            cb_role.setSelectedIndex(0);
                        } else if (role.equals("karyawan")) {
                            cb_role.setSelectedIndex(1);
                        } else {
                            cb_role.setSelectedIndex(2);
                        }
                        cb_role.setSelectedItem(role);


                        if (JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data ini?", "Hapus Data", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            databaseHelper db = new databaseHelper();
                            if (db.deleteDataUser(txt_id.getText())) {
                                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                                model.removeRow(table1.getSelectedRow());
                                kondisiAwal();
                            } else {
                                JOptionPane.showMessageDialog(null, "Data gagal dihapus");
                            }
                        }
                    }







                }
            }
        });
        btn_cari_data.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cari = txt_cari_data.getText();
                databaseHelper db = new databaseHelper();
                db.cariDataUser(model, cari);
            }
        });
    }



    private void createUIComponents() {


        model = new DefaultTableModel();
        table1 = new JTable(model);

        // add table header
        model.addColumn("ID");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Nama Lengkap");
        model.addColumn("Role");

        databaseHelper db = new databaseHelper();
        db.getDataUser(model);




    }
}
