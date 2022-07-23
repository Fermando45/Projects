import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class power extends JFrame implements ActionListener {
    JFrame frame;

    JLabel des;
    JLabel p;
    JLabel w;
    JLabel t;

    JPanel pan;

    JTextField t1;
    JTextField t2;
    JTextField t3;

    JButton can;
    JButton calc;


    power() {

        can = new JButton("Cancel");
        can.setBounds(290, 350, 100, 30);
        can.setFocusPainted(false);
        can.addActionListener((ActionListener) this);

        calc = new JButton("Calculate");
        calc.setBounds(140, 350, 100, 30);
        calc.setFocusPainted(false);
        calc.addActionListener(this);


        p = new JLabel("p");
        p.setBounds(20, 30, 75, 100);
        p.setFont(new Font(null, Font.BOLD, 20));

        w = new JLabel("w");
        w.setBounds(20, 75, 75, 100);
        w.setFont(new Font(null, Font.BOLD, 20));

        t = new JLabel("t");
        t.setBounds(20, 115, 75, 100);
        t.setFont(new Font(null, Font.BOLD, 20));


        t1 = new JTextField();
        t1.setBounds(50, 70, 50, 25);

        t2 = new JTextField();
        t2.setBounds(50, 113, 50, 25);


        t3 = new JTextField();
        t3.setBounds(50, 156, 50, 25);

        JTextArea textArea = new JTextArea(
                "Energy is capacity to do work. " +
                        "The energy is spent to do work" + "\n" +
                        "Formula:P=W/t"
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
        this.add(p);
        this.add(w);
        this.add(t);
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
            p.setForeground(Color.BLACK);
            w.setForeground(Color.BLACK);
            t.setForeground(Color.BLACK);
        }
        if (e.getSource() == calc) {
            if (t3.getText().equals("") && t2.getText().length() >= 1 && t1.getText().length() >= 1) {
                t.setForeground(Color.GREEN);
                double w = Double.parseDouble(t2.getText());
                double p = Double.parseDouble(t1.getText());
                double t = w / p;
                String Q = Double.toString(t);
                t3.setText(Q);

            }
            if (t1.getText().equals("") && t2.getText().length() >= 1 && t3.getText().length() >= 1) {
                p.setForeground(Color.GREEN);
                double w= Double.parseDouble(t2.getText());
                double  t= Double.parseDouble(t3.getText());
                double p=w / t;
                String Q = Double.toString(p);
                t1.setText(Q);
            }


            if (t2.getText().equals("") && t3.getText().length() >= 1 && t1.getText().length() >= 1) {
                w.setForeground(Color.GREEN);
                double  p= Double.parseDouble(t1.getText());
                double  t= Double.parseDouble(t3.getText());
                double w=p*t;
                String Q = Double.toString(w);
                t2.setText(Q);
            }



        }
    }



}
