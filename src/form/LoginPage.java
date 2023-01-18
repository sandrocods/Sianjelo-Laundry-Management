package form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import helper.databaseHelper;

public class LoginPage extends JFrame {

    private JPanel panel1;
    private JButton btn_login;
    private JButton registerButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel loginLabel;
    private JLabel registerLabel;
    private JLabel loginImage;
    private JLabel registerImage;
    private JLabel background;
    private JTextField txt_username;
    private JPasswordField txt_password;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private JCheckBox cb_show_password;

    public LoginPage() {
        this.setVisible(true);
        this.setSize(1280, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Sianjelau - Login Page");
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        /*
         * Background Image
         */
        ImageIcon image = new ImageIcon("src\\assets\\login_page.gif");
        JLabel label = new JLabel(image);
        label.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));
        JPanel panel = (JPanel) this.getContentPane();
        panel.setOpaque(false);

        /*
         * Label Username
         */
        lbl_username = new JLabel("Username");
        lbl_username.setBounds(850, 330, 100, 20);
        this.getLayeredPane().add(lbl_username, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Text Field Username
         */
        txt_username = new JTextField();
        txt_username.setBounds(850, 350, 300, 25);
        txt_username.setBorder(null);
        this.getLayeredPane().add(txt_username, Integer.valueOf(Integer.MAX_VALUE));


        /*
         * Label Password
         */
        lbl_password = new JLabel("Password");
        lbl_password.setBounds(850, 380, 100, 20);
        this.getLayeredPane().add(lbl_password, Integer.valueOf(Integer.MAX_VALUE));


        /*
         * Text Field Password
         */
        txt_password = new JPasswordField();
        txt_password.setBounds(850, 400, 300, 25);
        txt_password.setBorder(null);
        this.getLayeredPane().add(txt_password, Integer.valueOf(Integer.MAX_VALUE));

        /*
         * Check Box Show Password
         */
        cb_show_password.setBounds(850, 430, 300, 20);
        cb_show_password.setBorder(null);
        this.getLayeredPane().add(cb_show_password, Integer.valueOf(Integer.MAX_VALUE));


        /*
         * Button Login
         */
        btn_login.setBounds(870, 470, 250, 32);
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setBorder(null);
        this.getLayeredPane().add(btn_login, Integer.valueOf(Integer.MAX_VALUE));


        cb_show_password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cb_show_password.isSelected()) {
                    txt_password.setEchoChar((char) 0);
                    cb_show_password.setText("Hide Password");
                } else {
                    txt_password.setEchoChar('*');
                    cb_show_password.setText("Show Password");
                }
            }
        });

        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = txt_username.getText();
                String password = txt_password.getText();


                if (username.equals("") || password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Silahkan isi semua fields", "Login - Error", JOptionPane.WARNING_MESSAGE);
                    txt_username.requestFocus();
                } else {
                    boolean status_login = databaseHelper.login(username, password);
                    if (status_login) {
                        JOptionPane.showMessageDialog(null, "Login Berhasil", "Login - Success", JOptionPane.INFORMATION_MESSAGE);


                        dispose();
                        new DashboardPage(
                                username,
                                password
                        );


                    } else {
                        JOptionPane.showMessageDialog(null, "Login Gagal Pastikan Username & Password anda benar", "Login - Error", JOptionPane.ERROR_MESSAGE);
                        txt_username.setText("");
                        txt_password.setText("");
                        txt_username.requestFocus();
                    }
                }

            }
        });
    }


}
