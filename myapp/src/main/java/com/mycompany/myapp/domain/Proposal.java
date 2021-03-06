package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Proposal.
 */
@Entity
@Table(name = "proposal")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Proposal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_email")
    private String customerEmail;

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

    @Column(name = "state")
    private String state;

    @Column(name = "customer_feedback")
    private String customerFeedback;

    @Column(name = "examples_other_travel_services")
    private String examplesOtherTravelServices;

    @Column(name = "airline_ticket_number")
    private String airlineTicketNumber;

    @Column(name = "hotel_booking_number")
    private String hotelBookingNumber;

    @Column(name = "car_booking_number")
    private String carBookingNumber;

    @Column(name = "car_rental_included")
    private Boolean carRentalIncluded;

    @Column(name = "application_user_name")
    private String applicationUserName;

    @Column(name = "application_password")
    private String applicationPassword;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    @JsonIgnoreProperties(value = { "customer" }, allowSetters = true)
    private TravelPlan travelPlan;

    @ManyToOne
    private AirlineCompany airlineCompany;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private RentalCarCompany rentalCarCompany;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proposal id(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Proposal name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public Proposal customerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return this.customerEmail;
    }

    public Proposal customerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getTravelName() {
        return this.travelName;
    }

    public Proposal travelName(String travelName) {
        this.travelName = travelName;
        return this;
    }

    public void setTravelName(String travelName) {
        this.travelName = travelName;
    }

    public LocalDate getTravelStartDate() {
        return this.travelStartDate;
    }

    public Proposal travelStartDate(LocalDate travelStartDate) {
        this.travelStartDate = travelStartDate;
        return this;
    }

    public void setTravelStartDate(LocalDate travelStartDate) {
        this.travelStartDate = travelStartDate;
    }

    public LocalDate getTravelEndDate() {
        return this.travelEndDate;
    }

    public Proposal travelEndDate(LocalDate travelEndDate) {
        this.travelEndDate = travelEndDate;
        return this;
    }

    public void setTravelEndDate(LocalDate travelEndDate) {
        this.travelEndDate = travelEndDate;
    }

    public String getTravelType() {
        return this.travelType;
    }

    public Proposal travelType(String travelType) {
        this.travelType = travelType;
        return this;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    public String getSuggestedAirlines() {
        return this.suggestedAirlines;
    }

    public Proposal suggestedAirlines(String suggestedAirlines) {
        this.suggestedAirlines = suggestedAirlines;
        return this;
    }

    public void setSuggestedAirlines(String suggestedAirlines) {
        this.suggestedAirlines = suggestedAirlines;
    }

    public String getSuggestedHotels() {
        return this.suggestedHotels;
    }

    public Proposal suggestedHotels(String suggestedHotels) {
        this.suggestedHotels = suggestedHotels;
        return this;
    }

    public void setSuggestedHotels(String suggestedHotels) {
        this.suggestedHotels = suggestedHotels;
    }

    public String getOtherSuggestedTravelServices() {
        return this.otherSuggestedTravelServices;
    }

    public Proposal otherSuggestedTravelServices(String otherSuggestedTravelServices) {
        this.otherSuggestedTravelServices = otherSuggestedTravelServices;
        return this;
    }

    public void setOtherSuggestedTravelServices(String otherSuggestedTravelServices) {
        this.otherSuggestedTravelServices = otherSuggestedTravelServices;
    }

    public String getState() {
        return this.state;
    }

    public Proposal state(String state) {
        this.state = state;
        return this;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCustomerFeedback() {
        return this.customerFeedback;
    }

    public Proposal customerFeedback(String customerFeedback) {
        this.customerFeedback = customerFeedback;
        return this;
    }

    public void setCustomerFeedback(String customerFeedback) {
        this.customerFeedback = customerFeedback;
    }

    public String getExamplesOtherTravelServices() {
        return this.examplesOtherTravelServices;
    }

    public Proposal examplesOtherTravelServices(String examplesOtherTravelServices) {
        this.examplesOtherTravelServices = examplesOtherTravelServices;
        return this;
    }

    public void setExamplesOtherTravelServices(String examplesOtherTravelServices) {
        this.examplesOtherTravelServices = examplesOtherTravelServices;
    }

    public String getAirlineTicketNumber() {
        return this.airlineTicketNumber;
    }

    public Proposal airlineTicketNumber(String airlineTicketNumber) {
        this.airlineTicketNumber = airlineTicketNumber;
        return this;
    }

    public void setAirlineTicketNumber(String airlineTicketNumber) {
        this.airlineTicketNumber = airlineTicketNumber;
    }

    public String getHotelBookingNumber() {
        return this.hotelBookingNumber;
    }

    public Proposal hotelBookingNumber(String hotelBookingNumber) {
        this.hotelBookingNumber = hotelBookingNumber;
        return this;
    }

    public void setHotelBookingNumber(String hotelBookingNumber) {
        this.hotelBookingNumber = hotelBookingNumber;
    }

    public String getCarBookingNumber() {
        return this.carBookingNumber;
    }

    public Proposal carBookingNumber(String carBookingNumber) {
        this.carBookingNumber = carBookingNumber;
        return this;
    }

    public void setCarBookingNumber(String carBookingNumber) {
        this.carBookingNumber = carBookingNumber;
    }

    public Boolean getCarRentalIncluded() {
        return this.carRentalIncluded;
    }

    public Proposal carRentalIncluded(Boolean carRentalIncluded) {
        this.carRentalIncluded = carRentalIncluded;
        return this;
    }

    public void setCarRentalIncluded(Boolean carRentalIncluded) {
        this.carRentalIncluded = carRentalIncluded;
    }

    public String getApplicationUserName() {
        return this.applicationUserName;
    }

    public Proposal applicationUserName(String applicationUserName) {
        this.applicationUserName = applicationUserName;
        return this;
    }

    public void setApplicationUserName(String applicationUserName) {
        this.applicationUserName = applicationUserName;
    }

    public String getApplicationPassword() {
        return this.applicationPassword;
    }

    public Proposal applicationPassword(String applicationPassword) {
        this.applicationPassword = applicationPassword;
        return this;
    }

    public void setApplicationPassword(String applicationPassword) {
        this.applicationPassword = applicationPassword;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Proposal customer(Customer customer) {
        this.setCustomer(customer);
        return this;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TravelPlan getTravelPlan() {
        return this.travelPlan;
    }

    public Proposal travelPlan(TravelPlan travelPlan) {
        this.setTravelPlan(travelPlan);
        return this;
    }

    public void setTravelPlan(TravelPlan travelPlan) {
        this.travelPlan = travelPlan;
    }

    public AirlineCompany getAirlineCompany() {
        return this.airlineCompany;
    }

    public Proposal airlineCompany(AirlineCompany airlineCompany) {
        this.setAirlineCompany(airlineCompany);
        return this;
    }

    public void setAirlineCompany(AirlineCompany airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public Hotel getHotel() {
        return this.hotel;
    }

    public Proposal hotel(Hotel hotel) {
        this.setHotel(hotel);
        return this;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public RentalCarCompany getRentalCarCompany() {
        return this.rentalCarCompany;
    }

    public Proposal rentalCarCompany(RentalCarCompany rentalCarCompany) {
        this.setRentalCarCompany(rentalCarCompany);
        return this;
    }

    public void setRentalCarCompany(RentalCarCompany rentalCarCompany) {
        this.rentalCarCompany = rentalCarCompany;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Proposal)) {
            return false;
        }
        return id != null && id.equals(((Proposal) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Proposal{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", customerName='" + getCustomerName() + "'" +
            ", customerEmail='" + getCustomerEmail() + "'" +
            ", travelName='" + getTravelName() + "'" +
            ", travelStartDate='" + getTravelStartDate() + "'" +
            ", travelEndDate='" + getTravelEndDate() + "'" +
            ", travelType='" + getTravelType() + "'" +
            ", suggestedAirlines='" + getSuggestedAirlines() + "'" +
            ", suggestedHotels='" + getSuggestedHotels() + "'" +
            ", otherSuggestedTravelServices='" + getOtherSuggestedTravelServices() + "'" +
            ", state='" + getState() + "'" +
            ", customerFeedback='" + getCustomerFeedback() + "'" +
            ", examplesOtherTravelServices='" + getExamplesOtherTravelServices() + "'" +
            ", airlineTicketNumber='" + getAirlineTicketNumber() + "'" +
            ", hotelBookingNumber='" + getHotelBookingNumber() + "'" +
            ", carBookingNumber='" + getCarBookingNumber() + "'" +
            ", carRentalIncluded='" + getCarRentalIncluded() + "'" +
            ", applicationUserName='" + getApplicationUserName() + "'" +
            ", applicationPassword='" + getApplicationPassword() + "'" +
            "}";
    }
}
