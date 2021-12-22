package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.TravelPlanDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TravelPlan} and its DTO {@link TravelPlanDTO}.
 */
@Mapper(componentModel = "spring", uses = { CustomerMapper.class })
public interface TravelPlanMapper extends EntityMapper<TravelPlanDTO, TravelPlan> {
    @Mapping(target = "customer", source = "customer", qualifiedByName = "name")
    TravelPlanDTO toDto(TravelPlan s);

    @Named("travelName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "travelName", source = "travelName")
    TravelPlanDTO toDtoTravelName(TravelPlan travelPlan);
}
