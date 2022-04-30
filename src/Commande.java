import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Commande extends JFrame {

	private JPanel contentPane;
	private JTextField txtMarque;
	private JTextField txtModele;
	private JTextField txtDate;
	private JTextField txtCouleur;
	private JTextField txtPrix;
	private JTextField txtQuantite;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Commande frame = new Commande();
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
	public Commande() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1182, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1168, 590);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Marque");
		lblNewLabel.setBounds(53, 135, 142, 34);
		panel.add(lblNewLabel);
		
		JLabel lblModele = new JLabel("Modele");
		lblModele.setBounds(53, 199, 142, 34);
		panel.add(lblModele);
		
		JLabel lblDateDeFabrication = new JLabel("Date de Fabrication");
		lblDateDeFabrication.setBounds(53, 269, 142, 34);
		panel.add(lblDateDeFabrication);
		
		JLabel lblCouleur = new JLabel("Couleur");
		lblCouleur.setBounds(53, 345, 142, 34);
		panel.add(lblCouleur);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setBounds(53, 434, 142, 34);
		panel.add(lblPrix);
		
		JLabel lblQuantite = new JLabel("Quantite");
		lblQuantite.setBounds(53, 507, 142, 34);
		panel.add(lblQuantite);
		
		txtMarque = new JTextField();
		txtMarque.setBounds(178, 136, 201, 34);
		panel.add(txtMarque);
		txtMarque.setColumns(10);
		
		txtModele = new JTextField();
		txtModele.setColumns(10);
		txtModele.setBounds(178, 200, 201, 34);
		panel.add(txtModele);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(178, 270, 201, 34);
		panel.add(txtDate);
		
		txtCouleur = new JTextField();
		txtCouleur.setColumns(10);
		txtCouleur.setBounds(178, 346, 201, 34);
		panel.add(txtCouleur);
		
		txtPrix = new JTextField();
		txtPrix.setColumns(10);
		txtPrix.setBounds(178, 435, 201, 34);
		panel.add(txtPrix);
		
		txtQuantite = new JTextField();
		txtQuantite.setColumns(10);
		txtQuantite.setBounds(178, 508, 201, 34);
		panel.add(txtQuantite);
		
		JButton btnNewButton = new JButton("Commander");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0 ) {
				commande();
			}
		});
		btnNewButton.setBounds(972, 539, 159, 41);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion de Stock");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(308, 10, 554, 81);
		panel.add(lblNewLabel_1);
		
		table = new JTable();
		table.setBounds(455, 113, 690, 306);
		panel.add(table);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(636, 434, 153, 34);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Suprimer");
		btnNewButton_1_1.setBounds(817, 434, 153, 34);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Mettre a Jour");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_2.setBounds(992, 434, 153, 34);
		panel.add(btnNewButton_1_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Entrep\u00F4ts Port Louis", "Entrep\u00F4ts Baie du Tombeau", "Entrep\u00F4ts Phoenix", "Entrep\u00F4ts Plaisance"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(956, 69, 175, 34);
		panel.add(comboBox);
		
	
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
	
	private void commande() {
		Connection con = (Connection) con();
		try {
			String query = "INSERT INTO `gestiondestock`(`Marque`, `Modèle`, `Date_de_Fabrication`, `Couleur`, `Prix`,`Quantité`) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, txtMarque.getText() );
			ps.setString(2, txtModele.getText() );
			ps.setString(3, txtDate.getText() );
			ps.setString(4, txtCouleur.getText() );
			ps.setString(5, txtPrix.getText() );
			ps.setString(6, txtQuantite.getText() );
			ps.execute();

		} catch (Exception e) {
			System.out.println("error" + e);
		}
	}
}

