package koneksidatabase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {
    JLabel title;

    JLabel lNim = new JLabel("Nim : ");
    JTextField tfNim = new JTextField();
    JLabel lNama = new JLabel("Nama : ");
    JTextField tfNama = new JTextField();
    JLabel lAlamat = new JLabel("Alamat : ");
    JTextField tfAlamat = new JTextField();

    JLabel lNim2 = new JLabel("Nim : ");
    JLabel lNama2 = new JLabel("Nama : ");
    JTextField tfNama2 = new JTextField();
    JLabel lAlamat2 = new JLabel("Alamat : ");
    JTextField tfAlamat2 = new JTextField();

    JComboBox daftarNim = new JComboBox();

    JButton btnInsert = new JButton("Insert");
    JButton btnReset1 = new JButton("Reset");
    JButton btnUpdate = new JButton("Update");
    JButton btnReset2 = new JButton("Reset");

    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    Object namaKolom[] = {"NIM", "Nama", "Alamat"};

    public View() {
        tableModel = new DefaultTableModel(namaKolom, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(530, 550);

        title = new JLabel("Data Mahasiswa");
        add(title);
        title.setBounds(200, 5, 100, 20);

        title = new JLabel("Insert Data");
        add(title);
        title.setBounds(100, 35, 100, 20);

        title = new JLabel("Update Data");
        add(title);
        title.setBounds(350, 35, 100, 20);

        add(scrollPane);
        scrollPane.setBounds(20, 195, 480, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(lNim);
        lNim.setBounds(20, 65, 90, 20);
        add(tfNim);
        tfNim.setBounds(110, 65, 120, 20);
        add(lNama);
        lNama.setBounds(20, 90, 90, 20);
        add(tfNama);
        tfNama.setBounds(110, 90, 120, 20);
        add(lAlamat);
        lAlamat.setBounds(20, 115, 90, 20);
        add(tfAlamat);
        tfAlamat.setBounds(110, 115, 120, 20);

        add(lNim2);
        lNim2.setBounds(270, 65, 90, 20);
        add(daftarNim);
        daftarNim.setBounds(360, 65, 120, 20);
        add(lNama2);
        lNama2.setBounds(270, 90, 90, 20);
        add(tfNama2);
        tfNama2.setBounds(360, 90, 120, 20);
        add(lAlamat2);
        lAlamat2.setBounds(270, 115, 90, 20);
        add(tfAlamat2);
        tfAlamat2.setBounds(360, 115, 120, 20);

        add(btnInsert);
        btnInsert.setBounds(20, 155, 90, 20);
        add(btnReset1);
        btnReset1.setBounds(130, 155, 90, 20);
        add(btnUpdate);
        btnUpdate.setBounds(270, 155, 90, 20);
        add(btnReset2);
        btnReset2.setBounds(380, 155, 90, 20);
    }

    public String getNim(){
        return tfNim.getText();
    }

    public String getNama(){
        return tfNama.getText();
    }

    public String getAlamat(){
        return tfAlamat.getText();
    }

    public String getNimCombo(){
        return daftarNim.getSelectedItem().toString();
    }

    public String getNama2(){
        return tfNama2.getText();
    }

    public String getAlamat2(){
        return tfAlamat2.getText();
    }
}
