import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Book extends JFrame implements ActionListener, MouseListener {
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;


    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JTextArea t5;

    JButton ad;




    Book(){
        l1=new JLabel("ISBN:");
        l1.setBounds(50,50,75,25);

         t1=new JTextField();
         t1.setBounds(100,50,200,25);

         l2=new JLabel("Title:");
         l2.setBounds(50,80,75,25);

        t2=new JTextField();
        t2.setBounds(100,80,200,25);

        l3=new JLabel("Author:");
        l3.setBounds(50,110,75,25);

        t3=new JTextField();
        t3.setBounds(100,110,200,25);

        l4=new JLabel("Year:");
        l4.setBounds(50,140,75,25);

        t4=new JTextField();
        t4.setBounds(100,140,200,25);

        t5=new JTextArea();
        t5.setBounds(20,200,450,250);

        ad=new JButton("Add book");
        ad.setBounds(320,80,120,65);
        ad.setFocusPainted(true);
        ad.addActionListener(this);
        ad.addMouseListener(this);



        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setTitle("Login");
        this.add(l1);
        this.add(t1);
        this.add(l2);
        this.add(t2);
        this.add(l3);
        this.add(t3);
        this.add(l4);
        this.add(t4);
        this.add(t5);
        this.add(ad);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ad){


            if(t1.getText().equals(""))l1.setForeground(Color.RED);
            else l1.setForeground(Color.GREEN);
            if(t2.getText().equals(""))l2.setForeground(Color.RED);
            else l2.setForeground(Color.GREEN);
            if(t3.getText().equals(""))l3.setForeground(Color.RED);
            else l3.setForeground(Color.GREEN);
            if(t4.getText().equals(""))l4.setForeground(Color.RED);
            else l4.setForeground(Color.GREEN);
          if(t1.getText().length()>=3 && t2.getText().length()>=3 && t3.getText().length()>=3 &&t4.getText().length()>=3){
              t5.setText("ISBN:"+t1.getText()+"\n"+"Title:"+t2.getText()+"\n"+"Author:"+t3.getText()+"\n"+"Year:"+t4.getText());
          }




        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");




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
