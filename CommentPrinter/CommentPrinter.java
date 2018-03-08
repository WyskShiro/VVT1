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
				/*Finaliza um comentario, adiciona-o na lista de comentarios encontrados
				 *E reinicia a busca por outro comentário
				 */
				if (caractere == '/') {
				    comentariosEncontrados.add(resultado.substring(0, resultado.length() - 1));
				    resultado = "";
				    estado = 1;
				    continue;
				} else if (caractere != '*') {
					estado = 3;
				} 
				resultado += caractere;
			}
		}

		//Se existe ao menos um comentário, retorna a lista com o(s) comentário(s)
		//Se não, retorna null
		return comentariosEncontrados.size() == 0 ? null : comentariosEncontrados;
	}

	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String texto = br.readLine();


		
		if (texto != null) {

			//Vai pegando todas as linhas da entrada e colocando na variavel "texto"
			String novaLinha = br.readLine();
			while (novaLinha != null) {
				texto = texto + "\n" + novaLinha;
				novaLinha = br.readLine();
			}
            List<String> comentarios = commentPrinter(texto);

		    //E exibe todos os comentários encontrados, caso haja pelo menos um
            if (comentarios != null) {
                comentarios.forEach(System.out::println);
            }

		    //E le a proxima linha
	  	    
		}
	}
}
