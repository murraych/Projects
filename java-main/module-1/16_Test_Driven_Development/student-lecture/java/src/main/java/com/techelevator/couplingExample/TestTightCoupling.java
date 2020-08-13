package com.techelevator.couplingExample;

public class TestTightCoupling {


	public static void main(String[] args) {
		SmartWorkerTightCoupling smartWorker =
				new SmartWorkerTightCoupling();
		LazyWorkerTightCoupling lazyWorker = 
				new LazyWorkerTightCoupling();
		ManagerTightCoupling manager = 
				new ManagerTightCoupling(smartWorker, lazyWorker);
		
		manager.manageWork();
		

	}

}
