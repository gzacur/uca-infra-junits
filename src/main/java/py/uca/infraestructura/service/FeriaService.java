package py.uca.infraestructura.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import py.uca.infraestructura.pojo.Evento;
import py.uca.infraestructura.pojo.Feria;

public class FeriaService {

	private Feria feria;

	public Long guardarFeria(Feria feria) {

		this.feria = feria;
		feria.setEventos(new ArrayList<>());

		Random random = new Random();
		this.feria.setId(random.nextLong());

		return this.feria.getId();

	}

	public Feria getFeriaPorId(Long id) {

		if (id.equals(this.feria.getId())) {
			return this.feria;
		} else {
			return null;
		}

	}

	public List<Evento> agregarEvento(Evento e) {
		this.feria.getEventos().add(e);
		return this.feria.getEventos();
	}

}
