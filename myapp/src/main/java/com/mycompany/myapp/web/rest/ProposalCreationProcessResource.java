package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.ProposalCreationProcessService;
import com.mycompany.myapp.service.dto.ProposalCreationProcessDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.ProposalCreationProcess}.
 */
@RestController
@RequestMapping("/api")
public class ProposalCreationProcessResource {

    private final Logger log = LoggerFactory.getLogger(ProposalCreationProcessResource.class);

    private static final String ENTITY_NAME = "proposalCreationProcess";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ProposalCreationProcessService proposalCreationProcessService;

    public ProposalCreationProcessResource(ProposalCreationProcessService proposalCreationProcessService) {
        this.proposalCreationProcessService = proposalCreationProcessService;
    }

    /**
     * {@code POST  /proposal-creation-processes} : Create a new proposalCreationProcess.
     *
     * @param proposalCreationProcessDTO the proposalCreationProcessDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new proposalCreationProcessDTO, or with status {@code 400 (Bad Request)} if the proposalCreationProcess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/proposal-creation-processes")
    public ResponseEntity<ProposalCreationProcessDTO> create(@RequestBody ProposalCreationProcessDTO proposalCreationProcessDTO)
        throws URISyntaxException {
        log.debug("REST request to save ProposalCreationProcess : {}", proposalCreationProcessDTO);
        if (proposalCreationProcessDTO.getId() != null) {
            throw new BadRequestAlertException("A new proposalCreationProcess cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProposalCreationProcessDTO result = proposalCreationProcessService.create(proposalCreationProcessDTO);
        return ResponseEntity
            .created(new URI("/api/proposal-creation-processes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /proposal-creation-processes} : get all the proposalCreationProcesss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of proposalCreationProcesss in body.
     */
    @GetMapping("/proposal-creation-processes")
    public List<ProposalCreationProcessDTO> getAllProposalCreationProcesss() {
        log.debug("REST request to get all ProposalCreationProcesss");
        return proposalCreationProcessService.findAll();
    }

    /**
     * {@code GET  /proposal-creation-processes/:id} : get the "id" proposalCreationProcess.
     *
     * @param processInstanceId the id of the proposalCreationProcessDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the proposalCreationProcessDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/proposal-creation-processes/{processInstanceId}")
    public ResponseEntity<ProposalCreationProcessDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get ProposalCreationProcess by processInstanceId : {}", processInstanceId);
        Optional<ProposalCreationProcessDTO> proposalCreationProcessDTO = proposalCreationProcessService.findByProcessInstanceId(
            processInstanceId
        );
        return ResponseUtil.wrapOrNotFound(proposalCreationProcessDTO);
    }
}
