package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.ProposalDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Proposal} and its DTO {@link ProposalDTO}.
 */
@Mapper(
    componentModel = "spring",
    uses = { CustomerMapper.class, TravelPlanMapper.class, AirlineCompanyMapper.class, HotelMapper.class, RentalCarCompanyMapper.class }
)
public interface ProposalMapper extends EntityMapper<ProposalDTO, Proposal> {
    @Mapping(target = "customer", source = "customer", qualifiedByName = "name")
    @Mapping(target = "travelPlan", source = "travelPlan", qualifiedByName = "travelName")
    @Mapping(target = "airlineCompany", source = "airlineCompany", qualifiedByName = "name")
    @Mapping(target = "hotel", source = "hotel", qualifiedByName = "name")
    @Mapping(target = "rentalCarCompany", source = "rentalCarCompany", qualifiedByName = "name")
    ProposalDTO toDto(Proposal s);
}
