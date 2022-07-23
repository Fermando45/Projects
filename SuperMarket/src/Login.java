import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JFrame frame;

    JPanel des;

    JLabel icon;
    JLabel description;
    JLabel login;
    JLabel icon2;
    JLabel Select;
    JLabel Name;
    JLabel Pass;

    JComboBox Role;

    JTextField name;
    JPasswordField pass;

    JButton Log;
    JButton Cancle;


    Login() {
        ImageIcon Icon = new ImageIcon("209497-200.png");
        Image ima = Icon.getImage();
        Image scaleimage = ima.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        icon = new JLabel();
        icon.setIcon(Icon);
        icon.setBounds(150, 50, 65, 65);
        description = new JLabel("Everything you need in one place");
        description.setBounds(0, 110, 100, 75);
        description.setFont(new Font("sdfv", Font.BOLD, 17));
        description.setForeground(Color.BLACK);
        des = new JPanel();
        des.setBackground(new Color(55, 223, 50));
        des.setBounds(0, 0, 350, 500);
        //des.setLayout(null);
        des.add(icon);
        des.add(description);

        login = new JLabel("LOGIN");
        login.setFont(new Font("df", Font.BOLD, 20));
        login.setBounds(550, 2, 100, 75);
        login.setForeground(new Color(55, 223, 50));

        ImageIcon Icon2 = new ImageIcon("green-shopping-cart-icon-604165.png");
        Image ima2 = Icon2.getImage();
        Image Ima2 = ima2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Icon2 = new ImageIcon(Ima2);
        icon2 = new JLabel();
        icon2.setIcon(Icon2);
        icon2.setBounds(550, 50, 100, 100);

        Select = new JLabel("Select Role:");
        Select.setForeground(new Color(55, 223, 50));
        Select.setBounds(380, 170, 100, 25);
        Select.setFont(new Font("Sd", Font.BOLD, 15));
        String[] role = {"Admin", "Seller"};
        Role = new JComboBox<>(role);
        Role.setBounds(500, 170, 130, 25);

        Name = new JLabel("Name:");
        Name.setForeground(new Color(55, 223, 50));
        Name.setBounds(420, 220, 100, 25);
        Name.setFont(new Font("Sd", Font.BOLD, 15));
        name = new JTextField();
        name.setBounds(500, 220, 200, 25);
        name.setForeground(new Color(55, 223, 50));

        Pass = new JLabel("Password:");
        Pass.setForeground(new Color(55, 223, 50));
        Pass.setBounds(390, 270, 100, 25);
        Pass.setFont(new Font("Sd", Font.BOLD, 15));
        pass = new JPasswordField();
        pass.setBounds(500, 270, 200, 25);
        pass.setForeground(new Color(55, 223, 50));

        Log = new JButton("Log in");
        Log.setForeground(Color.WHITE);
        Log.setBackground(new Color(53, 223, 50));
        Log.setBounds(470, 320, 75, 25);
        Log.setFocusPainted(false);
        Log.addActionListener(this);

        Cancle = new JButton("Cancle");
        Cancle.setForeground(Color.WHITE);
        Cancle.setBackground(new Color(53, 223, 50));
        Cancle.setBounds(600, 320, 75, 25);
        Cancle.setFocusPainted(false);
        Cancle.addActionListener(this);

        frame = new JFrame("Log in");
        frame.setSize(800, 500);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(icon2);
        frame.add(des);
        frame.add(login);
        frame.add(Select);
        frame.add(Role);
        frame.add(Name);
        frame.add(name);
        frame.add(Pass);
        frame.add(pass);
        frame.add(Log);
        frame.add(Cancle);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Cancle) {

            name.setText("");
            pass.setText("");

        }
        if (e.getSource() == Log) {
            if (Role.getSelectedIndex() == 0) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "");
                    String sql = "Select * from admin where Name=? and Password=?";
                    PreparedStatement pre = con.prepareStatement(sql);
                    pre.setString(1, name.getText());
                    pre.setString(2, pass.getText());
                    ResultSet st = pre.executeQuery();
                    if (st.next()) {
new MainAdmin();
frame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalide User");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            }
            if(Role.getSelectedIndex()==1){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "");
                    String sql = "Select * from seller where Name=? and Password=?";
                    PreparedStatement pre = con.prepareStatement(sql);
                    pre.setString(1, name.getText());
                    pre.setString(2, pass.getText());
                    ResultSet st = pre.executeQuery();
                    if (st.next()) {
new Seller();
frame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalide User");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            }


            }


            /*
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "");

                String sql = "Select * from admin where Name=? and Password=? ";
                String sql1 = "Select * from seller where Name=? and Password=? ";

                PreparedStatement pre = con.prepareStatement(sql);
                PreparedStatement pre1 = con.prepareStatement(sql1);

                pre.setString(1, name.getText());
                pre.setString(2, pass.getText());

                pre1.setString(1, name.getText());
                pre1.setString(2, pass.getText());

                ResultSet st = pre.executeQuery();
                ResultSet st1 = pre1.executeQuery();
                if (Role.getSelectedIndex() == 0 && st.next()) {
                    JOptionPane.showMessageDialog(null, "Admin Login");
                } else if (Role.getSelectedIndex() == 1 && st1.next()) {

                    JOptionPane.showMessageDialog(null, "Seller Login");

                } else {
                    JOptionPane.showMessageDialog(null, "Invalide user");

                }


            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);

            }


             */

        }
    }
