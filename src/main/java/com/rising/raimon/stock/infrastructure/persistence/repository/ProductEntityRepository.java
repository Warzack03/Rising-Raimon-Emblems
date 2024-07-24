package com.rising.raimon.stock.infrastructure.persistence.repository;

import com.rising.raimon.stock.infrastructure.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {

    ProductEntity findByType(String type);
}
