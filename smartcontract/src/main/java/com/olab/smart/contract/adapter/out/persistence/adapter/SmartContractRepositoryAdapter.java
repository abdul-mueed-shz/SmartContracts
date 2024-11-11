package com.olab.smart.contract.adapter.out.persistence.adapter;

import com.olab.smart.contract.adapter.out.persistence.entity.SmartContract;
import com.olab.smart.contract.adapter.out.persistence.mapper.SmartContractMapper;
import com.olab.smart.contract.adapter.out.persistence.repository.SmartContractJpaRepository;
import com.olab.smart.contract.domain.smartcontract.model.SmartContractInfo;
import com.olab.smart.contract.domain.smartcontract.model.SmartContractRecord;
import com.olab.smart.contract.domain.smartcontract.port.out.repository.SmartContractRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SmartContractRepositoryAdapter implements SmartContractRepository {

    private final SmartContractJpaRepository smartContractJpaRepository;
    private final SmartContractMapper smartContractMapper;

    @Override
    public Long saveContract(SmartContractRecord smartContractRecord) {
        SmartContract smartContract = smartContractJpaRepository.save(smartContractMapper.map(smartContractRecord));
        return smartContract.getId();
    }

    @Override
    public void updateContract(SmartContractRecord smartContractRecord) {
        Optional<SmartContract> smartContractOptional = smartContractJpaRepository.findById(smartContractRecord.id());
        smartContractOptional.ifPresent(smartContract -> smartContractJpaRepository.save(
                smartContractMapper.map(smartContractRecord, smartContract)));
    }

    @Override
    public List<SmartContractInfo> getContracts() {
        return smartContractMapper.map(smartContractJpaRepository.findAll());
    }

    @Override
    public SmartContractInfo getContractDetail(Long contractId) {
        Optional<SmartContract> smartContract = smartContractJpaRepository.findById(contractId);
        return smartContract.map(smartContractMapper::map).orElse(null);
    }

    @Override
    public Boolean existById(Long contractId) {
        return smartContractJpaRepository.existsById(contractId);
    }

    @Override
    public void deleteById(Long contractId) {
        smartContractJpaRepository.deleteById(contractId);
    }

}
