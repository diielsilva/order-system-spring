package com.olix.order_system.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olix.order_system.domain.model.Entry;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {

}
