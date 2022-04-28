import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class connexion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
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
		
		textField = new JTextField();
		textField.setBounds(803, 252, 283, 40);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Connexion");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(828, 426, 200, 61);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Identifient");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(609, 252, 184, 40);
		panel.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot de Passe");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMotDePasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotDePasse.setBounds(609, 323, 171, 40);
		panel.add(lblMotDePasse);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Antoine\\Downloads\\Capture_d_\u00E9cran_2022-04-13_123051-removebg-preview.png"));
		lblNewLabel_3.setBounds(796, 36, 232, 166);
		panel.add(lblNewLabel_3);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(803, 328, 283, 40);
		panel.add(passwordField);
	}

}
