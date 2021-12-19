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
public class TaskCheckTravelPlanService {

    private final TaskInstanceService taskInstanceService;

    private final ProposalService proposalService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final ProposalCreationProcessRepository proposalCreationProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskCheckTravelPlanMapper taskCheckTravelPlanMapper;

    private final ProposalCreationProcessMapper proposalCreationProcessMapper;

    public TaskCheckTravelPlanService(
        TaskInstanceService taskInstanceService,
        ProposalService proposalService,
        TaskInstanceRepository taskInstanceRepository,
        ProposalCreationProcessRepository proposalCreationProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskCheckTravelPlanMapper taskCheckTravelPlanMapper,
        ProposalCreationProcessMapper proposalCreationProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.proposalService = proposalService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.proposalCreationProcessRepository = proposalCreationProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskCheckTravelPlanMapper = taskCheckTravelPlanMapper;
        this.proposalCreationProcessMapper = proposalCreationProcessMapper;
    }

    public TaskCheckTravelPlanContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        ProposalCreationProcessDTO proposalCreationProcess = proposalCreationProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskCheckTravelPlanMapper::toProposalCreationProcessDTO)
            .orElseThrow();

        TaskCheckTravelPlanContextDTO taskCheckTravelPlanContext = new TaskCheckTravelPlanContextDTO();
        taskCheckTravelPlanContext.setTaskInstance(taskInstanceDTO);
        taskCheckTravelPlanContext.setProposalCreationProcess(proposalCreationProcess);

        return taskCheckTravelPlanContext;
    }

    public TaskCheckTravelPlanContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskCheckTravelPlanContextDTO taskCheckTravelPlanContext) {
        ProposalDTO proposalDTO = proposalService
            .findOne(taskCheckTravelPlanContext.getProposalCreationProcess().getProposal().getId())
            .orElseThrow();
        proposalDTO.setCustomerName(taskCheckTravelPlanContext.getProposalCreationProcess().getProposal().getCustomerName());
        proposalDTO.setCustomerEmail(taskCheckTravelPlanContext.getProposalCreationProcess().getProposal().getCustomerEmail());
        proposalService.save(proposalDTO);
    }

    public void complete(TaskCheckTravelPlanContextDTO taskCheckTravelPlanContext) {
        save(taskCheckTravelPlanContext);
        ProposalCreationProcessDTO proposalCreationProcess = proposalCreationProcessRepository
            .findByProcessInstanceId(taskCheckTravelPlanContext.getProposalCreationProcess().getProcessInstance().getId())
            .map(proposalCreationProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskCheckTravelPlanContext.getTaskInstance(), proposalCreationProcess);
    }
}
