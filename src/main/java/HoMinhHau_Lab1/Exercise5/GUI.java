package HoMinhHau_Lab1.Exercise5;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private JTextField tfIn;
    private JTextField tfOut;
    private JProgressBar progressBar;
    private JLabel lblIn;
    private JButton btnIn;
    private JLabel lblOut;
    private JButton btnOut;
    private JButton btnSp;
    private JTextField tfInto;
    private JLabel lblInto;

    public GUI() {
        initUI();
    }

    private void initUI() {
        setTitle("Spliter and Combiner");
        setSize(470, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());

        JPanel pNorth = new JPanel();
//        pNorth.add();
        p.add(pNorth, BorderLayout.NORTH);

        JPanel pCen = new JPanel();
        Box b, b1, b2, b3, b4, b5;

        add(b = Box.createVerticalBox());
        b.add(b1 = Box.createHorizontalBox());
        b.add(b2 = Box.createHorizontalBox());
        b.add(b3 = Box.createHorizontalBox());
        b.add(b4 = Box.createHorizontalBox());
        b.add(b5 = Box.createHorizontalBox());

        b1.add(lblIn = new JLabel("Input     "));
        b1.add(tfIn = new JTextField(20));
        b1.add(btnIn = new JButton("-"));
        b2.add(lblOut = new JLabel("Output  "));
        b2.add(tfOut = new JTextField(20));
        b2.add(btnOut = new JButton("-"));
        b3.add(lblInto = new JLabel("Enter Number of filters to splits into: "));
        b3.add(tfInto = new JTextField(20));
        b4.add(btnSp = new JButton("Splits Its"));
        b5.add(progressBar = new JProgressBar(0, 100));
        progressBar.setStringPainted(true);


        b1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        b2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        b3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        b4.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        b5.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        pCen.setBorder((BorderFactory.createTitledBorder("Split File")));
        pCen.add(b);
        p.add(pCen, BorderLayout.CENTER);
        add(p);
    }

    public static void main(String[] args) {
        new GUI().setVisible(true);
    }

}
