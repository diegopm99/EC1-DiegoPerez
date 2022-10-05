package pe.idat.ec1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="universidad")
public class Universidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_universidad")
	private Integer idUniversidad;
	
	private String Universidad;
	
	@OneToOne
	private MallaCurricular mallaCurricular;

	public Integer getIdUniversidad() {
		return idUniversidad;
	}

	public void setIdUniversidad(Integer idUniversidad) {
		this.idUniversidad = idUniversidad;
	}

	public String getUniversidad() {
		return Universidad;
	}

	public void setUniversidad(String universidad) {
		Universidad = universidad;
	}
	
	
}
