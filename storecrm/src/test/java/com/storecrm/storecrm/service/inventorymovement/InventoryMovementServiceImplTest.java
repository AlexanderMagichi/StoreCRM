package com.storecrm.storecrm.service.inventorymovement;

import com.storecrm.storecrm.exception.InventoryMovementNotFoundException;
import com.storecrm.storecrm.model.inventorymovement.InventoryMovement;
import com.storecrm.storecrm.repository.inventorymovement.InventoryMovementRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InventoryMovementServiceImplTest {

    @Mock
    private InventoryMovementRepository inventoryMovementRepository;

    @InjectMocks
    private InventoryMovementServiceImpl inventoryMovementService;

    private InventoryMovement inventoryMovement;

    @BeforeEach
    void setUp() {
        inventoryMovement = InventoryMovement.builder()
                .id(1L)
                .productId(100L)
                .quantity(10)
                .movementType("IN")
                .build();
    }

    @Test
    void testGetAllMovements() {
        when(inventoryMovementRepository.findAll()).thenReturn(List.of(inventoryMovement));

        List<InventoryMovement> movements = inventoryMovementService.getAllMovements();

        assertThat(movements).isNotEmpty();
        assertThat(movements.size()).isEqualTo(1);
        verify(inventoryMovementRepository, times(1)).findAll();
    }

    @Test
    void testGetMovementById_Found() {
        when(inventoryMovementRepository.findById(1L)).thenReturn(Optional.of(inventoryMovement));

        Optional<InventoryMovement> foundMovement = inventoryMovementService.getMovementById(1L);

        assertThat(foundMovement).isPresent();
        assertThat(foundMovement.get().getId()).isEqualTo(1L);
        verify(inventoryMovementRepository, times(1)).findById(1L);
    }

    @Test
    void testGetMovementById_NotFound() {
        when(inventoryMovementRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<InventoryMovement> foundMovement = inventoryMovementService.getMovementById(1L);

        assertThat(foundMovement).isEmpty();
        verify(inventoryMovementRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateMovement() {
        when(inventoryMovementRepository.save(any(InventoryMovement.class))).thenReturn(inventoryMovement);

        InventoryMovement createdMovement = inventoryMovementService.createMovement(inventoryMovement);

        assertThat(createdMovement).isNotNull();
        assertThat(createdMovement.getId()).isEqualTo(1L);
        verify(inventoryMovementRepository, times(1)).save(inventoryMovement);
    }

    @Test
    void testUpdateMovement_Success() {
        when(inventoryMovementRepository.existsById(1L)).thenReturn(true);
        when(inventoryMovementRepository.save(any(InventoryMovement.class))).thenReturn(inventoryMovement);

        InventoryMovement updatedMovement = inventoryMovementService.updateMovement(1L, inventoryMovement);

        assertThat(updatedMovement).isNotNull();
        assertThat(updatedMovement.getId()).isEqualTo(1L);
        verify(inventoryMovementRepository, times(1)).existsById(1L);
        verify(inventoryMovementRepository, times(1)).save(inventoryMovement);
    }

    @Test
    void testUpdateMovement_NotFound() {
        when(inventoryMovementRepository.existsById(1L)).thenReturn(false);

        assertThrows(InventoryMovementNotFoundException.class, () -> inventoryMovementService.updateMovement(1L, inventoryMovement));

        verify(inventoryMovementRepository, times(1)).existsById(1L);
        verify(inventoryMovementRepository, never()).save(any(InventoryMovement.class));
    }

    @Test
    void testDeleteMovement() {
        doNothing().when(inventoryMovementRepository).deleteById(1L);

        inventoryMovementService.deleteMovement(1L);

        verify(inventoryMovementRepository, times(1)).deleteById(1L);
    }
}
