import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.*;

import net.proteanit.sql.DbUtils;

import java.awt.print.PrinterException;
import java.sql.*;
import java.util.Vector;

public class Seller extends JFrame implements ActionListener, MouseListener, KeyListener {
    JFrame frame;

    JLabel Billing;
    JLabel Name;
    JLabel Quantity;
    JLabel Product;
    JLabel Rs;
    JLabel Logout;

    JButton add;
    JButton clear;
    JButton print;
    JButton filtrer;
    JButton refresh;

    JComboBox category;

    JPanel tab;
    JPanel logout;

    JTable Tab;

    JTextArea bill;

    JTextField name;
    JTextField quantity;

    double Uprice;
    double ProdTot;
    double Quan;
    String N;
    double Total;



    private void Categoriess() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("Select Name from Categories");
            while (rs.next()) {
                String name = rs.getString("Name");
                category.addItem(name);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void productlist() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/supermarket", "root", "");
            Statement st = con.createStatement();
            String sql = "Select * from product";
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData RSS = rs.getMetaData();
            int c = RSS.getColumnCount();
            DefaultTableModel Df = (DefaultTableModel) Tab.getModel();
            Df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();

                for (int a = 1; a <= c; a++) {
                    v2.add(rs.getString("ID"));
                    v2.add(rs.getString("Name"));
                    v2.add(rs.getString("Quantity"));
                    v2.add(rs.getString("Price"));
                    v2.add(rs.getString("Category"));


                }
                Df.addRow(v2);

            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Seller(){
        Logout=new JLabel("Logout");
        Logout.setForeground(Color.WHITE);
        Logout.setBounds(25,620,75,25);
        Logout.setFont(new Font("sdf",Font.PLAIN,16));
        Logout.addMouseListener(this);
        logout =new JPanel();
        logout.setBounds(0,0,80,700);
        logout.setBackground(new Color(53,223,50));
        logout.setLayout(null);
        logout.add(Logout);

        Billing=new JLabel("Billing Point");
        Billing.setForeground(new Color(53,223,50));
        Billing.setBounds(400,0,120,35);
        Billing.setFont(new Font("jhk",Font.BOLD,20));

        Name=new JLabel("Name:");
        Name.setBounds(120,150,75,25);
        Name.setForeground(new Color(53,223,50));
        Name.setFont(new Font("ds",Font.BOLD,15));
        name=new JTextField();
        name.setBounds(170,153,120,20);
        name.setEnabled(false);

        Quantity=new JLabel("Qauntity:");
        Quantity.setBounds(100,200,100,25);
        Quantity.setForeground(new Color(53,223,50));
        Quantity.setFont(new Font("ds",Font.BOLD,15));
        quantity=new JTextField();
        quantity.setBounds(170,203,120,20);
        quantity.addKeyListener(this);

        add=new JButton("Add to Bill");
        add.setBackground(new Color(53,223,50));
        add.setForeground(Color.WHITE);
        add.setFocusPainted(false);
        add.setBounds(100,250,90,25);
        add.addActionListener(this);

        clear=new JButton("Clear");
        clear.setBackground(new Color(53,223,50));
        clear.setForeground(Color.WHITE);
        clear.setFocusPainted(false);
        clear.setBounds(200,250,90,25);
        clear.addActionListener(this);

        Product=new JLabel("Product List");
        Product.setForeground(new Color(53,223,50));
        Product.setFont(new Font("sdsa",Font.BOLD,18));
        Product.setBounds(550,60,125,25);

        category=new JComboBox();
        category.setBounds(480,90,110,20);
        Categoriess();

        filtrer=new JButton("Filter");
        filtrer.setForeground(Color.WHITE);
        filtrer.setBackground(new Color(53,223,50));
        filtrer.setBounds(600,90,80,20);
        filtrer.setFocusPainted(false);
        filtrer.addActionListener(this);

        refresh=new JButton("Refresh");
        refresh.setForeground(Color.WHITE);
        refresh.setBackground(new Color(53,223,50));
        refresh.setBounds(690,90,80,20);
        refresh.setFocusPainted(false);
        refresh.addActionListener(this);

        tab=new JPanel();
        tab.setBackground(new Color(238,238,238));
       // tab.setVisible(false);
        tab.setBounds(425,115,360,300);
        String data[][] = {};
        String[] title = {"ID", "Name", "Quantity", "Price", "Category"};
        Tab = new JTable();
        Tab.setModel(new DefaultTableModel(data, title));
        productlist();
        Tab.setPreferredScrollableViewportSize(new Dimension(340, 265));
        Tab.setShowVerticalLines(false);
        Tab.setShowHorizontalLines(false);
        Tab.addMouseListener(this);
        tab.add(new JScrollPane(Tab));


        bill=new JTextArea("================== SUPERMARKET ==================" + "\n" +
                "Product                    Price                    Quantity                    Total"+"\n");
        //bill.setBounds(430,420,350,200);
        //bill.setAutoscrolls(true);
        bill.setLayout(null);
        JScrollPane s=new JScrollPane(bill,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        s.setBounds(430,420,350,200);

        print=new JButton("Print");
        print.setBackground(new Color(53,223,50));
        print.setForeground(Color.WHITE);
        print.setBounds(570,640,80,25);
        print.setFocusPainted(false);
        print.addActionListener(this);



frame=new JFrame();
frame.setVisible(true);
frame.setSize(800,735);
frame.setLayout(null);
frame.setResizable(false);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add(logout);
frame.add(s);
frame.add(Billing);
frame.add(Name);
frame.add(name);
frame.add(Quantity);
frame.add(category);
frame.add(quantity);
frame.add(add);
frame.add(clear);
frame.add(filtrer);
frame.add(refresh);
frame.add(tab);
//frame.add(bill);
frame.add(Product);
frame.add(print);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            name.setText("");
            quantity.setText("");
        }
        if (e.getSource() == filtrer) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("Select * from product where Category='" + category.getSelectedItem().toString() + "'");
                Tab.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == refresh) {
            productlist();
            category.setSelectedIndex(0);
        }
        if (e.getSource() == add) {
            if (name.getText().equals("")) Name.setForeground(Color.RED);
            else Name.setForeground(new Color(53, 223, 50));
            if (quantity.getText().equals("")) Quantity.setForeground(Color.RED);
            else Quantity.setForeground(new Color(53, 223, 50));
            int i = 0;
            if (name.getText().isEmpty() || quantity.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Missing Information");
            } else if (Quan < Integer.valueOf(quantity.getText())) {
                JOptionPane.showMessageDialog(null, "We dont have that much quantity");
            } else {
                i = i + 1;
                ProdTot = Uprice * Integer.valueOf(quantity.getText());

                if (i == 1) {
                    Total=Total+ProdTot;

                    bill.setText(bill.getText() + name.getText() + "\t    " + Uprice + "\t          " + quantity.getText() + "\t          " + ProdTot + "\n");

                }

            }


        }
        if(e.getSource()==print){
            String total=String.valueOf(Total);
            bill.append("                                                                                        Total:"+total);
            try {
                bill.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
if(e.getSource()==Tab){
    DefaultTableModel Df = (DefaultTableModel) Tab.getModel();
    int Selectindex = Tab.getSelectedRow();

    name.setText(Df.getValueAt(Selectindex, 1).toString());
    // N=String.valueOf(Df.getValueAt(Selectindex,1).toString());
    Uprice=Double.valueOf(Df.getValueAt(Selectindex,3).toString());
    Quan=Double.valueOf(Df.getValueAt(Selectindex,2).toString());



}
        if(e.getSource()==Logout){

new Login();
frame.setVisible(false);
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char c = e.getKeyChar();

        if(e.getSource()==quantity){
    if (Character.isLetter(c)) {
        quantity.setText("");
        Quantity.setForeground(Color.RED);
        JOptionPane.showMessageDialog(null, "Enter only Numbers");

    } else {
        Quantity.setForeground(new Color(53, 223, 50));

    }
}
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
