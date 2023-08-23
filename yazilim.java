import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Library_management extends JFrame implements ActionListener{
    private JLabel label1, label2, label3, label4, label4, label5, label6, label7;
    private JTextField textfield1, textfield2, textfield3, textfield4, textfield5, textfield6, textfield7;
    private JButton EkleButton, GörButton, DüzenleButton, SilButton, TemizleButton, CıkışButton;
    private JPanel panel;
    private ArrayList<String[]> books = new ArrayList<String[]>();

    public Library_management() {
        setTitle("Kütüphaneler İçin Kütüphane Yazılımı");
        setSize (600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel ("Kitap Numarası");
        label2 = new JLabel ("Kitap İsmi");
        label3 = new JLabel ("Yazar");
        label4 = new JLabel ("Yayınevi/Yayıncı");
        label5 = new JLabel ("Yayım Yılı");
        label6 = new JLabel ("Uluslararası Standart Kitap Numarası(Barkod)");
        label7 = new JLabel ("Satış Sayısı");

        textfield1 = new JTextField(10);
        textfield2 = new JTextField(20);
        textfield3 = new JTextField(20);
        textfield4 = new JTextField(20);
        textfield5 = new JTextField(10);
        textfield6 = new JTextField(20);
        textfield7 = new JTextField(10);

        EkleButton = new JButton("Ekle");
        GörButton = new JButton("Gör");
        DüzenleButton = new JButton("Düzenle");
        SilButton = new JButton("Sil");
        TemizleButton = new JButton("Temizle");
        ÇıkışButton = new JButton("Çıkış");

        EkleButton.addActionListener(this);
        GörButton.addActionListener(this);
        DüzenleButton.addActionListener(this);
        SilButton.addActionListener(this);
        TemizleButton.addActionListener(this);
        CıkışButton.addActionListener(this);

        panel = new JPanel (new GridLayout(10, 2));
        panel.add(label1);
        panel.add(textfield1);
        panel.add(label2);
        panel.add(textfield2);
        panel.add(label3);
        panel.add(textfield3);
        panel.add(label4);
        panel.add(textfield4);
        panel.add(label5);
        panel.add(textfield5);
        panel.add(label6);
        panel.add(textfield6);
        panel.add(label7);
        panel.add(textfield7);
        panel.add(EkleButton);
        panel.add(GörButton);
        panel.add(DüzenleButton);
        panel.add(SilButton);
        panel.add(TemizleButton);
        panel.add(CıkışButton);

        add(panel);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource () == EkleButton) {
            String [] book = new String[7];
            book[0] = textfield1.getText();
            book[1] = textfield2.getText();
            book[2] = textfield3.getText();
            book[3] = textfield4.getText();
            book[4] = textfield5.getText();
            book[5] = textfield6.getText();
            book[6] = textfield7.getText();
            books.add(book);
            JOptionPane.showMessageDialog(this,"Kitap Başarıyla Kütüphaneye Eklendi.");
            clearFields();
        }   else if (e.getSource () == GörButton) {
             String[] columns = {"Kitap Numarası", "Kitap İsmi", "Yazar", "Yayınevi/Yayıncı", "Yayım Yılı", "Uluslararası Standart Kitap Numarası(Barkod)",  "Satış Sayısı"};
             Object [][] data = new Object [books.size()][7];
             for (int i = 0; i < books.size (); i++) {
                data [i] [0] = books.get(i) [0];
                data [i] [1] = books.get(i) [1];
                data [i] [2] = books.get(i) [2];
                data [i] [3] = books.get(i) [3];
                data [i] [4] = books.get(i) [4];
                data [i] [5] = books.get(i) [5];
                data [i] [6] = books.get(i) [6];

                JTable table= new JTable(data, columns);
                JScrollPane scrollPane = new JScrollPane(table);
                JFrame frame = new  JFrame ("Tüm Kitapları Görüntüle";)
                frame.add(scrollPane);
                frame.setSize(800, 400);
                frame.setVisible(true);
             }  else if (e.getSource() == DüzenleButton) {
            String KitapNumarası=JOptionPane.showInputDialog(this,"Düzenlemek için kitap numarasını girin.");
            for (int i = 0; i < books.size(); i++) {
                if (books.get (i) [0].equals(KitapNumarası)) {
                    String[] book = new String[7];
                    book[0] = KitapNumarası;
                    book[1] = textfield2.getText();

                    book[2] =  textfield3.getText();
                    book[3] =  textfield4.getText();
                    book[4] =  textfield5.getText();
                    book[5] =  textfield6.getText();
                    book[6] =  textfield7.getText();
                    books.set(i, book);
                    JOptionPane.showMessageDialog(this,"Kitap Bilgileri Düzenlendi");
                    clearFields();
                    return;
                } }
            JOptionPane.showMessageDialog(this, "Kitap Bulunamadı");
             } else if (e.getSource() == SilButton) {
            String KitapNumarası = JOptionPane.showInputDialog(this, "Silmek için Kitap Numarasaını Girin");
              for (int i = 0; i < books.size(); i++)
                 if (books.get(i)[0].equals(KitapNumarası)) {
                    books.remove(i);
                    JOptionPane.showMessageDialog(this, "Kitap Silindi ");
                    clearFields();
                    return;
                 }}
                 JOptionPane.showMessageDialog(this, "Kitap Bulunamadı");
        }   else if (e.getSource() == TemizleButton) {
               clearFields();
        }   else if (e.getSource() == CıkışButton)   {
               System.exit(0);
        }
    }
    
    private void clearFields() {
        textfield1.setText("");
        textfield2.setText("");
        textfield3.setText("");
        textfield4.setText("");
        textfield5.setText("");
        textfield6.setText("");
        textfield7.setText("");
    }

     Run|Debug
     public static void main(String[] args){
        new Library_management();
     }
}





