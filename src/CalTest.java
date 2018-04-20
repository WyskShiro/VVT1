import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalTest {

    Cal calTest = new Cal();
    private static ByteArrayOutputStream bOut;
    private static PrintStream pStream;
    
    @BeforeEach
    void preparar() {
        calTest = new Cal();
        bOut = new ByteArrayOutputStream();
        pStream = new PrintStream(bOut);
        System.setOut(pStream);
    }
    
    @AfterEach
    void finalizar() {
    	pStream.close();
    }
    
    
    /*
     * Casos de teste para o método main
     * */
    @Test
    void testValido() {
    		String[] nada = {};
    		calTest.main(nada);
    		String resultado = bOut.toString();
    		
    		assertNotEquals(resultado, "");
    }
    
    @Test
    void testAnoValido() {
    		String[] ano = {"2018"};
    		calTest.main(ano);
    		String resultado = bOut.toString();
    		
    		assertNotEquals(resultado, "");
    }
    
    @Test
    void testAnoValidoMesValido() {
    		String[] ano = {"1", "2018"};
    		calTest.main(ano);
    		String resultado = bOut.toString();
    		
    		assertNotEquals(resultado, "");
    }
    
    @Test
    void testAnoMenorMesValido() {
    		String[] ano = {"1", "0"};
    		calTest.main(ano);
    		String resultado = bOut.toString();
    		
    		assertNotEquals(resultado, "");
    }
    
    @Test
    void testAnoMaiorMesValido() {
    		String[] ano = {"1", "10000"};
    		calTest.main(ano);
    		String resultado = bOut.toString();
    		
    		assertNotEquals(resultado, "");
    }
    
    @Test
    void testAnoValidoMesInvalidoMenor() {
    		String[] ano = {"0", "2018"};
    		calTest.main(ano);
    		String resultado = bOut.toString();
    		
    		assertNotEquals(resultado, "");
    }
    
    
    @Test
    void testAnoValidoMesInvalidoMaior() {
    		String[] ano = {"13", "2018"};
    		calTest.main(ano);
    		String resultado = bOut.toString();
    		
    		assertNotEquals(resultado, "");
    }
    
    @Test
    void testAnoMenor() {
    		String[] ano = {"0"};
    		calTest.main(ano);
    		String resultado = bOut.toString();
    		
    		assertNotEquals(resultado, "");
    }
    
    @Test
    void testAnoMaior() {
    		String[] ano = {"10000"};
    		calTest.main(ano);
    		String resultado = bOut.toString();
    		
    		assertNotEquals(resultado, "");
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
    
    @Test
    void testMesEspecificoValidoAnoEspecificoValido() {
        try {
            int valorDaSemana = calTest.firstOfMonth(10, 1752);
            if (valorDaSemana >= 0 && valorDaSemana <= 6) {
                fail("Mes e ano inválido não podem ser computados");
            }
        } catch (Exception e) {
            System.out.println("Exception lançada");
        }       
    }
    
    @Test
    void testMesEspecificoValidoAnoEspecificoInvalido() {
        try {
            int valorDaSemana = calTest.firstOfMonth(9, 1750);
        } catch (Exception e) {
            System.out.println("Exception lançada");
        }       
    }
    
    @Test
    void testMesEspecificoInvalidoAnoEspecificoValido() {
        try {
            int valorDaSemana = calTest.firstOfMonth(7, 1752);

        } catch (Exception e) {
            System.out.println("Exception lançada");
        }       
    }
    
    @Test
    void testMesEspecificoInvalidoAnoEspecificoInvalido() {
        try {
            int valorDaSemana = calTest.firstOfMonth(1, 1751);
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
    void testAnoPossivelNaoMultiplo400_IsLeap() {
        boolean eBissexto = calTest.isLeap(2100);   
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


    
}
