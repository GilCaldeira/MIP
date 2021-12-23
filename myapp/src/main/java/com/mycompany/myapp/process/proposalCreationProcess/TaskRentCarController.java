package com.mycompany.myapp.process.proposalCreationProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proposal-creation-process/task-rent-car")
public class TaskRentCarController {

    private final Logger log = LoggerFactory.getLogger(TaskRentCarController.class);

    private final TaskRentCarService taskRentCarService;

    public TaskRentCarController(TaskRentCarService taskRentCarService) {
        this.taskRentCarService = taskRentCarService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskRentCarContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskRentCarContextDTO taskRentCarContext = taskRentCarService.loadContext(id);
        return ResponseEntity.ok(taskRentCarContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskRentCarContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskRentCarContextDTO taskRentCarContext = taskRentCarService.claim(id);
        return ResponseEntity.ok(taskRentCarContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskRentCarContextDTO taskRentCarContext) {
        log.debug("REST request to complete ProposalCreationProcess.TaskRentCar {}", taskRentCarContext.getTaskInstance().getId());
        taskRentCarService.complete(taskRentCarContext);
        return ResponseEntity.noContent().build();
    }
}
