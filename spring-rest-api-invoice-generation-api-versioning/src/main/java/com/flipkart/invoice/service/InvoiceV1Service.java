package com.flipkart.invoice.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkart.invoice.dao.InvoiceDAOImpl;
import com.flipkart.invoice.entity.Invoice;

@Service("invoiceV1Service")
public class InvoiceV1Service implements InvoiceService {
	
	@Autowired
	InvoiceDAOImpl invoiceDAOImpl;
	
	@Override
	public Invoice generateInvoice(String item, String desc, Double price) {
		
		double vat = price * 0.13;	//s + c
		double total = price + vat;
		
		Invoice invoice = new Invoice();
		
		invoice.setInvoiceId(UUID.randomUUID().toString().substring(0, 10));
        invoice.setItemName(item);
        invoice.setDescription(desc);
        invoice.setBasePrice(price);
        invoice.setTaxAmount(vat);
        invoice.setTotalPrice(total);
        invoice.setTaxType("VAT");
        invoice.setVersion("v1");
        invoice.setCreatedAt(new Date());
		
        invoiceDAOImpl.saveInvoice(invoice);
		
		return invoice;
	}

}
