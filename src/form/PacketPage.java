package form;

import helper.databaseHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PacketPage extends JFrame{
    private JPanel PacketPane;
    private JTextField txt_nama;
    private JButton btn_tambah;
    private JButton btn_delete;
    private JButton btn_reset;
    private JComboBox cmb_jenis;
    private JTable tblPaket;
    private JSpinner spn_harga;
    private JButton btn_update;
    private JLabel lbl_nama;
    private JLabel lbl_jenis;
    private JLabel lbl_harga;
    private JSpinner txt_id;
    private JTextField txt_cari_data;
    private JLabel lbl_cari_data;
    private JButton btn_cari_data;
    private DefaultTableModel model;

    public void reset() {
        txt_nama.setText("");
        spn_harga.setValue(0);

        txt_cari_data.setText("");
    }
    public PacketPage() {
        this.setVisible(true);
        this.setSize(1280, 800);
        this.setTitle("Sianjelau - Packet Page");
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        /*
         * Landing Image
         */
        ImageIcon image = new ImageIcon("src\\assets\\manage_paket_page.png");
        JLabel label = new JLabel(image);
        label.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));
        JPanel panel = (JPanel) this.getContentPane();
        panel.setOpaque(false);

        /*
         * Label Nama
         */
        lbl_nama = new JLabel("Nama");
        lbl_nama.setBounds(105, 150, 100, 20);
        this.getLayeredPane().add(lbl_nama, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Text Field Nama
         */

        txt_nama.setBounds(300, 150, 300, 25);
        txt_nama.setBorder(null);
        this.getLayeredPane().add(txt_nama, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Label Harga
         */
        lbl_harga = new JLabel("Harga");
        lbl_harga.setBounds(105, 180, 100, 20);
        this.getLayeredPane().add(lbl_harga, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Text Field Harga
         */

        spn_harga.setBounds(300, 180, 300, 25);
        spn_harga.setBorder(null);
        this.getLayeredPane().add(spn_harga, Integer.valueOf(Integer.MAX_VALUE));


        /*
         * Label jenis
         */
        lbl_jenis = new JLabel("Jenis");
        lbl_jenis.setBounds(105, 210, 100, 20);
        this.getLayeredPane().add(lbl_jenis, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Combo Box Jenis
         */

        cmb_jenis.setBounds(300, 210, 300, 25);
        this.getLayeredPane().add(cmb_jenis, Integer.valueOf(Integer.MAX_VALUE));


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
        btn_update.setBounds(550, 330, 130, 25);
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setBorder(null);
        this.getLayeredPane().add(btn_update, Integer.valueOf(Integer.MAX_VALUE));

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
        btn_reset.setBounds(950, 330, 130, 25);
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setBorder(null);
        this.getLayeredPane().add(btn_reset, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Button Cari Data
         */
        btn_cari_data.setBounds(900, 220, 130, 25);
        btn_cari_data.setForeground(new java.awt.Color(255, 255, 255));
        btn_cari_data.setBorder(null);
        this.getLayeredPane().add(btn_cari_data, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Label Cari Data
         */
        lbl_cari_data = new JLabel("Cari Data");
        lbl_cari_data.setBounds(820, 150, 100, 20);
        this.getLayeredPane().add(lbl_cari_data, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Text Field Cari Data
         */
        txt_cari_data.setBounds(820, 180, 300, 25);
        txt_cari_data.setBorder(null);
        this.getLayeredPane().add(txt_cari_data, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Table
         */
        tblPaket.setBounds(130, 400, 1000, 300);
        tblPaket.setBorder(null);
        tblPaket.setDefaultEditor(Object.class, null);
        this.getLayeredPane().add(tblPaket, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * scroll pane
         */
        JScrollPane scrollPane = new JScrollPane(tblPaket);
        scrollPane.setBounds(130, 400, 1000, 300);
        this.getLayeredPane().add(scrollPane, Integer.valueOf(Integer.MAX_VALUE));


        btn_tambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nama = txt_nama.getText();
                String jenis = (String) cmb_jenis.getSelectedItem();
                int harga = (int)spn_harga.getValue();

                String oldId = tblPaket.getValueAt(tblPaket.getRowCount() - 1, 0).toString();
                int newId = Integer.parseInt(oldId) + 1;

                if (nama.equals("") || jenis.equals("") ) {
                    JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
                } else {
                    databaseHelper db = new databaseHelper();
                    if (db.addDataPaket(newId , nama, jenis, harga)) {
                        JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
                        model.addRow(new Object[]{newId,nama,jenis, harga});
                        reset();
                    } else {
                        JOptionPane.showMessageDialog(null, "Data gagal disimpan");

                    }
                }
            }
        });
        btn_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();

                databaseHelper db = new databaseHelper();
                db.cariDataPaket(model, " ");
            }
        });
        tblPaket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String id = tblPaket.getValueAt(tblPaket.getSelectedRow(),0).toString();
                txt_nama.setText(tblPaket.getValueAt(tblPaket.getSelectedRow(),1).toString());
                String jenis = tblPaket.getValueAt(tblPaket.getSelectedRow(),2).toString();
                cmb_jenis.setSelectedItem(jenis);

                int harga = Integer.parseInt(tblPaket.getValueAt(tblPaket.getSelectedRow(),3).toString());
                spn_harga.setValue(harga);
            }
        });
        btn_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int jawab;
                if ((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0){
                    databaseHelper db = new databaseHelper();
                    String id = tblPaket.getValueAt(tblPaket.getSelectedRow(),0).toString();
                    if (db.deleteDataPaket(id)) {
                        JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                        model.removeRow(tblPaket.getSelectedRow());
                        reset();
                    } else {
                        JOptionPane.showMessageDialog(null, "Data gagal dihapus");
                    }
                }
            }
        });

        btn_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = tblPaket.getValueAt(tblPaket.getSelectedRow(),0).toString();
                String nama = txt_nama.getText( );
                String jenis = (String) cmb_jenis.getSelectedItem();
                int harga = (int)spn_harga.getValue();
                if (nama.equals("") || jenis.equals("") || harga == 0){
                    JOptionPane.showMessageDialog(null,"Pilih data terlebih dahulu!");
                }else{
                    databaseHelper db = new databaseHelper();
                    if (db.updateDataPaket(id, nama,jenis,harga)) {
                        JOptionPane.showMessageDialog(null, "Data berhasil diubah");
                        model.setValueAt(nama, tblPaket.getSelectedRow(), 1);
                        model.setValueAt(jenis, tblPaket.getSelectedRow(), 2);
                        model.setValueAt(harga, tblPaket.getSelectedRow(), 3);

                        reset();
                    }else{
                        JOptionPane.showMessageDialog(null, "Data gagal diubah");

                    }
                }
            }
        });
        btn_cari_data.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String cari = txt_cari_data.getText();
                databaseHelper db = new databaseHelper();
                db.cariDataPaket(model, cari);


            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        model = new DefaultTableModel() ;
        tblPaket = new JTable(model);
        model.addColumn( "Id" ) ;
        model.addColumn( "Nama" ) ;
        model.addColumn( "Jenis Paket" ) ;
        model.addColumn( "Harga (Rp)" ) ;

        databaseHelper db = new databaseHelper();
        db.getDataPaket(model);
    }
}
