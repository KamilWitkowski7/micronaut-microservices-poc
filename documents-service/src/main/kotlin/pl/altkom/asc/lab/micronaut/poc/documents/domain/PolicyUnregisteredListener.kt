package pl.altkom.asc.lab.micronaut.poc.documents.domain

import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.http.annotation.Header
import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.events.PolicyUnregisteredEvent

@KafkaListener(clientId = "policy-unregistered-listener", offsetReset = OffsetReset.EARLIEST)
@Header(name = "Content-Type", value = "application/json")
class PolicyUnregisteredListener(private val policyDocumentRepository: PolicyDocumentRepository) {

    @Topic("policy-unregistered")
    fun onPolicyUnregistered(event: PolicyUnregisteredEvent) {
        policyDocumentRepository.delete(event.policyDocumentId)
    }
}
