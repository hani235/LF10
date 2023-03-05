package view.Kunden;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Address;
import de.oszimt.lf10aContractMgmt.model.Customer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class KundenVerwaltung {

	public JFrame frame;
	private JTextField txt_vorname;
	private JTextField txt_nachname;
	private JTextField txt_email;
	private JTextField txt_adresse;
	private JTextField txt_gbtag;
	private JTextField txt_id;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KundenVerwaltung window = new KundenVerwaltung();
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
	public KundenVerwaltung() {
		initialize(null, false);
	}
	
	public KundenVerwaltung(List<String> data) {
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
		
		JLabel lblNewLabel = new JLabel("Kunden hinzuf\u00FCgen");
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
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Geburtsdatum");
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
		
		txt_gbtag = new JTextField();
		txt_gbtag.setColumns(10);
		txt_gbtag.setBounds(392, 291, 179, 31);
		frame.getContentPane().add(txt_gbtag);
	
		if(editMode) {
			
			lblNewLabel.setText("Kunden bearbeiten");
			HaseGmbHManagement haseMgmtDriver = HaseGmbHManagement.GET_INSTANCE();
			Object obj = data.get(0);
			int custId = (int)obj;
			Customer cust  = haseMgmtDriver.getCustomer(custId);
			
			txt_id.setText(String.valueOf(cust.getCustomerID()));
			txt_adresse.setText(cust.getAddress().getStreet());
			txt_email.setText(cust.getEmail());
			txt_vorname.setText(cust.getFirstname());
			txt_nachname.setText(cust.getLastname());
			txt_gbtag.setText(cust.getBirthday());
			

		}
		
		JButton btnNewButton = new JButton("Speichern");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HaseGmbHManagement haseMgmtDriver = HaseGmbHManagement.GET_INSTANCE();
				
				Address address = new Address(txt_adresse.getText(), null, null, null, null);
				
				Customer cust = new Customer(txt_vorname.getText(), txt_nachname.getText(),txt_gbtag.getText(), txt_email.getText(), address);
				if(!editMode)
					haseMgmtDriver.addNewCustomer(cust);
				else {
					Object obj = data.get(0);
					int id  = (int)obj;
					Customer edited = haseMgmtDriver.getCustomer(id);
					edited.setAllFields(txt_vorname.getText(), txt_nachname.getText(),address, txt_email.getText(), txt_gbtag.getText());
					haseMgmtDriver.updateCustomer(edited);	
				}
					
				Kundenliste ml = new Kundenliste();
				ml.main(null);
				frame.setVisible(false);
			
			}
		});
		btnNewButton.setBounds(458, 371, 113, 31);
		frame.getContentPane().add(btnNewButton);
		
		JButton btn_speichern = new JButton("Zur\u00FCck");
		btn_speichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kundenliste ml = new Kundenliste();
				ml.main(null);
				frame.setVisible(false);
			}
		});
		btn_speichern.setBounds(63, 371, 113, 31);
		frame.getContentPane().add(btn_speichern);
		
	}
}
