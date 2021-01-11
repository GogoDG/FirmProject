package methods;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class DeleteTableContents {
	
	public void deleteTableEntry(String query, String query2, JTextField id, JLabel lbl, JTable table) {
		try {
			SQLConnection sql = new SQLConnection();
			Connection conn = sql.getConnection();
			//String query = "DELETE FROM admins where id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id.getText()));
			ps.executeUpdate();
			lbl.setText("Entry Deleted.");
			lbl.setForeground(Color.RED);
			lbl.setVisible(true);
			id.setText("");
			DisplayTable dt = new DisplayTable();
			dt.displayTable(query2, table);
			table.getColumnModel().getColumn(0).setPreferredWidth(15);
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Something's wrong...");
		}
		
	}

}
