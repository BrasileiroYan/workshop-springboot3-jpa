package com.example.course.services;

import com.example.course.entities.User;
import com.example.course.repositories.UserRepository;
import com.example.course.services.exceptions.DataBaseException;
import com.example.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        return optionalUser.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        try {
            if (!userRepository.existsById(id)) {
                throw new ResourceNotFoundException(id);
            }
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }


    public User update(Long id, User updatedUser) {
        try{
            User entity = userRepository.getReferenceById(id);
            updateData(entity, updatedUser);

            return userRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User updatedUser) {
        entity.setName(updatedUser.getName());
        entity.setEmail(updatedUser.getEmail());
        entity.setPhone(updatedUser.getPhone());
    }

}
