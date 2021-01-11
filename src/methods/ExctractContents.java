package methods;

import java.math.*;
import java.sql.*;
import javax.swing.*;

public class ExctractContents {
	String fname;
	String lname;
	String company;
	String pname;
	String brand;
	int quantity;
	BigDecimal price;
	
	public void getClient(JTextField clientid) {
		try {
			SQLConnection sql = new SQLConnection();
			Connection conn = sql.getConnection();
			String query = "SELECT * FROM clients where id = ?";
		
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(clientid.getText()));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				fname = rs.getString("firstname");
				lname = rs.getString("lastname");
				company = rs.getString("company");
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
	
	public void getStock(JTextField productid) {
		try {
			SQLConnection sql = new SQLConnection();
			Connection conn = sql.getConnection();
			String query = "SELECT * FROM products where id = ?";
		
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(productid.getText()));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				pname = rs.getString("product_name");
				brand = rs.getString("product_brand");
				price = rs.getBigDecimal("product_price");
				quantity = rs.getInt("product_qnty");
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

}
