package ua.com.alevel.unit_7_patterns.facade;


import ua.com.alevel.unit_7_patterns.dto.DepartmentRequestDto;
import ua.com.alevel.unit_7_patterns.dto.DepartmentResponseDto;

import java.util.List;

public interface DepartmentFacade {

    void create(DepartmentRequestDto dto);
    void update(DepartmentRequestDto dto, String id);
    void delete(String id);
    DepartmentResponseDto findById(String id);
    List<DepartmentResponseDto> findAll();
}
