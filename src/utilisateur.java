import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JTree;
import javax.swing.JCheckBox;
import java.awt.Checkbox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class utilisateur extends JFrame {

	private JPanel contentPane;
	private String sexe;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtMail;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					utilisateur frame = new utilisateur();
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
	public utilisateur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(73, 96, 127, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prenom");
		lblNewLabel_1_1.setBounds(73, 151, 127, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mail");
		lblNewLabel_2.setBounds(381, 106, 75, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(381, 161, 75, 22);
		contentPane.add(lblNewLabel_3);
		
		txtNom = new JTextField();
		txtNom.setBounds(139, 103, 161, 25);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(139, 158, 161, 25);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		txtMail = new JTextField();
		txtMail.setBounds(446, 103, 161, 25);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(446, 158, 161, 25);
		contentPane.add(passwordField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "RH", "Vente"}));
		comboBox.setBounds(446, 220, 161, 21);
		contentPane.add(comboBox);
		
		JRadioButton rdbtnNewRadioButton1 = new JRadioButton("M");
		rdbtnNewRadioButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sexe="M";
				
			}
			
		});
		buttonGroup.add(rdbtnNewRadioButton1);
		rdbtnNewRadioButton1.setToolTipText("");
		rdbtnNewRadioButton1.setBounds(75, 220, 103, 21);
		contentPane.add(rdbtnNewRadioButton1);
		
		JRadioButton rdbtnNewRadioButton2 = new JRadioButton("F");
		rdbtnNewRadioButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sexe="F";
			}
			
		});
		buttonGroup.add(rdbtnNewRadioButton2);
		rdbtnNewRadioButton2.setBounds(73, 267, 103, 21);
		contentPane.add(rdbtnNewRadioButton2);
		
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utilisateur(comboBox);
				txtNom.setText(null);
				txtPrenom.setText(null);
				txtMail.setText(null);
				passwordField.setText(null);
				
				
		
			}
		});
		btnNewButton.setBounds(472, 321, 135, 37);
		contentPane.add(btnNewButton);
	}
	
	static Connection con () {
		try {
			String drive ="com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost/sybercar";
			Class.forName(drive);
			return DriverManager.getConnection(url,"root","");
		}catch(Exception e) {
			System.out.println("error de connection" + e);
		}
		return null;
	}
	
	private void utilisateur(JComboBox comboBox) {
		Connection con = (Connection) con();
		if (comboBox.getSelectedItem() == "Admin") {
		try {
			String query = "INSERT INTO `admin`(`Nom`, `Prenom`, `Sex`, `Mail`, `Password`) VALUES (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, txtNom.getText() );
			ps.setString(2, txtPrenom.getText() );
			ps.setString(3, sexe);
			ps.setString(4, txtMail.getText() );
			ps.setString(5,passwordField.getText());
			ps.execute();
       
		} catch (Exception e) {
			System.out.println("error" + e);
		}
	}
		else if (comboBox.getSelectedItem() == "RH") {
			try {
				String query = "INSERT INTO `rh`(`Nom`, `Prenom`, `Sex`, `Mail`, `Password`) VALUES (?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, txtNom.getText() );
				ps.setString(2, txtPrenom.getText() );
				ps.setString(3, sexe);
				ps.setString(4, txtMail.getText() );
				ps.setString(5,passwordField.getText());
				ps.execute();
	       
			} catch (Exception e) {
				System.out.println("error" + e);
			}
		}
		
		else{
			try {
				String query = "INSERT INTO `vente`(`Nom`, `Prenom`, `Sex`, `Mail`, `Password`) VALUES (?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, txtNom.getText() );
				ps.setString(2, txtPrenom.getText() );
				ps.setString(3, sexe);
				ps.setString(4, txtMail.getText() );
				ps.setString(5,passwordField.getText());
				ps.execute();
	       
			} catch (Exception e) {
				System.out.println("error" + e);
			}
		}
		
	}
}
