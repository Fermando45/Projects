import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class Pratic extends JFrame implements MouseListener {
    JFrame frame;
    JTable table;
    JPanel Table;

JLabel clickme;

    Pratic(){
       Table=new JPanel();
        Table.setBounds(350,10,500,400);
        Table.setVisible(true);
        String data1[][]={{"CIT","Rruga Xhanfize Keko","www.cit.edu.al"},{"UET","Rruga Xhanfize Keko","www.uet.edu.al"},{"UPT","Bulevardi Dëshmorët e Kombit","www.upt.edu.al"}};
        String title1[]={"Name","Location","Website"};
        table=new JTable();
        table.setModel(new DefaultTableModel(data1,title1));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/smartcity","root","");

            Statement st=con.createStatement();
            String sql="Select * from student_modul";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String Name=rs.getString("Name");
                String Location=rs.getString("Location");
                String Website=rs.getString("Website");

                String totable[]={Name,Location,Website};
                DefaultTableModel tbl=(DefaultTableModel) table.getModel();
                tbl.addRow(totable);


            }


            con.close();











        } catch (Exception ex) {
            ex.printStackTrace();
        }


        Table.setBackground(Color.green);
        Table.add(new JScrollPane(table));


clickme=new JLabel("Click me");
clickme.setBounds(50,50,100,30);
clickme.addMouseListener(this);


















frame=new JFrame();
        frame.setSize(900,500);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setTitle("Pratic");
        frame.add(clickme);
        frame.add(Table);






    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==clickme){


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
