package com.flipkart.invoice.service;

import com.flipkart.invoice.entity.Invoice;

public interface InvoiceService {
	Invoice generateInvoice(String item, String desc, Double price);
}
