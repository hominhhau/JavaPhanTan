package HoMinhHau_Lab1.Exercise4;

import javax.swing.*;
import java.io.*;

public class CopyFileGUI extends JFrame {

    private JTextField txtFrom;
    private JTextField txtTo;
    private JButton btnCopy;
    private JProgressBar progressBar;

    public CopyFileGUI() {
        initUI();
    }

    private void initUI() {
        setTitle("Copy ");
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

        b1.add(txtFrom = new JTextField(20));
        b2.add(txtTo = new JTextField(20));
        b3.add(btnCopy = new JButton("Copy"));
        b4.add(progressBar = new JProgressBar(0, 100));
        progressBar.setStringPainted(true);

        txtFrom.setText("D:/Lab_PhanTanJava/1. Threading Lab.pdf");
        txtTo.setText("D:/Lab_PhanTanJava/1. Threading Lab - Copy.pdf");

        btnCopy.addActionListener(e -> {
            String from = txtFrom.getText();
            String to = txtTo.getText();
            if(from.equals("") || to.equals("")){
               JOptionPane.showMessageDialog(null,"Please enter the path");
            }else{
                Thread t = new Thread(() -> copyFile());
                t.start();

            }
        });

    }
    private void copyFile(){

        File srcFile = new File(txtFrom.getText());
        if (srcFile.exists()) {
            File destFile = new File(txtTo.getText());
            try (InputStream in = new FileInputStream(srcFile);
                 OutputStream out = new FileOutputStream(destFile)) {
                int len;
                float srcFileSize = in.available() / 1000.0f;
                float totalCopied = 0.0f;
                byte[] bytes = new byte[1024];
                while ((len = in.read(bytes)) > 0) {
                    out.write(bytes, 0, len);
                    totalCopied += len;
                    float percent = ((totalCopied / 1000.0f) / srcFileSize) * 100;
                    progressBar.setValue((int) percent);
                    Thread.sleep(1);
                }
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null,"File not found");
        }
    }


    public static void main(String[] args) {
        CopyFileGUI gui = new CopyFileGUI();
        gui.setVisible(true);
    }



}




