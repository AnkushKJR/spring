package com.zepto.invoice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zepto.invoice.entity.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Integer>{

}
