import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Accleration extends JFrame implements ActionListener {
    JFrame frame;

    JLabel des;
    JLabel a;
    JLabel v;
    JLabel t;

    JPanel pan;

    JTextField t1;
    JTextField t2;
    JTextField t3;

    JButton can;
    JButton calc;


    Accleration() {

        can = new JButton("Cancel");
        can.setBounds(290, 350, 100, 30);
        can.setFocusPainted(false);
        can.addActionListener(this);

        calc = new JButton("Calculate");
        calc.setBounds(140, 350, 100, 30);
        calc.setFocusPainted(false);
        calc.addActionListener(this);


        a = new JLabel("a");
        a.setBounds(20, 30, 75, 100);
        a.setFont(new Font(null, Font.BOLD, 20));

        t = new JLabel("Δv");
        t.setBounds(20, 75, 75, 100);
        t.setFont(new Font(null, Font.BOLD, 20));

        v = new JLabel("Δt");
        v.setBounds(20, 115, 75, 100);
        v.setFont(new Font(null, Font.BOLD, 20));


        t1 = new JTextField();
        t1.setBounds(50, 70, 50, 25);

        t2 = new JTextField();
        t2.setBounds(50, 113, 50, 25);


        t3 = new JTextField();
        t3.setBounds(50, 156, 50, 25);

        JTextArea textArea = new JTextArea(
                "Acceleration is a defined as the rate of change " +
                        "in velocity to the change in time" + "\n" +
                        "Formula:a=Δv/Δt"+"\n"+
                        "Formulet:Δv=a*Δt"+"\n"+
                        "Formule:t=Δv/a"+"\n"+
                        "Δv=(1)v-(0)v"+"\n"+
                        "Δt=(2)t-(1)t"

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
        this.setTitle("Speed");
        this.add(can);
        this.add(calc);
        this.add(t);
        this.add(a);
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
            a.setForeground(Color.BLACK);
            v.setForeground(Color.BLACK);
            t.setForeground(Color.BLACK);
        }
        if (e.getSource() == calc) {
            if (t3.getText().equals("") && t2.getText().length() >= 1 && t1.getText().length() >= 1) {
                v.setForeground(Color.GREEN);
                double v = Double.parseDouble(t2.getText());
                double a = Double.parseDouble(t1.getText());
                double t = v / a;
                String Q = Double.toString(t);
                t3.setText(Q);
            }
            if (t1.getText().equals("") && t2.getText().length() >= 1 && t3.getText().length() >= 1) {
                a.setForeground(Color.GREEN);
                double v= Double.parseDouble(t2.getText());
                double  t= Double.parseDouble(t3.getText());
                double a=v / t;
                String Q = Double.toString(a);
                t1.setText(Q);
            }


            if (t2.getText().equals("") && t3.getText().length() >= 1 && t1.getText().length() >= 1) {
                v.setForeground(Color.GREEN);
                double  a= Double.parseDouble(t1.getText());
                double  t= Double.parseDouble(t3.getText());
                double v=a*t;
                String Q = Double.toString(v);
                t2.setText(Q);
            }



        }
    }
}





