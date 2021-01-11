package methods;

import java.awt.Color;
import java.math.BigDecimal;
import java.sql.*;
import javax.swing.*;

public class StockContentsEditor {
	
	public void displayStockContents(String query, JTextField id, JTextField pname, JTextField brand, JTextField price, JTextField quantity) {
		try {
			SQLConnection sql = new SQLConnection();
			Connection conn = sql.getConnection();
			//String query = "SELECT * FROM admins where id = ?";
		
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id.getText()));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				pname.setText(rs.getString("product_name"));
				brand.setText(rs.getString("product_brand"));
				price.setText(rs.getString("product_price"));
				quantity.setText(rs.getString("product_qnty"));
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
	
	public void editStockEntry(String query, String query2, JTextField id, JTextField pname, JTextField brand, JTextField price, JTextField quantity, JLabel lbl, JButton btn, JTable table)  {
		if(id.getText().trim().isEmpty() || pname.getText().trim().isEmpty() || brand.getText().trim().isEmpty() || price.getText().trim().isEmpty() || quantity.getText().trim().isEmpty()) 
			{
				lbl.setText("Empty TextField.");
				lbl.setForeground(Color.RED);
				lbl.setVisible(true);
			}
		else {
			try {
				SQLConnection sql = new SQLConnection();
				Connection conn = sql.getConnection();
				//String query = "UPDATE products SET product_name = ?, product_brand = ?, prduct_price = ?, prduct_qnty = ? where id = ?";
				BigDecimal Price = new BigDecimal(price.getText());
				
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, pname.getText());
				ps.setString(2, brand.getText());
				ps.setBigDecimal(3, Price);
				ps.setInt(4, Integer.parseInt(quantity.getText()));
				ps.setInt(5, Integer.parseInt(id.getText()));
				
				ps.executeUpdate();
				lbl.setText("Entry Updated.");
				lbl.setForeground(Color.ORANGE);
				lbl.setVisible(true);
				ClearTextField ct = new ClearTextField();
				DisplayTable dt = new DisplayTable();
				ct.clearTextField(id, pname, brand, price, quantity);
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
	
