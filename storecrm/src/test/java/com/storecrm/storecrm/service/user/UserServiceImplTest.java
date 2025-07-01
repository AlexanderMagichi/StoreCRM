package com.storecrm.storecrm.service.user;

import com.storecrm.storecrm.exception.UserNotFoundException;
import com.storecrm.storecrm.model.user.User;
import com.storecrm.storecrm.repository.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        user = User.builder()
                .id(1L)
                .username("johndoe")
                .passwordHash("$2a$10$abcdefg12345")
                .roleId(2L)
                .build();
    }

    @Test
    public void testGetAllUsers() {
        // Arrange
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));

        // Act
        var users = userService.getAllUsers();

        // Assert
        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals("johndoe", users.get(0).getUsername());
    }

    @Test
    public void testGetUserById_UserExists() {
        // Arrange
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        // Act
        var result = userService.getUserById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("johndoe", result.get().getUsername());
    }

    @Test
    public void testGetUserById_UserNotFound() {
        // Arrange
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        var result = userService.getUserById(1L);

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    public void testCreateUser() {
        // Arrange
        when(userRepository.save(user)).thenReturn(user);

        // Act
        var result = userService.createUser(user);

        // Assert
        assertNotNull(result);
        assertEquals("johndoe", result.getUsername());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testUpdateUser_UserExists() {
        // Arrange
        when(userRepository.existsById(1L)).thenReturn(true);
        when(userRepository.save(user)).thenReturn(user);

        // Act
        var result = userService.updateUser(1L, user);

        // Assert
        assertNotNull(result);
        assertEquals("johndoe", result.getUsername());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testUpdateUser_UserNotFound() {
        // Arrange
        when(userRepository.existsById(1L)).thenReturn(false);

        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> userService.updateUser(1L, user));
    }

    @Test
    public void testDeleteUser() {
        // Arrange
        doNothing().when(userRepository).deleteById(1L);

        // Act
        userService.deleteUser(1L);

        // Assert
        verify(userRepository, times(1)).deleteById(1L);
    }
}
