package com.olab.smart.contract.domain.smartcontract.model;

import com.olab.smart.contract.domain.participant.model.ParticipantRecord;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

public record SmartContractRecord(
        Long id,
        String creatorAddress,
        String description,          // Brief description of the contract
        List<ParticipantRecord> participants,    // List of participant addresses
        Boolean isActive
) {

    public SmartContractRecord(
            Long id,
            String creatorAddress,
            String description,
            List<ParticipantRecord> participants,
            Boolean isActive) {
        this.id = id;
        this.creatorAddress = creatorAddress;
        this.description = description;
        this.participants = participants != null ? List.copyOf(participants) : List.of(); // Defensive copy
        this.isActive = Objects.nonNull(isActive) ? isActive : Boolean.TRUE;
    }
}
