import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Admin extends JFrame implements ActionListener, MouseListener {
    JLabel Menu;
    JLabel Hotels;
    JLabel Institution;
    JLabel Jobs;
    JLabel Highschool;
    JLabel University;
    JLabel ATM;
    JLabel Hospital;
    JLabel Theater;
    JLabel Travel;

    JPanel Module;
    JPanel hotels;
    JPanel Instittion;
    JPanel jobs;
    JPanel highschool;
    JPanel university;
    JPanel atm;
    JPanel hospital;
    JPanel theatre;
    JPanel travel;

    JTextArea description;

    JTextField HName;
    JLabel     hname;
    JTextField HLocation;
    JLabel     hlocation;
    JTextField HWebsite;
    JLabel     hwebsite;
    JButton HAadd;
    JButton HClear;

    JTextField IName;
    JLabel     iname;
    JTextField ILocation;
    JLabel     ilocation;
    JTextField IWebsite;
    JLabel     iwebsite;
    JButton IAadd;
    JButton IClear;

    JTextField JName;
    JLabel     jname;
    JTextField JDomain;
    JLabel     jdomain;
    JTextField JWebsite;
    JLabel     jwbsite;
    JButton JAadd;
    JButton JClear;

    JTextField HIName;
    JLabel     hiname;
    JTextField HILocation;
    JLabel     hilocation;
    JTextField HIWebsite;
    JLabel     hiwebsite;
    JButton HIAadd;
    JButton HIClear;

    JTextField UName;
    JLabel     uname;
    JTextField ULocation;
    JLabel     ulocation;
    JTextField UWebsite;
    JLabel     uwebsite;
    JButton UAadd;
    JButton UClear;

    JTextField AName;
    JLabel     aname;
    JTextField ALocation;
    JLabel     alocation;
    JButton AAadd;
    JButton AClear;

    JTextField HOName;
    JLabel     honame;
    JTextField HOLocation;
    JLabel     holocation;
    JTextField HOWebsite;
    JLabel     howebsite;
    JButton HOAadd;
    JButton HOClear;

    JTextField THName;
    JLabel     thname;
    JTextField THLocation;
    JLabel     thlocation;
    JTextField THWebsite;
    JLabel     thwebsite;
    JButton THAadd;
    JButton THClear;

    JTextField TName;
    JLabel     tname;
    JTextField TLocation;
    JLabel     tlocation;
    JTextField TWebsite;
    JLabel     twebsite;
    JButton TAadd;
    JButton TClear;
    JFrame frame;


Admin(){
    Module = new JPanel();
    Module.setBounds(10, 10, 300, 175);
    Module.setBorder(BorderFactory.createTitledBorder("Admin"));
    Module.setLayout(new FlowLayout());


    description = new JTextArea("Administration module is the overall controller of the smart city project. It updates itself as well as other modules. This module is responsible for uploading job opportunities in the site, updating business information, authenticating the user profiles along with the maintenance of other four modules.", 6, 20);
    description.setLineWrap(true);
    description.setWrapStyleWord(true);
    description.setOpaque(false);
    description.setEditable(false);
    Module.add(description);

    Menu = new JLabel("Menu Bar");
    Menu.setBounds(10, 200, 100, 25);
    Menu.setFont(new Font("eda", Font.BOLD, 15));

    Hotels = new JLabel("Hotel");
    Hotels.setBounds(10, 240, 100, 25);
    Hotels.setFont(new Font("eda", Font.PLAIN, 15));
    Hotels.addMouseListener(this);

    Institution = new JLabel("Institution");
    Institution.setBounds(10, 270, 100, 25);
    Institution.setFont(new Font("eda", Font.PLAIN, 15));
    Institution.addMouseListener(this);

    Jobs = new JLabel("Jobs");
    Jobs.setBounds(10, 300, 100, 25);
    Jobs.setFont(new Font("eda", Font.PLAIN, 15));
    Jobs.addMouseListener(this);

    Highschool = new JLabel("Highschool");
    Highschool.setBounds(10, 330, 100, 25);
    Highschool.setFont(new Font("eda", Font.PLAIN, 15));
    Highschool.addMouseListener(this);

    University = new JLabel("University");
    University.setBounds(10, 360, 100, 25);
    University.setFont(new Font("eda", Font.PLAIN, 15));
    University.addMouseListener(this);

    ATM = new JLabel("ATM");
    ATM.setBounds(10, 390, 100, 25);
    ATM.setFont(new Font("eda", Font.PLAIN, 15));
    ATM.addMouseListener(this);

    Hospital = new JLabel("Hospital");
    Hospital.setBounds(10, 420, 100, 25);
    Hospital.setFont(new Font("eda", Font.PLAIN, 15));
    Hospital.addMouseListener(this);

    Theater = new JLabel("Theater");
    Theater.setBounds(10, 450, 100, 25);
    Theater.setFont(new Font("eda", Font.PLAIN, 15));
    Theater.addMouseListener(this);

    Travel = new JLabel("Agency");
    Travel.setBounds(10, 480, 100, 25);
    Travel.setFont(new Font("eda", Font.PLAIN, 15));
    Travel.addMouseListener(this);


    HName=new JTextField();
    HName.setBounds(130,120,200,20);
    hname=new JLabel("Name:");
    hname.setBounds(90,115,75,25);
    HLocation=new JTextField();
    HLocation.setBounds(130,160,200,20);
    hlocation=new JLabel("Location:");
    hlocation.setBounds(75,155,75,25);
    HWebsite=new JTextField();
    HWebsite.setBounds(130,200,200,20);
    hwebsite=new JLabel("Website:");
    hwebsite.setBounds(75,195,75,25);
    HAadd=new JButton("Add");
    HAadd.setBounds(130,230,80,30);
    HAadd.setFocusPainted(false);
    HAadd.addActionListener(this);
    HClear=new JButton("Cancle");
    HClear.setBounds(250,230,80,30);
    HClear.setFocusPainted(false);
    HClear.addActionListener(this);
    hotels=new JPanel();
    hotels.setBounds(350, 70, 500, 400);
    hotels.setVisible(false);
    hotels.setLayout(null);
    hotels.add(HName);
    hotels.add(HLocation);
    hotels.add(HWebsite);
    hotels.add(hname);
    hotels.add(hlocation);
    hotels.add(hwebsite);
    hotels.add(HAadd);
    hotels.add(HClear);

    IName=new JTextField();
    IName.setBounds(130,120,200,20);
    iname=new JLabel("Name:");
    iname.setBounds(90,115,75,25);
    ILocation=new JTextField();
    ILocation.setBounds(130,160,200,20);
    ilocation=new JLabel("Location:");
    ilocation.setBounds(75,155,75,25);
    IWebsite=new JTextField();
    IWebsite.setBounds(130,200,200,20);
    iwebsite=new JLabel("Website:");
    iwebsite.setBounds(75,195,75,25);
    IAadd=new JButton("Add");
    IAadd.setBounds(130,230,80,30);
    IAadd.setFocusPainted(false);
    IAadd.addActionListener(this);
    IClear=new JButton("Cancle");
    IClear.setBounds(250,230,80,30);
    IClear.setFocusPainted(false);
    IClear.addActionListener(this);
    Instittion=new JPanel();
    Instittion.setBounds(350, 70, 500, 400);
    Instittion.setVisible(false);
    Instittion.setLayout(null);
    Instittion.add(IName);
    Instittion.add(ILocation);
    Instittion.add(IWebsite);
    Instittion.add(iname);
    Instittion.add(ilocation);
    Instittion.add(iwebsite);
    Instittion.add(IAadd);
    Instittion.add(IClear);

    JName=new JTextField();
    JName.setBounds(130,120,200,20);
    jname=new JLabel("Name:");
    jname.setBounds(90,115,75,25);
    JDomain=new JTextField();
    JDomain.setBounds(130,160,200,20);
    jdomain=new JLabel("Domain:");
    jdomain.setBounds(75,155,75,25);
    JWebsite=new JTextField();
    JWebsite.setBounds(130,200,200,20);
    jwbsite=new JLabel("Website:");
    jwbsite.setBounds(75,195,75,25);
    JAadd=new JButton("Add");
    JAadd.setBounds(130,230,80,30);
    JAadd.setFocusPainted(false);
    JAadd.addActionListener(this);
    JClear=new JButton("Cancle");
    JClear.setBounds(250,230,80,30);
    JClear.setFocusPainted(false);
    JClear.addActionListener(this);
    jobs=new JPanel();
    jobs.setBounds(350, 70, 500, 400);
    jobs.setVisible(false);
    jobs.setLayout(null);
    jobs.add(JName);
    jobs.add(JDomain);
    jobs.add(JWebsite);
    jobs.add(jname);
    jobs.add(jdomain);
    jobs.add(jwbsite);
    jobs.add(JAadd);
    jobs.add(JClear);

    HIName=new JTextField();
    HIName.setBounds(130,120,200,20);
    hiname=new JLabel("Name:");
    hiname.setBounds(90,115,75,25);
    HILocation=new JTextField();
    HILocation.setBounds(130,160,200,20);
    hilocation=new JLabel("Location:");
    hilocation.setBounds(75,155,75,25);
    HIWebsite=new JTextField();
    HIWebsite.setBounds(130,200,200,20);
    hiwebsite=new JLabel("Website:");
    hiwebsite.setBounds(75,195,75,25);
    HIAadd=new JButton("Add");
    HIAadd.setBounds(130,230,80,30);
    HIAadd.setFocusPainted(false);
    HIAadd.addActionListener(this);
    HIClear=new JButton("Cancle");
    HIClear.setBounds(250,230,80,30);
    HIClear.setFocusPainted(false);
    HIClear.addActionListener(this);
    highschool=new JPanel();
    highschool.setBounds(350, 70, 500, 400);
    highschool.setVisible(false);
    highschool.setLayout(null);
    highschool.add(HIName);
    highschool.add(HILocation);
    highschool.add(HIWebsite);
    highschool.add(hiname);
    highschool.add(hilocation);
    highschool.add(hiwebsite);
    highschool.add(HIAadd);
    highschool.add(HIClear);


    UName=new JTextField();
    UName.setBounds(130,120,200,20);
    uname=new JLabel("Name:");
    uname.setBounds(90,115,75,25);
    ULocation=new JTextField();
    ULocation.setBounds(130,160,200,20);
    ulocation=new JLabel("Location:");
    ulocation.setBounds(75,155,75,25);
    UWebsite=new JTextField();
    UWebsite.setBounds(130,200,200,20);
    uwebsite=new JLabel("Website:");
    uwebsite.setBounds(75,195,75,25);
    UAadd=new JButton("Add");
    UAadd.setBounds(130,230,80,30);
    UAadd.setFocusPainted(false);
    UAadd.addActionListener(this);
    UClear=new JButton("Cancle");
    UClear.setBounds(250,230,80,30);
    UClear.setFocusPainted(false);
    UClear.addActionListener(this);
    university=new JPanel();
    university.setBounds(350, 70, 500, 400);
    university.setVisible(false);
    university.setLayout(null);
    university.add(UName);
    university.add(ULocation);
    university.add(UWebsite);
    university.add(uname);
    university.add(ulocation);
    university.add(uwebsite);
    university.add(UAadd);
    university.add(UClear);


    AName=new JTextField();
    AName.setBounds(130,120,200,20);
    aname=new JLabel("Name:");
    aname.setBounds(90,115,75,25);
    ALocation=new JTextField();
    ALocation.setBounds(130,160,200,20);
    alocation=new JLabel("Location:");
    alocation.setBounds(75,155,75,25);
    AAadd=new JButton("Add");
    AAadd.setBounds(130,190,80,30);
    AAadd.setFocusPainted(false);
    AAadd.addActionListener(this);
    AClear=new JButton("Cancle");
    AClear.setBounds(250,190,80,30);
    AClear.setFocusPainted(false);
    AClear.addActionListener(this);
    atm=new JPanel();
    atm.setBounds(350, 70, 500, 400);
    atm.setVisible(false);
    atm.setLayout(null);
    atm.add(AName);
    atm.add(ALocation);
    atm.add(aname);
    atm.add(alocation);
    atm.add(AAadd);
    atm.add(AClear);

    HOName=new JTextField();
    HOName.setBounds(130,120,200,20);
    honame=new JLabel("Name:");
    honame.setBounds(90,115,75,25);
    HOLocation=new JTextField();
    HOLocation.setBounds(130,160,200,20);
    holocation=new JLabel("Location:");
    holocation.setBounds(75,155,75,25);
    HOWebsite=new JTextField();
    HOWebsite.setBounds(130,200,200,20);
    howebsite=new JLabel("Website:");
    howebsite.setBounds(75,195,75,25);
    HOAadd=new JButton("Add");
    HOAadd.setBounds(130,230,80,30);
    HOAadd.setFocusPainted(false);
    HOAadd.addActionListener(this);
    HOClear=new JButton("Cancle");
    HOClear.setBounds(250,230,80,30);
    HOClear.setFocusPainted(false);
    HOClear.addActionListener(this);
    hospital=new JPanel();
    hospital.setBounds(350, 70, 500, 400);
    hospital.setVisible(false);
    hospital.setLayout(null);
    hospital.add(HOName);
    hospital.add(HOLocation);
    hospital.add(HOWebsite);
    hospital.add(honame);
    hospital.add(holocation);
    hospital.add(howebsite);
    hospital.add(HOAadd);
    hospital.add(HOClear);

    THName=new JTextField();
    THName.setBounds(130,120,200,20);
    thname=new JLabel("Name:");
    thname.setBounds(90,115,75,25);
    THLocation=new JTextField();
    THLocation.setBounds(130,160,200,20);
    thlocation=new JLabel("Location:");
    thlocation.setBounds(75,155,75,25);
    THWebsite=new JTextField();
    THWebsite.setBounds(130,200,200,20);
    thwebsite=new JLabel("Website:");
    thwebsite.setBounds(75,195,75,25);
    THAadd=new JButton("Add");
    THAadd.setBounds(130,230,80,30);
    THAadd.setFocusPainted(false);
    THAadd.addActionListener(this);
    THClear=new JButton("Cancle");
    THClear.setBounds(250,230,80,30);
    THClear.setFocusPainted(false);
    THClear.addActionListener(this);
    theatre=new JPanel();
    theatre.setBounds(350, 70, 500, 400);
    theatre.setVisible(false);
    theatre.setLayout(null);
    theatre.add(THName);
    theatre.add(THLocation);
    theatre.add(THWebsite);
    theatre.add(thname);
    theatre.add(thlocation);
    theatre.add(thwebsite);
    theatre.add(THAadd);
    theatre.add(THClear);

    TName=new JTextField();
    TName.setBounds(130,120,200,20);
    tname=new JLabel("Name:");
    tname.setBounds(90,115,75,25);
    TLocation=new JTextField();
    TLocation.setBounds(130,160,200,20);
    tlocation=new JLabel("Location:");
    tlocation.setBounds(75,155,75,25);
    TWebsite=new JTextField();
    TWebsite.setBounds(130,200,200,20);
    twebsite=new JLabel("Website:");
    twebsite.setBounds(75,195,75,25);
    TAadd=new JButton("Add");
    TAadd.setBounds(130,230,80,30);
    TAadd.setFocusPainted(true);
    TAadd.addActionListener(this);
    TClear=new JButton("Cancle");
    TClear.setBounds(250,230,80,30);
    TClear.setFocusPainted(false);
    TClear.addActionListener(this);
    travel=new JPanel();
    travel.setBounds(350, 70, 500, 400);
    travel.setVisible(false);
    travel.setLayout(null);
    travel.add(TName);
    travel.add(TLocation);
    travel.add(TWebsite);
    travel.add(tname);
    travel.add(tlocation);
    travel.add(twebsite);
    travel.add(TAadd);
    travel.add(TClear);





    frame=new JFrame();
    frame.setTitle("Admin");
    frame.setVisible(true);
    frame.setResizable(false);
    frame.setSize(900,600);
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(Module);
    frame.add(Menu);
    frame.add(Hotels);
    frame.add(Institution);
    frame.add(Jobs);
    frame.add(Highschool);
    frame.add(University);
    frame.add(ATM);
    frame.add(Hospital);
    frame.add(Theater);
    frame.add(Travel);
    frame.add(hotels);
    frame.add(Instittion);
    frame.add(jobs);
    frame.add(highschool);
    frame.add(university);
    frame.add(atm);
    frame.add(hospital);
    frame.add(theatre);
    frame.add(travel);


}

    @Override
    public void actionPerformed(ActionEvent e) {
if (e.getSource()==HClear){
    HName.setText("");
    HWebsite.setText("");
    HLocation.setText("");
    hname.setForeground(Color.BLACK);
    hwebsite.setForeground(Color.BLACK);
    hlocation.setForeground(Color.BLACK);

}
if (e.getSource()==IClear){
    IName.setText("");
    IWebsite.setText("");
    ILocation.setText("");
    iname.setForeground(Color.BLACK);
    iwebsite.setForeground(Color.BLACK);
    ilocation.setForeground(Color.BLACK);
}
if (e.getSource()==JClear){
    JName.setText("");
    JWebsite.setText("");
    JDomain.setText("");
    jname.setForeground(Color.BLACK);
    jdomain.setForeground(Color.BLACK);
    jwbsite.setForeground(Color.BLACK);
}
if (e.getSource()==HIClear){
    HIName.setText("");
    HILocation.setText("");
    HIWebsite.setText("");
    hiname.setForeground(Color.BLACK);
    hiwebsite.setForeground(Color.BLACK);
    hilocation.setForeground(Color.BLACK);
}
if (e.getSource()==UClear){
    UName.setText("");
    ULocation.setText("");
    UWebsite.setText("");
    uname.setForeground(Color.BLACK);
    uwebsite.setForeground(Color.BLACK);
    ulocation.setForeground(Color.BLACK);
}
if (e.getSource()==AClear){
    AName.setText("");
    ALocation.setText("");
    aname.setForeground(Color.BLACK);
    alocation.setForeground(Color.BLACK);
}
if (e.getSource()==HOClear){
    HOName.setText("");
    HOLocation.setText("");
    HOWebsite.setText("");
    honame.setForeground(Color.BLACK);
    howebsite.setForeground(Color.BLACK);
    holocation.setForeground(Color.BLACK);
}
if (e.getSource()==THClear){
    THName.setText("");
    THLocation.setText("");
    THWebsite.setText("");
    thname.setForeground(Color.BLACK);
    thwebsite.setForeground(Color.BLACK);
    thlocation.setForeground(Color.BLACK);
}
if (e.getSource()==TClear){
    TName.setText("");
    TLocation.setText("");
    TWebsite.setText("");
    tname.setForeground(Color.BLACK);
    twebsite.setForeground(Color.BLACK);
    tlocation.setForeground(Color.BLACK);
    }
if(e.getSource()==HAadd) {
    if(HName.getText().equals("") ) hname.setForeground(Color.RED);
    else hname.setForeground(Color.GREEN);
    if(HWebsite.getText().equals(""))hwebsite.setForeground(Color.RED);
    else hwebsite.setForeground(Color.GREEN);
    if(HLocation.getText().equals(""))hlocation.setForeground(Color.RED);
    else hlocation.setForeground(Color.GREEN);
    if(hname.getForeground().equals(Color.GREEN)&&hwebsite.getForeground().equals(Color.GREEN)&&hlocation.getForeground().equals(Color.GREEN)) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity", "root", "");
            String sql = "insert into bussnies_modul_hotels(Name,Location,Website)values(?,?,?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, HName.getText());
            pre.setString(2, HLocation.getText());
            pre.setString(3, HWebsite.getText());
            pre.executeUpdate();
            HName.setText("");
            HWebsite.setText("");
            HLocation.setText("");
            JOptionPane.showMessageDialog(null, "Updated Succesfully");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);


        }
    }else{
        JOptionPane.showMessageDialog(null,"Plz type at the all fields");
    }



}
        if (e.getSource() == JAadd) {
            if(JName.getText().equals("") ) jname.setForeground(Color.RED);
            else jname.setForeground(Color.GREEN);
            if(JWebsite.getText().equals(""))jwbsite.setForeground(Color.RED);
            else jwbsite.setForeground(Color.GREEN);
            if(JDomain.getText().equals(""))jdomain.setForeground(Color.RED);
            else jdomain.setForeground(Color.GREEN);
            if(jname.getForeground().equals(Color.GREEN)&&jdomain.getForeground().equals(Color.GREEN)&&jwbsite.getForeground().equals(Color.GREEN)) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity", "root", "");
                    String sql = "insert into jobseeker_modul_job(Name,Domain,Website)values(?,?,?)";
                    PreparedStatement pre = con.prepareStatement(sql);
                    pre.setString(1, JName.getText());
                    pre.setString(2, JDomain.getText());
                    pre.setString(3, JWebsite.getText());
                    pre.executeUpdate();
                    JName.setText("");
                    JDomain.setText("");
                    JWebsite.setText("");
                    JOptionPane.showMessageDialog(null, "Updated Succesfully");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);


                }
            }else{
                JOptionPane.showMessageDialog(null,"Plz type at the all fields");

            }
        }
        if (e.getSource() == IAadd) {
            if(IName.getText().equals("") ) iname.setForeground(Color.RED);
            else iname.setForeground(Color.GREEN);
            if(IWebsite.getText().equals(""))iwebsite.setForeground(Color.RED);
            else iwebsite.setForeground(Color.GREEN);
            if(ILocation.getText().equals(""))ilocation.setForeground(Color.RED);
            else ilocation.setForeground(Color.GREEN);
            if(iname.getForeground().equals(Color.GREEN)&&iwebsite.getForeground().equals(Color.GREEN)&&ilocation.getForeground().equals(Color.GREEN)) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity", "root", "");
                    String sql = "insert into jobseeker_modul_institution(Name,Location,Website)values(?,?,?)";
                    PreparedStatement pre = con.prepareStatement(sql);
                    pre.setString(1, IName.getText());
                    pre.setString(2, ILocation.getText());
                    pre.setString(3, IWebsite.getText());
                    pre.executeUpdate();
                    IName.setText("");
                    IWebsite.setText("");
                    ILocation.setText("");
                    JOptionPane.showMessageDialog(null, "Updated Succesfully");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);


                }
            }else{
                JOptionPane.showMessageDialog(null,"Plz type at the all fields");
            }

        }
        if (e.getSource() == UAadd) {
            if(UName.getText().equals("") ) uname.setForeground(Color.RED);
            else uname.setForeground(Color.GREEN);
            if(UWebsite.getText().equals(""))uwebsite.setForeground(Color.RED);
            else uwebsite.setForeground(Color.GREEN);
            if(ULocation.getText().equals(""))ulocation.setForeground(Color.RED);
            else ulocation.setForeground(Color.GREEN);
            if(uname.getForeground().equals(Color.GREEN)&&uwebsite.getForeground().equals(Color.GREEN)&&ulocation.getForeground().equals(Color.GREEN)) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity", "root", "");
                    String sql = "insert into student_modul_university(Name,Location,Website)values(?,?,?)";
                    PreparedStatement pre = con.prepareStatement(sql);
                    pre.setString(1, UName.getText());
                    pre.setString(2, ULocation.getText());
                    pre.setString(3, UWebsite.getText());
                    pre.executeUpdate();
                    UName.setText("");
                    UWebsite.setText("");
                    ULocation.setText("");
                    JOptionPane.showMessageDialog(null, "Updated Succesfully");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);


                }
            }else{
                JOptionPane.showMessageDialog(null,"Plz type at the all fields");
            }

        }
        if (e.getSource() ==AAadd) {
            if(AName.getText().equals("") ) aname.setForeground(Color.RED);
            else aname.setForeground(Color.GREEN);

            if(ALocation.getText().equals(""))alocation.setForeground(Color.RED);
            else alocation.setForeground(Color.GREEN);
            if(aname.getForeground().equals(Color.GREEN)&&alocation.getForeground().equals(Color.GREEN)) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity", "root", "");
                String sql = "insert into tourisem_module_atm(Name,Location)values(?,?)";
                PreparedStatement pre = con.prepareStatement(sql);
                pre.setString(1, AName.getText());
                pre.setString(2, ALocation.getText());
                pre.executeUpdate();
                AName.setText("");
                ALocation.setText("");
                JOptionPane.showMessageDialog(null, "Updated Succesfully");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);


            }
            }else{
                JOptionPane.showMessageDialog(null,"Plz type at the all fields");
            }

        }
        if (e.getSource() == HOAadd) {
            if(HOName.getText().equals("") ) honame.setForeground(Color.RED);
            else honame.setForeground(Color.GREEN);
            if(HOWebsite.getText().equals(""))howebsite.setForeground(Color.RED);
            else howebsite.setForeground(Color.GREEN);
            if(HOLocation.getText().equals(""))holocation.setForeground(Color.RED);
            else holocation.setForeground(Color.GREEN);
            if(honame.getForeground().equals(Color.GREEN)&&howebsite.getForeground().equals(Color.GREEN)&&holocation.getForeground().equals(Color.GREEN)) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity", "root", "");
                String sql = "insert into tourisem_module_hospitals(Name,Location,Website)values(?,?,?)";
                PreparedStatement pre = con.prepareStatement(sql);
                pre.setString(1, HOName.getText());
                pre.setString(2, HOLocation.getText());
                pre.setString(3, HOWebsite.getText());
                pre.executeUpdate();
                HOName.setText("");
                HOWebsite.setText("");
                HOLocation.setText("");
                JOptionPane.showMessageDialog(null, "Updated Succesfully");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);


            }
            }else {
                JOptionPane.showMessageDialog(null, "Plz type at the all fields");
            }
        }
        if (e.getSource() == THAadd) {
            if(THName.getText().equals("") ) thname.setForeground(Color.RED);
            else thname.setForeground(Color.GREEN);
            if(THWebsite.getText().equals(""))thwebsite.setForeground(Color.RED);
            else thwebsite.setForeground(Color.GREEN);
            if(THLocation.getText().equals(""))thlocation.setForeground(Color.RED);
            else thlocation.setForeground(Color.GREEN);
            if(thname.getForeground().equals(Color.GREEN)&&thwebsite.getForeground().equals(Color.GREEN)&&thlocation.getForeground().equals(Color.GREEN)) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity", "root", "");
                String sql = "insert into tourisem_module_theater(Name,Location,Website)values(?,?,?)";
                PreparedStatement pre = con.prepareStatement(sql);
                pre.setString(1, THName.getText());
                pre.setString(2, THLocation.getText());
                pre.setString(3, THWebsite.getText());
                pre.executeUpdate();
                THName.setText("");
                THWebsite.setText("");
                THLocation.setText("");
                JOptionPane.showMessageDialog(null, "Updated Succesfully");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);


            }
            }else {
                JOptionPane.showMessageDialog(null, "Plz type at the all fields");
            }
        }
        if (e.getSource() == TAadd) {
            if(TName.getText().equals("") ) tname.setForeground(Color.RED);
            else tname.setForeground(Color.GREEN);
            if(TWebsite.getText().equals(""))twebsite.setForeground(Color.RED);
            else twebsite.setForeground(Color.GREEN);
            if(TLocation.getText().equals(""))tlocation.setForeground(Color.RED);
            else tlocation.setForeground(Color.GREEN);
            if(tname.getForeground().equals(Color.GREEN)&&twebsite.getForeground().equals(Color.GREEN)&&tlocation.getForeground().equals(Color.GREEN)) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity", "root", "");
                String sql = "insert into tourisem_module_travel(Name,Location,Website)values(?,?,?)";
                PreparedStatement pre = con.prepareStatement(sql);
                pre.setString(1, TName.getText());
                pre.setString(2, TLocation.getText());
                pre.setString(3, TWebsite.getText());
                pre.executeUpdate();
                TName.setText("");
                TWebsite.setText("");
                TLocation.setText("");
                JOptionPane.showMessageDialog(null, "Updated Succesfully");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);


            }
            }else {
                JOptionPane.showMessageDialog(null, "Plz type at the all fields");
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
if(e.getSource()==Institution){
    hotels.setVisible(false);
     Instittion.setVisible(true);
     jobs.setVisible(false);
     highschool.setVisible(false);
     university.setVisible(false);
     atm.setVisible(false);
     hospital.setVisible(false);
    theatre.setVisible(false);
    travel.setVisible(false);
}
        if(e.getSource()==Hotels){
            hotels.setVisible(true);
            Instittion.setVisible(false);
            jobs.setVisible(false);
            highschool.setVisible(false);
            university.setVisible(false);
            atm.setVisible(false);
            hospital.setVisible(false);
            theatre.setVisible(false);
            travel.setVisible(false);
        }
        if(e.getSource()==Jobs){
            hotels.setVisible(false);
            Instittion.setVisible(false);
            jobs.setVisible(true);
            highschool.setVisible(false);
            university.setVisible(false);
            atm.setVisible(false);
            hospital.setVisible(false);
            theatre.setVisible(false);
            travel.setVisible(false);
        }
        if(e.getSource()==Highschool){
            hotels.setVisible(false);
            Instittion.setVisible(false);
            jobs.setVisible(false);
            highschool.setVisible(true);
            university.setVisible(false);
            atm.setVisible(false);
            hospital.setVisible(false);
            theatre.setVisible(false);
            travel.setVisible(false);
        }
        if(e.getSource()==University){
            hotels.setVisible(false);
            Instittion.setVisible(false);
            jobs.setVisible(false);
            highschool.setVisible(false);
            university.setVisible(true);
            atm.setVisible(false);
            hospital.setVisible(false);
            theatre.setVisible(false);
            travel.setVisible(false);
        }
        if(e.getSource()==ATM){
            hotels.setVisible(false);
            Instittion.setVisible(false);
            jobs.setVisible(false);
            highschool.setVisible(false);
            university.setVisible(false);
            atm.setVisible(true);
            hospital.setVisible(false);
            theatre.setVisible(false);
            travel.setVisible(false);
        }
        if(e.getSource()==Hospital){
            hotels.setVisible(false);
            Instittion.setVisible(false);
            jobs.setVisible(false);
            highschool.setVisible(false);
            university.setVisible(false);
            atm.setVisible(false);
            hospital.setVisible(true);
            theatre.setVisible(false);
            travel.setVisible(false);
        }
        if(e.getSource()==Theater){
            hotels.setVisible(false);
            Instittion.setVisible(false);
            jobs.setVisible(false);
            highschool.setVisible(false);
            university.setVisible(false);
            atm.setVisible(false);
            hospital.setVisible(false);
            theatre.setVisible(true);
            travel.setVisible(false);
        }
        if(e.getSource()==Travel){
            hotels.setVisible(false);
            Instittion.setVisible(false);
            jobs.setVisible(false);
            highschool.setVisible(false);
            university.setVisible(false);
            atm.setVisible(false);
            hospital.setVisible(false);
            theatre.setVisible(false);
            travel.setVisible(true);
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
