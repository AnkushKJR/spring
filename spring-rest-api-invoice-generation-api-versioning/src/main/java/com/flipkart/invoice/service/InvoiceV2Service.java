package com.flipkart.invoice.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkart.invoice.dao.InvoiceDAOImpl;
import com.flipkart.invoice.entity.Invoice;

@Service("invoiceV2Service")
public class InvoiceV2Service implements InvoiceService {
	
	@Autowired
	InvoiceDAOImpl invoiceDAOImpl;
	
	@Override
	public Invoice generateInvoice(String item, String desc, Double price) {
		
		double gst = price * 0.18;
        double total = price + gst;
        
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(UUID.randomUUID().toString().substring(0, 10));
        invoice.setItemName(item);
        invoice.setDescription(desc);
        invoice.setBasePrice(price);
        invoice.setTaxAmount(gst);
        invoice.setTotalPrice(total);
        invoice.setTaxType("GST");
        invoice.setVersion("v2");
        invoice.setCreatedAt(new Date());
        
        invoiceDAOImpl.saveInvoice(invoice);
		
		return invoice;
	}

}
