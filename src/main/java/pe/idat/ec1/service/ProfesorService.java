package pe.idat.ec1.service;

import java.util.List;

import pe.idat.ec1.model.Profesor;

public interface ProfesorService {

	Profesor obtener(Integer id);
	List<Profesor> listar();
	void guardar(Profesor profesor);
	void eliminar(Integer id);
}
