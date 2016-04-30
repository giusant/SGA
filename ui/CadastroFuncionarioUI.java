package br.si.es.sga.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroFuncionarioUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeFuncionarioCadastro;
	private JTextField textFieldRuaFuncionarioCadastro;
	private JTextField textFieldNFuncionarioCadastro;
	private JTextField textFieldBairroFuncionarioCadastro;
	private JTextField txtFieldCepFuncionarioCadastro;
	private JTextField textFieldCidadeFuncionarioCadastro;
	private JTextField textFieldEstadoFuncionarioCadastro;
	private JTextField txtFieldComplementoFuncionarioCadastro;
	private JTextField txtFieldNomeDeUsuarioFuncionarioCadastro;
	private JPasswordField passwordFieldSenhaFuncionarioCadastro;
	private JPasswordField passwordFieldConfirmaSenhaFuncionarioCadastro;
	private JTextField txtFieldRuaFuncionarioEditar;
	private JTextField txtFieldBairroFuncionarioEditar;
	private JTextField txtFieldCidadeFuncionarioEditar;
	private JTextField txtFieldEstadoFuncionarioEditar;
	private JTextField txtFieldCepFuncionarioEditar;
	private JTextField textFieldNFuncionarioEditar;
	private JTextField txtFieldComplementoFuncionarioEditar;
	private JTextField txtFieldNomedeUsuarioFuncionarioEditar;
	private JPasswordField passwordFieldSenhaFuncEditar;
	private JPasswordField passwordFieldConfSenhaFuncEditar;
	private JTextField textFieldNomeFuncionarioEditar;
	private JTextField txtFieldFuncExcluir;
	private JTextField txtFieldRuaFuncExcluir;
	private JTextField txtFieldBairroFuncExcluir;
	private JTextField txtFieldCidadeFuncExcluir;
	private JTextField txtFieldComplFuncExcluir;
	private JTextField txtFieldEstadoFuncExcluir;
	private JTextField txtFieldNFuncExcluir;
	private JTextField txtFieldCepFuncExcluir;
	private JTextField txtFieldNDeUsuarioFuncExcluir;
	private JPasswordField passwordFieldSenhaFuncExcluir;
	private JPasswordField passwordFieldConfASenhaFuncExcluir;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setSize(900, 700);
		this.setTitle("Cadastro de Funcionário");
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel Cadastrar = new JPanel();
		tabbedPane.addTab("Cadastrar", null, Cadastrar, null);
		Cadastrar.setLayout(null);
		
		JLabel lblNomeFuncionarioCadastro = new JLabel("Nome:");
		lblNomeFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNomeFuncionarioCadastro.setBounds(47, 36, 76, 23);
		Cadastrar.add(lblNomeFuncionarioCadastro);
		
		textFieldNomeFuncionarioCadastro = new JTextField();
		textFieldNomeFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNomeFuncionarioCadastro.setBounds(118, 36, 504, 25);
		Cadastrar.add(textFieldNomeFuncionarioCadastro);
		textFieldNomeFuncionarioCadastro.setColumns(10);
		
		JRadioButton rdbtnGerenteFuncionarioCadastro = new JRadioButton("Gerente");
		rdbtnGerenteFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnGerenteFuncionarioCadastro.setBounds(315, 97, 109, 23);
		Cadastrar.add(rdbtnGerenteFuncionarioCadastro);
		
		JRadioButton rdbtnFuncionrioFuncionarioCadastro = new JRadioButton("Funcion\u00E1rio");
		rdbtnFuncionrioFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnFuncionrioFuncionarioCadastro.setBounds(315, 148, 145, 23);
		Cadastrar.add(rdbtnFuncionrioFuncionarioCadastro);
		
		JLabel lblTipoDeUsuarioFuncionarioCadastro = new JLabel("Tipo de Usu\u00E1rio:");
		lblTipoDeUsuarioFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTipoDeUsuarioFuncionarioCadastro.setBounds(47, 117, 177, 31);
		Cadastrar.add(lblTipoDeUsuarioFuncionarioCadastro);
		
		JLabel lblEnderecoFuncionarioCadastro = new JLabel("Endere\u00E7o");
		lblEnderecoFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnderecoFuncionarioCadastro.setBounds(47, 207, 99, 23);
		Cadastrar.add(lblEnderecoFuncionarioCadastro);
		
		JLabel lblRuaFuncionarioCadastro = new JLabel("Rua:");
		lblRuaFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRuaFuncionarioCadastro.setBounds(47, 264, 63, 25);
		Cadastrar.add(lblRuaFuncionarioCadastro);
		
		textFieldRuaFuncionarioCadastro = new JTextField();
		textFieldRuaFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldRuaFuncionarioCadastro.setColumns(10);
		textFieldRuaFuncionarioCadastro.setBounds(108, 264, 338, 25);
		Cadastrar.add(textFieldRuaFuncionarioCadastro);
		
		JLabel lblNFuncionarioCadastro = new JLabel("N\u00BA:");
		lblNFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNFuncionarioCadastro.setBounds(466, 264, 63, 25);
		Cadastrar.add(lblNFuncionarioCadastro);
		
		textFieldNFuncionarioCadastro = new JTextField();
		textFieldNFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNFuncionarioCadastro.setColumns(10);
		textFieldNFuncionarioCadastro.setBounds(506, 264, 135, 25);
		Cadastrar.add(textFieldNFuncionarioCadastro);
		
		JLabel lblBairroFuncionarioCadastro = new JLabel("Bairro:");
		lblBairroFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBairroFuncionarioCadastro.setBounds(47, 323, 77, 25);
		Cadastrar.add(lblBairroFuncionarioCadastro);
		
		textFieldBairroFuncionarioCadastro = new JTextField();
		textFieldBairroFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldBairroFuncionarioCadastro.setColumns(10);
		textFieldBairroFuncionarioCadastro.setBounds(130, 323, 313, 26);
		Cadastrar.add(textFieldBairroFuncionarioCadastro);
		
		JLabel lblCepFuncionarioCadastro = new JLabel("CEP:");
		lblCepFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCepFuncionarioCadastro.setBounds(466, 322, 52, 25);
		Cadastrar.add(lblCepFuncionarioCadastro);
		
		txtFieldCepFuncionarioCadastro = new JTextField();
		txtFieldCepFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldCepFuncionarioCadastro.setColumns(10);
		txtFieldCepFuncionarioCadastro.setBounds(514, 322, 127, 26);
		Cadastrar.add(txtFieldCepFuncionarioCadastro);
		
		JLabel lblCidadeFuncionariCadastro = new JLabel("Cidade:");
		lblCidadeFuncionariCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCidadeFuncionariCadastro.setBounds(47, 376, 77, 26);
		Cadastrar.add(lblCidadeFuncionariCadastro);
		
		textFieldCidadeFuncionarioCadastro = new JTextField();
		textFieldCidadeFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCidadeFuncionarioCadastro.setColumns(10);
		textFieldCidadeFuncionarioCadastro.setBounds(133, 376, 230, 26);
		Cadastrar.add(textFieldCidadeFuncionarioCadastro);
		
		JLabel lblEstadoFuncionarioCadastro = new JLabel("Estado:");
		lblEstadoFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEstadoFuncionarioCadastro.setBounds(402, 377, 77, 25);
		Cadastrar.add(lblEstadoFuncionarioCadastro);
		
		textFieldEstadoFuncionarioCadastro = new JTextField();
		textFieldEstadoFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldEstadoFuncionarioCadastro.setColumns(10);
		textFieldEstadoFuncionarioCadastro.setBounds(488, 376, 156, 26);
		Cadastrar.add(textFieldEstadoFuncionarioCadastro);
		
		JLabel lblComplementoFuncionarioCadastro = new JLabel("Complemento:");
		lblComplementoFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComplementoFuncionarioCadastro.setBounds(41, 426, 153, 25);
		Cadastrar.add(lblComplementoFuncionarioCadastro);
		
		txtFieldComplementoFuncionarioCadastro = new JTextField();
		txtFieldComplementoFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldComplementoFuncionarioCadastro.setColumns(10);
		txtFieldComplementoFuncionarioCadastro.setBounds(204, 426, 443, 26);
		Cadastrar.add(txtFieldComplementoFuncionarioCadastro);
		
		JLabel lblNomeDeUsurioFuncionarioCadastro = new JLabel("Nome de Usu\u00E1rio: ");
		lblNomeDeUsurioFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNomeDeUsurioFuncionarioCadastro.setBounds(47, 489, 185, 26);
		Cadastrar.add(lblNomeDeUsurioFuncionarioCadastro);
		
		txtFieldNomeDeUsuarioFuncionarioCadastro = new JTextField();
		txtFieldNomeDeUsuarioFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldNomeDeUsuarioFuncionarioCadastro.setColumns(10);
		txtFieldNomeDeUsuarioFuncionarioCadastro.setBounds(242, 490, 230, 26);
		Cadastrar.add(txtFieldNomeDeUsuarioFuncionarioCadastro);
		
		JLabel lblSenhaFuncionarioCadastro = new JLabel("Senha:");
		lblSenhaFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSenhaFuncionarioCadastro.setBounds(47, 526, 86, 26);
		Cadastrar.add(lblSenhaFuncionarioCadastro);
		
		passwordFieldSenhaFuncionarioCadastro = new JPasswordField();
		passwordFieldSenhaFuncionarioCadastro.setBounds(242, 527, 230, 25);
		Cadastrar.add(passwordFieldSenhaFuncionarioCadastro);
		
		JLabel lblConfirmeASenhaFuncionarioCadastro = new JLabel("Confirme a senha:");
		lblConfirmeASenhaFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfirmeASenhaFuncionarioCadastro.setBounds(47, 564, 185, 26);
		Cadastrar.add(lblConfirmeASenhaFuncionarioCadastro);
		
		passwordFieldConfirmaSenhaFuncionarioCadastro = new JPasswordField();
		passwordFieldConfirmaSenhaFuncionarioCadastro.setBounds(242, 565, 230, 25);
		Cadastrar.add(passwordFieldConfirmaSenhaFuncionarioCadastro);
		
		JButton btnSalvarFuncCadastrar = new JButton("Salvar");
		btnSalvarFuncCadastrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalvarFuncCadastrar.setBounds(536, 559, 111, 31);
		Cadastrar.add(btnSalvarFuncCadastrar);
		
		JButton btnCancelarFuncCadastrar = new JButton("Cancelar");
		btnCancelarFuncCadastrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelarFuncCadastrar.setBounds(685, 559, 127, 31);
		Cadastrar.add(btnCancelarFuncCadastrar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(47, 194, 621, 2);
		Cadastrar.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(47, 476, 621, 2);
		Cadastrar.add(separator_1);
		
		JPanel Editar = new JPanel();
		tabbedPane.addTab("Editar", null, Editar, null);
		Editar.setLayout(null);
		
		JLabel lblNomesFuncionarioEditar = new JLabel("Funcion\u00E1rios:");
		lblNomesFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNomesFuncionarioEditar.setBounds(16, 46, 135, 23);
		Editar.add(lblNomesFuncionarioEditar);
		
		JLabel lblTipoDeUsuarioFuncionarioEditar = new JLabel("Tipo de Usu\u00E1rio:");
		lblTipoDeUsuarioFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTipoDeUsuarioFuncionarioEditar.setBounds(16, 154, 177, 31);
		Editar.add(lblTipoDeUsuarioFuncionarioEditar);
		
		JRadioButton radioButtonGerenteFuncionarioEditar = new JRadioButton("Gerente");
		radioButtonGerenteFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		radioButtonGerenteFuncionarioEditar.setBounds(252, 158, 109, 23);
		Editar.add(radioButtonGerenteFuncionarioEditar);
		
		JRadioButton rbtnFuncionarioFuncionarioEditar = new JRadioButton("Funcion\u00E1rio");
		rbtnFuncionarioFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		rbtnFuncionarioFuncionarioEditar.setBounds(414, 158, 145, 23);
		Editar.add(rbtnFuncionarioFuncionarioEditar);
		
		JLabel lblEnderecoFuncionarioEditar = new JLabel("Endere\u00E7o");
		lblEnderecoFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnderecoFuncionarioEditar.setBounds(16, 217, 99, 23);
		Editar.add(lblEnderecoFuncionarioEditar);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(16, 204, 621, 2);
		Editar.add(separator_2);
		
		JLabel txtFieldNFuncionarioEditar = new JLabel("N\u00BA:");
		txtFieldNFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtFieldNFuncionarioEditar.setBounds(435, 274, 41, 25);
		Editar.add(txtFieldNFuncionarioEditar);
		
		txtFieldRuaFuncionarioEditar = new JTextField();
		txtFieldRuaFuncionarioEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldRuaFuncionarioEditar.setColumns(10);
		txtFieldRuaFuncionarioEditar.setBounds(77, 274, 338, 25);
		Editar.add(txtFieldRuaFuncionarioEditar);
		
		JLabel lblRuaFuncionarioEditar = new JLabel("Rua:");
		lblRuaFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRuaFuncionarioEditar.setBounds(16, 274, 63, 25);
		Editar.add(lblRuaFuncionarioEditar);
		
		JLabel lblBairroFuncionarioEditar = new JLabel("Bairro:");
		lblBairroFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBairroFuncionarioEditar.setBounds(16, 333, 77, 25);
		Editar.add(lblBairroFuncionarioEditar);
		
		txtFieldBairroFuncionarioEditar = new JTextField();
		txtFieldBairroFuncionarioEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldBairroFuncionarioEditar.setColumns(10);
		txtFieldBairroFuncionarioEditar.setBounds(99, 333, 313, 26);
		Editar.add(txtFieldBairroFuncionarioEditar);
		
		JLabel lblCidadeFuncionarioEditar = new JLabel("Cidade:");
		lblCidadeFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCidadeFuncionarioEditar.setBounds(16, 386, 77, 26);
		Editar.add(lblCidadeFuncionarioEditar);
		
		txtFieldCidadeFuncionarioEditar = new JTextField();
		txtFieldCidadeFuncionarioEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldCidadeFuncionarioEditar.setColumns(10);
		txtFieldCidadeFuncionarioEditar.setBounds(102, 386, 230, 26);
		Editar.add(txtFieldCidadeFuncionarioEditar);
		
		JLabel lblEstadoFuncionarioEditar = new JLabel("Estado:");
		lblEstadoFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEstadoFuncionarioEditar.setBounds(371, 387, 77, 25);
		Editar.add(lblEstadoFuncionarioEditar);
		
		txtFieldEstadoFuncionarioEditar = new JTextField();
		txtFieldEstadoFuncionarioEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldEstadoFuncionarioEditar.setColumns(10);
		txtFieldEstadoFuncionarioEditar.setBounds(457, 386, 156, 26);
		Editar.add(txtFieldEstadoFuncionarioEditar);
		
		JLabel lblCepFuncionarioEditar = new JLabel("CEP:");
		lblCepFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCepFuncionarioEditar.setBounds(435, 332, 52, 25);
		Editar.add(lblCepFuncionarioEditar);
		
		txtFieldCepFuncionarioEditar = new JTextField();
		txtFieldCepFuncionarioEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldCepFuncionarioEditar.setColumns(10);
		txtFieldCepFuncionarioEditar.setBounds(483, 332, 127, 26);
		Editar.add(txtFieldCepFuncionarioEditar);
		
		textFieldNFuncionarioEditar = new JTextField();
		textFieldNFuncionarioEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNFuncionarioEditar.setColumns(10);
		textFieldNFuncionarioEditar.setBounds(475, 274, 135, 25);
		Editar.add(textFieldNFuncionarioEditar);
		
		JLabel lblComplementoFuncionarioEditar = new JLabel("Complemento:");
		lblComplementoFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComplementoFuncionarioEditar.setBounds(10, 436, 153, 25);
		Editar.add(lblComplementoFuncionarioEditar);
		
		txtFieldComplementoFuncionarioEditar = new JTextField();
		txtFieldComplementoFuncionarioEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldComplementoFuncionarioEditar.setColumns(10);
		txtFieldComplementoFuncionarioEditar.setBounds(173, 436, 443, 26);
		Editar.add(txtFieldComplementoFuncionarioEditar);
		
		JLabel lblNomedeUsuarioFuncionarioEditar = new JLabel("Nome de Usu\u00E1rio: ");
		lblNomedeUsuarioFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNomedeUsuarioFuncionarioEditar.setBounds(16, 499, 185, 26);
		Editar.add(lblNomedeUsuarioFuncionarioEditar);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(16, 486, 621, 2);
		Editar.add(separator_3);
		
		txtFieldNomedeUsuarioFuncionarioEditar = new JTextField();
		txtFieldNomedeUsuarioFuncionarioEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldNomedeUsuarioFuncionarioEditar.setColumns(10);
		txtFieldNomedeUsuarioFuncionarioEditar.setBounds(211, 500, 230, 26);
		Editar.add(txtFieldNomedeUsuarioFuncionarioEditar);
		
		JLabel lblSenhaFuncionarioEditar = new JLabel("Senha:");
		lblSenhaFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSenhaFuncionarioEditar.setBounds(16, 536, 86, 26);
		Editar.add(lblSenhaFuncionarioEditar);
		
		passwordFieldSenhaFuncEditar = new JPasswordField();
		passwordFieldSenhaFuncEditar.setBounds(211, 537, 230, 25);
		Editar.add(passwordFieldSenhaFuncEditar);
		
		JLabel lblConfSenhaFuncEditar = new JLabel("Confirme a senha:");
		lblConfSenhaFuncEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfSenhaFuncEditar.setBounds(16, 574, 185, 26);
		Editar.add(lblConfSenhaFuncEditar);
		
		passwordFieldConfSenhaFuncEditar = new JPasswordField();
		passwordFieldConfSenhaFuncEditar.setBounds(211, 575, 230, 25);
		Editar.add(passwordFieldConfSenhaFuncEditar);
		
		JButton btnSalvarFuncEditar = new JButton("Salvar");
		btnSalvarFuncEditar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalvarFuncEditar.setBounds(505, 569, 111, 31);
		Editar.add(btnSalvarFuncEditar);
		
		JButton btnCancelarFuncEditar = new JButton("Cancelar");
		btnCancelarFuncEditar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelarFuncEditar.setBounds(654, 569, 127, 31);
		Editar.add(btnCancelarFuncEditar);
		
		JComboBox comboBoxFuncionarioEditar = new JComboBox();
		comboBoxFuncionarioEditar.setBounds(159, 38, 526, 31);
		Editar.add(comboBoxFuncionarioEditar);
		
		JLabel lblNomeFuncionarioEditar = new JLabel("Nome:");
		lblNomeFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNomeFuncionarioEditar.setBounds(16, 101, 76, 23);
		Editar.add(lblNomeFuncionarioEditar);
		
		textFieldNomeFuncionarioEditar = new JTextField();
		textFieldNomeFuncionarioEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNomeFuncionarioEditar.setColumns(10);
		textFieldNomeFuncionarioEditar.setBounds(99, 98, 586, 31);
		Editar.add(textFieldNomeFuncionarioEditar);
		
		JPanel Excluir = new JPanel();
		tabbedPane.addTab("Excluir", null, Excluir, null);
		Excluir.setLayout(null);
		
		JLabel lblFuncionarios = new JLabel("Funcion\u00E1rios:");
		lblFuncionarios.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblFuncionarios.setBounds(26, 37, 147, 23);
		Excluir.add(lblFuncionarios);
		
		JComboBox comboBoxFuncExcluir = new JComboBox();
		comboBoxFuncExcluir.setBounds(168, 29, 541, 31);
		Excluir.add(comboBoxFuncExcluir);
		
		JLabel lblNomeFuncExcluir = new JLabel("Nome:");
		lblNomeFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNomeFuncExcluir.setBounds(26, 92, 76, 23);
		Excluir.add(lblNomeFuncExcluir);
		
		JLabel lblTipoDeUsuarioFuncExcluir = new JLabel("Tipo de Usu\u00E1rio:");
		lblTipoDeUsuarioFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTipoDeUsuarioFuncExcluir.setBounds(26, 145, 177, 31);
		Excluir.add(lblTipoDeUsuarioFuncExcluir);
		
		txtFieldFuncExcluir = new JTextField();
		txtFieldFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldFuncExcluir.setColumns(10);
		txtFieldFuncExcluir.setBounds(109, 89, 600, 31);
		Excluir.add(txtFieldFuncExcluir);
		
		JRadioButton rbtnGerenteFuncExcluir = new JRadioButton("Gerente");
		rbtnGerenteFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		rbtnGerenteFuncExcluir.setBounds(262, 149, 109, 23);
		Excluir.add(rbtnGerenteFuncExcluir);
		
		JRadioButton rbtnFuncFuncExcluir = new JRadioButton("Funcion\u00E1rio");
		rbtnFuncFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		rbtnFuncFuncExcluir.setBounds(424, 149, 145, 23);
		Excluir.add(rbtnFuncFuncExcluir);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(26, 195, 621, 2);
		Excluir.add(separator_4);
		
		JLabel lblEnderecoFuncExcluir = new JLabel("Endere\u00E7o");
		lblEnderecoFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnderecoFuncExcluir.setBounds(26, 208, 99, 23);
		Excluir.add(lblEnderecoFuncExcluir);
		
		JLabel lblRuaFuncExcluir = new JLabel("Rua:");
		lblRuaFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRuaFuncExcluir.setBounds(26, 265, 63, 25);
		Excluir.add(lblRuaFuncExcluir);
		
		txtFieldRuaFuncExcluir = new JTextField();
		txtFieldRuaFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldRuaFuncExcluir.setColumns(10);
		txtFieldRuaFuncExcluir.setBounds(87, 265, 338, 25);
		Excluir.add(txtFieldRuaFuncExcluir);
		
		JLabel lblBairroFuncExcluir = new JLabel("Bairro:");
		lblBairroFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBairroFuncExcluir.setBounds(26, 324, 77, 25);
		Excluir.add(lblBairroFuncExcluir);
		
		txtFieldBairroFuncExcluir = new JTextField();
		txtFieldBairroFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldBairroFuncExcluir.setColumns(10);
		txtFieldBairroFuncExcluir.setBounds(109, 324, 313, 26);
		Excluir.add(txtFieldBairroFuncExcluir);
		
		JLabel lblCidadeFuncExcluir = new JLabel("Cidade:");
		lblCidadeFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCidadeFuncExcluir.setBounds(26, 377, 77, 26);
		Excluir.add(lblCidadeFuncExcluir);
		
		txtFieldCidadeFuncExcluir = new JTextField();
		txtFieldCidadeFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldCidadeFuncExcluir.setColumns(10);
		txtFieldCidadeFuncExcluir.setBounds(112, 377, 230, 26);
		Excluir.add(txtFieldCidadeFuncExcluir);
		
		JLabel lblComplementoFuncExcluir = new JLabel("Complemento:");
		lblComplementoFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComplementoFuncExcluir.setBounds(26, 427, 153, 25);
		Excluir.add(lblComplementoFuncExcluir);
		
		txtFieldComplFuncExcluir = new JTextField();
		txtFieldComplFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldComplFuncExcluir.setColumns(10);
		txtFieldComplFuncExcluir.setBounds(183, 427, 443, 26);
		Excluir.add(txtFieldComplFuncExcluir);
		
		JLabel lblEstadoFuncExcluir = new JLabel("Estado:");
		lblEstadoFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEstadoFuncExcluir.setBounds(381, 378, 77, 25);
		Excluir.add(lblEstadoFuncExcluir);
		
		txtFieldEstadoFuncExcluir = new JTextField();
		txtFieldEstadoFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldEstadoFuncExcluir.setColumns(10);
		txtFieldEstadoFuncExcluir.setBounds(467, 377, 156, 26);
		Excluir.add(txtFieldEstadoFuncExcluir);
		
		JLabel lblNFuncExcluir = new JLabel("N\u00BA:");
		lblNFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNFuncExcluir.setBounds(445, 265, 41, 25);
		Excluir.add(lblNFuncExcluir);
		
		txtFieldNFuncExcluir = new JTextField();
		txtFieldNFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldNFuncExcluir.setColumns(10);
		txtFieldNFuncExcluir.setBounds(485, 265, 135, 25);
		Excluir.add(txtFieldNFuncExcluir);
		
		txtFieldCepFuncExcluir = new JTextField();
		txtFieldCepFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldCepFuncExcluir.setColumns(10);
		txtFieldCepFuncExcluir.setBounds(493, 323, 127, 26);
		Excluir.add(txtFieldCepFuncExcluir);
		
		JLabel lblCepFuncExcluir = new JLabel("CEP:");
		lblCepFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCepFuncExcluir.setBounds(445, 323, 52, 25);
		Excluir.add(lblCepFuncExcluir);
		
		txtFieldNDeUsuarioFuncExcluir = new JTextField();
		txtFieldNDeUsuarioFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldNDeUsuarioFuncExcluir.setColumns(10);
		txtFieldNDeUsuarioFuncExcluir.setBounds(221, 491, 230, 26);
		Excluir.add(txtFieldNDeUsuarioFuncExcluir);
		
		passwordFieldSenhaFuncExcluir = new JPasswordField();
		passwordFieldSenhaFuncExcluir.setBounds(221, 528, 230, 25);
		Excluir.add(passwordFieldSenhaFuncExcluir);
		
		passwordFieldConfASenhaFuncExcluir = new JPasswordField();
		passwordFieldConfASenhaFuncExcluir.setBounds(221, 566, 230, 25);
		Excluir.add(passwordFieldConfASenhaFuncExcluir);
		
		JLabel lblConfASenhaFuncExcluir = new JLabel("Confirme a senha:");
		lblConfASenhaFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfASenhaFuncExcluir.setBounds(26, 565, 185, 26);
		Excluir.add(lblConfASenhaFuncExcluir);
		
		JLabel lblSenhaFuncExcluir = new JLabel("Senha:");
		lblSenhaFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSenhaFuncExcluir.setBounds(26, 527, 86, 26);
		Excluir.add(lblSenhaFuncExcluir);
		
		JLabel lblNdeUsuarioFuncExcluir = new JLabel("Nome de Usu\u00E1rio: ");
		lblNdeUsuarioFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNdeUsuarioFuncExcluir.setBounds(26, 490, 185, 26);
		Excluir.add(lblNdeUsuarioFuncExcluir);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(26, 477, 621, 2);
		Excluir.add(separator_5);
		
		JButton BtnExcluirFuncionario = new JButton("Excluir");
		BtnExcluirFuncionario.setFont(new Font("Tahoma", Font.BOLD, 18));
		BtnExcluirFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BtnExcluirFuncionario.setBounds(546, 559, 109, 31);
		Excluir.add(BtnExcluirFuncionario);
	}
}
