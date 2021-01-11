package tabs;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import methods.*;
import java.awt.event.*;

public class RepTab extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RepTab frame = new RepTab();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RepTab() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RepTab.class.getResource("/icons/facade.png")));
		setTitle("Facade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 644, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClientControl = new JButton("Client Control");
		btnClientControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "SELECT * FROM clients";
				ControlClientTab cc = new ControlClientTab();
				DisplayTable dt = new DisplayTable();
				dt.displayTable(query, cc.table);
				cc.table.getColumnModel().getColumn(0).setPreferredWidth(15);
				cc.lblPointer.setText("rep");
				cc.setVisible(true);
				dispose();
			}
		});
		btnClientControl.setForeground(Color.WHITE);
		btnClientControl.setFont(new Font("Arial", Font.BOLD, 12));
		btnClientControl.setBackground(new Color(0, 102, 204));
		btnClientControl.setBounds(110, 110, 197, 57);
		contentPane.add(btnClientControl);
		
		JButton btnTransactions = new JButton("Make Transaction");
		btnTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "SELECT * FROM clients";
				String query2 = "SELECT * FROM products";
				TransactionTab tr = new TransactionTab();
				DisplayTable dt = new DisplayTable();
				dt.displayTable(query, tr.tableClients);
				tr.tableClients.getColumnModel().getColumn(0).setPreferredWidth(15);
				dt.displayTable(query2, tr.tableProducts);
				tr.tableProducts.getColumnModel().getColumn(0).setPreferredWidth(15);
				tr.setVisible(true);
				dispose();
			}
		});
		btnTransactions.setForeground(Color.WHITE);
		btnTransactions.setFont(new Font("Arial", Font.BOLD, 12));
		btnTransactions.setBackground(new Color(0, 102, 204));
		btnTransactions.setBounds(110, 42, 404, 57);
		contentPane.add(btnTransactions);
		
		JButton btnLogout = new JButton("");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeTab ht = new HomeTab();
				ht.setVisible(true);
				dispose();
			}
		});
		btnLogout.setIcon(new ImageIcon(RepTab.class.getResource("/icons/logout.png")));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Arial", Font.BOLD, 12));
		btnLogout.setBackground(new Color(0, 102, 204));
		btnLogout.setBounds(10, 374, 50, 50);
		contentPane.add(btnLogout);
		
		JButton btnSalesCatalog = new JButton("Sales Catalog");
		btnSalesCatalog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnSalesCatalog.setForeground(Color.WHITE);
		btnSalesCatalog.setFont(new Font("Arial", Font.BOLD, 12));
		btnSalesCatalog.setBackground(new Color(0, 102, 204));
		btnSalesCatalog.setBounds(317, 110, 197, 57);
		contentPane.add(btnSalesCatalog);
		
		JLabel lblPic = new JLabel("");
		lblPic.setIcon(new ImageIcon(RepTab.class.getResource("/icons/stars3.png")));
		lblPic.setBounds(0, 204, 628, 231);
		contentPane.add(lblPic);
	}
}