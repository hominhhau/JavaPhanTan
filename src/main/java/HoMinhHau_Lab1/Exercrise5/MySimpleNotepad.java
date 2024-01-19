package HoMinhHau_Lab1.Exercrise5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MySimpleNotepad extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu mFile, mEdit, mHelp;
    private JMenuItem itemNew, itemOpen, itemSave, itemExit;
    private JMenuItem itemCut, itemCopy, itemPaste, itemFind, itemReplace;
    private JTextArea tpContent;
    private JLabel lbStatus;

    public MySimpleNotepad() {
        super("Tý tèo Simple Notepad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        menuBar = new JMenuBar();
        mFile = new JMenu("File");
        mEdit = new JMenu("Edit");
        mHelp = new JMenu("Help");

        itemNew = new JMenuItem("New");
        itemOpen = new JMenuItem("Open");
        itemSave = new JMenuItem("Save");
        itemExit = new JMenuItem("Exit");

        itemCut = new JMenuItem("Cut");
        itemCopy = new JMenuItem("Copy");
        itemPaste = new JMenuItem("Paste");
        itemFind = new JMenuItem("Find");
        itemReplace = new JMenuItem("Replace");

        itemNew.addActionListener(this);
        itemOpen.addActionListener(this);
        itemSave.addActionListener(this);
        itemExit.addActionListener(this);

        itemCut.addActionListener(this);
        itemCopy.addActionListener(this);
        itemPaste.addActionListener(this);
        itemFind.addActionListener(this);
        itemReplace.addActionListener(this);

        mFile.add(itemNew);
        mFile.add(itemOpen);
        mFile.add(itemSave);
        mFile.add(itemExit);

        mEdit.add(itemCut);
        mEdit.add(itemCopy);
        mEdit.add(itemPaste);
        mEdit.add(itemFind);
        mEdit.add(itemReplace);

        menuBar.add(mFile);
        menuBar.add(mEdit);
        menuBar.add(mHelp);

        setJMenuBar(menuBar);

        tpContent = new JTextArea();
        tpContent.setFont(new Font("Arial", Font.PLAIN, 16));
        tpContent.setLineWrap(true);
        tpContent.setWrapStyleWord(true);

        lbStatus = new JLabel("Ready...");

        add(tpContent, BorderLayout.CENTER);
        add(lbStatus, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == itemNew) {
            tpContent.setText("");
        } else if (o == itemOpen) {
            // TODO: Open a file
        } else if (o == itemSave) {
            // TODO: Save the file
        } else if (o == itemExit) {
            System.exit(0);
        } else if (o == itemCut) {
            tpContent.cut();
        } else if (o == itemCopy) {
            tpContent.copy();
        } else if (o == itemPaste) {
            tpContent.paste();
        } else if (o == itemFind) {
            // TODO: Find a text
        } else if (o == itemReplace) {
            // TODO: Replace a text
        }
    }


}
