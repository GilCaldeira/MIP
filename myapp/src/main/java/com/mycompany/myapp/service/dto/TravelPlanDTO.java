package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.TravelPlan} entity.
 */
public class TravelPlanDTO implements Serializable {

    private Long id;

    private String travelName;

    private LocalDate travelStartDate;

    private LocalDate travelEndDate;

    private String travelType;

    private String suggestedAirlines;

    private String suggestedHotels;

    private String otherTravelServices;

    private CustomerDTO customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTravelName() {
        return travelName;
    }

    public void setTravelName(String travelName) {
        this.travelName = travelName;
    }

    public LocalDate getTravelStartDate() {
        return travelStartDate;
    }

    public void setTravelStartDate(LocalDate travelStartDate) {
        this.travelStartDate = travelStartDate;
    }

    public LocalDate getTravelEndDate() {
        return travelEndDate;
    }

    public void setTravelEndDate(LocalDate travelEndDate) {
        this.travelEndDate = travelEndDate;
    }

    public String getTravelType() {
        return travelType;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    public String getSuggestedAirlines() {
        return suggestedAirlines;
    }

    public void setSuggestedAirlines(String suggestedAirlines) {
        this.suggestedAirlines = suggestedAirlines;
    }

    public String getSuggestedHotels() {
        return suggestedHotels;
    }

    public void setSuggestedHotels(String suggestedHotels) {
        this.suggestedHotels = suggestedHotels;
    }

    public String getOtherTravelServices() {
        return otherTravelServices;
    }

    public void setOtherTravelServices(String otherTravelServices) {
        this.otherTravelServices = otherTravelServices;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TravelPlanDTO)) {
            return false;
        }

        TravelPlanDTO travelPlanDTO = (TravelPlanDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, travelPlanDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TravelPlanDTO{" +
            "id=" + getId() +
            ", travelName='" + getTravelName() + "'" +
            ", travelStartDate='" + getTravelStartDate() + "'" +
            ", travelEndDate='" + getTravelEndDate() + "'" +
            ", travelType='" + getTravelType() + "'" +
            ", suggestedAirlines='" + getSuggestedAirlines() + "'" +
            ", suggestedHotels='" + getSuggestedHotels() + "'" +
            ", otherTravelServices='" + getOtherTravelServices() + "'" +
            ", customer=" + getCustomer() +
            "}";
    }
}
