package methods;

import java.awt.Color;
import java.sql.*;
import javax.swing.*;

public class ClientContentsEditor {
	
	public void displayClientContents(String query, JTextField id, JTextField fname, JTextField lname, JTextField company, JLabel lbl) {
		try {
			SQLConnection sql = new SQLConnection();
			Connection conn = sql.getConnection();
			//String query = "SELECT * FROM clients where id = ?";
		
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id.getText()));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				fname.setText(rs.getString("firstname"));
				lname.setText(rs.getString("lastname"));
				company.setText(rs.getString("company"));
			}
			else 
			{
				lbl.setText("Entry Not Found");
				lbl.setForeground(Color.RED);
				lbl.setVisible(true);
			}
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Something's wrong...");
		}
	}
	
	public void editClientEntry(String query, String query2, JTextField id, JTextField fname, JTextField lname, JTextField company, JLabel lbl, JButton btn, JTable table)  {
		if(id.getText().trim().isEmpty() || fname.getText().trim().isEmpty() || lname.getText().trim().isEmpty() || company.getText().trim().isEmpty()) 
			{
				lbl.setText("Empty TextField.");
				lbl.setForeground(Color.RED);
				lbl.setVisible(true);
			}
		else {
			try {
				SQLConnection sql = new SQLConnection();
				Connection conn = sql.getConnection();
				//String query = "UPDATE clients SET firstname = ?, lastname = ?, company = ? where id = ?";
				
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, fname.getText());
				ps.setString(2, lname.getText());
				ps.setString(3, company.getText());
				ps.setInt(4, Integer.parseInt(id.getText()));
				
				ps.executeUpdate();
				lbl.setText("Entry Updated.");
				lbl.setForeground(Color.ORANGE);
				lbl.setVisible(true);
				ClearTextField ct = new ClearTextField();
				DisplayTable dt = new DisplayTable();
				ct.clearTextField(id, fname, lname, company);
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
