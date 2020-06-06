package com.example.demo.Repository;

import com.example.demo.Entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<Files,String> {
}
