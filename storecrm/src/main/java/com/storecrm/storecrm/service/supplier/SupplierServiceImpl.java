package com.storecrm.storecrm.service.supplier;

import com.storecrm.storecrm.dto.supplier.SupplierDTO;
import com.storecrm.storecrm.mapper.supplier.SupplierMapper;
import com.storecrm.storecrm.model.supplier.Supplier;
import com.storecrm.storecrm.repository.supplier.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private static final String SUPPLIER_NOT_FOUND = "Supplier not found with id: ";
    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    @Override
    public SupplierDTO.SupplierResponse getSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(SUPPLIER_NOT_FOUND + id));
        return supplierMapper.toResponseDTO(supplier);
    }

    @Override
    public List<SupplierDTO.SupplierResponse> getAllSuppliers() {
        return supplierRepository.findAll().stream()
                .map(supplierMapper::toResponseDTO)
                .toList();
    }

    @Override
    public SupplierDTO.SupplierResponse createSupplier(SupplierDTO.Create createDTO) {
        Supplier supplier = supplierMapper.toEntity(createDTO);
        Supplier savedSupplier = supplierRepository.save(supplier);
        return supplierMapper.toResponseDTO(savedSupplier);
    }

    @Override
    public void deleteSupplier(Long id) {
        if (!supplierRepository.existsById(id)) {
            throw new EntityNotFoundException(SUPPLIER_NOT_FOUND + id);
        }
        supplierRepository.deleteById(id);
    }
}
