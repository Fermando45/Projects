import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Speed extends JFrame implements ActionListener {
    JFrame frame;

    JLabel des;
    JLabel t;
    JLabel l;
    JLabel v;

    JPanel pan;

    JTextField t1;
    JTextField t2;
    JTextField t3;

    JButton can;
    JButton calc;


    Speed() {

        can = new JButton("Cancel");
        can.setBounds(290, 350, 100, 30);
        can.setFocusPainted(false);
        can.addActionListener(this);

        calc = new JButton("Calculate");
        calc.setBounds(140, 350, 100, 30);
        calc.setFocusPainted(false);
        calc.addActionListener(this);


        t = new JLabel("t");
        t.setBounds(20, 30, 75, 100);
        t.setFont(new Font(null, Font.BOLD, 20));

        l = new JLabel("l");
        l.setBounds(20, 75, 75, 100);
        l.setFont(new Font(null, Font.BOLD, 20));

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
                "The speed of a moving body for the overall " +
                        "distance that it has covered" + "\n" +
                        "Formula:V=l/t"+"\n"+
                "Formulet:l=v*t"+"\n"+
                        "Formule:t=l/v"

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
        this.add(l);
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
            l.setForeground(Color.BLACK);
            v.setForeground(Color.BLACK);
            t.setForeground(Color.BLACK);
        }
        if (e.getSource() == calc) {
            if (t3.getText().equals("") && t2.getText().length() >= 1 && t1.getText().length() >= 1) {
                v.setForeground(Color.GREEN);
                double L = Double.parseDouble(t2.getText());
                double T = Double.parseDouble(t1.getText());
                double v = L / T;
                String Q = Double.toString(v);
                t3.setText(Q);

}
            if (t1.getText().equals("") && t2.getText().length() >= 1 && t3.getText().length() >= 1) {
                t.setForeground(Color.GREEN);
                double l= Double.parseDouble(t2.getText());
                double  v= Double.parseDouble(t3.getText());
                double t=l / v;
                String Q = Double.toString(t);
                t1.setText(Q);
            }


            if (t2.getText().equals("") && t3.getText().length() >= 1 && t1.getText().length() >= 1) {
                l.setForeground(Color.GREEN);
                double  t= Double.parseDouble(t1.getText());
                double  v= Double.parseDouble(t3.getText());
                double l=v*t;
                String Q = Double.toString(l);
                t2.setText(Q);
            }



        }
        }
    }

