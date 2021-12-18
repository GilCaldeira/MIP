package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.ProposalCreationProcess;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the ProposalCreationProcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProposalCreationProcessRepository extends JpaRepository<ProposalCreationProcess, Long> {
    Optional<ProposalCreationProcess> findByProcessInstanceId(Long processInstanceId);
}
