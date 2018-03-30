import java.util.Calendar;

public class Cal {

	static String dayw = "Do Se Te Qa Qi Se Sa";

	static String smon[] = new String[] { "Janeiro", "Fevereiro", "Mar�o", "Abril", "Maio", "Junho", "Julho", "Agosto",
			"Setembro", "Outubro", "Novembro", "Dezembro", };

	static char[] string = new char[432];

	/**
	 * Esse é o método principal do programa. Podem ser recebidos 0, 1 ou 2
	 * parâmetros por meio do argumento argv. Se mais do que 2 parâmetros forem
	 * fornecidos, os excedentes são simplesmente ignorados
	 * 
	 * @param argv
	 *            : se argv.length == 0 então o programa deve mostrar o calendário
	 *            do mês corrente. Se um parâmetro apenas for fornecido, então ele
	 *            representa um ano e então todos os meses daquele ano devem ser
	 *            mostrados. Se dois parâmetros forem fornecidos o primeiro
	 *            representa o mês e o segundo representa o ano. Então apenas aquele
	 *            mês deve ser exibido. Valores válidos para o mês são 1 a 12. Para
	 *            o ano, 1 a 9999. Se valores inválidos forem fornecidos, o programa
	 *            irá exibir uma mensagem de erro dizendo que o mês ou o ano é
	 *            inválido.
	 * 
	 */
	static public void main(String[] argv) {
		int y;
		int m;
		int argc = argv.length;

		Cal myCal = new Cal();
		if (argc >= 2 || argc == 0) {
			/*
			 * print out just month
			 */
			if (argc == 0) { /* current month */
				Calendar cl = Calendar.getInstance();
				m = cl.get(Calendar.MONTH) + 1;
				y = cl.get(Calendar.YEAR);
			} else {
				m = 0;
				try {
					m = Integer.parseInt(argv[0]);
				} catch (Exception e) {
					;
				}
				if (m < 1 || m > 12) {
					System.err.printf("Cal: %s: mes invalido.\n", argv[0]);
					return;
				}
				y = 0;
				try {
					y = Integer.parseInt(argv[1]);
				} catch (Exception e) {
					;
				}
				if (y < 1 || y > 9999) {
					System.err.printf("Cal: %s: ano invalido.\n", argv[1]);
					return;
				}
			}
			System.out.printf("   %s %d\n", smon[m - 1], y);
			System.out.printf("%s\n", dayw);
			String s = myCal.cal(myCal.firstOfMonth(m, y), myCal.numberOfDays(m, y));
			System.out.println(s);
		} else {
			/*
			 * print out complete year
			 */
			y = 0;
			try {
				y = Integer.parseInt(argv[0]);
			} catch (Exception e) {
				;
			}
			if (y < 1 || y > 9999) {
				System.err.printf("Cal: %s: ano invalido.\n", argv[0]);
				return;
			}
			for (int zi = 1; zi < 13; zi++) {
				System.out.printf("   %s %d\n", smon[zi - 1], y);
				System.out.printf("%s\n", dayw);
				String s = myCal.cal(myCal.firstOfMonth(zi, y), myCal.numberOfDays(zi, y));
				System.out.println(s);
				System.out.println();
			}
		}
	}

	static int mon[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, };

	/**
	 * Esse método computa qual é o dia da semana correspondente ao primeiro dia de
	 * um determinado mês.
	 * 
	 * @param m:
	 *            o mês do ano
	 * 
	 * @param a:
	 *            o ano
	 * @return: Um valor entre 0 e 6 que corresponde ao dia da semana que cai o dia
	 *          1/m/a
	 */
	int firstOfMonth(int m, int a)  {
		int k = 0;
		if (isLeap(a) && m > 2)
			k++;
		for (int i = 0; i < m; i++)
			k += mon[i];
		if (a == 1752 && m > 9)
			k -= 11;
		k %= 7;
		k = (k + jan1(a)) % 7;
		return k;
	}

	/**
	 * Computa o número de dias de um determinado mês/ano
	 * 
	 * @param m:
	 *            O mês
	 * @param a:
	 *            O ano
	 * @return: O número de dias do mes m no ano a.
	 */
	int numberOfDays(int m, int a) {
		if (isLeap(a) && m == 2)
			return 29;
		if (a == 1752 && m == 9)
			return 19;
		return mon[m];
	}

	/**
	 * Verifica se um determinado ano é bisexto
	 * 
	 * @param a:
	 *            O ano.
	 * @return: Verdadeiro se o ano for bissexto e falso caso contrário.
	 */
	boolean isLeap(int a) {
		if (a <= 1752) {
			if (a % 4 == 0)
				return true;
			else
				return false;
		} else {
			if (a % 400 == 0)
				return true;
			if (a % 100 == 0)
				return false;
			if (a % 4 == 0)
				return true;
		}
		return false;
	}

	/**
	 * Computa um string que representa o calendário de um determinado mês
	 * 
	 * @param dds:
	 *            Esse parâmetro indica em que dia da semana cai o dia 1 do mês cujo
	 *            calendário se quer calcular. Deve ser uma valor entre 0 e 6.
	 * @param n:
	 *            Indica quantos dias tem o mês. Pode ser um valor entre 28 e 31 ou
	 *            o valor 19, que indica se tratar do mês de setembro de 1752,
	 *            quando considera-se a mudança do calendário Juliano/Gregoriano.
	 * 
	 * @return: o string correspondente ao calendário de um determinado mês
	 */
	String cal(int dds, int n) {
		if (n == 19)
			return "       1  2 14 15 16\n17 18 19 20 21 22 23\n24 25 26 27 28 29 30";
		String s = "";
		for (int k = 0; k < dds; k++)
			s += "   ";
		int cont = dds + 1;
		for (int k = 1; k <= n; k++, cont++) {
			if (k < 10)
				s += " ";
			s += k;
			if (cont % 7 == 0)
				s += "\n";
			else
				s += " ";
		}
		return s;
	}

	/**
	 * Computa o dia da semana do primeiro dia do ano.
	 * 
	 * @param yr:
	 *            o ano que se deseja computar o dia da semana.
	 * @return: um valor entre 0 e 6 que indica o dia da semana do primeirio dia do
	 *          ano.
	 */
	int jan1(int yr) {
		int y, d;

		/*
		 * normal gregorian calendar one extra day per four years
		 */

		y = yr;
		d = 4 + y + (y + 3) / 4;

		/*
		 * julian calendar regular gregorian less three days per 400
		 */

		if (y > 1800) {
			d -= (y - 1701) / 100;
			d += (y - 1601) / 400;
		}

		/*
		 * great calendar changeover instant
		 */

		if (y > 1752)
			d += 3;

		return (d % 7);
	}

}