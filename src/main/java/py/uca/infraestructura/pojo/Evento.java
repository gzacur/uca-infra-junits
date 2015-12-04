package py.uca.infraestructura.pojo;

import java.util.Date;

public class Evento {

	private Long id;
	private String nombre;
	private Date fecha;

	public Evento(String nombre, Date fecha) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
	}

	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
