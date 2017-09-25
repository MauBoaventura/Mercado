package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import comercio.Cliente;
import comercio.Iniciar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;

public class CadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JFormattedTextField textField_1;
	private JFormattedTextField textField_2;
	private JTextField textField_3;
	private JLabel lblCadastroDoCliente;
	private JButton btnCadastra;
	private JFormattedTextField vData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Iniciar listas) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente(listas);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public CadastroCliente(Iniciar listas) throws ParseException {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 150, 767, 427);
		setTitle("Cadastro Cliente");

		// setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome ");
		lblNome.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		lblNome.setBounds(50, 69, 226, 36);
		contentPane.add(lblNome);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		lblCpf.setBounds(50, 116, 179, 36);
		contentPane.add(lblCpf);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		lblTelefone.setBounds(50, 163, 187, 36);
		contentPane.add(lblTelefone);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		lblEndereo.setBounds(50, 210, 143, 36);
		contentPane.add(lblEndereo);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(356, 69, 284, 36);
		contentPane.add(textField);

		textField_1 = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(356, 116, 284, 36);
		contentPane.add(textField_1);

		textField_2 = new JFormattedTextField(new MaskFormatter("(##)9 ####-####"));
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(356, 163, 284, 36);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(356, 210, 284, 36);
		contentPane.add(textField_3);

		JLabel lblAniversario = new JLabel("Data de nascimento");
		lblAniversario.setFont(new Font("Lucida Fax", Font.PLAIN, 20));
		lblAniversario.setBounds(50, 257, 226, 36);
		contentPane.add(lblAniversario);

		// Data formato
		vData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		vData.setBounds(356, 257, 284, 36);
		vData.setFont(new Font("Tahoma", Font.PLAIN, 20));
		vData.setColumns(6);
		contentPane.add(vData);

		lblCadastroDoCliente = new JLabel("Cadastro do Cliente");
		lblCadastroDoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDoCliente.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblCadastroDoCliente.setBounds(252, 11, 247, 27);
		contentPane.add(lblCadastroDoCliente);

		btnCadastra = new JButton("Cadastra");
		btnCadastra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cadastra cliente
				Cliente cliente;
				try {

					if (vData.getText().equals("  /  /    ")) {
						cliente = new Cliente(textField.getText(), textField_1.getText(), textField_2.getText(),
								textField_3.getText());
					} else {
						GregorianCalendar gc = new GregorianCalendar(Integer.parseInt(vData.getText().substring(6, 10)),
								Integer.parseInt(vData.getText().substring(3, 5)) - 1,
								Integer.parseInt(vData.getText().substring(0, 2)));
						cliente = new Cliente(textField.getText(), textField_1.getText(), textField_2.getText(),
								textField_3.getText(), gc);
						System.out.println(gc.getTime());
					}

					listas.adicionarCliente(cliente);
					JOptionPane.showMessageDialog(null, "Cliente Cadastrado com sucesso!", "OK!!",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERRO! Digite um valor valido", "ERRO!!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnCadastra.setBounds(287, 326, 109, 27);
		contentPane.add(btnCadastra);
	}

}
