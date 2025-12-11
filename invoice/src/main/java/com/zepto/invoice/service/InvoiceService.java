package com.zepto.invoice.service;

import java.util.List;
import java.util.Optional;

import com.zepto.invoice.entity.Invoice;
import com.zepto.invoice.request.InvoiceRequest;

public interface InvoiceService {
	
	public abstract Invoice createInvoice(InvoiceRequest invoiceRequest);
	
	public abstract List<Invoice> getAllInvoices();
	
	public abstract Optional<Invoice> getInvoice(int invoiceId);
	
	public abstract Optional<Invoice> updateInvoice(int invoiceId, InvoiceRequest invoiceRequest);

	public abstract boolean deleteInvoice(int invoiceId);
	
}
