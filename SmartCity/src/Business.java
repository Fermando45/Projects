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

public class Business extends JFrame implements MouseListener {
    JFrame frame;

    JPanel module;
    JPanel Table;
    JPanel Table1;
    JPanel City;


    JLabel menu;
    JLabel Job;
    JLabel CityHistory;
    JLabel Hotels;

    JTable table;
    JTable table1;

    JScrollPane p;
    JScrollPane p1;

    JTextArea text;
    JTextArea description;


    Business() {

        module = new JPanel();
        module.setBounds(10, 10, 300, 180);
        module.setBorder(BorderFactory.createTitledBorder("Business Module"));
        module.setLayout(new FlowLayout());


        description = new JTextArea("Business Module focuses at updating the different information regarding the trade in city. It gives the information about business centers, industries, etc. in the city along with social and political impact on them. The history of the city, market views, industrial views etc. can be accessed through this module of Java project on Smart City.", 6, 20);
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

        CityHistory = new JLabel("City History");
        CityHistory.setBounds(15, 270, 100, 25);
        CityHistory.addMouseListener(this);

        Hotels = new JLabel("Hotels");
        Hotels.setBounds(15, 300, 100, 25);
        Hotels.addMouseListener(this);


        Table = new JPanel();
        Table.setBounds(350, 10, 500, 400);
        Table.setVisible(false);
        // Table.setBackground(Color.black);
        String data[][] = {};
        String title[] = {"Name", "Domain", "Website"};
        table = new JTable();
        table.setModel(new DefaultTableModel(data, title));
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/smartcity", "root", "");

            Statement st = con.createStatement();
            String sql = "Select * from jobseeker_modul_job";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String Name = rs.getString("Name");
                String Domain = rs.getString("Domain");
                String Website = rs.getString("Website");
                String totable[] = {Name, Domain, Website};
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
        Table.add(p = new JScrollPane(table));


        Table1 = new JPanel();
        Table1.setBounds(350, 10, 500, 400);
        Table1.setVisible(false);
        // Table1.setBackground(Color.green);
        String data1[][] = {};
        String title1[] = {"Name", "Location", "Website"};
        table1 = new JTable();
        table1.setModel(new DefaultTableModel(data1, title1));
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/smartcity", "root", "");

            Statement st = con.createStatement();
            String sql = "Select * from bussnies_modul_hotels";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String Name = rs.getString("Name");
                String Location = rs.getString("Location");
                String Website = rs.getString("Website");
                String totable[] = {Name, Location, Website};
                DefaultTableModel tbl = (DefaultTableModel) table1.getModel();
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
        text = new JTextArea("Tirana" + "\n" + "\n" + "Tirana was founded as a city in 1614 by the Ottoman Albanian general Sylejman Pasha Bargjini and flourished by then around the Old Mosque and the türbe. The area that today corresponds to the city's territory has been continuously inhabited since the Iron Age. It was inhabited by Illyrians, and was most likely the core of the Illyrian Kingdom of the Taulantii, which in Classical Antiquity was centred in the hinterland of Epidamnus. Following the Illyrian Wars it was annexed by Rome and became an integral part of the Roman Empire. The heritage of that period is still evident and represented by the Mosaics of Tirana. Later, in the 5th and 6th centuries, an Early Christian basilica was built around this site.", 10, 30);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setOpaque(false);
        text.setEditable(false);
        text.setLayout(new FlowLayout());
        text.setFont(new Font("MV Boli", Font.PLAIN, 15));
        text.setForeground(Color.BLACK);
        text.setBounds(1, 1, 450, 300);
        City.setVisible(false);
        City.add(text);
        // City.setBackground(Color.blue);


        frame = new JFrame();
        frame.setSize(900, 500);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setTitle("Business");
        frame.add(module);
        frame.add(Job);
        frame.add(menu);
        frame.add(CityHistory);
        frame.add(Hotels);
        frame.add(Table);
        frame.add(Table1);
        frame.add(City);


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == Job) {
            Table.setVisible(true);
            City.setVisible(false);
            Table1.setVisible(false);


        }
        if (e.getSource() == CityHistory) {
            City.setVisible(true);
            Table1.setVisible(false);
            Table.setVisible(false);

        }
        if (e.getSource() == Hotels) {
            Table1.setVisible(true);
            Table.setVisible(false);
            City.setVisible(false);

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
