import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jobseekers extends JFrame implements MouseListener {
    JFrame frame;

    JPanel module;
    JPanel Table;
    JPanel Table1;
    JPanel City;
    JPanel Map;

    JTextArea description;

    JLabel menu;
    JLabel Job;
    JLabel Cityinformation;
    JLabel Institutes;
    JLabel CityMap;
    JLabel map;

    JTable table;
    JTable table1;
    JTable table2;

    JScrollPane p;
    JScrollPane p1;

    JTextArea text;

    Jobseekers() {
        module = new JPanel();
        module.setBounds(10, 10, 300, 175);
        module.setBorder(BorderFactory.createTitledBorder("Job Seekers Module"));
        module.setLayout(new FlowLayout());


        description = new JTextArea("Jobseekers module enables the system to enlist available job opportunities in the city. Though this module, the user can access the various information regarding various job offering organizations. The main aim of the module is to help the city administration in solving unemployment problems.", 6, 20);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setOpaque(false);
        description.setEditable(false);
        module.add(description);

        menu = new JLabel("Menu Bar");
        menu.setBounds(10, 200, 100, 25);
        menu.setFont(new Font("eda", Font.BOLD, 15));


        Job = new JLabel("Job");
        Job.setBounds(15, 240, 50, 25);
        Job.addMouseListener(this);

        Cityinformation = new JLabel("City Information");
        Cityinformation.setBounds(15, 270, 100, 25);
        Cityinformation.addMouseListener(this);

        Institutes = new JLabel("Institutes");
        Institutes.setBounds(15, 300, 100, 25);
        Institutes.addMouseListener(this);

        CityMap = new JLabel("City Map");
        CityMap.setBounds(15, 330, 100, 25);
        CityMap.addMouseListener(this);
        CityMap.setBackground(Color.red);

        Table = new JPanel();
        Table.setBounds(350, 10, 500, 400);
        Table.setVisible(false);
        //Table.setBackground(Color.gray);
        String data[][] = {};
        String title[] = {"Name", "Domain", "Website"};
        table = new JTable();
        table.setModel(new DefaultTableModel(data,title));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/smartcity","root","");

            Statement st=con.createStatement();
            String sql="Select * from jobseeker_modul_job";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String Name=rs.getString("Name");
                String Domain=rs.getString("Domain");
                String Website=rs.getString("Website");
                String totable[]={Name,Domain,Website};
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
        Table.add(p = new JScrollPane(table));




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
            String sql="Select * from jobseeker_modul_institution";
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

        City = new JPanel();
        City.setBounds(350, 10, 500, 400);
        text=new JTextArea("Tirana"+"\n"+"\n"+"Tirana is the capital and largest city of Albania. It is located in the centre of the country, enclosed by mountains and hills with Dajti rising to the east and a slight valley to the northwest overlooking the Adriatic Sea in the distance. Due to its location at the Plain of Tirana and the close proximity to the Mediterranean Sea, the city is particularly influenced by a Mediterranean seasonal climate. It is among the wettest and sunniest cities in Europe, with 2,544 hours of sun per year.Tirana has a humid subtropical climate (Cfa) according to the Köppen climate classification and receives a commensurable amount of precipitation, during summer, to avoid the Mediterranean climate (Csa) classification",10,30);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setOpaque(false);
        text.setEditable(false);
        text.setLayout(new FlowLayout());
        text.setFont(new Font("MV Boli",Font.PLAIN,15));
        text.setForeground(Color.BLACK);
        text.setBounds(1,1,450,300);
        City.setVisible(false);
        City.add(text);
       // City.setBackground(Color.blue);

        Map = new JPanel();
        Map.setBounds(350, 10, 500, 400);
        ImageIcon ima=new ImageIcon("carte.png");
        map=new JLabel();
        map.setIcon(ima);
        map.setBounds(1,1,450,313);
        map.addMouseListener(this);
        Map.setVisible(false);
        //Map.setBackground(Color.black);
        Map.add(map);





        frame = new JFrame();
        frame.setSize(900, 500);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setTitle("Jobseekers");
        frame.add(module);
        frame.add(Job);
        frame.add(menu);
        frame.add(CityMap);
        frame.add(Cityinformation);
        frame.add(Institutes);
        frame.add(Table);
        frame.add(Table1);
        frame.add(City);
        frame.add(Map);


    }

    @Override
    public void mouseClicked(MouseEvent e) {
if(e.getSource()==Job){
    Table.setVisible(true);
    City.setVisible(false);
    Table1.setVisible(false);
    Map.setVisible(false);


}
        if(e.getSource()==Cityinformation){
            City.setVisible(true);
            Table1.setVisible(false);
            Map.setVisible(false);
            Table.setVisible(false);

        }
        if(e.getSource()==Institutes){
            Table1.setVisible(true);
            Map.setVisible(false);
            Table.setVisible(false);
            City.setVisible(false);

        }
        if(e.getSource()==CityMap){
            Map.setVisible(true);
            Table.setVisible(false);
            City.setVisible(false);
            Table1.setVisible(false);

        }
if(e.getSource()==map){

    try{

        Desktop.getDesktop().browse(new URI("https://www.google.com/maps/place/Tirana/@41.330961,19.7477833,12z/data=!3m1!4b1!4m5!3m4!1s0x1350310470fac5db:0x40092af10653720!8m2!3d41.3275459!4d19.8186982"));
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
        if (e.getSource() == table) {
            int row1 = table.rowAtPoint(e.getPoint());
            int columb1 = table.columnAtPoint(e.getPoint());
            for(int i=0;i<=45;i++) {

                if (row1==i ) {
                    try {
                        String value=table.getModel().getValueAt(i,2).toString();
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



