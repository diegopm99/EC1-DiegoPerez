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

import pe.idat.ec1.model.MallaCurricular;
import pe.idat.ec1.service.MallaCurricularService;

@RestController
@RequestMapping("/malla")
public class MallaCurricularController {

	@Autowired
	private MallaCurricularService service;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		List<MallaCurricular> listaMallas = service.listar();
		return new ResponseEntity<>(listaMallas, HttpStatus.OK);

	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarporid(@PathVariable Integer id) {
		MallaCurricular malla = service.obtener(id);
		if (malla != null) {
			return new ResponseEntity<>(malla, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(malla, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("")
	public ResponseEntity<?> registrar(@RequestBody MallaCurricular malla) {
		service.guardar(malla);
		return new ResponseEntity<>(malla, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody MallaCurricular malla, @PathVariable Integer id) {
		MallaCurricular mallabd = service.obtener(id);
		if (mallabd != null) {
			malla.setIdMalla(id);
			service.guardar(malla);
			return new ResponseEntity<>(malla, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(malla, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {
		MallaCurricular malla = service.obtener(id);
		if (malla != null) {
			service.eliminar(id);
			return new ResponseEntity<>(id, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
		}
	}
}
