package com.olab.smart.contract.domain.participant.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ParticipantInfo {
    private Long id;
    private String address;
    private String role;
    private LocalDateTime joinedAt;
}
