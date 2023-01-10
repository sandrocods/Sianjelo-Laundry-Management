package form;

import helper.databaseHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class DashboardPage extends JFrame {


    private JPanel panel1;
    private JLabel lbl_username;
    private JButton btn_manage_user;
    private JButton btn_logout_user;
    private JButton btn_test;

    public DashboardPage(String username, String password) {
        this.setVisible(true);
        this.setSize(1280, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Sianjelau - Dashboard Page");
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        /*
         * Background Image
         */
        ImageIcon image = new ImageIcon("src\\assets\\dashboard_page.gif");
        JLabel label = new JLabel(image);
        label.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));
        JPanel panel = (JPanel) this.getContentPane();
        panel.setOpaque(false);


        /*
         * Label Username
         */

        lbl_username = new JLabel("Welcome, " + username);
        lbl_username.setBounds(840, 40, 300, 20);
        lbl_username.setFont(new java.awt.Font("", 0, 20));
        this.getLayeredPane().add(lbl_username, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Logika Role User
         */
        String Role_user = databaseHelper.getRole(username, password);

        if (Objects.equals(Role_user, "admin")) { // Logika Role User Admin

            /*
             * Button Manage User Aktif
             */
            ImageIcon icon = new ImageIcon("src\\assets\\icon_manage_user.png");
            btn_manage_user.setIcon(icon);
            btn_manage_user.setForeground(new java.awt.Color(255, 255, 255));
            btn_manage_user.setBounds(0, 135, 295, 35);
            btn_manage_user.setVisible(true);
            this.getLayeredPane().add(btn_manage_user, Integer.valueOf(Integer.MAX_VALUE));


        } else if (Objects.equals(Role_user, "karyawan")) { // Logika Role User Karyawan


        } else if (Objects.equals(Role_user, "kurir")) { // Logika Role User Kurir


        }

        ImageIcon icon = new ImageIcon("src\\assets\\icon_logout_user.png");
        btn_logout_user.setIcon(icon);
        btn_logout_user.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout_user.setBounds(0, 700, 295, 35);
        btn_logout_user.setVisible(true);
        this.getLayeredPane().add( btn_logout_user, Integer.valueOf(Integer.MAX_VALUE));


        btn_logout_user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LandingPage();
                dispose();
            }
        });
    }
}
