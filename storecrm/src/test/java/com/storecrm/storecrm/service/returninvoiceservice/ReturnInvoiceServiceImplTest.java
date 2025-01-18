package com.storecrm.storecrm.service.returninvoiceservice;

import com.storecrm.storecrm.dto.returninvoice.ReturnInvoiceDTO;
import com.storecrm.storecrm.exception.ResourceNotFoundException;
import com.storecrm.storecrm.mapper.returninvoise.ReturnInvoiceMapper;
import com.storecrm.storecrm.model.returninvoise.ReturnInvoice;
import com.storecrm.storecrm.repository.returninvoicerepository.ReturnInvoiceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ReturnInvoiceServiceImpl class.
 */
@ExtendWith(MockitoExtension.class)
class ReturnInvoiceServiceImplTest {

    @Mock
    private ReturnInvoiceRepository returnInvoiceRepository;

    @Mock
    private ReturnInvoiceMapper returnInvoiceMapper;

    @InjectMocks
    private ReturnInvoiceServiceImpl returnInvoiceService;

    private ReturnInvoice returnInvoice;
    private ReturnInvoiceDTO returnInvoiceDTO;

    @BeforeEach
    public void setUp() {
        returnInvoice = new ReturnInvoice();
        returnInvoice.setId(1L);
        // Set other fields of the ReturnInvoice if needed

        returnInvoiceDTO = new ReturnInvoiceDTO();
        returnInvoiceDTO.setId(1L);
        // Set other fields of ReturnInvoiceDTO if needed
    }

    @Test
    public void testGetReturnInvoiceById_Success() {
        // Given
        when(returnInvoiceRepository.findById(1L)).thenReturn(Optional.of(returnInvoice));
        when(returnInvoiceMapper.toDto(returnInvoice)).thenReturn(returnInvoiceDTO);

        // When
        ReturnInvoiceDTO result = returnInvoiceService.getReturnInvoiceById(1L);

        // Then
        assertNotNull(result);
        assertEquals(returnInvoiceDTO.getId(), result.getId());
        verify(returnInvoiceRepository, times(1)).findById(1L);
        verify(returnInvoiceMapper, times(1)).toDto(returnInvoice);
    }

    @Test
    public void testGetReturnInvoiceById_NotFound() {
        // Given
        when(returnInvoiceRepository.findById(1L)).thenReturn(Optional.empty());

        // When & Then
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            returnInvoiceService.getReturnInvoiceById(1L);
        });

        assertEquals("ReturnInvoice not found with id: 1", exception.getMessage());
        verify(returnInvoiceRepository, times(1)).findById(1L);
    }

    @Test
    public void testCreateReturnInvoice() {
        // Given
        when(returnInvoiceMapper.toEntity(returnInvoiceDTO)).thenReturn(returnInvoice);
        when(returnInvoiceRepository.save(returnInvoice)).thenReturn(returnInvoice);
        when(returnInvoiceMapper.toDto(returnInvoice)).thenReturn(returnInvoiceDTO);

        // When
        ReturnInvoiceDTO result = returnInvoiceService.createReturnInvoice(returnInvoiceDTO);

        // Then
        assertNotNull(result);
        assertEquals(returnInvoiceDTO.getId(), result.getId());
        verify(returnInvoiceRepository, times(1)).save(returnInvoice);
        verify(returnInvoiceMapper, times(1)).toEntity(returnInvoiceDTO);
        verify(returnInvoiceMapper, times(1)).toDto(returnInvoice);
    }

    @Test
    public void testUpdateReturnInvoice_Success() {
        // Given
        when(returnInvoiceRepository.findById(1L)).thenReturn(Optional.of(returnInvoice));
        doNothing().when(returnInvoiceMapper).updateEntityFromDto(returnInvoiceDTO, returnInvoice);
        when(returnInvoiceRepository.save(returnInvoice)).thenReturn(returnInvoice);
        when(returnInvoiceMapper.toDto(returnInvoice)).thenReturn(returnInvoiceDTO);

        // When
        ReturnInvoiceDTO result = returnInvoiceService.updateReturnInvoice(1L, returnInvoiceDTO);

        // Then
        assertNotNull(result);
        assertEquals(returnInvoiceDTO.getId(), result.getId());
        verify(returnInvoiceRepository, times(1)).findById(1L);
        verify(returnInvoiceRepository, times(1)).save(returnInvoice);
        verify(returnInvoiceMapper, times(1)).updateEntityFromDto(returnInvoiceDTO, returnInvoice);
        verify(returnInvoiceMapper, times(1)).toDto(returnInvoice);
    }



    @Test
    public void testDeleteReturnInvoice_Success() {
        // Given
        when(returnInvoiceRepository.findById(1L)).thenReturn(Optional.of(returnInvoice));
        doNothing().when(returnInvoiceRepository).delete(returnInvoice);  // Используем doNothing для void метода

        // When
        returnInvoiceService.deleteReturnInvoice(1L);

        // Then
        verify(returnInvoiceRepository, times(1)).delete(returnInvoice);
    }

    @Test
    public void testDeleteReturnInvoice_NotFound() {
        // Given
        when(returnInvoiceRepository.findById(1L)).thenReturn(Optional.empty());

        // When & Then
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            returnInvoiceService.deleteReturnInvoice(1L);
        });

        assertEquals("ReturnInvoice not found with id: 1", exception.getMessage());
        verify(returnInvoiceRepository, times(1)).findById(1L);
    }
}
