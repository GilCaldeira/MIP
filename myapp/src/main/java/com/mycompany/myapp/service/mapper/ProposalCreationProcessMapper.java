package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.ProposalCreationProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProposalCreationProcess} and its DTO {@link ProposalCreationProcessDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, ProposalMapper.class })
public interface ProposalCreationProcessMapper extends EntityMapper<ProposalCreationProcessDTO, ProposalCreationProcess> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "proposal", source = "proposal")
    ProposalCreationProcessDTO toDto(ProposalCreationProcess s);
}
