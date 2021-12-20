package com.mycompany.myapp.delegate;

import com.mycompany.myapp.service.ProposalService;
import com.mycompany.myapp.service.dto.ProposalCreationProcessDTO;
import com.mycompany.myapp.service.dto.ProposalDTO;
import java.util.Locale;
import java.util.Random;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendCustomerResponseMessageDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        ProposalCreationProcessDTO proposalCreationProcess = (ProposalCreationProcessDTO) execution.getVariable("processInstance");
        ProposalDTO proposal = proposalCreationProcess.getProposal();

        Random rand = new Random();
        int randomNumber = rand.nextInt(1000);

        if (randomNumber % 2 == 0) {
            proposal.setState("Approved");
        } else {
            proposal.setState("Refused");
        }

        System.out.println(randomNumber);

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
