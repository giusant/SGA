package br.si.es.sga.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

import java.awt.Color;

import javax.swing.JTable;

import br.si.es.sga.dto.ModalidadeDTO;
import br.si.es.sga.exeception.LogicException;
import br.si.es.sga.logic.ModalidadeLogic;
import br.si.es.sga.util.MessageUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.border.LineBorder;

public class CadastroModalidadeUI extends JFrame {
	ModalidadeLogic modalidadeLogic = new ModalidadeLogic();
	private JPanel contentPane;
	JTextField textFieldNome = new JTextField();
	private JTextField textFieldNomeCadastrar;
	JTextField textFieldValorCadastrar = new JTextField();
	private JTextField textFieldNomeEditar;
	private JTextField textFieldValorEditar;
	private JTextField textFieldModalidadeExcluir;
	private JTextField textFieldValorExcluir;
	JComboBox comboBoxModalidadeCadastrar;
	JComboBox comboBoxModalidadeEditar;
	JComboBox comboBoxModalidadesExcluir;
	JTextArea textAreaDescricaoEditar;
	JTextArea textAreaDescricaoExcluir;
	int idModalidade;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setSize(800, 500);		//tamanho da tela
		this.setLocationRelativeTo(null);	//situa a tela no centro
		contentPane.setLayout(null);
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(224, 255, 255));
		tabbedPane.setBounds(5, 5, 784, 461);
		contentPane.add(tabbedPane);
		
		JPanel BtnSalvarCadastrar = new JPanel();
		BtnSalvarCadastrar.setBackground(new Color(224, 255, 255));
		tabbedPane.addTab("Cadastrar", null, BtnSalvarCadastrar, null);
		
		JPanel Editar = new JPanel();
		Editar.setBackground(new Color(224, 255, 255));
		tabbedPane.addTab("Editar", null, Editar, null);
		Editar.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setLayout(null);
		panel.setBounds(0, 0, 779, 433);
		Editar.add(panel);
		
		JLabel lblModalidadesEditar = new JLabel("Modalidades:");
		lblModalidadesEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblModalidadesEditar.setBounds(35, 37, 150, 25);
		panel.add(lblModalidadesEditar);
		
		
		
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
		
		textAreaDescricaoEditar = new JTextArea();
		textAreaDescricaoEditar.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaDescricaoEditar.setForeground(new Color(0, 0, 128));
		textAreaDescricaoEditar.setLineWrap(true);
		textAreaDescricaoEditar.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textAreaDescricaoEditar.setBackground(Color.WHITE);
		textAreaDescricaoEditar.setBounds(150, 277, 300, 145);
		panel.add(textAreaDescricaoEditar);
		
		JButton btnSalvarModalidadeEditar = new JButton("Salvar");
		btnSalvarModalidadeEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModalidadeDTO modalidadeDTO = new ModalidadeDTO();
				ModalidadeLogic modalidadeLogic = new ModalidadeLogic();
				try {
					modalidadeDTO.setIdModalidade(recuperarIDCamposEditar());
					modalidadeDTO.setNomeModalidade(textFieldNomeEditar.getText());
					modalidadeDTO.setValor(Double.parseDouble(textFieldValorEditar.getText()));
					modalidadeDTO.setDescrição(textAreaDescricaoEditar.getText());
					modalidadeLogic.ataulizar(modalidadeDTO);
					MessageUtil.addMsg(CadastroModalidadeUI.this, "Salvo com Sucesso!");
					CadastroModalidadeUI.this.dispose();
					main(null);
				} catch (LogicException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnSalvarModalidadeEditar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalvarModalidadeEditar.setBounds(501, 316, 127, 31);
		panel.add(btnSalvarModalidadeEditar);
		
		JButton btnCancelarModalidadeEditar = new JButton("Limpar");
		btnCancelarModalidadeEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNomeEditar.setText("");
				textFieldValorEditar.setText("");
				textAreaDescricaoEditar.setText("");
				
			}
		});
		btnCancelarModalidadeEditar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelarModalidadeEditar.setBounds(501, 358, 127, 31);
		panel.add(btnCancelarModalidadeEditar);
		
		JPanel Excluir = new JPanel();
		Excluir.setBackground(new Color(224, 255, 255));
		tabbedPane.addTab("Excluir", null, Excluir, null);
		Excluir.setLayout(null);
		
		JButton btnExcluirModalidade = new JButton("Excluir");
		btnExcluirModalidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModalidadeDTO modalidadeDTO = new ModalidadeDTO();
				ModalidadeLogic modalidadeLogic = new ModalidadeLogic();
				try {
					modalidadeDTO.setIdModalidade(recuperarIDCamposExcluir());
					modalidadeLogic.removerModalidade(modalidadeDTO.getIdModalidade());
					MessageUtil.addMsg(CadastroModalidadeUI.this, "Excluído com Sucesso!");
					CadastroModalidadeUI.this.dispose();
					main(null);
				} catch (LogicException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnExcluirModalidade.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExcluirModalidade.setBounds(526, 315, 129, 29);
		Excluir.add(btnExcluirModalidade);
		
		
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
		textFieldModalidadeExcluir.setEnabled(false);
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
		textFieldValorExcluir.setEnabled(false);
		textFieldValorExcluir.setText("");
		textFieldValorExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldValorExcluir.setColumns(10);
		textFieldValorExcluir.setBounds(93, 197, 156, 28);
		Excluir.add(textFieldValorExcluir);
		
		textAreaDescricaoExcluir = new JTextArea();
		textAreaDescricaoExcluir.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaDescricaoExcluir.setEnabled(false);
		textAreaDescricaoExcluir.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textAreaDescricaoExcluir.setBackground(Color.WHITE);
		textAreaDescricaoExcluir.setBounds(133, 265, 300, 145);
		Excluir.add(textAreaDescricaoExcluir);
		
		JLabel lblDescricaoModalidadeExcluir = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricaoModalidadeExcluir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDescricaoModalidadeExcluir.setBounds(18, 264, 105, 25);
		Excluir.add(lblDescricaoModalidadeExcluir);
		
		JButton btnSelecionarExcluir = new JButton("Selecionar");
		btnSelecionarExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarCamposExcluir();
				
			}
		});
		btnSelecionarExcluir.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSelecionarExcluir.setBounds(566, 26, 129, 29);
		Excluir.add(btnSelecionarExcluir);
		
		JLabel lblModalidadesCadastrar = new JLabel("Modalidades existentes:");
		lblModalidadesCadastrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblModalidadesCadastrar.setBounds(35, 37, 257, 25);
		BtnSalvarCadastrar.add(lblModalidadesCadastrar);
				
		JSeparator separator = new JSeparator();
		separator.setBounds(35, 95, 637, 2);
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
		textAreaDescricaoCadastrar.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaDescricaoCadastrar.setBackground(SystemColor.text);
		textAreaDescricaoCadastrar.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textAreaDescricaoCadastrar.setBounds(150, 277, 300, 145);
		BtnSalvarCadastrar.add(textAreaDescricaoCadastrar);
		// codigo que converte o atributo para uma combobox cadastrar
		try{

			ComboBoxModel comboModalidadeModel;
			comboModalidadeModel = new DefaultComboBoxModel(converteModalidade(modalidadeLogic.listarModalidade()));
			comboBoxModalidadeCadastrar = new JComboBox();
			comboBoxModalidadeCadastrar.setModel(comboModalidadeModel);
		}catch(LogicException e){
			e.printStackTrace();
			//MessagensUtil.addMsg(MainFrame.this, e.getMessage());
		}

		comboBoxModalidadeCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxModalidadeCadastrar.setBounds(288, 38, 377, 25);
		BtnSalvarCadastrar.add(comboBoxModalidadeCadastrar);
		BtnSalvarCadastrar.setLayout(null);

		// codigo que converte o atributo para uma combobox editar
		try{

			ComboBoxModel comboModalidadeModel;
			comboModalidadeModel = new DefaultComboBoxModel(converteModalidade(modalidadeLogic.listarModalidade()));
			comboBoxModalidadeEditar = new JComboBox();
			comboBoxModalidadeEditar.setModel(comboModalidadeModel);
		}catch(LogicException e){
			e.printStackTrace();
			//MessagensUtil.addMsg(MainFrame.this, e.getMessage());
		}
		
		comboBoxModalidadeEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxModalidadeEditar.setBounds(178, 38, 394, 25);
		panel.add(comboBoxModalidadeEditar);
		
		// codigo que converte o atributo para uma combobox excluir
		try{

			ComboBoxModel comboModalidadeModel;
			  ModalidadeDTO[] test = converte(modalidadeLogic.listarModalidade());
			comboModalidadeModel = new DefaultComboBoxModel(converteModalidade(modalidadeLogic.listarModalidade()));
			comboBoxModalidadesExcluir = new JComboBox();
			comboBoxModalidadesExcluir.setModel(comboModalidadeModel);
		}catch(LogicException e){
			e.printStackTrace();
			//MessagensUtil.addMsg(MainFrame.this, e.getMessage());
		}

		comboBoxModalidadesExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxModalidadesExcluir.setBounds(161, 26, 394, 25);
		Excluir.add(comboBoxModalidadesExcluir);

		JButton btnSelecionarEditar = new JButton("Selecionar");
		btnSelecionarEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carregarCamposEditar();
			}
		});
		btnSelecionarEditar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSelecionarEditar.setBounds(588, 37, 150, 25);
		panel.add(btnSelecionarEditar);
		
		
		
		
		JButton btnSalvarModalidadeCadastrar = new JButton("Salvar");
		btnSalvarModalidadeCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModalidadeDTO modalidadeDTO = new ModalidadeDTO();
				ModalidadeLogic modalidadeLogic = new ModalidadeLogic();
				try {
					
					modalidadeDTO.setNomeModalidade(textFieldNomeCadastrar.getText());
					modalidadeDTO.setValor(Double.parseDouble(textFieldValorCadastrar.getText()));
					modalidadeDTO.setDescrição(textAreaDescricaoCadastrar.getText());
					modalidadeLogic.cadastrar(modalidadeDTO);
					MessageUtil.addMsg(CadastroModalidadeUI.this, "Salvo com Sucesso!");
					CadastroModalidadeUI.this.dispose();
					main(null);
				} catch (LogicException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSalvarModalidadeCadastrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalvarModalidadeCadastrar.setBounds(501, 315, 127, 31);
		BtnSalvarCadastrar.add(btnSalvarModalidadeCadastrar);
		
		JButton btnCancelarModalidadeCadastrar = new JButton("Limpar");
		btnCancelarModalidadeCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldNome.setText("");
				textFieldValorCadastrar.setText("");
				textAreaDescricaoCadastrar.setText("");
				
				
			}
		});
		btnCancelarModalidadeCadastrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelarModalidadeCadastrar.setBounds(501, 358, 127, 31);
		BtnSalvarCadastrar.add(btnCancelarModalidadeCadastrar);
		
		//carregarCamposEditar();
		//carregarCamposExcluir();
	}
	
	public String[] converteModalidade(List<ModalidadeDTO> listarModalidade) {
		String[] result = new String[listarModalidade.size()];
		for(int i = 0; i < listarModalidade.size();i++){
			ModalidadeDTO modalidadeDTO = listarModalidade.get(i);
			result[i] =  modalidadeDTO.getNomeModalidade();

		}
		return result;
	}
	public ModalidadeDTO[] converte(List<ModalidadeDTO> listarModalidade) {
		ModalidadeDTO[] result = new ModalidadeDTO[listarModalidade.size()];
		for(int i = 0; i < listarModalidade.size();i++){
			ModalidadeDTO modalidadeDTO = listarModalidade.get(i);
			result[i] =  modalidadeDTO;

		}
		return result;
	}
	
	public void populationModalidadeEditar(ModalidadeDTO modalidadeDTO){
		this.idModalidade = modalidadeDTO.getIdModalidade();  
		this.textFieldNomeEditar.setText(modalidadeDTO.getNomeModalidade().toString());
		this.textFieldValorEditar.setText(String.valueOf(modalidadeDTO.getValor()));
		this.textAreaDescricaoEditar.setText(modalidadeDTO.getDescrição());
		
	}
	public void populationModalidadeExcluir(ModalidadeDTO modalidadeDTO){
		this.idModalidade = modalidadeDTO.getIdModalidade();  
		this.textFieldModalidadeExcluir.setText(modalidadeDTO.getNomeModalidade().toString());
		this.textFieldValorExcluir.setText(String.valueOf(modalidadeDTO.getValor()));
		this.textAreaDescricaoExcluir.setText(modalidadeDTO.getDescrição());
		
	}
	//Codigo que pega o valor da comoboxEditar
	public void carregarCamposEditar (){
	String nomeComoboxEditar =  (String) comboBoxModalidadeEditar.getSelectedItem().toString();
	ModalidadeDTO modalidadeEditar = null;
	try {
		 modalidadeEditar = modalidadeLogic.getModalidade(nomeComoboxEditar);
	} catch (LogicException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	populationModalidadeEditar(modalidadeEditar);
	}

	//Codigo que pega o valor da comoboxExcluir
	public void carregarCamposExcluir (){
		String nomeComoboxExcluir =  (String) comboBoxModalidadesExcluir.getSelectedItem().toString();
		ModalidadeDTO modalidadeEditar = null;
		try {
			modalidadeEditar = modalidadeLogic.getModalidade(nomeComoboxExcluir);
		} catch (LogicException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		populationModalidadeExcluir(modalidadeEditar);
	}

	//Recupera o id do objeto da comobox 
	public int recuperarIDCamposEditar (){
		ModalidadeDTO modalidadeEditar = null;
		String nomeComoboxEditar =  (String) comboBoxModalidadeEditar.getSelectedItem().toString();
		try {
		ModalidadeDTO[] test = converte(modalidadeLogic.listarModalidade());
	
		if(nomeComoboxEditar.equals(test[ comboBoxModalidadeEditar.getSelectedIndex()].getNomeModalidade()) ){
		 modalidadeEditar = modalidadeLogic.getModalidade(nomeComoboxEditar);
		}
		
			//modalidadeEditar = modalidadeLogic.getModalidade(nomeComoboxEditar);
		} catch (LogicException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return modalidadeEditar.getIdModalidade();
	}
	//Recupera o id do objeto da comobox 
		public int recuperarIDCamposExcluir (){
			String nomeComoboxExcluir =  (String) comboBoxModalidadesExcluir.getSelectedItem().toString();
			ModalidadeDTO modalidadeExcluir = null;
			try {
				modalidadeExcluir = modalidadeLogic.getModalidade(nomeComoboxExcluir);
			} catch (LogicException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return modalidadeExcluir.getIdModalidade();
		}
}