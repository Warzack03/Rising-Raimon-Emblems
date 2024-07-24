package com.rising.raimon.stock.application.controller;

import com.rising.raimon.stock.application.model.request.ProductSoldInTimeRequestDTO;
import com.rising.raimon.stock.domain.model.exception.RisingRaimonException;
import com.rising.raimon.stock.domain.usecases.ProductUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Date Controller", description = "API endpoints for manage date actions.")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping(path = "${com.rising.raimon.stock.service.name}" + "${com.rising.raimon.stock.date.controller.name}")
public class DateController {

    private final ProductUseCase productUseCase;

    @Operation(summary = "Endpoint to know how many products have sold between 2 dates")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(headers = "Accept=application/json")
    public ResponseEntity<Integer> productSoldBetweenDate(@RequestBody ProductSoldInTimeRequestDTO request) throws RisingRaimonException {
        log.info("DateController::productSoldBetweenDate() of type: {}", request.getProductType());
        return new ResponseEntity<>(productUseCase.productsSoldBetweenDates(request), HttpStatus.OK);
    }
}
