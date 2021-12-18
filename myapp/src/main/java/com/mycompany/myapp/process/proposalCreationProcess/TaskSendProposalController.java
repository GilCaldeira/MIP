package com.mycompany.myapp.process.proposalCreationProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proposal-creation-process/task-send-proposal")
public class TaskSendProposalController {

    private final Logger log = LoggerFactory.getLogger(TaskSendProposalController.class);

    private final TaskSendProposalService taskSendProposalService;

    public TaskSendProposalController(TaskSendProposalService taskSendProposalService) {
        this.taskSendProposalService = taskSendProposalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskSendProposalContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskSendProposalContextDTO taskSendProposalContext = taskSendProposalService.loadContext(id);
        return ResponseEntity.ok(taskSendProposalContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskSendProposalContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskSendProposalContextDTO taskSendProposalContext = taskSendProposalService.claim(id);
        return ResponseEntity.ok(taskSendProposalContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskSendProposalContextDTO taskSendProposalContext) {
        log.debug(
            "REST request to complete ProposalCreationProcess.TaskSendProposal {}",
            taskSendProposalContext.getTaskInstance().getId()
        );
        taskSendProposalService.complete(taskSendProposalContext);
        return ResponseEntity.noContent().build();
    }
}
