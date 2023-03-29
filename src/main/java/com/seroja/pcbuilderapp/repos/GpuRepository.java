package com.seroja.pcbuilderapp.repos;

import com.seroja.pcbuilderapp.entities.Gpu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GpuRepository extends JpaRepository<Gpu, Integer> {

    @Query(value = "select * from gpu where (select max(price <= ?)) ORDER BY price LIMIT 1", nativeQuery = true)
    Gpu getBudgetGpu(int budgetPart);

}
