package pe.idat.ec1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="malla_curricular")
public class MallaCurricular {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_malla")
	private Integer idMalla;
	
	private String año;
	
	@OneToOne
	private Universidad universidad;
	
	@OneToMany(mappedBy = "mallaCurricular")
	private List<Curso> cursos = new ArrayList<>();

	public Integer getIdMalla() {
		return idMalla;
	}

	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}
	
}
