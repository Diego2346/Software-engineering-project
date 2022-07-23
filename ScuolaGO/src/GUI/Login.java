package GUI;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;


import Dominio.Alunno;
import Dominio.Professore;
import Dominio.ScuolaGO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {
	ScuolaGO scuolago = ScuolaGO.getInstance();
	private JFrame frame;
	private JTextField txtEmail1;
	private JTextField txtPassword1;
	private JTextField txtPsw2;
	private JTextField txtEmail2;
	private JTextField textField;
	private JTextField textField_1;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} 			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */ 
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 863, 429);
		frame.setResizable(false);
//////////////////////ADMIN
		JLabel lblNewLabel_1 = new JLabel("Admin");
		lblNewLabel_1.setBounds(97, 21, 85, 53);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		

		JLabel lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setBounds(54, 84, 42, 37);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2_1 = new JLabel("Password:");
		lblNewLabel_2_1.setBounds(53, 174, 73, 37);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		txtEmail1 = new JTextField();
		txtEmail1.setBounds(54, 124, 188, 37);
		txtEmail1.setText("admin@gmail.com");
		txtEmail1.setForeground(Color.GRAY);
		txtEmail1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		txtEmail1.setToolTipText("");
		txtEmail1.setColumns(10);
		
		txtPassword1 = new JTextField();
		txtPassword1.setBounds(54, 209, 188, 37);
		txtPassword1.setText("psw");
		txtPassword1.setToolTipText("");
		txtPassword1.setForeground(Color.GRAY);
		txtPassword1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		txtPassword1.setColumns(10);
		
		JButton btnLogin1 = new JButton("Login");
		btnLogin1.setBounds(64, 256, 159, 37);
		btnLogin1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String email= txtEmail1.getText();
			    String psw= txtPassword1.getText();
			    if(scuolago.loginAdmin(email,psw)!=null) {
			    	Home_admin.main(null);
			    	frame.dispose();}
			    else{
			    	JOptionPane.showMessageDialog(null, "Errore login");
			    }}		
	});
		btnLogin1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JButton btnRegistrati1 = new JButton("Registrati");
		btnRegistrati1.setBounds(64, 303, 159, 37);
		btnRegistrati1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    SignupAdmin.main(null);				
			}
		});
		btnRegistrati1.setFont(new Font("Tahoma", Font.PLAIN, 14));
///////////////////////////////////////////////////////////////		
		JSeparator separator = new JSeparator();
		separator.setBounds(293, 27, 29, 354);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLUE);
		separator.setBackground(Color.BLUE);
///////////////////////////////////////////77/////////PROFESSORE
		JLabel lblNewLabel = new JLabel("Professore");
		lblNewLabel.setBounds(342, 27, 172, 53);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		
		JLabel lblNewLabel_2_2 = new JLabel("ID:");
		lblNewLabel_2_2.setBounds(332, 90, 22, 37);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Password:");
		lblNewLabel_2_1_1.setBounds(338, 180, 73, 37);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtPsw2 = new JTextField();
		txtPsw2.setBounds(332, 215, 188, 37);
		txtPsw2.setToolTipText("");
		txtPsw2.setText("psw");
		txtPsw2.setForeground(Color.GRAY);
		txtPsw2.setFont(new Font("Tahoma", Font.ITALIC, 20));
		txtPsw2.setColumns(10);
		
		txtEmail2 = new JTextField();
		txtEmail2.setBounds(332, 130, 188, 37);
		txtEmail2.setToolTipText("");
		txtEmail2.setText("1");
		txtEmail2.setForeground(Color.GRAY);
		txtEmail2.setFont(new Font("Tahoma", Font.ITALIC, 20));
		txtEmail2.setColumns(10);
		
		JButton btnLogin2 = new JButton("Login");
		btnLogin2.setBounds(342, 262, 159, 37);
		btnLogin2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    int id_p=Integer.parseInt(txtEmail2.getText());
				    String psw_p= txtPsw2.getText();
				    Professore prof_login=scuolago.loginProfessore(id_p,psw_p);
				    if(prof_login!=null) {
				    	Home_professore.main(prof_login);
				    	frame.dispose();}
				    else{
				    	JOptionPane.showMessageDialog(null, "Errore login");
			        }}
			
		});
		btnLogin2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(576, 27, 29, 354);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLUE);
		separator_1.setBackground(Color.BLUE);
		
/////////////////////////////////////////////////////////ALUNNO		

		JLabel lblAlunno = new JLabel("Alunno");
		lblAlunno.setBounds(625, 27, 172, 53);
		lblAlunno.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		textField = new JTextField();
		textField.setBounds(615, 215, 188, 37);
		textField.setToolTipText("");
		textField.setText("psw");
		textField.setForeground(Color.GRAY);
		textField.setFont(new Font("Tahoma", Font.ITALIC, 20));
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Password:");
		lblNewLabel_2_1_1_1.setBounds(621, 180, 73, 37);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_1 = new JTextField();
		textField_1.setBounds(615, 130, 188, 37);
		textField_1.setToolTipText("");
		textField_1.setText("1");
		textField_1.setForeground(Color.GRAY);
		textField_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("ID:");
		lblNewLabel_2_2_1.setBounds(615, 90, 22, 37);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnLogin2_1 = new JButton("Login");
		btnLogin2_1.setBounds(625, 262, 159, 37);
		btnLogin2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id_a=Integer.parseInt(textField_1.getText());
			    String psw_a= textField.getText();
			    Alunno alunno_login=scuolago.loginAlunno(id_a,psw_a);
			    if(alunno_login!=null) {
			    	Home_alunno.main(alunno_login);
			    	frame.dispose();}
			    else{
			    	JOptionPane.showMessageDialog(null, "Errore login");
		        }}			
		});
		btnLogin2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(lblNewLabel_2);
		frame.getContentPane().add(txtEmail1);
		frame.getContentPane().add(txtPassword1);
		frame.getContentPane().add(lblNewLabel_2_1);
		frame.getContentPane().add(btnLogin1);
		frame.getContentPane().add(btnRegistrati1);
		frame.getContentPane().add(separator);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblNewLabel_2_2);
		frame.getContentPane().add(txtEmail2);
		frame.getContentPane().add(lblNewLabel_2_1_1);
		frame.getContentPane().add(txtPsw2);
		frame.getContentPane().add(btnLogin2);
		frame.getContentPane().add(separator_1);
		frame.getContentPane().add(lblAlunno);
		frame.getContentPane().add(lblNewLabel_2_2_1);
		frame.getContentPane().add(textField_1);
		frame.getContentPane().add(lblNewLabel_2_1_1_1);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(btnLogin2_1);
	}
}
