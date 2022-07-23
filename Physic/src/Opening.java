import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.jar.JarEntry;

public class Opening extends JFrame implements MouseListener {

JFrame frame;

ImageIcon ima;

JLabel pic;
JLabel Speed;
JLabel Averagespeed;
JLabel Velocity;
JLabel Acceleration;
JLabel Density;
JLabel Newtonsecondlaw;
JLabel power;
JLabel Weight;
JLabel Pressure;
JLabel Kineticenergy;
JLabel Potentialenergy;
JLabel work;

    Opening(){

        ima=new ImageIcon("Funny Physics - Imgur.jpg");

        pic=new JLabel();
        pic.setIcon(ima);
        pic.setSize(500,500);
        pic.setLocation(100,1);

        Speed=new JLabel("Speed");
        Speed.setBounds(800,100,120,40);
        Speed.setFont(new Font("Ravie",Font.BOLD,30));
        Speed.addMouseListener(this);

        Averagespeed=new JLabel("Average Speed");
        Averagespeed.setBounds(1050,100,310,40);
        Averagespeed.setFont(new Font("Ravie",Font.BOLD,30));
        Averagespeed.addMouseListener(this);

        Velocity=new JLabel("Velocity");
        Velocity.setBounds(800,200,180,40);
        Velocity.setFont(new Font("Ravie",Font.BOLD,30));
        Velocity.addMouseListener(this);

        work=new JLabel("Work");
        work.setBounds(1050,200,115,40);
        work.setFont(new Font("Ravie",Font.BOLD,30));
        work.addMouseListener(this);

        Newtonsecondlaw=new JLabel("Newton 2 law");
        Newtonsecondlaw.setBounds(1050,300,350,40);
        Newtonsecondlaw.setFont(new Font("Ravie",Font.BOLD,30));
        Newtonsecondlaw.addMouseListener(this);

        power=new JLabel("Power");
        power.setBounds(800,300,130,40);
        power.setFont(new Font("Ravie",Font.BOLD,30));
        power.addMouseListener(this);

        Density=new JLabel("Density");
        Density.setBounds(800,400,165,40);
        Density.setFont(new Font("Ravie",Font.BOLD,30));
        Density.addMouseListener(this);

        Acceleration=new JLabel("Acceleration");
        Acceleration.setBounds(1050,400,270,40);
        Acceleration.setFont(new Font("Ravie",Font.BOLD,30));
        Acceleration.addMouseListener(this);

        Potentialenergy=new JLabel("Potential E");
        Potentialenergy.setBounds(1050,500,240,40);
        Potentialenergy.setFont(new Font("Ravie",Font.BOLD,30));
        Potentialenergy.addMouseListener(this);

        Kineticenergy=new JLabel("Kinetic E");
        Kineticenergy.setBounds(800,500,200,40);
        Kineticenergy.setFont(new Font("Ravie",Font.BOLD,30));
        Kineticenergy.addMouseListener(this);

        Weight=new JLabel("Weight");
        Weight.setBounds(800,600,165,40);
        Weight.setFont(new Font("Ravie",Font.BOLD,30));
        Weight.addMouseListener(this);

        Pressure=new JLabel("Presure");
        Pressure.setBounds(1050,600,170,40);
        Pressure.setFont(new Font("Ravie",Font.BOLD,30));
        Pressure.addMouseListener(this);












        this.setSize(900,700);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(pic);
        this.add(Speed);
        this.add(Averagespeed);
        this.add(Velocity);
        this.add(work);
        this.add(Newtonsecondlaw);
        this.add(power);
        this.add(Density);
        this.add(Acceleration);
        this.add(Potentialenergy);
        this.add(Kineticenergy);
        this.add(Weight);
        this.add(Pressure);


    }


    @Override
    public void mouseClicked(MouseEvent e) {
if(e.getSource()==Speed){
    new Speed();

}

if(e.getSource()==Averagespeed){
    new AverageSpeed();
}

if(e.getSource()==Acceleration){
   new Accleration();
}
if(e.getSource()==Kineticenergy){
    new KE();
}
if(e.getSource()==Velocity){
    new Velocity();
}
if(e.getSource()==Potentialenergy){
    new PE();
}
if(e.getSource()==Newtonsecondlaw){
    new Newton();
}
if(e.getSource()==Density){
    new Density();
}
if(e.getSource()==work){
    new work();
}
if(e.getSource()==power){
    new power();
}
if(e.getSource()==Weight){
    new weight();
}
if(e.getSource()==Pressure){
new pressure();
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
