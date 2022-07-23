import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class KE extends JFrame implements ActionListener {


    JFrame frame;

    JLabel des;
    JLabel KE;
    JLabel m;
    JLabel v;

    JPanel pan;

    JTextField t1;
    JTextField t2;
    JTextField t3;

    JButton can;
    JButton calc;


    KE() {

        can = new JButton("Cancel");
        can.setBounds(290, 350, 100, 30);
        can.setFocusPainted(false);
        can.addActionListener(this);

        calc = new JButton("Calculate");
        calc.setBounds(140, 350, 100, 30);
        calc.setFocusPainted(false);
        calc.addActionListener(this);


        KE = new JLabel("KE");
        KE.setBounds(20, 30, 75, 100);
        KE.setFont(new Font(null, Font.BOLD, 20));

        m = new JLabel("m");
        m.setBounds(20, 75, 75, 100);
        m.setFont(new Font(null, Font.BOLD, 20));

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
                "KE is the energy that is possessed by " +
                        "a body to its state of motion" + "\n" +
                        "Formula:KE=1/2mv^2"+"\n"+
                        "Formulet:v=KE/1/2m Squer root"+"\n"+
                        "Formule:m=KE/v^2"

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
        this.setTitle("KE");
        this.add(can);
        this.add(calc);
        this.add(KE);
        this.add(m);
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
            KE.setForeground(Color.BLACK);
            v.setForeground(Color.BLACK);
            m.setForeground(Color.BLACK);
        }
        if (e.getSource() == calc) {
            if (t3.getText().equals("") && t2.getText().length() >= 1 && t1.getText().length() >= 1) {
                v.setForeground(Color.GREEN);
                double m = Double.parseDouble(t2.getText());
                double KE = Double.parseDouble(t1.getText());
                double v = Math.sqrt(KE/(0.5*m));
                String Q = Double.toString(v);
                t3.setText(Q);

            }
            if (t1.getText().equals("") && t2.getText().length() >= 1 && t3.getText().length() >= 1) {
                KE.setForeground(Color.GREEN);
                double m= Double.parseDouble(t2.getText());
                double  v= Double.parseDouble(t3.getText());
                double KE=(0.5*m) * (v*v);
                String Q = Double.toString(KE);
                t1.setText(Q);
            }


            if (t2.getText().equals("") && t3.getText().length() >= 1 && t1.getText().length() >= 1) {
                m.setForeground(Color.GREEN);
                double  KE= Double.parseDouble(t1.getText());
                double  v= Double.parseDouble(t3.getText());
                double m=KE/(v*v);
                String Q = Double.toString(m);
                t2.setText(Q);
            }



        }
    }
}







