package com.seroja.pcbuilderapp.repos;

import com.seroja.pcbuilderapp.entities.Motherboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MotherboardRepository extends JpaRepository<Motherboard, Integer> {
    @Query(value = "select * from motherboards where (select max(price <= ?1)) ORDER BY price LIMIT 1", nativeQuery = true)
    Motherboard getBudgetMotherboard(int budgetPart);

}
