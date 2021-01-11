package tabs;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class HomeTab extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeTab frame = new HomeTab();
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
	public HomeTab() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomeTab.class.getResource("/icons/facade.png")));
		setTitle("Facade");
		setBackground(new Color(0, 102, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 644, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogU = new JButton("Sales Rep Login");
		btnLogU.setForeground(Color.WHITE);
		btnLogU.setFont(new Font("Arial", Font.BOLD, 14));
		btnLogU.setBackground(new Color(0, 102, 204));
		btnLogU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PassTab pt = new PassTab();
				pt.btnLogin.setText("Log in as Rep");
				pt.setVisible(true);
				dispose();
			}
		});
		btnLogU.setBounds(370, 137, 197, 57);
		contentPane.add(btnLogU);
		
		JLabel lblTitle = new JLabel("Welcome to Facade");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
		lblTitle.setBounds(370, 43, 197, 22);
		contentPane.add(lblTitle);
		
		JButton btnLogAd = new JButton("Admin Login");
		btnLogAd.setForeground(Color.WHITE);
		btnLogAd.setFont(new Font("Arial", Font.BOLD, 14));
		btnLogAd.setBackground(new Color(0, 102, 204));
		btnLogAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PassTab t1 = new PassTab();
				t1.btnLogin.setText("Log in as Admin");
				t1.setVisible(true);
				dispose();
			}
		});
		btnLogAd.setBounds(370, 225, 197, 57);
		contentPane.add(btnLogAd);
		
		JLabel lblPic = new JLabel("");
		lblPic.setIcon(new ImageIcon(HomeTab.class.getResource("/icons/cute.png")));
		lblPic.setBounds(0, 0, 300, 435);
		contentPane.add(lblPic);
	}
}
