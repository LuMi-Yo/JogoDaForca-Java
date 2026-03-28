import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

class JogoDaForca {
	private ArrayList<String> listadepalavras;
	
	public JogoDaForca() {
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
	}
}
