package pe.idat.ec1.service;

import java.util.List;
import org.springframework.stereotype.Service;

import pe.idat.ec1.model.Curso;

@Service
public interface CursoService {

	Curso obtener(Integer id);
	List<Curso> listar();
	void guardar(Curso curso);
	void eliminar(Integer id);
	
}
