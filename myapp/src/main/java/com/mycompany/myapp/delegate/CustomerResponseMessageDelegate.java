package com.mycompany.myapp.delegate;

import com.mycompany.myapp.service.ProposalService;
import com.mycompany.myapp.service.dto.ProposalCreationProcessDTO;
import com.mycompany.myapp.service.dto.ProposalDTO;
import java.util.Locale;
import java.util.Random;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.EventSubscription;
import org.camunda.bpm.engine.runtime.Execution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerResponseMessageDelegate implements JavaDelegate {

    @Autowired
    ProposalService proposalService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ProposalCreationProcessDTO proposalCreationProcess = (ProposalCreationProcessDTO) delegateExecution.getVariable("processInstance");
        ProposalDTO proposal = proposalCreationProcess.getProposal();
        String state = proposal.getState();
        // Random rand = new Random();
        // int randomNumber = rand.nextInt(1000);

        if (state == null) {
            proposal.setState("Refused");
        } else {
            proposal.setState("Approved");
        }

        proposalService.save(proposal);

        System.out.println(proposal);

        System.out.println("Aquiiii!");
        // String businessKey = execution.getProcessBusinessKey();
        // System.out.println(businessKey);

        // execution.getProcessEngineServices().getRuntimeService()
        //   .createMessageCorrelation("CustomerResponseMessage")
        //   .processInstanceBusinessKey(businessKey)
        //   .setVariable("CANCEL_REASON", "someReason")
        //   .correlate();
    }
}
