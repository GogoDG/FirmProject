package tabs;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import methods.*;
import java.awt.event.*;

public class AdminTab extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminTab frame = new AdminTab();
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
	public AdminTab() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminTab.class.getResource("/icons/facade.png")));
		setTitle("Facade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 644, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdminControl = new JButton("Admin Control");
		btnAdminControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "SELECT * FROM admins";
				ControlAdminTab ca = new ControlAdminTab();
				DisplayTable dt = new DisplayTable();
				dt.displayTable(query, ca.table);
				ca.table.getColumnModel().getColumn(0).setPreferredWidth(15);
				ca.setVisible(true);
				dispose();
			}
		});
		btnAdminControl.setForeground(Color.WHITE);
		btnAdminControl.setFont(new Font("Arial", Font.BOLD, 12));
		btnAdminControl.setBackground(new Color(0, 102, 204));
		btnAdminControl.setBounds(100, 28, 197, 57);
		contentPane.add(btnAdminControl);
		
		JButton btnSalesRepControl = new JButton("Sales Rep Control");
		btnSalesRepControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "SELECT * FROM sales_rep";
				ControlRepTab cr = new ControlRepTab();
				DisplayTable dt = new DisplayTable();
				dt.displayTable(query, cr.table);
				cr.table.getColumnModel().getColumn(0).setPreferredWidth(15);
				cr.setVisible(true);
				dispose();
			}
		});
		btnSalesRepControl.setForeground(Color.WHITE);
		btnSalesRepControl.setFont(new Font("Arial", Font.BOLD, 12));
		btnSalesRepControl.setBackground(new Color(0, 102, 204));
		btnSalesRepControl.setBounds(100, 103, 197, 57);
		contentPane.add(btnSalesRepControl);
		
		JButton btnClientControl = new JButton("Client Control");
		btnClientControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "SELECT * FROM clients";
				ControlClientTab cc = new ControlClientTab();
				DisplayTable dt = new DisplayTable();
				dt.displayTable(query, cc.table);
				cc.table.getColumnModel().getColumn(0).setPreferredWidth(15);
				cc.setVisible(true);
				dispose();
			}
		});
		btnClientControl.setForeground(Color.WHITE);
		btnClientControl.setFont(new Font("Arial", Font.BOLD, 12));
		btnClientControl.setBackground(new Color(0, 102, 204));
		btnClientControl.setBounds(317, 103, 197, 57);
		contentPane.add(btnClientControl);
		
		JButton btnSalesControl = new JButton("Stock Control");
		btnSalesControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "SELECT * FROM products";
				ControlStockTab cs = new ControlStockTab();
				DisplayTable dt = new DisplayTable();
				dt.displayTable(query, cs.table);
				cs.table.getColumnModel().getColumn(0).setPreferredWidth(15);
				cs.setVisible(true);
				dispose();
			}
		});
		btnSalesControl.setForeground(Color.WHITE);
		btnSalesControl.setFont(new Font("Arial", Font.BOLD, 12));
		btnSalesControl.setBackground(new Color(0, 102, 204));
		btnSalesControl.setBounds(317, 28, 197, 57);
		contentPane.add(btnSalesControl);
		
		JButton btnLogout = new JButton("");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeTab ht = new HomeTab();
				ht.setVisible(true);
				dispose();
			}
		});
		btnLogout.setIcon(new ImageIcon(AdminTab.class.getResource("/icons/logout.png")));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Arial", Font.BOLD, 12));
		btnLogout.setBackground(new Color(0, 102, 204));
		btnLogout.setBounds(10, 374, 50, 50);
		contentPane.add(btnLogout);
		
		JButton btnSalesTable = new JButton("Sales Catalog");
		btnSalesTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "SELECT * FROM sales";
				SalesTableTab st = new SalesTableTab();
				DisplayTable dt = new DisplayTable();
				dt.displayTable(query, st.table);
				st.table.getColumnModel().getColumn(6).setPreferredWidth(50);
				st.table.getColumnModel().getColumn(7).setPreferredWidth(30);
				st.lblPointer.setText("admin");
				st.btnSrchDate.setVisible(true);
				st.btnSrchPerson.setVisible(true);
				st.setVisible(true);
				dispose();
			}
		});
		btnSalesTable.setForeground(Color.WHITE);
		btnSalesTable.setFont(new Font("Arial", Font.BOLD, 12));
		btnSalesTable.setBackground(new Color(0, 102, 204));
		btnSalesTable.setBounds(100, 171, 414, 57);
		contentPane.add(btnSalesTable);
		
		JLabel lblPic = new JLabel("");
		lblPic.setIcon(new ImageIcon(AdminTab.class.getResource("/icons/stars3.png")));
		lblPic.setBounds(0, 239, 628, 196);
		contentPane.add(lblPic);
	}
}
