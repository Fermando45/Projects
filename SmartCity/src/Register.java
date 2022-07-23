import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Register extends JFrame implements ActionListener, MouseListener {



    JFrame frame;

    JLabel Tirana;
    JLabel SmartCity;
    JLabel email;
    JLabel password;
    JLabel config;
    JLabel Login;
    JLabel Choose;

    JTextField Email;
    JTextField Password;
    JTextField Config;

    JComboBox module;

    JButton cancel;
    JButton Creat;
    Register(){
        Tirana=new JLabel("Tirana");
        Tirana.setBounds(100,10,150,50);
        Tirana.setForeground(new Color(204,0,0));
        Tirana.setFont(new Font("Times Roman",Font.BOLD,35));

        SmartCity =new JLabel("Smart City");
        SmartCity.setBounds(200,50,250,50);
        SmartCity.setForeground(new Color(0,0,0));
        SmartCity.setFont(new Font("MV Boli",Font.BOLD,35));

        email=new JLabel("Name:");
        email.setBounds(100,150,75,30);
        email.setFont(new Font("",Font.BOLD,15));

        Email=new JTextField();
        Email.setBounds(180,155,200,25);


        password=new JLabel("Password:");
        password.setBounds(100,190,75,30);
        password.setFont(new Font("",Font.BOLD,15));

        Password=new JTextField();
        Password.setBounds(180,195,200,25);

        config=new JLabel("Confirm Password:");
        config.setBounds(40,230,150,30);
        config.setFont(new Font("",Font.BOLD,15));

        Config=new JTextField();
        Config.setBounds(180,235,200,25);




        Choose=new JLabel("Choose a Module:");
        Choose.setBounds(45,270,150,30);
        Choose.setFont(new Font("",Font.BOLD,15));

        String [] Moduls={"Tourism","Student","Jobseekers","Business"};
        module=new JComboBox(Moduls);
        module.setBounds(180,275,100,25);

        Creat=new JButton("Create");
        Creat.setBounds(180,330,80,30);
        Creat.setFocusPainted(false);
        Creat.addActionListener(this);


        cancel=new JButton("Cancel");
        cancel.setBounds(300,330,80,30);
        cancel.setFocusPainted(false);
        cancel.addActionListener(this);


        Login=new JLabel("Login");
        Login.setBounds(260,400,80,30);
        Login.setFont(new Font("dssd",Font.BOLD,15));
        Login.addMouseListener(this);



        frame=new JFrame();

frame.setSize(500,550);
frame.setVisible(true);
frame.setResizable(false);
frame.setLayout(null);
frame.setTitle("Register");
frame.add(Tirana);
frame.add(SmartCity);
frame.add(email);
frame.add(Email);
frame.add(password);
frame.add(Password);
frame.add(config);
frame.add(Config);
frame.add(module);
frame.add(Choose);
frame.add(Creat);
frame.add(cancel);
frame.add(Login);


    }



























    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==cancel){

    Email.setText("");
    Password.setText("");
    Config.setText("");

    email.setForeground(Color.black);
    password.setForeground(Color.black);
    config.setForeground(Color.black);
}

