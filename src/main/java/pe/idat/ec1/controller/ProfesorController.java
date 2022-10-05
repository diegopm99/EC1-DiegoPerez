package pe.idat.ec1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.idat.ec1.model.Profesor;
import pe.idat.ec1.service.ProfesorService;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

	@Autowired
	private ProfesorService service;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		List<Profesor> listaProfesores = service.listar();
		return new ResponseEntity<>(listaProfesores, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarporid(@PathVariable Integer id) {
		Profesor profesor = service.obtener(id);
		if (profesor != null) {
			return new ResponseEntity<>(profesor, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(profesor, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("")
	public ResponseEntity<?> registrar(@RequestBody Profesor profesor) {
		service.guardar(profesor);
		return new ResponseEntity<>(profesor, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Profesor profesor, @PathVariable Integer id) {
		Profesor profesorbd = service.obtener(id);
		if (profesorbd != null) {
			profesor.setIdProfesor(id);
			service.guardar(profesor);
			return new ResponseEntity<>(profesor, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(profesor, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {
		Profesor profesor = service.obtener(id);
		if (profesor != null) {
			service.eliminar(id);
			return new ResponseEntity<>(id, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
		}
	}
}
