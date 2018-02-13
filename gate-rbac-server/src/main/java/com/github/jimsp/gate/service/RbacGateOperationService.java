package com.github.jimsp.gate.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.jimsp.gate.canonial.OperationCanonico;
import com.github.jimsp.gate.converter.OperationCanonicoToOperationCoverter;
import com.github.jimsp.gate.converter.OperationToOperationCanonicoCoverter;
import com.github.jimsp.gate.handle.GateRmiHandle;
import com.github.jimsp.gate.rbac.entities.Operation;
import com.github.jimsp.gate.rbac.repositories.OperationJpaRepository;
import com.github.jimsp.gate.remote.RbacGateOperationRemote;

@Service(GateRmiHandle.RBAC_GATE_OPERATION_SERVICE)
public class RbacGateOperationService implements RbacGateOperationRemote {

	@Autowired
	private OperationJpaRepository operationJpaRepository;

	@Autowired
	private OperationCanonicoToOperationCoverter operationCanonicoToOperationCoverter;

	@Autowired
	private OperationToOperationCanonicoCoverter operationToOperationCanonicoCoverter;

	@Override
	@Transactional
	public void save(final OperationCanonico operationCanonico) {
		final Operation operation = operationCanonicoToOperationCoverter.convert(operationCanonico);
		operationJpaRepository.save(operation);
	}

	@Override
	@Transactional
	public void remove(final OperationCanonico operationCanonico) {
		operationJpaRepository.delete(operationCanonico.getName());
	}

	@Override
	public OperationCanonico findByName(final OperationCanonico operationCanonico) {
		final Operation operation = operationJpaRepository.findByName(operationCanonico.getName());
		return operationToOperationCanonicoCoverter.convert(operation);
	}

	@Override
	public List<OperationCanonico> findAll() {
		return operationJpaRepository.findAll() //
				.parallelStream() //
				.map(operation -> operationToOperationCanonicoCoverter.convert(operation)) //
				.collect(Collectors.toList());
	}
}