if(e.getSource()==Creat ) {
    if (Email.getText().equals("")) email.setForeground(Color.RED);
    if (Password.getText().equals("")) password.setForeground(Color.RED);
    if (Config.getText().equals("")) config.setForeground(Color.RED);


    if (Password.getText().equals(Config.getText()) &&
    Password.getText().length()>=1) {


            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity", "root", "");
                String sql = "insert into tourisem(Email,Password)values(?,?)";
                String sql1 = "insert into student(Email,Password)values(?,?)";
                String sql2 = "insert into business(Email,Password)values(?,?)";
                String sql3 = "insert into jobseekers(Email,Password)values(?,?)";


                PreparedStatement pre = con.prepareStatement(sql);
                PreparedStatement pre1 = con.prepareStatement(sql1);
                PreparedStatement pre2 = con.prepareStatement(sql2);
                PreparedStatement pre3 = con.prepareStatement(sql3);

                pre.setString(1, Email.getText());
                pre.setString(2, Password.getText());

                pre1.setString(1, Email.getText());
                pre1.setString(2, Password.getText());

                pre2.setString(1, Email.getText());
                pre2.setString(2, Password.getText());

                pre3.setString(1, Email.getText());
                pre3.setString(2, Password.getText());
                if(module.getSelectedIndex()==0) {
                    pre.executeUpdate();
                    new Login();
                }else if(module.getSelectedIndex()==1) {
                    pre1.executeUpdate();
                    new Login();

                }else if(module.getSelectedIndex()==2){
                    pre3.executeUpdate();
                    new Login();

                }else if(module.getSelectedIndex()==3){
                    pre2.executeUpdate();
                    new Login();

                }

                //JOptionPane.showMessageDialog(null,"Update to tourisem");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);




    }
       /* if (e.getSource()==Creat && module.getSelectedIndex() == 1) {
            if (Email.getText().equals("")) email.setForeground(Color.RED);
            if (Password.getText().equals("")) password.setForeground(Color.RED);
            if (Config.getText().equals("")) config.setForeground(Color.RED);


            if (Password.getText().equals(Config.getText()) &&
                    Password.getText().length()>=1) {

                try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity", "root", "");
                String sql = "insert into student(Email,Password)values(?,?)";
                PreparedStatement pre = con.prepareStatement(sql);
                pre.setString(1, Email.getText());
                pre.setString(2, Password.getText());
                pre.executeUpdate();
                JOptionPane.showMessageDialog(null,"Update to Student");


            } catch (Exception ex) {
                    // JOptionPane.showMessageDialog(null, ex);

                }
            }
            if (e.getSource()==Creat && module.getSelectedIndex() == 2) {
                if (Email.getText().equals("")) email.setForeground(Color.RED);
                if (Password.getText().equals("")) password.setForeground(Color.RED);
                if (Config.getText().equals("")) config.setForeground(Color.RED);


                if (Password.getText().equals(Config.getText()) &&
                        Password.getText().length()>=1) {

                    try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity", "root", "");
                    String sql = "insert into jobseekers(Email,Password)values(?,?)";
                    PreparedStatement pre = con.prepareStatement(sql);
                    pre.setString(1, Email.getText());
                    pre.setString(2, Password.getText());
                    pre.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Update to Jobseekers");

                } catch (Exception ex) {
                        //   JOptionPane.showMessageDialog(null, ex);
                    }

                }
                if (e.getSource()==Creat && module.getSelectedIndex() == 3) {
                    if (Email.getText().equals("")) email.setForeground(Color.RED);
                    if (Password.getText().equals("")) password.setForeground(Color.RED);
                    if (Config.getText().equals("")) config.setForeground(Color.RED);


                    if (Password.getText().equals(Config.getText()) &&
                            Password.getText().length()>=1) {

                        try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity", "root", "");
                        String sql = "insert into business(Email,Password)values(?,?)";
                        PreparedStatement pre = con.prepareStatement(sql);
                        pre.setString(1, Email.getText());
                        pre.setString(2, Password.getText());
                        pre.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Update to business");

                    } catch (Exception ex) {
                            //     JOptionPane.showMessageDialog(null, ex);

                        }
                    }

                }
            }

        }
    }else{
        password.setForeground(Color.red);
        config.setForeground(Color.red);
        JOptionPane.showMessageDialog(null,"Your configuration is wrong");

        */
    }else{
        password.setForeground(Color.red);
        config.setForeground(Color.red);
        JOptionPane.showMessageDialog(null,"Your registration is wrong pleas check the passwords or if you let somthing without typing");

    }







    }










  /*  if (module.getSelectedIndex() == 0) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity", "root", "");
            String sql = "insert into tourisem(Email,Password),values(?,?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, Email.getText());
            pre.setString(2, Password.getText());
            pre.executeUpdate();
            new Login();

        } catch (Exception ex) {
           // JOptionPane.showMessageDialog(null, ex);


        }

    }
    if (module.getSelectedIndex() == 1) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity", "root", "");
            String sql = "insert into student(Email,Password)values(?,?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, Email.getText());
            pre.setString(2, Password.getText());
            pre.executeUpdate();
            new Login();


        } catch (Exception ex) {
           // JOptionPane.showMessageDialog(null, ex);


        }
        if (module.getSelectedIndex() == 2) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity", "root", "");
                String sql = "insert into jobseekers(Email,Password)values(?,?)";
                PreparedStatement pre = con.prepareStatement(sql);
                pre.setString(1, Email.getText());
                pre.setString(2, Password.getText());
                pre.executeUpdate();
                new Login();

            } catch (Exception ex) {
              //  JOptionPane.showMessageDialog(null, ex);


            }
            if (module.getSelectedIndex() == 3) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity", "root", "");
                    String sql = "insert into business(Email,Password)values(?,?)";
                    PreparedStatement pre = con.prepareStatement(sql);
                    pre.setString(1, Email.getText());
                    pre.setString(2, Password.getText());
                    pre.executeUpdate();
                    new Login();

                } catch (Exception ex) {
                   // JOptionPane.showMessageDialog(null, ex);


                }

            }
        }

    }


}
*/




    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==Login){

            new Login();




        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
