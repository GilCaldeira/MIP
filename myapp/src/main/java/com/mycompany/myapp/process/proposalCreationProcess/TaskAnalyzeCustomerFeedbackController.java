package com.mycompany.myapp.process.proposalCreationProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proposal-creation-process/task-analyze-customer-feedback")
public class TaskAnalyzeCustomerFeedbackController {

    private final Logger log = LoggerFactory.getLogger(TaskAnalyzeCustomerFeedbackController.class);

    private final TaskAnalyzeCustomerFeedbackService taskAnalyzeCustomerFeedbackService;

    public TaskAnalyzeCustomerFeedbackController(TaskAnalyzeCustomerFeedbackService taskAnalyzeCustomerFeedbackService) {
        this.taskAnalyzeCustomerFeedbackService = taskAnalyzeCustomerFeedbackService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskAnalyzeCustomerFeedbackContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskAnalyzeCustomerFeedbackContextDTO taskAnalyzeCustomerFeedbackContext = taskAnalyzeCustomerFeedbackService.loadContext(id);
        return ResponseEntity.ok(taskAnalyzeCustomerFeedbackContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskAnalyzeCustomerFeedbackContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskAnalyzeCustomerFeedbackContextDTO taskAnalyzeCustomerFeedbackContext = taskAnalyzeCustomerFeedbackService.claim(id);
        return ResponseEntity.ok(taskAnalyzeCustomerFeedbackContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskAnalyzeCustomerFeedbackContextDTO taskAnalyzeCustomerFeedbackContext) {
        log.debug(
            "REST request to complete ProposalCreationProcess.TaskAnalyzeCustomerFeedback {}",
            taskAnalyzeCustomerFeedbackContext.getTaskInstance().getId()
        );
        taskAnalyzeCustomerFeedbackService.complete(taskAnalyzeCustomerFeedbackContext);
        return ResponseEntity.noContent().build();
    }
}
