package com.mycompany.myapp.process.proposalCreationProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proposal-creation-process/task-write-proposal")
public class TaskWriteProposalController {

    private final Logger log = LoggerFactory.getLogger(TaskWriteProposalController.class);

    private final TaskWriteProposalService taskWriteProposalService;

    public TaskWriteProposalController(TaskWriteProposalService taskWriteProposalService) {
        this.taskWriteProposalService = taskWriteProposalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskWriteProposalContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskWriteProposalContextDTO taskWriteProposalContext = taskWriteProposalService.loadContext(id);
        return ResponseEntity.ok(taskWriteProposalContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskWriteProposalContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskWriteProposalContextDTO taskWriteProposalContext = taskWriteProposalService.claim(id);
        return ResponseEntity.ok(taskWriteProposalContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskWriteProposalContextDTO taskWriteProposalContext) {
        log.debug(
            "REST request to complete ProposalCreationProcess.TaskWriteProposal {}",
            taskWriteProposalContext.getTaskInstance().getId()
        );
        taskWriteProposalService.complete(taskWriteProposalContext);
        return ResponseEntity.noContent().build();
    }
}
