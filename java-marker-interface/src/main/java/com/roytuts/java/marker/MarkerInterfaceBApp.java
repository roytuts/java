package com.roytuts.java.marker;

public class MarkerInterfaceBApp {

	public static void main(String[] args) {
		PaymentB payment = new PaymentB();

		if (payment instanceof Cheque) {
			System.out.println("payment is instance of Cheque.");
		}

		if (payment instanceof BankDraft) {
			System.out.println("payment is instance of BankDraft.");
		}
	}

}
