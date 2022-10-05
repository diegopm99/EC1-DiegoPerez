package pe.idat.ec1.service;

import java.util.List;

import pe.idat.ec1.model.Universidad;

public interface UniversidadService {
	
	Universidad obtener(Integer id);
	List<Universidad> listar();
	void guardar(Universidad universidad);
	void eliminar(Integer id);
}
