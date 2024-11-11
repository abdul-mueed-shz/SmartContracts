package com.olab.smart.contract.domain.smartcontract.usecase;

import com.olab.smart.contract.domain.smartcontract.model.SmartContractRecord;
import com.olab.smart.contract.domain.smartcontract.port.in.CreateSmartContractUseCase;
import com.olab.smart.contract.domain.smartcontract.port.out.repository.SmartContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSmartContractUseCaseImpl implements CreateSmartContractUseCase {

    private final SmartContractRepository smartContractRepository;

    public Long createContract(SmartContractRecord smartContractRecord) {
        return smartContractRepository.saveContract(smartContractRecord);
    }
}
