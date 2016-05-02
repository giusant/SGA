package br.si.es.sga.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;

import br.si.es.sga.dto.EnderecoDTO;
import br.si.es.sga.dto.ModalidadeDTO;
import br.si.es.sga.dto.UsuarioDTO;
import br.si.es.sga.exeception.LogicException;
import br.si.es.sga.logic.EnderecoLogic;
import br.si.es.sga.logic.ModalidadeLogic;
import br.si.es.sga.logic.UsuarioLogic;
import br.si.es.sga.util.MessageUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.ButtonGroup;

public class CadastroFuncionarioUI extends JFrame {
	UsuarioLogic usuarioLogic =  new UsuarioLogic();
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
	JComboBox comboBoxFuncionarioEditar;
	JComboBox comboBoxFuncExcluir;
	private JTextField textFieldTelefoneFuncCadastro;
	private JTextField textFieldTelefoneFuncEditar;
	private JTextField textFieldTelefoneFuncExcluir;
	JRadioButton rdbtnGerenteFuncionarioCadastro;
	JRadioButton rdbtnFuncionrioFuncionarioCadastro;
	JRadioButton radioButtonGerenteFuncionarioEditar;
	JRadioButton rbtnFuncionarioFuncionarioEditar;
	JRadioButton rbtnGerenteFuncExcluir;
	JRadioButton rbtnFuncFuncExcluir;
	private final ButtonGroup buttonGroupFuncionarioExcluir = new ButtonGroup();
	private final ButtonGroup buttonGroupFuncionarioEditar = new ButtonGroup();
	private final ButtonGroup buttonGroupFuncionarioCadastrar = new ButtonGroup();
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
		this.setTitle("Funcion\u00E1rio");
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
		
		rdbtnGerenteFuncionarioCadastro = new JRadioButton("Gerente");
		buttonGroupFuncionarioCadastrar.add(rdbtnGerenteFuncionarioCadastro);
		rdbtnGerenteFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnGerenteFuncionarioCadastro.setBounds(315, 97, 109, 23);
		Cadastrar.add(rdbtnGerenteFuncionarioCadastro);
		
		rdbtnFuncionrioFuncionarioCadastro = new JRadioButton("Funcion\u00E1rio");
		buttonGroupFuncionarioCadastrar.add(rdbtnFuncionrioFuncionarioCadastro);
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
		lblRuaFuncionarioCadastro.setBounds(47, 241, 63, 25);
		Cadastrar.add(lblRuaFuncionarioCadastro);
		
		textFieldRuaFuncionarioCadastro = new JTextField();
		textFieldRuaFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldRuaFuncionarioCadastro.setColumns(10);
		textFieldRuaFuncionarioCadastro.setBounds(108, 241, 338, 25);
		Cadastrar.add(textFieldRuaFuncionarioCadastro);
		
		JLabel lblNFuncionarioCadastro = new JLabel("N\u00BA:");
		lblNFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNFuncionarioCadastro.setBounds(466, 241, 63, 25);
		Cadastrar.add(lblNFuncionarioCadastro);
		
		textFieldNFuncionarioCadastro = new JTextField();
		textFieldNFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNFuncionarioCadastro.setColumns(10);
		textFieldNFuncionarioCadastro.setBounds(506, 241, 135, 25);
		Cadastrar.add(textFieldNFuncionarioCadastro);
		
		JLabel lblBairroFuncionarioCadastro = new JLabel("Bairro:");
		lblBairroFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBairroFuncionarioCadastro.setBounds(47, 277, 77, 25);
		Cadastrar.add(lblBairroFuncionarioCadastro);
		
		textFieldBairroFuncionarioCadastro = new JTextField();
		textFieldBairroFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldBairroFuncionarioCadastro.setColumns(10);
		textFieldBairroFuncionarioCadastro.setBounds(130, 277, 313, 26);
		Cadastrar.add(textFieldBairroFuncionarioCadastro);
		
		JLabel lblCepFuncionarioCadastro = new JLabel("CEP:");
		lblCepFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCepFuncionarioCadastro.setBounds(466, 277, 52, 25);
		Cadastrar.add(lblCepFuncionarioCadastro);
		
		txtFieldCepFuncionarioCadastro = new JTextField();
		txtFieldCepFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldCepFuncionarioCadastro.setColumns(10);
		txtFieldCepFuncionarioCadastro.setBounds(514, 277, 127, 26);
		Cadastrar.add(txtFieldCepFuncionarioCadastro);
		
