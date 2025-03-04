package com.storecrm.storecrm.service.returnservice;
import com.storecrm.storecrm.model.returninvoise.ReturnInvoice;
import com.storecrm.storecrm.repository.returninvoicerepository.ReturnInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReturnServiceImpl implements ReturnService {

    private final ReturnInvoiceRepository returnInvoiceRepository;

    @Autowired
    public ReturnServiceImpl(ReturnInvoiceRepository returnInvoiceRepository) {
        this.returnInvoiceRepository = returnInvoiceRepository;
    }

    @Override
    public List<ReturnInvoice> getAllReturns() {
        return returnInvoiceRepository.findAll();
    }

    @Override
    public Optional<ReturnInvoice> getReturnById(Long id) {
        return returnInvoiceRepository.findById(id);
    }

    @Override
    public ReturnInvoice createReturn(ReturnInvoice returnInvoice) {
        return returnInvoiceRepository.save(returnInvoice);
    }

    @Override
    public ReturnInvoice updateReturn(ReturnInvoice returnInvoice) {
        if (returnInvoice.getId() == null || !returnInvoiceRepository.existsById(returnInvoice.getId())) {
            throw new IllegalArgumentException("Return invoice does not exist");
        }
        return returnInvoiceRepository.save(returnInvoice);
    }

    @Override
    public void deleteReturn(Long id) {
        if (!returnInvoiceRepository.existsById(id)) {
            throw new IllegalArgumentException("Return invoice not found");
        }
        returnInvoiceRepository.deleteById(id);
    }
}
