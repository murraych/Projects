package com.techelevator.couplingExample;

public class ManagerTightCoupling {

	SmartWorkerTightCoupling smartWorker;
	LazyWorkerTightCoupling lazyWorker;
	
	public ManagerTightCoupling(SmartWorkerTightCoupling smartWorker,
			    LazyWorkerTightCoupling lazyWorker) {
		this.smartWorker = smartWorker;
		this.lazyWorker = lazyWorker;
	}
	
	public void manageWork() {
		smartWorker.work();
		lazyWorker.work();
	}

}
