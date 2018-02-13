package com.github.jimsp.gate.client;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

public final class GateClientFactory {

	protected static <I> I createGateInterface(final String urlGateServer, final Class<I> interfaceType) {
		return JAXRSClientFactory.create(urlGateServer, interfaceType);
	}

	public static GroupMaintananceRestClient createGroupMaintananceRestClient() {
		return GroupMaintananceRestClient.create();
	}

	public static GroupMaintananceRestClient createGroupMaintananceRestClient(final String urlGateServer) {
		return GroupMaintananceRestClient.create(urlGateServer);
	}

	public static OperationMaintenanceRestClient createOperationMaintenanceRestClient() {
		return OperationMaintenanceRestClient.create();
	}

	public static OperationMaintenanceRestClient createOperationMaintenanceRestClient(final String urlGateServer) {
		return OperationMaintenanceRestClient.create(urlGateServer);
	}

	public static PermissionMaintenanceRestClient createPermissionMaintenanceRestClient() {
		return PermissionMaintenanceRestClient.create();
	}

	public static PermissionMaintenanceRestClient createPermissionMaintenanceRestClient(final String urlGateServer) {
		return PermissionMaintenanceRestClient.create(urlGateServer);
	}

	public static ResourceMaintenanceRestClient createResourceMaintenanceRestClient() {
		return ResourceMaintenanceRestClient.create();
	}

	public static ResourceMaintenanceRestClient createResourceMaintenanceRestClient(final String urlGateServer) {
		return ResourceMaintenanceRestClient.create(urlGateServer);
	}

	public static RoleMaintenanceRestClient createRoleMaintenanceRestClient() {
		return RoleMaintenanceRestClient.create();
	}

	public static RoleMaintenanceRestClient createRoleMaintenanceRestClient(final String urlGateServer) {
		return RoleMaintenanceRestClient.create(urlGateServer);
	}

	public static UserMaintananceRestClient createUserMaintananceRestClient() {
		return UserMaintananceRestClient.create();
	}

	public static UserMaintananceRestClient createUserMaintananceRestClient(final String urlGateServer) {
		return UserMaintananceRestClient.create(urlGateServer);
	}

	public static UserRoleAuthenticationRestClient createUserRoleAuthenticationRestClient() {
		return UserRoleAuthenticationRestClient.create();
	}

	public static UserRoleAuthenticationRestClient createUserRoleAuthenticationRestClient(final String urlGateServer) {
		return UserRoleAuthenticationRestClient.create(urlGateServer);
	}
}
