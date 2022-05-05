import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;



// TODO: Auto-generated Javadoc
/**
 * The Class connexion.
 */
public class connexion extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The text field. */
	private JTextField textField;
	
	/** The password field. */
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					connexion frame = new connexion();
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
	public connexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1164, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 557, 507);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Antoine\\Downloads\\aaaaa.png"));
		lblNewLabel_1.setBounds(0, 0, 557, 507);
		panel_1.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "RH", "Vente"}));
		comboBox.setBounds(609, 450, 124, 21);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Connexion");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			
			/**
			 * Action performed.
			 *
			 * @param e the e
			 */
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem() == "Admin") {
					try {
						String query = "SELECT * FROM `admin` WHERE `Mail` =? and `Password` =?";
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sybercar","root","");
						PreparedStatement pst = con.prepareStatement(query);
						pst.setString(1, textField.getText() );
						pst.setString(2, passwordField.getText() );
						ResultSet rs = pst.executeQuery();
						if (rs.next()) {
							Commande com = new Commande();
							com.setVisible(true);
							dispose();
							JOptionPane.showMessageDialog(btnNewButton, " connexion reussi avec succer");
							
						}else {
							JOptionPane.showMessageDialog(btnNewButton, " Identifient ou Mot de passe Invalid");
						}

					} catch (Exception e1) {
						System.out.println("error" + e1);
					}
				}
				else if (comboBox.getSelectedItem() == "RH") {
					try {
						String query = "SELECT * FROM `rh` WHERE `Mail` =? and `Password` =?";
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sybercar","root","");
						PreparedStatement pst = con.prepareStatement(query);
						pst.setString(1, textField.getText() );
						pst.setString(2, passwordField.getText() );
						ResultSet rs = pst.executeQuery();
						
						if (rs.next()) {
							RH com = new RH();
							com.setVisible(true);
							dispose();
							JOptionPane.showMessageDialog(btnNewButton, " connexion reussi avec succer");
							
						}else {
							JOptionPane.showMessageDialog(btnNewButton, " Identifient ou Mot de passe Invalid");
						}

					} catch (Exception e1) {
						System.out.println("error" + e1);
					}
				}
				
				else {
					try {
						String query = "SELECT * FROM `vente` WHERE `Mail` =? and `Password` =?";
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sybercar","root","");
						PreparedStatement pst = con.prepareStatement(query);
						pst.setString(1, textField.getText() );
						pst.setString(2, passwordField.getText() );
						ResultSet rs = pst.executeQuery();
						
						if (rs.next()) {
							Vente com = new Vente();
							com.setVisible(true);
							dispose();
							JOptionPane.showMessageDialog(btnNewButton, " connexion reussi avec succer");
							
						}else {
							JOptionPane.showMessageDialog(btnNewButton, " Identifient ou Mot de passe Invalid");
						}

					} catch (Exception e1) {
						System.out.println("error" + e1);
					}
				}
					}
		});
		btnNewButton.setBounds(796, 426, 200, 61);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Identifient");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(594, 247, 184, 40);
		panel.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot de Passe");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMotDePasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotDePasse.setBounds(609, 323, 171, 40);
		panel.add(lblMotDePasse);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Antoine\\Downloads\\Capture_d_\u00E9cran_2022-04-13_123051-removebg-preview.png"));
		lblNewLabel_3.setBounds(787, 37, 232, 166);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(773, 252, 324, 40);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(773, 323, 324, 40);
		panel.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Ajouter User");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilisateur ut = new utilisateur();
				ut.setVisible(true);
				dispose();
			}
		});
		
		
		btnNewButton_1.setBounds(1022, 466, 108, 21);
		panel.add(btnNewButton_1);
	}
	

	
}
