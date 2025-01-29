package com.rising.raimon.emblem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewsletterSubscriptionDTO {

    private int id;
    private LocalDate startDate;
    private LocalDate expirationDate;
    private float cost;
    private UserDTO user;

}
