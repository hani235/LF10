package GUI;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Employee;

public class mitarbeiterliste {

	private JFrame frmAuftragsverwaltung;
	private JTable table;
	private JTextField tx_filter;
	String[] columnNames = {
			"Id",
			"Vorname",
			"Nachname",
            "Email",
            "Tel.Nr"
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mitarbeiterliste window = new mitarbeiterliste();
					window.frmAuftragsverwaltung.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mitarbeiterliste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		HaseGmbHManagement haseMgmtDriver = new HaseGmbHManagement();
		ArrayList<Employee> mliste = haseMgmtDriver.getAllEmployees();
		
		Object[][] data = new Object[mliste.size()][5];
		
		for(int i = 0; i < mliste.size(); i++) {
			
			data[i][0] = new Integer(mliste.get(i).getEmployeeID());
			data[i][1] = mliste.get(i).getFirstname();
			data[i][2] = mliste.get(i).getLastname();
			data[i][3] = mliste.get(i).getEmail();
			data[i][4] = mliste.get(i).getTelephone();
				 
		}
		
		
		frmAuftragsverwaltung = new JFrame();
		frmAuftragsverwaltung.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frmAuftragsverwaltung.setMinimumSize(new Dimension(1200, 800));
		frmAuftragsverwaltung.setTitle("Auftragsverwaltung");
		frmAuftragsverwaltung.setBounds(100, 100, 450, 300);
		frmAuftragsverwaltung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAuftragsverwaltung.getContentPane().setLayout(null);
		
		
		
		
		
		table = new JTable( data, this.columnNames);
		table.setBounds(64, 357, 1028, 227);
		frmAuftragsverwaltung.getContentPane().add(table);
		
		JLabel lb_NewLabel = new JLabel("Mitarbeiterliste");
		lb_NewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lb_NewLabel.setBounds(64, 139, 207, 70);
		frmAuftragsverwaltung.getContentPane().add(lb_NewLabel);
		
		JButton btn_AddEmployee = new JButton("+");
		btn_AddEmployee.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_AddEmployee.setFocusTraversalKeysEnabled(false);
		btn_AddEmployee.setFocusPainted(false);
		btn_AddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_AddEmployee.setBounds(281, 156, 81, 52);
		frmAuftragsverwaltung.getContentPane().add(btn_AddEmployee);
		
		JLabel lb_filter = new JLabel("Filtern nach Mitarbeiter Namen: ");
		lb_filter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_filter.setBounds(64, 255, 238, 14);
		frmAuftragsverwaltung.getContentPane().add(lb_filter);
		
		tx_filter = new JTextField();
		tx_filter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tx_filter.setBounds(281, 245, 201, 36);
		frmAuftragsverwaltung.getContentPane().add(tx_filter);
		tx_filter.setColumns(10);
		
		JButton btn_back = new JButton("zur\u00FCck");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_back.setBounds(64, 672, 89, 36);
		frmAuftragsverwaltung.getContentPane().add(btn_back);
		
		JLabel lblNewLabel = new JLabel("Employee Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(142, 332, 89, 14);
		frmAuftragsverwaltung.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Vorname");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(339, 332, 81, 14);
		frmAuftragsverwaltung.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nachname\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(536, 333, 81, 14);
		frmAuftragsverwaltung.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("E-Mail");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(759, 332, 46, 14);
		frmAuftragsverwaltung.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tel");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(986, 333, 46, 14);
		frmAuftragsverwaltung.getContentPane().add(lblNewLabel_4);
	}
}
