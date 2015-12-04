package py.uca.infraestructura.service;

import java.util.Random;

import py.uca.infraestructura.pojo.Evento;

public class EventoService {

	private Evento evento;

	public Long guardarEvento(Evento evento) {

		this.evento = evento;
		Random random = new Random();
		this.evento.setId(random.nextLong());

		return this.evento.getId();
	}

	public Evento getEventoPorId(Long id) {

		if (id.equals(this.evento.getId())) {
			return this.evento;
		} else {
			return null;
		}

	}

	public Boolean borrarEvento(Long id) {
		if (this.evento.equals(id)) {
			this.evento = new Evento(null, null);
			return true;
		} else {
			return false;
		}
	}

}
