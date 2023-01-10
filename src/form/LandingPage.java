package form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingPage extends JFrame {

    private JPanel panel1;
    private JButton loginButton;

    public LandingPage() {
        this.setVisible(true);
        this.setSize(1280, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Sianjelau - Landing Page");
        this.setLocationRelativeTo(null);
        this.setResizable(false);


        /*
         * Landing Image
         */
        ImageIcon image = new ImageIcon("src\\assets\\landing_page.gif");
        JLabel label = new JLabel(image);
        label.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        JPanel panel = (JPanel) this.getContentPane();
        panel.setOpaque(false);

        /*
         * Login Button
         */
        loginButton.setLocation(830, 600);
        loginButton.setSize(200, 32);
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setBorder(null);
        this.getLayeredPane().add(loginButton, new Integer(Integer.MAX_VALUE));


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                dispose();
            }
        });
    }

}
