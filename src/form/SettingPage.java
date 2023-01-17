package form;

import helper.databaseHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingPage extends JFrame {
    private JLabel lbl_aktif_whatsapp;
    private JCheckBox cb_aktif_whatsapp;
    private JTextField txt_api_endpoint;
    private JButton btn_simpan;
    private JLabel lbl_api_endpoint;

    public SettingPage() {
        this.setVisible(true);
        this.setSize(1280, 800);
        this.setTitle("Sianjelau - Setting Page");
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        /*
         * Background Image
         */
        ImageIcon image = new ImageIcon("src\\assets\\setting_aplikasi_page.png");
        JLabel label = new JLabel(image);
        label.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));
        JPanel panel = (JPanel) this.getContentPane();
        panel.setOpaque(false);

        /*
         * Label
         */

        lbl_aktif_whatsapp.setBounds(100, 130, 200, 30);
        this.getLayeredPane().add(lbl_aktif_whatsapp, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Checkbox
         */

        cb_aktif_whatsapp.setBounds(300, 130, 300, 30);
        this.getLayeredPane().add(cb_aktif_whatsapp, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * label api endpoint
         */

        lbl_api_endpoint.setBounds(100, 190, 200, 20);
        this.getLayeredPane().add(lbl_api_endpoint, Integer.valueOf(Integer.MAX_VALUE));


        /*
         * Text Field
         */

        txt_api_endpoint.setBounds(100, 230, 500, 20);
        this.getLayeredPane().add(txt_api_endpoint, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Button
         */

        btn_simpan.setBounds(400, 330, 150, 20);
        btn_simpan.setBorder(null);
        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        this.getLayeredPane().add(btn_simpan, Integer.valueOf(Integer.MAX_VALUE));

        databaseHelper db = new databaseHelper();
        db.getSettingApp(
                cb_aktif_whatsapp,
                txt_api_endpoint
        );


        btn_simpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                db.updateSettingApp(
                        cb_aktif_whatsapp,
                        txt_api_endpoint
                );
                JOptionPane.showMessageDialog(null, "Setting berhasil disimpan");
            }
        });
    }
}
