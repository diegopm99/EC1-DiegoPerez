package pe.idat.ec1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.ec1.model.Curso;
import pe.idat.ec1.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public Curso obtener(Integer id) {
		return cursoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Curso> listar() {
		return cursoRepository.findAll();
	}

	@Override
	public void guardar(Curso curso) {
		cursoRepository.save(curso);
	}

	@Override
	public void eliminar(Integer id) {
		cursoRepository.deleteById(id);
	}

}
