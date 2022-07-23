package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dominio.Alunno;
import Dominio.Avviso;
import Dominio.Classe;
import Dominio.Lezione;
import Dominio.Professore;
import Dominio.PropertyListener;
import Dominio.ScuolaGO;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextArea;

public class Home_admin extends JFrame implements PropertyListener {
    ScuolaGO scuolago = ScuolaGO.getInstance();
	private JPanel contentPane;
	private JTable table,table_1,table_2,table_3,table_4;
	private JComboBox comboBox,comboBox_1,comboBox_2;
	private JList list_classi;
	private JLabel lblTot;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_admin frame = new Home_admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}}});
	}

	/**
	 * Create the frame.
	 */
	public Home_admin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 497);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
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
		logout.setBounds(680, 0, 98, 31);
		contentPane.add(logout);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(SystemColor.text);
		tabbedPane.setBackground(new Color(102, 153, 204));
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.setBounds(10, 10, 768, 440);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Home", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Professori", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Classi", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Alunni", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Lezioni", null, panel_4, null);
		panel_4.setLayout(null);
		
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Avvisi", null, panel_5, null);
		panel_5.setLayout(null);
		
		
//HOME***************************************************************
		JLabel lblNewLabel_1_1 = new JLabel("ScuolaGO");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(102, 153, 204));
		lblNewLabel_1_1.setFont(new Font("Segoe Print", Font.BOLD, 50));
		lblNewLabel_1_1.setBackground(new Color(102, 204, 0));
		lblNewLabel_1_1.setBounds(227, 146, 272, 112);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Amministratore");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(247, 82, 201, 35);
		panel.add(lblNewLabel_2);
		
		
//PROFESSORI*****************************************************************************
		JLabel lblNewLabel_3 = new JLabel("Gestione professore");
		lblNewLabel_3.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(30, 37, 191, 27);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(30, 106, 56, 19);
		panel_1.add(lblNewLabel);
		
		JLabel lblCognome = new JLabel("Cognome:");
		lblCognome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCognome.setBounds(30, 150, 79, 19);
		panel_1.add(lblCognome);
		
		JLabel lblPassword = new JLabel("Data di nascita:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(30, 192, 105, 19);
		panel_1.add(lblPassword);
		JLabel lblNewLabel_5 = new JLabel("gg-mm-aaaa");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setForeground(Color.GRAY);
		lblNewLabel_5.setBounds(40, 210, 68, 19);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword_1.setBounds(30, 240, 79, 19);
		panel_1.add(lblPassword_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(145, 108, 143, 19);
		panel_1.add(textField);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(145, 152, 143, 19);
		panel_1.add(textField_1);
		
		JTextField txtpnG = new JTextField();
		txtpnG.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnG.setForeground(Color.BLACK);
		txtpnG.setToolTipText("");
		txtpnG.setBounds(145, 192, 143, 19);
		panel_1.add(txtpnG);
		
		JTextField textField_3 = new JTextField();
		textField_3.setBounds(145, 242, 143, 19);
		panel_1.add(textField_3);
		JButton btnNewButton = new JButton("Aggiungi professore");
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome_p=textField.getText();
				String cognome_p=textField_1.getText();
				String nascita_p=txtpnG.getText();
				String psw_p=textField_3.getText();
				if(!nome_p.isEmpty() && !cognome_p.isEmpty() && !nascita_p.isEmpty() && !psw_p.isEmpty()) {
				     scuolago.nuovoProfessore(nome_p, cognome_p, nascita_p, psw_p);
				     scuolago.aggiungiProfessoreAOrganico();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(80, 316, 178, 27);
		panel_1.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(372, 69, 359, 201);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(372, 69, 359, 201);  
		panel_1.add(scrollPane);
		
		JButton btnRimuoviProfessore = new JButton("Rimuovi professore");
		btnRimuoviProfessore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id_selezionato=(int) table.getValueAt(table.getSelectedRow(),0);
				if(scuolago.rimuoviProfessore(id_selezionato)) 
				   JOptionPane.showMessageDialog(null,"Rimosso professore","Avviso", 1); 

			}
		});
		btnRimuoviProfessore.setBackground(new Color(250, 128, 114));
		btnRimuoviProfessore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRimuoviProfessore.setBounds(460, 316, 167, 27);
		panel_1.add(btnRimuoviProfessore);
		
		
		
