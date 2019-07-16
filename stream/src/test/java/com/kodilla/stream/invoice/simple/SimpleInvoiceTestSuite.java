package com.kodilla.stream.invoice.simple;

import org.junit.Assert;
import org.junit.Test;

public class SimpleInvoiceTestSuite {

    @Test
    public void testGetValueToPay() {
        //Given
        SimpleInvoice invoice = new SimpleInvoice();
        SimpleProduct simpleProduct1 = new SimpleProduct("Product 1", 17.28);
        SimpleProduct simpleProduct2 = new SimpleProduct("Product 2", 11.99);
        SimpleProduct simpleProduct3 = new SimpleProduct("Product 3",  6.49);
        SimpleItem simpleItem1 = new SimpleItem(simpleProduct1,2.0);
        SimpleItem simpleItem2 = new SimpleItem(simpleProduct2,3.5);
        SimpleItem simpleItem3 = new SimpleItem(simpleProduct3,5.0);
        //When
        invoice.addItem(simpleItem1);
        invoice.addItem(simpleItem2);
        invoice.addItem(simpleItem3);
        //Then
        Assert.assertEquals(108.975, invoice.getValueToPay(), 0.001);
    }
}
