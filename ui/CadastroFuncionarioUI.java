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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

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
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(117, 64, 504, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnGerente = new JRadioButton("Gerente");
		rdbtnGerente.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnGerente.setBounds(314, 125, 109, 23);
		contentPane.add(rdbtnGerente);
		
		JRadioButton rdbtnFuncionrio = new JRadioButton("Funcion\u00E1rio");
		rdbtnFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnFuncionrio.setBounds(314, 176, 145, 23);
		contentPane.add(rdbtnFuncionrio);
		
		JLabel lblTipoDeUsurio = new JLabel("Tipo de Usu\u00E1rio:");
		lblTipoDeUsurio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTipoDeUsurio.setBounds(46, 145, 177, 31);
		contentPane.add(lblTipoDeUsurio);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEndereo.setBounds(46, 235, 99, 23);
		contentPane.add(lblEndereo);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRua.setBounds(46, 292, 63, 25);
		contentPane.add(lblRua);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(107, 292, 338, 25);
		contentPane.add(textField_1);
		
		JLabel lblN = new JLabel("N\u00BA:");
		lblN.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblN.setBounds(465, 292, 63, 25);
		contentPane.add(lblN);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(505, 292, 135, 25);
		contentPane.add(textField_2);
		
		JLabel label = new JLabel("Bairro:");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(46, 351, 77, 25);
		contentPane.add(label);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(129, 351, 313, 26);
		contentPane.add(textField_3);
		
		JLabel label_1 = new JLabel("CEP:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(465, 350, 52, 25);
		contentPane.add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(513, 350, 127, 26);
		contentPane.add(textField_4);
		
		JLabel label_2 = new JLabel("Cidade:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(46, 404, 77, 26);
		contentPane.add(label_2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(132, 404, 230, 26);
		contentPane.add(textField_5);
		
		JLabel label_3 = new JLabel("Estado:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(401, 405, 77, 25);
		contentPane.add(label_3);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(487, 404, 156, 26);
		contentPane.add(textField_6);
		
		JLabel label_4 = new JLabel("Complemento:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBounds(46, 455, 600, 25);
		contentPane.add(label_4);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_7.setColumns(10);
		textField_7.setBounds(203, 454, 443, 26);
		contentPane.add(textField_7);
		
		JLabel lblNomeDeUsurio = new JLabel("Nome de Usu\u00E1rio: ");
		lblNomeDeUsurio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNomeDeUsurio.setBounds(46, 517, 185, 26);
		contentPane.add(lblNomeDeUsurio);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_8.setColumns(10);
		textField_8.setBounds(241, 518, 230, 26);
		contentPane.add(textField_8);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSenha.setBounds(46, 554, 86, 26);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(241, 555, 230, 25);
		contentPane.add(passwordField);
		
		JLabel lblConfirmeASenha = new JLabel("Confirme a senha:");
		lblConfirmeASenha.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfirmeASenha.setBounds(46, 592, 185, 26);
		contentPane.add(lblConfirmeASenha);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(241, 593, 230, 25);
		contentPane.add(passwordField_1);
		
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
