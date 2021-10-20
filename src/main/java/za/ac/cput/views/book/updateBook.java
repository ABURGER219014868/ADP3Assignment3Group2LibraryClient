package za.ac.cput.views.book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateBook extends JFrame implements ActionListener {
    private JLabel lblMenuName;
    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblShelf;
    private JTextField txtShelf;
    private JLabel lblAuthor;
    private JTextField txtAuthor;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblGenre;
    private JTextField txtGenre;
    private JLabel lblDesc;
    private JTextField txtDesc;
    private JLabel lblKeyword;
    private JTextField txtKeyword;
    private JLabel  lblPadding;
    private JLabel  lblPadding1;
    private JLabel  lblPadding2;
    private JButton btnSave;
    private JButton btnExit;

    public updateBook(){
        super("Library Loan Application");
        lblMenuName = new JLabel("Update a Book", (int) CENTER_ALIGNMENT);
        lblPadding2 = new JLabel("          ");

        lblId = new JLabel("Book ID: ");
        txtId = new JTextField();

        lblShelf = new JLabel("Shelf Number: ");
        txtShelf = new JTextField();

        lblAuthor = new JLabel("Author Name: ");
        txtAuthor = new JTextField();

        lblName = new JLabel("Book Name: ");
        txtName = new JTextField();

        lblGenre = new JLabel("Book Genre: ");
        txtGenre = new JTextField();

        lblDesc = new JLabel("Description");
        txtDesc = new JTextField();

        lblKeyword = new JLabel("Keywords: ");
        txtKeyword = new JTextField();

        lblPadding = new JLabel("             ");
        lblPadding1 = new JLabel("             ");

        btnSave = new JButton("Save");
        btnExit = new JButton("Exit");

    }

    public void setUpdateBookGUI(){
        this.setLayout(new GridLayout(10,2));
        this.add(lblMenuName);
        this.add(lblPadding2);

        this.add(lblId);
        this.add(txtId);

        this.add(lblShelf);
        this.add(txtShelf);

        this.add(lblAuthor);
        this.add(txtAuthor);

        this.add(lblName);
        this.add(txtName);

        this.add(lblGenre);
        this.add(txtGenre);

        this.add(lblDesc);
        this.add(txtDesc);

        this.add(lblKeyword);
        this.add(txtKeyword);


        this.add(lblPadding);
        this.add(lblPadding1);

        this.add(btnSave);
        btnSave.addActionListener(this);
        this.add(btnExit);

        this.setPreferredSize(new Dimension(300, 300));

        this.pack();
        this.setLocationRelativeTo(null); // Center screen
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSave) {
            // Reference custom method here
            JOptionPane.showMessageDialog(null,"Book Saved");
            // Call to user package and the UserMainGUI to show CRUD menu for that entity
        }
        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new updateBook().setUpdateBookGUI();
    }
}
