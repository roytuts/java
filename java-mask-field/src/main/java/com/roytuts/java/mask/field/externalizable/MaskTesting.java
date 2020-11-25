package com.roytuts.java.mask.field.externalizable;

import java.io.IOException;

public class MaskTesting {

    public static void main(String[] args) throws IOException, IOException, ClassNotFoundException {
        Card debitCard = new Card();
        debitCard.setType(Type.debit);
        debitCard.setName("Platinum");
        debitCard.setIdentifier("4567 8902 4365");

        System.out.println("Debit Card: " + debitCard);

        Card creditCard = new Card();
        creditCard.setType(Type.credit);
        creditCard.setName("Gold");
        creditCard.setIdentifier("5562 9354 6232");

        System.out.println("Credit Card: " + creditCard);
    }

}
