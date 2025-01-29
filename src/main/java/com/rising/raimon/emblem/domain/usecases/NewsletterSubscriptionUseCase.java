package com.rising.raimon.emblem.domain.usecases;

import com.rising.raimon.emblem.application.model.request.NewsletterSubscriptionRequestDTO;
import com.rising.raimon.emblem.domain.model.NewsletterSubscriptionDTO;
import com.rising.raimon.emblem.domain.model.exception.RisingRaimonException;

import java.util.List;

public interface NewsletterSubscriptionUseCase {
    NewsletterSubscriptionDTO createNewsletterSubscription(NewsletterSubscriptionRequestDTO request) throws RisingRaimonException;

    NewsletterSubscriptionDTO addMonthsIntoNewsletterSubscription(int userId, int moths) throws RisingRaimonException;

    NewsletterSubscriptionDTO getNewsletterSubscriptionById(int newsletterSubscriptionId) throws RisingRaimonException;

    NewsletterSubscriptionDTO getNewsletterSubscriptionByUserId(int userId) throws RisingRaimonException;

    List<NewsletterSubscriptionDTO> getInactiveNewsletterSubscriptions() throws RisingRaimonException;
    List<NewsletterSubscriptionDTO> getActiveNewsletterSubscriptions() throws RisingRaimonException;
}
