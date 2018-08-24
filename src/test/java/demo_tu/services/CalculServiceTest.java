package demo_tu.services;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo_tu.exception.CalculException;

/**

Test unitaire de la classe dev.service.CalculService.

 */

public class CalculServiceTest {

	private static final Logger LOG = LoggerFactory.getLogger(CalculServiceTest.class);
	@Rule
	public ExpectedException exceptionLevee = ExpectedException.none();

	@Test
	public void testAdditionnerValide()  {
		CalculService cs = new CalculService();
		LOG.info("Etant donné, une instance de la classe CalculService"); // TODO
		int somme = 0;
		try {
			somme = cs.additionner("1+3+4");
		} catch (CalculException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOG.info("Lorsque j'évalue l'addition de l'expression 1+3+4"); // TODO
		assertEquals(8, somme);
		LOG.info("Alors j'obtiens le résultat 8");
	}
	@Test
	public void testAdditionnerInvalide() {
		CalculService cs = new CalculService();
		LOG.info("Etant donné, une instance de la classe CalculService"); // TODO
		int somme = 0;
		try {
			somme = cs.additionner("1+3*4");
			exceptionLevee.expect(CalculException.class);
		} catch (CalculException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LOG.info("Lorsque j'évalue l'addition de l'expression 1+3*4"); // TODO
		
		LOG.info("Alors j'obtiens une calculException");
	}
}
