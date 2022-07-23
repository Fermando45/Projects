import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Velocity extends JFrame implements ActionListener {


    JFrame frame;

    JLabel des;
    JLabel t;
    JLabel x;
    JLabel v;

    JPanel pan;

    JTextField t1;
    JTextField t2;
    JTextField t3;

    JButton can;
    JButton calc;


    Velocity() {

        can = new JButton("Cancel");
        can.setBounds(290, 350, 100, 30);
        can.setFocusPainted(false);
        can.addActionListener(this);

        calc = new JButton("Calculate");
        calc.setBounds(140, 350, 100, 30);
        calc.setFocusPainted(false);
        calc.addActionListener(this);


        t = new JLabel("Δt");
        t.setBounds(20, 30, 75, 100);
        t.setFont(new Font(null, Font.BOLD, 20));

        x = new JLabel("Δx");
        x.setBounds(20, 75, 75, 100);
        x.setFont(new Font(null, Font.BOLD, 20));

        v = new JLabel("v");
        v.setBounds(20, 115, 75, 100);
        v.setFont(new Font(null, Font.BOLD, 20));


        t1 = new JTextField();
        t1.setBounds(50, 70, 50, 25);

        t2 = new JTextField();
        t2.setBounds(50, 113, 50, 25);


        t3 = new JTextField();
        t3.setBounds(50, 156, 50, 25);

        JTextArea textArea = new JTextArea(
                "The velocity of a moving body for the overall " +
                        "displacment that it has covered" + "\n" +
                        "Formula:V=Δx/Δt"+"\n"+
                        "Formulet:Δx=v*Δt"+"\n"+
                        "Formule:Δt=Δx/v"+"\n"+
                        "Δx=(2)x-(1)x"+"\n"+
                        "Δt=(2)t+(1)t"

                ,
                6,
                20);
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);

        pan = new JPanel();
        pan.add(textArea);
        pan.setLayout(new FlowLayout());
        pan.setBounds(130, 90, 280, 300);


        this.setSize(500, 500);
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("Velocity");
        this.add(can);
        this.add(calc);
        this.add(t);
        this.add(x);
        this.add(v);
        this.add(t1);
        this.add(t2);
        this.add(t3);
        this.add(pan);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == can) {

            t1.setText("");
            t2.setText("");
            t3.setText("");
            x.setForeground(Color.BLACK);
            v.setForeground(Color.BLACK);
            t.setForeground(Color.BLACK);
        }
        if (e.getSource() == calc) {
            if (t3.getText().equals("") && t2.getText().length() >= 1 && t1.getText().length() >= 1) {
                v.setForeground(Color.GREEN);
                double x = Double.parseDouble(t2.getText());
                double T = Double.parseDouble(t1.getText());
                double v = x / T;
                String Q = Double.toString(v);
                t3.setText(Q);

            }
            if (t1.getText().equals("") && t2.getText().length() >= 1 && t3.getText().length() >= 1) {
                t.setForeground(Color.GREEN);
                double x= Double.parseDouble(t2.getText());
                double  v= Double.parseDouble(t3.getText());
                double t=x / v;
                String Q = Double.toString(t);
                t1.setText(Q);
            }


            if (t2.getText().equals("") && t3.getText().length() >= 1 && t1.getText().length() >= 1) {
                x.setForeground(Color.GREEN);
                double  t= Double.parseDouble(t1.getText());
                double  v= Double.parseDouble(t3.getText());
                double x=v*t;
                String Q = Double.toString(x);
                t2.setText(Q);
            }



        }
    }
}







