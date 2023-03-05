package billingsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginPage {
    private JPanel panelAdmin;
    private JTextField username;
    private JPasswordField password;
    private JLabel lbl_password;
    private JLabel lbl_username;
    private JButton btn_Login;
    private JButton btn_Cancel;
    private JLabel AdminLoginPage;

    public AdminLoginPage() {

        btn_Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("AdminLoginPage");
        frame.setContentPane(new AdminLoginPage().panelAdmin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
