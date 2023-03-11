package com.seroja.pcbuilderapp.repo;

import com.seroja.pcbuilderapp.entities.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CpuRepository extends JpaRepository<Cpu, Integer> {
}
