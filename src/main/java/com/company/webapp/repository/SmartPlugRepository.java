package com.company.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.webapp.model.SmartPlug;

@Repository
public interface SmartPlugRepository extends JpaRepository<SmartPlug, Long> {}
