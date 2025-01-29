package com.rising.raimon.emblem.domain.usecases;

import com.rising.raimon.emblem.domain.model.UserDTO;
import com.rising.raimon.emblem.domain.model.exception.RisingRaimonException;

import java.util.List;

public interface UserUseCase {
    UserDTO createUser(UserDTO request) throws RisingRaimonException;
    void deleteUser(int userId) throws RisingRaimonException;
    UserDTO getUserById(int userId) throws RisingRaimonException;
    List<UserDTO> getUsers() throws RisingRaimonException;
}
