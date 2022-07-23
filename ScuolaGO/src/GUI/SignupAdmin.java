package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import Dominio.ScuolaGO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignupAdmin {
    ScuolaGO scuolago = ScuolaGO.getInstance();
    
	private JFrame frame;
	private JTextField txtnome;
	private JTextField txtcognome;
	private JTextField txtemail;
	private JTextField txtpsw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupAdmin window = new SignupAdmin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignupAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 696, 541);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		txtnome = new JTextField();
		txtnome.setBounds(275, 154, 173, 19);
		txtnome.setColumns(10);
		
		txtcognome = new JTextField();
		txtcognome.setColumns(10);
		txtcognome.setBounds(275, 193, 173, 19);
		frame.getContentPane().add(txtcognome);
		
		txtemail = new JTextField();
		txtemail.setBounds(275, 234, 173, 19);
		txtemail.setColumns(10);
		
		txtpsw = new JTextField();
		txtpsw.setBounds(275, 274, 173, 19);
		txtpsw.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Registrazione amministratore");
		lblNewLabel.setBounds(179, 61, 283, 54);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome:");
		lblNewLabel_1_1.setBounds(171, 152, 94, 19);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Cognome:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(171, 193, 94, 19);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email:");
		lblNewLabel_1_1_1.setBounds(171, 232, 84, 19);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Password:");
		lblNewLabel_1_1_1_1.setBounds(171, 272, 84, 19);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("Conferma");
		btnNewButton.setBounds(290, 320, 112, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  String nome = txtnome.getText();
				  String cognome = txtcognome.getText();
				  String email= txtemail.getText();
				  String psw= txtpsw.getText();
				  if(!nome.isEmpty() && !cognome.isEmpty() && !email.isEmpty() && !psw.isEmpty()) {
				   if(scuolago.registraAdmin(nome,cognome,email,psw)) {
			         JOptionPane.showMessageDialog(null, "Registrato correttamente");
				   }
				   else { JOptionPane.showMessageDialog(null, "Email già presente");

				   }}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		frame.getContentPane().add(lblNewLabel_1_1);
		frame.getContentPane().add(txtpsw);
		frame.getContentPane().add(txtemail);
		frame.getContentPane().add(txtnome);
		frame.getContentPane().add(txtcognome);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(lblNewLabel);
		
	
		
	
	}
}