//CLASSI*************************************************************************************
		JLabel lblNewLabel_3_1 = new JLabel("Gestione classi");
		lblNewLabel_3_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3_1.setBounds(30, 37, 191, 27);
		panel_2.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(30, 108, 56, 19);
		panel_2.add(lblNewLabel_1);
		JLabel lblNewLabel_6 = new JLabel("AnnoSezione");
		lblNewLabel_6.setForeground(Color.GRAY);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(30, 124, 79, 19);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblAula = new JLabel("Aula:");
		lblAula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAula.setBounds(30, 152, 79, 19);
		panel_2.add(lblAula);
		
		JLabel lblMaxAlunni = new JLabel("Max. Alunni:");
		lblMaxAlunni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaxAlunni.setBounds(30, 192, 122, 19);
		panel_2.add(lblMaxAlunni);
		
		JTextField textField_4 = new JTextField();
		textField_4.setBounds(131, 110, 143, 19);
		panel_2.add(textField_4);
		
		JTextField textField_1_1 = new JTextField();
		textField_1_1.setBounds(131, 154, 143, 19);
		panel_2.add(textField_1_1);
		
     	SpinnerModel sm = new SpinnerNumberModel(0, 0, 30, 1); 
		JSpinner spinner = new JSpinner(sm);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spinner.setBounds(130, 188, 56, 27);
		panel_2.add(spinner);
		
		table_1 = new JTable();
		table_1.setBounds(372, 69, 359, 201);

		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(372, 69, 359, 201);  
		panel_2.add(scrollPane_1);
		
		JButton btnAggiungiClasse = new JButton("Aggiungi classe");
		btnAggiungiClasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome_c= textField_4.getText();
				String aula= textField_1_1.getText();
				int max_alunni = (Integer) spinner.getValue();
				scuolago.nuovaClasse(nome_c, aula, max_alunni);
				if(!scuolago.aggiungiClasseAIstituto())
					JOptionPane.showMessageDialog(null,"Classe già presente","Avviso", 1); 
			}
		});
		btnAggiungiClasse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAggiungiClasse.setBounds(67, 262, 167, 27);
		panel_2.add(btnAggiungiClasse);

		JButton btnRimuoviClasse = new JButton("Rimuovi Classe");
		btnRimuoviClasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome_selezionato=(String) table_1.getValueAt(table_1.getSelectedRow(),0);
				if(scuolago.rimuoviClasse(nome_selezionato)) 
				   JOptionPane.showMessageDialog(null,"Rimossa la classe, i suoi alunni, e le sue lezioni","Avviso", 1); 
			}
		});
		btnRimuoviClasse.setBackground(new Color(250, 128, 114));
		btnRimuoviClasse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRimuoviClasse.setBounds(460, 316, 167, 27);
		panel_2.add(btnRimuoviClasse);
		
	
		
