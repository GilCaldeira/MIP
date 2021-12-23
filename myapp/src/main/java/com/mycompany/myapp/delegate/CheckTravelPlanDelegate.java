package com.mycompany.myapp.delegate;

import com.mycompany.myapp.domain.Proposal;
import com.mycompany.myapp.domain.ProposalCreationProcess;
import com.mycompany.myapp.domain.TravelPlan;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CheckTravelPlanDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ProposalCreationProcess proposalCreationProcess = (ProposalCreationProcess) delegateExecution.getVariable("processInstance");
        Proposal proposal = proposalCreationProcess.getProposal();
        TravelPlan travelPlan = proposal.getTravelPlan();

        proposal.setTravelName(travelPlan.getTravelName());
        proposal.setCustomerName(travelPlan.getCustomer().getName());
        proposal.setCustomerEmail(proposal.getCustomer().getEmail());
        proposal.setTravelStartDate(travelPlan.getTravelStartDate());
        proposal.setTravelEndDate(travelPlan.getTravelEndDate());
        proposal.setTravelType(travelPlan.getTravelType());
        proposal.setSuggestedAirlines(travelPlan.getSuggestedAirlines());
        proposal.setSuggestedHotels(travelPlan.getSuggestedHotels());
        proposal.setOtherSuggestedTravelServices(travelPlan.getOtherSuggestedTravelServices());
        proposal.setCarRentalIncluded(travelPlan.getCarRentalIncluded());
    }
}
