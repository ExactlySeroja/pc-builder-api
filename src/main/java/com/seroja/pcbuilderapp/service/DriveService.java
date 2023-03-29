package com.seroja.pcbuilderapp.service;

import com.seroja.pcbuilderapp.dto.DriveDto;
import com.seroja.pcbuilderapp.entities.Drive;
import com.seroja.pcbuilderapp.mapper.DriveMapper;
import com.seroja.pcbuilderapp.repos.DriveRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DriveService {
    private final DriveRepository repo;
    private final DriveMapper driveMapper;

    public List<DriveDto> listAll() {
        return driveMapper.toDtoList(repo.findAll());
    }

    public DriveDto save(DriveDto driveDto) {
        return driveMapper.toDto(repo.save(driveMapper.toDrive(driveDto)));
    }

    public Drive get(int id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Drive was not found"));
    }

    public DriveDto getDto(int id) {
        return driveMapper.toDto(repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Drive was not found")));
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public void update(DriveDto newDriveDto, int id) {
        Drive exsistDrive = get(id);
        Drive update = driveMapper.toDrive(newDriveDto);
        driveMapper.update(exsistDrive, update);
        repo.save(exsistDrive);
    }

}
