package com.techelevator.couplingExample.looseCoupling;

public class Manager {

	InterfaceWorker worker;
	public Manager(InterfaceWorker worker) {
		this.worker = worker;
	}
	
	public void manageWork() {
		this.worker.work();
	}

}
