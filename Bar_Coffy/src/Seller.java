import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.sql.*;
import java.util.Vector;

public class Seller extends JFrame implements ActionListener, MouseListener, KeyListener,WindowListener {
    JFrame frame;
    JFrame frame1;

    JButton tab1;
    JButton tab2;
    JButton tab3;
    JButton tab4;
    JButton tab5;
    JButton tab6;
    JButton tab7;
    JButton tab8;
    JButton tab9;
    JButton tab10;
    JButton tab11;
    JButton tab12;
    JButton Add;
    JButton Clear;
    JButton Refresh;
    JButton Filter;
    JButton Print;
    JButton LOGIN;
    JButton Cancle;

    JComboBox Category;


    JLabel Name;
    JLabel Quantity;
    JLabel Title;
    JLabel Logout;
    JLabel NAMe;
    JLabel pass;
    JLabel waiter;

    JTextField name;
    JTextField quantity;
    JTextField search;
    JTextField NAME;

    JPasswordField Pass;

    JPanel pan;
    JPanel tab;

    JTable Tab;

    JTextArea Bill;

    double Uprice;
    double ProdTot;
    double Quan;
    String N;
    double Total;

    public void search(String str) {
        DefaultTableModel Df = (DefaultTableModel) Tab.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(Df);
        Tab.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

    public void Categoriess() {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bar", "root", "andiminaj1234");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("Select Name from category");
            while (rs.next()) {
                String name = rs.getString("Name");
                Category.addItem(name);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void productlist() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bar", "root", "andiminaj1234");
            Statement st = con.createStatement();
            String sql = "Select * from products";
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

    Seller() {
        tab1 = new JButton("Table 1");
        tab1.setBounds(20, 20, 90, 25);
        tab1.setFocusPainted(false);
        tab1.setBackground(Color.GREEN);
        tab1.setForeground(Color.WHITE);
        tab1.addActionListener(this);

        tab2 = new JButton("Table 2");
        tab2.setBounds(20, 60, 90, 25);
        tab2.setFocusPainted(false);
        tab2.setBackground(Color.GREEN);
        tab2.setForeground(Color.WHITE);
        tab2.addActionListener(this);

        tab3 = new JButton("Table 3");
        tab3.setBounds(20, 100, 90, 25);
        tab3.setFocusPainted(false);
        tab3.setBackground(Color.GREEN);
        tab3.setForeground(Color.WHITE);
        tab3.addActionListener(this);

        tab4 = new JButton("Table 4");
        tab4.setBounds(20, 140, 90, 25);
        tab4.setFocusPainted(false);
        tab4.setBackground(Color.GREEN);
        tab4.setForeground(Color.WHITE);
        tab4.addActionListener(this);

        tab5 = new JButton("Table 5");
        tab5.setBounds(20, 180, 90, 25);
        tab5.setFocusPainted(false);
        tab5.setBackground(Color.GREEN);
        tab5.setForeground(Color.WHITE);
        tab5.addActionListener(this);

        tab6 = new JButton("Table 6");
        tab6.setBounds(20, 220, 90, 25);
        tab6.setFocusPainted(false);
        tab6.setBackground(Color.GREEN);
        tab6.setForeground(Color.WHITE);
        tab6.addActionListener(this);

        tab7 = new JButton("Table 7");
        tab7.setBounds(20, 260, 90, 25);
        tab7.setFocusPainted(false);
        tab7.setBackground(Color.GREEN);
        tab7.setForeground(Color.WHITE);
        tab7.addActionListener(this);

        tab8 = new JButton("Table 8");
        tab8.setBounds(20, 300, 90, 25);
        tab8.setFocusPainted(false);
        tab8.setBackground(Color.GREEN);
        tab8.setForeground(Color.WHITE);
        tab8.addActionListener(this);

        tab9 = new JButton("Table 9");
        tab9.setBounds(20, 340, 90, 25);
        tab9.setFocusPainted(false);
        tab9.setBackground(Color.GREEN);
        tab9.setForeground(Color.WHITE);
        tab9.addActionListener(this);

        tab10 = new JButton("Table 10");
        tab10.setBounds(20, 380, 90, 25);
        tab10.setFocusPainted(false);
        tab10.setBackground(Color.GREEN);
        tab10.setForeground(Color.WHITE);
        tab10.addActionListener(this);

        tab11 = new JButton("Table 11");
        tab11.setBounds(20, 420, 90, 25);
        tab11.setFocusPainted(false);
        tab11.setBackground(Color.GREEN);
        tab11.setForeground(Color.WHITE);
        tab11.addActionListener(this);

        tab12 = new JButton("Table 12");
        tab12.setBounds(20, 460, 90, 25);
        tab12.setFocusPainted(false);
        tab12.setBackground(Color.GREEN);
        tab12.setForeground(Color.WHITE);
        tab12.addActionListener(this);

        Name = new JLabel("Name:");
        Name.setBounds(30, 180, 75, 25);
        Name.setFont(new Font("dds", Font.BOLD, 15));
        name = new JTextField();
        name.setBounds(85, 183, 120, 20);
        name.setEditable(false);


        Quantity = new JLabel("Quantity:");
        Quantity.setBounds(15, 210, 75, 25);
        Quantity.setFont(new Font("dds", Font.BOLD, 15));
        quantity = new JTextField();
        quantity.setBounds(85, 213, 120, 20);

        Add = new JButton("Add");
        Add.setBounds(30, 250, 80, 25);
        Add.setFocusPainted(false);
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.WHITE);
        Add.addActionListener(this);

        Clear = new JButton("Clear");
        Clear.setBounds(135, 250, 80, 25);
        Clear.setFocusPainted(false);
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.WHITE);
        Clear.addActionListener(this);

        Category = new JComboBox<>();
        Category.setBounds(390, 110, 100, 25);
        Category.addMouseListener(this);
        Categoriess();


        Refresh = new JButton("Refresh");
        Refresh.setBounds(600, 110, 80, 25);
        Refresh.setFocusPainted(false);
        Refresh.setBackground(Color.BLACK);
        Refresh.setForeground(Color.WHITE);
        Refresh.addActionListener(this);

        Filter = new JButton("Search");
        Filter.setBounds(510, 110, 80, 25);
        Filter.setFocusPainted(false);
        Filter.setBackground(Color.BLACK);
        Filter.setForeground(Color.WHITE);
        Filter.addActionListener(this);

        tab = new JPanel();
        tab.setBackground(Color.WHITE);
        // tab.setVisible(false);
        tab.setBounds(325, 140, 360, 300);
        String data[][] = {};
        String[] title = {"ID", "Name", "Quantity", "Price", "Category"};
        Tab = new JTable();
        Tab.setModel(new DefaultTableModel(data, title));
        productlist();
        Tab.setPreferredScrollableViewportSize(new Dimension(340, 265));
        Tab.setShowVerticalLines(false);
        Tab.setShowHorizontalLines(false);
        Tab.setBackground(Color.WHITE);
        Tab.addMouseListener(this);
        tab.add(new JScrollPane(Tab));

        Title = new JLabel("Bar Coffee");
        Title.setBounds(300, 10, 150, 35);
        Title.setFont(new Font("sdj", Font.BOLD, 20));

        Bill = new JTextArea();
        Bill.setBounds(330, 440, 350, 150);
        Bill.setBackground(Color.WHITE);
        Bill.setText("=====================   BAR   ========================" + "\n" +
                "Product                    Price                    Quantity                    Total" + "\n"
        );
        JScrollPane s = new JScrollPane(Bill, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        search = new JTextField();
        search.setBounds(340, 110, 160, 25);
        search.addKeyListener(this);

        Print = new JButton("Print");
        Print.setBounds(480, 600, 80, 25);
        Print.setFocusPainted(false);
        Print.setBackground(Color.BLACK);
        Print.setForeground(Color.WHITE);
        Print.addActionListener(this);

        waiter=new JLabel();

        pan = new JPanel();
        pan.setVisible(false);
        pan.setBounds(300, 0, 700, 700);
        pan.setBackground(Color.WHITE);
        pan.setLayout(null);
        pan.add(Name);
        pan.add(name);
        pan.add(Quantity);
        pan.add(quantity);
        pan.add(Add);
        pan.add(Clear);
        pan.add(Refresh);
        pan.add(Filter);
        pan.add(tab);
        pan.add(waiter);
        pan.add(Category);
        pan.add(Title);
        pan.add(Bill);
        pan.add(Print);

        Logout = new JLabel("Log Out");
        Logout.setBounds(20, 600, 100, 35);
        Logout.setFont(new Font("SDf", Font.BOLD, 20));
        Logout.addMouseListener(this);


        frame = new JFrame("Seller");
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.getContentPane().setBackground(Color.white);
        frame.setResizable(false);
        frame.add(tab1);
        frame.add(tab2);
        frame.add(tab3);
        frame.add(tab4);
        frame.add(tab5);
        frame.add(tab6);
        frame.add(tab7);
        frame.add(tab8);
        frame.add(tab9);
        frame.add(tab10);
        frame.add(tab11);
        frame.add(tab12);
        frame.add(Logout);
        frame.add(pan);

        NAME = new JTextField();
        NAME.setBounds(75, 30, 150, 20);
        NAMe = new JLabel("Name:");
        NAMe.setBounds(30, 25, 75, 25);


        Pass = new JPasswordField();
        Pass.setBounds(75, 70, 150, 20);
        pass = new JLabel("Password:");
        pass.setBounds(10, 65, 75, 25);

        LOGIN = new JButton("Login");
        LOGIN.setBounds(30, 105, 75, 25);
        //LOGIN.setBackground(new Color(32,242,32));
        LOGIN.setBackground(Color.BLACK);
        LOGIN.setForeground(Color.WHITE);
        LOGIN.setFocusPainted(false);
        LOGIN.addActionListener(this);

        Cancle = new JButton("Cancel");
        Cancle.setBounds(150, 105, 75, 25);
        // Cancle.setBackground(new Color(242,32,32));
        Cancle.setBackground(Color.BLACK);
        Cancle.setForeground(Color.WHITE);
        Cancle.setFocusPainted(false);
        Cancle.addActionListener(this);

        frame1 = new JFrame();
        frame1.setVisible(false);
        frame1.setLayout(null);
        frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame1.setSize(300, 190);
        frame1.getContentPane().setBackground(Color.white);
        frame1.setResizable(false);
        frame1.add(NAME);
        frame1.add(Pass);
        frame1.add(NAMe);
        frame1.add(pass);
        frame1.add(LOGIN);
        frame1.add(Cancle);
        frame1.addWindowListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == LOGIN) {
            waiter.setText(NAME.getText());
            waiter.setBounds(10,10,75,25);
            try {
                // Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bar", "root", "andiminaj1234");
                String sql = "Select * from waiter where name=? and password=?";

                PreparedStatement pre = con.prepareStatement(sql);

                pre.setString(1, NAME.getText());
                pre.setString(2, Pass.getText());


                ResultSet st = pre.executeQuery();
                if (st.next()) {
                    pan.setVisible(true);
                    frame1.setVisible(false);
                    tab1.setEnabled(false);
                    tab2.setEnabled(false);
                    tab3.setEnabled(false);
                    tab4.setEnabled(false);
                    tab5.setEnabled(false);
                    tab6.setEnabled(false);
                    tab7.setEnabled(false);
                    tab8.setEnabled(false);
                    tab9.setEnabled(false);
                    tab10.setEnabled(false);
                    tab11.setEnabled(false);
                    tab12.setEnabled(false);
                    Total=0;


                } else {
                    JOptionPane.showMessageDialog(null, "Invalide User");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }


        }
        if (e.getSource() == Cancle) {
            Name.setText("");
            Pass.setText("");
        }
/////////////////////////////////////////////// Tables ///////////////////////////////////////////////////

        if (e.getSource() == tab1) {
            if (tab1.getBackground().equals(Color.GREEN)) {
                frame1.setVisible(true);
                frame1.setTitle(tab1.getText());
                tab1.setBackground(Color.RED);
            } else if (tab1.getBackground().equals(Color.RED)) {
                int responsee1 = JOptionPane.showConfirmDialog(this, "Is the table free", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (responsee1 == JOptionPane.YES_OPTION) {
                    tab1.setBackground(Color.green);
                }
            }
        }

        if (e.getSource() == tab2) {


            if (tab2.getBackground().equals(Color.GREEN)) {
                frame1.setVisible(true);
                frame1.setTitle(tab2.getText());
                tab2.setBackground(Color.RED);
            } else if (tab2.getBackground().equals(Color.RED)) {
                int responsee1 = JOptionPane.showConfirmDialog(this, "Is the table free", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (responsee1 == JOptionPane.YES_OPTION) {
                    tab2.setBackground(Color.green);
                }


            }

        }




        if (e.getSource() == tab3) {


            if (tab3.getBackground().equals(Color.GREEN)) {
                frame1.setVisible(true);
                frame1.setTitle(tab3.getText());
                tab3.setBackground(Color.RED);
            } else if (tab3.getBackground().equals(Color.RED)) {
                int responsee1 = JOptionPane.showConfirmDialog(this, "Is the table free", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (responsee1 == JOptionPane.YES_OPTION) {
                    tab3.setBackground(Color.green);
                }


            }

        }





        if (e.getSource() == tab4) {


            if (tab4.getBackground().equals(Color.GREEN)) {
                frame1.setVisible(true);
                frame1.setTitle(tab4.getText());
                tab4.setBackground(Color.RED);
            } else if (tab4.getBackground().equals(Color.RED)) {
                int responsee1 = JOptionPane.showConfirmDialog(this, "Is the table free", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (responsee1 == JOptionPane.YES_OPTION) {
                    tab4.setBackground(Color.green);
                }


            }

        }








        if (e.getSource() == tab5) {


            if (tab5.getBackground().equals(Color.GREEN)) {
                frame1.setVisible(true);
                frame1.setTitle(tab5.getText());
                tab5.setBackground(Color.RED);
            } else if (tab5.getBackground().equals(Color.RED)) {
                int responsee1 = JOptionPane.showConfirmDialog(this, "Is the table free", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (responsee1 == JOptionPane.YES_OPTION) {
                    tab5.setBackground(Color.green);
                }


            }

        }













        if (e.getSource() == tab6) {


            if (tab6.getBackground().equals(Color.GREEN)) {
                frame1.setVisible(true);
                frame1.setTitle(tab6.getText());
                tab6.setBackground(Color.RED);
            } else if (tab6.getBackground().equals(Color.RED)) {
                int responsee1 = JOptionPane.showConfirmDialog(this, "Is the table free", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (responsee1 == JOptionPane.YES_OPTION) {
                    tab6.setBackground(Color.green);
                }


            }

        }

















        if (e.getSource() == tab7) {


            if (tab7.getBackground().equals(Color.GREEN)) {
                frame1.setVisible(true);
                frame1.setTitle(tab7.getText());
                tab7.setBackground(Color.RED);
            } else if (tab7.getBackground().equals(Color.RED)) {
                int responsee1 = JOptionPane.showConfirmDialog(this, "Is the table free", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (responsee1 == JOptionPane.YES_OPTION) {
                    tab7.setBackground(Color.green);
                }


            }

        }


















        if (e.getSource() == tab8) {


            if (tab8.getBackground().equals(Color.GREEN)) {
                frame1.setVisible(true);
                frame1.setTitle(tab8.getText());
                tab8.setBackground(Color.RED);
            } else if (tab8.getBackground().equals(Color.RED)) {
                int responsee1 = JOptionPane.showConfirmDialog(this, "Is the table free", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (responsee1 == JOptionPane.YES_OPTION) {
                    tab8.setBackground(Color.green);
                }


            }

        }













        if (e.getSource() == tab9) {


            if (tab9.getBackground().equals(Color.GREEN)) {
                frame1.setVisible(true);
                frame1.setTitle(tab9.getText());
                tab9.setBackground(Color.RED);
            } else if (tab9.getBackground().equals(Color.RED)) {
                int responsee1 = JOptionPane.showConfirmDialog(this, "Is the table free", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (responsee1 == JOptionPane.YES_OPTION) {
                    tab9.setBackground(Color.green);
                }


            }

        }
















        if (e.getSource() == tab10) {


            if (tab10.getBackground().equals(Color.GREEN)) {
                frame1.setVisible(true);
                frame1.setTitle(tab10.getText());
                tab10.setBackground(Color.RED);
            } else if (tab10.getBackground().equals(Color.RED)) {
                int responsee1 = JOptionPane.showConfirmDialog(this, "Is the table free", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (responsee1 == JOptionPane.YES_OPTION) {
                    tab10.setBackground(Color.green);
                }


            }

        }













        if (e.getSource() == tab11) {


            if (tab11.getBackground().equals(Color.GREEN)) {
                frame1.setVisible(true);
                frame1.setTitle(tab11.getText());
                tab11.setBackground(Color.RED);
            } else if (tab11.getBackground().equals(Color.RED)) {
                int responsee1 = JOptionPane.showConfirmDialog(this, "Is the table free", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (responsee1 == JOptionPane.YES_OPTION) {
                    tab11.setBackground(Color.green);
                }


            }

        }

















        if (e.getSource() == tab12) {


            if (tab12.getBackground().equals(Color.GREEN)) {
                frame1.setVisible(true);
                frame1.setTitle(tab12.getText());
                tab12.setBackground(Color.RED);
            } else if (tab12.getBackground().equals(Color.RED)) {
                int responsee1 = JOptionPane.showConfirmDialog(this, "Is the table free", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (responsee1 == JOptionPane.YES_OPTION) {
                    tab12.setBackground(Color.green);
                }


            }

        }
        ////////////////////////////////////////Selling///////////////////////////////////////



            if (e.getSource() == Refresh) {
                productlist();
                Category.setSelectedIndex(0);
                search.setText("");
            }
            if (e.getSource() == Add) {
                if (name.getText().equals(""))
                    Name.setForeground(Color.RED);
                else Name.setForeground(Color.BLACK);
                if (quantity.getText().equals(""))
                    Quantity.setForeground(Color.RED);
                else Quantity.setForeground(Color.BLACK);
                int i = 0;
                if (name.getText().isEmpty() || quantity.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Missing Information");
                } else if (Quan < Integer.valueOf(quantity.getText())) {
                    JOptionPane.showMessageDialog(null, "We dont have that much quantity");
                } else {
                    i = i + 1;
                    ProdTot = Uprice * Integer.valueOf(quantity.getText());

                    if (i == 1) {
                        Total = Total + ProdTot;

                        Bill.setText(Bill.getText() + name.getText() + "\t    " + Uprice + "\t          " + quantity.getText() + "\t          " + ProdTot + "\n");

                        String uprice=Double.toString(Uprice);
                        String prodtot=Double.toString(ProdTot);
                       try {
                            //  Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bar", "root", "andiminaj1234");
                            String sql = "insert into bills(Waiter,Product,Price,Quantity,Total)values(?,?,?,?,?)";
                            PreparedStatement pre = con.prepareStatement(sql);
                            pre.setString(1, waiter.getText());
                            pre.setString(2,name.getText());
                            pre.setString(3, uprice);
                            pre.setString(4,quantity.getText());
                            pre.setString(5,prodtot);
                            pre.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Added");

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex);
                        }




                    }

                }


            }
            if (e.getSource() == Print) {
                String total = String.valueOf(Total);
                Bill.append("                                                                                        Total:" + total);
                int responds = JOptionPane.showConfirmDialog(this, "You sure you fineshed?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (responds == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "The payment:" + total);
                    pan.setVisible(true);
                    tab1.setEnabled(true);
                    tab2.setEnabled(true);
                    tab3.setEnabled(true);
                    tab4.setEnabled(true);
                    tab5.setEnabled(true);
                    tab6.setEnabled(true);
                    tab7.setEnabled(true);
                    tab8.setEnabled(true);
                    tab9.setEnabled(true);
                    tab10.setEnabled(true);
                    tab11.setEnabled(true);
                    tab12.setEnabled(true);
                    pan.setVisible(false);
                    Category.setSelectedIndex(0);
                    name.setText("");
                    quantity.setText("");
                    Bill.setText("=====================   BAR   ========================" + "\n" +
                            "Product                    Price                    Quantity                    Total" + "\n"
                    );
                    productlist();


                }


            }
            if (e.getSource() == Clear) {
                name.setText("");
                quantity.setText("");
            }
            if (e.getSource() == Filter) {
                if (search.getText().length() == 0 && Category.getSelectedIndex() != 0) {

                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bar", "root", "andiminaj1234");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("Select * from products where category='" + Category.getSelectedItem().toString() + "'");
                        Tab.setModel(DbUtils.resultSetToTableModel(rs));
                    } catch (SQLException ex) {
                        ex.printStackTrace();
           /* } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }

            */

                    }
                }

            }
        }




                                                    @Override
                                                    public void keyTyped (KeyEvent e){

                                                    }

                                                    @Override
                                                    public void keyPressed (KeyEvent e){

                                                    }

                                                    @Override
                                                    public void keyReleased (KeyEvent e){

                                                    }

                                                    @Override
                                                    public void mouseClicked (MouseEvent e){
                                                        if (e.getSource() == Logout) {
                                                            frame.setVisible(false);
                                                            new Login();


                                                        }

                                                        if (e.getSource() == Tab) {
                                                            DefaultTableModel Df = (DefaultTableModel) Tab.getModel();
                                                            int Selectindex = Tab.getSelectedRow();

                                                            name.setText(Df.getValueAt(Selectindex, 1).toString());
                                                            // N=String.valueOf(Df.getValueAt(Selectindex,1).toString());
                                                            Uprice = Integer.valueOf(Df.getValueAt(Selectindex, 3).toString());
                                                            Quan = Integer.valueOf(Df.getValueAt(Selectindex, 2).toString());
                                                        }

                                                    }

                                                    @Override
                                                    public void mousePressed (MouseEvent e){

                                                    }

                                                    @Override
                                                    public void mouseReleased (MouseEvent e){

                                                    }

                                                    @Override
                                                    public void mouseEntered (MouseEvent e){

                                                    }

                                                    @Override
                                                    public void mouseExited (MouseEvent e){

                                                    }

                                                    @Override
                                                    public void windowOpened (WindowEvent e){

                                                    }

                                                    @Override
                                                    public void windowClosing (WindowEvent e){
                                                        if (e.getSource() == frame1) {
                                                            if (frame1.getTitle().equals(tab1.getText())) {
                                                                tab1.setBackground(Color.green);
                                                            }
                                                            if (frame1.getTitle().equals(tab2.getText())) {
                                                                tab2.setBackground(Color.green);
                                                            }
                                                            if (frame1.getTitle().equals(tab3.getText())) {
                                                                tab3.setBackground(Color.green);
                                                            }
                                                            if (frame1.getTitle().equals(tab4.getText())) {
                                                                tab4.setBackground(Color.green);
                                                            }
                                                            if (frame1.getTitle().equals(tab5.getText())) {
                                                                tab5.setBackground(Color.green);
                                                            }
                                                            if (frame1.getTitle().equals(tab6.getText())) {
                                                                tab6.setBackground(Color.green);
                                                            }
                                                            if (frame1.getTitle().equals(tab7.getText())) {
                                                                tab7.setBackground(Color.green);
                                                            }
                                                            if (frame1.getTitle().equals(tab8.getText())) {
                                                                tab8.setBackground(Color.green);
                                                            }
                                                            if (frame1.getTitle().equals(tab9.getText())) {
                                                                tab9.setBackground(Color.green);
                                                            }
                                                            if (frame1.getTitle().equals(tab10.getText())) {
                                                                tab10.setBackground(Color.green);
                                                            }
                                                            if (frame1.getTitle().equals(tab11.getText())) {
                                                                tab11.setBackground(Color.green);
                                                            }
                                                            if (frame1.getTitle().equals(tab12.getText())) {
                                                                tab12.setBackground(Color.green);
                                                            }
                                                        }
                                                    }
                                                    @Override
                                                    public void windowClosed (WindowEvent e){

                                                    }

                                                    @Override
                                                    public void windowIconified (WindowEvent e){

                                                    }

                                                    @Override
                                                    public void windowDeiconified (WindowEvent e){

                                                    }

                                                    @Override
                                                    public void windowActivated (WindowEvent e){

                                                    }

                                                    @Override
                                                    public void windowDeactivated (WindowEvent e){

                                                    }
                                                }
