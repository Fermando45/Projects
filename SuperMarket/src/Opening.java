import javax.swing.*;
import java.awt.*;

public class Opening extends JFrame {
    JFrame frame;

    JLabel Icon;
    JLabel Title;
    JLabel Coun;

    JProgressBar Bar=new JProgressBar();

    Opening(){
ImageIcon ima=new ImageIcon("209497-200.png");
Image Ima=ima.getImage();
Image scaleimage=Ima.getScaledInstance(150,150,Image.SCALE_SMOOTH);
ima=new ImageIcon(scaleimage);
Icon=new JLabel();
Icon.setIcon(ima);
Icon.setBounds(280,75,150,100);

Title=new JLabel("Supermarket");
Title.setFont(new Font("Clarendon",Font.BOLD,30));
Title.setForeground(Color.BLACK);
Title.setBounds(260,5,200,75);

Bar.setValue(0);
Bar.setSize(700,5);
Bar.setLocation(0,357);
Bar.setBackground(new Color(55,223,50));
//Bar.setStringPainted(true);
Bar.setForeground(Color.BLACK);


        Coun=new JLabel();



        frame=new JFrame("Supermarket");
        frame.setLayout(null);
        frame.setSize(700,400);
       frame.setVisible(true);
       frame.getContentPane().setBackground(new Color(55,223,50));
       frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
       frame.setResizable(false);
        frame.add(Icon);
       frame.add(Title);
        frame.add(Bar);
        frame.add(Coun);

        fill();
    }
public void fill(){
int counter=0;
while (counter<=99){


    Bar.setValue(counter);
    try {
        Thread.sleep(30);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    counter+=1;

  /* String coun=Integer.toString(counter);
    Coun.setText(coun+"%");
    Coun.setForeground(Color.BLACK);
    Coun.setFont(new Font("sfd",Font.BOLD,15));
    Coun.setBounds(200,200,50,50);


   */

}
frame.setVisible(false);
    new Login();




}










}
