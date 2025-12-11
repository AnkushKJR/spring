package com.zepto.invoice.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.invoice.entity.Invoice;
import com.zepto.invoice.request.InvoiceRequest;
import com.zepto.invoice.service.InvoiceService;

@RestController
public class InvoiceController {

	@Autowired
	Map<String, InvoiceService> InvoiceServiceImplementations;

	@PostMapping("/v1/invoices")
	public ResponseEntity generateInvoice(@RequestBody InvoiceRequest invoiceRequest) {

		InvoiceService invoiceService = InvoiceServiceImplementations.get(invoiceRequest.getTaxType().toLowerCase());

		Invoice invoice = invoiceService.createInvoice(invoiceRequest);

		int invoiceId = invoice.getInvoiceId();
		System.out.println("Returning only ID: " + invoiceId); // Check your console logs

		return ResponseEntity.ok(invoiceId);
	}

	@GetMapping("/v1/invoices")
	public List<Invoice> getAllInvoices() {
		
		List<Invoice> allInvoices = new ArrayList<>();

		for(InvoiceService invoiceService : InvoiceServiceImplementations.values()) {
			List<Invoice> invoicesFromService = invoiceService.getAllInvoices();
			allInvoices.addAll(invoicesFromService);
		}
		
		return allInvoices;
	}

	@GetMapping("/v1/invoices/{invoiceId}")
	public ResponseEntity getOneInvoice(@PathVariable() int invoiceId) {

		Optional<Invoice> foundInvoice = null;
		
		for(InvoiceService invoiceService : InvoiceServiceImplementations.values()) {
			
			foundInvoice = invoiceService.getInvoice(invoiceId);
			
		}
		
		if (foundInvoice != null) {
            return ResponseEntity.ok(foundInvoice);
        } else {
            // Return 404 Not Found if no service has the invoice
            return ResponseEntity.notFound().build();
        }
	}
	
	@PutMapping("/v1/invoices/{invoiceId}")
	public ResponseEntity updateInvoice(@PathVariable() int invoiceId, @RequestBody InvoiceRequest invoiceRequest) {
		
				
		InvoiceService invoiceService = InvoiceServiceImplementations.get(invoiceRequest.getTaxType());
		
		Optional<Invoice> updatedInvoice = invoiceService.updateInvoice(invoiceId, invoiceRequest);
				
		return ResponseEntity.ok(updatedInvoice);
		
	}
	
	
	@DeleteMapping("/v1/invoices/{invoiceId}")
	public ResponseEntity deleteInvoice(@PathVariable() int invoiceId) {
		
		InvoiceService invoiceService = InvoiceServiceImplementations.get("gst");
		
		boolean res = invoiceService.deleteInvoice(invoiceId);
				
		return ResponseEntity.ok(res);
		
	}

	
}
