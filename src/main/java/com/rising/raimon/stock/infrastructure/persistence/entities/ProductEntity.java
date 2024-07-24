package com.rising.raimon.stock.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stock")
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "total_amount", nullable = false)
    private int totalAmount;
    @Column(name = "actual_stock", nullable = false)
    private int actualStock;
    @Column(name = "cost_price", nullable = false)
    private Double costPrice;
    @Column(name = "sell_price", nullable = false)
    private Double sellPrice;

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", totalAmount=" + totalAmount +
                ", actualStock=" + actualStock +
                ", costPrice=" + costPrice +
                ", sellPrice=" + sellPrice +
                '}';
    }
}
