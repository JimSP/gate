package com.github.jimsp.gate.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.service.LdapGateGroupService;
import com.github.jimsp.gate.service.LdapGateUserService;

@Component
public class LdapGateDumpPersonsDataRunner implements CommandLineRunner {

	private final Logger LOGGER = LoggerFactory.getLogger(LdapGateDumpPersonsDataRunner.class);

	@Autowired
	private LdapGateUserService ldpaGateFindUserService;

	@Autowired
	private LdapGateGroupService ldapGateGroupService;

	@Override
	public void run(final String... args) throws Exception {
		LOGGER.info("m=run");
		ldpaGateFindUserService //
				.findAll() //
				.parallelStream() //
				.forEach(userCanonico -> LOGGER.info("m=run, userCanonico={}", userCanonico));

		ldapGateGroupService.findAll().parallelStream()
				.forEach(groupCanonico -> LOGGER.info("m=run, groupCanonico={}", groupCanonico));
	}
}
