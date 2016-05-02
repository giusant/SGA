package br.si.es.sga.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.si.es.sga.dao.AlunoDAO;
import br.si.es.sga.dao.EnderecoDAO;
import br.si.es.sga.dto.AlunoDTO;
import br.si.es.sga.dto.EnderecoDTO;
import br.si.es.sga.exeception.LogicException;
import br.si.es.sga.logic.AlunoLogic;
import br.si.es.sga.util.MessageUtil;

import javax.swing.ButtonGroup;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class CadastroAlunoUI extends JFrame {
	//private DateFormat dateFormtBD = new SimpleDateFormat("YYYY/MM/DD");
	private DateFormat dateFormtUI = new SimpleDateFormat("dd/MM/yyyy");
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
	private JTextField textFieldDataDeNasc;
	private JTextField textFieldNomeConsulta;
	private JTable table;
	private final ButtonGroup buttonGroupSexoCadastrar = new ButtonGroup();
	private ArrayList<Integer> idsAlunos= new ArrayList<Integer>(); 

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
		
		setTitle("Aluno");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		this.setSize(1200, 700);
		contentPane.setLayout(null);
		
	
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 1184, 661);
		contentPane.add(tabbedPane);
		
		JPanel PanelCadastrarAluno = new JPanel();
		tabbedPane.addTab("Cadastrar", null, PanelCadastrarAluno, null);
		PanelCadastrarAluno.setLayout(null);
		
		JPanel PanelEditarAluno = new JPanel();
		tabbedPane.addTab("Editar", null, PanelEditarAluno, null);
		PanelEditarAluno.setLayout(null);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(230, 134, 699, 2);
		PanelEditarAluno.add(separator_2);
		
		JLabel lblAlunoEditar = new JLabel("Aluno:");
		lblAlunoEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAlunoEditar.setBounds(230, 37, 88, 25);
		PanelEditarAluno.add(lblAlunoEditar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					preencheTabelaConsulta();
			}
			});
		btnPesquisar.setFont(new Font("Dialog", Font.BOLD, 18));
		btnPesquisar.setBounds(783, 73, 146, 32);
		PanelEditarAluno.add(btnPesquisar);
		
		textFieldNomeConsulta = new JTextField();
		textFieldNomeConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNomeConsulta.setBounds(230, 73, 541, 32);
		PanelEditarAluno.add(textFieldNomeConsulta);
		textFieldNomeConsulta.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(230, 169, 699, 368);
		PanelEditarAluno.add(scrollPane);
		
		table = new JTable();
		
		JButton btnEditarAlunoEditar = new JButton("Editar Aluno");
		btnEditarAlunoEditar.setEnabled(false);
		btnEditarAlunoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnEditarAlunoEditar){
					int idAluno = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
					OperacaoEditarAlunoUI editaralunooperacao = new OperacaoEditarAlunoUI();
					editaralunooperacao.editar(idAluno);
					editaralunooperacao.setVisible(true);
					
				}
			}
		});
		btnEditarAlunoEditar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEditarAlunoEditar.setBounds(493, 566, 206, 32);
		PanelEditarAluno.add(btnEditarAlunoEditar);
		
		table.setCellSelectionEnabled(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					if(table.getSelectedRow() >= 0 ){
						btnEditarAlunoEditar.setEnabled(true);	
					}
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane.setViewportView(table);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNome.setBounds(41, 59, 77, 25);
		PanelCadastrarAluno.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNome.setBounds(127, 59, 613, 26);
		PanelCadastrarAluno.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSexo.setBounds(41, 118, 77, 25);
		PanelCadastrarAluno.add(lblSexo);
		
		JRadioButton rdbtnM = new JRadioButton("M");
		buttonGroupSexoCadastrar.add(rdbtnM);
		rdbtnM.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnM.setBounds(159, 117, 52, 28);
		PanelCadastrarAluno.add(rdbtnM);
		
		JRadioButton rdbtnF = new JRadioButton("F");
		buttonGroupSexoCadastrar.add(rdbtnF);
		rdbtnF.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnF.setBounds(267, 117, 52, 28);
		PanelCadastrarAluno.add(rdbtnF);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEndereo.setBounds(41, 168, 101, 25);
		PanelCadastrarAluno.add(lblEndereo);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRua.setBounds(41, 215, 61, 19);
		PanelCadastrarAluno.add(lblRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(101, 212, 384, 26);
		PanelCadastrarAluno.add(textFieldRua);
		
		JLabel lblN = new JLabel("N\u00BA:");
		lblN.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblN.setBounds(502, 211, 46, 27);
		PanelCadastrarAluno.add(lblN);
		
		textFieldN = new JTextField();
		textFieldN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldN.setColumns(10);
		textFieldN.setBounds(550, 212, 127, 26);
		PanelCadastrarAluno.add(textFieldN);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBairro.setBounds(41, 268, 77, 25);
		PanelCadastrarAluno.add(lblBairro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(117, 268, 368, 26);
		PanelCadastrarAluno.add(textFieldBairro);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCep.setBounds(502, 268, 52, 25);
		PanelCadastrarAluno.add(lblCep);
		
		textFieldCep = new JTextField();
		textFieldCep.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCep.setColumns(10);
		textFieldCep.setBounds(550, 268, 127, 26);
		PanelCadastrarAluno.add(textFieldCep);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCidade.setBounds(41, 320, 77, 26);
		PanelCadastrarAluno.add(lblCidade);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(127, 320, 230, 26);
		PanelCadastrarAluno.add(textFieldCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEstado.setBounds(396, 321, 77, 25);
		PanelCadastrarAluno.add(lblEstado);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldEstado.setColumns(10);
		textFieldEstado.setBounds(482, 320, 194, 26);
		PanelCadastrarAluno.add(textFieldEstado);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComplemento.setBounds(41, 381, 154, 25);
		PanelCadastrarAluno.add(lblComplemento);
		
		textFieldComplemento = new JTextField();
		textFieldComplemento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldComplemento.setColumns(10);
		textFieldComplemento.setBounds(198, 380, 479, 26);
		PanelCadastrarAluno.add(textFieldComplemento);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTelefone.setBounds(41, 469, 101, 25);
		PanelCadastrarAluno.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(152, 469, 218, 26);
		PanelCadastrarAluno.add(textFieldTelefone);
		
		JLabel lblDataDNasc = new JLabel("Data de Nasc.:");
		lblDataDNasc.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDataDNasc.setBounds(396, 469, 180, 25);
		PanelCadastrarAluno.add(lblDataDNasc);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(41, 155, 699, 2);
		PanelCadastrarAluno.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(41, 434, 699, 2);
		PanelCadastrarAluno.add(separator_1);
		
		textFieldDataDeNasc = new JTextField();
		textFieldDataDeNasc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldDataDeNasc.setColumns(10);
		textFieldDataDeNasc.setBounds(550, 469, 162, 26);
		PanelCadastrarAluno.add(textFieldDataDeNasc);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlunoDTO alunoDTO = new AlunoDTO();
				AlunoLogic alunoLogic = new AlunoLogic();
				EnderecoDTO enderecoDTO = new EnderecoDTO();
				
				try {
				
					
				enderecoDTO.setBairro(textFieldBairro.getText());
				enderecoDTO.setCidade(textFieldCidade.getText());
				enderecoDTO.setRua(textFieldRua.getText());
				enderecoDTO.setCep(Integer.parseInt(textFieldCep.getText()));
				enderecoDTO.setComplemento(textFieldComplemento.getText());
				enderecoDTO.setNumero(Integer.parseInt(textFieldN.getText()));
				enderecoDTO.setEstado(textFieldEstado.getText());
				
				String sexo = rdbtnM.isSelected() ? "M" : "F";
					
				alunoDTO.setNomeAluno(textFieldNome.getText());
				alunoDTO.setDataNasc(dateFormtUI.parse((textFieldDataDeNasc.getText())));
				alunoDTO.setDataMatricula(( new java.util.Date()));
				alunoDTO.setTelefoneAluno(textFieldTelefone.getText());
				alunoDTO.setIdEndereco(enderecoDTO);
				alunoDTO.setSexo(sexo.toUpperCase());
				
				alunoLogic.cadastrar(alunoDTO);
				MessageUtil.addMsg(CadastroAlunoUI.this, "Cadastrado com sucesso");
				
				CadastroAlunoUI.this.dispose();
				main(null);			
				
				
				} catch (LogicException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalvar.setBounds(211, 561, 111, 31);
		PanelCadastrarAluno.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Limpar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Endereço
				textFieldBairro.setText("");
				textFieldCidade.setText("");
				textFieldRua.setText("");
				textFieldCep.setText("");
				textFieldComplemento.setText("");
				textFieldN.setText("");
				textFieldEstado.setText("");
				//aluno
				textFieldNome.setText("");;
				textFieldDataDeNasc.setText("");
				textFieldTelefone.setText("");
				rdbtnM.setSelected(true);
				
				
				
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelar.setBounds(379, 561, 127, 31);
		PanelCadastrarAluno.add(btnCancelar);
		
		JButton btnTirarFoto = new JButton("Tirar foto");
		btnTirarFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTirarFoto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTirarFoto.setBounds(899, 359, 127, 23);
		PanelCadastrarAluno.add(btnTirarFoto);
		
		JLabel lblFoto = new JLabel("Foto");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setBounds(852, 79, 213, 251);
		PanelCadastrarAluno.add(lblFoto);
		this.setLocationRelativeTo(null);
		
		
		//Preencher a tabela consulta
		preencheTabelaConsulta();
		}
	
	public void preencheTabelaConsulta(){
		if(textFieldNomeConsulta.getText().equals("") || textFieldNomeConsulta ==  null ){
			String nome = textFieldNomeConsulta.getText();
			
			AlunoLogic alunoLogic = new AlunoLogic();
			try {
				String [][] lista = alunoLogic.Listagem(idsAlunos);
				table.setModel(new DefaultTableModel(
						lista,
						new String[] {
								"Número de Identificação","Nome"
						}
						));
			} catch (Exception e) {
				e.printStackTrace();
				MessageUtil.addMsg(CadastroAlunoUI.this, e.getMessage());
			}
		}else{
			String nome = textFieldNomeConsulta.getText();
			
			AlunoLogic alunoLogic = new AlunoLogic();
			try {
				String [][] lista = alunoLogic.ListagemPorNome(idsAlunos, nome);
				table.setModel(new DefaultTableModel(
						lista,
						new String[] {
								"Número de Identificação","Nome"
						}
						));
			} catch (Exception e) {
				e.printStackTrace();
				MessageUtil.addMsg(CadastroAlunoUI.this, e.getMessage());
			}
		}
		
	}
	public void atualizar(){
		CadastroAlunoUI.this.dispose();
		//main(null);
	}
	
	}

