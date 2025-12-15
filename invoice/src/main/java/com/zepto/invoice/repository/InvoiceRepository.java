package com.zepto.invoice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zepto.invoice.entity.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Integer>{

	//method derivation query (when the default provided methods are not sufficient)
	//return type methodName(- -)
	//Invoice findInvoiceByInvoiceId(String invoiceId);
	//Naming convention to be followed for custom
	
	List<Invoice> findBySupplier(String supplier);
	
	List<Invoice> findBySupplierAndTaxLessThan(String supplier, Double tax);
	
	//----------------------------------------------
	
	//for complex scenarios [very big method name[5-6 conditions] or very complex scenario]
	//Named query
	
	List<Invoice> findByTaxType(String taxType);
	
	List<Invoice> SearchBySupplier(String supplier);
	
}
