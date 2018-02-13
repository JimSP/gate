package com.github.jimsp.gate.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.jimsp.gate.handle.GateRmiHandle;
import com.github.jimsp.gate.remote.RbacGatePermissionRemote;
import com.github.jimsp.gate.remote.RbacGateResourceRemote;
import com.github.jimsp.gate.remote.RbacGateRoleRemote;
import com.github.jimsp.gate.remote.RbacGateUserRolesRemote;
import com.github.jimsp.gate.service.RbacGateOperationService;
import com.github.jimsp.gate.service.RbacGatePermissionService;
import com.github.jimsp.gate.service.RbacGateResourceService;
import com.github.jimsp.gate.service.RbacGateRoleService;
import com.github.jimsp.gate.service.RbacGateUserRolesService;

@Configuration
@EnableJpaRepositories("com.github.jimsp.gate.rbac.repositories.*")
@DependsOn("hazelcastConfiguration")
@EnableTransactionManagement
public class RbacGateConfiguration {

	@Autowired
	@Qualifier(GateRmiHandle.RBAC_GATE_USER_ROLES_SERVICE)
	private RbacGateUserRolesService rbacGateUserRolesService;

	@Autowired
	@Qualifier(GateRmiHandle.RBAC_GATE_OPERATION_SERVICE)
	private RbacGateOperationService rbacGateOperationService;
	
	@Autowired
	@Qualifier(GateRmiHandle.RBAC_GATE_PERMISSION_SERVICE)
	private RbacGatePermissionService rbacGatePermissionService;
	
	@Autowired
	@Qualifier(GateRmiHandle.RBAC_GATE_RESOURCE_SERVICE)
	private RbacGateResourceService rbacGateResourceService;
	
	@Autowired
	@Qualifier(GateRmiHandle.RBAC_GATE_ROLE_SERVICE)
	private RbacGateRoleService rbacGateRoleService;

	@Bean(GateRmiHandle.RBAC_GATE_ROLE_SERVICE)
	public RbacGateUserRolesService rbacGateUserRolesRemote() {
		return rbacGateUserRolesService;
	}

	@Bean("rbacGateOperationRemote")
	public RbacGateUserRolesRemote rbacGateOperationRemote() {
		return rbacGateUserRolesService;
	}
	
	@Bean("rbacGatePermissionRemote")
	public RbacGatePermissionRemote rbacGatePermissionRemote() {
		return rbacGatePermissionService;
	}
	
	@Bean("rbacGateResourceRemote")
	public RbacGateResourceRemote rbacGateResourceRemote() {
		return rbacGateResourceService;
	}
	
	@Bean("rbacGateRoleRemote")
	public RbacGateRoleRemote rbacGateRoleRemote() {
		return rbacGateRoleService;
	}

	@Bean
	public RmiServiceExporter rbacGateUserRolesService(final RbacGateUserRolesService rbacGateUserRolesService) {
		return GateRmiHandle.rmiServiceExporter(RbacGateUserRolesRemote.class, rbacGateUserRolesService,
				GateRmiHandle.RBAC_GATE_USER_ROLES_SERVICE, GateRmiHandle.RBAC_RMI_PORT);
	}

	@Bean
	public RmiServiceExporter rbacGatePermissionService(final RbacGatePermissionService rbacGatePermissionService) {
		return GateRmiHandle.rmiServiceExporter(RbacGatePermissionRemote.class, rbacGatePermissionService,
				GateRmiHandle.RBAC_GATE_PERMISSION_SERVICE, GateRmiHandle.RBAC_RMI_PORT);
	}
	
	@Bean
	public RmiServiceExporter rbacGateResourceService(final RbacGateResourceService rbacGateResourceService) {
		return GateRmiHandle.rmiServiceExporter(RbacGateResourceRemote.class, rbacGateResourceService,
				GateRmiHandle.RBAC_GATE_RESOURCE_SERVICE, GateRmiHandle.RBAC_RMI_PORT);
	}
	
	@Bean
	public RmiServiceExporter rbacGateRoleService(final RbacGateRoleService rbacGateRoleService) {
		return GateRmiHandle.rmiServiceExporter(RbacGateRoleRemote.class, rbacGateRoleService,
				GateRmiHandle.RBAC_GATE_ROLE_SERVICE, GateRmiHandle.RBAC_RMI_PORT);
	}
	
	@Bean
	public RmiServiceExporter rbacGateOperationService(final RbacGateOperationService rbacGateOperationService) {
		return GateRmiHandle.rmiServiceExporter(RbacGateUserRolesRemote.class, rbacGateOperationService,
				GateRmiHandle.RBAC_GATE_OPERATION_SERVICE, GateRmiHandle.RBAC_RMI_PORT);
	}
}
