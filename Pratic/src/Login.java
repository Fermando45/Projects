import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements MouseListener,ActionListener {



JFrame frame;
JLabel pas;
JLabel use;
JLabel cre;
JButton log;
JButton can;
JTextField t1;
JTextField t2;
Login(){



    cre=new JLabel("Create a new account");
    cre.setFont(new Font(null,Font.BOLD,15));
    cre.setBounds(150,350,200,14);
    cre.addMouseListener(this);
    cre.setForeground(Color.WHITE);


    log=new JButton("Login");
    log.setFocusPainted(true);
    log.setBounds(150,300,75,30);
    log.addActionListener(this);
    log.setBackground(Color.CYAN);

    can=new JButton("Cancel");
    can.setFocusPainted(false);
    can.setBounds(230,300,75,30);
    can.addActionListener(this);
    can.setBackground(Color.ORANGE);

    pas=new JLabel("Password:");
    pas.setBounds(50,190,75,25);
    pas.setForeground(Color.WHITE);

    use=new JLabel("Username:");
    use.setBounds(50,150,75,25);
    use.setForeground(Color.WHITE);

    t1=new JTextField();
    t1.setBounds(125,150,200,25);

    t2=new JTextField();
    t2.setBounds(125,190,200,25);





    this.setLayout(null);
  this.setResizable(false);
  this.setVisible(true);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.getContentPane().setBackground(Color.DARK_GRAY);
  this.setSize(500,500);
  this.setTitle("Login Form");
 this.add(cre);
 this.add(log);
 this.add(can);
this.add(pas);
this.add(use);
this.add(t1);
    this.add(t2);



}


    @Override
    public void mouseClicked(MouseEvent e) {
    new Register();
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


    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==can){
        t1.setText("");
        t2.setText("");
    }
    if(e.getSource()==log){
       try {
Class.forName("com.mysql.jdbc.Driver");
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/andi","root","");
String sql="Select * from data where Username=? and Password=?";
           PreparedStatement pre=con.prepareStatement(sql);
           pre.setString(1,t1.getText());
           pre.setString(1,t2.getText());
           pre.setString(2,t1.getText());
           pre.setString(2,t2.getText());
           ResultSet st=pre.executeQuery();
               if(st.next()) {

                   new Book();

               }else{

                   JOptionPane.showMessageDialog(null,"Invalide user");
               }
//con.close();



       }
           catch(Exception er){

JOptionPane.showMessageDialog(null,er);


       }



    }

    }
}


