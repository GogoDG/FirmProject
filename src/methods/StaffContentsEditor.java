package methods;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class StaffContentsEditor {
	
	public void displayStaffContents(String query, JTextField id, JTextField fname, JTextField lname, JTextField username, JTextField password) {
		try {
			SQLConnection sql = new SQLConnection();
			Connection conn = sql.getConnection();
			//String query = "SELECT * FROM admins where id = ?";
		
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id.getText()));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				fname.setText(rs.getString("firstname"));
				lname.setText(rs.getString("lastname"));
				username.setText(rs.getString("username"));
				password.setText(rs.getString("password"));
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Entry Not Found.");
			}
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Something's wrong...");
		}
	}
	
	public void editStaffEntry(String query, String query2, JTextField id, JTextField fname, JTextField lname, JTextField username, JTextField password, JLabel lbl, JButton btn, JTable table)  {
		if(id.getText().trim().isEmpty() || fname.getText().trim().isEmpty() || lname.getText().trim().isEmpty() || username.getText().trim().isEmpty() || password.getText().trim().isEmpty()) 
			{
				lbl.setText("Empty TextField.");
				lbl.setForeground(Color.RED);
				lbl.setVisible(true);
			}
		else {
			try {
				SQLConnection sql = new SQLConnection();
				Connection conn = sql.getConnection();
				//String query = "UPDATE admins SET firstname = ?, lastname = ?, username = ?, password = ? where id = ?";
				
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, fname.getText());
				ps.setString(2, lname.getText());
				ps.setString(3, username.getText());
				ps.setString(4, password.getText());
				ps.setInt(5, Integer.parseInt(id.getText()));
				
				ps.executeUpdate();
				lbl.setText("Entry Updated.");
				lbl.setForeground(Color.ORANGE);
				lbl.setVisible(true);
				ClearTextField ct = new ClearTextField();
				DisplayTable dt = new DisplayTable();
				ct.clearTextField(id, fname, lname, username, password);
				dt.displayTable(query2, table);
				table.getColumnModel().getColumn(0).setPreferredWidth(15);
				btn.setVisible(false);
				
				conn.close();
			} catch (SQLException e) {
				System.out.println("Something's wrong...");
			}
		}	
	}
}
