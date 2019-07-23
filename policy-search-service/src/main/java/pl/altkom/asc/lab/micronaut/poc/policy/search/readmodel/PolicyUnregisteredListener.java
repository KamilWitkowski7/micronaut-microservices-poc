package pl.altkom.asc.lab.micronaut.poc.policy.search.readmodel;

import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.events.PolicyUnregisteredEvent;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaListener(clientId = "policy-unregistered-listener", offsetReset = OffsetReset.EARLIEST)
public class PolicyUnregisteredListener extends AbstractPolicyListener {

    @Topic("policy-unregistered")
    void onPolicyRegistered(PolicyUnregisteredEvent event) {
        deletePolicyView(event.getPolicyNumber());
    }
}
