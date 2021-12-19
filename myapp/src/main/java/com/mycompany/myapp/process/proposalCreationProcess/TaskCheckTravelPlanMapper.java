package com.mycompany.myapp.process.proposalCreationProcess;

import com.mycompany.myapp.domain.Proposal;
import com.mycompany.myapp.domain.ProposalCreationProcess;
import com.mycompany.myapp.service.dto.ProposalCreationProcessDTO;
import com.mycompany.myapp.service.dto.ProposalDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class })
public interface TaskCheckTravelPlanMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    ProposalCreationProcessDTO toProposalCreationProcessDTO(ProposalCreationProcess proposalCreationProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "customerName", source = "customerName")
    @Mapping(target = "customerEmail", source = "customerEmail")
    ProposalDTO toProposalDTO(Proposal proposal);
}
