package ua.com.alevel.unit_7_patterns.facade;

import org.springframework.stereotype.Service;
import ua.com.alevel.unit_7_patterns.dto.DepartmentRequestDto;
import ua.com.alevel.unit_7_patterns.dto.DepartmentResponseDto;
import ua.com.alevel.unit_7_patterns.entity.Department;
import ua.com.alevel.unit_7_patterns.service.DepartmentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentFacadeImpl implements DepartmentFacade {

    private final DepartmentService departmentService;

    public DepartmentFacadeImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void create(DepartmentRequestDto dto) {
        createOrUpdate(dto, null);
    }

    @Override
    public void update(DepartmentRequestDto dto, String id) {
        createOrUpdate(dto, id);
    }

    @Override
    public void delete(String id) {
        departmentService.delete(id);
    }

    @Override
    public DepartmentResponseDto findById(String id) {
        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto(departmentService.findById(id));
        return departmentResponseDto;
    }

    @Override
    public List<DepartmentResponseDto> findAll() {
        return departmentService.findAll().stream().map(DepartmentResponseDto::new).collect(Collectors.toList());
    }

    private void createOrUpdate(DepartmentRequestDto dto, String id) {
        Department department = new Department();
        department.setName(dto.getName());
        if (id == null) {
            departmentService.create(department);
        } else {
            department.setId(id);
            departmentService.update(department);
        }
    }

}
