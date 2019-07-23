package pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PolicyUnregisteredEvent {
    private Long policyAccountId;
    private Long policyDocumentId;
    private String policyNumber;
}
