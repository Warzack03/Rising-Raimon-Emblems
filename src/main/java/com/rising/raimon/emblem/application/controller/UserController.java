package com.rising.raimon.emblem.application.controller;

import com.rising.raimon.emblem.domain.model.UserDTO;
import com.rising.raimon.emblem.domain.model.exception.RisingRaimonException;
import com.rising.raimon.emblem.domain.usecases.UserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User Controller", description = "API endpoints for manage user actions.")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping(path = "${com.rising.raimon.emblem.service.name}" + "${com.rising.raimon.emblem.user.controller.name}")
public class UserController {

    private final UserUseCase userUseCase;

    @Operation(summary = "Endpoint to add or modify user")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/create", headers = "Accept=application/json")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO request) throws RisingRaimonException {
        log.info("UserController::createUser()");
        return new ResponseEntity<>(userUseCase.createUser(request), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint to delete user")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(headers = "Accept=application/json")
    public void deleteUser(@RequestParam int userId) throws RisingRaimonException {
        log.info("UserController::deleteUser()");
        userUseCase.deleteUser(userId);
    }

    @Operation(summary = "Endpoint to get user by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/id", headers = "Accept=application/json")
    public ResponseEntity<UserDTO> getUserById(@RequestParam int userId) throws RisingRaimonException {
        log.info("UserController::getUserById()");
        return new ResponseEntity<>(userUseCase.getUserById(userId), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint to get all users")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/all", headers = "Accept=application/json")
    public ResponseEntity<List<UserDTO>> getUsers() throws RisingRaimonException {
        log.info("UserController::getUsers()");
        return new ResponseEntity<>(userUseCase.getUsers(), HttpStatus.OK);
    }
}
