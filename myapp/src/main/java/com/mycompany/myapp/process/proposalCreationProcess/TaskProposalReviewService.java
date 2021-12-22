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
public class TaskProposalReviewService {

    private final TaskInstanceService taskInstanceService;

    private final ProposalService proposalService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final ProposalCreationProcessRepository proposalCreationProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskProposalReviewMapper taskProposalReviewMapper;

    private final ProposalCreationProcessMapper proposalCreationProcessMapper;

    public TaskProposalReviewService(
        TaskInstanceService taskInstanceService,
        ProposalService proposalService,
        TaskInstanceRepository taskInstanceRepository,
        ProposalCreationProcessRepository proposalCreationProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskProposalReviewMapper taskProposalReviewMapper,
        ProposalCreationProcessMapper proposalCreationProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.proposalService = proposalService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.proposalCreationProcessRepository = proposalCreationProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskProposalReviewMapper = taskProposalReviewMapper;
        this.proposalCreationProcessMapper = proposalCreationProcessMapper;
    }

    public TaskProposalReviewContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        ProposalCreationProcessDTO proposalCreationProcess = proposalCreationProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskProposalReviewMapper::toProposalCreationProcessDTO)
            .orElseThrow();

        TaskProposalReviewContextDTO taskProposalReviewContext = new TaskProposalReviewContextDTO();
        taskProposalReviewContext.setTaskInstance(taskInstanceDTO);
        taskProposalReviewContext.setProposalCreationProcess(proposalCreationProcess);

        return taskProposalReviewContext;
    }

    public TaskProposalReviewContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskProposalReviewContextDTO taskProposalReviewContext) {
        ProposalDTO proposalDTO = proposalService
            .findOne(taskProposalReviewContext.getProposalCreationProcess().getProposal().getId())
            .orElseThrow();
        proposalDTO.setName(taskProposalReviewContext.getProposalCreationProcess().getProposal().getName());
        proposalDTO.setTravelName(taskProposalReviewContext.getProposalCreationProcess().getProposal().getTravelName());
        proposalDTO.setCustomerName(taskProposalReviewContext.getProposalCreationProcess().getProposal().getCustomerName());
        proposalDTO.setTravelStartDate(taskProposalReviewContext.getProposalCreationProcess().getProposal().getTravelStartDate());
        proposalDTO.setTravelEndDate(taskProposalReviewContext.getProposalCreationProcess().getProposal().getTravelEndDate());
        proposalDTO.setTravelType(taskProposalReviewContext.getProposalCreationProcess().getProposal().getTravelType());
        proposalDTO.setExamplesOtherTravelServices(
            taskProposalReviewContext.getProposalCreationProcess().getProposal().getExamplesOtherTravelServices()
        );
        proposalDTO.setHotel(taskProposalReviewContext.getProposalCreationProcess().getProposal().getHotel());
        proposalDTO.setHotel(taskProposalReviewContext.getProposalCreationProcess().getProposal().getHotel());
        proposalService.save(proposalDTO);
    }

    public void complete(TaskProposalReviewContextDTO taskProposalReviewContext) {
        save(taskProposalReviewContext);
        ProposalCreationProcessDTO proposalCreationProcess = proposalCreationProcessRepository
            .findByProcessInstanceId(taskProposalReviewContext.getProposalCreationProcess().getProcessInstance().getId())
            .map(proposalCreationProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskProposalReviewContext.getTaskInstance(), proposalCreationProcess);
    }
}
