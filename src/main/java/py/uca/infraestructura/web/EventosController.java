package py.uca.infraestructura.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.uca.infraestructura.pojo.Evento;

@RestController
public class EventosController {

	@RequestMapping(value = "/eventos", method = RequestMethod.GET)
	public ResponseEntity<String> getAllEventos(HttpServletRequest request, HttpServletResponse response) {

		// Devuelve un HTTP Code 200

		return new ResponseEntity<String>("Texto Dummy", HttpStatus.OK);
	}

	@RequestMapping(value = "/eventos", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> crearEvento(HttpServletRequest request, HttpServletResponse response,
			@RequestBody(required = true) Evento evento) {

		// Devuelve un HTTP Code 201

		return new ResponseEntity<String>("Evento creado", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/eventos/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getEventoById(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value = "id") Long id) {

		// Devuelve un HTTP Code 400

		return new ResponseEntity<String>("Texto Dummy", HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/eventos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEvento(HttpServletRequest request, HttpServletResponse response,
			@PathParam(value = "id") Long id) {

		// Devuelve un HTTP Code 409

		return new ResponseEntity<String>("Texto Dummy", HttpStatus.CONFLICT);
	}

}
