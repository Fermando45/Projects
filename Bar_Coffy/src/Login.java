import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JFrame frame;


    JLabel icon;
    JLabel icon2;

    JTextField Name;
    JTextField Pass;

    JLabel name;
    JLabel pass;
    JLabel des;

    JButton Login;
    JButton Cancle;


    Login(){
        icon=new JLabel();
        icon.setBounds(15,90,150,150);
        ImageIcon Icon=new ImageIcon("images.png")   ;
  Image ima=Icon.getImage();
  Image scalar=ima.getScaledInstance(icon.getWidth(),icon.getHeight(),Image.SCALE_SMOOTH);
  ImageIcon scalarIcon=new ImageIcon(scalar);
  icon.setIcon(Icon);



        icon2=new JLabel();
        icon2.setBounds(350,10,100,100);
        ImageIcon Icon2=new ImageIcon("3917657-200.png")   ;
        Image ima2=Icon2.getImage();
        Image scalar2=ima2.getScaledInstance(icon2.getWidth(),icon2.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scalarIcon2=new ImageIcon(scalar2);
        icon2.setIcon(Icon2);

        Name=new JTextField();
        Name.setBounds(330,130,150,20);
        name=new JLabel("Name:");
        name.setBounds(280,125,75,25);


        Pass=new JPasswordField();
        Pass.setBounds(330,170,150,20);
        pass=new JLabel("Password:");
        pass.setBounds(255,165,75,25);

        Login=new JButton("Login");
        Login.setBounds(285,205,75,25);
        //Login.setBackground(new Color(32,242,32));
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.setFocusPainted(false);
        Login.addActionListener(this);

        Cancle=new JButton("Cancel");
        Cancle.setBounds(390,205,75,25);
       // Cancle.setBackground(new Color(242,32,32));
        Cancle.setBackground(Color.BLACK);
        Cancle.setForeground(Color.WHITE);
        Cancle.setFocusPainted(false);
        Cancle.addActionListener(this);

        /*des=new JLabel();
        des.setText("Bar Coffee");
        des.setBounds(10,150,100,100);
        des.setFont(new Font("dshk",Font.ITALIC,20));

         */


        frame=new JFrame();
frame.setVisible(true);
frame.setLayout(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(600,350);
frame.getContentPane().setBackground(Color.white);
frame.setResizable(false);
frame.add(icon);
frame.add(icon2);
frame.add(Name);
frame.add(Pass);
frame.add(name);
frame.add(pass);
frame.add(Login);
frame.add(Cancle);
//frame.add(des);



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Login) {
            try {
                // Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bar", "root", "andiminaj1234");
                String sql = "Select * from admin where name=? and password=?";
                String sql1 = "Select * from open where name=? and password=?";
                String sql2 = "Select * from waiter where name=? and password=?";

                PreparedStatement pre = con.prepareStatement(sql);
                PreparedStatement pre1 = con.prepareStatement(sql1);
                PreparedStatement pre2 = con.prepareStatement(sql2);


                pre.setString(1, Name.getText());
                pre.setString(2, Pass.getText());
                pre1.setString(1, Name.getText());
                pre1.setString(2, Pass.getText());
                pre2.setString(1, Name.getText());
                pre2.setString(2, Pass.getText());

                ResultSet st = pre.executeQuery();
                ResultSet st1 = pre1.executeQuery();
                ResultSet st2 = pre2.executeQuery();
                if (st.next()) {
                    new Admin();
                    frame.setVisible(false);
                } else if (st1.next()) {
                    new Seller();
                    frame.setVisible(false);
                } else if (st2.next()) {
                    new Bills();
                    frame.setVisible(false);

            } else{
                JOptionPane.showMessageDialog(null, "Invalide User");
            }

        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }





        }
        if(e.getSource()==Cancle){
            Name.setText("");
            Pass.setText("");
        }
    }
}
