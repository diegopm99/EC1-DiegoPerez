package pe.idat.ec1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.ec1.model.Universidad;
import pe.idat.ec1.repository.UniversidadRepository;

@Service
public class UniversidadServiceImpl implements UniversidadService {

	@Autowired
	private UniversidadRepository repository;
	
	@Override
	public Universidad obtener(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Universidad> listar() {
		return repository.findAll();
	}

	@Override
	public void guardar(Universidad universidad) {
		repository.save(universidad);
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

}
