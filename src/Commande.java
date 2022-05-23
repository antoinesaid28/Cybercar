import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

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
import java.awt.Button;
import javax.swing.JScrollPane;

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
		lblNewLabel.setBounds(53, 112, 142, 34);
		panel.add(lblNewLabel);
		
		JLabel lblModele = new JLabel("Modele");
		lblModele.setBounds(53, 179, 142, 34);
		panel.add(lblModele);
		
		JLabel lblDateDeFabrication = new JLabel("Date de Fabrication");
		lblDateDeFabrication.setBounds(53, 245, 142, 34);
		panel.add(lblDateDeFabrication);
		
		JLabel lblCouleur = new JLabel("Couleur");
		lblCouleur.setBounds(53, 310, 142, 34);
		panel.add(lblCouleur);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setBounds(53, 375, 142, 34);
		panel.add(lblPrix);
		
		JLabel lblQuantite = new JLabel("Quantite");
		lblQuantite.setBounds(53, 434, 142, 34);
		panel.add(lblQuantite);
		
		txtMarque = new JTextField();
		txtMarque.setBounds(178, 113, 201, 34);
		panel.add(txtMarque);
		txtMarque.setColumns(10);
		
		txtModele = new JTextField();
		txtModele.setColumns(10);
		txtModele.setBounds(178, 180, 201, 34);
		panel.add(txtModele);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(178, 246, 201, 34);
		panel.add(txtDate);
		
		txtCouleur = new JTextField();
		txtCouleur.setColumns(10);
		txtCouleur.setBounds(178, 311, 201, 34);
		panel.add(txtCouleur);
		
		txtPrix = new JTextField();
		txtPrix.setColumns(10);
		txtPrix.setBounds(178, 376, 201, 34);
		panel.add(txtPrix);
		
		txtQuantite = new JTextField();
		txtQuantite.setColumns(10);
		txtQuantite.setBounds(178, 435, 201, 34);
		panel.add(txtQuantite);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion de Stock");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(308, 10, 554, 81);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(455, 113, 690, 306);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(636, 434, 153, 34);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Suprimer");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				
			}
		});
		btnNewButton_1_1.setBounds(817, 434, 153, 34);
		panel.add(btnNewButton_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Entrep\u00F4ts Port Louis", "Entrep\u00F4ts Baie du Tombeau", "Entrep\u00F4ts Phoenix", "Entrep\u00F4ts Plaisance"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(956, 69, 175, 34);
		panel.add(comboBox);
		
		JButton btnNewButton_1_3 = new JButton("Mise \u00E0  jour");
		btnNewButton_1_3.setBounds(455, 434, 153, 34);
		panel.add(btnNewButton_1_3);
		
		JButton btnNewButton_2 = new JButton("Afficher");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (comboBox.getSelectedItem() == "Entrepôts Port Louis") {
				try {
					String query = "SELECT * FROM `gestiondestock`";
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sybercar","root","");
				PreparedStatement pst = con.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
				else if (comboBox.getSelectedItem() == "Entrepôts Baie du Tombeau"){
				try {
					String query = "SELECT * FROM `entrepôts_baie_du_tombeau`";
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sybercar","root","");
				PreparedStatement pst = con.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}

				else if (comboBox.getSelectedItem() == "Entrepôts Phoenix"){
				try {
					String query = "SELECT * FROM `entrepôts phoenix`";
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sybercar","root","");
				PreparedStatement pst = con.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
				else  {
					try {
						String query = "SELECT * FROM `entrepôts plaisance`";
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sybercar","root","");
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					}catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton_2.setBounds(980, 434, 151, 34);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("commander");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtMarque.getText().equals("")|| txtModele.getText().equals("")|| txtDate.getText().equals("")|| txtCouleur.getText().equals("")|| txtPrix.getText().equals("")|| txtQuantite.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "les iformation saisi sont pas complet");
				}
				else {
					
			
				commande(comboBox);	
				txtMarque.setText(null);
				txtModele.setText(null);
				txtDate.setText(null);
				txtCouleur.setText(null);
				txtPrix.setText(null);
				txtQuantite.setText(null);
				JOptionPane.showMessageDialog(null, "les iformation saisi sont enregistrer");
				}
				
		}});
		btnNewButton_3.setBounds(982, 510, 163, 40);
		panel.add(btnNewButton_3);
		
	
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
	
	private void commande(JComboBox comboBox) {
		Connection con = (Connection) con();
		if (comboBox.getSelectedItem() == "Entrepôts Port Louis") {
			System.out.println("je suis la p");
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
	
		else if (comboBox.getSelectedItem() == "Entrepôts Baie du Tombeau") {System.out.println("je suis la t");
				
		try {
			String query ="INSERT INTO `entrepôts_baie_du_tombeau`(`Marque`, `Modèle`, `Date_de_Fabrication`, `Couleur`, `Prix`,`Quantité`) VALUES (?,?,?,?,?,?)";
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

		else if (comboBox.getSelectedItem() == "Entrepôts Phoenix") {
			System.out.println("je suis la p");
				
		try {
			String query ="INSERT INTO `entrepôts phoenix`(`Marque`, `Modèle`, `Date_de_Fabrication`, `Couleur`, `Prix`,`Quantité`) VALUES (?,?,?,?,?,?)";
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
		
		else  {
			
			try {
				String query ="INSERT INTO `entrepôts plaisance`(`Marque`, `Modèle`, `Date_de_Fabrication`, `Couleur`, `Prix`,`Quantité`) VALUES (?,?,?,?,?,?)";
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
	
	
	}


