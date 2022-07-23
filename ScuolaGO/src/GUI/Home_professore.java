package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dominio.Alunno;
import Dominio.Assenze;
import Dominio.Avviso;
import Dominio.Classe;
import Dominio.Lezione;
import Dominio.Professore;
import Dominio.PropertyListener;
import Dominio.RegistroVoti;
import Dominio.ScuolaGO;
import Dominio.Voto;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JSpinner;
import java.awt.SystemColor;

public class Home_professore extends JFrame implements PropertyListener {
	ScuolaGO scuolago = ScuolaGO.getInstance();
	Professore prof_login=null;
	private JPanel contentPane;
	private JTable table,table_1;

	/**
	 * Launch the application.
	 */
 public static void main(Professore prof_login) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_professore frame = new Home_professore(prof_login);
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
	public Home_professore(Professore prof_login) {
		this.prof_login=prof_login;
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
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBackground(new Color(102, 153, 204));
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.setBounds(10, 10, 768, 440);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("HOME", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Registro assenze", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Registro voti", null, panel_2, null);
		panel_2.setLayout(null);
		
		
//HOME************************************************	
		JLabel lblNewLabel = new JLabel("Benvenuto, Prof. "+ prof_login.getNome()+" "+prof_login.getCognome());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 36, 676, 56);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ScuolaGO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(102, 153, 255));
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD, 50));
		lblNewLabel_1.setBackground(new Color(102, 204, 0));
		lblNewLabel_1.setBounds(234, 136, 272, 112);
		panel.add(lblNewLabel_1);
		
//REGISTRO ASSENZE********************************************************
		JList list = new JList(scuolago.getClassi().toArray());		
		list.setBounds(30, 97, 63, 180);
		panel_1.add(list);
		
		DefaultListModel model_1 = new DefaultListModel();
		JList list_1 = new JList(model_1);
		list_1.setBounds(131, 97, 111, 190);
		panel_1.add(list_1);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(!list.getValueIsAdjusting()) {
					Classe classe_selezionata=(Classe) list.getSelectedValue();
					 model_1.clear();
					 model_1.addAll(classe_selezionata.getAlunniClasse());
					 list_1.setModel(model_1);
				}}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Classi Istituto");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(20, 76, 94, 13);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Alunni Classe");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(131, 76, 94, 13);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Registro assenze");
		lblNewLabel_3_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3_1.setBounds(20, 25, 191, 27);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("Ctrl per selezionare pi\u00F9 alunni");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_4.setBounds(102, 297, 164, 19);
		panel_1.add(lblNewLabel_4);
		
		table=new JTable();
		JScrollPane scrollPane_3 = new JScrollPane(table);
		scrollPane_3.setBounds(344, 69, 387, 201);
		panel_1.add(scrollPane_3);
		
		JButton btnNewButton = new JButton("Conferma assenze");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scuolago.nuovaAssenza(list_1.getSelectedValuesList());
				if(!scuolago.confermaAssenze())
					JOptionPane.showMessageDialog(null,"Registro già compilato oggi per la classe selezionata","ERRORE", 1); 
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(41, 339, 184, 27);
		panel_1.add(btnNewButton);
	
//REGISTRO VOTI********************************************************
		
		JLabel lblNewLabel_2_1 = new JLabel("Le tue lezioni");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(30, 75, 94, 13);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Registro voti");
		lblNewLabel_3_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3_1_1.setBounds(24, 24, 191, 27);
		panel_2.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Alunni lezione");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(186, 75, 94, 13);
		panel_2.add(lblNewLabel_3_2);
		
		JList list_2 = new JList(scuolago.getLezioniProf(prof_login).toArray());
		list_2.setBounds(30, 105, 109, 209);
		panel_2.add(list_2);
		
		DefaultListModel model_2 = new DefaultListModel();
		JList list_3 = new JList();
		
		list_3.setBounds(166, 105, 135, 209);
		panel_2.add(list_3);
		list_2.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(!list.getValueIsAdjusting()) {
					Lezione lezinoe_selezionata=(Lezione) list_2.getSelectedValue();
					 model_2.clear();
					 model_2.addAll(lezinoe_selezionata.getAlunniLezione());
					 list_3.setModel(model_2);
				}}
		});
		
		JLabel alunnoAssente = new JLabel("<html>Attenzione, l'alunno selezionato oggi \u00E8 assente.<br>E' comunque possibile aggiungere un voto.</html>");
		alunnoAssente.setForeground(new Color(255, 0, 0));
		alunnoAssente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		alunnoAssente.setBounds(381, 286, 316, 71);
		 panel_2.add(alunnoAssente);
		 alunnoAssente.setVisible(false);
		list_3.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				 if(scuolago.getRegistroAssenze().alunnoAssente((Alunno) list_3.getSelectedValue(),scuolago.getCurrentData()))
					 alunnoAssente.setVisible(true);
				 else alunnoAssente.setVisible(false);
			}
		});
		
     	SpinnerModel sm = new SpinnerNumberModel(0, 0, 10, 1); 
		JSpinner spinner = new JSpinner(sm);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner.setBounds(32, 337, 49, 33);
		panel_2.add(spinner);
		


		JButton btnConfermaVoto = new JButton("Conferma voto");
		btnConfermaVoto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConfermaVoto.setBounds(102, 342, 184, 27);
		panel_2.add(btnConfermaVoto);
		btnConfermaVoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valutazione=(Integer)spinner.getValue();
				Alunno alunno=(Alunno) list_3.getSelectedValue();
				scuolago.nuovoVoto(alunno,valutazione);
				Lezione lezione=(Lezione) list_2.getSelectedValue();
				scuolago.abbinaVotoALezione(lezione);
				scuolago.confermaVoto();
			}
		});
		
		
		JLabel lblNewLabel_5 = new JLabel("I tuoi voti");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(507, 41, 109, 30);
		panel_2.add(lblNewLabel_5);
		table_1=new JTable();	
		JScrollPane scrollPane_3_1 = new JScrollPane(table_1);
		scrollPane_3_1.setBounds(355, 75, 387, 201);
		panel_2.add(scrollPane_3_1);
		
		
		scuolago.getRegistroAssenze().addPropertyListener(this);
		scuolago.getRegistroVoti().addPropertyListener(this);
	}

@Override
public void onPropertyEvent(Object source,String name, Object value) {
	 switch(name){
		case "ASSENZE":
			String columns[]= {"Data", "Classe", "Alunni assenti"};
			DefaultTableModel model = new DefaultTableModel(columns,0);
			for(Assenze a :scuolago.getAssenze()){
				model.addRow(new Object[]{a.getData(),a.getClasse(),a.getAlunni()});
		    }
			table.setModel(model);
			table.getColumnModel().getColumn(2).setPreferredWidth(300);
			break;

		case "VOTO":
			String columns1[]= {"Data", "Materia", "Alunno","Voto"};
			DefaultTableModel model_1 = new DefaultTableModel(columns1,0);
			for(Voto v :scuolago.getVotiProf(prof_login)){
				model_1.addRow(new Object[]{v.getData(),v.getLezione().getMateria(),v.getAlunno(),v.getValutazione()});
		    }				
			table_1.setModel(model_1);
			break;

		 default:
			 	if(value!=null) System.out.println("MODIFICATO: "+name);
				}
			}	
}
