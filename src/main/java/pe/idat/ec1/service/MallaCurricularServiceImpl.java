package pe.idat.ec1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.ec1.model.MallaCurricular;
import pe.idat.ec1.repository.MallaCurricularRepository;

@Service
public class MallaCurricularServiceImpl implements MallaCurricularService {

	@Autowired
	private MallaCurricularRepository mallaCurricularRepository;
	
	@Override
	public MallaCurricular obtener(Integer id) {
		return mallaCurricularRepository.findById(id).orElse(null);
	}

	@Override
	public List<MallaCurricular> listar() {
		return mallaCurricularRepository.findAll();
	}

	@Override
	public void guardar(MallaCurricular mallaCurricular) {
		mallaCurricularRepository.save(mallaCurricular);
	}

	@Override
	public void eliminar(Integer id) {
		mallaCurricularRepository.deleteById(id);
	}

}
