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
	
	
	
	/*
	 * Casos de teste do método firstDayOfMonth
	 * Para verificar qual dia da semana é o primeiro dia do mês
	 * */
	@Test
	void testAnoBissextoEFevereiro() {
		assertSame(29, calTest.numberOfDays(2, 2000));
	}
	
	@Test
	void testAno1752Setembro() {
		assertSame(19, calTest.numberOfDays(9, 1752));
	}
	
	@Test
	void testAnoNaoBissextoEMesDiferenteDeFevereiroSetembro() {
		assertSame(31, calTest.numberOfDays(1, 2001));
	}

	
	
	/*
	 * Casos de teste do método isLeap
	 * Para verificar se o ano é bissexto
	 * */
	@Test
	void testAnoBissextoAntes1752true(){
		assertEquals(true, calTest.isLeap(1304));
	}
	
	@Test
	void testAnoBissextoAntes1752false(){
		assertEquals(false, calTest.isLeap(1305));
	}
	
	@Test
	void testAnoBissextoDepois1752resto0por400(){
		assertEquals(true, calTest.isLeap(2400));
	}
	
	@Test
	void testAnoBissextoDepois1752resto0por100(){
		assertEquals(false, calTest.isLeap(2100));
	}
	
	@Test
	void testAnoBissextoDepois1752resto0por4(){
		assertEquals(true, calTest.isLeap(2004));
	}
	
	@Test
	void testAnoBissextoDepois1752(){
		assertEquals(true, calTest.isLeap(2016));
	}

}
