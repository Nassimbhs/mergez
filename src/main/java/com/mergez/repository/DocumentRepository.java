package com.mergez.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mergez.entity.DocumentEsprit;

public interface DocumentRepository extends JpaRepository<DocumentEsprit, Long> {
}