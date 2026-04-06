import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class TelaJogo {

	private JFrame frame;
	private JButton btnIniciar;
	private JTextField textFieldLetra;
	private JLabel labelLetra;
	private JLabel labelAcertos;
	private JLabel labelErros;
	private JPanel inputs;
	private JLabel labelLetra_1;
	private JLabel labelPalavra;
	private JButton buttonAdvinhar;
	private JLabel labelResultado;
	private JLabel labelHistorico;
	private JLabel labelImagem;

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
		labelAcertos.setOpaque(true);
		labelErros.setOpaque(true);
		labelAcertos.setOpaque(true);
		labelPalavra.setOpaque(true);
		labelHistorico.setOpaque(true);
		buttonAdvinhar.setOpaque(true);
		labelResultado.setOpaque(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 486, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelAcertos.setOpaque(false);
				labelErros.setOpaque(false);
				labelAcertos.setOpaque(false);
				labelPalavra.setOpaque(false);
				labelHistorico.setOpaque(false);
				buttonAdvinhar.setOpaque(false);
				labelResultado.setOpaque(false);
			}
		});
		btnIniciar.setBounds(25, 242, 105, 27);
		frame.getContentPane().add(btnIniciar);
		
		labelAcertos = new JLabel("Acertos:");
		labelAcertos.setForeground(new Color(50, 205, 50));
		labelAcertos.setFont(new Font("Dialog", Font.BOLD, 14));
		labelAcertos.setBounds(25, 57, 63, 17);
		frame.getContentPane().add(labelAcertos);
		
		labelErros = new JLabel("Erros:");
		labelErros.setForeground(new Color(220, 20, 60));
		labelErros.setFont(new Font("Dialog", Font.BOLD, 14));
		labelErros.setBounds(25, 76, 45, 17);
		frame.getContentPane().add(labelErros);
		
		inputs = new JPanel();
		inputs.setBounds(25, 164, 169, 27);
		frame.getContentPane().add(inputs);
		
		labelLetra = new JLabel("Letra:");
		inputs.add(labelLetra);
		labelLetra.setFont(new Font("Dialog", Font.BOLD, 14));
		
		textFieldLetra = new JTextField();
		inputs.add(textFieldLetra);
		textFieldLetra.setColumns(10);
		
		labelLetra_1 = new JLabel("Dica:");
		labelLetra_1.setFont(new Font("Dialog", Font.BOLD, 14));
		labelLetra_1.setBounds(25, 33, 218, 20);
		frame.getContentPane().add(labelLetra_1);
		
		labelPalavra = new JLabel("Palavra");
		labelPalavra.setFont(new Font("Dialog", Font.BOLD, 16));
		labelPalavra.setBounds(25, 105, 189, 17);
		frame.getContentPane().add(labelPalavra);
		
		buttonAdvinhar = new JButton("Advinhar");
		buttonAdvinhar.setBounds(25, 203, 105, 27);
		frame.getContentPane().add(buttonAdvinhar);
		
		labelResultado = new JLabel("Resultado");
		labelResultado.setFont(new Font("Dialog", Font.BOLD, 14));
		labelResultado.setBounds(25, 135, 168, 17);
		frame.getContentPane().add(labelResultado);
		
		labelHistorico = new JLabel("");
		labelHistorico.setBounds(318, 188, 156, 147);
		frame.getContentPane().add(labelHistorico);
		
		labelImagem = new JLabel("imagem");
		labelImagem.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/0.png")));
		labelImagem.setBounds(318, 44, 156, 147);
		frame.getContentPane().add(labelImagem);
	}
}
