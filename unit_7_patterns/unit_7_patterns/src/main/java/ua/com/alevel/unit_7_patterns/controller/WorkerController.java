package ua.com.alevel.unit_7_patterns.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.unit_7_patterns.dto.ResponseContainer;
import ua.com.alevel.unit_7_patterns.dto.WorkerRequestDto;
import ua.com.alevel.unit_7_patterns.dto.WorkerResponseDto;
import ua.com.alevel.unit_7_patterns.facade.WorkerFacade;

import java.util.List;

@RestController
@RequestMapping("/api/workers")
public class WorkerController {

    WorkerFacade workerFacade;

    public WorkerController(WorkerFacade workerFacade) {
        this.workerFacade = workerFacade;
    }

    @PostMapping
    public ResponseEntity<ResponseContainer<Boolean>> create(@RequestBody WorkerRequestDto dto) {
        workerFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> update(@RequestBody WorkerRequestDto dto, @PathVariable String id) {
        workerFacade.update(dto, id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable String id) {
        workerFacade.delete(id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseContainer<WorkerResponseDto>> findById(@PathVariable String id) {
        return ResponseEntity.ok(new ResponseContainer<>(workerFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<ResponseContainer<List<WorkerResponseDto>>> findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(workerFacade.findAll()));
    }
}
