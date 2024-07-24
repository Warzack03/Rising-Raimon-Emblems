package com.rising.raimon.stock.application.controller;

import com.rising.raimon.stock.domain.model.enums.ProductTypeEnum;
import com.rising.raimon.stock.domain.model.exception.RisingRaimonException;
import com.rising.raimon.stock.domain.usecases.ProductUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Product Controller", description = "API endpoints for manage product generic actions.")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping(path = "${com.rising.raimon.stock.service.name}" + "${com.rising.raimon.stock.product.controller.name}")
public class ProductController {

    private final ProductUseCase productUseCase;

    @Operation(summary = "Endpoint to know how much money we have spent on a product")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/spent", headers = "Accept=application/json")
    public ResponseEntity<Double> totalSpentByProductType(@RequestParam(value = "productType") ProductTypeEnum productType) throws RisingRaimonException {
        log.info("ProductController::totalSpentOn() of type: {}", productType);
        return new ResponseEntity<>(productUseCase.totalSpentByProductType(productType), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint to know how much money we have earned on a product")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/earned", headers = "Accept=application/json")
    public ResponseEntity<Double> totalEarnedByProductType(@RequestParam(value = "productType") ProductTypeEnum productType) throws RisingRaimonException {
        log.info("ProductController::totalEarnedByProductType() of type: {}", productType);
        return new ResponseEntity<>(productUseCase.totalEarnedByProductType(productType), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint to know how many products we have sold")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/products-sold", headers = "Accept=application/json")
    public ResponseEntity<Integer> productsSoldByProductType(@RequestParam(value = "productType") ProductTypeEnum productType) throws RisingRaimonException {
        log.info("ProductController::productsSoldByProductType() of type: {}", productType);
        return new ResponseEntity<>(productUseCase.productsSoldByProductType(productType), HttpStatus.OK);
    }
}
