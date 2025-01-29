package com.rising.raimon.emblem.application.controller;

import com.rising.raimon.emblem.domain.model.EmblemDTO;
import com.rising.raimon.emblem.domain.model.enums.EmblemEnum;
import com.rising.raimon.emblem.domain.model.exception.RisingRaimonException;
import com.rising.raimon.emblem.domain.usecases.EmblemUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Emblem Controller", description = "API endpoints for manage emblems actions.")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping(path = "${com.rising.raimon.emblem.service.name}" + "${com.rising.raimon.emblem.emblem.controller.name}")
public class EmblemController {

    private final EmblemUseCase emblemUseCase;

    @Operation(summary = "Endpoint to add or modify emblem")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/create", headers = "Accept=application/json")
    public ResponseEntity<EmblemDTO> createEmblem(@RequestParam EmblemEnum request, @RequestParam int emblemId) throws RisingRaimonException {
        log.info("EmblemController::createEmblem()");
        return new ResponseEntity<>(emblemUseCase.createEmblem(request, emblemId), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint to delete emblem")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(headers = "Accept=application/json")
    public void deleteEmblem(@RequestParam int userId) throws RisingRaimonException {
        log.info("EmblemController::deleteEmblem()");
        emblemUseCase.deleteEmblem(userId);
    }

    @Operation(summary = "Endpoint to get user by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/id", headers = "Accept=application/json")
    public ResponseEntity<EmblemDTO> getEmblemById(@RequestParam int emblemId) throws RisingRaimonException {
        log.info("EmblemController::getEmblemById()");
        return new ResponseEntity<>(emblemUseCase.getEmblemById(emblemId), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint to get all users")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/all", headers = "Accept=application/json")
    public ResponseEntity<List<EmblemDTO>> getEmblems() throws RisingRaimonException {
        log.info("EmblemController::getEmblems()");
        return new ResponseEntity<>(emblemUseCase.getEmblems(), HttpStatus.OK);
    }
}
