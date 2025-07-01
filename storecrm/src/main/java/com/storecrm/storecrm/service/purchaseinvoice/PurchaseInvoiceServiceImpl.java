package com.storecrm.storecrm.service.purchaseinvoice;

import com.storecrm.storecrm.dto.purchaseinvoice.PurchaseInvoiceDTO;
import com.storecrm.storecrm.dto.purchaseinvoice.PurchaseInvoiceDTO.Create;
import com.storecrm.storecrm.dto.purchaseinvoice.PurchaseInvoiceDTO.Update;
import com.storecrm.storecrm.exception.EntityNotFoundException;
import com.storecrm.storecrm.model.purchaseinvoice.PurchaseInvoice;
import com.storecrm.storecrm.model.supplier.Supplier;
import com.storecrm.storecrm.model.user.User;
import com.storecrm.storecrm.repository.purchaseinvoice.PurchaseInvoiceRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PurchaseInvoiceServiceImpl implements PurchaseInvoiceService {

    private final PurchaseInvoiceRepository repository;

    @Override
    public List<PurchaseInvoiceDTO> getAllInvoices() {
        log.info("Fetching all purchase invoices");
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PurchaseInvoiceDTO getInvoiceById(Long id) {
        log.info("Fetching purchase invoice with ID: {}", id);
        return repository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Purchase invoice not found with ID: " + id));
    }

    @Override
    public PurchaseInvoiceDTO createInvoice(@Valid Create dto) {
        log.info("Creating new purchase invoice with data: {}", dto);
        PurchaseInvoice invoice = mapToEntity(dto);
        return mapToDTO(repository.save(invoice));
    }

    @Override
    public PurchaseInvoiceDTO updateInvoice(Long id, @Valid Update dto) {
        log.info("Updating purchase invoice with ID: {}", id);
        PurchaseInvoice existingInvoice = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Purchase invoice not found with ID: " + id));
        updateEntity(existingInvoice, dto);
        return mapToDTO(repository.save(existingInvoice));
    }

    @Override
    public void deleteInvoice(Long id) {
        log.info("Deleting purchase invoice with ID: {}", id);
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Purchase invoice not found with ID: " + id);
        }
        repository.deleteById(id);
    }

    private PurchaseInvoiceDTO mapToDTO(PurchaseInvoice invoice) {
        return new PurchaseInvoiceDTO(
                invoice.getId(),
                invoice.getDate().toLocalDateTime(),
                invoice.getSupplier().getId(),
                BigDecimal.valueOf(invoice.getTotalAmount()),
                invoice.getStatus(),
                invoice.getCreatedBy().getId()
        );
    }

    private PurchaseInvoice mapToEntity(Create dto) {
        return PurchaseInvoice.builder()
                .date(java.sql.Timestamp.valueOf(dto.getDate()))
                .supplier(Supplier.builder().id(dto.getSupplierId()).build())
                .totalAmount(dto.getTotalAmount().doubleValue())
                .status(dto.getStatus())
                .createdBy(User.builder().id(dto.getCreatedBy()).build())
                .build();
    }

    private void updateEntity(PurchaseInvoice invoice, Update dto) {
        invoice.setDate(java.sql.Timestamp.valueOf(dto.getDate()));
        invoice.setSupplier(Supplier.builder().id(dto.getSupplierId()).build());
        invoice.setTotalAmount(dto.getTotalAmount().doubleValue());
        invoice.setStatus(dto.getStatus());
        invoice.setCreatedBy(User.builder().id(dto.getCreatedBy()).build());
    }
}
