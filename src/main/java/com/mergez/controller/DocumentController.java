package com.mergez.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mergez.entity.DocumentEsprit;
import com.mergez.service.DocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
@Slf4j
public class DocumentController {

    private final DocumentService service;

    @GetMapping
    public ResponseEntity<?> getAllDocuments() {
        try {
            log.info("Fetching all documents...");
            List<DocumentEsprit> documents = service.getAllDocuments();
            log.info("Found {} documents", documents.size());
            return ResponseEntity.ok(documents);
        } catch (Exception e) {
            log.error("Error fetching documents: ", e);
            throw e; // Let GlobalExceptionHandler handle it
        }
    }

}