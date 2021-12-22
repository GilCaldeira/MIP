package com.mycompany.myapp.process.proposalCreationProcess;

import com.mycompany.myapp.repository.ProposalCreationProcessRepository;
import com.mycompany.myapp.service.ProposalService;
import com.mycompany.myapp.service.dto.ProposalCreationProcessDTO;
import com.mycompany.myapp.service.dto.ProposalDTO;
import com.mycompany.myapp.service.mapper.ProposalCreationProcessMapper;
import org.akip.repository.TaskInstanceRepository;
import org.akip.service.TaskInstanceService;
import org.akip.service.dto.TaskInstanceDTO;
import org.akip.service.mapper.TaskInstanceMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskAnalyzeCustomerFeedbackService {

    private final TaskInstanceService taskInstanceService;

    private final ProposalService proposalService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final ProposalCreationProcessRepository proposalCreationProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskAnalyzeCustomerFeedbackMapper taskAnalyzeCustomerFeedbackMapper;

    private final ProposalCreationProcessMapper proposalCreationProcessMapper;

    public TaskAnalyzeCustomerFeedbackService(
        TaskInstanceService taskInstanceService,
        ProposalService proposalService,
        TaskInstanceRepository taskInstanceRepository,
        ProposalCreationProcessRepository proposalCreationProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskAnalyzeCustomerFeedbackMapper taskAnalyzeCustomerFeedbackMapper,
        ProposalCreationProcessMapper proposalCreationProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.proposalService = proposalService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.proposalCreationProcessRepository = proposalCreationProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskAnalyzeCustomerFeedbackMapper = taskAnalyzeCustomerFeedbackMapper;
        this.proposalCreationProcessMapper = proposalCreationProcessMapper;
    }

    public TaskAnalyzeCustomerFeedbackContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        ProposalCreationProcessDTO proposalCreationProcess = proposalCreationProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskAnalyzeCustomerFeedbackMapper::toProposalCreationProcessDTO)
            .orElseThrow();

        TaskAnalyzeCustomerFeedbackContextDTO taskAnalyzeCustomerFeedbackContext = new TaskAnalyzeCustomerFeedbackContextDTO();
        taskAnalyzeCustomerFeedbackContext.setTaskInstance(taskInstanceDTO);
        taskAnalyzeCustomerFeedbackContext.setProposalCreationProcess(proposalCreationProcess);

        return taskAnalyzeCustomerFeedbackContext;
    }

    public TaskAnalyzeCustomerFeedbackContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskAnalyzeCustomerFeedbackContextDTO taskAnalyzeCustomerFeedbackContext) {
        ProposalDTO proposalDTO = proposalService
            .findOne(taskAnalyzeCustomerFeedbackContext.getProposalCreationProcess().getProposal().getId())
            .orElseThrow();
        proposalDTO.setName(taskAnalyzeCustomerFeedbackContext.getProposalCreationProcess().getProposal().getName());
        proposalDTO.setCustomerName(taskAnalyzeCustomerFeedbackContext.getProposalCreationProcess().getProposal().getCustomerName());
        proposalDTO.setCustomerEmail(taskAnalyzeCustomerFeedbackContext.getProposalCreationProcess().getProposal().getCustomerEmail());
        proposalDTO.setState(taskAnalyzeCustomerFeedbackContext.getProposalCreationProcess().getProposal().getState());
        proposalDTO.setCustomerFeedback(
            taskAnalyzeCustomerFeedbackContext.getProposalCreationProcess().getProposal().getCustomerFeedback()
        );
        proposalService.save(proposalDTO);
    }

    public void complete(TaskAnalyzeCustomerFeedbackContextDTO taskAnalyzeCustomerFeedbackContext) {
        save(taskAnalyzeCustomerFeedbackContext);
        ProposalCreationProcessDTO proposalCreationProcess = proposalCreationProcessRepository
            .findByProcessInstanceId(taskAnalyzeCustomerFeedbackContext.getProposalCreationProcess().getProcessInstance().getId())
            .map(proposalCreationProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskAnalyzeCustomerFeedbackContext.getTaskInstance(), proposalCreationProcess);
    }
}
