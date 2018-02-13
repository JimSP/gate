package com.github.jimsp.gate.remote;

import java.util.List;

public interface CrudGateInterface<C> {
	
	public void save(final C canonico);

	public void remove(final C canonico);

	public C findByName(final C canonico);

	public List<C> findAll();

}
