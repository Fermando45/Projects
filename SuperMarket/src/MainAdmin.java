import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

public class MainAdmin extends JFrame implements ActionListener, MouseListener,KeyListener {
    JFrame frame;

    JPanel Pan1;
    JPanel products;
    JPanel Pan2;
    JPanel sellers;
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
    JLabel NameSeller;
    JLabel Password;
    JLabel Gender;
    JLabel Stablename;
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
    JTextField nameseller;
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
    JButton SAdd;
    JButton SEdite;
    JButton SDelete;
    JButton SClear;
    JButton CAdd;
    JButton CEdite;
    JButton CDelete;
    JButton CClear;

    JTable Productlist;
    JTable Sellerlist;
    JTable Categorylist;

    private void Categoriess() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("Select Name from Categories");
            while (rs.next()) {
                String name = rs.getString("Name");
                Cate.addItem(name);
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

    private void sellerlist() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/supermarket", "root", "");
            Statement st = con.createStatement();
            String sql = "Select * from seller";
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData RSS = rs.getMetaData();
            int c = RSS.getColumnCount();
            DefaultTableModel Df = (DefaultTableModel) Sellerlist.getModel();
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

    private void categorieslist() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/supermarket", "root", "");
            Statement st = con.createStatement();
            String sql = "Select * from categories";
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


    MainAdmin() {

        Logout = new JLabel("Logout");
        Logout.setForeground(Color.WHITE);
        Logout.setFont(new Font("sd", Font.ITALIC, 20));
        Logout.setBounds(10, 500, 75, 25);
        Logout.addMouseListener(this);

///////////////////Prodyct///////////////////////////////////
        Title = new JLabel("Management Product");
        Title.setFont(new Font("hgch", Font.CENTER_BASELINE, 20));
        Title.setForeground(new Color(53, 223, 50));
        Title.setBounds(230, 5, 230, 25);
/////////////////////////
        Prodid = new JLabel("ProdID:");
        Prodid.setFont(new Font("asd", Font.PLAIN, 15));
        Prodid.setForeground(new Color(53, 223, 50));
        Prodid.setBounds(40, 75, 75, 25);
        prodid = new JTextField();
        prodid.setForeground(new Color(53, 223, 50));
        prodid.setBounds(95, 79, 110, 20);
        prodid.addKeyListener(this);
////////////////////////////////////
        name = new JLabel("Name:");
        name.setForeground(new Color(53, 223, 50));
        name.setBounds(40, 110, 75, 25);
        name.setFont(new Font("asd", Font.PLAIN, 15));
        Name = new JTextField();
        Name.setForeground(new Color(53, 223, 50));
        Name.setBounds(95, 115, 110, 20);
        Name.addKeyListener(this);
/////////////////////////////////////
        quantity = new JLabel("Quantity:");
        quantity.setForeground(new Color(53, 223, 50));
        quantity.setFont(new Font("xf", Font.PLAIN, 15));
        quantity.setBounds(350, 75, 75, 25);
        Quntity = new JTextField();
        Quntity.setForeground(new Color(53, 223, 50));
        Quntity.setBounds(420, 80, 110, 20);
        Quntity.addKeyListener(this);
///////////////////////////////////
        price = new JLabel("Price:");
        price.setForeground(new Color(53, 223, 50));
        price.setBounds(370, 110, 75, 25);
        price.setFont(new Font("tg", Font.PLAIN, 15));
        Price = new JTextField();
        Price.setForeground(new Color(53, 223, 50));
        Price.setBounds(420, 110, 110, 20);
        Price.addKeyListener(this);
//////////////////////////////////
        cate = new JLabel("Category:");
        cate.setForeground(new Color(53, 223, 50));
        cate.setFont(new Font("ads", Font.PLAIN, 15));
        cate.setBounds(20, 150, 100, 25);
        Cate = new JComboBox();
        Cate.setBounds(95, 150, 110, 20);
        Categoriess();

/////////////////////////////////
        Add = new JButton("Add");
        Add.setForeground(Color.WHITE);
        Add.setBackground(new Color(53, 223, 50));
        Add.setBounds(60, 210, 80, 20);
        Add.setFocusPainted(false);
        Add.addActionListener(this);

        Edite = new JButton("Edit");
        Edite.setForeground(Color.WHITE);
        Edite.setBackground(new Color(53, 223, 50));
        Edite.setBounds(180, 210, 80, 20);
        Edite.setFocusPainted(false);
        Edite.addActionListener(this);

        Delete = new JButton("Delete");
        Delete.setForeground(Color.WHITE);
        Delete.setBackground(new Color(53, 223, 50));
        Delete.setBounds(340, 210, 80, 20);
        Delete.setFocusPainted(false);
        Delete.addActionListener(this);

        Clear = new JButton("Clear");
        Clear.setForeground(Color.WHITE);
        Clear.setBackground(new Color(53, 223, 50));
        Clear.setBounds(460, 210, 80, 20);
        Clear.setFocusPainted(false);
        Clear.addActionListener(this);
////////////////////////////////
        tablename = new JLabel("Product List");
        tablename.setFont(new Font("ds", Font.BOLD, 20));
        tablename.setForeground(new Color(53, 223, 50));
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
///////////////////Seller/////////////////////////////////////
        STitle = new JLabel("Management Seller");
        STitle.setFont(new Font("hgch", Font.CENTER_BASELINE, 20));
        STitle.setForeground(new Color(53, 223, 50));
        STitle.setBounds(230, 5, 200, 25);
//////////////////////////////////////////////////////////////
        NameSeller = new JLabel("ID:");
        NameSeller.setFont(new Font("asd", Font.PLAIN, 15));
        NameSeller.setForeground(new Color(53, 223, 50));
        NameSeller.setBounds(40, 75, 75, 25);
        nameseller = new JTextField();
        nameseller.setForeground(new Color(53, 223, 50));
        nameseller.setBounds(95, 79, 110, 20);
        nameseller.addKeyListener(this);
////////////////////////////////////////////////////////////
        ID = new JLabel("Name:");
        ID.setForeground(new Color(53, 223, 50));
        ID.setBounds(40, 110, 75, 25);
        ID.setFont(new Font("asd", Font.PLAIN, 15));
        id = new JTextField();
        id.setForeground(new Color(53, 223, 50));
        id.setBounds(95, 115, 110, 20);
        id.addKeyListener(this);
////////////////////////////////////////////////////////////
        Password = new JLabel("Password:");
        Password.setForeground(new Color(53, 223, 50));
        Password.setFont(new Font("xf", Font.PLAIN, 15));
        Password.setBounds(350, 75, 75, 25);
        password = new JTextField();
        password.setForeground(new Color(53, 223, 50));
        password.setBounds(430, 80, 110, 20);
///////////////////////////////////////////////////////////
        Gender = new JLabel("Gender:");
        Gender.setForeground(new Color(53, 223, 50));
        Gender.setBounds(370, 110, 75, 25);
        Gender.setFont(new Font("tg", Font.PLAIN, 15));
        String g[] = {"Select", "Male", "Female"};
        gender = new JComboBox<>(g);
        gender.setBounds(430, 115, 110, 20);
////////////////////////////////////////////////////////
        SAdd = new JButton("Add");
        SAdd.setForeground(Color.WHITE);
        SAdd.setBackground(new Color(53, 223, 50));
        SAdd.setBounds(60, 210, 80, 20);
        SAdd.setFocusPainted(false);
        SAdd.addActionListener(this);

        SEdite = new JButton("Edit");
        SEdite.setForeground(Color.WHITE);
        SEdite.setBackground(new Color(53, 223, 50));
        SEdite.setBounds(180, 210, 80, 20);
        SEdite.setFocusPainted(false);
        SEdite.addActionListener(this);

        SDelete = new JButton("Delete");
        SDelete.setForeground(Color.WHITE);
        SDelete.setBackground(new Color(53, 223, 50));
        SDelete.setBounds(340, 210, 80, 20);
        SDelete.setFocusPainted(false);
        SDelete.addActionListener(this);

        SClear = new JButton("Clear");
        SClear.setForeground(Color.WHITE);
        SClear.setBackground(new Color(53, 223, 50));
        SClear.setBounds(460, 210, 80, 20);
        SClear.setFocusPainted(false);
        SClear.addActionListener(this);

///////////////////////////////////////////////////////
        Stablename = new JLabel("Seller List");
        Stablename.setFont(new Font("ds", Font.BOLD, 20));
        Stablename.setForeground(new Color(53, 223, 50));
        Stablename.setBounds(245, 250, 150, 25);

        sellers = new JPanel();
//seller.setLayout(null);
        sellers.setBounds(0, 285, 627, 255);
        sellers.setBackground(Color.WHITE);
        String sdata[][] = {};
        String[] stitle = {"ID", "Name", "Password", "Grende"};
        Sellerlist = new JTable();
        Sellerlist.setPreferredScrollableViewportSize(new Dimension(610, 226));
        Sellerlist.setModel(new DefaultTableModel(sdata, stitle));
        sellerlist();
        Sellerlist.setEnabled(true);
        Sellerlist.setShowHorizontalLines(false);
        Sellerlist.setShowVerticalLines(false);
        Sellerlist.addMouseListener(this);
        sellers.add(new JScrollPane(Sellerlist));

//////////////////////////////////////////////////////
        Pan2 = new JPanel();
        Pan2.setBounds(150, 10, 627, 540);
        Pan2.setBackground(Color.WHITE);
        Pan2.setLayout(null);
        Pan2.setVisible(false);
        Pan2.add(STitle);
        Pan2.add(NameSeller);
        Pan2.add(nameseller);
        Pan2.add(ID);
        Pan2.add(id);
        Pan2.add(Password);
        Pan2.add(password);
        Pan2.add(Gender);
        Pan2.add(gender);
        Pan2.add(SAdd);
        Pan2.add(SClear);
        Pan2.add(SEdite);
        Pan2.add(SDelete);
        Pan2.add(Stablename);
        Pan2.add(sellers);
        pan2 = new JLabel("Seller");
        pan2.setForeground(Color.WHITE);
        pan2.setBounds(10, 60, 75, 25);
        pan2.setFont(new Font("Ssd", Font.PLAIN, 20));
        pan2.addMouseListener(this);


/////////////////Categories/////////////////////////////////
        CTitle = new JLabel("Management Categories");
        CTitle.setFont(new Font("hgch", Font.CENTER_BASELINE, 20));
        CTitle.setForeground(new Color(53, 223, 50));
        CTitle.setBounds(230, 5, 250, 25);
///////////////////////////////////////////////////////////
        CID = new JLabel("ID:");
        CID.setForeground(new Color(53, 223, 50));
        CID.setBounds(40, 75, 75, 25);
        CID.setFont(new Font("asd", Font.PLAIN, 15));
        cid = new JTextField();
        cid.setForeground(new Color(53, 223, 50));
        cid.setBounds(70, 77, 110, 20);
        cid.addKeyListener(this);
//////////////////////////////////////////////////////////
        CName = new JLabel("Name:");
        CName.setForeground(new Color(53, 223, 50));
        CName.setFont(new Font("xf", Font.PLAIN, 15));
        CName.setBounds(350, 75, 75, 25);
        Cname = new JTextField();
        Cname.setForeground(new Color(53, 223, 50));
        Cname.setBounds(430, 80, 110, 20);
        Cname.addKeyListener(this);
/////////////////////////////////////////////////////////
        Description = new JLabel("Description:");
        Description.setForeground(new Color(53, 223, 50));
        Description.setBounds(160, 120, 100, 25);
        Description.setFont(new Font("asd", Font.PLAIN, 15));
        description = new JTextField();
        description.setForeground(new Color(53, 223, 50));
        description.setBounds(245, 125, 110, 20);
        description.addKeyListener(this);
////////////////////////////////////////////////////////
        CAdd = new JButton("Add");
        CAdd.setForeground(Color.WHITE);
        CAdd.setBackground(new Color(53, 223, 50));
        CAdd.setBounds(60, 210, 80, 20);
        CAdd.setFocusPainted(false);
        CAdd.addActionListener(this);

        CEdite = new JButton("Edit");
        CEdite.setForeground(Color.WHITE);
        CEdite.setBackground(new Color(53, 223, 50));
        CEdite.setBounds(180, 210, 80, 20);
        CEdite.setFocusPainted(false);
        CEdite.addActionListener(this);

        CDelete = new JButton("Delete");
        CDelete.setForeground(Color.WHITE);
        CDelete.setBackground(new Color(53, 223, 50));
        CDelete.setBounds(340, 210, 80, 20);
        CDelete.setFocusPainted(false);
        CDelete.addActionListener(this);

        CClear = new JButton("Clear");
        CClear.setForeground(Color.WHITE);
        CClear.setBackground(new Color(53, 223, 50));
        CClear.setBounds(460, 210, 80, 20);
        CClear.setFocusPainted(false);
        CClear.addActionListener(this);

////////////////////////////////////////////////////////
        ctablename = new JLabel("Category List");
        ctablename.setFont(new Font("ds", Font.BOLD, 20));
        ctablename.setForeground(new Color(53, 223, 50));
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
        categorieslist();
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
        frame.getContentPane().setBackground(new Color(53, 223, 50));
        frame.setResizable(false);
        frame.add(Pan1);
        frame.add(pan1);
        frame.add(Pan2);
        frame.add(pan2);
        frame.add(Pan3);
        frame.add(pan3);
        frame.add(Logout);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /////////////////////////////////Product////////////////////////////////
        if (e.getSource() == Add) {

            if (prodid.getText().equals("")) Prodid.setForeground(Color.RED);
            else Prodid.setForeground(new Color(53, 223, 50));
            if (Name.getText().equals("")) name.setForeground(Color.RED);
            else name.setForeground(new Color(53, 223, 50));
            if (Quntity.getText().equals("")) quantity.setForeground(Color.RED);
            else quantity.setForeground(new Color(53, 223, 50));
            if (Price.getText().equals("")) price.setForeground(Color.RED);
            else price.setForeground(new Color(53, 223, 50));
            if (Cate.getSelectedIndex() == 0) cate.setForeground(Color.RED);
            else cate.setForeground(new Color(53, 223, 50));
            if (Prodid.getForeground().equals(new Color(53, 223, 50)) && name.getForeground().equals(new Color(53, 223, 50)) && quantity.getForeground().equals(new Color(53, 223, 50)) && price.getForeground().equals(new Color(53, 223, 50)) && cate.getForeground().equals(new Color(53, 223, 50)))
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "");
                    String sql = "insert into product(ID,Name,Quantity,Price,Category)values(?,?,?,?,?)";
                    PreparedStatement pre = con.prepareStatement(sql);
                    pre.setString(1, prodid.getText());
                    pre.setString(2, Name.getText());
                    pre.setString(3, Quntity.getText());
                    pre.setString(4, Price.getText());
                    pre.setString(5, Cate.getSelectedItem().toString());

                    pre.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Update oki");
                    productlist();
                    Categoriess();
                    prodid.setText("");
                    Name.setText("");
                    Quntity.setText("");
                    Cate.setSelectedIndex(0);
                    Price.setText("");
                    Prodid.setForeground(new Color(53, 223, 50));
                    name.setForeground(new Color(53, 223, 50));
                    cate.setForeground(new Color(53, 223, 50));
                    price.setForeground(new Color(53, 223, 50));
                    Quntity.setForeground(new Color(53, 223, 50));


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
            else Prodid.setForeground(new Color(53, 223, 50));
            if (Name.getText().equals("")) name.setForeground(Color.RED);
            else name.setForeground(new Color(53, 223, 50));
            if (Quntity.getText().equals("")) quantity.setForeground(Color.RED);
            else quantity.setForeground(new Color(53, 223, 50));
            if (Price.getText().equals("")) price.setForeground(Color.RED);
            else price.setForeground(new Color(53, 223, 50));
            if (Cate.getSelectedIndex() == 0) cate.setForeground(Color.RED);
            else cate.setForeground(new Color(53, 223, 50));
            if (Prodid.getForeground().equals(new Color(53, 223, 50)) && name.getForeground().equals(new Color(53, 223, 50)) && quantity.getForeground().equals(new Color(53, 223, 50)) && price.getForeground().equals(new Color(53, 223, 50)) && cate.getForeground().equals(new Color(53, 223, 50))) {
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
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/supermarket", "root", "");

                    String sql = "Update product set Name='" + Name.getText() + "'" + ",Quantity='" + Quntity.getText() + "'" + ",Price='" + Price.getText() + "'" + ",Category='" + Cate.getSelectedItem().toString() + "'" + "where ID=" + prodid.getText();
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
                    Prodid.setForeground(new Color(53, 223, 50));
                    name.setForeground(new Color(53, 223, 50));
                    cate.setForeground(new Color(53, 223, 50));
                    price.setForeground(new Color(53, 223, 50));
                    Quntity.setForeground(new Color(53, 223, 50));

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }

        }
        if (e.getSource() == Delete) {
            if (prodid.getText().equals("")) Prodid.setForeground(Color.RED);
            else Prodid.setForeground(new Color(53, 223, 50));
            if (Name.getText().equals("")) name.setForeground(Color.RED);
            else name.setForeground(new Color(53, 223, 50));
            if (Quntity.getText().equals("")) quantity.setForeground(Color.RED);
            else quantity.setForeground(new Color(53, 223, 50));
            if (Price.getText().equals("")) price.setForeground(Color.RED);
            else price.setForeground(new Color(53, 223, 50));
            if (Cate.getSelectedIndex() == 0) cate.setForeground(Color.RED);
            else cate.setForeground(new Color(53, 223, 50));
            if (Prodid.getForeground().equals(new Color(53, 223, 50)) && name.getForeground().equals(new Color(53, 223, 50)) && quantity.getForeground().equals(new Color(53, 223, 50)) && price.getForeground().equals(new Color(53, 223, 50)) && cate.getForeground().equals(new Color(53, 223, 50))) {
                try {

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/supermarket", "root", "");
                    String id = prodid.getText();
                    String sql = "Delete from product where ID=" + id;

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
        if (e.getSource() == SAdd) {
            if (id.getText().equals("")) ID.setForeground(Color.RED);
            else ID.setForeground(new Color(53, 223, 50));
            if (nameseller.getText().equals("")) NameSeller.setForeground(Color.RED);
            else NameSeller.setForeground(new Color(53, 223, 50));
            if (password.getText().equals("")) Password.setForeground(Color.RED);
            else Password.setForeground(new Color(53, 223, 50));
            if (gender.getSelectedIndex() == 0) Gender.setForeground(Color.RED);
            else Gender.setForeground(new Color(53, 223, 50));
            if (ID.getForeground().equals(new Color(53, 223, 50)) && NameSeller.getForeground().equals(new Color(53, 223, 50)) && Password.getForeground().equals(new Color(53, 223, 50)) && Gender.getForeground().equals(new Color(53, 223, 50)))
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "");
                    String sql = "insert into seller(ID,Name,Password,Gender)values(?,?,?,?)";
                    PreparedStatement pre = con.prepareStatement(sql);
                    pre.setString(1, nameseller.getText());
                    pre.setString(2, id.getText());
                    pre.setString(3, password.getText());
                    pre.setString(4, gender.getSelectedItem().toString());

                    pre.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Update oki");
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
        }


        if (e.getSource() == SClear) {
            id.setText("");
            nameseller.setText("");
            password.setText("");
            gender.setSelectedIndex(0);
        }
        if (e.getSource() == SDelete) {

            if (id.getText().equals("")) ID.setForeground(Color.RED);
            else ID.setForeground(new Color(53, 223, 50));
            if (nameseller.getText().equals("")) NameSeller.setForeground(Color.RED);
            else NameSeller.setForeground(new Color(53, 223, 50));
            if (password.getText().equals("")) Password.setForeground(Color.RED);
            else Password.setForeground(new Color(53, 223, 50));
            if (gender.getSelectedIndex() == 0) Gender.setForeground(Color.RED);
            else Gender.setForeground(new Color(53, 223, 50));
            if (ID.getForeground().equals(new Color(53, 223, 50)) && NameSeller.getForeground().equals(new Color(53, 223, 50)) && Password.getForeground().equals(new Color(53, 223, 50)) && Gender.getForeground().equals(new Color(53, 223, 50)))
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/supermarket", "root", "");
                    String id = nameseller.getText();
                    String sql = "Delete from seller where ID=" + id;

                    Statement rs = con.createStatement();
                    rs.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Deleted");
                    sellerlist();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

        }

        if (e.getSource() == SEdite) {
            if (id.getText().equals("")) ID.setForeground(Color.RED);
            else ID.setForeground(new Color(53, 223, 50));
            if (nameseller.getText().equals("")) NameSeller.setForeground(Color.RED);
            else NameSeller.setForeground(new Color(53, 223, 50));
            if (password.getText().equals("")) Password.setForeground(Color.RED);
            else Password.setForeground(new Color(53, 223, 50));
            if (gender.getSelectedIndex() == 0) Gender.setForeground(Color.RED);
            else Gender.setForeground(new Color(53, 223, 50));
            if (ID.getForeground().equals(new Color(53, 223, 50)) && NameSeller.getForeground().equals(new Color(53, 223, 50)) && Password.getForeground().equals(new Color(53, 223, 50)) && Gender.getForeground().equals(new Color(53, 223, 50))) {
                try {
                    DefaultTableModel Df = (DefaultTableModel) Sellerlist.getModel();
                    int selectIndex = Sellerlist.getSelectedRow();
                    String n = id.getText();
                    String p = password.getText();
                    String g = gender.getSelectedItem().toString();
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/supermarket", "root", "");
                    PreparedStatement insert = con.prepareStatement("update seller set Name=?,Password=?,Gender=? where ID=?");
                    insert.setString(1, n);
                    insert.setString(2, p);
                    insert.setString(3, g);
                    insert.setString(4, nameseller.getText());

                    insert.executeUpdate();
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
                    ex.printStackTrace();
                }

            }


        }
        ///////////////////////////////////////////////////Categories///////////////////////////////////////////////
        if (e.getSource() == CAdd) {
            if (cid.getText().equals("")) CID.setForeground(Color.RED);
            else CID.setForeground(new Color(53, 223, 50));
            if (Cname.getText().equals("")) CName.setForeground(Color.RED);
            else Cname.setForeground(new Color(53, 223, 50));
            if (description.getText().equals("")) Description.setForeground(Color.RED);
            else Description.setForeground(new Color(53, 223, 50));

            if (CID.getForeground().equals(new Color(53, 223, 50)) && CName.getForeground().equals(new Color(53, 223, 50)) && Description.getForeground().equals(new Color(53, 223, 50))) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "");
                    String sql = "insert into categories(ID,Name,Description)values(?,?,?)";
                    PreparedStatement pre = con.prepareStatement(sql);
                    pre.setString(1, cid.getText());
                    pre.setString(2, Cname.getText());
                    pre.setString(3, description.getText());
                    pre.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Update oki");
                    categorieslist();
                    productlist();
                    // ();
                    cid.setText("");
                    Cname.setText("");
                    description.setText("");
                    CID.setForeground(new Color(53, 223, 50));
                    CName.setForeground(new Color(53, 223, 50));
                    Description.setForeground(new Color(53, 223, 50));

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
            else CID.setForeground(new Color(53, 223, 50));
            if (Cname.getText().equals("")) CName.setForeground(Color.RED);
            else Cname.setForeground(new Color(53, 223, 50));
            if (description.getText().equals("")) Description.setForeground(Color.RED);
            else Description.setForeground(new Color(53, 223, 50));

            if (CID.getForeground().equals(new Color(53, 223, 50)) && CName.getForeground().equals(new Color(53, 223, 50)) && Description.getForeground().equals(new Color(53, 223, 50))) {
                try {

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/supermarket", "root", "");
                    String id = cid.getText();
                    String sql = "Delete from categories where ID=" + id;

                    Statement rs = con.createStatement();
                    rs.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Deleted");
                    categorieslist();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            }
        }
        if (e.getSource() == CEdite) {
            if (cid.getText().equals("")) CID.setForeground(Color.RED);
            else CID.setForeground(new Color(53, 223, 50));
            if (Cname.getText().equals("")) CName.setForeground(Color.RED);
            else Cname.setForeground(new Color(53, 223, 50));
            if (description.getText().equals("")) Description.setForeground(Color.RED);
            else Description.setForeground(new Color(53, 223, 50));

            if (CID.getForeground().equals(new Color(53, 223, 50)) && CName.getForeground().equals(new Color(53, 223, 50)) && Description.getForeground().equals(new Color(53, 223, 50))) {
                try {
                    DefaultTableModel Df = (DefaultTableModel) Categorylist.getModel();
                    int selectIndex = Categorylist.getSelectedRow();
                    String n = Cname.getText();
                    String d = description.getText();
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/supermarket", "root", "");
                    PreparedStatement insert = con.prepareStatement("update categories set Name=?,Description=? where ID=?");
                    insert.setString(1, n);
                    insert.setString(2, d);
                    insert.setString(3, cid.getText());

                    insert.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Update Successful");
                    categorieslist();
                    cid.setText("");
                    Cname.setText("");
                    description.setText("");
                    CID.setForeground(new Color(53, 223, 50));
                    CName.setForeground(new Color(53, 223, 50));
                    Description.setForeground(new Color(53, 223, 50));


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
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == pan1) {

            Pan1.setVisible(true);
            Productlist.setVisible(true);
            Pan2.setVisible(false);
            Sellerlist.setVisible(false);
            Pan3.setVisible(false);
            JOptionPane.showMessageDialog(null, "READ ME\n1.The ID need to be diffrent for every product \n" +
                    "Because when you delete a product that have the same as another product\n" +
                    " they will be both deleted\n" +
                    "2.Click only one time at a product that you want to edit or delete");

        }
        if (e.getSource() == pan2) {
            Pan1.setVisible(false);
            Productlist.setVisible(false);
            Pan2.setVisible(true);
            Sellerlist.setVisible(true);
            Pan3.setVisible(false);
            JOptionPane.showMessageDialog(null, "READ ME\n1.The ID need to be diffrent for every product \n" +
                    "Because when you delete a product that have the same as another product\n" +
                    " they will be both deleted\n" +
                    "2.Click only one time at a product that you want to edit or delete");


        }


        if (e.getSource() == pan3) {
            Pan1.setVisible(false);
            Productlist.setVisible(false);
            Pan2.setVisible(false);
            Sellerlist.setVisible(false);
            Pan3.setVisible(true);
            JOptionPane.showMessageDialog(null, "READ ME\n1.The ID need to be diffrent for every product \n" +
                    "Because when you delete a product that have the same as another product\n" +
                    " they will be both deleted\n" +
                    "2.Click only one time at a product that you want to edit or delete");

        }
        if (e.getSource() == Logout) {

            frame.setVisible(false);
            new Login();


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
        //////////////////////////Categories//////////////////////
        if (e.getSource() == Categorylist) {
            DefaultTableModel Df = (DefaultTableModel) Categorylist.getModel();
            int Selectindex = Categorylist.getSelectedRow();


            cid.setText(Df.getValueAt(Selectindex, 0).toString());
            Cname.setText(Df.getValueAt(Selectindex, 1).toString());
            description.setText(Df.getValueAt(Selectindex, 2).toString());

            categorieslist();
        }


        ///////////////////////////Seller//////////////////////
        if (e.getSource() == Sellerlist) {
            DefaultTableModel SDf = (DefaultTableModel) Sellerlist.getModel();
            int SSelectindex = Sellerlist.getSelectedRow();


            nameseller.setText(SDf.getValueAt(SSelectindex, 0).toString());
            id.setText(SDf.getValueAt(SSelectindex, 1).toString());
            password.setText(SDf.getValueAt(SSelectindex, 2).toString());

            sellerlist();
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
////////////////Product////////////////////////////
        if (Quntity == e.getSource()) {
            if (Character.isLetter(c)) {
                Quntity.setText("");
                quantity.setForeground(Color.RED);
                JOptionPane.showMessageDialog(null, "Enter only Numbers");

            } else {
                quantity.setForeground(new Color(53, 223, 50));

            }
        }
        if (Name == e.getSource()) {
            if (Character.isDigit(c)) {
                Name.setText("");
                name.setForeground(Color.RED);
                JOptionPane.showMessageDialog(null, "Enter only Letters");

            } else {
                name.setForeground(new Color(53, 223, 50));

            }
        }
        if (Price == e.getSource()) {
            if (Character.isLetter(c)) {
                Price.setText("");
                price.setForeground(Color.RED);
                JOptionPane.showMessageDialog(null, "Enter only Numbers");

            } else {
                price.setForeground(new Color(53, 223, 50));

            }
        }
        if (prodid == e.getSource()) {
            if (Character.isLetter(c)) {
                prodid.setText("");
                Prodid.setForeground(Color.RED);
                JOptionPane.showMessageDialog(null, "Enter only Numbers");

            } else {
                Prodid.setForeground(new Color(53, 223, 50));

            }
        }
///////////////////////////////////Seller//////////////////////////////////////////
        if (id == e.getSource()) {
            if (Character.isDigit(c)) {
                id.setText("");
                ID.setForeground(Color.RED);
                JOptionPane.showMessageDialog(null, "Enter only Letters");

            } else {
                ID.setForeground(new Color(53, 223, 50));

            }
        }
        if (nameseller == e.getSource()) {
            if (Character.isLetter(c)) {
                nameseller.setText("");
                NameSeller.setForeground(Color.RED);
                JOptionPane.showMessageDialog(null, "Enter only Numbers");

            } else {
                NameSeller.setForeground(new Color(53, 223, 50));

            }


        }
/////////////////////////////////////Categories/////////////////////////////////
        if (cid == e.getSource()) {
            if (Character.isLetter(c)) {
                cid.setText("");
                CID.setForeground(Color.RED);
                JOptionPane.showMessageDialog(null, "Enter only Numbers");

            } else {
                CID.setForeground(new Color(53, 223, 50));

            }


        }
if(Cname==e.getSource()){
    if(Character.isDigit(c)){
        Cname.setText("");
        CName.setForeground(Color.RED);
        JOptionPane.showMessageDialog(null, "Enter only Numbers");

    } else {
        CName.setForeground(new Color(53, 223, 50));



    }


}
        if(description==e.getSource()){
            if(Character.isDigit(c)){
                description.setText("");
                Description.setForeground(Color.RED);
                JOptionPane.showMessageDialog(null, "Enter only Numbers");

            } else {
                Description.setForeground(new Color(53, 223, 50));



            }


        }
    }



    @Override
    public void keyReleased(KeyEvent e) {

    }
}
