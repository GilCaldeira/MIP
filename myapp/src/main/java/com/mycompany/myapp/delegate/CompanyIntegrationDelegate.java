package com.mycompany.myapp.delegate;

import com.mycompany.myapp.service.AccommodationService;
import com.mycompany.myapp.service.AirlineService;
import com.mycompany.myapp.service.ProposalService;
import com.mycompany.myapp.service.RentalCarService;
import com.mycompany.myapp.service.dto.ProposalCreationProcessDTO;
import com.mycompany.myapp.service.dto.ProposalDTO;
import java.util.Locale;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyIntegrationDelegate implements JavaDelegate {

    @Autowired
    ProposalService proposalService;

    @Autowired
    AirlineService airlineService;

    @Autowired
    AccommodationService accommodationService;

    @Autowired
    RentalCarService rentalCarService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ProposalCreationProcessDTO proposalCreationProcess = (ProposalCreationProcessDTO) delegateExecution.getVariable("processInstance");
        ProposalDTO proposal = proposalCreationProcess.getProposal();

        //Confirming the flight
        airlineService.confirmFlight(proposal.getAirlineTicketNumber());

        //Confirming the hotel booking
        accommodationService.confirmReservation(proposal.getHotelBookingNumber());

        //Confirming the car booking
        if (proposal.getCarRentalIncluded() == true) {
            rentalCarService.confirmReservation(proposal.getCarBookingNumber());
        }
    }
}
