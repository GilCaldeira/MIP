package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.ProposalDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Proposal} and its DTO {@link ProposalDTO}.
 */
@Mapper(componentModel = "spring", uses = { CustomerMapper.class, TravelPlanMapper.class })
public interface ProposalMapper extends EntityMapper<ProposalDTO, Proposal> {
    @Mapping(target = "customer", source = "customer", qualifiedByName = "name")
    @Mapping(target = "travelPlan", source = "travelPlan", qualifiedByName = "travelName")
    ProposalDTO toDto(Proposal s);
}
