package com.storecrm.storecrm.service.userservice;

import com.storecrm.storecrm.exception.UserNotFoundException;
import com.storecrm.storecrm.model.user.User;
import com.storecrm.storecrm.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the UserService interface.
 * This class provides the actual logic for user management.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        throw new UserNotFoundException(id); // Throw exception if user not found
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
