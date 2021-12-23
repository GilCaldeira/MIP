package com.mycompany.myapp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A TravelPlan.
 */
@Entity
@Table(name = "travel_plan")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TravelPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "travel_name")
    private String travelName;

    @Column(name = "travel_start_date")
    private LocalDate travelStartDate;

    @Column(name = "travel_end_date")
    private LocalDate travelEndDate;

    @Column(name = "travel_type")
    private String travelType;

    @Column(name = "suggested_airlines")
    private String suggestedAirlines;

    @Column(name = "suggested_hotels")
    private String suggestedHotels;

    @Column(name = "other_suggested_travel_services")
    private String otherSuggestedTravelServices;

    @Column(name = "car_rental_included")
    private Boolean carRentalIncluded;

    @ManyToOne
    private Customer customer;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TravelPlan id(Long id) {
        this.id = id;
        return this;
    }

    public String getTravelName() {
        return this.travelName;
    }

    public TravelPlan travelName(String travelName) {
        this.travelName = travelName;
        return this;
    }

    public void setTravelName(String travelName) {
        this.travelName = travelName;
    }

    public LocalDate getTravelStartDate() {
        return this.travelStartDate;
    }

    public TravelPlan travelStartDate(LocalDate travelStartDate) {
        this.travelStartDate = travelStartDate;
        return this;
    }

    public void setTravelStartDate(LocalDate travelStartDate) {
        this.travelStartDate = travelStartDate;
    }

    public LocalDate getTravelEndDate() {
        return this.travelEndDate;
    }

    public TravelPlan travelEndDate(LocalDate travelEndDate) {
        this.travelEndDate = travelEndDate;
        return this;
    }

    public void setTravelEndDate(LocalDate travelEndDate) {
        this.travelEndDate = travelEndDate;
    }

    public String getTravelType() {
        return this.travelType;
    }

    public TravelPlan travelType(String travelType) {
        this.travelType = travelType;
        return this;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    public String getSuggestedAirlines() {
        return this.suggestedAirlines;
    }

    public TravelPlan suggestedAirlines(String suggestedAirlines) {
        this.suggestedAirlines = suggestedAirlines;
        return this;
    }

    public void setSuggestedAirlines(String suggestedAirlines) {
        this.suggestedAirlines = suggestedAirlines;
    }

    public String getSuggestedHotels() {
        return this.suggestedHotels;
    }

    public TravelPlan suggestedHotels(String suggestedHotels) {
        this.suggestedHotels = suggestedHotels;
        return this;
    }

    public void setSuggestedHotels(String suggestedHotels) {
        this.suggestedHotels = suggestedHotels;
    }

    public String getOtherSuggestedTravelServices() {
        return this.otherSuggestedTravelServices;
    }

    public TravelPlan otherSuggestedTravelServices(String otherSuggestedTravelServices) {
        this.otherSuggestedTravelServices = otherSuggestedTravelServices;
        return this;
    }

    public void setOtherSuggestedTravelServices(String otherSuggestedTravelServices) {
        this.otherSuggestedTravelServices = otherSuggestedTravelServices;
    }

    public Boolean getCarRentalIncluded() {
        return this.carRentalIncluded;
    }

    public TravelPlan carRentalIncluded(Boolean carRentalIncluded) {
        this.carRentalIncluded = carRentalIncluded;
        return this;
    }

    public void setCarRentalIncluded(Boolean carRentalIncluded) {
        this.carRentalIncluded = carRentalIncluded;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public TravelPlan customer(Customer customer) {
        this.setCustomer(customer);
        return this;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TravelPlan)) {
            return false;
        }
        return id != null && id.equals(((TravelPlan) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TravelPlan{" +
            "id=" + getId() +
            ", travelName='" + getTravelName() + "'" +
            ", travelStartDate='" + getTravelStartDate() + "'" +
            ", travelEndDate='" + getTravelEndDate() + "'" +
            ", travelType='" + getTravelType() + "'" +
            ", suggestedAirlines='" + getSuggestedAirlines() + "'" +
            ", suggestedHotels='" + getSuggestedHotels() + "'" +
            ", otherSuggestedTravelServices='" + getOtherSuggestedTravelServices() + "'" +
            ", carRentalIncluded='" + getCarRentalIncluded() + "'" +
            "}";
    }
}
