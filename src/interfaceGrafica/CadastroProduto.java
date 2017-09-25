package interfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import comercio.Iniciar;
import deposito.Produto;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCodigo;
	private JTextField txtValor;
	private JTextField txtTipo;
	private JLabel lblCadastro;
	private JLabel lblQuantidade;
	private JTextField txtQuantidade;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Iniciar listas) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProduto frame = new CadastroProduto(listas);
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
	public CadastroProduto(Iniciar listas) {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 647, 410);

		// setExtendedState(MAXIMIZED_BOTH);
		setTitle("Cadastro Produto");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeDoProduto = new JLabel("Nome do Produto");
		lblNomeDoProduto.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		lblNomeDoProduto.setBounds(35, 62, 226, 36);
		contentPane.add(lblNomeDoProduto);

		JLabel lblCodigoDoProduto = new JLabel("Codigo do Produto");
		lblCodigoDoProduto.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		lblCodigoDoProduto.setBounds(35, 109, 270, 36);
		contentPane.add(lblCodigoDoProduto);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		lblValor.setBounds(35, 156, 187, 36);
		contentPane.add(lblValor);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		lblTipo.setBounds(35, 250, 143, 36);
		contentPane.add(lblTipo);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNome.setBounds(394, 63, 196, 36);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCodigo.setBounds(394, 110, 196, 36);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtValor = new JTextField();
		txtValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtValor.setBounds(394, 157, 196, 36);
		contentPane.add(txtValor);
		txtValor.setColumns(10);

		txtTipo = new JTextField();
		txtTipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTipo.setBounds(394, 251, 196, 36);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);

		lblCadastro = new JLabel("Cadastro");
		lblCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblCadastro.setBounds(233, 11, 155, 27);
		contentPane.add(lblCadastro);

		lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		lblQuantidade.setBounds(35, 203, 143, 36);
		contentPane.add(lblQuantidade);

		txtQuantidade = new JTextField();
		txtQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(394, 204, 196, 36);
		contentPane.add(txtQuantidade);

		
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cadastra Produto e exibe mensagem de sucesso
				// Produto criado se ele tiver nome,cod,valor

				Produto prod = null;
				try {
					if (txtTipo.getText().equals("")) {
						prod = new Produto(txtNome.getText(), txtCodigo.getText(), Integer.parseInt(txtValor.getText()),
								Integer.parseInt(txtQuantidade.getText()));

					} else {

						prod = new Produto(txtNome.getText(), txtCodigo.getText(), Integer.parseInt(txtValor.getText()),
								txtTipo.getText(), Integer.parseInt(txtQuantidade.getText()));
					}
					listas.adicionarProduto(prod);
					System.out.println("BLZ");
					JOptionPane.showMessageDialog(null, "Produto Cadastrado com sucesso!", "OK!!",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERRO! Digite um valor valido", "ERRO!!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(251, 319, 100, 42);
		contentPane.add(btnNewButton);
	}
}
