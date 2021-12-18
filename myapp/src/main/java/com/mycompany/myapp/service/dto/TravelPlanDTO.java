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

    private String customerName;

    private String travelServices;

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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTravelServices() {
        return travelServices;
    }

    public void setTravelServices(String travelServices) {
        this.travelServices = travelServices;
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
            ", customerName='" + getCustomerName() + "'" +
            ", travelServices='" + getTravelServices() + "'" +
            "}";
    }
}
