package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.ProposalRepository;
import com.mycompany.myapp.service.ProposalService;
import com.mycompany.myapp.service.dto.ProposalDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.Proposal}.
 */
@RestController
@RequestMapping("/api")
public class ProposalResource {

    private final Logger log = LoggerFactory.getLogger(ProposalResource.class);

    private final ProposalService proposalService;

    private final ProposalRepository proposalRepository;

    public ProposalResource(ProposalService proposalService, ProposalRepository proposalRepository) {
        this.proposalService = proposalService;
        this.proposalRepository = proposalRepository;
    }

    /**
     * {@code GET  /proposals} : get all the proposals.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of proposals in body.
     */
    @GetMapping("/proposals")
    public List<ProposalDTO> getAllProposals() {
        log.debug("REST request to get all Proposals");
        return proposalService.findAll();
    }

    /**
     * {@code GET  /proposals/:id} : get the "id" proposal.
     *
     * @param id the id of the proposalDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the proposalDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/proposals/{id}")
    public ResponseEntity<ProposalDTO> getProposal(@PathVariable Long id) {
        log.debug("REST request to get Proposal : {}", id);
        Optional<ProposalDTO> proposalDTO = proposalService.findOne(id);
        return ResponseUtil.wrapOrNotFound(proposalDTO);
    }
}
