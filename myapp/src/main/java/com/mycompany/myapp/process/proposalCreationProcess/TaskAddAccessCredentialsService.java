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
public class TaskAddAccessCredentialsService {

    private final TaskInstanceService taskInstanceService;

    private final ProposalService proposalService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final ProposalCreationProcessRepository proposalCreationProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskAddAccessCredentialsMapper taskAddAccessCredentialsMapper;

    private final ProposalCreationProcessMapper proposalCreationProcessMapper;

    public TaskAddAccessCredentialsService(
        TaskInstanceService taskInstanceService,
        ProposalService proposalService,
        TaskInstanceRepository taskInstanceRepository,
        ProposalCreationProcessRepository proposalCreationProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskAddAccessCredentialsMapper taskAddAccessCredentialsMapper,
        ProposalCreationProcessMapper proposalCreationProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.proposalService = proposalService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.proposalCreationProcessRepository = proposalCreationProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskAddAccessCredentialsMapper = taskAddAccessCredentialsMapper;
        this.proposalCreationProcessMapper = proposalCreationProcessMapper;
    }

    public TaskAddAccessCredentialsContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        ProposalCreationProcessDTO proposalCreationProcess = proposalCreationProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskAddAccessCredentialsMapper::toProposalCreationProcessDTO)
            .orElseThrow();

        TaskAddAccessCredentialsContextDTO taskAddAccessCredentialsContext = new TaskAddAccessCredentialsContextDTO();
        taskAddAccessCredentialsContext.setTaskInstance(taskInstanceDTO);
        taskAddAccessCredentialsContext.setProposalCreationProcess(proposalCreationProcess);

        return taskAddAccessCredentialsContext;
    }

    public TaskAddAccessCredentialsContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskAddAccessCredentialsContextDTO taskAddAccessCredentialsContext) {
        ProposalDTO proposalDTO = proposalService
            .findOne(taskAddAccessCredentialsContext.getProposalCreationProcess().getProposal().getId())
            .orElseThrow();
        proposalDTO.setCustomerName(taskAddAccessCredentialsContext.getProposalCreationProcess().getProposal().getCustomerName());
        proposalDTO.setTravelStartDate(taskAddAccessCredentialsContext.getProposalCreationProcess().getProposal().getTravelStartDate());
        proposalDTO.setTravelEndDate(taskAddAccessCredentialsContext.getProposalCreationProcess().getProposal().getTravelEndDate());
        proposalDTO.setApplicationUserName(
            taskAddAccessCredentialsContext.getProposalCreationProcess().getProposal().getApplicationUserName()
        );
        proposalDTO.setApplicationPassword(
            taskAddAccessCredentialsContext.getProposalCreationProcess().getProposal().getApplicationPassword()
        );
        proposalService.save(proposalDTO);
    }

    public void complete(TaskAddAccessCredentialsContextDTO taskAddAccessCredentialsContext) {
        save(taskAddAccessCredentialsContext);
        ProposalCreationProcessDTO proposalCreationProcess = proposalCreationProcessRepository
            .findByProcessInstanceId(taskAddAccessCredentialsContext.getProposalCreationProcess().getProcessInstance().getId())
            .map(proposalCreationProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskAddAccessCredentialsContext.getTaskInstance(), proposalCreationProcess);
    }
}
