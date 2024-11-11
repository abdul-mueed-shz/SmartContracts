package com.olab.smart.contract.domain.smartcontract.model;

import com.olab.smart.contract.domain.participant.model.ParticipantInfo;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class SmartContractInfo {

    private Long id;
    private String version;
    private String creatorAddress;
    private LocalDateTime createdOn;
    private LocalDateTime updatedAt;
    private String description;
    private Boolean isActive;
    List<ParticipantInfo> participants;
}
