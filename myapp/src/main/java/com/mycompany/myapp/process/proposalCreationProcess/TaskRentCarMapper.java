package com.mycompany.myapp.process.proposalCreationProcess;

import com.mycompany.myapp.domain.Proposal;
import com.mycompany.myapp.domain.ProposalCreationProcess;
import com.mycompany.myapp.domain.RentalCarCompany;
import com.mycompany.myapp.service.dto.ProposalCreationProcessDTO;
import com.mycompany.myapp.service.dto.ProposalDTO;
import com.mycompany.myapp.service.dto.RentalCarCompanyDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class })
public interface TaskRentCarMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    ProposalCreationProcessDTO toProposalCreationProcessDTO(ProposalCreationProcess proposalCreationProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "travelName", source = "travelName")
    @Mapping(target = "travelStartDate", source = "travelStartDate")
    @Mapping(target = "travelEndDate", source = "travelEndDate")
    @Mapping(target = "carBookingNumber", source = "carBookingNumber")
    @Mapping(target = "rentalCarCompany", source = "rentalCarCompany")
    ProposalDTO toProposalDTO(Proposal proposal);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    RentalCarCompanyDTO toRentalCarCompanyDTO(RentalCarCompany name);
}
