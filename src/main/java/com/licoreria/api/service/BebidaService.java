package com.licoreria.api.service;

import java.util.List;
import java.util.Optional;

import com.licoreria.api.entity.Bebida;

public interface BebidaService {
	
	
	public abstract List<Bebida> listaBebida();
	public abstract Bebida insertaActualizaBebida(Bebida obj);
	public abstract Optional<Bebida> obtienePorId(int idBebida);
	public abstract void eliminaBebida(int id);
	

}
