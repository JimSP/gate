package com.github.jimsp.gate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.github.jimsp.gate.handle.GateRmiHandle;
import com.github.jimsp.gate.remote.LdpaGateRemote;
import com.github.jimsp.gate.remote.RbacGateRemote;

@Configuration
public class RestApiGateConfiguration {

	@Bean(GateRmiHandle.LDPA_GATE_SERVICE)
	public RmiProxyFactoryBean ldpaGateServiceRmiProxyFactoryBean() {
		RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
		rmiProxyFactory.setServiceUrl(String.format("rmi://%s:%s/%s", GateRmiHandle.LDAP_RMI_SERVER,
				GateRmiHandle.LDAP_RMI_PORT, GateRmiHandle.LDPA_GATE_SERVICE));
		rmiProxyFactory.setServiceInterface(LdpaGateRemote.class);
		return rmiProxyFactory;
	}

	@Bean(GateRmiHandle.RBAC_GATE_SERVICE)
	public RmiProxyFactoryBean rbacGateServiceRmiProxyFactoryBean() {
		RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
		rmiProxyFactory.setServiceUrl(String.format("rmi://%s:%s/%s", GateRmiHandle.RBAC_RMI_SERVER,
				GateRmiHandle.RBAC_RMI_PORT, GateRmiHandle.RBAC_GATE_SERVICE));
		rmiProxyFactory.setServiceInterface(RbacGateRemote.class);
		return rmiProxyFactory;
	}
}
