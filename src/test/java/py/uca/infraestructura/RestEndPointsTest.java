package py.uca.infraestructura;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import py.uca.infraestructura.pojo.Evento;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class RestEndPointsTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void testHttpCodeOk() throws Exception {

		ResultActions resultActions = this.mvc.perform(MockMvcRequestBuilders.get("/eventos"));
		resultActions.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void testHttpCodeCreate() throws Exception {

		Evento e = new Evento("Olimpia vs Santani", new Date());

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(e);

		ResultActions resultActions = this.mvc
                .perform(MockMvcRequestBuilders.post("/eventos")
                        .contentType(MediaType.APPLICATION_JSON_VALUE).content(json));
        resultActions.andExpect(MockMvcResultMatchers.status().isCreated());

	}

	@Test
	public void testHttpCodeBadRequest() throws Exception {

		ResultActions resultActions = this.mvc.perform(MockMvcRequestBuilders.get("/eventos/123"));
		resultActions.andExpect(MockMvcResultMatchers.status().isNotFound());

	}

	@Test
	public void testHttpCodeNotFound() throws Exception {

		ResultActions resultActions = this.mvc
				.perform(MockMvcRequestBuilders.get("/eventos/nombreDelEventoQueDebeDarBadRequest"));
		resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());

	}

	@Test
	public void testHttpCodeConflict() throws Exception {

		ResultActions resultActions = this.mvc.perform(MockMvcRequestBuilders.delete("/eventos/123"));
		resultActions.andExpect(MockMvcResultMatchers.status().isConflict());

	}
}
