package tabs;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import methods.*;
import java.awt.event.*;

public class ControlAdminTab extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textFname;
	private JTextField textLname;
	private JTextField textUname;
	private JTextField textPass;
	private JLabel lblID;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnUpdate;
	public JTable table;
	private JLabel lblTXT;
	private JButton btnBack;

	/**
	 * Create the frame.
	 */
	public ControlAdminTab() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ControlAdminTab.class.getResource("/icons/facade.png")));
		setTitle("Facade");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 644, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon(ControlAdminTab.class.getResource("/icons/plus.png")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "SELECT * FROM admins WHERE username = ?";
					String query2 = "INSERT INTO admins values (?, ?, ?, ?, ?)";
					String query3 = "SELECT * FROM admins";
					String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[-_.,;:!?@#$%^&+=*<>(){}])(?=\\S+$).{8,}$";
					DuplicateUsernameScanner du = new DuplicateUsernameScanner();
					du.isDuplicateUsername(query, query2, query3, textID, textFname, textLname, textUname, textPass, lblTXT, table, pattern);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Insert Valid ID!");
				}
			}
		});
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Arial", Font.BOLD, 12));
		btnAdd.setBackground(new Color(0, 102, 204));
		btnAdd.setBounds(10, 253, 60, 60);
		contentPane.add(btnAdd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(229, 11, 389, 413);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "First Name", "Last Name", "Username", "Password"
			}
		));
		table.getTableHeader();
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		
		textID = new JTextField();
		textID.setBounds(80, 25, 139, 29);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textFname = new JTextField();
		textFname.setColumns(10);
		textFname.setBounds(80, 65, 139, 29);
		contentPane.add(textFname);
		
		textLname = new JTextField();
		textLname.setColumns(10);
		textLname.setBounds(80, 105, 139, 29);
		contentPane.add(textLname);
		
		textUname = new JTextField();
		textUname.setColumns(10);
		textUname.setBounds(80, 145, 139, 29);
		contentPane.add(textUname);
		
		textPass = new JTextField();
		textPass.setToolTipText("<html>" + "The password policy is:" + "<br>" + "- At least 8 characters"+ "<br>" + "- Contains at least one digit" + "<br>" +
		"- Contains at least one lower and one upper character" + "<br>" + "- Contains at least one char within a set of special chars (@#%$^)" + "<br>" +
		"- Does not contain space, tab, etc." + "</html>");
		textPass.setColumns(10);
		textPass.setBounds(80, 185, 139, 29);
		contentPane.add(textPass);
		
		lblID = new JLabel("ID:");
		lblID.setFont(new Font("Arial", Font.BOLD, 12));
		lblID.setBounds(58, 31, 24, 14);
		contentPane.add(lblID);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Arial", Font.BOLD, 12));
		lblFirstName.setBounds(10, 71, 79, 14);
		contentPane.add(lblFirstName);
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Arial", Font.BOLD, 12));
		lblLastName.setBounds(10, 111, 79, 14);
		contentPane.add(lblLastName);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 12));
		lblUsername.setBounds(10, 151, 79, 14);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 12));
		lblPassword.setBounds(10, 191, 79, 14);
		contentPane.add(lblPassword);
		
		btnEdit = new JButton("");
		btnEdit.setIcon(new ImageIcon(ControlAdminTab.class.getResource("/icons/edit.png")));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "SELECT * FROM admins where id = ?";
					lblTXT.setVisible(false);
					StaffContentsEditor sc = new StaffContentsEditor();
					sc.displayStaffContents(query, textID, textFname, textLname, textUname, textPass);
					btnUpdate.setVisible(true);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Insert Valid ID!");
				}	
			}
		});
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Arial", Font.BOLD, 12));
		btnEdit.setBackground(new Color(0, 102, 204));
		btnEdit.setBounds(85, 253, 60, 60);
		contentPane.add(btnEdit);
		
		btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon(ControlAdminTab.class.getResource("/icons/minus.png")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "DELETE FROM admins where id = ?";
					String query2 = "SELECT * FROM admins";
					DeleteTableContents dt = new DeleteTableContents();
					dt.deleteTableEntry(query, query2, textID, lblTXT, table);
				} catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "No ID detected!");
				}
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Arial", Font.BOLD, 12));
		btnDelete.setBackground(new Color(0, 102, 204));
		btnDelete.setBounds(159, 253, 60, 60);
		contentPane.add(btnDelete);
		
		lblTXT = new JLabel("New label");
		lblTXT.setForeground(Color.RED);
		lblTXT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTXT.setFont(new Font("Arial", Font.BOLD, 14));
		lblTXT.setBounds(0, 220, 232, 22);
		contentPane.add(lblTXT);
		lblTXT.setVisible(false);
		
		btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon(ControlAdminTab.class.getResource("/icons/refresh.png")));
		btnUpdate.setVisible(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "UPDATE admins SET firstname = ?, lastname = ?, username = ?, password = ? where id = ?";
					String query2 = "SELECT * FROM admins";
					StaffContentsEditor sc = new StaffContentsEditor();
					sc.editStaffEntry(query, query2, textID, textFname, textLname, textUname, textPass, lblTXT, btnUpdate, table);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Insert Valid ID!");
				}
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 12));
		btnUpdate.setBackground(new Color(0, 102, 204));
		btnUpdate.setBounds(85, 322, 60, 60);
		contentPane.add(btnUpdate);
		
		btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminTab at = new AdminTab();
				at.setVisible(true);
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon(ControlAdminTab.class.getResource("/icons/back.png")));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Arial", Font.BOLD, 12));
		btnBack.setBackground(new Color(0, 102, 204));
		btnBack.setBounds(10, 374, 50, 50);
		contentPane.add(btnBack);
		
	}
}
