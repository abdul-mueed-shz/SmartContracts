package com.olab.smart.contract.adapter.in.web.mapper;

import com.olab.smart.contract.domain.participant.model.ParticipantInfo;
import com.olab.smart.contract.domain.smartcontract.model.SmartContractInfo;
import com.olab.smart.contract.domain.smartcontract.model.SmartContractRecord;
import com.olab.smart.contract.dto.ContractParticipantResponse;
import com.olab.smart.contract.dto.SmartContractResponse;
import com.olab.smart.contract.dto.CreateSmartContractRequest;
import com.olab.smart.contract.dto.UpdateSmartContractRequest;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SmartContractDtoMapper {

    List<SmartContractResponse> map(List<SmartContractInfo> smartContractInfoList);

    SmartContractResponse map(SmartContractInfo smartContractInfo);

    List<ContractParticipantResponse> mapParticipantList(List<ParticipantInfo> participantInfo);

    ContractParticipantResponse mapParticipant(ParticipantInfo participantInfo);

    SmartContractRecord map(CreateSmartContractRequest createSmartContractRequest);

    SmartContractRecord map(UpdateSmartContractRequest updateSmartContractRequest);
}
