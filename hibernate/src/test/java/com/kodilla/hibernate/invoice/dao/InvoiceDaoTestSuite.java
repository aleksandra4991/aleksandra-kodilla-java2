package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {

        //Given

        Item item1 = new Item(new BigDecimal(467.76), 5);
        Item item2 = new Item(new BigDecimal(467.76), 5);
        Item item3 = new Item(new BigDecimal(467.76), 5);

        Invoice invoice1 = new Invoice("FGH/KH/56987/04");

        Product product1 = new Product("SAMSUNG 4");

        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);
        invoice1.getItems().add(item3);

        item1.setInvoice(invoice1);
        item2.setInvoice(invoice1);
        item3.setInvoice(invoice1);

        item1.setProduct(product1);
        item2.setProduct(product1);
        item3.setProduct(product1);

        //When
        invoiceDao.save(invoice1);
        int invoice1Id = invoice1.getId();
        int product1Id = product1.getId();

        //Then
        Assert.assertNotEquals(0, invoice1Id);
        Assert.assertNotEquals(0, product1Id);

        //CleanUp
        invoiceDao.deleteById(invoice1Id);
    }
}
