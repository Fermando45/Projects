import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cheat extends JFrame implements ActionListener {
    JFrame frame;
    JButton yes;
    JLabel cheat;

    Cheat(){

      cheat=new JLabel("Do you want to cheat in Physics");
      cheat.setBounds(10,10,400,30);
      cheat.setFont(new Font("MV Boli",Font.BOLD,22));


      yes=new JButton("YES");
      yes.setBackground(Color.RED);
      yes.setBounds(140,200,100,75);
      yes.setFocusPainted(false);
      yes.addActionListener(this);





        this.setSize(400,400);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.add(cheat);
        this.add(yes);






    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==yes){

            new Opening();



        }
    }
}
