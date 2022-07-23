import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.awt.Desktop;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.util.Vector;

public class Student extends JFrame implements MouseListener {
    JFrame frame;

    JPanel module;
    JPanel Table;
    JPanel Table1;
    JPanel Table2;






    JTextArea description;

    JLabel menu;
    JLabel Library;
    JLabel Universities;
    JLabel HighSchool;

    JTable table;
    JTable table1;
    JTable table2;

    JScrollPane p;
    JScrollPane p1;
    JScrollPane p2;

    String Adrion;
    Label adrion;

    Student(){
        module=new JPanel();
        module.setBounds(10,10,300,160);
        module.setBorder(BorderFactory.createTitledBorder("Student Module"));
        module.setLayout(new FlowLayout());


        description=new JTextArea("Student module aims at helping the student in searching institutes and providing the information regarding them. A student can view library, coaching centers, technical colleges etc. with the help this module.",6,20);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setOpaque(false);
        description.setEditable(false);
        module.add(description);

        menu=new JLabel("Menu Bar");
        menu.setBounds(10 ,200,100,25);
        menu.setFont(new Font("eda",Font.BOLD,15));


        Library=new JLabel("Library");
        Library.setBounds(15,250,50,25);
        Library.addMouseListener(this);

        Universities=new JLabel("Universities");
        Universities.setBounds(15,285,70,25);
        Universities.addMouseListener(this);

        HighSchool=new JLabel("HighSchool");
        HighSchool.setBounds(15,320,70,25);
        HighSchool.addMouseListener(this);


        Table=new JPanel();
        Table.setBounds(350,10,500,400);
        Table.setVisible(false);
        String data[][]={};
        String title[]={"Name","Location","Website"};
        table=new JTable();
        table.setModel(new DefaultTableModel(data,title));
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

        table.setEnabled(false);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.addMouseListener(this);
        Table.add(new JScrollPane(table));




/*Table=new JPanel();
Table.setBounds(350,10,500,400);
Table.setVisible(false);
adrion=new Label("www.adrionltd.com");
DefaultTableModel model= (DefaultTableModel) table.getModel();
model.addRow(new Object[]{"ldnsjfk","jdfjkd",});

 */



         Table1=new JPanel();
         Table1.setBounds(350,10,500,400);
         Table1.setVisible(false);
        String data1[][]={};
        String title1[]={"Name","Location","Website"};
        table1=new JTable();
        table1.setModel(new DefaultTableModel(data1,title1));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/smartcity","root","");

            Statement st=con.createStatement();
            String sql="Select * from student_modul_university";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String Name=rs.getString("Name");
                String Location=rs.getString("Location");
                String Website=rs.getString("Website");
                String totable[]={Name,Location,Website};
                DefaultTableModel tbl=(DefaultTableModel) table1.getModel();
                tbl.addRow(totable);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        table1.setShowHorizontalLines(false);
        table1.setShowVerticalLines(false);
        table1.setEnabled(false);
        table1.addMouseListener(this);
        Table1.add(p1=new JScrollPane(table1));



        Table2=new JPanel();
        Table2.setBounds(350,10,500,400);
        Table2.setVisible(false);
        String data2[][]={};
        String title2[]={"Name","Location","Website"};
        table2=new JTable();
        table2.setModel(new DefaultTableModel(data2,title2));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/smartcity","root","");

            Statement st=con.createStatement();
            String sql="Select * from student_modul_highschool";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String Name=rs.getString("Name");
                String Location=rs.getString("Location");
                String Website=rs.getString("Website");
                String totable[]={Name,Location,Website};
                DefaultTableModel tbl=(DefaultTableModel) table2.getModel();
                tbl.addRow(totable);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        table2.setEnabled(false);
        table2.setShowHorizontalLines(false);
        table2.setShowVerticalLines(false);
        Table2.add(p2=new JScrollPane(table2));
        table2.addMouseListener(this);


        frame=new JFrame();
        frame.setSize(900,500);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setTitle("Student");
        frame.add(module);
        frame.add(Library);
        frame.add(menu);
        frame.add(HighSchool);
        frame.add(Universities);
        frame.add(Table);
        frame.add(Table1);
        frame.add(Table2);

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == Library) {
            Table.setVisible(true);
            //  table.setVisible(true);
            Table1.setVisible(false);
            //   table1.setVisible(false);
            Table2.setVisible(false);
            //  table2.setVisible(false);


        }
        if (e.getSource() == Universities) {
            Table.setVisible(false);
            //   table.setVisible(false);
            Table1.setVisible(true);
            // table1.setVisible(true);
            Table2.setVisible(false);
            //   table2.setVisible(false);

        }

        if (e.getSource() == HighSchool) {
            Table.setVisible(false);
            //table.setVisible(false);
            Table1.setVisible(false);
            // table1.setVisible(false);
            Table2.setVisible(true);
            //table2.setVisible(true);

        }
        if (e.getSource() == table) {
            int row1 = table.rowAtPoint(e.getPoint());
            int columb1 = table.columnAtPoint(e.getPoint());
            for (int i = 0; i <= 45; i++) {

                if (row1 == i) {
                    try {
                        String value = table.getModel().getValueAt(i, 2).toString();
                        Desktop.getDesktop().browse(new URI(value));


                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        if (e.getSource() == table1) {
            int row1 = table1.rowAtPoint(e.getPoint());
            int columb1 = table1.columnAtPoint(e.getPoint());
            for (int i = 0; i <= 45; i++) {

                if (row1 == i) {
                    try {
                        String value = table1.getModel().getValueAt(i, 2).toString();
                        Desktop.getDesktop().browse(new URI(value));


                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        if (e.getSource() == table2) {
            int row1 = table2.rowAtPoint(e.getPoint());
            int columb1 = table2.columnAtPoint(e.getPoint());
            for (int i = 0; i <= 45; i++) {

                if (row1 == i) {
                    try {
                        String value = table2.getModel().getValueAt(i, 2).toString();
                        Desktop.getDesktop().browse(new URI(value));


                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
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
