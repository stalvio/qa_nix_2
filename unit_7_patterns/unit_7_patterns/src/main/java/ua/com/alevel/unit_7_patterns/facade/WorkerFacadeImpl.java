package ua.com.alevel.unit_7_patterns.facade;

import org.springframework.stereotype.Service;
import ua.com.alevel.unit_7_patterns.dto.WorkerRequestDto;
import ua.com.alevel.unit_7_patterns.dto.WorkerResponseDto;
import ua.com.alevel.unit_7_patterns.entity.Worker;
import ua.com.alevel.unit_7_patterns.service.WorkerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerFacadeImpl implements WorkerFacade {

    private final WorkerService workerService;

    public WorkerFacadeImpl(WorkerService workerService) {
        this.workerService = workerService;
    }

    @Override
    public void create(WorkerRequestDto dto) {
        createOrUpdate(dto, null);
    }

    @Override
    public void update(WorkerRequestDto dto, String id) {
        createOrUpdate(dto, id);
    }

    @Override
    public void delete(String id) {
        workerService.delete(id);
    }

    @Override
    public WorkerResponseDto findById(String id) {
        return (new WorkerResponseDto(workerService.findById(id)));
    }

    @Override
    public List<WorkerResponseDto> findAll() {
        return workerService.findAll().stream().map(WorkerResponseDto::new).collect(Collectors.toList());
    }

    private void createOrUpdate(WorkerRequestDto dto, String id) {
        Worker worker = new Worker();
        worker.setFirstName(dto.getFirstName());
        worker.setLastName(dto.getLastName());
        worker.setEmail(dto.getEmail());
        worker.setBirthDay(dto.getBirthDay());
        worker.setDepartment(dto.getDepartmentId());
        if (id == null) {
            workerService.create(worker);
        } else {
            worker.setId(id);
            workerService.update(worker);
        }
    }
}
