package com.storecrm.storecrm.service.returnservice;
import com.storecrm.storecrm.model.returninvoise.ReturnInvoice;
import com.storecrm.storecrm.repository.returninvoicerepository.ReturnInvoiceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Test class for {@link ReturnServiceImpl}.
 * Contains unit tests for the main methods of the service.
 */
@SpringBootTest
public class ReturnServiceImplTest {

    @Mock
    private ReturnInvoiceRepository returnInvoiceRepository;

    @InjectMocks
    private ReturnServiceImpl returnService;

    private ReturnInvoice returnInvoice;

    /**
     * Set up test data for each test method.
     */
    @BeforeEach
    public void setUp() {
        returnInvoice = ReturnInvoice.builder()
                .id(1L)
                .date(new Timestamp(System.currentTimeMillis()))
                .totalAmount(BigDecimal.valueOf(150.75))
                .status("Pending")
                .build();
    }

    /**
     * Test the method {@link ReturnServiceImpl#getAllReturns()}.
     */
    @Test
    public void testGetAllReturns() {
        when(returnInvoiceRepository.findAll()).thenReturn(List.of(returnInvoice));

        var returns = returnService.getAllReturns();

        assertNotNull(returns);
        assertEquals(1, returns.size());
        assertEquals(returnInvoice, returns.get(0));
    }

    /**
     * Test the method {@link ReturnServiceImpl#getReturnById(Long)} when return is found.
     */
    @Test
    public void testGetReturnById_Found() {
        when(returnInvoiceRepository.findById(1L)).thenReturn(Optional.of(returnInvoice));

        Optional<ReturnInvoice> foundReturn = returnService.getReturnById(1L);

        assertTrue(foundReturn.isPresent());
        assertEquals(returnInvoice, foundReturn.get());
    }

    /**
     * Test the method {@link ReturnServiceImpl#getReturnById(Long)} when return is not found.
     */
    @Test
    public void testGetReturnById_NotFound() {
        when(returnInvoiceRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<ReturnInvoice> foundReturn = returnService.getReturnById(1L);

        assertFalse(foundReturn.isPresent());
    }

    /**
     * Test the method {@link ReturnServiceImpl#createReturn(ReturnInvoice)}.
     */
    @Test
    public void testCreateReturn() {
        when(returnInvoiceRepository.save(returnInvoice)).thenReturn(returnInvoice);

        ReturnInvoice createdReturn = returnService.createReturn(returnInvoice);

        assertNotNull(createdReturn);
        assertEquals(returnInvoice, createdReturn);
    }

    /**
     * Test the method {@link ReturnServiceImpl#updateReturn(ReturnInvoice)} when return exists.
     */
    @Test
    public void testUpdateReturn() {
        when(returnInvoiceRepository.existsById(1L)).thenReturn(true);
        when(returnInvoiceRepository.save(returnInvoice)).thenReturn(returnInvoice);

        ReturnInvoice updatedReturn = returnService.updateReturn(returnInvoice);

        assertNotNull(updatedReturn);
        assertEquals(returnInvoice, updatedReturn);
    }

    /**
     * Test the method {@link ReturnServiceImpl#updateReturn(ReturnInvoice)} when return does not exist.
     */
    @Test
    public void testUpdateReturn_NotFound() {
        when(returnInvoiceRepository.existsById(1L)).thenReturn(false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            returnService.updateReturn(returnInvoice);
        });

        assertEquals("Return invoice does not exist", exception.getMessage());
    }

    /**
     * Test the method {@link ReturnServiceImpl#deleteReturn(Long)} when return exists.
     */
    @Test
    public void testDeleteReturn() {
        when(returnInvoiceRepository.existsById(1L)).thenReturn(true);

        returnService.deleteReturn(1L);

        verify(returnInvoiceRepository, times(1)).deleteById(1L);
    }

    /**
     * Test the method {@link ReturnServiceImpl#deleteReturn(Long)} when return does not exist.
     */
    @Test
    public void testDeleteReturn_NotFound() {
        when(returnInvoiceRepository.existsById(1L)).thenReturn(false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            returnService.deleteReturn(1L);
        });

        assertEquals("Return invoice not found", exception.getMessage());
    }
}
