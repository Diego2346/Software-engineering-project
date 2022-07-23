package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dominio.Alunno;
import Dominio.Avviso;
import Dominio.Classe;
import Dominio.Lezione;
import Dominio.Professore;
import Dominio.ScuolaGO;
import Dominio.Voto;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Component;

public class Home_alunno extends JFrame {
	ScuolaGO scuolago = ScuolaGO.getInstance();
	Alunno alunno_login=null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(Alunno alunno_login) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_alunno frame = new Home_alunno(alunno_login);
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
	public Home_alunno(Alunno alunno_login) {
		this.alunno_login = alunno_login;
		Classe miaClasse  = alunno_login.getClasse();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1018, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login.main(null);}
		});
		logout.setForeground(new Color(255, 255, 255));
		logout.setBackground(new Color(255, 102, 102));
		logout.setBounds(891, 49, 98, 31);
		contentPane.add(logout);
		
		JLabel lblNewLabel_1_1 = new JLabel("ScuolaGO");
		lblNewLabel_1_1.setBounds(109, 10, 788, 89);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(102, 153, 204));
		lblNewLabel_1_1.setFont(new Font("Segoe Print", Font.BOLD, 50));
		lblNewLabel_1_1.setBackground(new Color(102, 204, 0));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("Alunno: "+ alunno_login + "    Classe: "+miaClasse);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 89, 547, 59);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("I toui compagni di classe");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(23, 181, 211, 22);
		contentPane.add(lblNewLabel_1);
		JList list = new JList(miaClasse.getAlunniClasse().toArray());
		list.setBounds(34, 213, 175, 409);
		contentPane.add(list);
		
		JLabel lblNewLabel_2 = new JLabel("I tuoi voti");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(753, 186, 96, 13);
		contentPane.add(lblNewLabel_2);
		String columns[]= {"Data", "Materia","Voto"};
		DefaultTableModel model = new DefaultTableModel(columns,0);
		for(Voto v:scuolago.getVotiAlunno(alunno_login)) model.addRow(new Object[]{v.getData(),v.getLezione().getMateria(),v.getValutazione()});
		JTable table = new JTable(model);
		table.setBounds(372, 69, 359, 201);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(630, 207, 359, 182);  
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_4 = new JLabel("Avvisi per la tua classe");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(492, 410, 206, 13);
		contentPane.add(lblNewLabel_4);
		String columns1[]= {"Data", "Classi","Avviso"};
		DefaultTableModel model1 = new DefaultTableModel(columns1,0);
		for(Avviso a:scuolago.getAvvisiClasse(miaClasse)) model1.addRow(new Object[]{a.getData(),a.getClassi(),a.getMsg()});
		JTable table_1 = new JTable(model1);
		table_1.setBounds(372, 69, 359, 201);
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(500);
		scrollPane_1.setBounds(259, 440, 730, 182);  
		contentPane.add(scrollPane_1);
		
		JLabel lblNewLabel_3 = new JLabel("Orario lezioni");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(356, 181, 104, 13);
		String columns2[]= {"Lunedi","Martedi","Mercoledi","Giovedi","Venerdi"};
		DefaultTableModel model_orario = new DefaultTableModel(columns2,5);
		for(Lezione l:scuolago.getLezioniClasse(miaClasse)) 
		 for(String giorno: l.getOrario().keySet()) 
			 for(int ora:l.getOrario().get(giorno))
			  for(int i=0;i<columns2.length;i++) 
				if(columns2[i].equals(giorno))
					model_orario.setValueAt(l.getMateria(),ora-1,i);
		
		contentPane.add(lblNewLabel_3);
		JTable table_2 = new JTable(model_orario);
		table_2.setBackground(new Color(255, 255, 204));
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table_2.setBounds(259, 330, 1, 1);
		contentPane.add(table_2);
		JScrollPane scrollPane_2 = new JScrollPane(table_2);
		scrollPane_2.setBounds(233, 213, 342, 106);
		contentPane.add(scrollPane_2);
		
		JLabel lblNewLabel_5 = new JLabel("La tua media: "+scuolago.getMediaAlunno(alunno_login));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(630, 136, 163, 31);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Calcolata secondo le regole d'istituto");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6.setForeground(Color.GRAY);
		lblNewLabel_6.setBounds(793, 148, 196, 13);
		contentPane.add(lblNewLabel_6);
		

		
		
	}
}
