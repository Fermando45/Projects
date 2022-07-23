import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PE extends JFrame implements ActionListener {
    JFrame frame;

    JLabel des;
    JLabel m;
    JLabel g;
    JLabel h;
    JLabel PE;

    JPanel pan;

    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;

    JButton can;
    JButton calc;


    PE() {

        can = new JButton("Cancel");
        can.setBounds(290, 350, 100, 30);
        can.setFocusPainted(false);
        can.addActionListener(this);

        calc = new JButton("Calculate");
        calc.setBounds(140, 350, 100, 30);
        calc.setFocusPainted(false);
        calc.addActionListener(this);


        m = new JLabel("m");
        m.setBounds(20, 30, 75, 100);
        m.setFont(new Font(null, Font.BOLD, 20));

        g = new JLabel("g");
        g.setBounds(20, 75, 75, 100);
        g.setFont(new Font(null, Font.BOLD, 20));

        h = new JLabel("h");
        h.setBounds(20, 115, 75, 100);
        h.setFont(new Font(null, Font.BOLD, 20));

        PE=new JLabel("PE");
        PE.setBounds(20,160,75,100);
        PE.setFont(new Font(null, Font.BOLD, 20));



        t1 = new JTextField();
        t1.setBounds(50, 70, 50, 25);

        t2 = new JTextField("10");
        t2.setBounds(50, 113, 50, 25);
        //t2.setEditable(false);


        t3 = new JTextField();
        t3.setBounds(50, 156, 50, 25);

        t4=new JTextField();
        t4.setBounds(50,199,50,25);

        JTextArea textArea = new JTextArea(
                "Stored energy that depends upon the relative" +
                        "position of varius parts of system" + "\n" +
                        "Formula:PE=m*g*h"+"\n"+
                        "Formulet:m=PE/g*h"+"\n"+
                        "Formule:h=PE/m*g"

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
        this.setTitle("PE");
        this.add(can);
        this.add(calc);
        this.add(m);
        this.add(g);
        this.add(h);
        this.add(t1);
        this.add(t2);
        this.add(t3);
        this.add(pan);
        this.add(t4);
        this.add(PE);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == can) {
            t1.setText("");
            t2.setText("10");
            t3.setText("");
            t4.setText("");
            m.setForeground(Color.BLACK);
            g.setForeground(Color.BLACK);
            h.setForeground(Color.BLACK);
            PE.setForeground(Color.BLACK);
        }
        if (e.getSource() == calc) {

            if (t3.getText().equals("") && t2.getText().length() >= 1 && t1.getText().length() >= 1 && t4.getText().length()>=1) {
                h.setForeground(Color.GREEN);
                t2.setText("10");
                double g = Double.parseDouble(t2.getText());
                double m = Double.parseDouble(t1.getText());
                double PE=Double.parseDouble(t4.getText());
                double h = PE / (g*m);
                String Q = Double.toString(h);
                t3.setText(Q);

            }
            if (t1.getText().equals("") && t2.getText().length() >= 1 && t3.getText().length() >= 1&& t4.getText().length()>=1) {
                m.setForeground(Color.GREEN);
                t2.setText("10");
                double PE=Double.parseDouble(t4.getText());
                double g= Double.parseDouble(t2.getText());
                double  h= Double.parseDouble(t3.getText());
                double m=PE/(g*h);
                String Q = Double.toString(m);
                t1.setText(Q);
            }


            if (t4.getText().equals("") && t3.getText().length() >= 1 && t1.getText().length() >= 1&& t2.getText().length()>=1) {
                PE.setForeground(Color.GREEN);
                t2.setText("10");
                double g=Double.parseDouble(t2.getText());
                double  m= Double.parseDouble(t1.getText());
                double  h= Double.parseDouble(t3.getText());
                double PE=m*g*h;
                String Q = Double.toString(PE);
                t4.setText(Q);
            }



        }
    }
}
