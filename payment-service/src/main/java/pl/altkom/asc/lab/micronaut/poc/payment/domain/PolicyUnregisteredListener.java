package pl.altkom.asc.lab.micronaut.poc.payment.domain;

import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.events.PolicyUnregisteredEvent;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@KafkaListener(offsetReset = OffsetReset.EARLIEST)
public class PolicyUnregisteredListener {
    private final PolicyAccountRepository policyAccountRepository;

    @Topic("policy-unregistered")
    void onPolicyUnregistered(PolicyUnregisteredEvent event) {
        policyAccountRepository.delete(event.getPolicyAccountId());
    }
}
