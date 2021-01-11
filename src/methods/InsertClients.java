package methods;

import java.awt.Color;
import java.sql.*;
import javax.swing.*;;

public class InsertClients {
	
	public void insertIntoClients(String query, String query2, JTextField id, JTextField fname, JTextField lname, JTextField company, JLabel lbl, JTable table) {
		try {
			SQLConnection sql = new SQLConnection();
			Connection conn = sql.getConnection();
			//String query = "INSERT INTO clients values (?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id.getText()));
			ps.setString(2, fname.getText());
			ps.setString(3, lname.getText());
			ps.setString(4, company.getText());
			
			ps.executeUpdate();
			ClearTextField ct = new ClearTextField();
			DisplayTable dt = new DisplayTable();
			ct.clearTextField(id, fname, lname, company);
			dt.displayTable(query2, table);
			table.getColumnModel().getColumn(0).setPreferredWidth(15);
			
			lbl.setText("Entry Inserted.");
			lbl.setForeground(Color.GREEN);
			lbl.setVisible(true);
			
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Duplicate entry detected!");
		}
	}

}
