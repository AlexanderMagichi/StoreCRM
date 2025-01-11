package com.storecrm.storecrm.service.returninvoiceservice;


import com.storecrm.storecrm.dto.returninvoice.ReturnInvoiceDTO;

import java.util.List;

public interface ReturnInvoiceService {
    List<ReturnInvoiceDTO> getAllReturnInvoices();

    ReturnInvoiceDTO getReturnInvoiceById(Long id);

    ReturnInvoiceDTO createReturnInvoice(CreateReturnInvoiceDTO dto);

    ReturnInvoiceDTO updateReturnInvoice(Long id, UpdateReturnInvoiceDTO dto);

    void deleteReturnInvoice(Long id);
}
