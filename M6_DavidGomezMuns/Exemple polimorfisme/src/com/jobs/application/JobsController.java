package com.jobs.application;

import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();

	public JobsController() {

	}

	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
		if(salaryPerMonth < 8000) throw new Exception();
		Employee e = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(e);
	}

	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
		Employee e = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(e);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
		if(salaryPerMonth < 3000 || salaryPerMonth > 5000) throw new Exception();
		Employee e = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(e);
	}

	public void createVolunteer(String name, String address, String phone, double salaryPerMonth) throws Exception {

		Volunteer v = new Volunteer(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateVolunteer());
		repository.addMember(v);

	}

	public void payAllEmployeers() {
		for (int i = 0; i < repository.getAllMembers().size(); i++) {
			repository.getAllMembers().get(i).pay();
		}
	}

	public String getAllEmployees() {
		String members = "";
		for (int i = 0; i < repository.getAllMembers().size(); i++) {
			members += repository.getAllMembers().get(i).toString() + "\n";
		}
		return members;
	}

}
