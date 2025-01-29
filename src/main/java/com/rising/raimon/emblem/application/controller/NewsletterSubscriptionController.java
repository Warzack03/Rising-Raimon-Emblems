package com.rising.raimon.emblem.application.controller;

import com.rising.raimon.emblem.application.model.request.NewsletterSubscriptionRequestDTO;
import com.rising.raimon.emblem.domain.model.NewsletterSubscriptionDTO;
import com.rising.raimon.emblem.domain.model.exception.RisingRaimonException;
import com.rising.raimon.emblem.domain.usecases.NewsletterSubscriptionUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Newsletter Subscription Controller", description = "API endpoints for manage newsletter subscriptions actions.")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping(path = "${com.rising.raimon.emblem.service.name}" + "${com.rising.raimon.emblem.newslleter-subscription.controller.name}")
public class NewsletterSubscriptionController {

    private final NewsletterSubscriptionUseCase newsletterSubscriptionUseCase;

    @Operation(summary = "Endpoint to add newsletter subscription")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/create", headers = "Accept=application/json")
    public ResponseEntity<NewsletterSubscriptionDTO> createNewsletterSubscription(@RequestBody NewsletterSubscriptionRequestDTO request) throws RisingRaimonException {
        log.info("NewsletterSubscriptionController::createNewsletterSubscription()");
        return new ResponseEntity<>(newsletterSubscriptionUseCase.createNewsletterSubscription(request), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint to add more months newsletter subscription")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/add-months", headers = "Accept=application/json")
    public ResponseEntity<NewsletterSubscriptionDTO> addMonthsIntoNewsletterSubscription(@RequestParam int userId, @RequestParam int moths) throws RisingRaimonException {
        log.info("NewsletterSubscriptionController::addMonthsIntoNewsletterSubscription()");
        return new ResponseEntity<>(newsletterSubscriptionUseCase.addMonthsIntoNewsletterSubscription(userId, moths), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint to get newsletter subscription by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/id", headers = "Accept=application/json")
    public ResponseEntity<NewsletterSubscriptionDTO> getNewsletterSubscriptionById(@RequestParam int newsletterSubscriptionId) throws RisingRaimonException {
        log.info("NewsletterSubscriptionController::getNewsletterSubscriptionById()");
        return new ResponseEntity<>(newsletterSubscriptionUseCase.getNewsletterSubscriptionById(newsletterSubscriptionId), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint to get newsletter subscription by user id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user-id", headers = "Accept=application/json")
    public ResponseEntity<NewsletterSubscriptionDTO> getNewsletterSubscriptionByUserId(@RequestParam int userId) throws RisingRaimonException {
        log.info("NewsletterSubscriptionController::getNewsletterSubscriptionByUserId()");
        return new ResponseEntity<>(newsletterSubscriptionUseCase.getNewsletterSubscriptionByUserId(userId), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint to get all in-active newsletter subscriptions")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/in-actives", headers = "Accept=application/json")
    public ResponseEntity<List<NewsletterSubscriptionDTO>> getInactiveNewsletterSubscriptions() throws RisingRaimonException {
        log.info("NewsletterSubscriptionController::getInactiveNewsletterSubscriptions()");
        return new ResponseEntity<>(newsletterSubscriptionUseCase.getInactiveNewsletterSubscriptions(), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint to get all active newsletter subscriptions")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/actives", headers = "Accept=application/json")
    public ResponseEntity<List<NewsletterSubscriptionDTO>> getActiveNewsletterSubscriptions() throws RisingRaimonException {
        log.info("NewsletterSubscriptionController::getActiveNewsletterSubscriptions()");
        return new ResponseEntity<>(newsletterSubscriptionUseCase.getActiveNewsletterSubscriptions(), HttpStatus.OK);
    }
}
