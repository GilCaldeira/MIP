package com.mycompany.myapp.process.proposalCreationProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proposal-creation-process/task-add-access-credentials")
public class TaskAddAccessCredentialsController {

    private final Logger log = LoggerFactory.getLogger(TaskAddAccessCredentialsController.class);

    private final TaskAddAccessCredentialsService taskAddAccessCredentialsService;

    public TaskAddAccessCredentialsController(TaskAddAccessCredentialsService taskAddAccessCredentialsService) {
        this.taskAddAccessCredentialsService = taskAddAccessCredentialsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskAddAccessCredentialsContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskAddAccessCredentialsContextDTO taskAddAccessCredentialsContext = taskAddAccessCredentialsService.loadContext(id);
        return ResponseEntity.ok(taskAddAccessCredentialsContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskAddAccessCredentialsContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskAddAccessCredentialsContextDTO taskAddAccessCredentialsContext = taskAddAccessCredentialsService.claim(id);
        return ResponseEntity.ok(taskAddAccessCredentialsContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskAddAccessCredentialsContextDTO taskAddAccessCredentialsContext) {
        log.debug(
            "REST request to complete ProposalCreationProcess.TaskAddAccessCredentials {}",
            taskAddAccessCredentialsContext.getTaskInstance().getId()
        );
        taskAddAccessCredentialsService.complete(taskAddAccessCredentialsContext);
        return ResponseEntity.noContent().build();
    }
}
