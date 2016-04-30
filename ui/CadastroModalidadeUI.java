package br.si.es.sga.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTable;

public class CadastroModalidadeUI extends JFrame {

	private JPanel contentPane;
	JTextField textFieldNome = new JTextField();
	private JTextField textFieldNomeCadastrar;
	JTextField textFieldValorCadastrar = new JTextField();
	private JTextField textFieldNomeEditar;
	private JTextField textFieldValorEditar;
	private JTextField textFieldModalidadeExcluir;
	private JTextField textFieldValorExcluir;

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
		setResizable(false);
		setTitle("Cadastro de Modalidade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setSize(800, 500);		//tamanho da tela
		this.setLocationRelativeTo(null);	//situa a tela no centro
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 784, 461);
		contentPane.add(tabbedPane);
		
		JPanel BtnSalvarCadastrar = new JPanel();
		tabbedPane.addTab("Cadastrar", null, BtnSalvarCadastrar, null);
		
		JPanel Editar = new JPanel();
		tabbedPane.addTab("Editar", null, Editar, null);
		Editar.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 779, 433);
		Editar.add(panel);
		
		JLabel lblModalidadesEditar = new JLabel("Modalidades:");
		lblModalidadesEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblModalidadesEditar.setBounds(35, 37, 150, 25);
		panel.add(lblModalidadesEditar);
		
		JComboBox comboBoxModalidadeEditar = new JComboBox();
		comboBoxModalidadeEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxModalidadeEditar.setBounds(178, 38, 394, 25);
		panel.add(comboBoxModalidadeEditar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(35, 108, 637, 2);
		panel.add(separator_1);
		
		JLabel lblNomeEditar = new JLabel("Nome:");
		lblNomeEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNomeEditar.setBounds(35, 155, 65, 25);
		panel.add(lblNomeEditar);
		
		textFieldNomeEditar = new JTextField();
		textFieldNomeEditar.setText("");
		textFieldNomeEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNomeEditar.setColumns(10);
		textFieldNomeEditar.setBounds(110, 154, 250, 28);
		panel.add(textFieldNomeEditar);
		
		JLabel lblValorEditar = new JLabel("Valor:");
		lblValorEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblValorEditar.setBounds(35, 210, 60, 25);
		panel.add(lblValorEditar);
		
		textFieldValorEditar = new JTextField();
		textFieldValorEditar.setText("");
		textFieldValorEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldValorEditar.setColumns(10);
		textFieldValorEditar.setBounds(110, 209, 156, 28);
		panel.add(textFieldValorEditar);
		
		JLabel lblDescricaoEditar = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricaoEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDescricaoEditar.setBounds(35, 276, 105, 25);
		panel.add(lblDescricaoEditar);
		
		JTextArea textAreaDescricaoEditar = new JTextArea();
		textAreaDescricaoEditar.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textAreaDescricaoEditar.setBackground(Color.WHITE);
		textAreaDescricaoEditar.setBounds(150, 277, 300, 145);
		panel.add(textAreaDescricaoEditar);
		
		JButton btnSalvarModalidadeEditar = new JButton("Salvar");
		btnSalvarModalidadeEditar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalvarModalidadeEditar.setBounds(501, 302, 127, 31);
		panel.add(btnSalvarModalidadeEditar);
		
		JButton btnCancelarModalidadeEditar = new JButton("Cancelar");
		btnCancelarModalidadeEditar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelarModalidadeEditar.setBounds(501, 358, 127, 31);
		panel.add(btnCancelarModalidadeEditar);
		
		JPanel Excluir = new JPanel();
		tabbedPane.addTab("Excluir", null, Excluir, null);
		Excluir.setLayout(null);
		
		JButton btnExcluirModalidade = new JButton("Excluir");
		btnExcluirModalidade.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExcluirModalidade.setBounds(526, 315, 129, 29);
		Excluir.add(btnExcluirModalidade);
		
		JComboBox comboBoxModalidadesExcluir = new JComboBox();
		comboBoxModalidadesExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxModalidadesExcluir.setBounds(161, 26, 394, 25);
		Excluir.add(comboBoxModalidadesExcluir);
		
		JLabel lblModalidadesExcluir = new JLabel("Modalidades:");
		lblModalidadesExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblModalidadesExcluir.setBounds(18, 25, 150, 25);
		Excluir.add(lblModalidadesExcluir);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(18, 96, 637, 2);
		Excluir.add(separator_2);
		
		JLabel lblNomeModalidadeExluir = new JLabel("Nome:");
		lblNomeModalidadeExluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNomeModalidadeExluir.setBounds(18, 143, 65, 25);
		Excluir.add(lblNomeModalidadeExluir);
		
		textFieldModalidadeExcluir = new JTextField();
		textFieldModalidadeExcluir.setText("");
		textFieldModalidadeExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldModalidadeExcluir.setColumns(10);
		textFieldModalidadeExcluir.setBounds(93, 142, 250, 28);
		Excluir.add(textFieldModalidadeExcluir);
		
		JLabel lblValorExcluir = new JLabel("Valor:");
		lblValorExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblValorExcluir.setBounds(18, 198, 60, 25);
		Excluir.add(lblValorExcluir);
		
		textFieldValorExcluir = new JTextField();
		textFieldValorExcluir.setText("");
		textFieldValorExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldValorExcluir.setColumns(10);
		textFieldValorExcluir.setBounds(93, 197, 156, 28);
		Excluir.add(textFieldValorExcluir);
		
		JTextArea textAreaDescricaoExcluir = new JTextArea();
		textAreaDescricaoExcluir.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textAreaDescricaoExcluir.setBackground(Color.WHITE);
		textAreaDescricaoExcluir.setBounds(133, 265, 300, 145);
		Excluir.add(textAreaDescricaoExcluir);
		
		JLabel lblDescricaoModalidadeExcluir = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricaoModalidadeExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDescricaoModalidadeExcluir.setBounds(18, 264, 105, 25);
		Excluir.add(lblDescricaoModalidadeExcluir);
		
		JLabel lblModalidadesCadastrar = new JLabel("Modalidades:");
		lblModalidadesCadastrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblModalidadesCadastrar.setBounds(35, 37, 150, 25);
		BtnSalvarCadastrar.add(lblModalidadesCadastrar);
		
		JComboBox comboBoxModalidadeCadastrar = new JComboBox();
		comboBoxModalidadeCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxModalidadeCadastrar.setBounds(178, 38, 394, 25);
		BtnSalvarCadastrar.add(comboBoxModalidadeCadastrar);
		BtnSalvarCadastrar.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(35, 82, 637, 2);
		BtnSalvarCadastrar.add(separator);
		
		JLabel lblNovaModalidadeCadastrar = new JLabel("Nova Modalidade:");
		lblNovaModalidadeCadastrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNovaModalidadeCadastrar.setBounds(35, 95, 181, 25);
		BtnSalvarCadastrar.add(lblNovaModalidadeCadastrar);
		
		JLabel lblNomeCadastrar = new JLabel("Nome:");
		lblNomeCadastrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNomeCadastrar.setBounds(35, 155, 65, 25);
		BtnSalvarCadastrar.add(lblNomeCadastrar);
		
		textFieldNomeCadastrar = new JTextField();
		textFieldNomeCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNomeCadastrar.setText("");
		textFieldNomeCadastrar.setBounds(110, 154, 250, 28);
		BtnSalvarCadastrar.add(textFieldNomeCadastrar);
		textFieldNomeCadastrar.setColumns(10);
		
		JLabel lblValorCadastrar = new JLabel("Valor:");
		lblValorCadastrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblValorCadastrar.setBounds(35, 210, 60, 25);
		BtnSalvarCadastrar.add(lblValorCadastrar);
		
		
		textFieldValorCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldValorCadastrar.setText("");
		textFieldValorCadastrar.setColumns(10);
		textFieldValorCadastrar.setBounds(110, 209, 156, 28);
		BtnSalvarCadastrar.add(textFieldValorCadastrar);
		
		JLabel lblDescricaoCadastrar = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricaoCadastrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDescricaoCadastrar.setBounds(35, 276, 105, 25);
		BtnSalvarCadastrar.add(lblDescricaoCadastrar);
		
		JTextArea textAreaDescricaoCadastrar = new JTextArea();
		textAreaDescricaoCadastrar.setBackground(SystemColor.text);
		textAreaDescricaoCadastrar.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textAreaDescricaoCadastrar.setBounds(150, 277, 300, 145);
		BtnSalvarCadastrar.add(textAreaDescricaoCadastrar);
		
		JButton btnSalvarModalidadeCadastrar = new JButton("Salvar");
		btnSalvarModalidadeCadastrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalvarModalidadeCadastrar.setBounds(501, 302, 127, 31);
		BtnSalvarCadastrar.add(btnSalvarModalidadeCadastrar);
		
		JButton btnCancelarModalidadeCadastrar = new JButton("Cancelar");
		btnCancelarModalidadeCadastrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelarModalidadeCadastrar.setBounds(501, 358, 127, 31);
		BtnSalvarCadastrar.add(btnCancelarModalidadeCadastrar);
	}

}
