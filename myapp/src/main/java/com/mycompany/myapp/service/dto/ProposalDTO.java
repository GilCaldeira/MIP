package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.Proposal} entity.
 */
public class ProposalDTO implements Serializable {

    private Long id;

    private String name;

    private String customerName;

    private String customerEmail;

    private String travelName;

    private LocalDate travelStartDate;

    private LocalDate travelEndDate;

    private String travelType;

    private String suggestedAirlines;

    private String suggestedHotels;

    private String otherSuggestedTravelServices;

    private String state;

    private String customerFeedback;

    private String examplesOtherTravelServices;

    private String airlineTicketNumber;

    private String hotelBookingNumber;

    private String carBookingNumber;

    private Boolean carRentalIncluded;

    private String applicationUserName;

    private String applicationPassword;

    private CustomerDTO customer;

    private TravelPlanDTO travelPlan;

    private AirlineCompanyDTO airlineCompany;

    private HotelDTO hotel;

    private RentalCarCompanyDTO rentalCarCompany;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
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

    public String getOtherSuggestedTravelServices() {
        return otherSuggestedTravelServices;
    }

    public void setOtherSuggestedTravelServices(String otherSuggestedTravelServices) {
        this.otherSuggestedTravelServices = otherSuggestedTravelServices;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCustomerFeedback() {
        return customerFeedback;
    }

    public void setCustomerFeedback(String customerFeedback) {
        this.customerFeedback = customerFeedback;
    }

    public String getExamplesOtherTravelServices() {
        return examplesOtherTravelServices;
    }

    public void setExamplesOtherTravelServices(String examplesOtherTravelServices) {
        this.examplesOtherTravelServices = examplesOtherTravelServices;
    }

    public String getAirlineTicketNumber() {
        return airlineTicketNumber;
    }

    public void setAirlineTicketNumber(String airlineTicketNumber) {
        this.airlineTicketNumber = airlineTicketNumber;
    }

    public String getHotelBookingNumber() {
        return hotelBookingNumber;
    }

    public void setHotelBookingNumber(String hotelBookingNumber) {
        this.hotelBookingNumber = hotelBookingNumber;
    }

    public String getCarBookingNumber() {
        return carBookingNumber;
    }

    public void setCarBookingNumber(String carBookingNumber) {
        this.carBookingNumber = carBookingNumber;
    }

    public Boolean getCarRentalIncluded() {
        return carRentalIncluded;
    }

    public void setCarRentalIncluded(Boolean carRentalIncluded) {
        this.carRentalIncluded = carRentalIncluded;
    }

    public String getApplicationUserName() {
        return applicationUserName;
    }

    public void setApplicationUserName(String applicationUserName) {
        this.applicationUserName = applicationUserName;
    }

    public String getApplicationPassword() {
        return applicationPassword;
    }

    public void setApplicationPassword(String applicationPassword) {
        this.applicationPassword = applicationPassword;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public TravelPlanDTO getTravelPlan() {
        return travelPlan;
    }

    public void setTravelPlan(TravelPlanDTO travelPlan) {
        this.travelPlan = travelPlan;
    }

    public AirlineCompanyDTO getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(AirlineCompanyDTO airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public HotelDTO getHotel() {
        return hotel;
    }

    public void setHotel(HotelDTO hotel) {
        this.hotel = hotel;
    }

    public RentalCarCompanyDTO getRentalCarCompany() {
        return rentalCarCompany;
    }

    public void setRentalCarCompany(RentalCarCompanyDTO rentalCarCompany) {
        this.rentalCarCompany = rentalCarCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProposalDTO)) {
            return false;
        }

        ProposalDTO proposalDTO = (ProposalDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, proposalDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProposalDTO{" +
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
            ", customer=" + getCustomer() +
            ", travelPlan=" + getTravelPlan() +
            ", airlineCompany=" + getAirlineCompany() +
            ", hotel=" + getHotel() +
            ", rentalCarCompany=" + getRentalCarCompany() +
            "}";
    }
}
