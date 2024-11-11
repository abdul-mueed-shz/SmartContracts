package com.olab.smart.contract.domain.smartcontract.usecase;

import com.olab.smart.contract.domain.smartcontract.model.SmartContractInfo;
import com.olab.smart.contract.domain.smartcontract.model.SmartContractRecord;
import com.olab.smart.contract.domain.smartcontract.port.in.GetSmartContractDetailUseCase;
import com.olab.smart.contract.domain.smartcontract.port.in.UpdateSmartContractUseCase;
import com.olab.smart.contract.domain.smartcontract.port.out.repository.SmartContractRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UpdateSmartContractUseCaseImpl implements UpdateSmartContractUseCase {

    private final SmartContractRepository smartContractRepository;
    private final GetSmartContractDetailUseCase getSmartContractDetailUseCase;

    @Override
    public void updateContract(SmartContractRecord smartContractRecord) {
        SmartContractInfo smartContractInfo = getSmartContractDetailUseCase.getContractDetail(smartContractRecord.id());
        if (Objects.isNull(smartContractInfo)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Smart Contract not found");
        }
        smartContractRepository.updateContract(smartContractRecord);
    }
}