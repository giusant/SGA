package br.si.es.sga.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.SystemColor;

public class CadastroModalidadeUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroModalidadeUI frame = new CadastroModalidadeUI();
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
	public CadastroModalidadeUI() {
		setTitle("Cadastro de Modalidade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModalidades = new JLabel("Modalidades:");
		lblModalidades.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblModalidades.setBounds(35, 37, 150, 25);
		contentPane.add(lblModalidades);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(178, 38, 394, 25);
		contentPane.add(comboBox);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(35, 99, 664, 2);
		contentPane.add(separator);
		
		JLabel lblNovaModalidade = new JLabel("Nova Modalidade:");
		lblNovaModalidade.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNovaModalidade.setBounds(35, 120, 196, 25);
		contentPane.add(lblNovaModalidade);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNome.setBounds(35, 171, 75, 25);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setText("");
		textField.setBounds(117, 171, 400, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblValor.setBounds(35, 247, 75, 25);
		contentPane.add(lblValor);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setText("");
		textField_1.setColumns(10);
		textField_1.setBounds(117, 247, 196, 25);
		contentPane.add(textField_1);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDescrio.setBounds(35, 321, 116, 25);
		contentPane.add(lblDescrio);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.text);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setBounds(161, 325, 355, 123);
		contentPane.add(textArea);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalvar.setBounds(592, 361, 133, 31);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelar.setBounds(592, 417, 133, 31);
		contentPane.add(btnCancelar);
		this.setSize(800, 500);		//tamanho da tela
		this.setLocationRelativeTo(null);	//situa a tela no centro
		this.setResizable(false);    //desabilita a fução maximizar e deixa o tamanho da tela fixa
	}
}
