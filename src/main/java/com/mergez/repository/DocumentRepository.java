package com.mergez.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mergez.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}