package com.techelevator.couplingExample.looseCoupling;

public class TestLooseCoupling {


	public static void main(String[] args) {
		SmartWorker smartWorker = new SmartWorker();
		Manager manager1 = new Manager(smartWorker);
		manager1.manageWork();
		
		LazyWorker lazyWorker = new LazyWorker();
		Manager manager2 = new Manager(lazyWorker);
		manager2.manageWork();
		

	}

}
