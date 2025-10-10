package com.mergez.service;

import org.springframework.stereotype.Service;
import com.mergez.entity.DocumentEsprit;
import com.mergez.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository repository;

    public List<DocumentEsprit> getAllDocuments() {
        return repository.findAll();
    }

}