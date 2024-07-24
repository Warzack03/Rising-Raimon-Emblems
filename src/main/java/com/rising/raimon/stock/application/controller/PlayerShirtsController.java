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

@Tag(name = "Player Shirts Controller", description = "API endpoints for manage player shirts actions.")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping(path = "${com.rising.raimon.stock.service.name}" + "${com.rising.raimon.stock.player-shirts.controller.name}")
public class PlayerShirtsController {

    private final ProductUseCase productUseCase;
    private final ProductTypeEnum productType = ProductTypeEnum.PLAYER_SHIRTS;

    @Operation(summary = "Endpoint to buy player shirts")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(headers = "Accept=application/json")
    public ResponseEntity<Void> buyProducts(@RequestParam(value = "amount") int amount) throws RisingRaimonException {
        log.info("PlayerShirtsController::buyProducts() of type: {}, total of: {}", productType, amount);
        productUseCase.buyProduct(productType, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Endpoint to sell a player shirts")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(headers = "Accept=application/json")
    public ResponseEntity<Void> sellProducts(@RequestParam(value = "amount") int amount) throws RisingRaimonException {
        log.info("PlayerShirtsController::sellProducts() of type: {}, total of: {}", productType, amount);
        productUseCase.sellProduct(productType, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
