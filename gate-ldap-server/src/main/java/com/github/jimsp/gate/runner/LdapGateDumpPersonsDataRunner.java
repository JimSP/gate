package com.github.jimsp.gate.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.service.LdpaGateService;

@Component
public class LdapGateDumpPersonsDataRunner implements CommandLineRunner {

	@Autowired
	private LdpaGateService ldpaGateFindUserService;

	@Override
	public void run(final String... args) throws Exception {
		ldpaGateFindUserService.findAll().parallelStream().forEach(action -> System.out.println(action));
	}
}
