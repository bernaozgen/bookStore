package com.brnozgn.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brnozgn.entities.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {

}
