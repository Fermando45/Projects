import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Tourisem extends JFrame implements MouseListener {

    JFrame frame;

    JPanel module;
    JPanel Table;
    JPanel Map;
    JPanel Table1;
    JPanel Table2;
    JPanel City;
    JPanel Table3;

    JTextArea description;
    JTextArea city;

    JLabel menu;
    JLabel Atm;
    JLabel map;
    JLabel theaters;
    JLabel hospitals;
    JLabel cityhis;
    JLabel agency;
    JLabel MAp;

    JTable table;
    JTable table1;
    JTable table2;
    JTable table3;

    JScrollPane p;
    JScrollPane p1;
    JScrollPane p2;
    JScrollPane p3;
    Tourisem() {
        module = new JPanel();
        module.setBounds(10, 10, 300, 160);
        module.setBorder(BorderFactory.createTitledBorder("Tourism Module"));
        module.setLayout(new FlowLayout());


        description = new JTextArea("Tourism Module is designed to take care of tourist related tasks in city. It maintains the details regarding the hotels, tourist spot, entertainment source, ATMs, theatres, city map, etc. A tourist authenticated by the administration is the main user of this module.", 6, 20);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setOpaque(false);
        description.setEditable(false);
        module.add(description);


        menu = new JLabel("Menu Bar");
        menu.setBounds(10, 200, 100, 25);
        menu.setFont(new Font("eda", Font.BOLD, 15));

        Atm = new JLabel("ATM");
        Atm.setBounds(15, 240, 50, 25);
        Atm.addMouseListener(this);

        map = new JLabel("Map");
        map.setBounds(15, 270, 50, 25);
        map.addMouseListener(this);

        theaters = new JLabel("Theaters");
        theaters.setBounds(15, 300, 100, 25);
        theaters.addMouseListener(this);

        hospitals = new JLabel("Hospitsle");
        hospitals.setBounds(15, 330, 100, 25);
        hospitals.addMouseListener(this);

        cityhis = new JLabel("City History");
        cityhis.setBounds(15, 360, 150, 25);
        cityhis.addMouseListener(this);

        agency = new JLabel("Travel Agency");
        agency.setBounds(15, 390, 150, 25);
        agency.addMouseListener(this);

        Table = new JPanel();
        Table.setBounds(350, 10, 500, 400);
        Table.setVisible(false);
        Table.setBackground(Color.gray);
        String data[][] = {};
        String title[] = {"Name", "Location"};
        table = new JTable();
        table.setModel(new DefaultTableModel(data, title));
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/smartcity", "root", "");

            Statement st = con.createStatement();
            String sql = "Select * from tourisem_module_atm";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String Name = rs.getString("Name");
                String Domain = rs.getString("Location");
                String totable[] = {Name, Domain};
                DefaultTableModel tbl = (DefaultTableModel) table.getModel();
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
        Table.add(p=new JScrollPane(table));



        Map = new JPanel();
        Map.setBounds(350, 10, 500, 400);
        ImageIcon ima=new ImageIcon("carte.png");
        MAp=new JLabel();
        MAp.setIcon(ima);
        MAp.setBounds(150,1,450,313);
        MAp.addMouseListener(this);
        Map.setVisible(false);
      //  Map.setBackground(Color.black);
        Map.add(MAp);


        Table1 = new JPanel();
        Table1.setBounds(350, 10, 500, 400);
        Table1.setVisible(false);
        // Table1.setBackground(Color.green);
        String data1[][] = {};
        String title1[] = {"Name", "Location", "Website"};
        table1 = new JTable();
        table1.setModel(new DefaultTableModel(data1,title1));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/smartcity","root","");

            Statement st=con.createStatement();
            String sql="Select * from tourisem_module_theater";
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
        Table1.add(p1 = new JScrollPane(table1));


        Table2 = new JPanel();
        Table2.setBounds(350, 10, 500, 400);
        Table2.setVisible(false);
       // Table2.setBackground(Color.green);
        String data2[][] = {};
        String title2[] = {"Name", "Location", "Website"};
        table2 = new JTable();
        table2.setModel(new DefaultTableModel(data2,title2));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/smartcity","root","");

            Statement st=con.createStatement();
            String sql="Select * from tourisem_module_hospitals";
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
        table2.setShowHorizontalLines(false);
        table2.setShowVerticalLines(false);
        table2.setEnabled(false);
        table2.addMouseListener(this);
        Table2.add(p2 = new JScrollPane(table2));




        City = new JPanel();
        City.setBounds(350, 10, 500, 400);
        city = new JTextArea("Tirana" + "\n" + "\n" + "Tirana was founded as a city in 1614 by the Ottoman Albanian general Sylejman Pasha Bargjini and flourished by then around the Old Mosque and the türbe. The area that today corresponds to the city's territory has been continuously inhabited since the Iron Age. It was inhabited by Illyrians, and was most likely the core of the Illyrian Kingdom of the Taulantii, which in Classical Antiquity was centred in the hinterland of Epidamnus. Following the Illyrian Wars it was annexed by Rome and became an integral part of the Roman Empire. The heritage of that period is still evident and represented by the Mosaics of Tirana. Later, in the 5th and 6th centuries, an Early Christian basilica was built around this site.", 10, 30);
        city.setLineWrap(true);
        city.setWrapStyleWord(true);
        city.setOpaque(false);
        city.setEditable(false);
        city.setLayout(new FlowLayout());
        city.setFont(new Font("MV Boli", Font.PLAIN, 15));
        city.setForeground(Color.BLACK);
        city.setBounds(1, 1, 450, 300);
        City.setVisible(false);
        City.add(city);
        // City.setBackground(Color.blue);



        Table3 = new JPanel();
        Table3.setBounds(350, 10, 500, 400);
        Table3.setVisible(false);
        // Table3.setBackground(Color.green);
        String data3[][] = {};
        String title3[] = {"Name", "Location", "Website"};
        table3 = new JTable();
        table3.setModel(new DefaultTableModel(data3,title3));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/smartcity","root","");

            Statement st=con.createStatement();
            String sql="Select * from tourisem_module_travel";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String Name=rs.getString("Name");
                String Location=rs.getString("Location");
                String Website=rs.getString("Website");
                String totable[]={Name,Location,Website};
                DefaultTableModel tbl=(DefaultTableModel) table3.getModel();
                tbl.addRow(totable);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        table3.setShowHorizontalLines(false);
        table3.setShowVerticalLines(false);
        table3.setEnabled(false);
        table3.addMouseListener(this);
        Table3.add(p3 = new JScrollPane(table3));

















        frame = new JFrame();
        frame.setSize(900, 500);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setTitle("Tourisem");
        frame.add(module);
        frame.add(menu);
        frame.add(Atm);
        frame.add(map);
        frame.add(theaters);
        frame.add(hospitals);
        frame.add(cityhis);
        frame.add(agency);
        frame.add(Table);
        frame.add(Map);
        frame.add(Table1);
        frame.add(Table2);
        frame.add(City);
        frame.add(Table3);

    }


    @Override
    public void mouseClicked(MouseEvent e) {
            if(e.getSource()==Atm){
            Table.setVisible(true);
            Table1.setVisible(false);
            Table2.setVisible(false);
            Table3.setVisible(false);
            Map.setVisible(false);
            City.setVisible(false);
           }
        if(e.getSource()==map){
            Table.setVisible(false);
            Table1.setVisible(false);
            Table2.setVisible(false);
            Table3.setVisible(false);
            Map.setVisible(true);
            City.setVisible(false);
        }
        if(e.getSource()==theaters){
            Table.setVisible(false);
            Table1.setVisible(true);
            Table2.setVisible(false);
            Table3.setVisible(false);
            Map.setVisible(false);
            City.setVisible(false);
        }
        if(e.getSource()==hospitals){
            Table.setVisible(false);
            Table1.setVisible(false);
            Table2.setVisible(true);
            Table3.setVisible(false);
            Map.setVisible(false);
            City.setVisible(false);
        }
        if(e.getSource()==cityhis){
            Table.setVisible(false);
            Table1.setVisible(false);
            Table2.setVisible(false);
            Table3.setVisible(false);
            Map.setVisible(false);
            City.setVisible(true);
        }
        if(e.getSource()==agency){
            Table.setVisible(false);
            Table1.setVisible(false);
            Table2.setVisible(false);
            Table3.setVisible(true);
            Map.setVisible(false);
            City.setVisible(false);
        }

        if (e.getSource() == table1) {
            int row1 = table1.rowAtPoint(e.getPoint());
            int columb1 = table1.columnAtPoint(e.getPoint());
            for(int i=0;i<=45;i++) {

                if (row1==i ) {
                    try {
                        String value=table1.getModel().getValueAt(i,2).toString();
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
            for(int i=0;i<=45;i++) {

                if (row1==i ) {
                    try {
                        String value=table2.getModel().getValueAt(i,2).toString();
                        Desktop.getDesktop().browse(new URI(value));


                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        if (e.getSource() == table3) {
            int row1 = table3.rowAtPoint(e.getPoint());
            int columb1 = table3.columnAtPoint(e.getPoint());
            for(int i=0;i<=45;i++) {

                if (row1==i ) {
                    try {
                        String value=table3.getModel().getValueAt(i,2).toString();
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


