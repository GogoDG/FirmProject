package methods;

import java.sql.*;
import javax.swing.*;

public class InsertStaff {
	
	public void insertIntoStaff(String query, String query2, JTextField id, JTextField fname, JTextField lname, JTextField username, JTextField password, JTable table) {
		try {
			SQLConnection sql = new SQLConnection();
			Connection conn = sql.getConnection();
			//String query = "INSERT INTO admins values (?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id.getText()));
			ps.setString(2, fname.getText());
			ps.setString(3, lname.getText());
			ps.setString(4, username.getText());
			ps.setString(5, password.getText());
			
			ps.executeUpdate();
			ClearTextField ct = new ClearTextField();
			DisplayTable dt = new DisplayTable();
			ct.clearTextField(id, fname, lname, username, password);
			dt.displayTable(query2, table);
			table.getColumnModel().getColumn(0).setPreferredWidth(15);
			
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Duplicate entry detected!");
		}	
	}

}
