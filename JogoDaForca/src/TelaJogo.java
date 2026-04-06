import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class TelaJogo {

	private JFrame frame;
	private JButton btnRepetir;
	private JTextField textFieldLetra;
	private JLabel labelLetra;
	private JLabel labelAcertos;
	private JLabel labelPenalidade;
	private JPanel panelInputs;
	private JLabel labelDica;
	private JLabel labelPalavra;
	private JButton buttonAdvinhar;
	private JLabel labelResultado;
	private JLabel labelImagem;
	JogoDaForca JogoDaForca = new JogoDaForca();
	private JTextArea textAreaHistorico;
	private JPanel painelJogo;
	private JPanel painelInicial;
	private JLabel labelTitulo;
	private JLabel labelSubtitulo;
	private JButton buttonIniciar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJogo window = new TelaJogo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaJogo() {
		initialize();
		painelJogo.setVisible(false);
		/*
		labelAcertos.setVisible(false);
		labelDica.setVisible(false);
		labelPenalidade.setVisible(false);
		labelAcertos.setVisible(false);
		labelPalavra.setVisible(false);
		buttonAdvinhar.setVisible(false);
		labelResultado.setVisible(false);
		panelInputs.setVisible(false);
		labelImagem.setVisible(false);*/
	}
	
	private void atualizarTela() {
		labelDica.setText("Dica: " + JogoDaForca.getDica());
		labelAcertos.setText("Acertos: " + JogoDaForca.getAcertos());
		labelPenalidade.setText("Penalidade: " + JogoDaForca.getCodigoPenalidade() + " " + JogoDaForca.getNomePenalidade());
		labelResultado.setText("Resultado: " + JogoDaForca.getResultado());
		labelPalavra.setText("Palavra: " + JogoDaForca.getPalavra());
		
		ArrayList<String> historico = JogoDaForca.getResultados();
		String letras = "";
		for (String i : historico) {
			letras = letras += i + " ";
		}
		textAreaHistorico.setText(letras);
		
		ImageIcon imagem = new ImageIcon(getClass().getResource("/imagens/%d.png".formatted(JogoDaForca.getCodigoPenalidade())));
		labelImagem.setIcon(imagem);
		btnRepetir.setVisible(false);
		
		if (JogoDaForca.getResultado() != "Em Andamento") {
			buttonAdvinhar.setVisible(false);
			btnRepetir.setVisible(true);
			btnRepetir.setText("Repetir");
			
		};
		
	};
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 486, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		painelInicial = new JPanel();
		painelInicial.setBounds(0, 24, 486, 281);
		frame.getContentPane().add(painelInicial);
		painelInicial.setLayout(null);
		
		labelTitulo = new JLabel("Jogo da Forca");
		labelTitulo.setBounds(176, 72, 133, 28);
		painelInicial.add(labelTitulo);
		labelTitulo.setFont(new Font("Dialog", Font.BOLD, 20));
		
		labelSubtitulo = new JLabel("By Luís Miguel & Thatyane");
		labelSubtitulo.setFont(new Font("Dialog", Font.BOLD, 15));
		labelSubtitulo.setBounds(150, 99, 201, 28);
		painelInicial.add(labelSubtitulo);
		
		buttonIniciar = new JButton("Iniciar");
		buttonIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelInicial.setVisible(false);
				painelJogo.setVisible(true);
				JogoDaForca.jogoDaForca();
				JogoDaForca.iniciar();
				atualizarTela();
			}
		});
		buttonIniciar.setBounds(195, 151, 105, 27);
		painelInicial.add(buttonIniciar);
		
		painelJogo = new JPanel();
		painelJogo.setBounds(0, 0, 486, 367);
		frame.getContentPane().add(painelJogo);
		painelJogo.setLayout(null);
		
		
		btnRepetir = new JButton("Repetir");
		btnRepetir.setBounds(12, 254, 105, 27);
		painelJogo.add(btnRepetir);
		
		labelAcertos = new JLabel("Acertos:");
		labelAcertos.setBounds(12, 70, 292, 17);
		painelJogo.add(labelAcertos);
		labelAcertos.setForeground(new Color(50, 205, 50));
		labelAcertos.setFont(new Font("Dialog", Font.BOLD, 14));
		
		labelPenalidade = new JLabel("Erros:");
		labelPenalidade.setBounds(12, 89, 292, 17);
		painelJogo.add(labelPenalidade);
		labelPenalidade.setForeground(new Color(220, 20, 60));
		labelPenalidade.setFont(new Font("Dialog", Font.BOLD, 14));
		
		panelInputs = new JPanel();
		panelInputs.setBounds(12, 176, 169, 27);
		painelJogo.add(panelInputs);
		
		labelLetra = new JLabel("Letra:");
		panelInputs.add(labelLetra);
		labelLetra.setFont(new Font("Dialog", Font.BOLD, 14));
		
		textFieldLetra = new JTextField();
		panelInputs.add(textFieldLetra);
		textFieldLetra.setColumns(10);
		textFieldLetra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JogoDaForca.getResultado() != "Em Andamento") {
					btnRepetir.doClick();
				}
				buttonAdvinhar.doClick();
				textFieldLetra.setText("");
			}
		});
		
		labelDica = new JLabel("Dica:");
		labelDica.setBounds(12, 50, 292, 20);
		painelJogo.add(labelDica);
		labelDica.setFont(new Font("Dialog", Font.BOLD, 14));
		
		labelPalavra = new JLabel("Palavra");
		labelPalavra.setBounds(12, 118, 292, 17);
		painelJogo.add(labelPalavra);
		labelPalavra.setFont(new Font("Dialog", Font.BOLD, 16));
		
		buttonAdvinhar = new JButton("Advinhar");
		buttonAdvinhar.setBounds(12, 215, 105, 27);
		painelJogo.add(buttonAdvinhar);
		
		labelResultado = new JLabel("Resultado");
		labelResultado.setBounds(12, 147, 292, 17);
		painelJogo.add(labelResultado);
		labelResultado.setFont(new Font("Dialog", Font.BOLD, 14));
		
		labelImagem = new JLabel("imagem");
		labelImagem.setBounds(318, 39, 156, 147);
		painelJogo.add(labelImagem);
		labelImagem.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/0.png")));
		
		textAreaHistorico = new JTextArea();
		textAreaHistorico.setBounds(261, 198, 213, 83);
		painelJogo.add(textAreaHistorico);
		textAreaHistorico.setEditable(false);
		textAreaHistorico.setFocusable(false);
		buttonAdvinhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String letra = textFieldLetra.getText();
				try {
					JogoDaForca.getOcorrencias(letra);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				atualizarTela();
			}
		});
		btnRepetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelDica.setVisible(true);
				labelAcertos.setVisible(true);
				labelPenalidade.setVisible(true);
				labelAcertos.setVisible(true);
				labelPalavra.setVisible(true);
				textAreaHistorico.setVisible(true);
				buttonAdvinhar.setVisible(true);
				labelResultado.setVisible(true);
				panelInputs.setVisible(true);
				labelImagem.setVisible(true);
				JogoDaForca.jogoDaForca();
				JogoDaForca.iniciar();
				atualizarTela();
			}
		});
	}
}
