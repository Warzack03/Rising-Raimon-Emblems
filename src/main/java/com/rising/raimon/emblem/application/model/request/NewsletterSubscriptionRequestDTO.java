package com.rising.raimon.emblem.application.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewsletterSubscriptionRequestDTO {

    private int months;
    private float costs;
    private int userId;

}
