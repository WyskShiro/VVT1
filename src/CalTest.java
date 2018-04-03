import static org.junit.Assert.assertEquals;
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
	
	/*
	 * Casos de teste do método isLeap
	 * Para verificar se o ano é bissexto
	 * */
	@Test
	void testMesCom19Dias(){
		assertEquals(calTest.cal(5, 19), "       1  2 14 15 16\n17 18 19 20 21 22 23\n24 25 26 27 28 29 30");
	}
	
	@Test
	void testMesCom29Dias(){
		assertEquals(calTest.cal(2, 29), "       1  2  3  4  5\n" + 
				" 6  7  8  9 10 11 12\n" + 
				"13 14 15 16 17 18 19\n" + 
				"20 21 22 23 24 25 26\n" + 
				"27 28 29 ");
	}
	
	@Test
	void testMesCom30Dias(){
		assertEquals(calTest.cal(6, 30), "                   1\n" + 
				" 2  3  4  5  6  7  8\n" + 
				" 9 10 11 12 13 14 15\n" + 
				"16 17 18 19 20 21 22\n" + 
				"23 24 25 26 27 28 29\n" + 
				"30 ");
	}
	
	@Test
	void testMesCom31Dias(){
		assertEquals(calTest.cal(1, 31), "    1  2  3  4  5  6\n" + 
				" 7  8  9 10 11 12 13\n" + 
				"14 15 16 17 18 19 20\n" + 
				"21 22 23 24 25 26 27\n" + 
				"28 29 30 31 ");
	}
	
	/* Testes para o metodo jan1 */
	@Test
	void testDiaAnoNormalMenor1752(){
		assertEquals(2, calTest.jan1(1023));
	}
	
	@Test
	void testDiaAnoNormalMaior1800(){
		assertEquals(1, calTest.jan1(2018));
	}
	
}
