package com.storecrm.storecrm.service.returninvoiceservice;


import com.storecrm.storecrm.dto.returninvoice.ReturnInvoiceDTO;
import com.storecrm.storecrm.exception.EntityNotFoundException;
import com.storecrm.storecrm.mapper.returninvoise.ReturnInvoiceMapper;
import com.storecrm.storecrm.model.returninvoise.ReturnInvoice;
import com.storecrm.storecrm.repository.returninvoise.ReturnInvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReturnInvoiceServiceImpl implements ReturnInvoiceService {

    private final ReturnInvoiceRepository repository;
    private final ReturnInvoiceMapper mapper;

    @Override
    public List<ReturnInvoiceDTO> getAllReturnInvoices() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public ReturnInvoiceDTO getReturnInvoiceById(Long id) {
        ReturnInvoice returnInvoice = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ReturnInvoice not found with id: " + id));
        return mapper.toDTO(returnInvoice);
    }

    @Override
    public ReturnInvoiceDTO createReturnInvoice(CreateReturnInvoiceDTO dto) {
        ReturnInvoice returnInvoice = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(returnInvoice));
    }

    @Override
    public ReturnInvoiceDTO updateReturnInvoice(Long id, UpdateReturnInvoiceDTO dto) {
        ReturnInvoice existingInvoice = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ReturnInvoice not found with id: " + id));

        mapper.updateEntity(existingInvoice, dto);
        return mapper.toDTO(repository.save(existingInvoice));
    }

    @Override
    public void deleteReturnInvoice(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("ReturnInvoice not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
