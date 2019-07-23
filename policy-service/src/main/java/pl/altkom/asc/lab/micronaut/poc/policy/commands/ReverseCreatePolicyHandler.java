package pl.altkom.asc.lab.micronaut.poc.policy.commands;

import pl.altkom.asc.lab.micronaut.poc.command.bus.CommandHandler;
import pl.altkom.asc.lab.micronaut.poc.policy.domain.PolicyRepository;
import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.reversecreatepolicy.ReverseCreatePolicyCommand;

import javax.inject.Singleton;

import io.micronaut.spring.tx.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class ReverseCreatePolicyHandler implements CommandHandler<Void, ReverseCreatePolicyCommand> {
    private final PolicyRepository policyRepository;

    @Transactional
    @Override
    public Void handle(ReverseCreatePolicyCommand cmd) {
        policyRepository.delete(cmd.getPolicyId());
        return null;
    }
}
