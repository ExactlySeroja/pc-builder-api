package com.seroja.pcbuilderapp.repos;

import com.seroja.pcbuilderapp.entities.Ram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RamRepository extends JpaRepository<Ram, Integer> {

    @Query(value = "select * from ram where (select max(price <= ?) and ram.type = ?)ORDER BY price LIMIT 1 ", nativeQuery = true)
    Ram getBudgetRam(int budgetPart, String type);

}
