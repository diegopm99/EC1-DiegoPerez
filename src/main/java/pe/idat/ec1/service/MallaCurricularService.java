package pe.idat.ec1.service;

import java.util.List;

import pe.idat.ec1.model.MallaCurricular;

public interface MallaCurricularService {

	MallaCurricular obtener(Integer id);
	List<MallaCurricular> listar();
	void guardar(MallaCurricular mallaCurricular);
	void eliminar(Integer id);
}
