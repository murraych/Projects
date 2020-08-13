package com.techelevator.couplingExample.looseCoupling;

public class LazyWorker implements InterfaceWorker {


	@Override
	public void work() {
		System.out.println("Lazy Worker working");

	}

}
