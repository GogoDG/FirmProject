package tabs;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import methods.*;
import java.awt.event.*;

public class PassTab extends JFrame {

	private JPanel contentPane;
	public JTextField textName;
	public JTextField textPass;
	public JLabel lblLoginType;
	public JLabel lblTXT;
	public JButton btnLogin;

	/**
	 * Create the frame.
	 */
	public PassTab() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PassTab.class.getResource("/icons/facade.png")));
		setTitle("Facade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 644, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Username");
		lblName.setFont(new Font("Arial", Font.BOLD, 12));
		lblName.setBounds(338, 119, 79, 14);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 12));
		lblPassword.setBounds(338, 168, 79, 14);
		contentPane.add(lblPassword);
		
		textName = new JTextField();
		textName.setFont(new Font("Arial", Font.PLAIN, 12));
		textName.setBounds(338, 134, 257, 30);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textPass = new JPasswordField();
		textPass.setFont(new Font("Arial", Font.BOLD, 12));
		textPass.setColumns(10);
		textPass.setBounds(338, 183, 257, 30);
		contentPane.add(textPass);
		
		btnLogin = new JButton("Login");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
		btnLogin.setBackground(new Color(0, 102, 204));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "SELECT * FROM admins where username=? and password =?";
				String query2 = "SELECT * FROM sales_rep where username=? and password =?";
				String username = textName.getText();
				String password = textPass.getText();
				Login log = new Login();
				
				if(btnLogin.getText() == "Log in as Admin")
				{
					if(log.logIntoProgram(query, username, password)) {
						AdminTab a1 = new AdminTab();
						a1.setVisible(true);
						dispose();
					}
					else {
						lblTXT.setText("Invalid username or password.");
						lblTXT.setVisible(true);
						}
				}
				else
				{
					if(log.logIntoProgram(query2, username, password)) {
						RepTab a1 = new RepTab();
						a1.setVisible(true);
						dispose();
					}
					else {
						lblTXT.setText("Invalid username or password.");
						lblTXT.setVisible(true);
						}
				}
				
			}
		});
		btnLogin.setBounds(338, 231, 257, 57);
		contentPane.add(btnLogin);
		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(PassTab.class.getResource("/icons/back.png")));
		btnBack.setBackground(new Color(0, 102, 204));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Arial", Font.BOLD, 12));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeTab t1 = new HomeTab();
				t1.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(10, 374, 50, 50);
		contentPane.add(btnBack);
		
		lblLoginType = new JLabel("Welcome Back");
		lblLoginType.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoginType.setFont(new Font("Arial", Font.BOLD, 18));
		lblLoginType.setBounds(338, 33, 257, 27);
		contentPane.add(lblLoginType);
		
		lblTXT = new JLabel("New label");
		lblTXT.setForeground(Color.RED);
		lblTXT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTXT.setFont(new Font("Arial", Font.BOLD, 14));
		lblTXT.setBounds(338, 299, 257, 30);
		contentPane.add(lblTXT);
		
		JLabel lblSignInTo = new JLabel("Sign in to continue");
		lblSignInTo.setForeground(new Color(192, 192, 192));
		lblSignInTo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSignInTo.setFont(new Font("Arial", Font.BOLD, 14));
		lblSignInTo.setBounds(338, 61, 257, 17);
		contentPane.add(lblSignInTo);
		
		JLabel lblPic = new JLabel("");
		lblPic.setIcon(new ImageIcon(PassTab.class.getResource("/icons/stars2.png")));
		lblPic.setBounds(0, 0, 300, 435);
		contentPane.add(lblPic);
		lblTXT.setVisible(false);
	}
}
