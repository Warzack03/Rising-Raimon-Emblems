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

@Tag(name = "Fan Shirts Controller", description = "API endpoints for manage fan shirts actions.")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping(path = "${com.rising.raimon.stock.service.name}" + "${com.rising.raimon.stock.fan-shirts.controller.name}")
public class FanShirtsController {

    private final ProductUseCase productUseCase;
    private final ProductTypeEnum productType = ProductTypeEnum.FAN_SHIRTS;

    @Operation(summary = "Endpoint to buy fan shirts")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(headers = "Accept=application/json")
    public ResponseEntity<Void> buyProducts(@RequestParam(value = "amount") int amount) throws RisingRaimonException {
        log.info("FanShirtsController::buyProducts() of type: {}, total of: {}", productType, amount);
        productUseCase.buyProduct(productType, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Endpoint to sell a fan shirts")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(headers = "Accept=application/json")
    public ResponseEntity<Void> sellProducts(@RequestParam(value = "amount") int amount) throws RisingRaimonException {
        log.info("FanShirtsController::sellProducts() of type: {}, total of: {}", productType, amount);
        productUseCase.sellProduct(productType, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
