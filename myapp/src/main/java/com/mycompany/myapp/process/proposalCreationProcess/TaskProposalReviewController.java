package com.mycompany.myapp.process.proposalCreationProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proposal-creation-process/task-proposal-review")
public class TaskProposalReviewController {

    private final Logger log = LoggerFactory.getLogger(TaskProposalReviewController.class);

    private final TaskProposalReviewService taskProposalReviewService;

    public TaskProposalReviewController(TaskProposalReviewService taskProposalReviewService) {
        this.taskProposalReviewService = taskProposalReviewService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskProposalReviewContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskProposalReviewContextDTO taskProposalReviewContext = taskProposalReviewService.loadContext(id);
        return ResponseEntity.ok(taskProposalReviewContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskProposalReviewContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskProposalReviewContextDTO taskProposalReviewContext = taskProposalReviewService.claim(id);
        return ResponseEntity.ok(taskProposalReviewContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskProposalReviewContextDTO taskProposalReviewContext) {
        log.debug(
            "REST request to complete ProposalCreationProcess.TaskProposalReview {}",
            taskProposalReviewContext.getTaskInstance().getId()
        );
        taskProposalReviewService.complete(taskProposalReviewContext);
        return ResponseEntity.noContent().build();
    }
}
