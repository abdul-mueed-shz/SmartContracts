package com.olab.smart.contract.adapter.out.persistence.repository;

import com.olab.smart.contract.adapter.out.persistence.entity.SmartContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartContractJpaRepository extends JpaRepository<SmartContract, Long> {

}
