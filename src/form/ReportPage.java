package form;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import helper.databaseHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReportPage extends JFrame {

    private JPanel panel1;
    private JLabel lbl_tanggal_mulai;
    private JLabel lbl_tanggal_akhir;
    private JButton btn_filter;
    private JTable table1;
    private JTable table2;

    private DefaultTableModel model;

    private DefaultTableModel model2;


    public ReportPage() {
        this.setVisible(true);
        this.setSize(1280, 800);
        this.setTitle("Sianjelau - Report Page");
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        /*
         * Background Image
         */
        ImageIcon image = new ImageIcon("src\\assets\\report_page.png");
        JLabel label = new JLabel(image);
        label.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));
        JPanel panel = (JPanel) this.getContentPane();
        panel.setOpaque(false);

        /*
         * lbl_tanggal_mulai
         */

        lbl_tanggal_mulai.setBounds(100, 100, 100, 100);
        lbl_tanggal_mulai.setOpaque(false);
        this.getLayeredPane().add(lbl_tanggal_mulai, 1);

        DatePickerSettings dateSettings = new DatePickerSettings();
        dateSettings.setFormatForDatesCommonEra("yyyy-MM-dd");
        dateSettings.setFormatForDatesBeforeCommonEra("yyyy-MM-dd");
        dateSettings.setAllowKeyboardEditing(false);
        dateSettings.setAllowEmptyDates(false);

        DatePicker datePicker = new DatePicker(dateSettings);
        datePicker.setBounds(100, 170, 200, 30);
        this.getLayeredPane().add(datePicker, 1);


        /*
         * lbl_tanggal_akhir
         */

        lbl_tanggal_akhir.setBounds(400, 100, 100, 100);
        lbl_tanggal_akhir.setOpaque(false);
        this.getLayeredPane().add(lbl_tanggal_akhir, 1);


        DatePickerSettings dateSettings2 = new DatePickerSettings();
        dateSettings2.setFormatForDatesCommonEra("yyyy-MM-dd");
        dateSettings2.setFormatForDatesBeforeCommonEra("yyyy-MM-dd");
        dateSettings2.setAllowKeyboardEditing(false);
        dateSettings2.setAllowEmptyDates(false);

        DatePicker datePicker2 = new DatePicker(dateSettings2);
        datePicker2.setBounds(400, 170, 200, 30);
        this.getLayeredPane().add(datePicker2, 1);

        /*
         * btn_filter
         */

        btn_filter.setBounds(700, 170, 200, 30);
        btn_filter.setForeground(new java.awt.Color(255, 255, 255));
        this.getLayeredPane().add(btn_filter, 1);

        /*
         * table1
         */
        table1.setBounds(90, 300, 800, 400);
        this.getLayeredPane().add(table1, 1);

        /*
         * JscrollPane
         */
        JScrollPane scrollPane = new JScrollPane(table1);
        scrollPane.setBounds(90, 300, 800, 400);
        this.getLayeredPane().add(scrollPane, 1);

        /*
         * table2
         */
        table2.setBounds(890, 300, 300, 400);
        this.getLayeredPane().add(table2, 2);

        /*
         * JscrollPane
         */
        JScrollPane scrollPane2 = new JScrollPane(table2);
        scrollPane2.setBounds(890, 300, 300, 400);
        this.getLayeredPane().add(scrollPane2, 2);


        btn_filter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String tanggal_mulai = datePicker.getText();
                String tanggal_akhir = datePicker2.getText();

                databaseHelper db = new databaseHelper();
                db.getTransaksibyDate(model, tanggal_mulai, tanggal_akhir);

            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table1.getSelectedRow();
                String id_detail_transaksi = table1.getValueAt(row, 5).toString();
                databaseHelper db = new databaseHelper();
                db.getDetailTrx(id_detail_transaksi, model2);
            }
        });
    }

    private void createUIComponents() {

        model = new DefaultTableModel();
        table1 = new JTable(model);
        model.addColumn("ID Transaksi");
        model.addColumn("Status Transaksi");
        model.addColumn("Nama Member");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("Status Proses");
        model.addColumn("id_detail_transaksi");
        model.addColumn("no_telp");

        databaseHelper db = new databaseHelper();
        db.getTransaksi(model);

        model2 = new DefaultTableModel();
        table2 = new JTable(model2);
        model2.addColumn("ID Paket");
        model2.addColumn("Nama Paket");
        model2.addColumn("Jenis Paket");
        model2.addColumn("Harga Paket");


    }
}
