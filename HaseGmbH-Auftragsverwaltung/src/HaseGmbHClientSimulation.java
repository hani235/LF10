
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.*;

public class HaseGmbHClientSimulation {

	
	public static void main(String[] args) {
		new HaseGmbHClientSimulation();
	}

	public HaseGmbHClientSimulation() {
		HaseGmbHManagement haseMgmtDriver =  HaseGmbHManagement.GET_INSTANCE();

		System.out.println(" list of the test-employees:");
		for (Employee e : haseMgmtDriver.getAllEmployees()) {
			System.out.println(e);
		}
		System.out.println("-------------------------------\n");
		System.out.println(" list of the test-customers:");
		for (Customer c : haseMgmtDriver.getAllCustomers()) {
			System.out.println(c);
		}
		System.out.println("-------------------------------\n");

		System.out.println(" list of the test-contracs:");
		for (Contract c : haseMgmtDriver.getAllContracts()) {
			System.out.println(c);
		}
	}

}
