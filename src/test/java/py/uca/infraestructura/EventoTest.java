package py.uca.infraestructura;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import py.uca.infraestructura.pojo.Evento;
import py.uca.infraestructura.service.EventoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class EventoTest {

	private Evento evento;
	private EventoService eventoService;

	@Before
	public void init() {
		eventoService = new EventoService();

		Calendar calendar = Calendar.getInstance();
		calendar.set(2015, Calendar.NOVEMBER, 21);

		evento = new Evento("Curso UCA", calendar.getTime());
	}

	@Test
	public void guardarEvento() throws Exception {

		Long id = eventoService.guardarEvento(this.evento);

		this.evento = eventoService.getEventoPorId(id);

		Assert.assertNotNull(evento);
		Assert.assertEquals(this.evento.getId(), id);

	}

	@Test
	public void obtenerEvento() throws Exception {

		Long id = eventoService.guardarEvento(this.evento);

		Evento evento2 = eventoService.getEventoPorId(-1l);

		Assert.assertNull(evento2);

	}

}