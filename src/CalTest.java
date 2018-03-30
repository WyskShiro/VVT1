import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class CalTest {

	Cal calTest = new Cal();
	
	@Before
	void preparar() {
		calTest = new Cal();
	}
	
	
	/*
	 * Fiz mais pra testar a ideia mesmo
	 * */
	@Test
	void testPrimeiroDia2018() {
		assertSame(1, calTest.firstOfMonth(1, 2018));
	}
	
	/*
	 * Casos de teste - First of month
	 * */
	
	@Test
	void testPrimeiroDiaAnoBissexto2016Mes3() {
		assertSame(2, calTest.firstOfMonth(3, 2016));
	}
	
	@Test
	void testPrimeiroDiaAnoNaoBissexto2018Mes3() {
		assertSame(4, calTest.firstOfMonth(3, 2018));
	}
	
	@Test
	void testPrimeiroDia1752Mes1() {
		assertSame(3, calTest.firstOfMonth(1, 1752));
	}
	
	@Test
	void testPrimeiroDia1752Mes10() {
		assertSame(0, calTest.firstOfMonth(10, 1752));
	}

}
