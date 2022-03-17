package com.olix.order_system.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olix.order_system.domain.model.ExitItem;

@Repository
public interface ExitItemRepository extends JpaRepository<ExitItem, Long> {

}
