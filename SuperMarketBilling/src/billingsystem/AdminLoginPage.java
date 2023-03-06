package billingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdminLoginPage extends JDialog {
    private JPanel panelAdmin;
    private JTextField username;
    private JPasswordField password1;
    private JLabel lbl_password;
    private JLabel lbl_username;
    private JButton btn_Login;
    private JButton btn_Cancel;
    private JLabel AdminLoginPage;

    public AdminLoginPage(JFrame parent) {
        super(parent);
        setTitle("ADMIN Login");
        setContentPane(panelAdmin);
        setMinimumSize(new Dimension(500,500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        btn_Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btn_Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = username.getText();
                String password = String.valueOf(password1.getPassword());

                user1 = getAuthenticatedUser(email,password);

                if(user1 !=null)
                {
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(AdminLoginPage.this,"Invalid email or password", "Try again", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        setVisible(true);
    }

    public AdminClass user1;
    private AdminClass getAuthenticatedUser(String email,String password)
    {
        AdminClass user1 = null;

        final String DB_URL = "jdbc:mysql://localhost/supermarketbillingsystem?serverTimezone=UTC";
        final String USERNAME = "admin";
        final String PASSWORD = "";

        try
        {
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                user1 = new AdminClass();
                user1.name = resultSet.getString("name");
                user1.email = resultSet.getString("email");
                user1.phone = resultSet.getString("phone");
                user1.password = resultSet.getString("password");
            }
            stmt.close();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return user1;
    }

    public static void main(String[] args)
    {
        billingsystem.AdminLoginPage admin_form = new AdminLoginPage(null);
        AdminClass user1 = admin_form.user1;
        if(user1 != null)
        {
            System.out.println("Success");
        }
        else
        {
            System.out.println("Error");
        }
    }
}
