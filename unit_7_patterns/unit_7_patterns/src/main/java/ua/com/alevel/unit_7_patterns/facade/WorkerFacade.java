package ua.com.alevel.unit_7_patterns.facade;

import ua.com.alevel.unit_7_patterns.dto.WorkerRequestDto;
import ua.com.alevel.unit_7_patterns.dto.WorkerResponseDto;

import java.util.List;

public interface WorkerFacade {
    void create(WorkerRequestDto dto);
    void update(WorkerRequestDto dto, String id);
    void delete(String id);
    WorkerResponseDto findById(String id);
    List<WorkerResponseDto> findAll();
}
