package za.ac.cput.views.book;

import com.google.gson.Gson;
import okhttp3.*;
import za.ac.cput.entity.Book;
import za.ac.cput.factory.BookFac;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class addBook extends JFrame implements ActionListener {

    public static final MediaType JSON =
            MediaType.get("application/json; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

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

    public addBook (){
        super("Library Loan Application");
        lblMenuName = new JLabel("Add a Book", (int) CENTER_ALIGNMENT);
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

    public void setAddBookGUI() {
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
        btnExit.addActionListener(this);

        this.setPreferredSize(new Dimension(300, 300));

        this.pack();
        this.setLocationRelativeTo(null); // Center screen
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            saveToDb(txtShelf.getText(),
                    txtAuthor.getText(),
                    txtName.getText(),
                    txtDesc.getText(),
                    txtKeyword.getText());

        } else if (e.getSource() == btnExit) {
            addBook.main(null);
            this.setVisible(false);
        }

    }

    public void saveToDb(String shelfNumber, String authorname, String bookName,
                         String bookDescription, String keywords) {
        try {
            final String URL = "http://localhost:3306/book/create";

            Book book = BookFac.createBook(shelfNumber, authorname, bookName, bookDescription, keywords);
            Gson g = new Gson();
            String jsonString = g.toJson(book);
            String r = post(URL, jsonString);
            if (r != null) {
                JOptionPane.showMessageDialog(null, "Success! Book saved.");
                addBook.main(null);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Oh no! Book not saved.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String post(final String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request
                .Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) {
        new addBook().setAddBookGUI();
    }
}
