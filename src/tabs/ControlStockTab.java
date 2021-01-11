package tabs;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import methods.*;
import java.awt.event.*;

public class ControlStockTab extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textPname;
	private JTextField textPbrand;
	private JTextField textPrice;
	private JTextField textQnty;
	private JLabel lblD;
	private JLabel lblPname;
	private JLabel lblBrand;
	private JLabel lblPrice;
	private JLabel lblQnty;
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
	public ControlStockTab() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ControlStockTab.class.getResource("/icons/facade.png")));
		setTitle("Facade");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 644, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon(ControlStockTab.class.getResource("/icons/plus.png")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "INSERT INTO products values (?, ?, ?, ?, ?)";
					String query2 = "SELECT * FROM products";
					NumericalValidator nv = new NumericalValidator();
					nv.isValidNumber(query, query2, textID, textPname, textPbrand, textPrice, textQnty, lblTXT, table);
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
				"ID", "Product Name", "Product Brand", "Price", "Quantity"
			}
		));
		table.getTableHeader();
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		
		textID = new JTextField();
		textID.setBounds(80, 25, 139, 29);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textPname = new JTextField();
		textPname.setColumns(10);
		textPname.setBounds(80, 65, 139, 29);
		contentPane.add(textPname);
		
		textPbrand = new JTextField();
		textPbrand.setColumns(10);
		textPbrand.setBounds(80, 105, 139, 29);
		contentPane.add(textPbrand);
		
		textPrice = new JTextField();
		textPrice.setToolTipText("<html>" + "Insert prices with 2 decimals after the dot." + "</html>");
		textPrice.setColumns(10);
		textPrice.setBounds(80, 145, 139, 29);
		contentPane.add(textPrice);
		
		textQnty = new JTextField();
		textQnty.setColumns(10);
		textQnty.setBounds(80, 185, 139, 29);
		contentPane.add(textQnty);
		
		lblD = new JLabel("ID:");
		lblD.setFont(new Font("Arial", Font.BOLD, 12));
		lblD.setBounds(58, 31, 24, 14);
		contentPane.add(lblD);
		
		lblPname = new JLabel("Name:");
		lblPname.setFont(new Font("Arial", Font.BOLD, 12));
		lblPname.setBounds(39, 71, 50, 14);
		contentPane.add(lblPname);
		
		lblBrand = new JLabel("Brand:");
		lblBrand.setFont(new Font("Arial", Font.BOLD, 12));
		lblBrand.setBounds(39, 111, 43, 14);
		contentPane.add(lblBrand);
		
		lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Arial", Font.BOLD, 12));
		lblPrice.setBounds(39, 151, 43, 14);
		contentPane.add(lblPrice);
		
		lblQnty = new JLabel("Quantity:");
		lblQnty.setFont(new Font("Arial", Font.BOLD, 12));
		lblQnty.setBounds(22, 191, 60, 14);
		contentPane.add(lblQnty);
		
		btnEdit = new JButton("");
		btnEdit.setIcon(new ImageIcon(ControlStockTab.class.getResource("/icons/edit.png")));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "SELECT * FROM products where id = ?";
					lblTXT.setVisible(false);
					StockContentsEditor es = new StockContentsEditor();
					es.displayStockContents(query, textID, textPname, textPbrand, textPrice, textQnty);
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
		btnDelete.setIcon(new ImageIcon(ControlStockTab.class.getResource("/icons/minus.png")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "DELETE FROM products where id = ?";
					String query2 = "SELECT * FROM products";
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
		lblTXT.setBounds(11, 220, 208, 22);
		contentPane.add(lblTXT);
		lblTXT.setVisible(false);
		
		btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon(ControlStockTab.class.getResource("/icons/refresh.png")));
		btnUpdate.setVisible(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "UPDATE products SET product_name = ?, product_brand = ?, product_price = ?, product_qnty = ? where id = ?";
					String query2 = "SELECT * FROM products";
					StockContentsEditor es = new StockContentsEditor();
					es.editStockEntry(query, query2, textID, textPname, textPbrand, textPrice, textQnty, lblTXT, btnUpdate, table);
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
		btnBack.setIcon(new ImageIcon(ControlStockTab.class.getResource("/icons/back.png")));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Arial", Font.BOLD, 12));
		btnBack.setBackground(new Color(0, 102, 204));
		btnBack.setBounds(10, 374, 50, 50);
		contentPane.add(btnBack);
		
	}
}
