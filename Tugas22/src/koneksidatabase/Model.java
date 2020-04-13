package koneksidatabase;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class Model {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbprak?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC ";
    static final String USER = "root";
    static final String PASS = "";
    Connection connection;
    Statement statement;

    public Model() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void insert(String nim, String nama, String alamat){
        try {
            String query = "INSERT INTO `mahasiswa`(`nim`, `nama`, `alamat`) " +
                    "VALUES ('"+nim+"','"+nama+"','"+alamat+"')";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dimasukkan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String[][] read(){
        try {
            int jmlData = 0;
            String data[][] = new String[getBanyakData()][3];
            String query = "Select * from`mahasiswa`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("nim");
                data[jmlData][1] = resultSet.getString("nama");
                data[jmlData][2] = resultSet.getString("alamat");
                jmlData++;
            }
            return data;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<String> readNim(){
        try {
            ArrayList<String> data = new ArrayList<>();
            String query = "Select * from`mahasiswa`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data.add(resultSet.getString("nim"));
            }
            return data;
        } catch (SQLException e) {
            return null;
        }
    }

    public int getBanyakData(){
        try {
            int jmlData = 0;
            String query = "Select * from `mahasiswa`";
            statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
            return jmlData;
        } catch (SQLException e) {
            return 0;
        }
    }

    public void delete(String nim){
        try {
            String query = "DELETE FROM `mahasiswa` WHERE `nim` = '"+nim+"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void update(String nim, String nama, String alamat){
        try {
            String query = "UPDATE `mahasiswa` SET `nama`='" + nama + "',`alamat`='" + alamat + "' WHERE `nim` = '" + nim + "'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
