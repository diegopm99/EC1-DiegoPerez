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

import pe.idat.ec1.model.Curso;
import pe.idat.ec1.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoService service;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		List<Curso> listaCursos = service.listar();
		return new ResponseEntity<>(listaCursos, HttpStatus.OK);

	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarporid(@PathVariable Integer id) {
		Curso curso = service.obtener(id);
		if (curso != null) {
			return new ResponseEntity<>(curso, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(curso, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("")
	public ResponseEntity<?> registrar(@RequestBody Curso curso) {
		service.guardar(curso);
		return new ResponseEntity<>(curso, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Curso curso, @PathVariable Integer id) {
		Curso cursobd = service.obtener(id);
		if (cursobd != null) {
			curso.setIdCurso(id);
			service.guardar(curso);
			return new ResponseEntity<>(curso, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(curso, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {
		Curso curso = service.obtener(id);
		if (curso != null) {
			service.eliminar(id);
			return new ResponseEntity<>(id, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
		}
	}
}
