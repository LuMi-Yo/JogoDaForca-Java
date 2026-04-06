import java.awt.HeadlessException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

class JogoDaForca {
	private ArrayList<String> listadepalavras = new ArrayList<>();
	private String palavraSorteada = new String();
	private String dicaPalavra = new String();
	private char[] palavraOculta;
	private ArrayList<String> historicoResultados = new ArrayList<>(); 
	private int acertos = 0;
	private int codigoPenalidade = 0;
	private String[] nomesPenalidade = {
			"sem penalidades",       //indice 0 ...
		    "perdeu primeira perna", 
		    "perdeu segunda perna",  
		    "perdeu primeiro braço", 
		    "perdeu segundo braço",  
		    "perdeu tronco",         
		    "perdeu cabeça"          
		};
	
	//Métodos -> tirando aquele que foi o gemini que fez, o resto eu fiz logo tudo, mas tu pode apagar e refazer os teus 
	
	public void jogoDaForca() {
		try {
			InputStream stream = this.getClass().getResourceAsStream("/dados/palavras.txt");
			if (stream == null) {
			JOptionPane.showMessageDialog(null, "Arquivo de palavras inexistente!");
				System.exit(0);
			}
			Scanner arquivo = new Scanner(stream);
			String linha;
			while (arquivo.hasNext()) {
				linha = arquivo.nextLine();
				this.listadepalavras.add(linha);
			}
			arquivo.close();
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
	}
	
	public void iniciar() {
		try {
			if(this.listadepalavras.isEmpty()) {
				JOptionPane.showConfirmDialog(null, "Arquivo de palavras inexistente!");
				System.exit(0);
			}
			
			if (!this.palavraSorteada.isEmpty()) {
				this.historicoResultados.add(this.palavraSorteada + " - " + this.getResultado() + System.lineSeparator());
			}
			
			
			Random gerador = new Random();
			int indice = gerador.nextInt(this.listadepalavras.size());
			
			String[] partes = this.listadepalavras.get(indice).split(";");
			this.palavraSorteada = partes[0].toUpperCase();
			this.dicaPalavra = partes[1].toUpperCase();
				
			this.palavraOculta = new char[this.palavraSorteada.length()];
			Arrays.fill(palavraOculta, '*');
			this.acertos = 0;
			this.codigoPenalidade = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		}	
	
	public String getDica() {
		return this.dicaPalavra;
	}
	
	public String getPalavra() {
		return new String(this.palavraOculta);
	}
	
	public ArrayList<String> getResultados(){
		return this.historicoResultados;
	
	}
	
	//essa aqui foi totalmente gemini que fez só pra eu testar se tava rodando o código
	
	public ArrayList<Integer> getOcorrencias(String letra) throws Exception {
		// Lança exceção se a string for vazia, nula ou tiver mais de 1 caractere
		if (letra == null || letra.length() != 1) {
			throw new Exception("A letra deve conter exatamente 1 caractere.");
		}
		
		ArrayList<Integer> posicoes = new ArrayList<>();
		
		// Converte a letra para maiúscula para comparar de igual para igual
		char letraBuscada = letra.toUpperCase().charAt(0);
		boolean encontrouLetra = false;
		
		// Percorre a palavra sorteada procurando a letra
		for (int i = 0; i < this.palavraSorteada.length(); i++) {
			if (this.palavraSorteada.charAt(i) == letraBuscada) {
				encontrouLetra = true;
				posicoes.add(i + 1); // Salva a posição (1 a N)
				
				// Se for a primeira vez que encontra essa letra nesta posição, revela e conta o acerto
				if (this.palavraOculta[i] == '*') {
					this.palavraOculta[i] = letraBuscada;
					this.acertos++;
				}
			}
		}
		
		// Contabiliza a penalidade na ausência da letra
		if (!encontrouLetra && this.codigoPenalidade < 6) {
			this.codigoPenalidade++;
		}
		
		return posicoes;
	}
	
	public boolean terminou(){
		return !this.getResultado().equals("Em Andamento");
	}
	
	public int getAcertos() {
		return this.acertos;
	};
	
	public int getCodigoPenalidade() {
		return this.codigoPenalidade;
	}
	
	public String getNomePenalidade() {
		return this.nomesPenalidade[this.codigoPenalidade];
	}
	
	public String getResultado() {
		if (this.codigoPenalidade == 6){
			return "Perdeu";
		} else if (this.acertos == this.palavraSorteada.length()) {
			return "Venceu";
		} else {
			return "Em Andamento";
		}
	}
	
}
