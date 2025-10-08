package com.mergez.service;

import org.springframework.stereotype.Service;

import com.mergez.entity.Document;
import com.mergez.repository.DocumentRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository repository;

    public List<Document> getAllDocuments() {
        return repository.findAll();
    }

}