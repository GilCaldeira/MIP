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
public class TaskSendProposalService {

    private final TaskInstanceService taskInstanceService;

    private final ProposalService proposalService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final ProposalCreationProcessRepository proposalCreationProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskSendProposalMapper taskSendProposalMapper;

    private final ProposalCreationProcessMapper proposalCreationProcessMapper;

    public TaskSendProposalService(
        TaskInstanceService taskInstanceService,
        ProposalService proposalService,
        TaskInstanceRepository taskInstanceRepository,
        ProposalCreationProcessRepository proposalCreationProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskSendProposalMapper taskSendProposalMapper,
        ProposalCreationProcessMapper proposalCreationProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.proposalService = proposalService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.proposalCreationProcessRepository = proposalCreationProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskSendProposalMapper = taskSendProposalMapper;
        this.proposalCreationProcessMapper = proposalCreationProcessMapper;
    }

    public TaskSendProposalContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        ProposalCreationProcessDTO proposalCreationProcess = proposalCreationProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskSendProposalMapper::toProposalCreationProcessDTO)
            .orElseThrow();

        TaskSendProposalContextDTO taskSendProposalContext = new TaskSendProposalContextDTO();
        taskSendProposalContext.setTaskInstance(taskInstanceDTO);
        taskSendProposalContext.setProposalCreationProcess(proposalCreationProcess);

        return taskSendProposalContext;
    }

    public TaskSendProposalContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskSendProposalContextDTO taskSendProposalContext) {
        ProposalDTO proposalDTO = proposalService
            .findOne(taskSendProposalContext.getProposalCreationProcess().getProposal().getId())
            .orElseThrow();
        proposalDTO.setName(taskSendProposalContext.getProposalCreationProcess().getProposal().getName());
        proposalDTO.setCustomerName(taskSendProposalContext.getProposalCreationProcess().getProposal().getCustomerName());
        proposalDTO.setCustomerEmail(taskSendProposalContext.getProposalCreationProcess().getProposal().getCustomerEmail());
        proposalService.save(proposalDTO);
    }

    public void complete(TaskSendProposalContextDTO taskSendProposalContext) {
        save(taskSendProposalContext);
        ProposalCreationProcessDTO proposalCreationProcess = proposalCreationProcessRepository
            .findByProcessInstanceId(taskSendProposalContext.getProposalCreationProcess().getProcessInstance().getId())
            .map(proposalCreationProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskSendProposalContext.getTaskInstance(), proposalCreationProcess);
    }
}
