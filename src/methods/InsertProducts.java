package methods;

import java.math.BigDecimal;
import java.sql.*;
import javax.swing.*;

public class InsertProducts {
	
	public void insertIntoProducts(String query, String query2, JTextField id, JTextField pname, JTextField brand, JTextField price, JTextField quantity, JTable table) {
		try {
			SQLConnection sql = new SQLConnection();
			Connection conn = sql.getConnection();
			//String query = "INSERT INTO products values (?, ?, ?, ?, ?) where clientid = ?, prductid = ?";
			BigDecimal Price = new BigDecimal(price.getText());
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id.getText()));
			ps.setString(2, pname.getText());
			ps.setString(3, brand.getText());
			ps.setBigDecimal(4, Price);
			ps.setInt(5, Integer.parseInt(quantity.getText()));
			
			ps.executeUpdate();
			ClearTextField ct = new ClearTextField();
			DisplayTable dt = new DisplayTable();
			ct.clearTextField(id, pname, brand, price, quantity);
			dt.displayTable(query2, table);
			table.getColumnModel().getColumn(0).setPreferredWidth(15);
			
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Duplicate entry detected!");
		}	
	}

}
