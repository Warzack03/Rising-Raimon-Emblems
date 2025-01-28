package com.rising.raimon.emblem.infrastructure.persistence.repository;

import com.rising.raimon.emblem.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
