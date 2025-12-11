package com.zepto.invoice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.invoice.entity.Invoice;
import com.zepto.invoice.repository.InvoiceRepository;
import com.zepto.invoice.request.InvoiceRequest;

//GST

@Service(value="gst")
public class InvoiceV1Service implements InvoiceService{
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Override
	public Invoice createInvoice(InvoiceRequest invoiceRequest) {
		
		Invoice invoice = new Invoice();
		
		invoice.setSupplier(invoiceRequest.getSupplier());
		invoice.setRecipient(invoiceRequest.getRecipient());
		invoice.setDueDate(invoiceRequest.getDueDate());
		invoice.setProducts(invoiceRequest.getProducts());
		invoice.setPrices(invoiceRequest.getPrices());
		
		Double totalPrice =  invoiceRequest.getPrices()
										.stream()
										.reduce((double) 0, (a,b)->a+b);
		
		invoice.setTotalPrice(totalPrice);
		
		invoice.setTaxType(invoiceRequest.getTaxType());
		
		//GST = CGST + SGST = 18%
		
		Double gst = totalPrice * 0.18;
		
		invoice.setTax(gst);
		
		Double priceWithGST = totalPrice + gst;
		
		invoice.setPriceWithGst(priceWithGST);
		
		Invoice invoiceRes = invoiceRepository.save(invoice);
		
		return invoiceRes;
	}

	@Override
	public List<Invoice> getAllInvoices() {
		
		Iterable<Invoice> allInvoices = invoiceRepository.findAll();
		
		return (List<Invoice>) allInvoices;
	}

	@Override
	public Optional<Invoice> getInvoice(int invoiceId) {
		
		Optional<Invoice> invoice = invoiceRepository.findById(invoiceId);
		
		return invoice;
	}

	@Override
	public Optional<Invoice> updateInvoice(int invoiceId, InvoiceRequest invoiceRequest) {
		
		Optional<Invoice> invoice = invoiceRepository.findById(invoiceId);
		
		if(invoice.isPresent()) {
			Invoice invoiceUpdated = invoice.get();
			invoiceUpdated.setSupplier(invoiceRequest.getSupplier());
			invoiceUpdated.setRecipient(invoiceRequest.getRecipient());
			invoiceUpdated.setDueDate(invoiceRequest.getDueDate());
			invoiceUpdated.setProducts(invoiceRequest.getProducts());
			invoiceUpdated.setPrices(invoiceRequest.getPrices());
			
			Double totalPrice =  invoiceRequest.getPrices()
												.stream()
												.reduce((double) 0, (a,b)->a+b);
			
			invoiceUpdated.setTotalPrice(totalPrice);
			
			invoiceUpdated.setTaxType(invoiceRequest.getTaxType());
			
			//GST = CGST + SGST = 18%
			
			Double gst = totalPrice * 0.18;
			
			invoiceUpdated.setTax(gst);
			
			Double priceWithGST = totalPrice + gst;
			
			invoiceUpdated.setPriceWithGst(priceWithGST);
			
			Invoice updatedIn = invoiceRepository.save(invoiceUpdated);
			
			return Optional.of(updatedIn);

		}else {
			return Optional.empty();
		}

	}

	@Override
	public boolean deleteInvoice(int invoiceId) {
		
		invoiceRepository.deleteById(invoiceId);
		
		if(invoiceRepository.existsById(invoiceId)) {
			return false;
		}else {
			return true;
		}
		
	}

	
	

}
