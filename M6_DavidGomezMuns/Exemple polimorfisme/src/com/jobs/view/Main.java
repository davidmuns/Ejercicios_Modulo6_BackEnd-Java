package com.jobs.view;

import javax.swing.JOptionPane;

import com.jobs.application.JobsController;

public class Main {

	private static JobsController controller=new JobsController();
	
	public static void main(String[] args) throws Exception {
		
		try {
			controller.createBossEmployee("Pepe Boss", "Dirección molona", "666666666", 8001.0);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "The boss earns more than 8.000 euros a month");
			System.exit(0);
		}
		
		try {
			controller.createManagerEmployee("Pedro Manager", "Dirección molona 2", "665226666", 4000.0);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "The manager earns more than 3.000 and less than 5.000 euros a month");
			System.exit(0);
		}
		controller.createEmployee("Pedro Employee", "Dirección molona 2", "665266666", 40.0);
		controller.createEmployee("Laura Employee", "Dirección molona 3", "625266666", 45.0);
		
		try {
			controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666", 0.0);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "The volunteer does not receive a salary");
			System.exit(0);
		}
			
		controller.payAllEmployeers();
		
		String allEmployees=controller.getAllEmployees();
		
		System.out.println("EMPLOYEES:\n" + allEmployees + " \n");
		
	}

}
