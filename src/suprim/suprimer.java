package suprim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class suprimer {
	
	private JPanel contentPane;
	private JTextField txtMarque;
	private JTextField txtModele;
	private JTextField txtCouleur;
	private JTextField txtPrix;
	private JTextField txtQuantite;
	private JTable table;
	private JTextField txtId;


	if (comboBox.getSelectedItem() == "Entrepôts Port Louis") {
		try {
				String query = "DELETE FROM `gestiondestock` WHERE ID =?";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sybercar","root","");
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, txtId.getText() );
			pst.executeUpdate();
			con.close();
			JOptionPane.showMessageDialog(null, "la ligne"+"");
			
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			}
			else if (comboBox.getSelectedItem() == "Entrepôts Baie du Tombeau") {
				try {
					String query = "DELETE FROM `entrepôts_baie_du_tombeau` WHERE ID =?";
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sybercar","root","");
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, txtId.getText() );
				pst.executeUpdate();
				con.close();
				JOptionPane.showMessageDialog(null, "la ligne"+"");
				
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			else if (comboBox.getSelectedItem() == "Entrepôts Phoenix") {
				try {
					String query = "DELETE FROM `entrepôts phoenix` WHERE ID =?";
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sybercar","root","");
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, txtId.getText() );
				pst.executeUpdate();
				con.close();
				JOptionPane.showMessageDialog(null, "la ligne"+"");
				
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			else  {
				try {
					String query = "DELETE FROM `entrepôts plaisance` WHERE ID =?";
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sybercar","root","");
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, txtId.getText() );
				pst.executeUpdate();
				con.close();
				JOptionPane.showMessageDialog(null, "la ligne"+"");
				
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		txtId.setText(null);
}
}
