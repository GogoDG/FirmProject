package methods;

import java.awt.Color;
import java.util.regex.*;
import javax.swing.*;

public class PasswordValidator {
	public void isValidPassword(String query, String query2, JTextField id, JTextField fname, JTextField lname, JTextField username, JTextField password, JLabel lbl, JTable table, String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password.getText());
        if(matcher.matches())
        {
        	InsertStaff ins = new InsertStaff();
        	ins.insertIntoStaff(query, query2, id, fname, lname, username, password, table);
        	lbl.setText("Entry Inserted.");
			lbl.setForeground(Color.GREEN);
			lbl.setVisible(true);
        }
        else
        {
        	JOptionPane.showMessageDialog(null, "Invalid Password.");
        }
    }

}
