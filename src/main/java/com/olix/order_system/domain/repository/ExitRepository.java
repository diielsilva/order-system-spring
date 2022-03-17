package com.olix.order_system.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olix.order_system.domain.model.Exit;

@Repository
public interface ExitRepository extends JpaRepository<Exit, Long> {

}
