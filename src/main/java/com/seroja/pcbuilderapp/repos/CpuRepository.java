package com.seroja.pcbuilderapp.repos;

import com.seroja.pcbuilderapp.entities.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CpuRepository extends JpaRepository<Cpu, Integer> {

    @Query(value = "select * from cpu where (select max(price <= ?) and cpu.socket = ?) ORDER BY price LIMIT 1", nativeQuery = true)
    Cpu getBudgetCpu(int budgetPart, String socket);
}
