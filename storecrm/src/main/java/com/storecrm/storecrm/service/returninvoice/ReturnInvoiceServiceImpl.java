package com.storecrm.storecrm.service.returninvoice;

import com.storecrm.storecrm.dto.returninvoice.ReturnInvoiceDTO;
import com.storecrm.storecrm.exception.ResourceNotFoundException;
import com.storecrm.storecrm.mapper.returninvoise.ReturnInvoiceMapper;
import com.storecrm.storecrm.model.returninvoise.ReturnInvoice;
import com.storecrm.storecrm.repository.returninvoice.ReturnInvoiceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for handling return invoices.
 */
@Service
@AllArgsConstructor
@Slf4j
public class ReturnInvoiceServiceImpl implements ReturnInvoiceService {

    private final ReturnInvoiceRepository returnInvoiceRepository;
    private final ReturnInvoiceMapper returnInvoiceMapper;

    /**
     * Retrieves all return invoices.
     *
     * @return a list of ReturnInvoiceDTOs
     */
    @Override
    public List<ReturnInvoiceDTO> getAllReturnInvoices() {
        log.info("Fetching all return invoices");
        List<ReturnInvoice> returnInvoices = returnInvoiceRepository.findAll();
        return returnInvoiceMapper.toDtoList(returnInvoices);
    }

    /**
     * Retrieves a specific return invoice by its ID.
     *
     * @param id the ID of the return invoice
     * @return the corresponding ReturnInvoiceDTO
     * @throws ResourceNotFoundException if the return invoice with the given ID does not exist
     */
    @Override
    public ReturnInvoiceDTO getReturnInvoiceById(Long id) {
        log.info("Fetching return invoice with id: {}", id);
        ReturnInvoice returnInvoice = returnInvoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ReturnInvoice", "id", id));
        return returnInvoiceMapper.toDto(returnInvoice);
    }

    /**
     * Creates a new return invoice.
     *
     * @param returnInvoiceDTO the data to create a return invoice
     * @return the created ReturnInvoiceDTO
     */
    @Override
    public ReturnInvoiceDTO createReturnInvoice(ReturnInvoiceDTO returnInvoiceDTO) {
        log.info("Creating a new return invoice");
        ReturnInvoice returnInvoice = returnInvoiceMapper.toEntity(returnInvoiceDTO);
        ReturnInvoice savedReturnInvoice = returnInvoiceRepository.save(returnInvoice);
        return returnInvoiceMapper.toDto(savedReturnInvoice);
    }

    /**
     * Updates an existing return invoice.
     *
     * @param id               the ID of the return invoice to update
     * @param returnInvoiceDTO the updated data
     * @return the updated ReturnInvoiceDTO
     * @throws ResourceNotFoundException if the return invoice with the given ID does not exist
     */
    @Override
    public ReturnInvoiceDTO updateReturnInvoice(Long id, ReturnInvoiceDTO returnInvoiceDTO) {
        log.info("Updating return invoice with id: {}", id);
        ReturnInvoice existingReturnInvoice = returnInvoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ReturnInvoice", "id", id));
        returnInvoiceMapper.updateEntityFromDto(returnInvoiceDTO, existingReturnInvoice);
        ReturnInvoice updatedReturnInvoice = returnInvoiceRepository.save(existingReturnInvoice);
        return returnInvoiceMapper.toDto(updatedReturnInvoice);
    }

    /**
     * Deletes a return invoice by its ID.
     *
     * @param id the ID of the return invoice to delete
     * @throws ResourceNotFoundException if the return invoice with the given ID does not exist
     */
    @Override
    public void deleteReturnInvoice(Long id) {
        log.info("Deleting return invoice with id: {}", id);
        ReturnInvoice existingReturnInvoice = returnInvoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ReturnInvoice", "id", id));
        returnInvoiceRepository.delete(existingReturnInvoice);
    }
}
