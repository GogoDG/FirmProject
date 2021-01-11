package methods;

import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class DisplayTable {
	
	public void displayTable(String query, JTable table) {
		try {
			SQLConnection sql = new SQLConnection();
			Connection conn = sql.getConnection();
			//String query = "SELECT * FROM admins";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			conn.close();
		} catch (SQLException e) {
			System.out.println("Something's wrong...");
		}
	}

}
