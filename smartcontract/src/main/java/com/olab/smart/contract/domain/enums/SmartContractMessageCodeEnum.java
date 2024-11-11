package com.olab.smart.contract.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SmartContractMessageCodeEnum {
    SMART_CONTRACT_CREATED_SUCCESSFULLY("SC-001", "Smart Contract Created Successfully."),
    SMART_CONTRACT_UPDATED_SUCCESSFULLY("SC-002", "Smart Contract Updated Successfully."),
    SMART_CONTRACT_DELETED_SUCCESSFULLY("SC-003", "Smart Contract Deleted Successfully.");

    private final String messageCode;
    private final String messageDescription;
}
