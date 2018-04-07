import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalTest {

	Cal calTest = new Cal();
	
	@BeforeEach
	void preparar() {
		calTest = new Cal();
	}
	
	/*
	 * Casos de teste para o método firstOfMonth
	 * 
	 * 0 < Mes < 13
	 * 0 < Ano < 10000
	 * 
	 * */

	@Test
	void testMesInferiorAnoInferior_FirstOfMonth() {
		try {
			int valorDaSemana = calTest.firstOfMonth(0, 0);
			if (valorDaSemana >= 0 && valorDaSemana <= 6) {
				fail("Mes e ano inválido não podem ser computados");
			}
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	
	@Test
	void testMesInferiorAnoPossivel_FirstOfMonth() {
		try {
			int valorDaSemana = calTest.firstOfMonth(0, 1);
			if (valorDaSemana >= 0 && valorDaSemana <= 6) {
				fail("Ano inválido não pode ser computado");
			}
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	
	@Test
	void testMesInferiorAnoSuperior_FirstOfMonth() {
		try {
			int valorDaSemana = calTest.firstOfMonth(0, 10000);
			if (valorDaSemana >= 0 && valorDaSemana <= 6) {
				fail("Ano inválido não pode ser computado");
			}
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	
	@Test
	void testMesPossivelAnoInferior_FirstOfMonth() {
		try {
			int valorDaSemana = calTest.firstOfMonth(1, 0);
			if (valorDaSemana >= 0 && valorDaSemana <= 6) {
				fail("Ano inválido não pode ser computado");
			}
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	
	@Test
	void testMesPossivelAnoPossivel_FirstOfMonth() {
		int valorDaSemana = calTest.firstOfMonth(4, 2018);
		assertSame(0, valorDaSemana);
	}
	
	
	@Test
	void testMesPossivelAnoSuperior_FirstOfMonth() {
		try {
			int valorDaSemana = calTest.firstOfMonth(1, 10000);
			if (valorDaSemana >= 0 && valorDaSemana <= 6) {
				fail("Ano inválido não pode ser computado");
			}
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	
	@Test
	void testMesSuperiorAnoInferior_FirstOfMonth() {
		try {
			int valorDaSemana = calTest.firstOfMonth(13, 0);
			if (valorDaSemana >= 0 && valorDaSemana <= 6) {
				fail("Ano inválido não pode ser computado");
			}
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}
	}
	
	
	@Test
	void testMesSuperiorAnoPossivel_FirstOfMonth() {
		try {
			int valorDaSemana = calTest.firstOfMonth(13, 1);
			if (valorDaSemana >= 0 && valorDaSemana <= 6) {
				fail("Ano inválido não pode ser computado");
			}
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	@Test
	void testMesSuperiorAnoSuperior_FirstOfMonth() {
		try {
			int valorDaSemana = calTest.firstOfMonth(13, 10000);
			if (valorDaSemana >= 0 && valorDaSemana <= 6) {
				fail("Ano inválido não pode ser computado");
			}
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	

	
	
	
	/*
	 * Casos de teste para o método numberOfDays()
	 * 
	 * 0 < Mes < 13
	 * 0 < Ano < 10000
	 * */
	
	@Test
	void testMesInferiorAnoInferior_NumberOfDays() {
		try {
			int quantidadeDias = calTest.numberOfDays(0, 0);
			if (quantidadeDias >= 28 && quantidadeDias <= 31) {
				fail("Mes e ano inválido não podem ser computados");
			}
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	
	@Test
	void testMesInferiorAnoPossivel_NumberOfDays() {
		try {
			int quantidadeDias = calTest.numberOfDays(0, 1);
			if (quantidadeDias >= 28 && quantidadeDias <= 31) {
				fail("Mes e ano inválido não podem ser computados");
			}
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	
	@Test
	void testMesInferiorAnoSuperior_NumberOfDays() {
		try {
			int quantidadeDias = calTest.numberOfDays(0, 10000);
			if (quantidadeDias >= 28 && quantidadeDias <= 31) {
				fail("Mes e ano inválido não podem ser computados");
			}
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	
	@Test
	void testMesPossivelAnoInferior_NumberOfDays() {
		try {
			int quantidadeDias = calTest.numberOfDays(1, 0);
			if (quantidadeDias >= 28 && quantidadeDias <= 31) {
				fail("Mes e ano inválido não podem ser computados");
			}
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	
	@Test
	void testMesPossivelAnoPossivel_NumberOfDays() {
		int quantidadeDias = calTest.numberOfDays(4, 2018);
		assertEquals(30, quantidadeDias);
	}
	
	
	@Test
	void testMesPossivelAnoSuperior_NumberOfDays() {
		try {
			int quantidadeDias = calTest.numberOfDays(1, 10000);
			if (quantidadeDias >= 28 && quantidadeDias <= 31) {
				fail("Mes e ano inválido não podem ser computados");
			}
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	
	@Test
	void testMesSuperiorAnoInferior_NumberOfDays() {
		try {
			int quantidadeDias = calTest.numberOfDays(13, 0);
			if (quantidadeDias >= 28 && quantidadeDias <= 31) {
				fail("Mes e ano inválido não podem ser computados");
			}
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}
	}
	
	
	@Test
	void testMesSuperiorAnoPossivel_NumberOfDays() {
		try {
			int quantidadeDias = calTest.numberOfDays(13, 1);
			if (quantidadeDias >= 28 && quantidadeDias <= 31) {
				fail("Mes e ano inválido não podem ser computados");
			}
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	@Test
	void testMesSuperiorAnoSuperior_NumberOfDays() {
		try {
			int quantidadeDias = calTest.numberOfDays(13, 10000);
			if (quantidadeDias >= 28 && quantidadeDias <= 31) {
				fail("Mes e ano inválido não podem ser computados");
			}
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	
	
	
	/*
	 * Casos de teste para o método isLeap()
	 * 
	 * 0 < Ano < 10000
	 * */
	
	
	@Test
	void testAnoInferior_IsLeap() {
		try {
			boolean eBissexto = calTest.isLeap(0);
			
			fail("Para um ano inválido, deve ser lançada e tratada uma exceção");
			
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	
	@Test
	void testAnoPossivel_IsLeap() {
		boolean eBissexto = calTest.isLeap(2016);	
		assertTrue(eBissexto);
	}
	
	
	@Test
	void testAnoSuperior_IsLeap() {
		try {
			boolean eBissexto = calTest.isLeap(10000);
			fail("Para um ano inválido, deve ser lançada e tratada uma exceção");
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	
	/*
	 * Casos de teste para o método cal()
	 * 
	 * -1 < Dia da semana < 7
	 * 27 < Quantidade de dias < 32
	 * 
	 * */
	
	@Test
	void testDdsInferiorQuantidadeInferior_Cal() {
		try {
			String calendarioDoMes = calTest.cal(-1, 27);
			fail("Para um dia da semana e quantidade de dias inválidos, deve ser lançada e tratada uma exceção");
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	@Test
	void testDdsInferiorQuantidadePossivel_Cal() {
		try {
			String calendarioDoMes = calTest.cal(-1, 30);
			fail("Para um dia da semana inválido, deve ser lançada e tratada uma exceção");
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	@Test
	void testDdsInferiorQuantidadeSuperior_Cal() {
		try {
			String calendarioDoMes = calTest.cal(-1, 32);
			fail("Para um dia da semana e quantidade de dias inválidos, deve ser lançada e tratada uma exceção");
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	@Test
	void testDdsPossivelQuantidadeInferior_Cal() {
		try {
			String calendarioDoMes = calTest.cal(0, -1);
			fail("Para uma quantidade de dias inválida, deve ser lançada e tratada uma exceção");
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	@Test
	void testDdsPossivelQuantidadePossivel_Cal() {
		
		String calendarioDoMes = calTest.cal(0, 30);
		System.out.println(calendarioDoMes);
		String calendarioCorreto = " 1  2  3  4  5  6  7\n" + 
				" 8  9 10 11 12 13 14\n" + 
				"15 16 17 18 19 20 21\n" + 
				"22 23 24 25 26 27 28\n" + 
				"29 30 ";
		assertEquals(calendarioDoMes, calendarioCorreto);
	
	}
	
	@Test
	void testDdsPossivelQuantidadeSuperior_Cal() {
		try {
			String calendarioDoMes = calTest.cal(0, 32);
			fail("Para uma quantidade de dias inválida, deve ser lançada e tratada uma exceção");
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	@Test
	void testDdsSuperiorQuantidadeInferior_Cal() {
		try {
			String calendarioDoMes = calTest.cal(13, -1);
			fail("Para um dia da semana e quantidade de dias inválidos, deve ser lançada e tratada uma exceção");
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	@Test
	void testDdsSuperiorQuantidadePossivel_Cal() {
		try {
			String calendarioDoMes = calTest.cal(13, 30);
			fail("Para um dia da semana inválido, deve ser lançada e tratada uma exceção");
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	@Test
	void testDdsSuperiorQuantidadeSuperior_Cal() {
		try {
			String calendarioDoMes = calTest.cal(13, 32);
			fail("Para um dia da semana e quantidade de dias inválidos, deve ser lançada e tratada uma exceção");
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	
	/*
	 * Casos de teste para o método jan1()
	 * 
	 * 0 < Ano < 10000
	 * 
	 * */
	
	@Test
	void testAnoInferior_Jan1() {
		try {
			int primeiroDia = calTest.jan1(0);
			fail("Para um ano inválido, deve ser lançada e tratada uma exceção");
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	@Test
	void testAnoPossivel_Jan1() {
		int primeiroDia = calTest.jan1(2018);
		assertSame(primeiroDia, 1);	
	}
	
	@Test
	void testAnoSuperior_Jan1() {
		try {
			int primeiroDia = calTest.jan1(10000);
			fail("Para um ano inválido, deve ser lançada e tratada uma exceção");
		} catch (Exception e) {
			System.out.println("Exception lançada");
		}		
	}
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Daqui para baixo -> Casos de Teste Anteriores
	 * Que não foram utilizados os critérios de Particionamento 
	 * em Classes de Equivalência e Análise de Valor Limite
	 * */
	

	
	
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
