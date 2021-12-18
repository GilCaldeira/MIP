package com.mycompany.myapp.process.proposalCreationProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proposal-creation-process/task-check-travel-plan")
public class TaskCheckTravelPlanController {

    private final Logger log = LoggerFactory.getLogger(TaskCheckTravelPlanController.class);

    private final TaskCheckTravelPlanService taskCheckTravelPlanService;

    public TaskCheckTravelPlanController(TaskCheckTravelPlanService taskCheckTravelPlanService) {
        this.taskCheckTravelPlanService = taskCheckTravelPlanService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskCheckTravelPlanContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskCheckTravelPlanContextDTO taskCheckTravelPlanContext = taskCheckTravelPlanService.loadContext(id);
        return ResponseEntity.ok(taskCheckTravelPlanContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskCheckTravelPlanContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskCheckTravelPlanContextDTO taskCheckTravelPlanContext = taskCheckTravelPlanService.claim(id);
        return ResponseEntity.ok(taskCheckTravelPlanContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskCheckTravelPlanContextDTO taskCheckTravelPlanContext) {
        log.debug(
            "REST request to complete ProposalCreationProcess.TaskCheckTravelPlan {}",
            taskCheckTravelPlanContext.getTaskInstance().getId()
        );
        taskCheckTravelPlanService.complete(taskCheckTravelPlanContext);
        return ResponseEntity.noContent().build();
    }
}
