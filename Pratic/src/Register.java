import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.Arrays;

public class Register extends JFrame implements ActionListener, MouseListener {
JLabel l1;
JLabel l2;
JLabel l3;
JLabel l4;
JLabel l5;
JLabel l6;
JLabel l7;
JLabel l8;


    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JTextField t5;
    JTextField t7;

    JComboBox c6;

    JButton can;
    JButton cre;


    Register(){

l1=new JLabel();
l1.setBounds(50,100,75,25);
l1.setText("First name:");
l1.setForeground(Color.WHITE);

t1=new JTextField();
t1.setBounds(130,100,220,25);


l2=new JLabel();
l2.setBounds(50,140,75,25);
l2.setText("Last name:");
        l2.setForeground(Color.WHITE);

        t2=new JTextField();
        t2.setBounds(130,140,220,25);


l3=new JLabel();
l3.setBounds(50,180,75,25);
l3.setText("Username:");
        l3.setForeground(Color.WHITE);


        t3=new JTextField();
        t3.setBounds(130,180,220,25);

        l4=new JLabel();
        l4.setBounds(50,220,75,25);
        l4.setText("Password:");
        l4.setForeground(Color.WHITE);


        t4=new JTextField();
        t4.setBounds(130,220,220,25);

        l5=new JLabel();
        l5.setBounds(1,260,130,25);
        l5.setText("Confirme password:");
        l5.setForeground(Color.WHITE);


        t5=new JTextField();
        t5.setBounds(130,260,220,25);

        l6=new JLabel();
        l6.setBounds(50,300,75,25);
        l6.setText("Birthdate:");
        l6.setForeground(Color.WHITE);



        String[]years={"","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022"};
        c6=new JComboBox(years);
        c6.setBounds(130,300,75,25);


        l7=new JLabel();
        l7.setBounds(50,340,75,25);
        l7.setText("Address:");
        l7.setForeground(Color.WHITE);

        t7=new JTextField();
        t7.setBounds(130,340,220,25);

        can=new JButton("Cancel");
        can.setBounds(150,380,75,30);
        can.setFocusPainted(false);
        can.addActionListener(this);
        can.setBackground(Color.ORANGE);

        cre=new JButton("Create");
        cre.setFocusPainted(false);
        cre.setBounds(250,380,75,30);
        cre.addActionListener(this);
        cre.setBackground(Color.CYAN);

        l8=new JLabel("Click here to log in");
        l8.setBounds(175,430,108,25);
        l8.addMouseListener(this);
        l8.setForeground(Color.WHITE);






        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(450,550);
        this.setTitle("Register");
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(l4);
        this.add(l5);
        this.add(l6);
        this.add(l7);
        this.add(t1);
        this.add(t2);
        this.add(t3);
        this.add(t4);
        this.add(t5);
        this.add(t7);
        this.add(c6);
        this.add(can);
        this.add(cre);
        this.add(l8);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==can){
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t7.setText("");
            c6.setSelectedIndex(0);

        }
        if(e.getSource()==cre){
if(t1.getText().equals("") ) l1.setForeground(Color.RED);
else l1.setForeground(Color.GREEN);
    if(t2.getText().equals(""))l2.setForeground(Color.RED);
    else l2.setForeground(Color.GREEN);
            if(t3.getText().equals(""))l3.setForeground(Color.RED);
            else l3.setForeground(Color.GREEN);
            if(t4.getText().equals(""))l4.setForeground(Color.RED);
            else l4.setForeground(Color.GREEN);
            if(t5.getText().equals(""))l5.setForeground(Color.RED);
            else l5.setForeground(Color.GREEN);
            if(c6.getSelectedIndex()==0)l6.setForeground(Color.RED);
            else l6.setForeground(Color.GREEN);
            if(t7.getText().equals(""))l7.setForeground(Color.RED);
            else l7.setForeground(Color.GREEN);

            if(t1.getText().length()>=3 && t2.getText().length()>=3 && t3.getText().length()>=3 && t4.getText().length()>=3 && t5.getText().length()>=3 && t7.getText().length()>=3 && t4.getText().equals(t5.getText())) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/andi?","root","");
String sql="insert into data(Username,Password),values(?,?))";
                    PreparedStatement ps= con.prepareStatement(sql);
ps.setString(1,t1.getText());
ps.setString(2,t5.getText());

ps.executeUpdate();
                    new Login();

                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }




            }else if(t4.getText()!=t5.getText()){
                l5.setText("Invalid Password");
                l5.setForeground(Color.RED);

            }

}





        }


    @Override
    public void mouseClicked(MouseEvent e) {
      new Login();
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
