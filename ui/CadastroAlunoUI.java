package br.si.es.sga.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSpinner;
import javax.swing.JRadioButton;

import java.awt.Component;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class CadastroAlunoUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldRua;
	private JTextField textFieldN;
	private JTextField textFieldBairro;
	private JTextField textFieldCep;
	private JTextField textFieldCidade;
	private JTextField textFieldEstado;
	private JTextField textFieldComplemento;
	private JTextField textFieldTelefone;
	private JTextField textFieldDataDeEntrada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAlunoUI frame = new CadastroAlunoUI();
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
	public CadastroAlunoUI() {
		setResizable(false);
		setTitle("Cadastro de Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 376);
		this.setSize(1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNome.setBounds(41, 59, 77, 25);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNome.setBounds(127, 59, 613, 26);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSexo.setBounds(41, 118, 77, 25);
		contentPane.add(lblSexo);
		
		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnM.setBounds(159, 117, 52, 28);
		contentPane.add(rdbtnM);
		
		JRadioButton rdbtnF = new JRadioButton("F");
		rdbtnF.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnF.setBounds(267, 117, 52, 28);
		contentPane.add(rdbtnF);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEndereo.setBounds(41, 168, 101, 25);
		contentPane.add(lblEndereo);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRua.setBounds(41, 215, 61, 19);
		contentPane.add(lblRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(101, 212, 384, 26);
		contentPane.add(textFieldRua);
		
		JLabel lblN = new JLabel("N\u00BA:");
		lblN.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblN.setBounds(502, 211, 46, 27);
		contentPane.add(lblN);
		
		textFieldN = new JTextField();
		textFieldN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldN.setColumns(10);
		textFieldN.setBounds(550, 212, 127, 26);
		contentPane.add(textFieldN);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBairro.setBounds(41, 268, 77, 25);
		contentPane.add(lblBairro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(117, 268, 368, 26);
		contentPane.add(textFieldBairro);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCep.setBounds(502, 268, 52, 25);
		contentPane.add(lblCep);
		
		textFieldCep = new JTextField();
		textFieldCep.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCep.setColumns(10);
		textFieldCep.setBounds(550, 268, 127, 26);
		contentPane.add(textFieldCep);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCidade.setBounds(41, 320, 77, 26);
		contentPane.add(lblCidade);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(127, 320, 230, 26);
		contentPane.add(textFieldCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEstado.setBounds(396, 321, 77, 25);
		contentPane.add(lblEstado);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldEstado.setColumns(10);
		textFieldEstado.setBounds(482, 320, 194, 26);
		contentPane.add(textFieldEstado);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComplemento.setBounds(41, 381, 154, 25);
		contentPane.add(lblComplemento);
		
		textFieldComplemento = new JTextField();
		textFieldComplemento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldComplemento.setColumns(10);
		textFieldComplemento.setBounds(198, 380, 479, 26);
		contentPane.add(textFieldComplemento);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTelefone.setBounds(41, 469, 101, 25);
		contentPane.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(152, 469, 218, 26);
		contentPane.add(textFieldTelefone);
		
		JLabel lblDataDeEntrada = new JLabel("Data de Entrada:");
		lblDataDeEntrada.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDataDeEntrada.setBounds(396, 469, 180, 25);
		contentPane.add(lblDataDeEntrada);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(41, 155, 699, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(41, 434, 699, 2);
		contentPane.add(separator_1);
		
		textFieldDataDeEntrada = new JTextField();
		textFieldDataDeEntrada.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldDataDeEntrada.setColumns(10);
		textFieldDataDeEntrada.setBounds(585, 469, 127, 26);
		contentPane.add(textFieldDataDeEntrada);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalvar.setBounds(211, 561, 111, 31);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelar.setBounds(379, 561, 127, 31);
		contentPane.add(btnCancelar);
		
		JButton btnTirarFoto = new JButton("Tirar foto");
		btnTirarFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTirarFoto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTirarFoto.setBounds(899, 359, 127, 23);
		contentPane.add(btnTirarFoto);
		
		JLabel lblFoto = new JLabel("Foto");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setBounds(852, 79, 213, 251);
		contentPane.add(lblFoto);
		this.setLocationRelativeTo(null);
		
	}
}
