package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Address;
import de.oszimt.lf10aContractMgmt.model.Employee;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class MitarbeiterVerwaltung {

	public JFrame frame;
	private JTextField txt_vorname;
	private JTextField txt_nachname;
	private JTextField txt_email;
	private JTextField txt_adresse;
	private JTextField txt_telefon;
	private JTextField txt_id;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MitarbeiterVerwaltung window = new MitarbeiterVerwaltung();
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
	public MitarbeiterVerwaltung() {
		initialize(null, false);
	}
	
	public MitarbeiterVerwaltung(List<String> data) {
		initialize(data, true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(List<String> data, boolean editMode) {
		frame = new JFrame();
		frame.setBounds(100, 100, 668, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mitarbeiter hinzuf\u00FCgen");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(63, 62, 316, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Vorname ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(63, 199, 64, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nachname");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(63, 266, 90, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("TelefonNr.");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(392, 266, 97, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("E-mail");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(392, 132, 64, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Adresse");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1_2.setBounds(392, 199, 64, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Id");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(63, 132, 64, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		txt_id = new JTextField();
		txt_id.setText("auto generiert");
		txt_id.setEnabled(false);
		txt_id.setEditable(false);
		txt_id.setColumns(10);
		txt_id.setBounds(63, 157, 179, 31);
		frame.getContentPane().add(txt_id);
		
		txt_vorname = new JTextField();
		txt_vorname.setBounds(63, 224, 179, 31);
	
		frame.getContentPane().add(txt_vorname);
		txt_vorname.setColumns(10);
		
		txt_nachname = new JTextField();
		txt_nachname.setColumns(10);
		txt_nachname.setBounds(63, 291, 179, 31);
		frame.getContentPane().add(txt_nachname);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(392, 157, 179, 31);
		frame.getContentPane().add(txt_email);
		
		txt_adresse = new JTextField();
		txt_adresse.setColumns(10);
		txt_adresse.setBounds(392, 224, 179, 31);
		frame.getContentPane().add(txt_adresse);
		
		txt_telefon = new JTextField();
		txt_telefon.setColumns(10);
		txt_telefon.setBounds(392, 291, 179, 31);
		frame.getContentPane().add(txt_telefon);
	
		if(editMode) {
			
			lblNewLabel.setText("Mitarbeiter bearbeiten");
			HaseGmbHManagement haseMgmtDriver = HaseGmbHManagement.GET_INSTANCE();
			Object obj = data.get(0);
			int empId = (int)obj;
			Employee emp  = haseMgmtDriver.getEmployee(empId);
			
			txt_id.setText(String.valueOf(emp.getEmployeeID()));
			txt_adresse.setText(emp.getAddress().getStreet());
			txt_email.setText(emp.getEmail());
			txt_vorname.setText(emp.getFirstname());
			txt_nachname.setText(emp.getLastname());
			txt_telefon.setText(emp.getTelephone());
			

		}
		
		JButton btnNewButton = new JButton("Speichern");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HaseGmbHManagement haseMgmtDriver = HaseGmbHManagement.GET_INSTANCE();
				
				Address address = new Address(txt_adresse.getText(), null, null, null, null);
				
				Employee emp = new Employee(txt_vorname.getText(), txt_nachname.getText(),address, txt_email.getText(), txt_telefon.getText());
				if(!editMode)
					haseMgmtDriver.addNewEmployee(emp);
				else {
					Object obj = data.get(0);
					int id  = (int)obj;
					Employee edited = haseMgmtDriver.getEmployee(id);
					edited.setAllFields(txt_vorname.getText(), txt_nachname.getText(),address, txt_email.getText(), txt_telefon.getText());
					haseMgmtDriver.updateEmployee(edited);	
				}
					
				Mitarbeiterliste ml = new Mitarbeiterliste();
				ml.main(null);
				frame.setVisible(false);
			
			}
		});
		btnNewButton.setBounds(458, 371, 113, 31);
		frame.getContentPane().add(btnNewButton);
		
		JButton btn_speichern = new JButton("Zur\u00FCck");
		btn_speichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mitarbeiterliste ml = new Mitarbeiterliste();
				ml.main(null);
				frame.setVisible(false);
			}
		});
		btn_speichern.setBounds(63, 371, 113, 31);
		frame.getContentPane().add(btn_speichern);
		
	}
}
