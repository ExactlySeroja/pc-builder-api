package com.seroja.pcbuilderapp.repo;

import com.seroja.pcbuilderapp.entities.Drive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriveRepository extends JpaRepository<Drive, Integer> {
}
