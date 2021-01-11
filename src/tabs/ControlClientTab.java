package tabs;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import methods.*;
import java.awt.event.*;

public class ControlClientTab extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textFname;
	private JTextField textLname;
	private JTextField textCompany;
	private JLabel lblID;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblCompany;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnUpdate;
	public JTable table;
	private JLabel lblTXT;
	public JLabel lblPointer;
	private JButton btnBack;

	/**
	 * Create the frame.
	 */
	public ControlClientTab() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ControlClientTab.class.getResource("/icons/facade.png")));
		setTitle("Facade");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 644, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon(ControlClientTab.class.getResource("/icons/plus.png")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "INSERT INTO clients values (?, ?, ?, ?)";
					String query2 = "SELECT * FROM clients";
					InsertClients ins = new InsertClients();
					ins.insertIntoClients(query, query2, textID, textFname, textLname, textCompany, lblTXT, table);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "No ID detected!");
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
				"ID", "First Name", "Last Name", "Company"
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
		
		textCompany = new JTextField();
		textCompany.setColumns(10);
		textCompany.setBounds(80, 145, 139, 29);
		contentPane.add(textCompany);
		
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
		
		lblCompany = new JLabel("Company:");
		lblCompany.setFont(new Font("Arial", Font.BOLD, 12));
		lblCompany.setBounds(19, 151, 70, 14);
		contentPane.add(lblCompany);
		
		btnEdit = new JButton("");
		btnEdit.setIcon(new ImageIcon(ControlClientTab.class.getResource("/icons/edit.png")));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "SELECT * FROM clients where id = ?";
					lblTXT.setVisible(false);
					ClientContentsEditor ec = new ClientContentsEditor();
					ec.displayClientContents(query, textID, textFname, textLname, textCompany, lblTXT);
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
		btnDelete.setIcon(new ImageIcon(ControlClientTab.class.getResource("/icons/minus.png")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "DELETE FROM clients where id = ?";
					String query2 = "SELECT * FROM clients";
					DeleteTableContents dt = new DeleteTableContents();
					dt.deleteTableEntry(query, query2, textID, lblTXT, table);
				} catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Insert Valid ID!");
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
		btnUpdate.setIcon(new ImageIcon(ControlClientTab.class.getResource("/icons/refresh.png")));
		btnUpdate.setVisible(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "UPDATE clients SET firstname = ?, lastname = ?, company = ? where id = ?";
					String query2 = "SELECT * FROM clients";
					ClientContentsEditor ec = new ClientContentsEditor();
					ec.editClientEntry(query, query2, textID, textFname, textLname, textCompany, lblTXT, btnUpdate, table);
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
				if(lblPointer.getText() == "admin") {
					AdminTab at = new AdminTab();
					at.setVisible(true);
					dispose();
				}
				else {
					RepTab rt = new RepTab();
					rt.setVisible(true);
					dispose();
				}
				
			}
		});
		btnBack.setIcon(new ImageIcon(ControlClientTab.class.getResource("/icons/back.png")));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Arial", Font.BOLD, 12));
		btnBack.setBackground(new Color(0, 102, 204));
		btnBack.setBounds(10, 374, 50, 50);
		contentPane.add(btnBack);
		
		lblPointer = new JLabel("admin");
		lblPointer.setBounds(80, 410, 46, 14);
		contentPane.add(lblPointer);
		lblPointer.setVisible(false);
		
	}
}
