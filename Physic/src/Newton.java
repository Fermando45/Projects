import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Newton extends JFrame implements ActionListener {


    JFrame frame;

    JLabel des;
    JLabel f;
    JLabel m;
    JLabel a;

    JPanel pan;

    JTextField t1;
    JTextField t2;
    JTextField t3;

    JButton can;
    JButton calc;


    Newton() {

        can = new JButton("Cancel");
        can.setBounds(290, 350, 100, 30);
        can.setFocusPainted(false);
        can.addActionListener(this);

        calc = new JButton("Calculate");
        calc.setBounds(140, 350, 100, 30);
        calc.setFocusPainted(false);
        calc.addActionListener(this);


        f = new JLabel("F");
        f.setBounds(20, 30, 75, 100);
        f.setFont(new Font(null, Font.BOLD, 20));

        m = new JLabel("m");
        m.setBounds(20, 75, 75, 100);
        m.setFont(new Font(null, Font.BOLD, 20));

        a = new JLabel("a");
        a.setBounds(20, 115, 75, 100);
        a.setFont(new Font(null, Font.BOLD, 20));


        t1 = new JTextField();
        t1.setBounds(50, 70, 50, 25);

        t2 = new JTextField();
        t2.setBounds(50, 113, 50, 25);


        t3 = new JTextField();
        t3.setBounds(50, 156, 50, 25);

        JTextArea textArea = new JTextArea(
                "According to the Newton second law of motion" +
                        "the forc can be expressed by the produce of mass and acceleration" + "\n" +
                        "Formula:F=m*a"+"\n"+
                        "Formulet:a=F/m"+"\n"+
                        "Formule:m=F/t"

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
        this.setTitle("Newton");
        this.add(can);
        this.add(calc);
        this.add(f);
        this.add(m);
        this.add(a);
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
            f.setForeground(Color.BLACK);
            m.setForeground(Color.BLACK);
            a.setForeground(Color.BLACK);
        }
        if (e.getSource() == calc) {
            if (t3.getText().equals("") && t2.getText().length() >= 1 && t1.getText().length() >= 1) {
                a.setForeground(Color.GREEN);
                double m = Double.parseDouble(t2.getText());
                double f = Double.parseDouble(t1.getText());
                double a = f/ m;
                String Q = Double.toString(a);
                t3.setText(Q);

            }
            if (t1.getText().equals("") && t2.getText().length() >= 1 && t3.getText().length() >= 1) {
                f.setForeground(Color.GREEN);
                double m = Double.parseDouble(t2.getText());
                double  a= Double.parseDouble(t3.getText());
                double f=m*a;
                String Q = Double.toString(f);
                t1.setText(Q);
            }


            if (t2.getText().equals("") && t3.getText().length() >= 1 && t1.getText().length() >= 1) {
                m.setForeground(Color.GREEN);
                double  f= Double.parseDouble(t1.getText());
                double  a= Double.parseDouble(t3.getText());
                double m=f/a;
                String Q = Double.toString(m);
                t2.setText(Q);
            }



        }
    }
}
