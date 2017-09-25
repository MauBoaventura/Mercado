package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import comercio.Compra;
import comercio.Iniciar;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicial extends JFrame {
	Iniciar listas = new Iniciar();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial frame = new Inicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 531, 347);
		setTitle("Loja");
		// setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCadastraCliente = new JButton("Cadastrar Cliente");
		btnCadastraCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroCliente.main(null, listas);
			}
		});
		btnCadastraCliente.setBounds(70, 56, 161, 59);
		contentPane.add(btnCadastraCliente);

		JButton btnCaixa = new JButton("Caixa");
		btnCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Janela de compra
				Comprar.main(null);
			}
		});
		btnCaixa.setBounds(70, 137, 161, 59);
		contentPane.add(btnCaixa);

		JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroProduto.main(null, listas);

			}
		});
		btnCadastrarProduto.setBounds(260, 56, 161, 59);
		contentPane.add(btnCadastrarProduto);

		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.setBounds(260, 137, 161, 59);
		contentPane.add(btnEstoque);
	}
}
