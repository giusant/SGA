package br.si.es.sga.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class CadastroFuncionarioUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldRua;
	private JTextField textFieldN;
	private JTextField textFieldBairro;
	private JTextField txtFieldCep;
	private JTextField textFieldCidade;
	private JTextField textFieldEstado;
	private JTextField txtFieldComplemento;
	private JTextField txtFieldNomeDeUsuario;
	private JPasswordField passwordFieldSenha;
	private JPasswordField passwordFieldConfirmaSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionarioUI frame = new CadastroFuncionarioUI();
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
	public CadastroFuncionarioUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNome.setBounds(46, 64, 76, 23);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNome.setBounds(117, 64, 504, 25);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JRadioButton rdbtnGerente = new JRadioButton("Gerente");
		rdbtnGerente.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnGerente.setBounds(314, 125, 109, 23);
		contentPane.add(rdbtnGerente);
		
		JRadioButton rdbtnFuncionrio = new JRadioButton("Funcion\u00E1rio");
		rdbtnFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnFuncionrio.setBounds(314, 176, 145, 23);
		contentPane.add(rdbtnFuncionrio);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo de Usu\u00E1rio:");
		lblTipoDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTipoDeUsuario.setBounds(46, 145, 177, 31);
		contentPane.add(lblTipoDeUsuario);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEndereco.setBounds(46, 235, 99, 23);
		contentPane.add(lblEndereco);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRua.setBounds(46, 292, 63, 25);
		contentPane.add(lblRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(107, 292, 338, 25);
		contentPane.add(textFieldRua);
		
		JLabel lblN = new JLabel("N\u00BA:");
		lblN.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblN.setBounds(465, 292, 63, 25);
		contentPane.add(lblN);
		
		textFieldN = new JTextField();
		textFieldN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldN.setColumns(10);
		textFieldN.setBounds(505, 292, 135, 25);
		contentPane.add(textFieldN);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBairro.setBounds(46, 351, 77, 25);
		contentPane.add(lblBairro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(129, 351, 313, 26);
		contentPane.add(textFieldBairro);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCep.setBounds(465, 350, 52, 25);
		contentPane.add(lblCep);
		
		txtFieldCep = new JTextField();
		txtFieldCep.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldCep.setColumns(10);
		txtFieldCep.setBounds(513, 350, 127, 26);
		contentPane.add(txtFieldCep);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCidade.setBounds(46, 404, 77, 26);
		contentPane.add(lblCidade);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(132, 404, 230, 26);
		contentPane.add(textFieldCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEstado.setBounds(401, 405, 77, 25);
		contentPane.add(lblEstado);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldEstado.setColumns(10);
		textFieldEstado.setBounds(487, 404, 156, 26);
		contentPane.add(textFieldEstado);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComplemento.setBounds(40, 454, 153, 25);
		contentPane.add(lblComplemento);
		
		txtFieldComplemento = new JTextField();
		txtFieldComplemento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldComplemento.setColumns(10);
		txtFieldComplemento.setBounds(203, 454, 443, 26);
		contentPane.add(txtFieldComplemento);
		
		JLabel lblNomeDeUsurio = new JLabel("Nome de Usu\u00E1rio: ");
		lblNomeDeUsurio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNomeDeUsurio.setBounds(46, 517, 185, 26);
		contentPane.add(lblNomeDeUsurio);
		
		txtFieldNomeDeUsuario = new JTextField();
		txtFieldNomeDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldNomeDeUsuario.setColumns(10);
		txtFieldNomeDeUsuario.setBounds(241, 518, 230, 26);
		contentPane.add(txtFieldNomeDeUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSenha.setBounds(46, 554, 86, 26);
		contentPane.add(lblSenha);
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(241, 555, 230, 25);
		contentPane.add(passwordFieldSenha);
		
		JLabel lblConfirmeASenha = new JLabel("Confirme a senha:");
		lblConfirmeASenha.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfirmeASenha.setBounds(46, 592, 185, 26);
		contentPane.add(lblConfirmeASenha);
		
		passwordFieldConfirmaSenha = new JPasswordField();
		passwordFieldConfirmaSenha.setBounds(241, 593, 230, 25);
		contentPane.add(passwordFieldConfirmaSenha);
		
		JButton button = new JButton("Salvar");
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setBounds(563, 587, 111, 31);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		button_1.setBounds(731, 587, 127, 31);
		contentPane.add(button_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(46, 222, 621, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(46, 504, 621, 2);
		contentPane.add(separator_1);
		this.setSize(1200, 700);
		this.setTitle("Cadastro de Funcionário");
		this.setLocationRelativeTo(null);
	}
}
