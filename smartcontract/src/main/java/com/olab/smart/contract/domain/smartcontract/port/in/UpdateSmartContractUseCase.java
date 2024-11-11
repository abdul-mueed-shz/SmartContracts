package com.olab.smart.contract.domain.smartcontract.port.in;

import com.olab.smart.contract.domain.smartcontract.model.SmartContractRecord;

public interface UpdateSmartContractUseCase {

    void updateContract(SmartContractRecord smartContractRecord);
}
