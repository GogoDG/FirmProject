package methods;

import javax.swing.JTextField;

public class ClearTextField {
	public void clearTextField(JTextField id, JTextField fname, JTextField lname, JTextField username, JTextField password) {
		id.setText("");
		fname.setText("");
		lname.setText("");
		username.setText("");
		password.setText("");
	}
	
	public void clearTextField(JTextField id, JTextField fname, JTextField lname, JTextField username) {
		id.setText("");
		fname.setText("");
		lname.setText("");
		username.setText("");
	}
	
	public void clearTextField(JTextField id, JTextField fname) {
		id.setText("");
		fname.setText("");
	}

}
