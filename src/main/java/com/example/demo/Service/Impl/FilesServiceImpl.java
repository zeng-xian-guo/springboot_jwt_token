package com.example.demo.Service.Impl;

import com.example.demo.Entity.Files;
import com.example.demo.Repository.FilesRepository;
import com.example.demo.Service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilesServiceImpl implements FilesService {
    @Autowired
    private FilesRepository filesRepository;

    @Override
    public List<Files> getFiles() {
        return filesRepository.findAll();
    }
}
