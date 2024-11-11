package com.olab.smart.contract.domain.smartcontract.port.in;

import com.olab.smart.contract.domain.smartcontract.model.SmartContractInfo;

public interface GetSmartContractDetailUseCase {

    SmartContractInfo getContractDetail(Long id);
}
