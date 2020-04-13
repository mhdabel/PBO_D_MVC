package koneksidatabase;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Controller implements ActionListener{

    Model model;
    View view;
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        if (model.getBanyakData() != 0){
            String data[][] = model.read();
            view.table.setModel(new JTable(data, view.namaKolom).getModel());
            updateDataCombo(model.readNim());
        } else {
            JOptionPane.showMessageDialog(null, "Data Masih Kosong");
        }

        view.btnInsert.addActionListener(this);
        view.btnReset1.addActionListener(this);
        view.btnUpdate.addActionListener(this);
        view.btnReset2.addActionListener(this);

        view.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int baris = view.table.getSelectedRow();
                int kolom = view.table.getSelectedColumn();

                String data = view.table.getValueAt(baris, 0).toString();


                int input = JOptionPane.showConfirmDialog(null,
                        "Apa Anda Ingin Menghapus Data " + data + " ?",
                        "Pilih Opsi..." , JOptionPane.YES_NO_OPTION);

                if (input == 0){
                    model.delete(data);
                    String newData[][] = model.read();
                    view.table.setModel(new JTable(newData, view.namaKolom).getModel());
                    updateDataCombo(model.readNim());
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnInsert) {
            String nim = view.getNim();
            String nama = view.getNama();
            String alamat = view.getAlamat();

            if (nim.equals("")){
                JOptionPane.showMessageDialog(null, "Nim Tidak Boleh Kosong");
            } else if (nim.length() != 9){
                JOptionPane.showMessageDialog(null, "Nim Harus 9 Digit");
            } else {
                model.insert(nim, nama, alamat);
                String newData[][] = model.read();
                view.table.setModel(new JTable(newData, view.namaKolom).getModel());
                updateDataCombo(model.readNim());
            }
        } else if (e.getSource() == view.btnReset1){
            view.tfNim.setText("");
            view.tfNama.setText("");
            view.tfAlamat.setText("");
        } else if (e.getSource() == view.btnUpdate){
            String nim = view.getNimCombo();
            String nama = view.getNama2();
            String alamat = view.getAlamat2();

            if (nama.equals("") || alamat.equals("")){
                JOptionPane.showMessageDialog(null, "Form Tidak Boleh Kosong");
            } else {
                model.update(nim, nama, alamat);
                String newData[][] = model.read();
                view.table.setModel(new JTable(newData, view.namaKolom).getModel());
                updateDataCombo(model.readNim());
            }
        } else if (e.getSource() == view.btnReset2){
            view.tfNama2.setText("");
            view.tfAlamat2.setText("");
        }
    }

    public void updateDataCombo(ArrayList<String> data){
        view.daftarNim.removeAllItems();
        for (String item : data) {
            view.daftarNim.addItem(item);
        }
    }
}
