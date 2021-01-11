package tabs;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import methods.*;
import java.awt.event.*;

public class ResultTableTab extends JFrame {

	private JPanel contentPane;
	public JTable resTable;
	
	/**
	 * Create the frame.
	 */
	public ResultTableTab() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ResultTableTab.class.getResource("/icons/facade.png")));
		setTitle("Facade");	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 250, 686, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 650, 441);
		contentPane.add(scrollPane);
		
		resTable = new JTable();
		resTable.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(resTable);
		resTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Saledate", "First Name", "Last Name", "Company", "Product Name", "Product Brand", "Fullprice", "Quantity"
			}
		));
		resTable.getTableHeader();
	}
}
