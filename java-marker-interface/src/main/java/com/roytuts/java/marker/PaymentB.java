package com.roytuts.java.marker;

public class PaymentB implements BankDraft {

	public void paymentByCheque() {
		System.out.println("Payment by Cheque.");
	}

	public void paymentByBankDraft() {
		System.out.println("Payment by BankDraft.");
	}

}
