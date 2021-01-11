package methods;

import java.sql.*;
import javax.swing.*;

public class DuplicateUsernameScanner {
	
	public void isDuplicateUsername(String query, String query2, String query3, JTextField id, JTextField fname, JTextField lname, JTextField username, JTextField password, JLabel lbl, JTable table, String regex) {
		try {
			SQLConnection sql = new SQLConnection();
			Connection conn = sql.getConnection();
			//String query = "SELECT * FROM admins/sales_rep WHERE username = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username.getText());
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Duplicate username detected!");
			} 
			else {
				PasswordValidator pv = new PasswordValidator();
				pv.isValidPassword(query2, query3, id, fname, lname, username, password, lbl, table, regex);
			}
			
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Duplicate entry detected!");
		}
	}

}
