package methods;

import java.awt.Color;
import java.util.regex.*;
import javax.swing.*;

public class NumericalValidator {
	public void isValidNumber(String query, String query2, JTextField id, JTextField pname, JTextField brand, JTextField price, JTextField quantity, JLabel lbl, JTable table) {
		Pattern pattern = Pattern.compile("^\\d+(.\\d{1,2})?$");
		Matcher matcher = pattern.matcher(price.getText());
		if(matcher.matches())
        {
			InsertProducts ins = new InsertProducts();
			ins.insertIntoProducts(query, query2, id, pname, brand, price, quantity, table);
			lbl.setText("Entry Inserted.");
			lbl.setForeground(Color.GREEN);
			lbl.setVisible(true);
        }
        else
        {
        	JOptionPane.showMessageDialog(null, "Invalid Input.");
        }
	}

}
