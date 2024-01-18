package HoMinhHau_Lab1.Exercise4;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;


public class CopyTaskGui extends JFrame {

    private JTextField tfFrom;
    private JTextField tfTo;
    private JButton btnCopy;
    private JProgressBar progressBar;

    public CopyTaskGui() {
        initUI();
    }

    private void initUI() {
        setTitle("Copy Task");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Box b, b1, b2, b3, b4;

        add(b = Box.createVerticalBox());
        b.add(b1 = Box.createHorizontalBox());
        b.add(b2 = Box.createHorizontalBox());
        b.add(b3 = Box.createHorizontalBox());
        b.add(b4 = Box.createHorizontalBox());

        b1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10),
                BorderFactory.createTitledBorder("From")));
        b2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10),
                BorderFactory.createTitledBorder("To")));

        b4.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        b1.add(tfFrom = new JTextField(20));
        b2.add(tfTo = new JTextField(20));
        b3.add(btnCopy = new JButton("Copy"));
        b4.add(progressBar = new JProgressBar(0, 100));
        progressBar.setStringPainted(true);

        tfFrom.setText("D:/Lab_PhanTanJava/1. Threading Lab.pdf");
        tfTo.setText("D:/Lab_PhanTanJava/1. Threading Lab - Copy.pdf");

        btnCopy.addActionListener(e -> {
            String from = tfFrom.getText();
            String to = tfTo.getText();
            CopyTask task = new CopyTask(from, to, progressBar);
            task.execute();
        });
    }



}


    // @Override
    // protected void process(java.util.List<Long> chunks) {
    // progressBar.setValue((int) (chunks.get(chunks.size() - 1) * 100 / new
    // File(from).length()));
    // }