//ALUNNI********************************************************
		JLabel lblNewLabel_3_2 = new JLabel("Nuovo alunno");
		lblNewLabel_3_2.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3_2.setBounds(30, 37, 191, 27);
		panel_3.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nome:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(30, 102, 56, 19);
		panel_3.add(lblNewLabel_1_2);
		
		JLabel lblAula_1 = new JLabel("Cognome:");
		lblAula_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAula_1.setBounds(30, 146, 79, 19);
		panel_3.add(lblAula_1);
		
		JLabel lblMaxAlunni_1 = new JLabel("Data di nascita:");
		lblMaxAlunni_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaxAlunni_1.setBounds(30, 186, 122, 19);
		panel_3.add(lblMaxAlunni_1);
		JLabel lblNewLabel_9 = new JLabel("gg-mm-aaaa");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9.setForeground(Color.GRAY);
		lblNewLabel_9.setBounds(41, 207, 68, 15);
		panel_3.add(lblNewLabel_9);
		
		JLabel lblpsw_1 = new JLabel("Password:");
		lblpsw_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblpsw_1.setBounds(30, 230, 103, 19);
		panel_3.add(lblpsw_1);
		
		JLabel lblname = new JLabel("Classe:");
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblname.setBounds(30, 278, 103, 19);
		panel_3.add(lblname);
		
		JTextField textField_4_1 = new JTextField();
		textField_4_1.setBounds(151, 104, 143, 19);
		panel_3.add(textField_4_1);
		
		JTextField textField_1_1_1 = new JTextField();
		textField_1_1_1.setBounds(151, 148, 143, 19);
		panel_3.add(textField_1_1_1);
		
		JTextField textField_1_1_1_1 = new JTextField();
		textField_1_1_1_1.setBounds(151, 188, 143, 19);
		panel_3.add(textField_1_1_1_1);
		
		JTextField textField_1_1_1_1_1 = new JTextField();
		textField_1_1_1_1_1.setBounds(151, 232, 143, 19);
		panel_3.add(textField_1_1_1_1_1);
		
		comboBox = new JComboBox(); 
		comboBox.setBounds(150, 279, 73, 21);
		panel_3.add(comboBox);
		
		table_2 = new JTable();
		table_2.setBounds(372, 69, 359, 201);

		JScrollPane scrollPane_2 = new JScrollPane(table_2);
		scrollPane_2.setBounds(372, 69, 359, 201);  
		panel_3.add(scrollPane_2);
			
		JButton btnAggiungiClasse_1 = new JButton("Aggiungi alunno a classe");
		btnAggiungiClasse_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAggiungiClasse_1.setBounds(75, 329, 219, 27);
		panel_3.add(btnAggiungiClasse_1);
		btnAggiungiClasse_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome_a= textField_4_1.getText();
				String cognome_a= textField_1_1_1.getText();
				String nascita_a= textField_1_1_1_1.getText();
				String psw_a= textField_1_1_1_1_1.getText();
				Classe classe=(Classe) comboBox.getSelectedItem();
				scuolago.nuovoAlunno(nome_a, cognome_a, nascita_a,psw_a);
				if(!scuolago.aggiungiAlunnoAClasse(classe))
					JOptionPane.showMessageDialog(null,"La classe ha superato la capienza massima","ERRORE", 1); 
			}
		});

		
		lblTot = new JLabel();
		lblTot.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTot.setBounds(445, 312, 185, 44);
		panel_3.add(lblTot);
		
		
		
