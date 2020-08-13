package com.techelevator.couplingExample;

public class ManagerTightCoupling {

	SmartWorkerTightCoupling smartWorker;
	LazyWorkerTightCoupling lazyWorker;
	ExtraordinaryWorkerTightCoupling extraWorker;
	
	public ManagerTightCoupling(SmartWorkerTightCoupling smartWorker,
			    LazyWorkerTightCoupling lazyWorker, 
			    ExtraordinaryWorkerTightCoupling extraWorker) {
		this.smartWorker = smartWorker;
		this.lazyWorker = lazyWorker;
		this.extraWorker = extraWorker;
	}
	
	public void manageWork() {
		smartWorker.work();
		lazyWorker.work();
		extraWorker.work();
	}

}
