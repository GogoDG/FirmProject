package tabs;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import methods.*;
import java.awt.event.*;

public class SalesTableTab extends JFrame {

	private JPanel contentPane;
	public JButton btnSrchPerson;
	public JButton btnSrchDate;
	public JTable table;
	private JLabel lblTXT;
	private JButton btnBack;
	public JLabel lblPointer;
	private JTextField textSrch1;
	private JLabel lblSrch2;
	private JLabel lblSrch1;
	private JTextField textSrch2;
	private JButton btnSrch;

	/**
	 * Create the frame.
	 */
	public SalesTableTab() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SalesTableTab.class.getResource("/icons/facade.png")));
		setTitle("Facade");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 772, 568);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSrchPerson = new JButton("");
		btnSrchPerson.setIcon(new ImageIcon(SalesTableTab.class.getResource("/icons/search_person.png")));
		btnSrchPerson.setVisible(false);
		btnSrchPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblSrch1.setText("First Name:");
				lblSrch2.setText("Last Name:");
				lblSrch1.setVisible(true);
				lblSrch2.setVisible(true);
				textSrch1.setVisible(true);
				textSrch2.setVisible(true);
				btnSrch.setVisible(true);
			}
		});
		btnSrchPerson.setForeground(Color.WHITE);
		btnSrchPerson.setFont(new Font("Arial", Font.BOLD, 12));
		btnSrchPerson.setBackground(new Color(0, 102, 204));
		btnSrchPerson.setBounds(14, 215, 60, 60);
		contentPane.add(btnSrchPerson);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(121, 11, 625, 507);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Saledate", "First Name", "Last Name", "Company", "Product Name", "Product Brand", "Fullprice", "Quantity"
			}
		));
		table.getTableHeader();
		
		btnSrchDate = new JButton("");
		btnSrchDate.setIcon(new ImageIcon(SalesTableTab.class.getResource("/icons/search_date.png")));
		btnSrchDate.setVisible(false);
		btnSrchDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					lblSrch1.setText("From:");
					lblSrch2.setText("Till:");
					lblSrch1.setVisible(true);
					lblSrch2.setVisible(true);
					textSrch1.setVisible(true);
					textSrch2.setVisible(true);
					btnSrch.setVisible(true);
			}
		});
		btnSrchDate.setForeground(Color.WHITE);
		btnSrchDate.setFont(new Font("Arial", Font.BOLD, 12));
		btnSrchDate.setBackground(new Color(0, 102, 204));
		btnSrchDate.setBounds(14, 286, 60, 60);
		contentPane.add(btnSrchDate);
		
		lblTXT = new JLabel("New label");
		lblTXT.setForeground(Color.RED);
		lblTXT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTXT.setFont(new Font("Arial", Font.BOLD, 14));
		lblTXT.setBounds(0, 357, 96, 22);
		contentPane.add(lblTXT);
		lblTXT.setVisible(false);
		
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
		btnBack.setIcon(new ImageIcon(SalesTableTab.class.getResource("/icons/back.png")));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Arial", Font.BOLD, 12));
		btnBack.setBackground(new Color(0, 102, 204));
		btnBack.setBounds(10, 468, 50, 50);
		contentPane.add(btnBack);
		
		lblPointer = new JLabel("admin");
		lblPointer.setBounds(14, 443, 46, 14);
		contentPane.add(lblPointer);
		lblPointer.setVisible(false);
		
		textSrch1 = new JTextField();
		textSrch1.setColumns(10);
		textSrch1.setBounds(10, 41, 101, 29);
		contentPane.add(textSrch1);
		textSrch1.setVisible(false);
		
		lblSrch1 = new JLabel("From:");
		lblSrch1.setFont(new Font("Arial", Font.BOLD, 12));
		lblSrch1.setBounds(10, 25, 64, 14);
		contentPane.add(lblSrch1);
		lblSrch1.setVisible(false);
		
		lblSrch2 = new JLabel("Till:");
		lblSrch2.setFont(new Font("Arial", Font.BOLD, 12));
		lblSrch2.setBounds(10, 79, 64, 14);
		contentPane.add(lblSrch2);
		lblSrch2.setVisible(false);
		
		textSrch2 = new JTextField();
		textSrch2.setColumns(10);
		textSrch2.setBounds(10, 95, 101, 29);
		contentPane.add(textSrch2);
		textSrch2.setVisible(false);
		
		btnSrch = new JButton("");
		btnSrch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultTableTab rt = new ResultTableTab();
				Search sr = new Search();
				if(textSrch1.getText().matches("\\d{4}-\\d{2}-\\d{2}") && textSrch2.getText().matches("\\d{4}-\\d{2}-\\d{2}") && lblSrch1.getText().equals("From:"))
				{
					sr.searchForDate(textSrch1, textSrch2, lblSrch1, lblSrch2, btnSrch, rt.resTable);
					rt.setVisible(true);
				}
				else if(textSrch1.getText().equals("") && textSrch1.getText().equals("")) {
					DisplayTable dt = new DisplayTable();
					dt.displayTable("SELECT * FROM sales", table);
					table.getColumnModel().getColumn(6).setPreferredWidth(50);
					table.getColumnModel().getColumn(7).setPreferredWidth(30);
				}
				else if(lblSrch1.getText().equals("First Name:")){
					sr.searchForPerson(textSrch1, textSrch2, lblSrch1, lblSrch2, btnSrch, rt.resTable);
					rt.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Insert Valid Name or Date!");
				}
			}
		});
		btnSrch.setIcon(new ImageIcon(SalesTableTab.class.getResource("/icons/search.png")));
		btnSrch.setForeground(Color.WHITE);
		btnSrch.setFont(new Font("Arial", Font.BOLD, 12));
		btnSrch.setBackground(new Color(0, 102, 204));
		btnSrch.setBounds(34, 135, 50, 50);
		contentPane.add(btnSrch);
		btnSrch.setVisible(false);
	}
}
