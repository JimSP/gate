package com.github.jimsp.gate.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.github.jimsp.gate.handle.GateRmiHandle;
import com.github.jimsp.gate.remote.LdpaGateRemote;
import com.github.jimsp.gate.service.LdpaGateService;

@Configuration
@EnableLdapRepositories
@DependsOn("com.github.jimsp.gate.configuration.HazelcastConfiguration")
public class LdapGateConfiguration {

	@Autowired
	@Qualifier(GateRmiHandle.LDPA_GATE_SERVICE)
	private LdpaGateService ldpaGateService;

	@Bean("ldpaGateRemote")
	public LdpaGateRemote ldpaGateRemote() {
		return ldpaGateService;
	}

	@Bean
	public RmiServiceExporter exporter(final LdpaGateService ldpaGateService) {
		Class<LdpaGateRemote> serviceInterface = LdpaGateRemote.class;
		RmiServiceExporter exporter = new RmiServiceExporter();
		exporter.setServiceInterface(serviceInterface);
		exporter.setService(ldpaGateService);
		exporter.setServiceName(GateRmiHandle.LDPA_GATE_SERVICE);
		exporter.setRegistryPort(GateRmiHandle.LDAP_RMI_PORT);
		return exporter;
	}
}
