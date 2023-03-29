package com.seroja.pcbuilderapp.service;

import com.seroja.pcbuilderapp.dto.CaseDto;
import com.seroja.pcbuilderapp.entities.Case;
import com.seroja.pcbuilderapp.mapper.CaseMapper;
import com.seroja.pcbuilderapp.repos.CaseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CaseService {
    private final CaseRepository repo;
    private final CaseMapper caseMapper;

    public List<CaseDto> listAll() {
        return caseMapper.toDTOList(repo.findAll());
    }

    public CaseDto save(CaseDto pcCaseDto) {
        return caseMapper.toDto(repo.save(caseMapper.toCase(pcCaseDto)));
    }

    private Case get(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Case was not found!"));
    }

    public CaseDto getDto(int id) {
        return caseMapper.toDto(repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Case was not found!")));
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public void update(CaseDto newCaseDto, int id) {
        Case exsistCase = get(id);
        Case update = caseMapper.toCase(newCaseDto);
        caseMapper.update(exsistCase, update);
        repo.save(exsistCase);
    }
}
