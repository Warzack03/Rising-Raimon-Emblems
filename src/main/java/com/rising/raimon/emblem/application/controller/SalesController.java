package com.rising.raimon.emblem.application.controller;

import com.rising.raimon.emblem.application.model.request.SaleRequestDTO;
import com.rising.raimon.emblem.domain.model.SaleDTO;
import com.rising.raimon.emblem.domain.model.exception.RisingRaimonException;
import com.rising.raimon.emblem.domain.usecases.SaleUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Sale Controller", description = "API endpoints for manage sale actions.")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping(path = "${com.rising.raimon.emblem.service.name}" + "${com.rising.raimon.emblem.sale.controller.name}")
public class SalesController {

    private final SaleUseCase saleUseCase;

    @Operation(summary = "Endpoint to add or modify sale")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/create", headers = "Accept=application/json")
    public ResponseEntity<SaleDTO> createSale(@RequestBody SaleRequestDTO request) throws RisingRaimonException {
        log.info("SaleController::createSale()");
        return new ResponseEntity<>(saleUseCase.createSale(request), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint to delete sale")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(headers = "Accept=application/json")
    public void deleteSale(@RequestParam int saleId) throws RisingRaimonException {
        log.info("SaleController::deleteSale()");
        saleUseCase.deleteSale(saleId);
    }

    @Operation(summary = "Endpoint to get sale by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/id", headers = "Accept=application/json")
    public ResponseEntity<SaleDTO> getSaleById(@RequestParam int saleId) throws RisingRaimonException {
        log.info("SaleController::getSaleById()");
        return new ResponseEntity<>(saleUseCase.getSaleById(saleId), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint to get all sales")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/all", headers = "Accept=application/json")
    public ResponseEntity<List<SaleDTO>> getSales() throws RisingRaimonException {
        log.info("SaleController::getSales()");
        return new ResponseEntity<>(saleUseCase.getSales(), HttpStatus.OK);
    }
}
