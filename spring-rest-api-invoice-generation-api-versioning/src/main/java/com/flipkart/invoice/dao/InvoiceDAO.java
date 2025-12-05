package com.flipkart.invoice.dao;

import com.flipkart.invoice.entity.Invoice;

public interface InvoiceDAO {
	
	public abstract void saveInvoice(Invoice invoice);

}
