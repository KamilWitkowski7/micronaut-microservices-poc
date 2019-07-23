package pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.reversecreatepolicy;

import pl.altkom.asc.lab.micronaut.poc.command.bus.api.Command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReverseCreatePolicyCommand implements Command<Void> {
    private Long policyId;
}