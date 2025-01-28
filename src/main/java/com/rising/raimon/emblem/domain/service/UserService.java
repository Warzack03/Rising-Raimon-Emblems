package com.rising.raimon.emblem.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rising.raimon.emblem.domain.model.UserDTO;
import com.rising.raimon.emblem.domain.model.exception.RisingRaimonException;
import com.rising.raimon.emblem.domain.usecases.UserUseCase;
import com.rising.raimon.emblem.infrastructure.persistence.entities.UserEntity;
import com.rising.raimon.emblem.infrastructure.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserUseCase {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    private static final String NO_USER_FOUND_ERROR = "No user found";

    @Override
    public UserDTO createUser(UserDTO request) throws RisingRaimonException {
        try {
            UserEntity entitySaved = userRepository.save(objectMapper.convertValue(request, UserEntity.class));
            return objectMapper.convertValue(entitySaved, UserDTO.class);
        } catch (Exception e) {
            log.error("Error while saving user -> {}", e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public void deleteUser(int userId) throws RisingRaimonException {
        try {
            userRepository.deleteById(userId);
        } catch (Exception e) {
            log.error("Error while deleting user -> {}", e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public UserDTO getUserById(int userId) throws RisingRaimonException {
        try {
            Optional<UserEntity> optionalUser = userRepository.findById(userId);
            if (optionalUser.isEmpty()) {
                throw new RisingRaimonException(NO_USER_FOUND_ERROR);
            }
            return objectMapper.convertValue(optionalUser.get(), UserDTO.class);
        } catch (Exception e) {
            log.error("Error while getting user -> {}", e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }

    @Override
    public List<UserDTO> getUsers() throws RisingRaimonException {
        try {
            List<UserEntity> users = userRepository.findAll();
            if (users.isEmpty()) {
                throw new RisingRaimonException(NO_USER_FOUND_ERROR);
            }
            return users.stream().map(userEntity -> objectMapper.convertValue(userEntity, UserDTO.class)).toList();
        } catch (Exception e) {
            log.error("Error while getting user -> {}", e.getMessage());
            throw new RisingRaimonException(e.getMessage());
        }
    }
}
