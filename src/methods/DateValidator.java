package methods;

import java.awt.Color;
import java.text.*;
import javax.swing.*;

public class DateValidator {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
	
    public void validDate(String tableQuery, JTextField saledate, JTextField clientid, JTextField productid, JTextField quantity, JLabel lbl, JTable table) {
    	
		if(isValidDate(saledate.getText()) == true)
        {
			InsertSales ins = new InsertSales();
			ins.insertIntoSales(tableQuery, saledate, clientid, productid, quantity, table);
			lbl.setText("Entry Inserted.");
			lbl.setForeground(Color.GREEN);
			lbl.setVisible(true);
        }
    }

    public static boolean isValidDate(final String date) {
        boolean valid = false;

        try {
            sdf.parse(date);
            sdf.setLenient(false);
            valid = true;

        } catch (ParseException e) {
        	JOptionPane.showMessageDialog(null, "Insert Valid Date!");
            valid = false;
        }

        return valid;
    }	
}
