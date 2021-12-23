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
public class TaskRentCarService {

    private final TaskInstanceService taskInstanceService;

    private final ProposalService proposalService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final ProposalCreationProcessRepository proposalCreationProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskRentCarMapper taskRentCarMapper;

    private final ProposalCreationProcessMapper proposalCreationProcessMapper;

    public TaskRentCarService(
        TaskInstanceService taskInstanceService,
        ProposalService proposalService,
        TaskInstanceRepository taskInstanceRepository,
        ProposalCreationProcessRepository proposalCreationProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskRentCarMapper taskRentCarMapper,
        ProposalCreationProcessMapper proposalCreationProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.proposalService = proposalService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.proposalCreationProcessRepository = proposalCreationProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskRentCarMapper = taskRentCarMapper;
        this.proposalCreationProcessMapper = proposalCreationProcessMapper;
    }

    public TaskRentCarContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        ProposalCreationProcessDTO proposalCreationProcess = proposalCreationProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskRentCarMapper::toProposalCreationProcessDTO)
            .orElseThrow();

        TaskRentCarContextDTO taskRentCarContext = new TaskRentCarContextDTO();
        taskRentCarContext.setTaskInstance(taskInstanceDTO);
        taskRentCarContext.setProposalCreationProcess(proposalCreationProcess);

        return taskRentCarContext;
    }

    public TaskRentCarContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskRentCarContextDTO taskRentCarContext) {
        ProposalDTO proposalDTO = proposalService
            .findOne(taskRentCarContext.getProposalCreationProcess().getProposal().getId())
            .orElseThrow();
        proposalDTO.setTravelName(taskRentCarContext.getProposalCreationProcess().getProposal().getTravelName());
        proposalDTO.setTravelStartDate(taskRentCarContext.getProposalCreationProcess().getProposal().getTravelStartDate());
        proposalDTO.setTravelEndDate(taskRentCarContext.getProposalCreationProcess().getProposal().getTravelEndDate());
        proposalDTO.setCarBookingNumber(taskRentCarContext.getProposalCreationProcess().getProposal().getCarBookingNumber());
        proposalDTO.setRentalCarCompany(taskRentCarContext.getProposalCreationProcess().getProposal().getRentalCarCompany());
        proposalService.save(proposalDTO);
    }

    public void complete(TaskRentCarContextDTO taskRentCarContext) {
        save(taskRentCarContext);
        ProposalCreationProcessDTO proposalCreationProcess = proposalCreationProcessRepository
            .findByProcessInstanceId(taskRentCarContext.getProposalCreationProcess().getProcessInstance().getId())
            .map(proposalCreationProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskRentCarContext.getTaskInstance(), proposalCreationProcess);
    }
}
