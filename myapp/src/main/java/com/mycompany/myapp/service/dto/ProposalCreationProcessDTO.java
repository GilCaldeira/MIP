package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;
import org.akip.service.dto.ProcessInstanceDTO;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.ProposalCreationProcess} entity.
 */
public class ProposalCreationProcessDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private ProposalDTO proposal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProcessInstanceDTO getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstanceDTO processInstance) {
        this.processInstance = processInstance;
    }

    public ProposalDTO getProposal() {
        return proposal;
    }

    public void setProposal(ProposalDTO proposal) {
        this.proposal = proposal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProposalCreationProcessDTO)) {
            return false;
        }

        ProposalCreationProcessDTO proposalCreationProcessDTO = (ProposalCreationProcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, proposalCreationProcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProposalCreationProcessDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", proposal=" + getProposal() +
            "}";
    }
}