//LEZIONE*************************************************************************************
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Crea lezione");
		lblNewLabel_3_2_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3_2_1.setBounds(30, 37, 191, 27);
		panel_4.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Materia:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(30, 86, 56, 19);
		panel_4.add(lblNewLabel_1_2_1);
		
		JLabel lblAula_1_1 = new JLabel("Professore:");
		lblAula_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAula_1_1.setBounds(30, 130, 79, 19);
		panel_4.add(lblAula_1_1);
		
		JLabel lblMaxAlunni_1_2 = new JLabel("Classe:");
		lblMaxAlunni_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaxAlunni_1_2.setBounds(30, 170, 122, 19);
		panel_4.add(lblMaxAlunni_1_2);
		
		JLabel lblMaxAlunni_1_1_2 = new JLabel("Orario:");
		lblMaxAlunni_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaxAlunni_1_1_2.setBounds(30, 213, 56, 19);
		panel_4.add(lblMaxAlunni_1_1_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(148, 88, 143, 19);
		panel_4.add(textField_2);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(148, 131, 122, 21);
		panel_4.add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(148, 171, 69, 21);
		panel_4.add(comboBox_2);
		
		List<Integer> ore = new ArrayList<Integer>();
		for (int i=1;i<6; i++) ore.add(i);
		
		JLabel lblLunedi = new JLabel("Lunedi");
		lblLunedi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblLunedi.setBounds(112, 206, 37, 13);
		panel_4.add(lblLunedi);
		JList list = new JList(ore.toArray());
		list.setBounds(115, 222, 27, 91);
		((JLabel) list.getCellRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(list);
		
		JLabel lblMartedi = new JLabel("Martedi");
		lblMartedi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMartedi.setBounds(150, 206, 37, 13);
		panel_4.add(lblMartedi);
		JList list_1 = new JList(ore.toArray());
		list_1.setBounds(154, 222, 27, 91);
		((JLabel) list_1.getCellRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(list_1);
		
		JLabel lblMercoledi = new JLabel("Mercoledi");
		lblMercoledi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMercoledi.setBounds(188, 206, 45, 13);
		panel_4.add(lblMercoledi);
		JList list_2 = new JList(ore.toArray());
		list_2.setBounds(195, 222, 27, 91);
		((JLabel) list_2.getCellRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(list_2);
		
		JLabel lblGiovedi = new JLabel("Giovedi");
		lblGiovedi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblGiovedi.setBounds(235, 206, 45, 13);
		panel_4.add(lblGiovedi);
		JList list_3 = new JList(ore.toArray());
		list_3.setBounds(235, 222, 27, 91);
		((JLabel) list_3.getCellRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(list_3);
		
		JLabel lblVenerdi = new JLabel("Venerdi");
		lblVenerdi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblVenerdi.setBounds(272, 206, 37, 13);
		panel_4.add(lblVenerdi);
		JList list_4 = new JList(ore.toArray());
		list_4.setBounds(274, 222, 27, 91);
		((JLabel) list_4.getCellRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(list_4);
		
		JLabel lblNewLabel_4 = new JLabel("Ctrl per selezionare pi\u00F9 ore");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_4.setBounds(136, 318, 155, 19);
		panel_4.add(lblNewLabel_4);
		
		table_3=new JTable();
		JScrollPane scrollPane_3 = new JScrollPane(table_3);
		scrollPane_3.setBounds(344, 69, 387, 201);
		panel_4.add(scrollPane_3);
		
		JButton btnNewButton_1 = new JButton("Conferma lezione");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(118, 348, 173, 34);
		panel_4.add(btnNewButton_1);
	
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String materia=textField_2.getText();
				scuolago.nuovaLezione(materia);
				Professore prof=(Professore) comboBox_1.getSelectedItem();
				scuolago.abbinaProfALezione(prof);
				Classe classe=(Classe) comboBox_2.getSelectedItem();
				scuolago.abbinaClasseALezione(classe);
				Map<String,List<Integer>> orario_selezionato =new HashMap<>();
				orario_selezionato.put(lblLunedi.getText(), list.getSelectedValuesList());
				orario_selezionato.put(lblMartedi.getText(), list_1.getSelectedValuesList());
				orario_selezionato.put(lblMercoledi.getText(), list_2.getSelectedValuesList());
				orario_selezionato.put(lblGiovedi.getText(), list_3.getSelectedValuesList());
				orario_selezionato.put(lblVenerdi.getText(), list_4.getSelectedValuesList());
				orario_selezionato.entrySet().removeIf(entry -> entry.getValue().isEmpty());
				scuolago.definisciOrarioLezione(orario_selezionato);
				if(!materia.isEmpty() && orario_selezionato.size()>0)
					if(!scuolago.aggiungiLezioneACalendario()) 
						JOptionPane.showMessageDialog(null,"Impossibile creare lezione: è presente una sovrapposiziona "
								+ "di lezioni per la classe o il professore selezionato","ERRORE", 1); 
				list.clearSelection();
				list_1.clearSelection();
				list_2.clearSelection();
				list_3.clearSelection();
				list_4.clearSelection();

				}
			});

//AVVISI****************************************************************************************
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Invia avviso");
		lblNewLabel_3_2_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3_2_1_1.setBounds(30, 37, 191, 27);
		panel_5.add(lblNewLabel_3_2_1_1);
		
		list_classi = new JList();
		list_classi.setBounds(108, 107, 58, 102);
		panel_5.add(list_classi);
		
		JLabel lblNewLabel_7 = new JLabel("Classi:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(30, 106, 66, 13);
		panel_5.add(lblNewLabel_7);
		
		JLabel lblNewLabel_4_1 = new JLabel("Ctrl per selezionare pi\u00F9 classi");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_4_1.setBounds(30, 207, 155, 19);
		panel_5.add(lblNewLabel_4_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(113, 249, 208, 78);
		panel_5.add(textArea);
		
		JLabel lblNewLabel_8 = new JLabel("Messaggio:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(24, 248, 79, 22);
		panel_5.add(lblNewLabel_8);
		
		table_4=new JTable();
		JScrollPane scrollPane_4 = new JScrollPane(table_4);
		scrollPane_4.setBounds(344, 69, 387, 201);
		panel_5.add(scrollPane_4);
		
		JButton btnNewButton_2 = new JButton("Invia avviso");
		btnNewButton_2.setBackground(new Color(153, 255, 153));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(174, 349, 135, 33);
		panel_5.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg= textArea.getText();
				if(list_classi.getSelectedValuesList().size()>0)
					scuolago.nuovoAvviso(msg);
					scuolago.inviaAvviso(list_classi.getSelectedValuesList());
					
			}
		});
		
		
		scuolago.getOrganico().addPropertyListener(this);
		scuolago.getIstituto().addPropertyListener(this);
		scuolago.getClasse().addPropertyListener(this);
		scuolago.getCalendario().addPropertyListener(this);
		scuolago.getStorico().addPropertyListener(this);
	}
	
	
	

@Override
public void onPropertyEvent(Object source,String name, Object value) {
 switch(name){
	case "PROFESSORE":
			String columns[]= {"ID","Nome", "Cognome", "Data di Nascita"};
			DefaultTableModel model = new DefaultTableModel(columns,0);
			comboBox_1.removeAllItems();
			for(Professore p :scuolago.getProfessori()){
				model.addRow(new Object[]{p.getId(),p.getNome(),p.getCognome(),p.getNascita()});
				comboBox_1.addItem(p);
			}
		    table.setModel(model);
		    break;
			
	case "CLASSE","ALUNNO":
			String columns1[]= {"Nome", "Aula", "Limite capienza","Capienza attuale "};
			DefaultTableModel model1 = new DefaultTableModel(columns1,0);
			DefaultListModel model_l_1 = new DefaultListModel();
			comboBox.removeAllItems();
			comboBox_2.removeAllItems();
			for(Classe c :scuolago.getClassi()){
				model1.addRow(new Object[]{c.getNome(),c.getAula(),c.getMaxAlunni(),c.getAlunniClasse().size() });
				comboBox.addItem(c);
				comboBox_2.addItem(c);
				model_l_1.addElement(c);
			}
			list_classi.setModel(model_l_1);
			table_1.setModel(model1); 
	
			String columns2[]= {"ID","Nome", "Cognome", "Data di Nascita","Classe"};
			DefaultTableModel model2 = new DefaultTableModel(columns2,0);
			for(Alunno a :scuolago.getAlunniIstituto()){
				model2.addRow(new Object[]{a.getId(),a.getNome(),a.getCognome(),a.getNascita(),a.getClasse().getNome() });
		    }
		    table_2.setModel(model2);
		    lblTot.setText("Totale alunni: "+scuolago.getAlunniIstituto().size());
		    break;
		    
	 case "LEZIONE":
			String columns3[]= {"Materia", "Professore", "Classe","Orario"};
			DefaultTableModel model3 = new DefaultTableModel(columns3,0);
			for(Lezione l :scuolago.getLezioni()){
				model3.addRow(new Object[]{l.getMateria(),l.getProfessore().getNome()+" "+l.getProfessore().getCognome(),l.getClasse().getNome(),l.getOrario().toString()});
			}
			table_3.setModel(model3);
			break;
			
	 case "AVVISO":
			String columns4[]= {"Data", "Classi", "Messaggio"};
			DefaultTableModel model4 = new DefaultTableModel(columns4,0);
			for(Avviso a :scuolago.getAvvisi()){
				model4.addRow(new Object[]{a.getData(),a.getClassi(),a.getMsg()});
			}
			table_4.setModel(model4);
			table_4.getColumnModel().getColumn(2).setPreferredWidth(300);
			break;
			
 		}
	 if(value!=null) System.out.println("MODIFICATO "+name +"-> "+value);
		
	}
}
