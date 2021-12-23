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
public class TaskChooseFlightService {

    private final TaskInstanceService taskInstanceService;

    private final ProposalService proposalService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final ProposalCreationProcessRepository proposalCreationProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskChooseFlightMapper taskChooseFlightMapper;

    private final ProposalCreationProcessMapper proposalCreationProcessMapper;

    public TaskChooseFlightService(
        TaskInstanceService taskInstanceService,
        ProposalService proposalService,
        TaskInstanceRepository taskInstanceRepository,
        ProposalCreationProcessRepository proposalCreationProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskChooseFlightMapper taskChooseFlightMapper,
        ProposalCreationProcessMapper proposalCreationProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.proposalService = proposalService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.proposalCreationProcessRepository = proposalCreationProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskChooseFlightMapper = taskChooseFlightMapper;
        this.proposalCreationProcessMapper = proposalCreationProcessMapper;
    }

    public TaskChooseFlightContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        ProposalCreationProcessDTO proposalCreationProcess = proposalCreationProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskChooseFlightMapper::toProposalCreationProcessDTO)
            .orElseThrow();

        TaskChooseFlightContextDTO taskChooseFlightContext = new TaskChooseFlightContextDTO();
        taskChooseFlightContext.setTaskInstance(taskInstanceDTO);
        taskChooseFlightContext.setProposalCreationProcess(proposalCreationProcess);

        return taskChooseFlightContext;
    }

    public TaskChooseFlightContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskChooseFlightContextDTO taskChooseFlightContext) {
        ProposalDTO proposalDTO = proposalService
            .findOne(taskChooseFlightContext.getProposalCreationProcess().getProposal().getId())
            .orElseThrow();
        proposalDTO.setTravelName(taskChooseFlightContext.getProposalCreationProcess().getProposal().getTravelName());
        proposalDTO.setTravelStartDate(taskChooseFlightContext.getProposalCreationProcess().getProposal().getTravelStartDate());
        proposalDTO.setTravelEndDate(taskChooseFlightContext.getProposalCreationProcess().getProposal().getTravelEndDate());
        proposalDTO.setAirlineTicketNumber(taskChooseFlightContext.getProposalCreationProcess().getProposal().getAirlineTicketNumber());
        proposalDTO.setAirlineCompany(taskChooseFlightContext.getProposalCreationProcess().getProposal().getAirlineCompany());
        proposalService.save(proposalDTO);
    }

    public void complete(TaskChooseFlightContextDTO taskChooseFlightContext) {
        save(taskChooseFlightContext);
        ProposalCreationProcessDTO proposalCreationProcess = proposalCreationProcessRepository
            .findByProcessInstanceId(taskChooseFlightContext.getProposalCreationProcess().getProcessInstance().getId())
            .map(proposalCreationProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskChooseFlightContext.getTaskInstance(), proposalCreationProcess);
    }
}
