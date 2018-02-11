package com.github.jimsp.gate.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.github.jimsp.gate.handle.GateRmiHandle;
import com.github.jimsp.gate.remote.LdpaGateRemote;
import com.github.jimsp.gate.remote.RbacGateRemote;
import com.github.jimsp.gate.service.RbacGateService;

@Configuration
@EnableJpaRepositories
@DependsOn("com.github.jimsp.gate.configuration.HazelcastConfiguration")
public class RbacGateConfiguration {
	
	@Autowired
	@Qualifier(GateRmiHandle.RBAC_GATE_SERVICE)
	private RbacGateService rbacGateService;

	@Bean("rbacGateRemote")
	public RbacGateRemote ldpaGateRemote() {
		return rbacGateService;
	}

	@Bean
	public RmiServiceExporter exporter(final RbacGateService ldpaGateService) {
		Class<LdpaGateRemote> serviceInterface = LdpaGateRemote.class;
		RmiServiceExporter exporter = new RmiServiceExporter();
		exporter.setServiceInterface(serviceInterface);
		exporter.setService(ldpaGateService);
		exporter.setServiceName(GateRmiHandle.RBAC_GATE_SERVICE);
		exporter.setRegistryPort(GateRmiHandle.RBAC_RMI_PORT);
		return exporter;
	}
}
