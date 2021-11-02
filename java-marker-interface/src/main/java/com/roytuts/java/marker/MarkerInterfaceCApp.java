package com.roytuts.java.marker;

public class MarkerInterfaceCApp {

	public static void main(String[] args) {
		PaymentC payment = new PaymentC();
		
		if (payment instanceof Cheque) {
			System.out.println("payment is instance of Cheque.");
		}
		
		if (payment instanceof BankDraft) {
			System.out.println("payment is instance of BankDraft.");
		}
	}

}
