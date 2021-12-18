package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.ProposalCreationProcess;
import com.mycompany.myapp.repository.ProposalCreationProcessRepository;
import com.mycompany.myapp.repository.ProposalRepository;
import com.mycompany.myapp.service.dto.ProposalCreationProcessDTO;
import com.mycompany.myapp.service.mapper.ProposalCreationProcessMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.akip.domain.ProcessInstance;
import org.akip.service.ProcessInstanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link ProposalCreationProcess}.
 */
@Service
@Transactional
public class ProposalCreationProcessService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "ProposalCreationProcess";

    private final Logger log = LoggerFactory.getLogger(ProposalCreationProcessService.class);

    private final ProcessInstanceService processInstanceService;

    private final ProposalRepository proposalRepository;

    private final ProposalCreationProcessRepository proposalCreationProcessRepository;

    private final ProposalCreationProcessMapper proposalCreationProcessMapper;

    public ProposalCreationProcessService(
        ProcessInstanceService processInstanceService,
        ProposalRepository proposalRepository,
        ProposalCreationProcessRepository proposalCreationProcessRepository,
        ProposalCreationProcessMapper proposalCreationProcessMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.proposalRepository = proposalRepository;
        this.proposalCreationProcessRepository = proposalCreationProcessRepository;
        this.proposalCreationProcessMapper = proposalCreationProcessMapper;
    }

    /**
     * Save a proposalCreationProcess.
     *
     * @param proposalCreationProcessDTO the entity to save.
     * @return the persisted entity.
     */
    public ProposalCreationProcessDTO create(ProposalCreationProcessDTO proposalCreationProcessDTO) {
        log.debug("Request to save ProposalCreationProcess : {}", proposalCreationProcessDTO);

        ProposalCreationProcess proposalCreationProcess = proposalCreationProcessMapper.toEntity(proposalCreationProcessDTO);

        //Saving the domainEntity
        proposalRepository.save(proposalCreationProcess.getProposal());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "Proposal#" + proposalCreationProcess.getProposal().getId(),
            proposalCreationProcess
        );
        proposalCreationProcess.setProcessInstance(processInstance);

        //Saving the process entity
        proposalCreationProcess = proposalCreationProcessRepository.save(proposalCreationProcess);
        return proposalCreationProcessMapper.toDto(proposalCreationProcess);
    }

    /**
     * Get all the proposalCreationProcesss.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<ProposalCreationProcessDTO> findAll() {
        log.debug("Request to get all ProposalCreationProcesss");
        return proposalCreationProcessRepository
            .findAll()
            .stream()
            .map(proposalCreationProcessMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one proposalCreationProcess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ProposalCreationProcessDTO> findOne(Long id) {
        log.debug("Request to get ProposalCreationProcess : {}", id);
        return proposalCreationProcessRepository.findById(id).map(proposalCreationProcessMapper::toDto);
    }

    /**
     * Get one proposalCreationProcess by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ProposalCreationProcessDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get ProposalCreationProcess by  processInstanceId: {}", processInstanceId);
        return proposalCreationProcessRepository.findByProcessInstanceId(processInstanceId).map(proposalCreationProcessMapper::toDto);
    }
}
