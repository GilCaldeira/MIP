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

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "travel_services")
    private String travelServices;

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

    public String getCustomerName() {
        return this.customerName;
    }

    public TravelPlan customerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTravelServices() {
        return this.travelServices;
    }

    public TravelPlan travelServices(String travelServices) {
        this.travelServices = travelServices;
        return this;
    }

    public void setTravelServices(String travelServices) {
        this.travelServices = travelServices;
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
            ", customerName='" + getCustomerName() + "'" +
            ", travelServices='" + getTravelServices() + "'" +
            "}";
    }
}
