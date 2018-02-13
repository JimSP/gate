package com.github.jimsp.gate.handle;

import org.springframework.remoting.rmi.RmiServiceExporter;

public interface GateRmiHandle {
	
	public final String LDAP_RMI_SERVER = "localhost";
	public final Integer LDAP_RMI_PORT = 1099;
	public final String LDPA_GATE_USER_SERVICE = "ldapGateUserService";
	public final String LDAP_GATE_GROUP_SERVICE = "ldapGateRoleService";
	
	public final String RBAC_RMI_SERVER = "localhost";
	public final Integer RBAC_RMI_PORT = 1100;
	public final String RBAC_GATE_USER_ROLES_SERVICE = "rbacGateUserRolesService";
	public final String RBAC_GATE_OPERATION_SERVICE = "rbacGateOperationService";
	public final String RBAC_GATE_PERMISSION_SERVICE = "rbacGatePermissionService";
	public final String RBAC_GATE_RESOURCE_SERVICE = "rbacGateResourceService";
	public final String RBAC_GATE_ROLE_SERVICE = "rbacGateRoleService";
	
	public static <I, S> RmiServiceExporter rmiServiceExporter(final Class<I> serviceInterface, final S serviceImplementation,
			final String serviceName, final Integer servicePort) {
		final RmiServiceExporter rmiExporterService = new RmiServiceExporter();
		rmiExporterService.setServiceInterface(serviceInterface);
		rmiExporterService.setService(serviceImplementation);
		rmiExporterService.setServiceName(serviceName);
		rmiExporterService.setRegistryPort(servicePort);
		return rmiExporterService;
	}
}
