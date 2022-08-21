import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

public class Admin extends JFrame implements ActionListener, MouseListener, KeyListener {
    JFrame frame;

    JPanel Pan1;
    JPanel products;
    JPanel Pan2;
    JPanel waiter;
    JPanel Pan3;
    JPanel categorys;

    JLabel pan1;
    JLabel pan2;
    JLabel pan3;
    JLabel Logout;
    JLabel Title;
    JLabel Prodid;
    JLabel name;
    JLabel cate;
    JLabel quantity;
    JLabel price;
    JLabel tablename;
    JLabel STitle;
    JLabel ID;
    JLabel NameWaiter;
    JLabel Password;
    JLabel Gender;
    JLabel Wtablename;
    JLabel CTitle;
    JLabel CID;
    JLabel Description;
    JLabel CName;
    JLabel ctablename;


    JTextField prodid;
    JTextField Name;
    JTextField Quntity;
    JTextField Price;
    JTextField id;
    JTextField namewaiter;
    JTextField password;
    JTextField cid;
    JTextField description;
    JTextField Cname;


    JComboBox Cate;
    JComboBox gender;

    JButton Add;
    JButton Edite;
    JButton Delete;
    JButton Clear;
    JButton WAdd;
    JButton WEdite;
    JButton WDelete;
    JButton WClear;
    JButton CAdd;
    JButton CEdite;
    JButton CDelete;
    JButton CClear;

    JTable Productlist;
    JTable Waiterlist;
    JTable Categorylist;

    private void waiterlist() {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bar", "root", "andiminaj1234");
            Statement st = con.createStatement();
            String sql = "Select * from waiter";
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData RSS = rs.getMetaData();
            int c = RSS.getColumnCount();
            DefaultTableModel Df = (DefaultTableModel) Waiterlist.getModel();
            Df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();

                for (int a = 1; a <= c; a++) {
                    v2.add(rs.getString("ID"));
                    v2.add(rs.getString("Name"));
                    v2.add(rs.getString("Password"));
                    v2.add(rs.getString("Gender"));


                }
                Df.addRow(v2);

            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void categorylist() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bar", "root", "andiminaj1234");
            Statement st = con.createStatement();
            String sql = "Select * from category";
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData RSS = rs.getMetaData();
            int c = RSS.getColumnCount();
            DefaultTableModel Df = (DefaultTableModel) Categorylist.getModel();
            Df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();

                for (int a = 1; a <= c; a++) {
                    v2.add(rs.getString("ID"));
                    v2.add(rs.getString("Name"));
                    v2.add(rs.getString("Description"));


                }
                Df.addRow(v2);

            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }

    private void productlist() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bar", "root", "andiminaj1234");
            Statement st = con.createStatement();
            String sql = "Select * from products";
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData RSS = rs.getMetaData();
            int c = RSS.getColumnCount();
            DefaultTableModel Df = (DefaultTableModel) Productlist.getModel();
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

