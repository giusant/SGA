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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_10;

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
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(127, 59, 613, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblModalidade = new JLabel("Sexo:");
		lblModalidade.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblModalidade.setBounds(41, 118, 77, 25);
		contentPane.add(lblModalidade);
		
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
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(101, 212, 384, 26);
		contentPane.add(textField_1);
		
		JLabel lblN = new JLabel("N\u00BA:");
		lblN.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblN.setBounds(502, 211, 46, 27);
		contentPane.add(lblN);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(550, 212, 127, 26);
		contentPane.add(textField_2);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBairro.setBounds(41, 268, 77, 25);
		contentPane.add(lblBairro);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(117, 268, 368, 26);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel = new JLabel("CEP:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(502, 268, 52, 25);
		contentPane.add(lblNewLabel);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(550, 268, 127, 26);
		contentPane.add(textField_4);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCidade.setBounds(41, 320, 77, 26);
		contentPane.add(lblCidade);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(127, 320, 230, 26);
		contentPane.add(textField_5);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEstado.setBounds(396, 321, 77, 25);
		contentPane.add(lblEstado);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(482, 320, 194, 26);
		contentPane.add(textField_6);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComplemento.setBounds(41, 381, 154, 25);
		contentPane.add(lblComplemento);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_7.setColumns(10);
		textField_7.setBounds(198, 380, 479, 26);
		contentPane.add(textField_7);
		
		JLabel lblContato = new JLabel("Telefone:");
		lblContato.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblContato.setBounds(41, 469, 101, 25);
		contentPane.add(lblContato);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_8.setColumns(10);
		textField_8.setBounds(152, 469, 218, 26);
		contentPane.add(textField_8);
		
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
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_10.setColumns(10);
		textField_10.setBounds(585, 469, 127, 26);
		contentPane.add(textField_10);
		
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
