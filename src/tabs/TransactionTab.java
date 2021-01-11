package tabs;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import methods.*;
import java.awt.event.*;

public class TransactionTab extends JFrame {

	private JPanel contentPane;
	private JTextField textClientID;
	private JTextField textProductID;
	private JTextField textQuantity;
	private JLabel lblClientID;
	private JLabel lblProductID;
	private JLabel lblLastName;
	private JButton btnSell;
	public JTable tableClients;
	private JLabel lblTXT;
	private JButton btnBack;
	public JTable tableProducts;
	private JScrollPane scrollPane2;
	private JTextField textDate;

	/**
	 * Create the frame.
	 */
	public TransactionTab() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TransactionTab.class.getResource("/icons/facade.png")));
		setTitle("Facade");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 644, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSell = new JButton("");
		btnSell.setIcon(new ImageIcon(TransactionTab.class.getResource("/icons/sell.png")));
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String tableQuery = "SELECT * FROM products";
					DateValidator dv = new DateValidator();
					dv.validDate(tableQuery, textDate, textClientID, textProductID, textQuantity, lblTXT, tableProducts);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Insert Valid ID!");
				}
			}
		});
		btnSell.setForeground(Color.WHITE);
		btnSell.setFont(new Font("Arial", Font.BOLD, 12));
		btnSell.setBackground(new Color(0, 102, 204));
		btnSell.setBounds(48, 253, 60, 60);
		contentPane.add(btnSell);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(229, 11, 389, 198);
		contentPane.add(scrollPane);
		
		tableClients = new JTable();
		tableClients.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(tableClients);
		tableClients.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "First Name", "Last Name", "Company"
			}
		));
		tableClients.getTableHeader();
		tableClients.getColumnModel().getColumn(0).setPreferredWidth(30);
		
		textClientID = new JTextField();
		textClientID.setBounds(80, 35, 139, 29);
		contentPane.add(textClientID);
		textClientID.setColumns(10);
		
		textProductID = new JTextField();
		textProductID.setColumns(10);
		textProductID.setBounds(80, 75, 139, 29);
		contentPane.add(textProductID);
		
		textQuantity = new JTextField();
		textQuantity.setColumns(10);
		textQuantity.setBounds(80, 115, 139, 29);
		contentPane.add(textQuantity);
		
		lblClientID = new JLabel("Client ID:");
		lblClientID.setFont(new Font("Arial", Font.BOLD, 12));
		lblClientID.setBounds(22, 41, 60, 14);
		contentPane.add(lblClientID);
		
		lblProductID = new JLabel("Product ID:");
		lblProductID.setFont(new Font("Arial", Font.BOLD, 12));
		lblProductID.setBounds(10, 81, 72, 14);
		contentPane.add(lblProductID);
		
		lblLastName = new JLabel("Quantity:");
		lblLastName.setFont(new Font("Arial", Font.BOLD, 12));
		lblLastName.setBounds(22, 121, 60, 14);
		contentPane.add(lblLastName);
		
		lblTXT = new JLabel("New label");
		lblTXT.setForeground(Color.RED);
		lblTXT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTXT.setFont(new Font("Arial", Font.BOLD, 14));
		lblTXT.setBounds(0, 220, 232, 22);
		contentPane.add(lblTXT);
		lblTXT.setVisible(false);
		
		btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RepTab rt = new RepTab();
				rt.setVisible(true);
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon(TransactionTab.class.getResource("/icons/back.png")));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Arial", Font.BOLD, 12));
		btnBack.setBackground(new Color(0, 102, 204));
		btnBack.setBounds(10, 374, 50, 50);
		contentPane.add(btnBack);
		
		scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(229, 220, 389, 204);
		contentPane.add(scrollPane2);
		
		tableProducts = new JTable();
		scrollPane2.setViewportView(tableProducts);
		tableProducts.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "product_name", "product_brand", "product_price", "product_qnty"
			}
		));
		tableProducts.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableProducts.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblDateOfDeal = new JLabel("Date:");
		lblDateOfDeal.setFont(new Font("Arial", Font.BOLD, 12));
		lblDateOfDeal.setBounds(40, 161, 42, 14);
		contentPane.add(lblDateOfDeal);
		
		textDate = new JTextField();
		textDate.setColumns(10);
		textDate.setBounds(80, 155, 139, 29);
		contentPane.add(textDate);
		
		JButton btnTable = new JButton("");
		btnTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "SELECT * FROM sales";
				SalesTableTab st = new SalesTableTab();
				DisplayTable dt = new DisplayTable();
				dt.displayTable(query, st.table);
				st.table.getColumnModel().getColumn(6).setPreferredWidth(50);
				st.table.getColumnModel().getColumn(7).setPreferredWidth(30);
				st.lblPointer.setText("rep");
				st.setVisible(true);
				dispose();
			}
		});
		btnTable.setIcon(new ImageIcon(TransactionTab.class.getResource("/icons/table.png")));
		btnTable.setForeground(Color.WHITE);
		btnTable.setFont(new Font("Arial", Font.BOLD, 12));
		btnTable.setBackground(new Color(0, 102, 204));
		btnTable.setBounds(123, 253, 60, 60);
		contentPane.add(btnTable);
		
	}
}
