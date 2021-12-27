package com.mycompany.myapp.delegate;

import com.mycompany.myapp.service.MailService;
import com.mycompany.myapp.service.dto.ProposalCreationProcessDTO;
import com.mycompany.myapp.service.dto.ProposalDTO;
import java.util.Locale;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Component
public class ProposalSummaryEmailDelegate implements JavaDelegate {

    @Autowired
    MailService mailService;

    @Autowired
    SpringTemplateEngine templateEngine;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ProposalCreationProcessDTO proposalCreationProcess = (ProposalCreationProcessDTO) delegateExecution.getVariable("processInstance");
        ProposalDTO proposal = proposalCreationProcess.getProposal();

        System.out.println("Aquiiiiii");
        System.out.println(proposalCreationProcess);
        System.out.println(proposal);

        String to = proposal.getCustomerEmail();
        String subject = "[AgileKip] Summary of your travel proposal " + proposal.getName();

        Context context = new Context(Locale.getDefault());
        context.setVariable("proposal", proposal);

        String content = templateEngine.process("proposalCreationProcess/proposalSummaryEmail", context);
        mailService.sendEmail(to, subject, content, false, true);
    }
}
