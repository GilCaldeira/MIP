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
public class TaskBookHotelService {

    private final TaskInstanceService taskInstanceService;

    private final ProposalService proposalService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final ProposalCreationProcessRepository proposalCreationProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskBookHotelMapper taskBookHotelMapper;

    private final ProposalCreationProcessMapper proposalCreationProcessMapper;

    public TaskBookHotelService(
        TaskInstanceService taskInstanceService,
        ProposalService proposalService,
        TaskInstanceRepository taskInstanceRepository,
        ProposalCreationProcessRepository proposalCreationProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskBookHotelMapper taskBookHotelMapper,
        ProposalCreationProcessMapper proposalCreationProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.proposalService = proposalService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.proposalCreationProcessRepository = proposalCreationProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskBookHotelMapper = taskBookHotelMapper;
        this.proposalCreationProcessMapper = proposalCreationProcessMapper;
    }

    public TaskBookHotelContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        ProposalCreationProcessDTO proposalCreationProcess = proposalCreationProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskBookHotelMapper::toProposalCreationProcessDTO)
            .orElseThrow();

        TaskBookHotelContextDTO taskBookHotelContext = new TaskBookHotelContextDTO();
        taskBookHotelContext.setTaskInstance(taskInstanceDTO);
        taskBookHotelContext.setProposalCreationProcess(proposalCreationProcess);

        return taskBookHotelContext;
    }

    public TaskBookHotelContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskBookHotelContextDTO taskBookHotelContext) {
        ProposalDTO proposalDTO = proposalService
            .findOne(taskBookHotelContext.getProposalCreationProcess().getProposal().getId())
            .orElseThrow();
        proposalDTO.setTravelName(taskBookHotelContext.getProposalCreationProcess().getProposal().getTravelName());
        proposalDTO.setTravelStartDate(taskBookHotelContext.getProposalCreationProcess().getProposal().getTravelStartDate());
        proposalDTO.setTravelEndDate(taskBookHotelContext.getProposalCreationProcess().getProposal().getTravelEndDate());
        proposalDTO.setAirlineTicketNumber(taskBookHotelContext.getProposalCreationProcess().getProposal().getAirlineTicketNumber());
        proposalDTO.setHotelBookingNumber(taskBookHotelContext.getProposalCreationProcess().getProposal().getHotelBookingNumber());
        proposalDTO.setHotel(taskBookHotelContext.getProposalCreationProcess().getProposal().getHotel());
        proposalService.save(proposalDTO);
    }

    public void complete(TaskBookHotelContextDTO taskBookHotelContext) {
        save(taskBookHotelContext);
        ProposalCreationProcessDTO proposalCreationProcess = proposalCreationProcessRepository
            .findByProcessInstanceId(taskBookHotelContext.getProposalCreationProcess().getProcessInstance().getId())
            .map(proposalCreationProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskBookHotelContext.getTaskInstance(), proposalCreationProcess);
    }
}
