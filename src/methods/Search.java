package methods;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class Search {
	
	public void searchForDate(JTextField fromdate, JTextField todate, JLabel lbl1, JLabel lbl2, JButton btn, JTable table) {
		try {
			SQLConnection sql = new SQLConnection();
			Connection conn = sql.getConnection();
			Date startDate = Date.valueOf(fromdate.getText());
	        Date endDate = Date.valueOf(todate.getText());
	        String query = "SELECT * FROM sales where saledate between ? and ?";
	        
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setDate(1, startDate);
	        ps.setDate(2, endDate);
	        
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	        	 	String data1 = rs.getString("saledate");
	        	 	String data2 = rs.getString("firstname");
	        	 	String data3 = rs.getString("lastname");
	        	 	String data4 = rs.getString("company");
	     			String data5 = rs.getString("product_name");
	     			String data6 = rs.getString("product_brand");
	     			String data7 = rs.getString("fullprice");
	     			String data8 = rs.getString("qntysold");
	     			
	        		Object[] row = { data1, data2, data3, data4, data5, data6, data7, data8 };
	        	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	        	    table.getColumnModel().getColumn(6).setPreferredWidth(50);
	        	    table.getColumnModel().getColumn(7).setPreferredWidth(30);
	        	    model.addRow(row);
	           }
	        
	        fromdate.setVisible(false);
	        todate.setVisible(false);
	        lbl1.setVisible(false);
	        lbl2.setVisible(false);
	        btn.setVisible(false);
	        
	        ClearTextField ct = new ClearTextField();
    	    ct.clearTextField(fromdate, todate);
	        
	        conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Insert Valid Date!");
		}
	}
	
	public void searchForPerson(JTextField fname, JTextField lname, JLabel lbl1, JLabel lbl2, JButton btn, JTable table) {
		try {
			SQLConnection sql = new SQLConnection();
			Connection conn = sql.getConnection();
	        String query = "SELECT * FROM sales where firstname = ? and lastname = ?";
	        
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setString(1, fname.getText());
	        ps.setString(2, lname.getText());
	        
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	        	 	String data1 = rs.getString("saledate");
	        	 	String data2 = rs.getString("firstname");
	        	 	String data3 = rs.getString("lastname");
	        	 	String data4 = rs.getString("company");
	     			String data5 = rs.getString("product_name");
	     			String data6 = rs.getString("product_brand");
	     			String data7 = rs.getString("fullprice");
	     			String data8 = rs.getString("qntysold");
	     			
	        		Object[] row = { data1, data2, data3, data4, data5, data6, data7, data8 };
	        	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	        	    table.getColumnModel().getColumn(6).setPreferredWidth(50);
	        	    table.getColumnModel().getColumn(7).setPreferredWidth(30);
	        	    model.addRow(row);
	           }
	        
	        fname.setVisible(false);
	        lname.setVisible(false);
	        lbl1.setVisible(false);
	        lbl2.setVisible(false);
	        btn.setVisible(false);
	        
	        ClearTextField ct = new ClearTextField();
    	    ct.clearTextField(fname, lname);
	        
	        conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Insert Valid Name!");
		}
	}

}
