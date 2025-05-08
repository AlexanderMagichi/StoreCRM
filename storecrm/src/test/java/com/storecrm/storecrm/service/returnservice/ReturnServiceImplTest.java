package com.storecrm.storecrm.service.returnservice;

import com.storecrm.storecrm.model.returninvoise.ReturnInvoice;
import com.storecrm.storecrm.repository.product.ProductRepository;
import com.storecrm.storecrm.repository.returninvoice.ReturnInvoiceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit test class for {@link ReturnServiceImpl}.
 * Uses Mockito to mock dependencies and test the service logic in isolation.
 */
@ExtendWith(MockitoExtension.class)
public class ReturnServiceImplTest {

    @Mock
    private ReturnInvoiceRepository returnInvoiceRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ReturnServiceImpl returnService;

    private ReturnInvoice returnInvoice;

    @BeforeEach
    public void setUp() {
        returnInvoice = ReturnInvoice.builder()
                .id(1L)
                .date(new Timestamp(System.currentTimeMillis()))
                .totalAmount(BigDecimal.valueOf(150.75))
                .status("Pending")
                .build();
    }

    @Test
    public void testGetAllReturns() {
        when(returnInvoiceRepository.findAll()).thenReturn(List.of(returnInvoice));

        var returns = returnService.getAllReturns();

        assertNotNull(returns);
        assertEquals(1, returns.size());
        assertEquals(returnInvoice, returns.get(0));
    }

    @Test
    public void testGetReturnById_Found() {
        when(returnInvoiceRepository.findById(1L)).thenReturn(Optional.of(returnInvoice));

        Optional<ReturnInvoice> foundReturn = returnService.getReturnById(1L);

        assertTrue(foundReturn.isPresent());
        assertEquals(returnInvoice, foundReturn.get());
    }

    @Test
    public void testGetReturnById_NotFound() {
        when(returnInvoiceRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<ReturnInvoice> foundReturn = returnService.getReturnById(1L);

        assertFalse(foundReturn.isPresent());
    }

    @Test
    public void testCreateReturn() {
        when(returnInvoiceRepository.save(returnInvoice)).thenReturn(returnInvoice);

        ReturnInvoice createdReturn = returnService.createReturn(returnInvoice);

        assertNotNull(createdReturn);
        assertEquals(returnInvoice, createdReturn);
    }

    @Test
    public void testUpdateReturn() {
        when(returnInvoiceRepository.existsById(1L)).thenReturn(true);
        when(returnInvoiceRepository.save(returnInvoice)).thenReturn(returnInvoice);

        ReturnInvoice updatedReturn = returnService.updateReturn(returnInvoice);

        assertNotNull(updatedReturn);
        assertEquals(returnInvoice, updatedReturn);
    }

    @Test
    public void testUpdateReturn_NotFound() {
        when(returnInvoiceRepository.existsById(1L)).thenReturn(false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            returnService.updateReturn(returnInvoice);
        });

        assertEquals("Return invoice does not exist", exception.getMessage());
    }

    @Test
    public void testDeleteReturn() {
        when(returnInvoiceRepository.existsById(1L)).thenReturn(true);

        returnService.deleteReturn(1L);

        verify(returnInvoiceRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteReturn_NotFound() {
        when(returnInvoiceRepository.existsById(1L)).thenReturn(false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            returnService.deleteReturn(1L);
        });

        assertEquals("Return invoice not found", exception.getMessage());
    }
}
