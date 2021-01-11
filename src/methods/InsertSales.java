package methods;

import java.math.*;
import java.sql.*;
import javax.swing.*;

public class InsertSales {
	
	public void insertIntoSales(String tableQuery, JTextField saledate, JTextField clientid, JTextField productid, JTextField quantity, JTable table) {
		try {
			SQLConnection sql = new SQLConnection();
			Connection conn = sql.getConnection();
			String query = "INSERT INTO sales values (?, ?, ?, ?, ?, ?, ?, ?)";
			String query2 = "UPDATE products SET product_qnty = ? where id = ?";
			Date date = Date.valueOf(saledate.getText());
			
			ExctractContents ec = new ExctractContents();
			ec.getClient(clientid);
			ec.getStock(productid);
			
			BigDecimal fullprice = new BigDecimal(BigInteger.ZERO,  2);  
			BigDecimal totalCost = ec.price.multiply(new BigDecimal(quantity.getText()));
			fullprice = fullprice.add(totalCost);
			int qnty = Integer.parseInt(quantity.getText());
			
			if(qnty > ec.quantity) {
				JOptionPane.showMessageDialog(null, "Insufficient Products.");
			}
			else {
					int nqnty = ec.quantity - Integer.parseInt(quantity.getText());
					PreparedStatement ps2 = conn.prepareStatement(query2);
					ps2.setInt(1, nqnty);
					ps2.setInt(2, Integer.parseInt(productid.getText()));
					ps2.executeUpdate();
					
					PreparedStatement ps = conn.prepareStatement(query);
					ps.setDate(1, date);
					ps.setString(2, ec.fname);
					ps.setString(3, ec.lname);
					ps.setString(4, ec.company);
					ps.setString(5, ec.pname);
					ps.setString(6, ec.brand);
					ps.setBigDecimal(7, fullprice);
					ps.setInt(8, Integer.parseInt(quantity.getText()));
					ps.executeUpdate();
					
					ClearTextField ct = new ClearTextField();
					DisplayTable dt = new DisplayTable();
					ct.clearTextField(clientid, productid, quantity, saledate);
					dt.displayTable(tableQuery, table);
					table.getColumnModel().getColumn(0).setPreferredWidth(15);
			}

			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "An Error Occurred!");
		}
	}

}
