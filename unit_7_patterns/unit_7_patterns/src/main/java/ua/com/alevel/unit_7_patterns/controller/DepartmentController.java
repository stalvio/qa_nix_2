package ua.com.alevel.unit_7_patterns.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.unit_7_patterns.dto.DepartmentRequestDto;
import ua.com.alevel.unit_7_patterns.dto.DepartmentResponseDto;
import ua.com.alevel.unit_7_patterns.dto.ResponseContainer;
import ua.com.alevel.unit_7_patterns.facade.DepartmentFacade;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    DepartmentFacade departmentFacade;

    public DepartmentController(DepartmentFacade departmentFacade) {
        this.departmentFacade = departmentFacade;
    }

    @PostMapping
    public ResponseEntity<ResponseContainer<Boolean>> create(@RequestBody DepartmentRequestDto dto) {
        departmentFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> update(@RequestBody DepartmentRequestDto dto, @PathVariable String id) {
        departmentFacade.update(dto, id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable String id) {
        departmentFacade.delete(id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseContainer<DepartmentResponseDto>> findById(@PathVariable String id) {
        ResponseContainer<DepartmentResponseDto> responseContainer = new ResponseContainer<>(departmentFacade.findById(id));
        return ResponseEntity.ok(responseContainer);
    }

    @GetMapping
    public ResponseEntity<ResponseContainer<List<DepartmentResponseDto>>> findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(departmentFacade.findAll()));
    }

}
