import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class weight extends JFrame implements ActionListener {
    JFrame frame;

    JLabel des;
    JLabel w;
    JLabel m;
    JLabel g;

    JPanel pan;

    JTextField t1;
    JTextField t2;
    JTextField t3;

    JButton can;
    JButton calc;


    weight() {

        can = new JButton("Cancel");
        can.setBounds(290, 350, 100, 30);
        can.setFocusPainted(false);
        can.addActionListener(this);

        calc = new JButton("Calculate");
        calc.setBounds(140, 350, 100, 30);
        calc.setFocusPainted(false);
        calc.addActionListener(this);


        g = new JLabel("g");
        g.setBounds(20, 30, 75, 100);
        g.setFont(new Font(null, Font.BOLD, 20));

        m = new JLabel("m");
        m.setBounds(20, 75, 75, 100);
        m.setFont(new Font(null, Font.BOLD, 20));

        w = new JLabel("w");
        w.setBounds(20, 115, 75, 100);
        w.setFont(new Font(null, Font.BOLD, 20));


        t1 = new JTextField("10");
        t1.setBounds(50, 70, 50, 25);
        t1.setEditable(false);

        t2 = new JTextField();
        t2.setBounds(50, 113, 50, 25);


        t3 = new JTextField();
        t3.setBounds(50, 156, 50, 25);

        JTextArea textArea = new JTextArea(
                "Weight is nothing but the force " +
                        "which an object experiences due to gravity" + "\n" +
                        "Formula:W=m*g"
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
        this.add(g);
        this.add(m);
        this.add(w);
        this.add(t1);
        this.add(t2);
        this.add(t3);
        this.add(pan);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == can) {

            t2.setText("");
            t3.setText("");
            m.setForeground(Color.BLACK);
            g.setForeground(Color.BLACK);
            w.setForeground(Color.BLACK);
        }
        if (e.getSource() == calc) {
            if (t3.getText().equals("") && t2.getText().length() >= 1 && t1.getText().length() >= 1) {
                w.setForeground(Color.GREEN);
                double m = Double.parseDouble(t2.getText());
                double g = Double.parseDouble(t1.getText());
                double w = m*g;
                String Q = Double.toString(w);
                t3.setText(Q);

            }
            if (t1.getText().equals("") && t2.getText().length() >= 1 && t3.getText().length() >= 1) {
                g.setForeground(Color.GREEN);
                double m= Double.parseDouble(t2.getText());
                double w= Double.parseDouble(t3.getText());
                double g=w / m;
                String Q = Double.toString(g);
                t1.setText(Q);
            }


            if (t2.getText().equals("") && t3.getText().length() >= 1 && t1.getText().length() >= 1) {
                m.setForeground(Color.GREEN);
                double  g= Double.parseDouble(t1.getText());
                double  w= Double.parseDouble(t3.getText());
                double  m=w / g;
                String Q = Double.toString(m);
                t2.setText(Q);
            }



        }
    }
}