		JLabel lblCidadeFuncionariCadastro = new JLabel("Cidade:");
		lblCidadeFuncionariCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCidadeFuncionariCadastro.setBounds(45, 322, 77, 26);
		Cadastrar.add(lblCidadeFuncionariCadastro);
		
		textFieldCidadeFuncionarioCadastro = new JTextField();
		textFieldCidadeFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCidadeFuncionarioCadastro.setColumns(10);
		textFieldCidadeFuncionarioCadastro.setBounds(131, 322, 250, 26);
		Cadastrar.add(textFieldCidadeFuncionarioCadastro);
		
		JLabel lblEstadoFuncionarioCadastro = new JLabel("Estado:");
		lblEstadoFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEstadoFuncionarioCadastro.setBounds(399, 323, 77, 25);
		Cadastrar.add(lblEstadoFuncionarioCadastro);
		
		textFieldEstadoFuncionarioCadastro = new JTextField();
		textFieldEstadoFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldEstadoFuncionarioCadastro.setColumns(10);
		textFieldEstadoFuncionarioCadastro.setBounds(485, 322, 156, 26);
		Cadastrar.add(textFieldEstadoFuncionarioCadastro);
		
		JLabel lblComplementoFuncionarioCadastro = new JLabel("Complemento:");
		lblComplementoFuncionarioCadastro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComplementoFuncionarioCadastro.setBounds(47, 426, 153, 25);
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
		btnSalvarFuncCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDTO usuarioDTO = new UsuarioDTO();
				UsuarioLogic usuarioLogic = new UsuarioLogic();
				EnderecoDTO enderecoDTO = new EnderecoDTO();
				EnderecoLogic enderecoLogic = new EnderecoLogic();
				try {
					boolean gerente = rdbtnFuncionrioFuncionarioCadastro.isSelected() ? false : true;
					
					enderecoDTO.setBairro(textFieldBairroFuncionarioCadastro.getText());
					enderecoDTO.setCidade(textFieldCidadeFuncionarioCadastro.getText());
					enderecoDTO.setRua(textFieldRuaFuncionarioCadastro.getText());
					enderecoDTO.setCep( Integer.parseInt(txtFieldCepFuncionarioCadastro.getText()));
					enderecoDTO.setComplemento(txtFieldComplementoFuncionarioCadastro.getText());
					enderecoDTO.setNumero(Integer.parseInt(textFieldNFuncionarioCadastro.getText()));
					enderecoDTO.setEstado(textFieldEstadoFuncionarioCadastro.getText());
					
					//int idEndereco =  enderecoLogic.cadastrar(enderecoDTO);

			
					usuarioDTO.setNomeUsuario(textFieldNomeFuncionarioCadastro.getText());
					usuarioDTO.setGerente(gerente);
					usuarioDTO.setLogin(txtFieldNomeDeUsuarioFuncionarioCadastro.getText());
					usuarioDTO.setSenha(String.valueOf(passwordFieldSenhaFuncionarioCadastro.getPassword()));
					usuarioDTO.setTelefoneUsuario(textFieldTelefoneFuncCadastro.getText());
					usuarioDTO.setEndereco(enderecoDTO);
					
					if(!String.valueOf(passwordFieldConfirmaSenhaFuncionarioCadastro.getPassword()).equals(String.valueOf(passwordFieldSenhaFuncionarioCadastro.getPassword()))){
						MessageUtil.addMsg(CadastroFuncionarioUI.this, "Senhas incompatíveis");
						passwordFieldConfirmaSenhaFuncionarioCadastro.setText("");
						passwordFieldSenhaFuncionarioCadastro.setText("");
					}else{
						usuarioLogic.cadastrar(usuarioDTO);
						JOptionPane.showMessageDialog(CadastroFuncionarioUI.this,"Sucesso!");
						CadastroFuncionarioUI.this.dispose();
						main(null);
					}
					
					
				} catch (LogicException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
		
		});
		btnSalvarFuncCadastrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalvarFuncCadastrar.setBounds(536, 559, 111, 31);
		Cadastrar.add(btnSalvarFuncCadastrar);
		
		JButton btnCancelarFuncCadastrar = new JButton("limpar");
		btnCancelarFuncCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dados do usuario
				textFieldNomeFuncionarioCadastro.setText("");  
				rdbtnFuncionrioFuncionarioCadastro.setSelected(false);
				rdbtnGerenteFuncionarioCadastro.setSelected(true);
				txtFieldNomeDeUsuarioFuncionarioCadastro.setText("");
				textFieldTelefoneFuncCadastro.setText("");
				passwordFieldSenhaFuncionarioCadastro.setText("");
				passwordFieldConfirmaSenhaFuncionarioCadastro.setText("");
				//dados do endereço
				textFieldBairroFuncionarioCadastro.setText("");
				textFieldCidadeFuncionarioCadastro.setText("");
				textFieldRuaFuncionarioCadastro.setText("");
				txtFieldCepFuncionarioCadastro.setText("");
				txtFieldComplementoFuncionarioCadastro.setText("");
				textFieldNFuncionarioCadastro.setText("");
				textFieldEstadoFuncionarioCadastro.setText("");
				
				
			
				
			}
		});
		btnCancelarFuncCadastrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelarFuncCadastrar.setBounds(685, 559, 127, 31);
		Cadastrar.add(btnCancelarFuncCadastrar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(47, 194, 621, 2);
		Cadastrar.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(47, 476, 621, 2);
		Cadastrar.add(separator_1);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTelefone.setBounds(47, 374, 99, 26);
		Cadastrar.add(lblTelefone);
		
		textFieldTelefoneFuncCadastro = new JTextField();
		textFieldTelefoneFuncCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldTelefoneFuncCadastro.setColumns(10);
		textFieldTelefoneFuncCadastro.setBounds(157, 374, 224, 26);
		Cadastrar.add(textFieldTelefoneFuncCadastro);
		
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
		
		radioButtonGerenteFuncionarioEditar = new JRadioButton("Gerente");
		buttonGroupFuncionarioEditar.add(radioButtonGerenteFuncionarioEditar);
		radioButtonGerenteFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		radioButtonGerenteFuncionarioEditar.setBounds(252, 158, 109, 23);
		Editar.add(radioButtonGerenteFuncionarioEditar);
		
		rbtnFuncionarioFuncionarioEditar = new JRadioButton("Funcion\u00E1rio");
		buttonGroupFuncionarioEditar.add(rbtnFuncionarioFuncionarioEditar);
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
		txtFieldNFuncionarioEditar.setBounds(435, 251, 41, 25);
		Editar.add(txtFieldNFuncionarioEditar);
		
		txtFieldRuaFuncionarioEditar = new JTextField();
		txtFieldRuaFuncionarioEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldRuaFuncionarioEditar.setColumns(10);
		txtFieldRuaFuncionarioEditar.setBounds(77, 251, 338, 25);
		Editar.add(txtFieldRuaFuncionarioEditar);
		
		JLabel lblRuaFuncionarioEditar = new JLabel("Rua:");
		lblRuaFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRuaFuncionarioEditar.setBounds(16, 251, 63, 25);
		Editar.add(lblRuaFuncionarioEditar);
		
		JLabel lblBairroFuncionarioEditar = new JLabel("Bairro:");
		lblBairroFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBairroFuncionarioEditar.setBounds(16, 288, 77, 25);
		Editar.add(lblBairroFuncionarioEditar);
		
		txtFieldBairroFuncionarioEditar = new JTextField();
		txtFieldBairroFuncionarioEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldBairroFuncionarioEditar.setColumns(10);
		txtFieldBairroFuncionarioEditar.setBounds(99, 288, 313, 26);
		Editar.add(txtFieldBairroFuncionarioEditar);
		
		JLabel lblCidadeFuncionarioEditar = new JLabel("Cidade:");
		lblCidadeFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCidadeFuncionarioEditar.setBounds(16, 335, 77, 26);
		Editar.add(lblCidadeFuncionarioEditar);
		
		txtFieldCidadeFuncionarioEditar = new JTextField();
		txtFieldCidadeFuncionarioEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldCidadeFuncionarioEditar.setColumns(10);
		txtFieldCidadeFuncionarioEditar.setBounds(131, 336, 230, 26);
		Editar.add(txtFieldCidadeFuncionarioEditar);
		
		JLabel lblEstadoFuncionarioEditar = new JLabel("Estado:");
		lblEstadoFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEstadoFuncionarioEditar.setBounds(371, 336, 77, 25);
		Editar.add(lblEstadoFuncionarioEditar);
		
		txtFieldEstadoFuncionarioEditar = new JTextField();
		txtFieldEstadoFuncionarioEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldEstadoFuncionarioEditar.setColumns(10);
		txtFieldEstadoFuncionarioEditar.setBounds(457, 335, 156, 26);
		Editar.add(txtFieldEstadoFuncionarioEditar);
		
		JLabel lblCepFuncionarioEditar = new JLabel("CEP:");
		lblCepFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCepFuncionarioEditar.setBounds(424, 287, 52, 25);
		Editar.add(lblCepFuncionarioEditar);
		
		txtFieldCepFuncionarioEditar = new JTextField();
		txtFieldCepFuncionarioEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldCepFuncionarioEditar.setColumns(10);
		txtFieldCepFuncionarioEditar.setBounds(483, 287, 127, 26);
		Editar.add(txtFieldCepFuncionarioEditar);
		
		textFieldNFuncionarioEditar = new JTextField();
		textFieldNFuncionarioEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNFuncionarioEditar.setColumns(10);
		textFieldNFuncionarioEditar.setBounds(475, 251, 135, 25);
		Editar.add(textFieldNFuncionarioEditar);
		
		JLabel lblComplementoFuncionarioEditar = new JLabel("Complemento:");
		lblComplementoFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComplementoFuncionarioEditar.setBounds(20, 435, 153, 25);
		Editar.add(lblComplementoFuncionarioEditar);
		
		txtFieldComplementoFuncionarioEditar = new JTextField();
		txtFieldComplementoFuncionarioEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldComplementoFuncionarioEditar.setColumns(10);
		txtFieldComplementoFuncionarioEditar.setBounds(183, 435, 443, 26);
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
		btnSalvarFuncEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDTO usuarioDTO = new UsuarioDTO();
				UsuarioLogic usuarioLogic = new UsuarioLogic();
				EnderecoDTO enderecoDTO = new EnderecoDTO();
				EnderecoLogic enderecoLogic = new EnderecoLogic();
				try {
					boolean gerente = rbtnFuncionarioFuncionarioEditar.isSelected() ? false : true;
					
					enderecoDTO.setBairro(txtFieldBairroFuncionarioEditar.getText());
					enderecoDTO.setCidade(txtFieldCidadeFuncionarioEditar.getText());
					enderecoDTO.setRua(txtFieldRuaFuncionarioEditar.getText());
					enderecoDTO.setCep( Integer.parseInt(txtFieldCepFuncionarioEditar.getText()));
					enderecoDTO.setComplemento(txtFieldComplementoFuncionarioEditar.getText());
					enderecoDTO.setNumero(Integer.parseInt(textFieldNFuncionarioEditar.getText()));
					enderecoDTO.setEstado(txtFieldEstadoFuncionarioEditar.getText());
					 String login = recuperarIDCamposEditar();
					 UsuarioDTO usuarioAtual = usuarioLogic.getUsuarioPorLogin(login);
					 
					enderecoDTO.setIdEndereco(usuarioAtual.getEndereco().getIdEndereco());
					//int idEndereco =  enderecoLogic.cadastrar(enderecoDTO);

			
					usuarioDTO.setNomeUsuario(textFieldNomeFuncionarioEditar.getText());
					usuarioDTO.setGerente(gerente);
					usuarioDTO.setLogin(txtFieldNomedeUsuarioFuncionarioEditar.getText());
					usuarioDTO.setSenha(String.valueOf(passwordFieldSenhaFuncEditar.getPassword()));
					usuarioDTO.setTelefoneUsuario(textFieldTelefoneFuncEditar.getText());
					usuarioDTO.setEndereco(enderecoDTO);

					if(!String.valueOf(passwordFieldConfSenhaFuncEditar.getPassword()).equals(String.valueOf(passwordFieldSenhaFuncEditar.getPassword()))){
						MessageUtil.addMsg(CadastroFuncionarioUI.this, "Senhas incompatíveis");
						passwordFieldConfSenhaFuncEditar.setText("");
						passwordFieldSenhaFuncEditar.setText("");
					}else{
						usuarioLogic.atualizar(usuarioDTO);
						JOptionPane.showMessageDialog(CadastroFuncionarioUI.this,"Sucesso!");

						CadastroFuncionarioUI.this.dispose();
						main(null);
					}
					
					
				} catch (LogicException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
					
				
			}
		});
		btnSalvarFuncEditar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalvarFuncEditar.setBounds(505, 569, 111, 31);
		Editar.add(btnSalvarFuncEditar);
		
		JButton btnCancelarFuncEditar = new JButton("Limpar");
		btnCancelarFuncEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNomeFuncionarioEditar.setText("");  
				rbtnFuncionarioFuncionarioEditar.setSelected(false);
				radioButtonGerenteFuncionarioEditar.setSelected(true);
				txtFieldNomedeUsuarioFuncionarioEditar.setText("");
				textFieldTelefoneFuncEditar.setText("");
				passwordFieldSenhaFuncEditar.setText("");
				passwordFieldConfSenhaFuncEditar.setText("");
				//dados do endereço
				txtFieldBairroFuncionarioEditar.setText("");
				txtFieldCidadeFuncionarioEditar.setText("");
				txtFieldRuaFuncionarioEditar.setText("");
				txtFieldCepFuncionarioEditar.setText("");
				txtFieldComplementoFuncionarioEditar.setText("");
				textFieldNFuncionarioEditar.setText("");
				txtFieldEstadoFuncionarioEditar.setText("");
			}
		});
		btnCancelarFuncEditar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelarFuncEditar.setBounds(654, 569, 127, 31);
		Editar.add(btnCancelarFuncEditar);
		
		
		JLabel lblNomeFuncionarioEditar = new JLabel("Nome:");
		lblNomeFuncionarioEditar.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNomeFuncionarioEditar.setBounds(16, 101, 76, 23);
		Editar.add(lblNomeFuncionarioEditar);
		
		textFieldNomeFuncionarioEditar = new JTextField();
		textFieldNomeFuncionarioEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNomeFuncionarioEditar.setColumns(10);
		textFieldNomeFuncionarioEditar.setBounds(99, 98, 586, 31);
		Editar.add(textFieldNomeFuncionarioEditar);

		JButton btnSelecionarFuncEditar = new JButton("Selecionar");
		btnSelecionarFuncEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarCamposEditar();
					
				}
		});
		btnSelecionarFuncEditar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSelecionarFuncEditar.setBounds(708, 38, 145, 31);
		Editar.add(btnSelecionarFuncEditar);
		
		JLabel lblTelefoneFuncEditar = new JLabel("Telefone\r\n:");
		lblTelefoneFuncEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTelefoneFuncEditar.setBounds(16, 384, 105, 26);
		Editar.add(lblTelefoneFuncEditar);

		textFieldTelefoneFuncEditar = new JTextField();
		textFieldTelefoneFuncEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldTelefoneFuncEditar.setColumns(10);
		textFieldTelefoneFuncEditar.setBounds(131, 385, 230, 26);
		Editar.add(textFieldTelefoneFuncEditar);

		JPanel Excluir = new JPanel();
		tabbedPane.addTab("Excluir", null, Excluir, null);
		Excluir.setLayout(null);
		
		JLabel lblFuncionarios = new JLabel("Funcion\u00E1rios:");
		lblFuncionarios.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblFuncionarios.setBounds(26, 37, 147, 23);
		Excluir.add(lblFuncionarios);
		
		JLabel lblNomeFuncExcluir = new JLabel("Nome:");
		lblNomeFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNomeFuncExcluir.setBounds(26, 92, 76, 23);
		Excluir.add(lblNomeFuncExcluir);
		
		JLabel lblTipoDeUsuarioFuncExcluir = new JLabel("Tipo de Usu\u00E1rio:");
		lblTipoDeUsuarioFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTipoDeUsuarioFuncExcluir.setBounds(26, 145, 177, 31);
		Excluir.add(lblTipoDeUsuarioFuncExcluir);
		
		txtFieldFuncExcluir = new JTextField();
		txtFieldFuncExcluir.setEnabled(false);
		txtFieldFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldFuncExcluir.setColumns(10);
		txtFieldFuncExcluir.setBounds(109, 89, 600, 31);
		Excluir.add(txtFieldFuncExcluir);
		
		rbtnGerenteFuncExcluir = new JRadioButton("Gerente");
		rbtnGerenteFuncExcluir.setEnabled(false);
		buttonGroupFuncionarioExcluir.add(rbtnGerenteFuncExcluir);
		rbtnGerenteFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		rbtnGerenteFuncExcluir.setBounds(262, 149, 109, 23);
		Excluir.add(rbtnGerenteFuncExcluir);
		
		rbtnFuncFuncExcluir = new JRadioButton("Funcion\u00E1rio");
		rbtnFuncFuncExcluir.setEnabled(false);
		buttonGroupFuncionarioExcluir.add(rbtnFuncFuncExcluir);
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
		lblRuaFuncExcluir.setBounds(26, 242, 63, 25);
		Excluir.add(lblRuaFuncExcluir);
		
		txtFieldRuaFuncExcluir = new JTextField();
		txtFieldRuaFuncExcluir.setEnabled(false);
		txtFieldRuaFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldRuaFuncExcluir.setColumns(10);
		txtFieldRuaFuncExcluir.setBounds(87, 242, 338, 25);
		Excluir.add(txtFieldRuaFuncExcluir);
		
		JLabel lblBairroFuncExcluir = new JLabel("Bairro:");
		lblBairroFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBairroFuncExcluir.setBounds(26, 289, 77, 25);
		Excluir.add(lblBairroFuncExcluir);
		
		txtFieldBairroFuncExcluir = new JTextField();
		txtFieldBairroFuncExcluir.setEnabled(false);
		txtFieldBairroFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldBairroFuncExcluir.setColumns(10);
		txtFieldBairroFuncExcluir.setBounds(109, 289, 313, 26);
		Excluir.add(txtFieldBairroFuncExcluir);
		
		JLabel lblCidadeFuncExcluir = new JLabel("Cidade:");
		lblCidadeFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCidadeFuncExcluir.setBounds(26, 339, 77, 26);
		Excluir.add(lblCidadeFuncExcluir);
		
		txtFieldCidadeFuncExcluir = new JTextField();
		txtFieldCidadeFuncExcluir.setEnabled(false);
		txtFieldCidadeFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldCidadeFuncExcluir.setColumns(10);
		txtFieldCidadeFuncExcluir.setBounds(112, 339, 259, 26);
		Excluir.add(txtFieldCidadeFuncExcluir);
		
		JLabel lblComplementoFuncExcluir = new JLabel("Complemento:");
		lblComplementoFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComplementoFuncExcluir.setBounds(26, 440, 153, 25);
		Excluir.add(lblComplementoFuncExcluir);
		
		txtFieldComplFuncExcluir = new JTextField();
		txtFieldComplFuncExcluir.setEnabled(false);
		txtFieldComplFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldComplFuncExcluir.setColumns(10);
		txtFieldComplFuncExcluir.setBounds(183, 440, 443, 26);
		Excluir.add(txtFieldComplFuncExcluir);
		
		JLabel lblEstadoFuncExcluir = new JLabel("Estado:");
		lblEstadoFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEstadoFuncExcluir.setBounds(381, 340, 77, 25);
		Excluir.add(lblEstadoFuncExcluir);
		
		txtFieldEstadoFuncExcluir = new JTextField();
		txtFieldEstadoFuncExcluir.setEnabled(false);
		txtFieldEstadoFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldEstadoFuncExcluir.setColumns(10);
		txtFieldEstadoFuncExcluir.setBounds(467, 339, 156, 26);
		Excluir.add(txtFieldEstadoFuncExcluir);
		
		JLabel lblNFuncExcluir = new JLabel("N\u00BA:");
		lblNFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNFuncExcluir.setBounds(445, 242, 41, 25);
		Excluir.add(lblNFuncExcluir);
		
		txtFieldNFuncExcluir = new JTextField();
		txtFieldNFuncExcluir.setEnabled(false);
		txtFieldNFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldNFuncExcluir.setColumns(10);
		txtFieldNFuncExcluir.setBounds(485, 242, 135, 25);
		Excluir.add(txtFieldNFuncExcluir);
		
		txtFieldCepFuncExcluir = new JTextField();
		txtFieldCepFuncExcluir.setEnabled(false);
		txtFieldCepFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldCepFuncExcluir.setColumns(10);
		txtFieldCepFuncExcluir.setBounds(493, 288, 127, 26);
		Excluir.add(txtFieldCepFuncExcluir);
		
		JLabel lblCepFuncExcluir = new JLabel("CEP:");
		lblCepFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCepFuncExcluir.setBounds(445, 288, 52, 25);
		Excluir.add(lblCepFuncExcluir);
		
		txtFieldNDeUsuarioFuncExcluir = new JTextField();
		txtFieldNDeUsuarioFuncExcluir.setEnabled(false);
		txtFieldNDeUsuarioFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldNDeUsuarioFuncExcluir.setColumns(10);
		txtFieldNDeUsuarioFuncExcluir.setBounds(221, 491, 230, 26);
		Excluir.add(txtFieldNDeUsuarioFuncExcluir);
		
		passwordFieldSenhaFuncExcluir = new JPasswordField();
		passwordFieldSenhaFuncExcluir.setEnabled(false);
		passwordFieldSenhaFuncExcluir.setBounds(221, 528, 230, 25);
		Excluir.add(passwordFieldSenhaFuncExcluir);
		
		passwordFieldConfASenhaFuncExcluir = new JPasswordField();
		passwordFieldConfASenhaFuncExcluir.setEnabled(false);
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
				UsuarioDTO usuarioDTO = new UsuarioDTO();
				UsuarioLogic usuarioLogic = new UsuarioLogic();
				try {
					//usuarioDTO.setLogin(recuperarIDCamposExcluir());
					 usuarioDTO = usuarioLogic.getUsuarioPorLogin(recuperarIDCamposExcluir());
					usuarioLogic.removerUsuario(usuarioDTO.getLogin(), usuarioDTO.getEndereco().getIdEndereco());
					JOptionPane.showMessageDialog(CadastroFuncionarioUI.this,"Sucesso!");
					CadastroFuncionarioUI.this.dispose();
					main(null);
				} catch (LogicException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		BtnExcluirFuncionario.setBounds(546, 559, 109, 31);
		Excluir.add(BtnExcluirFuncionario);
		
		JButton btnSelecionarFuncExcluir = new JButton("Selecionar");
		btnSelecionarFuncExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarCamposExcluir();
			}
		});
		btnSelecionarFuncExcluir.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSelecionarFuncExcluir.setBounds(714, 29, 145, 31);
		Excluir.add(btnSelecionarFuncExcluir);
		JLabel lblTelefoneFunExcluir = new JLabel("Telefone\r\n:");
		lblTelefoneFunExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTelefoneFunExcluir.setBounds(26, 389, 105, 26);
		Excluir.add(lblTelefoneFunExcluir);
		
		textFieldTelefoneFuncExcluir = new JTextField();
		textFieldTelefoneFuncExcluir.setEnabled(false);
		textFieldTelefoneFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldTelefoneFuncExcluir.setColumns(10);
		textFieldTelefoneFuncExcluir.setBounds(141, 390, 230, 26);
		Excluir.add(textFieldTelefoneFuncExcluir);
		// codigo que converte o atributo para uma combobox Editar
		try{

			ComboBoxModel comboModalidadeModel;
			comboModalidadeModel = new DefaultComboBoxModel(converteUsuario(usuarioLogic.listarUsuario()));

			comboBoxFuncionarioEditar = new JComboBox();
			comboBoxFuncionarioEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
			comboBoxFuncionarioEditar.setModel(comboModalidadeModel);


		}catch(LogicException e){
			e.printStackTrace();
			//MessagensUtil.addMsg(MainFrame.this, e.getMessage());
		}

		comboBoxFuncionarioEditar.setBounds(159, 38, 526, 31);
		Editar.add(comboBoxFuncionarioEditar);

		// codigo que converte o atributo para uma combobox Excluir
		try{

			ComboBoxModel comboModalidadeModel;
			comboModalidadeModel = new DefaultComboBoxModel(converteUsuario(usuarioLogic.listarUsuario()));
			comboBoxFuncExcluir = new JComboBox();
			comboBoxFuncExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
			comboBoxFuncExcluir.setModel(comboModalidadeModel);
		}catch(LogicException e){
			e.printStackTrace();
			//MessagensUtil.addMsg(MainFrame.this, e.getMessage());
		}

		comboBoxFuncExcluir.setBounds(168, 29, 541, 31);
		Excluir.add(comboBoxFuncExcluir);
		
	
	}

	public String[] converteUsuario(List<UsuarioDTO> listarUsuario) {
		String[] result = new String[listarUsuario.size()];
		for(int i = 0; i < listarUsuario.size();i++){
			UsuarioDTO usuarioDTO = listarUsuario.get(i);
			result[i] =  usuarioDTO.getNomeUsuario();

		}
		return result;
	}
	public UsuarioDTO[] converte(List<UsuarioDTO> listarUsuario) {
		UsuarioDTO[] result = new UsuarioDTO[listarUsuario.size()];
		for(int i = 0; i < listarUsuario.size();i++){
			UsuarioDTO usuarioDTO = listarUsuario.get(i);
			result[i] =  usuarioDTO;

		}
		return result;
	}
	
	//Recupera o id do objeto da comobox 
	public String recuperarIDCamposEditar (){
		UsuarioDTO usuarioEditar = null;
		String nomeComoboxEditar =  (String) comboBoxFuncionarioEditar.getSelectedItem().toString();
		try {
		UsuarioDTO[] test = converte(usuarioLogic.listarUsuario());
	
		if(nomeComoboxEditar.equals(test[ comboBoxFuncionarioEditar.getSelectedIndex()].getNomeUsuario()) ){
		 usuarioEditar = usuarioLogic.getUsuario(nomeComoboxEditar);
		}
		
			//modalidadeEditar = modalidadeLogic.getModalidade(nomeComoboxEditar);
		} catch (LogicException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return usuarioEditar.getLogin()	;
	}

	//Recupera o id do objeto da comobox 
		public String recuperarIDCamposExcluir (){
			String nomeComoboxExcluir =  (String) comboBoxFuncExcluir.getSelectedItem().toString();
			UsuarioDTO usuarioExcluir = null;
			try {
				UsuarioDTO[] test = converte(usuarioLogic.listarUsuario());
				
				if(nomeComoboxExcluir.equals(test[ comboBoxFuncExcluir.getSelectedIndex()].getNomeUsuario()) ){
				 usuarioExcluir = usuarioLogic.getUsuario(nomeComoboxExcluir);
				}
			
			//	usuarioExcluir = usuarioLogic.getUsuario(nomeComoboxExcluir);
			} catch (LogicException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return usuarioExcluir.getLogin();
		}
		
		public void populationUsuarioEditar(UsuarioDTO usuarioDTO){
			//dados do usuario
			this.textFieldNomeFuncionarioEditar.setText(usuarioDTO.getNomeUsuario().toString());  
			this.rbtnFuncionarioFuncionarioEditar.setSelected(!usuarioDTO.isGerente());
			this.radioButtonGerenteFuncionarioEditar.setSelected(usuarioDTO.isGerente());
			this.txtFieldNomedeUsuarioFuncionarioEditar.setText(usuarioDTO.getLogin().toString());
			this.textFieldTelefoneFuncEditar.setText((usuarioDTO.getTelefoneUsuario()));
			this.passwordFieldSenhaFuncEditar.setText(usuarioDTO.getSenha());
			this.passwordFieldConfSenhaFuncEditar.setText(usuarioDTO.getSenha());
			//dados do endereço
			this.txtFieldBairroFuncionarioEditar.setText(usuarioDTO.getEndereco().getBairro());
			this.txtFieldCidadeFuncionarioEditar.setText(usuarioDTO.getEndereco().getCidade());
			this.txtFieldRuaFuncionarioEditar.setText(usuarioDTO.getEndereco().getRua());
			this.txtFieldCepFuncionarioEditar.setText(String.valueOf((usuarioDTO.getEndereco().getCep())));
			this.txtFieldComplementoFuncionarioEditar.setText(usuarioDTO.getEndereco().getComplemento());
			this.textFieldNFuncionarioEditar.setText(String.valueOf(usuarioDTO.getEndereco().getNumero()));
			this.txtFieldEstadoFuncionarioEditar.setText(usuarioDTO.getEndereco().getEstado());
			
		}
		public void populationUsuarioExcluir(UsuarioDTO usuarioDTO){
			//dados do usuario
			this.txtFieldFuncExcluir.setText(usuarioDTO.getNomeUsuario().toString());  
			this.rbtnFuncFuncExcluir.setSelected(!usuarioDTO.isGerente());
			this.rbtnGerenteFuncExcluir.setSelected(usuarioDTO.isGerente());
			this.txtFieldNDeUsuarioFuncExcluir.setText(usuarioDTO.getLogin().toString());
			this.textFieldTelefoneFuncExcluir.setText((usuarioDTO.getTelefoneUsuario()));
			this.passwordFieldSenhaFuncExcluir.setText(usuarioDTO.getSenha());
			this.passwordFieldConfASenhaFuncExcluir.setText(usuarioDTO.getSenha());
			//dados do endereço
			this.txtFieldBairroFuncExcluir.setText(usuarioDTO.getEndereco().getBairro());
			this.txtFieldCidadeFuncExcluir.setText(usuarioDTO.getEndereco().getCidade());
			this.txtFieldRuaFuncExcluir.setText(usuarioDTO.getEndereco().getRua());
			this.txtFieldCepFuncExcluir.setText(String.valueOf((usuarioDTO.getEndereco().getCep())));
			this.txtFieldComplFuncExcluir.setText(usuarioDTO.getEndereco().getComplemento());
			this.txtFieldNFuncExcluir.setText(String.valueOf(usuarioDTO.getEndereco().getNumero()));
			this.txtFieldEstadoFuncExcluir.setText(usuarioDTO.getEndereco().getEstado());
			
		}
		
		public void carregarCamposEditar (){
			String nomeComoboxEditar =  (String) comboBoxFuncionarioEditar.getSelectedItem().toString();
			UsuarioDTO usuarioEditar = null;
			try {
				usuarioEditar = usuarioLogic.getUsuario(nomeComoboxEditar);
			} catch (LogicException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			populationUsuarioEditar(usuarioEditar);
		}
		public void carregarCamposExcluir (){
			String nomeComoboxExcluir =  (String) comboBoxFuncExcluir.getSelectedItem().toString();
			UsuarioDTO usuarioExcluir = null;
			try {
				usuarioExcluir = usuarioLogic.getUsuario(nomeComoboxExcluir);
			} catch (LogicException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			populationUsuarioExcluir(usuarioExcluir);
		}
}
