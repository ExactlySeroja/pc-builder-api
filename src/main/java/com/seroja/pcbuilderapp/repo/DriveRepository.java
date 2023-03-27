package com.seroja.pcbuilderapp.repo;

import com.seroja.pcbuilderapp.entities.Drive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriveRepository extends JpaRepository<Drive, Integer> {

    @Query(value = "select * from drives where (select max(price <= ?)) ORDER BY price LIMIT 1", nativeQuery = true)
    Drive getBudgetDrive(int budgetPart);

}
