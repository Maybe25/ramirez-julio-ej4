package com.licoreria.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.licoreria.api.entity.Bebida;
import com.licoreria.api.repository.BebidaRepository;

@Service
public class BebidaServiceImpl implements BebidaService{
	
	@Autowired
	private BebidaRepository repository;

	@Override
	public List<Bebida> listaBebida() {
		return repository.findAll();
	}

	@Override
	public Bebida insertaActualizaBebida(Bebida obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Bebida> obtienePorId(int idBebida) {
		return repository.findById(idBebida);
	}

	@Override
	public void eliminaBebida(int id) {
		repository.deleteById(id);
		
	}


}
