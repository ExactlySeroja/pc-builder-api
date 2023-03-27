package com.seroja.pcbuilderapp.service;

import com.seroja.pcbuilderapp.dto.AssembledDto;
import com.seroja.pcbuilderapp.dto.PcBudgetRequest;
import com.seroja.pcbuilderapp.entities.Assembled;
import com.seroja.pcbuilderapp.entities.Motherboard;
import com.seroja.pcbuilderapp.mapper.AssembledMapper;
import com.seroja.pcbuilderapp.repo.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AssembledService {
    private final AssembledRepository repo;
    private final MotherboardRepository mRepo;
    private final CaseRepository caseRepo;
    private final CpuRepository cpuRepo;
    private final DriveRepository driveRepo;
    private final GpuRepository gpuRepo;
    private final PowerUnitRepository puRepo;
    private final RamRepository ramRepo;
    private final AssembledMapper assembledMapper;

    public Assembled save(Assembled assembled) {
        return repo.save(assembled);
    }
    public Assembled saveDto(AssembledDto dto) {
        return repo.save(assembledMapper.toAssembled(dto));
    }
    public Assembled get(int id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Something wrong"));
    }
    public List<AssembledDto> getAll() {
        List<Assembled> assembledList = repo.findAll();
        return assembledMapper.toDTOList(assembledList);
    }
    public void delete(int id) {
        repo.deleteById(id);
    }

    public int calculateTotalPrice(int id) {
        return repo.calculateTotalPrice(id);
    }

    public Assembled pickUpPcByBudget(PcBudgetRequest pcBudgetRequest) {
        int budgetPart = pcBudgetRequest.budget() / 7;
        Motherboard motherboard = mRepo.getBudgetMotherboard(budgetPart);

        return Assembled.builder()
                .motherboard(motherboard)
                .gpu(gpuRepo.getBudgetGpu(budgetPart * 2))
                .cpu(cpuRepo.getBudgetCpu(budgetPart, motherboard.getSocket()))
                .ram(ramRepo.getBudgetRam(budgetPart / pcBudgetRequest.ramAmount(), motherboard.getRamSlot()))
                .powerUnit(puRepo.getBudgetPowerUnit(budgetPart))
                .caseField(caseRepo.getBudgetCase(budgetPart / 2))
                .drive(driveRepo.getBudgetDrive((budgetPart / 2) / pcBudgetRequest.drivesAmount()))
                .ramAmount(pcBudgetRequest.ramAmount())
                .drivesAmount(pcBudgetRequest.drivesAmount()).build();
    }

    public void updateDto(AssembledDto assembledDto, int id) {
        Assembled existAssembled = get(id);
        Assembled update = assembledMapper.toAssembled(assembledDto);
        assembledMapper.update(existAssembled, update);
        repo.save(existAssembled);
    }
}
