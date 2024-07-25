package com.rising.raimon.stock.application.controller;

import com.rising.raimon.stock.domain.model.enums.ProductTypeEnum;
import com.rising.raimon.stock.domain.model.exception.RisingRaimonException;
import com.rising.raimon.stock.domain.usecases.PricesUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Prices Controller", description = "API endpoints for manage prices actions.")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping(path = "${com.rising.raimon.stock.service.name}" + "${com.rising.raimon.stock.prices.controller.name}")
public class PricesController {

    private final PricesUseCase pricesUseCase;

    @Operation(summary = "Endpoint to set the cost price of a product")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/cost-price", headers = "Accept=application/json")
    public ResponseEntity<Void> addCostPriceOfProduct(
            @RequestParam(value = "productType") ProductTypeEnum productType,
            @RequestParam(value = "price") Double price
    ) throws RisingRaimonException {
        log.info("PricesController::addCostPriceOfProduct() to product: {}", productType);
        pricesUseCase.addCostPrice(productType, price);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Endpoint to set the sell price of a product")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/sell-price", headers = "Accept=application/json")
    public ResponseEntity<Void> addSellPriceOfProduct(
            @RequestParam(value = "productType") ProductTypeEnum productType,
            @RequestParam(value = "price") Double price
    ) throws RisingRaimonException {
        log.info("PricesController::addSellPriceOfProduct() to product: {}", productType);
        pricesUseCase.addSellPrice(productType, price);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
