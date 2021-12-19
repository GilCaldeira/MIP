package com.mycompany.myapp.process.proposalCreationProcess;

import com.mycompany.myapp.service.dto.ProposalCreationProcessDTO;
import org.akip.service.dto.TaskInstanceDTO;

public class TaskAnalyzeCustomerFeedbackContextDTO {

    private ProposalCreationProcessDTO proposalCreationProcess;
    private TaskInstanceDTO taskInstance;

    public ProposalCreationProcessDTO getProposalCreationProcess() {
        return proposalCreationProcess;
    }

    public void setProposalCreationProcess(ProposalCreationProcessDTO proposalCreationProcess) {
        this.proposalCreationProcess = proposalCreationProcess;
    }

    public TaskInstanceDTO getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(TaskInstanceDTO taskInstance) {
        this.taskInstance = taskInstance;
    }
}
