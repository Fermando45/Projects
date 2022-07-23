import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener, MouseListener {

JFrame frame;

JLabel Tirana;
JLabel SmartCity;
JLabel Login;
JLabel Password;
JLabel Register;

JComboBox Module;

JButton login;
JButton cancle;


JTextField l;
JTextField p;



Login(){

Tirana=new JLabel("Tirana");
Tirana.setBounds(100,10,150,50);
Tirana.setForeground(new Color(204,0,0));
Tirana.setFont(new Font("Times Roman",Font.BOLD,35));

SmartCity =new JLabel("Smart City");
SmartCity.setBounds(200,50,250,50);
SmartCity.setForeground(new Color(0,0,0));
SmartCity.setFont(new Font("MV Boli",Font.BOLD,35));



Login=new JLabel("Name:");
Login.setBounds(100,200,75,30);
Login.setFont(new Font("Romans",Font.BOLD,15));


l=new JTextField();
l.setBounds(180,205,200,25);





Password=new JLabel("Password:");
Password.setBounds(100,240,100,25);
Password.setFont(new Font("Romans",Font.BOLD,15));


p=new JTextField();
p.setBounds(180,240,200,25);

login=new JButton("Login");
login.addActionListener(this);
login.setBounds(180,300,80,30);
login.setFocusPainted(false);




cancle=new JButton("Cancle");
cancle.setBounds(300,300,80,30);
cancle.setFocusPainted(false);
cancle.addActionListener(this);

Register=new JLabel("Register");
Register.setBounds(250,350,80,30);
Register.setForeground(Color.BLACK);
Register.addMouseListener(this);



    frame=new JFrame();
    frame.setSize(600,500);
    frame.setLayout(null);
    frame.setTitle("Smart city Tirana");
    frame.setVisible(true);
    frame.setResizable(false);
    frame.add(Tirana);
    frame.add(SmartCity);
    frame.add(Login);
    frame.add(Password);
    frame.add(l);
    frame.add(p);
    frame.add(login);
    frame.add(cancle);
    frame.add(Register);


}





















    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity", "root", "");
                String sql = "Select * from student where Email=? and Password=?";
                String sql1 = "Select * from tourisem where Email=? and Password=?";
                String sql2 = "Select * from business where Email=? and Password=?";
                String sql3 = "Select * from jobseekers where Email=? and Password=?";
                String sql4 = "Select * from admin where Email=? and Password=?";


                PreparedStatement pre = con.prepareStatement(sql);
                PreparedStatement pre1 = con.prepareStatement(sql1);
                PreparedStatement pre2 = con.prepareStatement(sql2);
                PreparedStatement pre3 = con.prepareStatement(sql3);
                PreparedStatement pre4 = con.prepareStatement(sql4);

                pre.setString(1, l.getText());
                pre.setString(2, p.getText());

                pre1.setString(1, l.getText());
                pre1.setString(2, p.getText());

                pre2.setString(1, l.getText());
                pre2.setString(2, p.getText());

                pre3.setString(1, l.getText());
                pre3.setString(2, p.getText());

                pre4.setString(1, l.getText());
                pre4.setString(2, p.getText());

                ResultSet st = pre.executeQuery();
                ResultSet st1 = pre1.executeQuery();
                ResultSet st2 = pre2.executeQuery();
                ResultSet st3 = pre3.executeQuery();
                ResultSet st4 = pre4.executeQuery();

                if (st.next()){
                    new Student();
            }else if (st1.next()) {
                new Tourisem();
                }else if (st2.next()) {
                    new Business();
                }else if (st3.next()) {
                    new Jobseekers();
                }else if (st4.next()) {
                    new Admin();
            } else {
                JOptionPane.showMessageDialog(null, "Invalide User");
            }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

        }
            if (e.getSource() == cancle) {

                l.setText("");
                p.setText("");


            }
        }

    @Override
    public void mouseClicked(MouseEvent e) {
if(e.getSource()==Register){

    new Register();

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
