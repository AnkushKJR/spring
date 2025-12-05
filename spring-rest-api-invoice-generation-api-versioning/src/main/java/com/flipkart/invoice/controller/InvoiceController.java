package com.flipkart.invoice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.invoice.entity.Invoice;
import com.flipkart.invoice.exception.EmptyItemNameException;
import com.flipkart.invoice.exception.InvalidPriceException;
import com.flipkart.invoice.request.InvoiceRequest;
import com.flipkart.invoice.response.InvoiceResponse;
import com.flipkart.invoice.service.InvoiceService;

@RestController
public class InvoiceController {
	
	@Autowired
	Map<String, InvoiceService> serviceMap;
	
	@PostMapping("/v1/invoice")
	public ResponseEntity generateV1(@RequestBody InvoiceRequest invoiceRequest) {
		System.out.println("InvoiceControllerV1.invoice()");
		if(invoiceRequest.getItemName() == null || invoiceRequest.getItemName().isEmpty()) {
	        throw new EmptyItemNameException("Item name must not be empty");
	    }

	    if(invoiceRequest.getPrice() == null || invoiceRequest.getPrice() <= 0) {
	        throw new InvalidPriceException("Price must be greater than 0");
	    }
		InvoiceService invoiceService = serviceMap.get("invoiceV1Service");
		Invoice invoice = invoiceService.generateInvoice(invoiceRequest.getItemName(), invoiceRequest.getDescription(), invoiceRequest.getPrice());
		
		InvoiceResponse response = new InvoiceResponse();
		
		response.setInvoiceId(invoice.getInvoiceId());
		response.setItemName(invoice.getItemName());
		response.setDescription(invoice.getDescription());
		response.setTotalPrice(invoice.getTotalPrice());
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/v2/invoice")
	public ResponseEntity generateV2(@RequestBody InvoiceRequest invoiceRequest) {
		System.out.println("InvoiceControllerV1.invoice()");
		if(invoiceRequest.getItemName() == null || invoiceRequest.getItemName().isEmpty()) {
	        throw new EmptyItemNameException("Item name must not be empty");
	    }

	    if(invoiceRequest.getPrice() == null || invoiceRequest.getPrice() <= 0) {
	        throw new InvalidPriceException("Price must be greater than 0");
	    }
		InvoiceService invoiceService = serviceMap.get("invoiceV2Service");
		Invoice invoice = invoiceService.generateInvoice(invoiceRequest.getItemName(), invoiceRequest.getDescription(), invoiceRequest.getPrice());
		
		InvoiceResponse response = new InvoiceResponse();
		
		response.setInvoiceId(invoice.getInvoiceId());
		response.setItemName(invoice.getItemName());
		response.setDescription(invoice.getDescription());
		response.setTotalPrice(invoice.getTotalPrice());
		
		return ResponseEntity.ok(response);
	}

}
