import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class Bills extends JFrame implements ActionListener {
    JFrame frame;

    JPanel tab;

    JTable Tab;

    JButton Delete;

    public void Bill() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bar", "root", "andiminaj1234");
            Statement st = con.createStatement();
            String sql = "Select * from bills";
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData RSS = rs.getMetaData();
            int c = RSS.getColumnCount();
            DefaultTableModel Df = (DefaultTableModel) Tab.getModel();
            Df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();

                for (int a = 1; a <= c; a++) {
                    v2.add(rs.getString("Waiter"));
                    v2.add(rs.getString("Product"));
                    v2.add(rs.getString("Price"));
                    v2.add(rs.getString("Quantity"));
                    v2.add(rs.getString("Total"));


                }
                Df.addRow(v2);

            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Bills() {

        tab = new JPanel();
        tab.setBackground(Color.WHITE);
        // tab.setVisible(false);
        tab.setBounds(10, 10, 460, 400);
        String data[][] = {};
        String[] title = {"Waiter", "Product", "Price", "Quantity", "Total"};
        Tab = new JTable();
        Tab.setModel(new DefaultTableModel(data, title));
        Bill();
        Tab.setPreferredScrollableViewportSize(new Dimension(440, 365));
        Tab.setShowVerticalLines(false);
        Tab.setShowHorizontalLines(false);
        Tab.setBackground(Color.WHITE);
        tab.add(new JScrollPane(Tab));

        Delete = new JButton("Delete");
        Delete.setBounds(500, 200, 100, 30);
        Delete.setBackground(Color.RED);
        Delete.setFocusPainted(false);
        Delete.setForeground(Color.WHITE);

        frame = new JFrame("Bills");
        frame.setSize(800, 500);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(tab);
        frame.add(Delete);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}