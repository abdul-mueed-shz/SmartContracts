package com.olab.smart.contract.adapter.out.persistence.mapper;

import com.olab.smart.contract.adapter.out.persistence.entity.Participant;
import com.olab.smart.contract.adapter.out.persistence.entity.SmartContract;
import com.olab.smart.contract.domain.participant.model.ParticipantInfo;
import com.olab.smart.contract.domain.smartcontract.model.SmartContractInfo;
import com.olab.smart.contract.domain.smartcontract.model.SmartContractRecord;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SmartContractMapper {

    SmartContract map(SmartContractRecord smartContractRecord);

    @Mapping(target = "id", ignore = true)
    SmartContract map(SmartContractRecord smartContractRecord, @MappingTarget SmartContract smartContract);

    SmartContractInfo map(SmartContract smartContract);

    List<SmartContractInfo> map(List<SmartContract> smartContracts);

    ParticipantInfo mapParticipant(Participant participant);

    List<ParticipantInfo> mapParticipants(List<Participant> participants);

    @AfterMapping
    default void setSmartContractId(@MappingTarget SmartContract smartContract) {
        for (Participant participant : smartContract.getParticipants()) {
            participant.setSmartContract(smartContract);
        }
    }
}
