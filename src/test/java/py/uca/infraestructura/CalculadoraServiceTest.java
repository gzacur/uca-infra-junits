package py.uca.infraestructura;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import py.uca.infraestructura.service.CalculadoraService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class CalculadoraServiceTest {

	private CalculadoraService calculadoraService = new CalculadoraService();

	// Valida que la suma se realice de manera correcta.
	@Test
	public void sumaTest() {

		int result = calculadoraService.sumaInt(2, 2);

		if (result != 4) { // if 2 + 2 != 4
			Assert.fail("La calculadora esta sumando mal.");
		}
	}

	@Test
	public void restaTest() {

		Assert.assertEquals(Integer.valueOf(0), calculadoraService.restaInt(2, 2));
	}

	@Test
	public void dividirTest() {

		Assert.assertEquals(Integer.valueOf(2), calculadoraService.divideInt(6, 3));
	}

	// Se espera que falle.
	@Test(expected = ArithmeticException.class)
	public void testDividirEntreCeroTest() {

		calculadoraService.divideInt(6, 0);
		Assert.fail("Debería haber lanzado una excepción al tratar de dividir entre 0.");

	}

	@Test
	public void multiplicaTest() {

		Assert.assertEquals(Integer.valueOf(4), calculadoraService.multiplicaInt(2, 2));
	}

}
