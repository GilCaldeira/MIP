package com.mycompany.myapp.process.proposalCreationProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proposal-creation-process/task-book-hotel")
public class TaskBookHotelController {

    private final Logger log = LoggerFactory.getLogger(TaskBookHotelController.class);

    private final TaskBookHotelService taskBookHotelService;

    public TaskBookHotelController(TaskBookHotelService taskBookHotelService) {
        this.taskBookHotelService = taskBookHotelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskBookHotelContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskBookHotelContextDTO taskBookHotelContext = taskBookHotelService.loadContext(id);
        return ResponseEntity.ok(taskBookHotelContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskBookHotelContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskBookHotelContextDTO taskBookHotelContext = taskBookHotelService.claim(id);
        return ResponseEntity.ok(taskBookHotelContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskBookHotelContextDTO taskBookHotelContext) {
        log.debug("REST request to complete ProposalCreationProcess.TaskBookHotel {}", taskBookHotelContext.getTaskInstance().getId());
        taskBookHotelService.complete(taskBookHotelContext);
        return ResponseEntity.noContent().build();
    }
}
