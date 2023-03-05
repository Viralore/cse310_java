package billingsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginPage {
    private JLabel UserLoginPage;
    private JTextField username;
    private JPasswordField password;
    private JButton btn_Login;
    private JButton btn_Cancel;
public UserLoginPage() {
    btn_Cancel.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });

}

}
