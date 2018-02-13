package com.github.jimsp.gate.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.github.jimsp.gate.handle.GateRmiHandle;
import com.github.jimsp.gate.remote.LdapGateGroupRemote;
import com.github.jimsp.gate.remote.LdapGateUserRemote;
import com.github.jimsp.gate.service.LdapGateGroupService;
import com.github.jimsp.gate.service.LdapGateUserService;

@Configuration
@EnableLdapRepositories("com.github.jimsp.gate.ldap.repositories.*")
@DependsOn("hazelcastConfiguration")
public class LdapGateConfiguration {

	@Autowired
	@Qualifier(GateRmiHandle.LDPA_GATE_USER_SERVICE)
	private LdapGateUserService ldapGateUserService;
	
	@Autowired
	@Qualifier(GateRmiHandle.LDAP_GATE_GROUP_SERVICE)
	private LdapGateGroupService ldapGateGroupService;

	@Bean("ldapGateUserRemote")
	public LdapGateUserRemote ldapGateUserRemote() {
		return ldapGateUserService;
	}
	
	@Bean("ldapGateGroupRemote")
	public LdapGateGroupRemote ldapGateGroupRemote() {
		return ldapGateGroupService;
	}

	@Bean
	public RmiServiceExporter ldapGateUserServiceRmiServiceExporter(final LdapGateUserService ldapGateUserService) {
		return GateRmiHandle.rmiServiceExporter(LdapGateUserRemote.class, ldapGateUserService,
				GateRmiHandle.LDPA_GATE_USER_SERVICE, GateRmiHandle.LDAP_RMI_PORT);
	}
	
	@Bean
	public RmiServiceExporter ldapGateGroupServiceRmiServiceExporter(final LdapGateGroupService ldapGateGropupService) {
		return GateRmiHandle.rmiServiceExporter(LdapGateUserRemote.class, ldapGateUserService,
				GateRmiHandle.LDAP_GATE_GROUP_SERVICE, GateRmiHandle.LDAP_RMI_PORT);
	}
}
