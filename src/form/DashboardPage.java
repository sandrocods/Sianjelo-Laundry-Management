package form;

import helper.databaseHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public class DashboardPage extends JFrame {


    private JPanel panel1;
    private JLabel lbl_username;
    private JButton btn_manage_user;
    private JButton btn_logout_user;
    private JLabel lbl_total_user;
    private JButton btn_manage_member;
    private JLabel lbl_total_member;
    private JButton btn_manage_paket;
    private JButton btn_transaksi;
    private JLabel lbl_total_pendapatan;
    private JLabel lbl_proses_selesai;
    private JLabel lbl_proses_pengerjaan;
    private JButton btn_update_transaksi;
    private JButton btn_laporan;
    private JButton btn_setting_app;
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
        lbl_username.setForeground(new java.awt.Color(41, 65, 114));
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

            /*
             * Button Manage Member Aktif
             */
            ImageIcon icon2 = new ImageIcon("src\\assets\\icon_manage_member.png");
            btn_manage_member.setIcon(icon2);
            btn_manage_member.setForeground(new java.awt.Color(255, 255, 255));
            btn_manage_member.setBounds(0, 190, 295, 35);
            btn_manage_member.setVisible(true);
            this.getLayeredPane().add(btn_manage_member, Integer.valueOf(Integer.MAX_VALUE));

            /*
             * Button Manage Paket Aktif
             */
            ImageIcon icon3 = new ImageIcon("src\\assets\\icon_manage_paket.png");
            btn_manage_paket.setIcon(icon3);
            btn_manage_paket.setForeground(new java.awt.Color(255, 255, 255));
            btn_manage_paket.setBounds(0, 245, 295, 35);
            btn_manage_paket.setVisible(true);
            this.getLayeredPane().add(btn_manage_paket, Integer.valueOf(Integer.MAX_VALUE));

            /*
             * Button Transaksi Aktif
             */
            ImageIcon icon4 = new ImageIcon("src\\assets\\icon_transaksi.png");
            btn_transaksi.setIcon(icon4);
            btn_transaksi.setForeground(new java.awt.Color(255, 255, 255));
            btn_transaksi.setBounds(0, 300, 295, 35);
            btn_transaksi.setVisible(true);
            this.getLayeredPane().add(btn_transaksi, Integer.valueOf(Integer.MAX_VALUE));

            /*
             * Button Update Transaksi Aktif
             */
            ImageIcon icon5 = new ImageIcon("src\\assets\\icon_update_transaksi.png");
            btn_update_transaksi.setIcon(icon5);
            btn_update_transaksi.setForeground(new java.awt.Color(255, 255, 255));
            btn_update_transaksi.setBounds(0, 355, 295, 35);
            btn_update_transaksi.setVisible(true);
            this.getLayeredPane().add(btn_update_transaksi, Integer.valueOf(Integer.MAX_VALUE));

            /*
             * Button Laporan Aktif
             */
            ImageIcon icon6 = new ImageIcon("src\\assets\\icon_report.png");
            btn_laporan.setIcon(icon6);
            btn_laporan.setForeground(new java.awt.Color(255, 255, 255));
            btn_laporan.setBounds(0, 410, 295, 35);
            btn_laporan.setVisible(true);
            this.getLayeredPane().add(btn_laporan, Integer.valueOf(Integer.MAX_VALUE));

            /*
             * Button Setting App Aktif
             */
            ImageIcon icon7 = new ImageIcon("src\\assets\\icon_setting_app.png");
            btn_setting_app.setIcon(icon7);
            btn_setting_app.setForeground(new java.awt.Color(255, 255, 255));
            btn_setting_app.setBounds(0, 465, 295, 35);
            btn_setting_app.setVisible(true);
            this.getLayeredPane().add(btn_setting_app, Integer.valueOf(Integer.MAX_VALUE));


        } else if (Objects.equals(Role_user, "karyawan")) { // Logika Role User Karyawan
            /*
             * Button Transaksi Aktif
             */
            ImageIcon icon4 = new ImageIcon("src\\assets\\icon_transaksi.png");
            btn_transaksi.setIcon(icon4);
            btn_transaksi.setForeground(new java.awt.Color(255, 255, 255));
            btn_transaksi.setBounds(0, 300, 295, 35);
            btn_transaksi.setVisible(true);
            this.getLayeredPane().add(btn_transaksi, Integer.valueOf(Integer.MAX_VALUE));

            /*
             * Button Update Transaksi Aktif
             */
            ImageIcon icon5 = new ImageIcon("src\\assets\\icon_update_transaksi.png");
            btn_update_transaksi.setIcon(icon5);
            btn_update_transaksi.setForeground(new java.awt.Color(255, 255, 255));
            btn_update_transaksi.setBounds(0, 355, 295, 35);
            btn_update_transaksi.setVisible(true);
            this.getLayeredPane().add(btn_update_transaksi, Integer.valueOf(Integer.MAX_VALUE));

            ImageIcon icon2 = new ImageIcon("src\\assets\\icon_manage_member.png");
            btn_manage_member.setIcon(icon2);
            btn_manage_member.setForeground(new java.awt.Color(255, 255, 255));
            btn_manage_member.setBounds(0, 190, 295, 35);
            btn_manage_member.setVisible(true);
            this.getLayeredPane().add(btn_manage_member, Integer.valueOf(Integer.MAX_VALUE));

        } else if (Objects.equals(Role_user, "kurir")) { // Logika Role User Kurir


        }

        ImageIcon icon = new ImageIcon("src\\assets\\icon_logout_user.png");
        btn_logout_user.setIcon(icon);
        btn_logout_user.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout_user.setBounds(0, 700, 295, 35);
        btn_logout_user.setVisible(true);
        this.getLayeredPane().add(btn_logout_user, Integer.valueOf(Integer.MAX_VALUE));



        /*
         * Threading
         */

        databaseHelper db = new databaseHelper();
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        nf.setMaximumFractionDigits(0);
        Thread thread = new Thread(() -> {
            while (true) {
                lbl_total_user.setText(db.getTotalUser());
                lbl_total_member.setText(db.getTotalMember());

                try{
                    int pendapatan = Integer.parseInt(db.getPendapatanHarian());
                    lbl_total_pendapatan.setText(nf.format(pendapatan));
                } catch (Exception e){
                    lbl_total_pendapatan.setText("Rp. 0");
                }

                lbl_proses_selesai.setText(db.getTotalProsesSelesai());
                lbl_proses_pengerjaan.setText(db.getTotalProsesPengerjaan());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        /*
         * lbl_proses_selesai
         */
        lbl_proses_selesai.setFont(new java.awt.Font("", 0, 70));
        lbl_proses_selesai.setBounds(740, 390, 100, 100);
        lbl_proses_selesai.setForeground(new java.awt.Color(41, 65, 114));
        this.getLayeredPane().add(lbl_proses_selesai, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * lbl_proses_pengerjaan
         */
        lbl_proses_pengerjaan.setFont(new java.awt.Font("", 0, 70));
        lbl_proses_pengerjaan.setBounds(480, 390, 100, 100);
        lbl_proses_pengerjaan.setForeground(new java.awt.Color(41, 65, 114));
        this.getLayeredPane().add(lbl_proses_pengerjaan, Integer.valueOf(Integer.MAX_VALUE));



        /*
         * Label Total User
         */

        lbl_total_user.setBounds(480, 80, 300, 300);
        lbl_total_user.setFont(new java.awt.Font("", 0, 70));
        lbl_total_user.setForeground(new java.awt.Color(41, 65, 114));
        this.getLayeredPane().add(lbl_total_user, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Label Total Member
         */


        lbl_total_member.setBounds(1080, 80, 300, 300);
        lbl_total_member.setFont(new java.awt.Font("", 0, 70));
        lbl_total_member.setForeground(new java.awt.Color(41, 65, 114));
        this.getLayeredPane().add(lbl_total_member, Integer.valueOf(Integer.MAX_VALUE));


        lbl_total_pendapatan.setBounds(740, 80, 300, 300);
        lbl_total_pendapatan.setFont(new java.awt.Font("", 0, 29));
        lbl_total_pendapatan.setForeground(new java.awt.Color(41, 65, 114));
        this.getLayeredPane().add(lbl_total_pendapatan, Integer.valueOf(Integer.MAX_VALUE));

        btn_logout_user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LandingPage();
                dispose();
            }
        });
        btn_manage_user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManageUserPage();

            }
        });
        btn_manage_member.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManageMemberPage();

            }
        });
        btn_manage_paket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PacketPage();

            }
        });
        btn_transaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TransaksiPage(
                        username
                );

            }
        });
        btn_update_transaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateTransaksiPage(

                );
            }
        });
        btn_laporan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new ReportPage(

                );

            }
        });
        btn_setting_app.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SettingPage(

                );
            }
        });
    }
}
