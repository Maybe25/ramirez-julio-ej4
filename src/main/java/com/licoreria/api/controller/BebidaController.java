package com.licoreria.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.licoreria.api.entity.Bebida;
import com.licoreria.api.service.BebidaService;

@RestController
@RequestMapping("/rest/bebida")
public class BebidaController {

	@Autowired
	private BebidaService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Bebida>> lista() {
		return ResponseEntity.ok(service.listaBebida());
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Bebida> eliminarPorId(@PathVariable("id") int idBebida) {
		Optional<Bebida> optBebida = service.obtienePorId(idBebida);
		if (optBebida.isPresent()) {
			service.eliminaBebida(idBebida);
			return ResponseEntity.ok(optBebida.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/porId/{id}")
	@ResponseBody
	public ResponseEntity<Bebida> listaPorId(@PathVariable("id") int idBebida) {
		Optional<Bebida> optBebida = service.obtienePorId(idBebida);
		if (optBebida.isPresent()) {
			return ResponseEntity.ok(optBebida.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Bebida> registra(@RequestBody Bebida obj) {
		return ResponseEntity.ok(service.insertaActualizaBebida(obj));
	}

	@PutMapping
	@ResponseBody
	public ResponseEntity<Bebida> actualiza(@RequestBody Bebida obj) {
		return ResponseEntity.ok(service.insertaActualizaBebida(obj));
	}

}