    private void Categoriess() {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bar", "root", "andiminaj1234");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("Select Name from category");
            while (rs.next()) {
                String name = rs.getString("Name");
                Cate.addItem(name);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Admin() {

        Logout = new JLabel("Logout");
        Logout.setForeground(Color.WHITE);
        Logout.setFont(new Font("sd", Font.ITALIC, 20));
        Logout.setBounds(10, 500, 75, 25);
        Logout.addMouseListener(this);
///////////////////       Products        /////////////////////////////
        Title = new JLabel("Management Product");
        Title.setFont(new Font("hgch", Font.CENTER_BASELINE, 20));
        Title.setForeground(Color.BLACK);
        Title.setBounds(230, 5, 230, 25);
/////////////////////////
        Prodid = new JLabel("ProdID:");
        Prodid.setFont(new Font("asd", Font.PLAIN, 15));
        Prodid.setForeground(Color.BLACK);
        Prodid.setBounds(40, 75, 75, 25);
        prodid = new JTextField();
        prodid.setForeground(Color.BLACK);
        prodid.setBounds(95, 79, 110, 20);
        prodid.addKeyListener(this);
////////////////////////////////////
        name = new JLabel("Name:");
        name.setForeground(Color.BLACK);
        name.setBounds(40, 110, 75, 25);
        name.setFont(new Font("asd", Font.PLAIN, 15));
        Name = new JTextField();
        Name.setForeground(Color.BLACK);
        Name.setBounds(95, 115, 110, 20);
        Name.addKeyListener(this);
/////////////////////////////////////
        quantity = new JLabel("Quantity:");
        quantity.setForeground(Color.BLACK);
        quantity.setFont(new Font("xf", Font.PLAIN, 15));
        quantity.setBounds(350, 75, 75, 25);
        Quntity = new JTextField();
        Quntity.setForeground(Color.BLACK);
        Quntity.setBounds(420, 80, 110, 20);
        Quntity.addKeyListener(this);
///////////////////////////////////
        price = new JLabel("Price:");
        price.setForeground(Color.BLACK);
        price.setBounds(370, 110, 75, 25);
        price.setFont(new Font("tg", Font.PLAIN, 15));
        Price = new JTextField();
        Price.setForeground(Color.BLACK);
        Price.setBounds(420, 110, 110, 20);
        Price.addKeyListener(this);
//////////////////////////////////
        cate = new JLabel("Category:");
        cate.setForeground(Color.BLACK);
        cate.setFont(new Font("ads", Font.PLAIN, 15));
        cate.setBounds(20, 150, 100, 25);
        Cate = new JComboBox();
        Cate.setBounds(95, 150, 110, 20);
        Categoriess();

/////////////////////////////////
        Add = new JButton("Add");
        Add.setForeground(Color.WHITE);
        Add.setBackground(Color.BLACK);
        Add.setBounds(60, 210, 80, 20);
        Add.setFocusPainted(false);
        Add.addActionListener(this);

        Edite = new JButton("Edit");
        Edite.setForeground(Color.WHITE);
        Edite.setBackground(Color.BLACK);
        Edite.setBounds(180, 210, 80, 20);
        Edite.setFocusPainted(false);
        Edite.addActionListener(this);

        Delete = new JButton("Delete");
        Delete.setForeground(Color.WHITE);
        Delete.setBackground(Color.BLACK);
        Delete.setBounds(340, 210, 80, 20);
        Delete.setFocusPainted(false);
        Delete.addActionListener(this);

        Clear = new JButton("Clear");
        Clear.setForeground(Color.WHITE);
        Clear.setBackground(Color.BLACK);
        Clear.setBounds(460, 210, 80, 20);
        Clear.setFocusPainted(false);
        Clear.addActionListener(this);
////////////////////////////////
        tablename = new JLabel("Product List");
        tablename.setFont(new Font("ds", Font.BOLD, 20));
        tablename.setForeground(Color.BLACK);
        tablename.setBounds(245, 250, 150, 25);

        products = new JPanel();
//products.setLayout(null);
        products.setBounds(0, 285, 627, 255);
        products.setBackground(Color.WHITE);
        String data[][] = {};
        String[] title = {"ID", "Name", "Quantity", "Price", "Category"};
        Productlist = new JTable();
        Productlist.setModel(new DefaultTableModel(data, title));
        Productlist.setEditingColumn(4);
        productlist();
        //  Categoriess();

        Productlist.setPreferredScrollableViewportSize(new Dimension(610, 226));
//Productlist.setModel(new DefaultTableModel(data,title));Productlist.setShowHorizontalLines(false);
        Productlist.setShowVerticalLines(false);
        Productlist.setShowHorizontalLines(false);
        Productlist.addMouseListener(this);
        products.add(new JScrollPane(Productlist));


///////////////////////////////
        Pan1 = new JPanel();
        Pan1.setBounds(150, 10, 627, 540);
        Pan1.setLayout(null);
        Pan1.setBackground(Color.WHITE);
//Pan1.setVisible(false);
        Pan1.add(Title);
        Pan1.add(Prodid);
        Pan1.add(prodid);
        Pan1.add(name);
        Pan1.add(Name);
        Pan1.add(Quntity);
        Pan1.add(quantity);
        Pan1.add(Price);
        Pan1.add(price);
        Pan1.add(cate);
        Pan1.add(Cate);
        Pan1.add(products);
        Pan1.add(Add);
        Pan1.add(Clear);
        Pan1.add(Edite);
        Pan1.add(Delete);
        Pan1.add(tablename);
        pan1 = new JLabel("Product");
        pan1.setForeground(Color.WHITE);
        pan1.setBounds(10, 25, 75, 25);
        pan1.setFont(new Font("Ssd", Font.PLAIN, 20));
        pan1.addMouseListener(this);

//////////////////       Waiter          /////////////////////////////
        STitle = new JLabel("Management Waiters");
        STitle.setFont(new Font("hgch", Font.CENTER_BASELINE, 20));
        STitle.setForeground(Color.BLACK);
        STitle.setBounds(230, 5, 200, 25);
//////////////////////////////////////////////////////////////
        NameWaiter = new JLabel("ID:");
        NameWaiter.setFont(new Font("asd", Font.PLAIN, 15));
        NameWaiter.setForeground(Color.BLACK);
        NameWaiter.setBounds(40, 75, 75, 25);
        namewaiter = new JTextField();
        namewaiter.setForeground(Color.BLACK);
        namewaiter.setBounds(95, 79, 110, 20);
        namewaiter.addKeyListener(this);
////////////////////////////////////////////////////////////
        ID = new JLabel("Name:");
        ID.setForeground(Color.BLACK);
        ID.setBounds(40, 110, 75, 25);
        ID.setFont(new Font("asd", Font.PLAIN, 15));
        id = new JTextField();
        id.setForeground(Color.BLACK);
        id.setBounds(95, 115, 110, 20);
        id.addKeyListener(this);
////////////////////////////////////////////////////////////
        Password = new JLabel("Password:");
        Password.setForeground(Color.BLACK);
        Password.setFont(new Font("xf", Font.PLAIN, 15));
        Password.setBounds(350, 75, 75, 25);
        password = new JTextField();
        password.setForeground(Color.BLACK);
        password.setBounds(430, 80, 110, 20);
///////////////////////////////////////////////////////////
        Gender = new JLabel("Gender:");
        Gender.setForeground(Color.BLACK);
        Gender.setBounds(370, 110, 75, 25);
        Gender.setFont(new Font("tg", Font.PLAIN, 15));
        String g[] = {"Select", "Male", "Female"};
        gender = new JComboBox<>(g);
        gender.setBounds(430, 115, 110, 20);
////////////////////////////////////////////////////////
        WAdd = new JButton("Add");
        WAdd.setForeground(Color.WHITE);
        WAdd.setBackground(Color.BLACK);
        WAdd.setBounds(60, 210, 80, 20);
        WAdd.setFocusPainted(false);
        WAdd.addActionListener(this);

        WEdite = new JButton("Edit");
        WEdite.setForeground(Color.WHITE);
        WEdite.setBackground(Color.BLACK);
        WEdite.setBounds(180, 210, 80, 20);
        WEdite.setFocusPainted(false);
        WEdite.addActionListener(this);

        WDelete = new JButton("Delete");
        WDelete.setForeground(Color.WHITE);
        WDelete.setBackground(Color.BLACK);
        WDelete.setBounds(340, 210, 80, 20);
        WDelete.setFocusPainted(false);
        WDelete.addActionListener(this);

        WClear = new JButton("Clear");
        WClear.setForeground(Color.WHITE);
        WClear.setBackground(Color.BLACK);
        WClear.setBounds(460, 210, 80, 20);
        WClear.setFocusPainted(false);
        WClear.addActionListener(this);

///////////////////////////////////////////////////////
        Wtablename = new JLabel("Waiter List");
        Wtablename.setFont(new Font("ds", Font.BOLD, 20));
        Wtablename.setForeground(Color.BLACK);
        Wtablename.setBounds(245, 250, 150, 25);

        waiter = new JPanel();
//waiter.setLayout(null);
        waiter.setBounds(0, 285, 627, 255);
        waiter.setBackground(Color.WHITE);
        String sdata[][] = {};
        String[] stitle = {"ID", "Name", "Password", "Grende"};
        Waiterlist = new JTable();
        Waiterlist.setPreferredScrollableViewportSize(new Dimension(610, 226));
        Waiterlist.setModel(new DefaultTableModel(sdata, stitle));
        waiterlist();
        Waiterlist.setEnabled(true);
        Waiterlist.setShowHorizontalLines(false);
        Waiterlist.setShowVerticalLines(false);
        Waiterlist.addMouseListener(this);
        waiter.add(new JScrollPane(Waiterlist));

//////////////////////////////////////////////////////
        Pan2 = new JPanel();
        Pan2.setBounds(150, 10, 627, 540);
        Pan2.setBackground(Color.WHITE);
        Pan2.setLayout(null);
        Pan2.setVisible(false);
        Pan2.add(STitle);
        Pan2.add(NameWaiter);
        Pan2.add(namewaiter);
        Pan2.add(ID);
        Pan2.add(id);
        Pan2.add(Password);
        Pan2.add(password);
        Pan2.add(Gender);
        Pan2.add(gender);
        Pan2.add(WAdd);
        Pan2.add(WClear);
        Pan2.add(WEdite);
        Pan2.add(WDelete);
        Pan2.add(Wtablename);
        Pan2.add(waiter);
        pan2 = new JLabel("Waiter");
        pan2.setForeground(Color.WHITE);
        pan2.setBounds(10, 60, 75, 25);
        pan2.setFont(new Font("Ssd", Font.PLAIN, 20));
        pan2.addMouseListener(this);


/////////////////       Category        /////////////////////////////
        CTitle = new JLabel("Management Categories");
        CTitle.setFont(new Font("hgch", Font.CENTER_BASELINE, 20));
        CTitle.setForeground(Color.BLACK);
        CTitle.setBounds(230, 5, 250, 25);
///////////////////////////////////////////////////////////
        CID = new JLabel("ID:");
        CID.setForeground(Color.BLACK);
        CID.setBounds(40, 75, 75, 25);
        CID.setFont(new Font("asd", Font.PLAIN, 15));
        cid = new JTextField();
        cid.setForeground(Color.BLACK);
        cid.setBounds(70, 77, 110, 20);
        cid.addKeyListener(this);
//////////////////////////////////////////////////////////
        CName = new JLabel("Name:");
        CName.setForeground(Color.BLACK);
        CName.setFont(new Font("xf", Font.PLAIN, 15));
        CName.setBounds(350, 75, 75, 25);
        Cname = new JTextField();
        Cname.setForeground(Color.BLACK);
        Cname.setBounds(430, 80, 110, 20);
        Cname.addKeyListener(this);
/////////////////////////////////////////////////////////
        Description = new JLabel("Description:");
        Description.setForeground(Color.BLACK);
        Description.setBounds(160, 120, 100, 25);
        Description.setFont(new Font("asd", Font.PLAIN, 15));
        description = new JTextField();
        description.setForeground(Color.BLACK);
        description.setBounds(245, 125, 110, 20);
        description.addKeyListener(this);
////////////////////////////////////////////////////////
        CAdd = new JButton("Add");
        CAdd.setForeground(Color.WHITE);
        CAdd.setBackground(Color.BLACK);
        CAdd.setBounds(60, 210, 80, 20);
        CAdd.setFocusPainted(false);
        CAdd.addActionListener(this);

        CEdite = new JButton("Edit");
        CEdite.setForeground(Color.WHITE);
        CEdite.setBackground(Color.BLACK);
        CEdite.setBounds(180, 210, 80, 20);
        CEdite.setFocusPainted(false);
        CEdite.addActionListener(this);

        CDelete = new JButton("Delete");
        CDelete.setForeground(Color.WHITE);
        CDelete.setBackground(Color.BLACK);
        CDelete.setBounds(340, 210, 80, 20);
        CDelete.setFocusPainted(false);
        CDelete.addActionListener(this);

        CClear = new JButton("Clear");
        CClear.setForeground(Color.WHITE);
        CClear.setBackground(Color.BLACK);
        CClear.setBounds(460, 210, 80, 20);
        CClear.setFocusPainted(false);
        CClear.addActionListener(this);

////////////////////////////////////////////////////////
        ctablename = new JLabel("Category List");
        ctablename.setFont(new Font("ds", Font.BOLD, 20));
        ctablename.setForeground(Color.BLACK);
        ctablename.setBounds(245, 250, 150, 25);

        categorys = new JPanel();
//categorys.setLayout(null);
        categorys.setBounds(0, 285, 627, 255);
        categorys.setBackground(Color.WHITE);
        String cdata[][] = {};
        String[] ctitle = {"ID", "Name", "Description"};
        Categorylist = new JTable();
        Categorylist.setModel(new DefaultTableModel(cdata, ctitle));
        //  Categorylist.setEditingColumn(4);
        //categorieslist();
        Categorylist.setPreferredScrollableViewportSize(new Dimension(610, 226));
//Productlist.setModel(new DefaultTableModel(data,title));
//Productlist.setEnabled(false);
        Categorylist.setShowHorizontalLines(false);
        Categorylist.setShowVerticalLines(false);
        Categorylist.addMouseListener(this);
        categorys.add(new JScrollPane(Categorylist));

///////////////////////////////////////////////////////
        CTitle = new JLabel("Management Categories");
        CTitle.setFont(new Font("hgch", Font.CENTER_BASELINE, 20));
        CTitle.setForeground(Color.BLACK);
        CTitle.setBounds(230, 5, 250, 25);
///////////////////////////////////////////////////////////
        CID = new JLabel("ID:");
        CID.setForeground(Color.BLACK);
        CID.setBounds(40, 75, 75, 25);
        CID.setFont(new Font("asd", Font.PLAIN, 15));
        cid = new JTextField();
        cid.setForeground(Color.BLACK);
        cid.setBounds(70, 77, 110, 20);
        cid.addKeyListener(this);
//////////////////////////////////////////////////////////
        CName = new JLabel("Name:");
        CName.setForeground(Color.BLACK);
        CName.setFont(new Font("xf", Font.PLAIN, 15));
        CName.setBounds(350, 75, 75, 25);
        Cname = new JTextField();
        Cname.setForeground(Color.BLACK);
        Cname.setBounds(430, 80, 110, 20);
        Cname.addKeyListener(this);
/////////////////////////////////////////////////////////
        Description = new JLabel("Description:");
        Description.setForeground(Color.BLACK);
        Description.setBounds(160, 120, 100, 25);
        Description.setFont(new Font("asd", Font.PLAIN, 15));
        description = new JTextField();
        description.setForeground(Color.BLACK);
        description.setBounds(245, 125, 110, 20);
        description.addKeyListener(this);
////////////////////////////////////////////////////////
        CAdd = new JButton("Add");
        CAdd.setForeground(Color.WHITE);
        CAdd.setBackground(Color.BLACK);
        CAdd.setBounds(60, 210, 80, 20);
        CAdd.setFocusPainted(false);
        CAdd.addActionListener(this);

        CEdite = new JButton("Edit");
        CEdite.setForeground(Color.WHITE);
        CEdite.setBackground(Color.BLACK);
        CEdite.setBounds(180, 210, 80, 20);
        CEdite.setFocusPainted(false);
        CEdite.addActionListener(this);

        CDelete = new JButton("Delete");
        CDelete.setForeground(Color.WHITE);
        CDelete.setBackground(Color.BLACK);
        CDelete.setBounds(340, 210, 80, 20);
        CDelete.setFocusPainted(false);
        CDelete.addActionListener(this);

        CClear = new JButton("Clear");
        CClear.setForeground(Color.WHITE);
        CClear.setBackground(Color.BLACK);
        CClear.setBounds(460, 210, 80, 20);
        CClear.setFocusPainted(false);
        CClear.addActionListener(this);

////////////////////////////////////////////////////////
        ctablename = new JLabel("Category List");
        ctablename.setFont(new Font("ds", Font.BOLD, 20));
        ctablename.setForeground(Color.BLACK);
        ctablename.setBounds(245, 250, 150, 25);

        categorys = new JPanel();
//categorys.setLayout(null);
        categorys.setBounds(0, 285, 627, 255);
        categorys.setBackground(Color.WHITE);
        String csdata[][] = {};
        String[] cstitle = {"ID", "Name", "Description"};
        Categorylist = new JTable();
        Categorylist.setModel(new DefaultTableModel(csdata, cstitle));
        //  Categorylist.setEditingColumn(4);
        categorylist();
        Categorylist.setPreferredScrollableViewportSize(new Dimension(610, 226));
//Productlist.setModel(new DefaultTableModel(data,title));
//Productlist.setEnabled(false);
        Categorylist.setShowHorizontalLines(false);
        Categorylist.setShowVerticalLines(false);
        Categorylist.addMouseListener(this);
        categorys.add(new JScrollPane(Categorylist));

///////////////////////////////////////////////////////
        Pan3 = new JPanel();
        Pan3.setBounds(150, 10, 627, 540);
        Pan3.setLayout(null);
        Pan3.setBackground(Color.WHITE);
        Pan3.setVisible(false);
        Pan3.add(CTitle);
        Pan3.add(cid);
        Pan3.add(CID);
        Pan3.add(CName);
        Pan3.add(Cname);
        Pan3.add(Description);
        Pan3.add(description);
        Pan3.add(CAdd);
        Pan3.add(CClear);
        Pan3.add(CDelete);
        Pan3.add(CEdite);
        Pan3.add(ctablename);
        Pan3.add(categorys);
        pan3 = new JLabel("Categories");
        pan3.setForeground(Color.WHITE);
        pan3.setBounds(10, 95, 100, 25);
        pan3.setFont(new Font("Ssd", Font.PLAIN, 20));
        pan3.addMouseListener(this);


        frame = new JFrame("Welcome Admin");
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setResizable(false);
        frame.add(pan1);
        frame.add(pan2);
        frame.add(pan3);
        frame.add(Logout);
        frame.add(Pan1);
        frame.add(Pan2);
        frame.add(Pan3);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        ///////////////////////////////////////////////////Categories///////////////////////////////////////////////
        if (e.getSource() == CAdd) {
            if (cid.getText().equals("")) CID.setForeground(Color.RED);
            else CID.setForeground(Color.BLACK);
            if (Cname.getText().equals("")) CName.setForeground(Color.RED);
            else Cname.setForeground(Color.BLACK);
            if (description.getText().equals("")) Description.setForeground(Color.RED);
            else Description.setForeground(Color.BLACK);

            if (CID.getForeground().equals(Color.BLACK) && CName.getForeground().equals(Color.BLACK) && Description.getForeground().equals(Color.BLACK)) {
                try {
                    //  Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bar", "root", "andiminaj1234");
                    String sql = "insert into category(ID,Name,Description)values(?,?,?)";
                    PreparedStatement pre = con.prepareStatement(sql);
                    pre.setString(1, cid.getText());
                    pre.setString(2, Cname.getText());
                    pre.setString(3, description.getText());
                    pre.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Update oki");
                    categorylist();
                    productlist();
                    // ();
                    cid.setText("");
                    Cname.setText("");
                    description.setText("");
                    CID.setForeground(Color.BLACK);
                    CName.setForeground(Color.BLACK);
                    Description.setForeground(Color.BLACK);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
        if (e.getSource() == CClear) {
            cid.setText("");
            Cname.setText("");
            description.setText("");
        }
        if (e.getSource() == CDelete) {
            if (cid.getText().equals("")) CID.setForeground(Color.RED);
            else CID.setForeground(Color.BLACK);
            if (Cname.getText().equals("")) CName.setForeground(Color.RED);
            else Cname.setForeground(Color.BLACK);
            if (description.getText().equals("")) Description.setForeground(Color.RED);
            else Description.setForeground(Color.BLACK);

            if (CID.getForeground().equals(Color.BLACK) && CName.getForeground().equals(Color.BLACK) && Description.getForeground().equals(Color.BLACK)) {
                try {

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bar", "root", "andiminaj1234");
                    String id = cid.getText();
                    String sql = "Delete from category where ID=" + id;

                    Statement rs = con.createStatement();
                    rs.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Deleted");
                    categorylist();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            }
        }
        if (e.getSource() == CEdite) {
            if (cid.getText().equals("")) CID.setForeground(Color.RED);
            else CID.setForeground(Color.BLACK);
            if (Cname.getText().equals("")) CName.setForeground(Color.RED);
            else Cname.setForeground(Color.BLACK);
            if (description.getText().equals("")) Description.setForeground(Color.RED);
            else Description.setForeground(Color.BLACK);

            if (CID.getForeground().equals(Color.BLACK) && CName.getForeground().equals(Color.BLACK) && Description.getForeground().equals(Color.BLACK)) {
                try {
                    DefaultTableModel Df = (DefaultTableModel) Categorylist.getModel();
                    int selectIndex = Categorylist.getSelectedRow();
                    String n = Cname.getText();
                    String d = description.getText();
                    //Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bar", "root", "andiminaj1234");
                    PreparedStatement insert = con.prepareStatement("update category set Name=?,Description=? where ID=?");
                    insert.setString(1, n);
                    insert.setString(2, d);
                    insert.setString(3, cid.getText());

                    insert.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Update Successful");
                    categorylist();
                    cid.setText("");
                    Cname.setText("");
                    description.setText("");
                    CID.setForeground(Color.BLACK);
                    CName.setForeground(Color.BLACK);
                    Description.setForeground(Color.BLACK);


                /*try {


                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/supermarket", "root", "");

                    String sql = "Update seller set Name='" + id.getText() + "'" + ",Password='" + password.getText() + "'" + ",Gender='" + gender.getSelectedItem().toString() + "'" + "where ID=" + nameseller.getText();
                    Statement pre = con.createStatement();

                    pre.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Update Successful");
                    sellerlist();
                    id.setText("");
                    nameseller.setText("");
                    password.setText("");
                    gender.setSelectedIndex(0);
                    ID.setForeground(new Color(53, 223, 50));
                    NameSeller.setForeground(new Color(53, 223, 50));
                    Password.setForeground(new Color(53, 223, 50));
                    Gender.setForeground(new Color(53, 223, 50));

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

                 */
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            }


        }

        /////////////////////////////////Product////////////////////////////////
        if (e.getSource() == Add) {

            if (prodid.getText().equals("")) Prodid.setForeground(Color.RED);
            else Prodid.setForeground(new Color(0, 0, 0));
            if (Name.getText().equals("")) name.setForeground(Color.RED);
            else name.setForeground(new Color(0, 0, 0));
            if (Quntity.getText().equals("")) quantity.setForeground(Color.RED);
            else quantity.setForeground(new Color(0, 0, 0));
            if (Price.getText().equals("")) price.setForeground(Color.RED);
            else price.setForeground(new Color(0, 0, 0));
            if (Cate.getSelectedIndex() == 0) cate.setForeground(Color.RED);
            else cate.setForeground(new Color(0, 0, 0));
            if (Prodid.getForeground().equals(new Color(0, 0, 0)) && name.getForeground().equals(new Color(0, 0, 0)) && quantity.getForeground().equals(new Color(0, 0, 0)) && price.getForeground().equals(new Color(0, 0, 0)) && cate.getForeground().equals(new Color(0, 0, 0)))
                try {
                    //Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bar", "root", "andiminaj1234");
                    String sql = "insert into products(ID,Name,Quantity,Price,Category)values(?,?,?,?,?)";
                    PreparedStatement pre = con.prepareStatement(sql);
                    pre.setString(1, prodid.getText());
                    pre.setString(2, Name.getText());
                    pre.setString(3, Quntity.getText());
                    pre.setString(4, Price.getText());
                    pre.setString(5, Cate.getSelectedItem().toString());

                    pre.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Update oki");
                    productlist();
                   // Categoriess();
                    prodid.setText("");
                    Name.setText("");
                    Quntity.setText("");
                    Cate.setSelectedIndex(0);
                    Price.setText("");
                    Prodid.setForeground(new Color(0, 0, 0));
                    name.setForeground(new Color(0, 0, 0));
                    cate.setForeground(new Color(0, 0, 0));
                    price.setForeground(new Color(0, 0, 0));
                    Quntity.setForeground(new Color(0, 0, 0));


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }


            {

            }


        }
        if (e.getSource() == Clear) {
            prodid.setText("");
            Name.setText("");
            Quntity.setText("");
            Price.setText("");
            Cate.setSelectedIndex(0);
        }
        if (e.getSource() == Edite) {
            if (prodid.getText().equals("")) Prodid.setForeground(Color.RED);
            else Prodid.setForeground(new Color(0, 0, 0));
            if (Name.getText().equals("")) name.setForeground(Color.RED);
            else name.setForeground(new Color(0, 0, 0));
            if (Quntity.getText().equals("")) quantity.setForeground(Color.RED);
            else quantity.setForeground(new Color(0, 0, 0));
            if (Price.getText().equals("")) price.setForeground(Color.RED);
            else price.setForeground(new Color(0, 0, 0));
            if (Cate.getSelectedIndex() == 0) cate.setForeground(Color.RED);
            else cate.setForeground(new Color(0, 0, 0));
            if (Prodid.getForeground().equals(new Color(0, 0, 0)) && name.getForeground().equals(new Color(0, 0, 0)) && quantity.getForeground().equals(new Color(0, 0, 0)) && price.getForeground().equals(new Color(0, 0, 0)) && cate.getForeground().equals(new Color(0, 0, 0))) {
                // DefaultTableModel Df=(DefaultTableModel) Productlist.getModel();
                // int selectIndex=Productlist.getSelectedRow();
                try {
                    //   int id=Integer.parseInt(Df.getValueAt(selectIndex,0).toString());
                    //   String Id=prodid.getText();
                    //   String nAme=Name.getText();
                    //  String category=Cate.getSelectedItem().toString();
                    //  String pRice=Price.getText();
                    //  String quantity=Quntity.getText();

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bar", "root", "andiminaj1234");

                    String sql = "Update products set Name='" + Name.getText() + "'" + ",Quantity='" + Quntity.getText() + "'" + ",Price='" + Price.getText() + "'" + ",Category='" + Cate.getSelectedItem().toString() + "'" + "where ID=" + prodid.getText();
                    Statement pre = con.createStatement();
                    //pre.setString(1,Id);
                    //pre.setString(2,nAme);
                    //pre.setString(3,category);
                    // pre.setString(4,pRice);
                    // pre.setString(5,quantity);

                    pre.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Update Successful");
                    productlist();
                    prodid.setText("");
                    Name.setText("");
                    Quntity.setText("");
                    Cate.setSelectedIndex(0);
                    Price.setText("");
                    Prodid.setForeground(new Color(0, 0, 0));
                    name.setForeground(new Color(0, 0, 0));
                    cate.setForeground(new Color(0, 0, 0));
                    price.setForeground(new Color(0, 0, 0));
                    Quntity.setForeground(new Color(0, 0, 0));

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }

        }
        if (e.getSource() == Delete) {
            if (prodid.getText().equals("")) Prodid.setForeground(Color.RED);
            else Prodid.setForeground(new Color(0, 0, 0));
            if (Name.getText().equals("")) name.setForeground(Color.RED);
            else name.setForeground(new Color(0, 0, 0));
            if (Quntity.getText().equals("")) quantity.setForeground(Color.RED);
            else quantity.setForeground(new Color(0, 0, 0));
            if (Price.getText().equals("")) price.setForeground(Color.RED);
            else price.setForeground(new Color(0, 0, 0));
            if (Cate.getSelectedIndex() == 0) cate.setForeground(Color.RED);
            else cate.setForeground(new Color(0, 0, 0));
            if (Prodid.getForeground().equals(new Color(0, 0, 0)) && name.getForeground().equals(new Color(0, 0, 0)) && quantity.getForeground().equals(new Color(0, 0, 0)) && price.getForeground().equals(new Color(0, 0, 0)) && cate.getForeground().equals(new Color(0, 0, 0))) {
                try {

                    //Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bar", "root", "andiminaj1234");
                    String id = prodid.getText();
                    String sql = "Delete from products where ID=" + id;

                    Statement rs = con.createStatement();
                    rs.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Deleted");
                    productlist();


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            }
        }
        ///////////////////////////////////////////////////Seller///////////////////////////////////////////////
        if (e.getSource() == WAdd) {
            if (id.getText().equals("")) ID.setForeground(Color.RED);
            else ID.setForeground(Color.BLACK);
            if (namewaiter.getText().equals("")) NameWaiter.setForeground(Color.RED);
            else NameWaiter.setForeground(Color.BLACK);
            if (password.getText().equals("")) Password.setForeground(Color.RED);
            else Password.setForeground(Color.BLACK);
            if (gender.getSelectedIndex() == 0) Gender.setForeground(Color.RED);
            else Gender.setForeground(Color.BLACK);
            if (ID.getForeground().equals(Color.BLACK) && NameWaiter.getForeground().equals(Color.BLACK) && Password.getForeground().equals(Color.BLACK) && Gender.getForeground().equals(Color.BLACK))
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bar", "root", "andiminaj1234");
                    String sql = "insert into waiter(ID,Name,Password,Gender)values(?,?,?,?)";
                    PreparedStatement pre = con.prepareStatement(sql);
                    pre.setString(1, namewaiter.getText());
                    pre.setString(2, id.getText());
                    pre.setString(3, password.getText());
                    pre.setString(4, gender.getSelectedItem().toString());

                    pre.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Update oki");
                    waiterlist();
                    id.setText("");
                    namewaiter.setText("");
                    password.setText("");
                    gender.setSelectedIndex(0);
                    ID.setForeground(Color.BLACK);
                    NameWaiter.setForeground(Color.BLACK);
                    Password.setForeground(Color.BLACK);
                    Gender.setForeground(Color.BLACK);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
        }


        if (e.getSource() == WClear) {
            id.setText("");
            namewaiter.setText("");
            password.setText("");
            gender.setSelectedIndex(0);
        }
        if (e.getSource() == WDelete) {

            if (id.getText().equals("")) ID.setForeground(Color.RED);
            else ID.setForeground(Color.BLACK);
            if (namewaiter.getText().equals("")) NameWaiter.setForeground(Color.RED);
            else NameWaiter.setForeground(Color.BLACK);
            if (password.getText().equals("")) Password.setForeground(Color.RED);
            else Password.setForeground(Color.BLACK);
            if (gender.getSelectedIndex() == 0) Gender.setForeground(Color.RED);
            else Gender.setForeground(Color.BLACK);
            if (ID.getForeground().equals(Color.BLACK) && NameWaiter.getForeground().equals(Color.BLACK) && Password.getForeground().equals(Color.BLACK) && Gender.getForeground().equals(Color.BLACK))
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bar", "root", "andiminaj1234");
                    String id = namewaiter.getText();
                    String sql = "Delete from waiter where ID=" + id;

                    Statement rs = con.createStatement();
                    rs.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Deleted");
                    waiterlist();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

        }

        if (e.getSource() == WEdite) {
            if (id.getText().equals("")) ID.setForeground(Color.RED);
            else ID.setForeground(Color.BLACK);
            if (namewaiter.getText().equals("")) NameWaiter.setForeground(Color.RED);
            else NameWaiter.setForeground(Color.BLACK);
            if (password.getText().equals("")) Password.setForeground(Color.RED);
            else Password.setForeground(Color.BLACK);
            if (gender.getSelectedIndex() == 0) Gender.setForeground(Color.RED);
            else Gender.setForeground(Color.BLACK);
            if (ID.getForeground().equals(Color.BLACK) && NameWaiter.getForeground().equals(Color.BLACK) && Password.getForeground().equals(Color.BLACK) && Gender.getForeground().equals(Color.BLACK)) {
                try {
                    DefaultTableModel Df = (DefaultTableModel) Waiterlist.getModel();
                    int selectIndex = Waiterlist.getSelectedRow();
                    String n = id.getText();
                    String p = password.getText();
                    String g = gender.getSelectedItem().toString();
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bar", "root", "andiminaj1234");
                    PreparedStatement insert = con.prepareStatement("update waiter set Name=?,Password=?,Gender=? where ID=?");
                    insert.setString(1, n);
                    insert.setString(2, p);
                    insert.setString(3, g);
                    insert.setString(4, namewaiter.getText());

                    insert.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Update Successful");
                    waiterlist();
                    id.setText("");
                    namewaiter.setText("");
                    password.setText("");
                    gender.setSelectedIndex(0);
                    ID.setForeground(Color.BLACK);
                    NameWaiter.setForeground(Color.BLACK);
                    Password.setForeground(Color.BLACK);
                    Gender.setForeground(Color.BLACK);


                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }


        }

    }







    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == pan1) {
            Pan1.setVisible(true);
            Pan2.setVisible(false);
            Pan3.setVisible(false);

        }
        if (e.getSource() == pan2) {
            Pan1.setVisible(false);
            Pan2.setVisible(true);
            Pan3.setVisible(false);
        }
        if (e.getSource() == pan3) {
            Pan1.setVisible(false);
            Pan2.setVisible(false);
            Pan3.setVisible(true);
        }
        ///////////////////////////Seller//////////////////////
        if (e.getSource() == Waiterlist) {
            DefaultTableModel SDf = (DefaultTableModel) Waiterlist.getModel();
            int SSelectindex = Waiterlist.getSelectedRow();


            namewaiter.setText(SDf.getValueAt(SSelectindex, 0).toString());
            id.setText(SDf.getValueAt(SSelectindex, 1).toString());
            password.setText(SDf.getValueAt(SSelectindex, 2).toString());

            waiterlist();
        }
        //////////////////////////Categories//////////////////////
        if (e.getSource() == Categorylist) {
            DefaultTableModel Df = (DefaultTableModel) Categorylist.getModel();
            int Selectindex = Categorylist.getSelectedRow();


            cid.setText(Df.getValueAt(Selectindex, 0).toString());
            Cname.setText(Df.getValueAt(Selectindex, 1).toString());
            description.setText(Df.getValueAt(Selectindex, 2).toString());

            categorylist();
        }
        ////////////////////Products/////////////////////
        if (e.getSource() == Productlist) {
            DefaultTableModel Df = (DefaultTableModel) Productlist.getModel();
            int Selectindex = Productlist.getSelectedRow();

            prodid.setText(Df.getValueAt(Selectindex, 0).toString());
            Name.setText(Df.getValueAt(Selectindex, 1).toString());
            Quntity.setText(Df.getValueAt(Selectindex, 2).toString());
            Price.setText(Df.getValueAt(Selectindex, 3).toString());

            productlist();

        }
        if (e.getSource() == Logout) {

            frame.setVisible(false);
            new Login();


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
