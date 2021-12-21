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
    private RuntimeService runtimeService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ProposalCreationProcessDTO proposalCreationProcess = (ProposalCreationProcessDTO) delegateExecution.getVariable("processInstance");
        ProposalDTO proposal = proposalCreationProcess.getProposal();

        // EventSubscription subscription = runtimeService.createEventSubscriptionQuery()
        //     .processInstanceId(proposalCreationProcess.getId().toString()).eventType("message").singleResult();

        // runtimeService.messageEventReceived(subscription.getEventName(), subscription.getExecutionId());

        // Execution execution = runtimeService.createExecutionQuery()
        // .messageEventSubscriptionName("CustomerResponseMessage")
        // .processVariableValueEquals("orderId", message.getOrderId())
        // .singleResult();

        // System.out.println(execution);

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
