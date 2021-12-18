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
public class TaskWriteProposalService {

    private final TaskInstanceService taskInstanceService;

    private final ProposalService proposalService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final ProposalCreationProcessRepository proposalCreationProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskWriteProposalMapper taskWriteProposalMapper;

    private final ProposalCreationProcessMapper proposalCreationProcessMapper;

    public TaskWriteProposalService(
        TaskInstanceService taskInstanceService,
        ProposalService proposalService,
        TaskInstanceRepository taskInstanceRepository,
        ProposalCreationProcessRepository proposalCreationProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskWriteProposalMapper taskWriteProposalMapper,
        ProposalCreationProcessMapper proposalCreationProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.proposalService = proposalService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.proposalCreationProcessRepository = proposalCreationProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskWriteProposalMapper = taskWriteProposalMapper;
        this.proposalCreationProcessMapper = proposalCreationProcessMapper;
    }

    public TaskWriteProposalContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        ProposalCreationProcessDTO proposalCreationProcess = proposalCreationProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskWriteProposalMapper::toProposalCreationProcessDTO)
            .orElseThrow();

        TaskWriteProposalContextDTO taskWriteProposalContext = new TaskWriteProposalContextDTO();
        taskWriteProposalContext.setTaskInstance(taskInstanceDTO);
        taskWriteProposalContext.setProposalCreationProcess(proposalCreationProcess);

        return taskWriteProposalContext;
    }

    public TaskWriteProposalContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskWriteProposalContextDTO taskWriteProposalContext) {
        ProposalDTO proposalDTO = proposalService
            .findOne(taskWriteProposalContext.getProposalCreationProcess().getProposal().getId())
            .orElseThrow();
        proposalDTO.setName(taskWriteProposalContext.getProposalCreationProcess().getProposal().getName());
        proposalService.save(proposalDTO);
    }

    public void complete(TaskWriteProposalContextDTO taskWriteProposalContext) {
        save(taskWriteProposalContext);
        ProposalCreationProcessDTO proposalCreationProcess = proposalCreationProcessRepository
            .findByProcessInstanceId(taskWriteProposalContext.getProposalCreationProcess().getProcessInstance().getId())
            .map(proposalCreationProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskWriteProposalContext.getTaskInstance(), proposalCreationProcess);
    }
}
