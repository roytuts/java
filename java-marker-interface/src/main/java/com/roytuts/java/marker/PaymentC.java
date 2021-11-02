package com.roytuts.java.marker;

public class PaymentC implements Cheque {

	public void paymentByCheque() {
		System.out.println("Payment by Cheque.");
	}

	public void paymentByBankDraft() {
		System.out.println("Payment by BankDraft.");
	}

}
