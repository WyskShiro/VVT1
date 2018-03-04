import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CommentPrinter {
	
	private static List<String> commentPrinter(String entrada) {
		int estado = 1;
		List<String> comentariosEncontrados = new ArrayList<>();
		String resultado = "";

		for(char caractere: entrada.toCharArray()) {
			if (estado == 1) {
				if (caractere == '/') {
					estado = 2;
				}

			} else if (estado == 2) {
				if (caractere == '/') {
					estado = 2;	
				} else if (caractere == '*') {
					estado = 3;
				} else {
					estado = 1;
				}

			} else if (estado == 3) {
				if (caractere == '*') {
					estado = 4;
				}
				resultado += caractere;

			} else if (estado == 4) {
				if (caractere == '/') {
				    comentariosEncontrados.add(resultado);
				    resultado = "";
				    estado = 1;
				}
				if (Character.isLetter(caractere)) {
					estado = 3;
				} 
				resultado += caractere;
			}
		}

		return comentariosEncontrados.size() == 0 ? null : comentariosEncontrados;
	}

	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linha = br.readLine();

		while (linha != null) {
            List<String> comentarios = commentPrinter(linha);

            if (comentarios != null) {
                comentarios.forEach(System.out::println);
            }

			linha = br.readLine();
		}
	}
}